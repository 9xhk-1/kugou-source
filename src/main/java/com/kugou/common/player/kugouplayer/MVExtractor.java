package com.kugou.common.player.kugouplayer;

import android.annotation.SuppressLint;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import e.c.e.b.b.b;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class MVExtractor {
    public static int EXTRACTOR_ERROR_BROKEN_FILE = 2;
    public static int EXTRACTOR_ERRROR_NO_SUCH_FILE = 1;
    public static int EXTRACTOR_NO_ERRROR = 0;
    public static int EXTRACTOR_SOURCE_TYPE_LOCAL = 3;
    public static int EXTRACTOR_SOURCE_TYPE_NET = 2;
    public static int EXTRACTOR_SOURCE_TYPE_NULL = 0;
    public static int EXTRACTOR_SOURCE_TYPE_PROXY = 1;
    public static int EXTRACTOR_SOURCE_TYPE_STREAM = 4;
    private static final boolean VERBOSE = true;
    private ByteBuffer mAudioBuffer;
    private Condition mAudioCondition;
    private Lock mAudioLock;
    private boolean mAudioReadPaused;
    private boolean mAudioSeekDone;
    private Condition mCondition;
    private String mFile;
    private Lock mLock;
    private int mSeekMode;
    private long mSeektimeUs;
    private long mStream;
    private ByteBuffer mVideoBuffer;
    private Condition mVideoCondition;
    private Lock mVideoLock;
    private boolean mVideoReadPaused;
    private boolean mVideoSeekDone;
    private String TAG = "MVExtractor";
    private MediaExtractor mExtractor = null;
    private boolean mExtractorCreating = false;
    private int mVideoMax = 1024;
    private int mAudioMax = 256;
    private Queue<Frame> mVideoQueue = new LinkedList();
    private Queue<Frame> mAudioQueue = new LinkedList();
    private int mVideoBufferSize = 0;
    private int mAudioBufferSize = 0;
    private boolean mReadIsFailed = false;
    private int mReadErrorCount = 0;
    private long mAudioNewReadPts = 0;
    private long mCurrReadPts = 0;
    private int mVideoIndex = -1;
    private int mAudioIndex = -1;
    private boolean mExtractorDone = false;
    private boolean mStop = false;
    private boolean mThreadIsRun = false;

    public class Frame {
        public ByteBuffer buffer;
        public int bufferSize = 0;
        public long ptsUs = 0;
        public int sampleFlags = 0;
        public int index = -1;

        public Frame() {
            this.buffer = null;
            this.buffer = null;
        }
    }

    public MVExtractor(String str, long j) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        this.mLock = reentrantLock;
        this.mCondition = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock(true);
        this.mAudioLock = reentrantLock2;
        this.mAudioCondition = reentrantLock2.newCondition();
        ReentrantLock reentrantLock3 = new ReentrantLock(true);
        this.mVideoLock = reentrantLock3;
        this.mVideoCondition = reentrantLock3.newCondition();
        this.mSeektimeUs = -1L;
        this.mSeekMode = 1;
        this.mVideoSeekDone = true;
        this.mAudioSeekDone = true;
        this.mAudioReadPaused = false;
        this.mVideoReadPaused = false;
        this.mVideoBuffer = null;
        this.mAudioBuffer = null;
        this.mFile = null;
        this.mStream = 0L;
        if (str == null && j == 0) {
            return;
        }
        this.mFile = str;
        this.mStream = j;
        StartThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ExtratorThread() {
        int i2;
        if (b.f().debug()) {
            b.f().d(this.TAG, "ExtratorThread start mExtractor:" + this.mExtractor);
        }
        init();
        if (this.mExtractor == null && this.mFile == null) {
            if (b.f().debug()) {
                b.f().eLF(this.TAG, "ExtratorThread parameters invalid filepath(" + this.mFile + ")");
                return;
            }
            return;
        }
        if (b.f().debug()) {
            b.f().d(this.TAG, "ExtratorThread mExtractor(" + this.mExtractor + ")");
        }
        while (true) {
            if (this.mStop) {
                break;
            }
            b.f().d(this.TAG, "ExtratorThread loop");
            try {
                try {
                    this.mLock.lock();
                    while (!this.mStop && ((this.mExtractorDone || (this.mVideoQueue.size() > 16 && this.mAudioQueue.size() > 64)) && this.mSeektimeUs < 0)) {
                        b.f().d(this.TAG, "ExtratorThread wait..");
                        this.mCondition.awaitNanos(500000000L);
                    }
                } finally {
                    this.mLock.unlock();
                }
            } catch (Exception e2) {
                if (b.f().debug()) {
                    b.f().eLF(this.TAG, "ExtratorThread Exception:" + e2);
                }
                e2.printStackTrace();
            }
            this.mLock.lock();
            if (this.mStop) {
                b.f().d(this.TAG, "ExtratorThread is stop...");
                break;
            }
            long j = this.mSeektimeUs;
            if (j >= 0) {
                i2 = this.mSeekMode;
                this.mCurrReadPts = j;
                this.mAudioNewReadPts = j;
                this.mSeektimeUs = -1L;
                this.mReadIsFailed = false;
            } else {
                j = -1;
                i2 = 1;
            }
            this.mLock.unlock();
            if (j >= 0) {
                if (b.f().debug()) {
                    b.f().d(this.TAG, " ExtratorThread seek:" + j);
                }
                this.mExtractor.seekTo(j, i2);
                this.mAudioLock.lock();
                try {
                    try {
                        if (!this.mAudioSeekDone) {
                            this.mAudioQueue.clear();
                            this.mAudioSeekDone = true;
                            this.mAudioCondition.signalAll();
                        }
                    } catch (Exception e3) {
                        if (b.f().debug()) {
                            b.f().eLF(this.TAG, "ExtratorThread Audio Exception:" + e3);
                        }
                        e3.printStackTrace();
                    }
                    this.mVideoLock.lock();
                    try {
                        try {
                            if (!this.mVideoSeekDone) {
                                this.mVideoQueue.clear();
                                this.mVideoSeekDone = true;
                                this.mVideoCondition.signalAll();
                            }
                        } catch (Exception e4) {
                            if (b.f().debug()) {
                                b.f().eLF(this.TAG, "ExtratorThread Video Exception:" + e4);
                            }
                            e4.printStackTrace();
                        }
                        if (b.f().debug()) {
                            b.f().d(this.TAG, "ExtratorThread seek:" + j + " end.contiue...");
                        }
                    } finally {
                    }
                } finally {
                }
            } else {
                b.f().d(this.TAG, "ExtratorThread loop 2");
                b.f().d(this.TAG, "ExtratorThread audiosize:" + this.mAudioQueue.size() + " videosize:" + this.mVideoQueue.size());
                Frame frameFromExtractor = readFrameFromExtractor();
                if (frameFromExtractor == null) {
                    if (b.f().debug()) {
                        b.f().eLF(this.TAG, "readFrameFromExtractor return null extractorDone:" + this.mExtractorDone);
                    }
                    this.mAudioLock.lock();
                    try {
                        try {
                            this.mAudioCondition.signalAll();
                        } catch (Exception e5) {
                            if (b.f().debug()) {
                                b.f().eLF(this.TAG, "ExtratorThread Exception:" + e5);
                            }
                            e5.printStackTrace();
                        }
                        this.mVideoLock.lock();
                        try {
                            try {
                                this.mVideoCondition.signalAll();
                            } finally {
                            }
                        } catch (Exception e6) {
                            if (b.f().debug()) {
                                b.f().eLF(this.TAG, "ExtratorThread Exception:" + e6);
                            }
                            e6.printStackTrace();
                        }
                    } finally {
                    }
                } else {
                    int i3 = frameFromExtractor.index;
                    if (i3 == this.mAudioIndex) {
                        this.mAudioLock.lock();
                        try {
                            try {
                                if (this.mAudioQueue.size() < this.mAudioMax) {
                                    b.f().d(this.TAG, "mAudioQueue EEEEE,size:" + this.mAudioQueue.size() + " bufferSize:" + frameFromExtractor.bufferSize + " ptsUs:" + frameFromExtractor.ptsUs);
                                    this.mAudioQueue.offer(frameFromExtractor);
                                } else if (b.f().debug()) {
                                    b.f().eLF(this.TAG, "mAudioQueue is full FFFFF,size:" + this.mAudioQueue.size());
                                }
                                this.mAudioCondition.signalAll();
                            } catch (Exception e7) {
                                if (b.f().debug()) {
                                    b.f().eLF(this.TAG, "ExtratorThread Exception:" + e7);
                                }
                                e7.printStackTrace();
                            }
                        } finally {
                        }
                    } else if (i3 == this.mVideoIndex) {
                        this.mVideoLock.lock();
                        try {
                            try {
                                if (this.mVideoQueue.size() < this.mVideoMax) {
                                    b.f().d(this.TAG, "mVideoQueue EEEEE,size:" + this.mVideoQueue.size() + " bufferSize:" + frameFromExtractor.bufferSize + " ptsUs:" + frameFromExtractor.ptsUs);
                                    this.mVideoQueue.offer(frameFromExtractor);
                                } else if (b.f().debug()) {
                                    b.f().eLF(this.TAG, "mVideoQueue is full FFFFF,size:" + this.mVideoQueue.size());
                                }
                                this.mVideoCondition.signalAll();
                            } finally {
                            }
                        } catch (Exception e8) {
                            if (b.f().debug()) {
                                b.f().eLF(this.TAG, "ExtratorThread Exception:" + e8);
                            }
                            e8.printStackTrace();
                        }
                    }
                }
            }
        }
        if (b.f().debug()) {
            b.f().eLF(this.TAG, "ExtratorThread end");
        }
    }

    private void StartThread() {
        if (b.f().debug()) {
            b.f().i(this.TAG, "====StartThread entry");
        }
        new Thread(new Runnable() { // from class: com.kugou.common.player.kugouplayer.MVExtractor.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.f().debug()) {
                    b.f().i(MVExtractor.this.TAG, "====run: ExtratorThread start");
                }
                MVExtractor.this.mLock.lock();
                if (MVExtractor.this.mThreadIsRun) {
                    MVExtractor.this.mLock.unlock();
                    if (b.f().debug()) {
                        b.f().d(MVExtractor.this.TAG, "run:ExtratorThread start faile,already started");
                        return;
                    }
                    return;
                }
                MVExtractor.this.mThreadIsRun = true;
                MVExtractor.this.mLock.unlock();
                try {
                    try {
                        if (b.f().debug()) {
                            b.f().i(MVExtractor.this.TAG, "====call ExtratorThread");
                        }
                        MVExtractor.this.mStop = false;
                        MVExtractor.this.ExtratorThread();
                        if (b.f().debug()) {
                            b.f().i(MVExtractor.this.TAG, "====call ExtratorThread end");
                        }
                        MVExtractor.this.mVideoLock.lock();
                        MVExtractor.this.mVideoQueue.clear();
                        MVExtractor.this.mVideoLock.unlock();
                        MVExtractor.this.mAudioLock.lock();
                        MVExtractor.this.mAudioQueue.clear();
                        MVExtractor.this.mAudioLock.unlock();
                        MVExtractor.this.mLock.lock();
                        MediaExtractor mediaExtractor = MVExtractor.this.mExtractor;
                        MVExtractor.this.mExtractor = null;
                        MVExtractor.this.mThreadIsRun = false;
                        MVExtractor.this.mLock.unlock();
                        if (mediaExtractor != null) {
                            mediaExtractor.release();
                        }
                        if (!b.f().debug()) {
                            return;
                        }
                    } catch (Exception e2) {
                        if (b.f().debug()) {
                            b.f().eLF(MVExtractor.this.TAG, "ExtratorThread Exception:" + e2);
                        }
                        e2.printStackTrace();
                        MVExtractor.this.mVideoLock.lock();
                        MVExtractor.this.mVideoQueue.clear();
                        MVExtractor.this.mVideoLock.unlock();
                        MVExtractor.this.mAudioLock.lock();
                        MVExtractor.this.mAudioQueue.clear();
                        MVExtractor.this.mAudioLock.unlock();
                        MVExtractor.this.mLock.lock();
                        MediaExtractor mediaExtractor2 = MVExtractor.this.mExtractor;
                        MVExtractor.this.mExtractor = null;
                        MVExtractor.this.mThreadIsRun = false;
                        MVExtractor.this.mLock.unlock();
                        if (mediaExtractor2 != null) {
                            mediaExtractor2.release();
                        }
                        if (!b.f().debug()) {
                            return;
                        }
                    }
                    b.f().i(MVExtractor.this.TAG, "ExtratorThread finally");
                } catch (Throwable th) {
                    MVExtractor.this.mVideoLock.lock();
                    MVExtractor.this.mVideoQueue.clear();
                    MVExtractor.this.mVideoLock.unlock();
                    MVExtractor.this.mAudioLock.lock();
                    MVExtractor.this.mAudioQueue.clear();
                    MVExtractor.this.mAudioLock.unlock();
                    MVExtractor.this.mLock.lock();
                    MediaExtractor mediaExtractor3 = MVExtractor.this.mExtractor;
                    MVExtractor.this.mExtractor = null;
                    MVExtractor.this.mThreadIsRun = false;
                    MVExtractor.this.mLock.unlock();
                    if (mediaExtractor3 != null) {
                        mediaExtractor3.release();
                    }
                    if (b.f().debug()) {
                        b.f().i(MVExtractor.this.TAG, "ExtratorThread finally");
                    }
                    throw th;
                }
            }
        }).start();
        if (b.f().debug()) {
            b.f().i(this.TAG, "====StartThread end");
        }
    }

    private MediaExtractor createExtractor() {
        if (b.f().debug()) {
            b.f().d(this.TAG, "createExtractor filepath(" + this.mFile + ")");
        }
        if (this.mFile == null && this.mStream == 0) {
            return null;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            String str = this.mFile;
            if (str != null) {
                mediaExtractor.setDataSource(str);
            }
            if (b.f().debug()) {
                b.f().iLF(this.TAG, "createExtractor mFile:" + this.mFile + " mStream:" + this.mStream);
            }
            if (b.f().debug()) {
                b.f().iLF(this.TAG, "createExtractor getTrackCount:" + mediaExtractor.getTrackCount());
            }
            if (b.f().debug()) {
                b.f().iLF(this.TAG, "createExtractor getTrackCount:" + mediaExtractor.getTrackCount() + " getSampleTrackIndex:" + mediaExtractor.getSampleTrackIndex() + " getSampleTime:" + mediaExtractor.getSampleTime() + " getSampleFlags:" + mediaExtractor.getSampleFlags() + " mFile:" + this.mFile);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (b.f().debug()) {
                b.f().eLF(this.TAG, "createExtractor Exception:" + e2 + " mFile:" + this.mFile);
            }
        }
        return mediaExtractor;
    }

    public static boolean fileIsExists(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private MediaExtractor getExtractor() {
        this.mLock.lock();
        try {
            try {
                if (this.mStop || this.mExtractor != null || this.mFile == null || this.mExtractorCreating) {
                    while (!this.mStop && this.mExtractor == null && this.mFile != null && this.mExtractorCreating) {
                        if (b.f().debug()) {
                            b.f().d(this.TAG, "getExtractor wait createExtractor filepath(" + this.mFile + ")");
                        }
                        this.mCondition.await();
                    }
                } else {
                    this.mExtractorCreating = true;
                    this.mLock.unlock();
                    if (b.f().debug()) {
                        b.f().d(this.TAG, "getExtractor createExtractor filepath(" + this.mFile + ") fileIsExists:" + fileIsExists(this.mFile));
                    }
                    MediaExtractor mediaExtractorCreateExtractor = createExtractor();
                    this.mLock.lock();
                    this.mExtractor = mediaExtractorCreateExtractor;
                    this.mExtractorCreating = false;
                    this.mCondition.signalAll();
                    if (b.f().debug()) {
                        b.f().d(this.TAG, "getExtractor mExtractor:" + this.mExtractor + " this:" + this);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (b.f().debug()) {
                    b.f().eLF(this.TAG, "getExtractor Exception:" + e2);
                }
            }
            return this.mExtractor;
        } finally {
            this.mLock.unlock();
        }
    }

    private final int getInteger(MediaFormat mediaFormat, String str, int i2) {
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(str);
            } catch (ClassCastException e2) {
                e2.printStackTrace();
            } catch (NullPointerException e3) {
                e3.printStackTrace();
            }
        }
        return i2;
    }

    private static String getMimeTypeFor(MediaFormat mediaFormat) {
        return mediaFormat.getString("mime");
    }

    private void init() {
        int i2;
        getExtractor();
        getVideoIndex();
        getAudioIndex();
        MediaExtractor mediaExtractor = this.mExtractor;
        if (mediaExtractor == null || (i2 = this.mVideoIndex) < 0 || this.mAudioIndex < 0) {
            return;
        }
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
        if (trackFormat != null) {
            int integer = getInteger(trackFormat, "max-input-size", 0);
            this.mVideoBufferSize = integer;
            if (integer <= 0) {
                int integer2 = getInteger(trackFormat, "width", 0) * getInteger(trackFormat, "height", 0) * 3;
                this.mVideoBufferSize = integer2;
                if (integer2 == 0) {
                    this.mVideoBufferSize = 4147200;
                }
            }
            int i3 = this.mVideoBufferSize;
            if (i3 > 0) {
                this.mVideoBuffer = ByteBuffer.allocate(i3);
            }
        }
        MediaFormat trackFormat2 = this.mExtractor.getTrackFormat(this.mAudioIndex);
        if (trackFormat2 != null) {
            int integer3 = getInteger(trackFormat2, "max-input-size", 0);
            this.mAudioBufferSize = integer3;
            if (integer3 <= 0) {
                int integer4 = (((getInteger(trackFormat2, "channel-count", 0) * getInteger(trackFormat2, "sample-rate", 0)) * 4) * 46) / 1000;
                this.mAudioBufferSize = integer4;
                if (integer4 < 4096) {
                    this.mAudioBufferSize = 4096;
                }
            }
            int i4 = this.mAudioBufferSize;
            if (i4 > 0) {
                this.mAudioBuffer = ByteBuffer.allocate(i4);
            }
        }
        if (b.f().debug()) {
            b.f().d(this.TAG, "MVExtractor: mVideoBufferSize:" + this.mVideoBufferSize + " mAudioBufferSize:" + this.mAudioBufferSize);
        }
    }

    private static boolean isAudioFormat(MediaFormat mediaFormat) {
        return getMimeTypeFor(mediaFormat).startsWith("audio/");
    }

    private static boolean isVideoFormat(MediaFormat mediaFormat) {
        return getMimeTypeFor(mediaFormat).startsWith("video/");
    }

    private Frame readFrameFromExtractor() {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        MediaExtractor extractor = getExtractor();
        if (this.mExtractorDone || extractor == null) {
            if (b.f().debug()) {
                b.f().eLF(this.TAG, "readFrameFromExtractor error extractorDone:" + this.mExtractorDone + " extractor:" + extractor);
            }
            return null;
        }
        Frame frame = new Frame();
        int sampleTrackIndex = extractor.getSampleTrackIndex();
        frame.index = sampleTrackIndex;
        if (sampleTrackIndex >= 0) {
            frame.ptsUs = extractor.getSampleTime();
            frame.sampleFlags = extractor.getSampleFlags();
            long j = frame.ptsUs;
            if (j > 0) {
                if (frame.index == this.mAudioIndex) {
                    this.mAudioNewReadPts = j;
                }
                this.mCurrReadPts = j;
            }
            this.mReadErrorCount = 0;
        } else {
            this.mReadIsFailed = true;
            this.mReadErrorCount++;
            if (b.f().debug()) {
                b.f().eLF(this.TAG, "readFrameFromExtractor failed index:" + frame.index + " ptsUs:" + frame.ptsUs + " flags:" + frame.sampleFlags + "videoindex:" + this.mVideoIndex + " mAudioIndex:" + this.mAudioIndex + "mReadErrorCount:" + this.mReadErrorCount);
            }
        }
        b.f().d(this.TAG, "readFrameFromExtractor  ptsUs:" + frame.ptsUs + " index:" + frame.index + " flags:" + frame.sampleFlags + "videoindex:" + this.mVideoIndex + " mAudioIndex:" + this.mAudioIndex);
        int i2 = this.mVideoIndex;
        int i3 = frame.index;
        if (i2 == i3 && (byteBuffer2 = this.mVideoBuffer) != null && this.mVideoBufferSize > 0) {
            byteBuffer2.clear();
            frame.bufferSize = extractor.readSampleData(this.mVideoBuffer, 0);
            b.f().d(this.TAG, "readFrameFromExtractor mVideoIndex bufferSize:" + frame.bufferSize);
            int i4 = frame.bufferSize;
            if (i4 <= 0 || i4 > this.mVideoBufferSize) {
                if (b.f().debug()) {
                    b.f().eLF(this.TAG, "readFrameFromExtractor video bufferSize(" + frame.bufferSize + ")invalid, maxbuffersize:" + this.mVideoBufferSize);
                }
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i4);
            frame.buffer = byteBufferAllocate;
            if (byteBufferAllocate == null) {
                if (b.f().debug()) {
                    b.f().eLF(this.TAG, "readFrameFromExtractor video allocate failed,bufferSize:" + frame.bufferSize);
                }
                return null;
            }
            this.mVideoBuffer.position(0);
            this.mVideoBuffer.limit(frame.bufferSize);
            frame.buffer.clear();
            frame.buffer.put(this.mVideoBuffer);
            frame.buffer.position(0);
            frame.buffer.limit(frame.bufferSize);
        } else if (this.mAudioIndex == i3 && (byteBuffer = this.mAudioBuffer) != null && this.mAudioBufferSize > 0) {
            byteBuffer.clear();
            frame.bufferSize = extractor.readSampleData(this.mAudioBuffer, 0);
            b.f().d(this.TAG, "readFrameFromExtractor mAudioIndex bufferSize:" + frame.bufferSize);
            int i5 = frame.bufferSize;
            if (i5 <= 0 || i5 > this.mAudioBufferSize) {
                if (b.f().debug()) {
                    b.f().eLF(this.TAG, "readFrameFromExtractor audio bufferSize(" + frame.bufferSize + ")invalid, maxbuffersize:" + this.mAudioBufferSize);
                }
                return null;
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i5);
            frame.buffer = byteBufferAllocate2;
            if (byteBufferAllocate2 == null) {
                if (b.f().debug()) {
                    b.f().eLF(this.TAG, "readFrameFromExtractor audio allocate failed,bufferSize:" + frame.bufferSize);
                }
                return null;
            }
            this.mAudioBuffer.position(0);
            this.mAudioBuffer.limit(frame.bufferSize);
            frame.buffer.clear();
            frame.buffer.put(this.mAudioBuffer);
            frame.buffer.position(0);
            frame.buffer.limit(frame.bufferSize);
        }
        this.mExtractorDone = !extractor.advance();
        if (frame.bufferSize > 0) {
            e.c.e.a.a.b bVarF = b.f();
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("readFrameFromExtractor: readSampleData size:");
            sb.append(frame.bufferSize);
            sb.append(" is EOF:");
            sb.append(this.mExtractorDone ? "yes" : "no");
            bVarF.d(str, sb.toString());
            return frame;
        }
        if (!b.f().debug()) {
            return null;
        }
        e.c.e.a.a.b bVarF2 = b.f();
        String str2 = this.TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("readFrameFromExtractor: readSampleData size:");
        sb2.append(frame.bufferSize);
        sb2.append(" is EOF:");
        sb2.append(this.mExtractorDone ? "yes" : "no");
        bVarF2.eLF(str2, sb2.toString());
        return null;
    }

    public void clear(int i2) {
        Queue<Frame> queue;
        Queue<Frame> queue2;
        if (this.mVideoIndex == i2) {
            this.mVideoLock.lock();
            try {
                try {
                    if (!this.mVideoSeekDone && (queue2 = this.mVideoQueue) != null) {
                        queue2.clear();
                        this.mVideoCondition.signalAll();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return;
            } finally {
                this.mVideoLock.unlock();
            }
        }
        if (this.mAudioIndex == i2) {
            this.mAudioLock.lock();
            try {
                try {
                    if (!this.mAudioSeekDone && (queue = this.mAudioQueue) != null) {
                        queue.clear();
                        this.mAudioCondition.signalAll();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } finally {
                this.mAudioLock.unlock();
            }
        }
    }

    public void clearAll() {
        this.mLock.lock();
        this.mExtractorDone = false;
        this.mLock.unlock();
        clear(this.mVideoIndex);
        clear(this.mVideoIndex);
    }

    public boolean frameQueueIsEmpty() {
        this.mAudioLock.lock();
        Queue<Frame> queue = this.mAudioQueue;
        boolean z = queue == null || queue.size() <= 0;
        this.mAudioLock.unlock();
        return z;
    }

    public int getAndSelectAudioTrackIndex(MediaExtractor mediaExtractor) {
        if (mediaExtractor == null) {
            if (b.f().debug()) {
                b.f().eLF(this.TAG, "getAndSelectAudioTrackIndex extractor is null");
            }
            return -1;
        }
        if (b.f().debug()) {
            b.f().d(this.TAG, "getAndSelectAudioTrackIndex getTrackCount" + mediaExtractor.getTrackCount());
        }
        for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
            if (b.f().debug()) {
                b.f().d(this.TAG, "format for track " + i2 + " is " + getMimeTypeFor(mediaExtractor.getTrackFormat(i2)));
            }
            if (isAudioFormat(mediaExtractor.getTrackFormat(i2))) {
                mediaExtractor.selectTrack(i2);
                return i2;
            }
        }
        return -1;
    }

    public int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        if (mediaExtractor == null) {
            if (b.f().debug()) {
                b.f().eLF(this.TAG, "getAndSelectVideoTrackIndex extractor is null");
            }
            return -1;
        }
        if (b.f().debug()) {
            b.f().d(this.TAG, "getAndSelectVideoTrackIndex getTrackCount" + mediaExtractor.getTrackCount());
        }
        for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
            if (b.f().debug()) {
                b.f().d(this.TAG, "format for track " + i2 + " is " + getMimeTypeFor(mediaExtractor.getTrackFormat(i2)));
            }
            if (isVideoFormat(mediaExtractor.getTrackFormat(i2))) {
                mediaExtractor.selectTrack(i2);
                return i2;
            }
        }
        return -1;
    }

    public int getAudioIndex() {
        getExtractor();
        this.mLock.lock();
        this.mAudioLock.lock();
        try {
            try {
                if (this.mAudioIndex < 0) {
                    this.mAudioIndex = getAndSelectAudioTrackIndex(this.mExtractor);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this.mAudioIndex;
        } finally {
            this.mAudioLock.unlock();
            this.mLock.unlock();
        }
    }

    public long getDuration() {
        MediaExtractor extractor = getExtractor();
        long j = extractor != null ? extractor.getTrackFormat(getAudioIndex()).getLong("durationUs") : -1L;
        if (b.f().debug()) {
            b.f().d(this.TAG, "duration:" + j);
        }
        return j;
    }

    public int getErrorState() {
        return (getExtractor() == null && !fileIsExists(this.mFile) && this.mStream == 0) ? EXTRACTOR_ERRROR_NO_SUCH_FILE : (getVideoIndex() < 0 || getAudioIndex() < 0) ? EXTRACTOR_ERROR_BROKEN_FILE : EXTRACTOR_NO_ERRROR;
    }

    public int getSourcType() {
        if (this.mStream != 0) {
            return EXTRACTOR_SOURCE_TYPE_STREAM;
        }
        String str = this.mFile;
        return (str == null || str.length() == 0) ? EXTRACTOR_SOURCE_TYPE_NULL : this.mFile.indexOf("http://127.0.0.1") == 0 ? EXTRACTOR_SOURCE_TYPE_PROXY : this.mFile.indexOf("http://fs.mv.android.kugou.com") == 0 ? EXTRACTOR_SOURCE_TYPE_NET : EXTRACTOR_SOURCE_TYPE_LOCAL;
    }

    public MediaFormat getTrackFormat(int i2) {
        MediaExtractor extractor = getExtractor();
        if (extractor == null || i2 < 0) {
            return null;
        }
        return extractor.getTrackFormat(i2);
    }

    public int getVideoIndex() {
        getExtractor();
        this.mLock.lock();
        this.mVideoLock.lock();
        try {
            try {
                if (this.mVideoIndex < 0) {
                    this.mVideoIndex = getAndSelectVideoTrackIndex(this.mExtractor);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this.mVideoIndex;
        } finally {
            this.mVideoLock.unlock();
            this.mLock.unlock();
        }
    }

    public boolean isEof() {
        this.mLock.lock();
        boolean z = this.mExtractorDone && this.mSeektimeUs < 0;
        this.mLock.unlock();
        return z;
    }

    public Frame readFrame(int i2) {
        Queue<Frame> queue;
        Queue<Frame> queue2;
        Queue<Frame> queue3;
        Queue<Frame> queue4;
        b.f().d(this.TAG, "readFrame index:" + i2);
        Frame framePoll = null;
        if (i2 == this.mVideoIndex) {
            this.mVideoLock.lock();
            while (!this.mStop && !this.mVideoReadPaused && !this.mExtractorDone && (queue4 = this.mVideoQueue) != null && (!this.mVideoSeekDone || queue4.size() == 0)) {
                try {
                    try {
                        this.mVideoCondition.await();
                    } catch (Exception e2) {
                        if (b.f().debug()) {
                            b.f().eLF(this.TAG, "getVideoFrame Exception:" + e2);
                        }
                        e2.printStackTrace();
                    }
                } finally {
                    this.mVideoLock.unlock();
                }
            }
            if (!this.mVideoReadPaused && this.mVideoSeekDone && (queue3 = this.mVideoQueue) != null && queue3.size() > 0) {
                framePoll = this.mVideoQueue.poll();
            }
        } else if (i2 == this.mAudioIndex) {
            this.mAudioLock.lock();
            while (!this.mStop && !this.mAudioReadPaused && !this.mExtractorDone && (queue2 = this.mAudioQueue) != null && (!this.mAudioSeekDone || queue2.size() == 0)) {
                try {
                    try {
                        this.mAudioCondition.await();
                    } catch (Exception e3) {
                        if (b.f().debug()) {
                            b.f().eLF(this.TAG, "get audio frame Exception:" + e3);
                        }
                        e3.printStackTrace();
                    }
                } finally {
                    this.mAudioLock.unlock();
                }
            }
            if (!this.mAudioReadPaused && this.mAudioSeekDone && (queue = this.mAudioQueue) != null && queue.size() > 0) {
                framePoll = this.mAudioQueue.poll();
            }
        } else if (b.f().debug()) {
            b.f().eLF(this.TAG, "invalid index");
        }
        this.mLock.lock();
        try {
            try {
                this.mCondition.signalAll();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            b.f().d(this.TAG, "readFrame index:" + i2 + " end frame:" + framePoll);
            return framePoll;
        } finally {
            this.mLock.unlock();
        }
    }

    public void release() {
        if (b.f().debug()) {
            b.f().d(this.TAG, " release");
        }
        this.mLock.lock();
        try {
            try {
                this.mStop = true;
                this.mCondition.signalAll();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mLock.unlock();
            if (b.f().debug()) {
                b.f().d(this.TAG, " release end");
            }
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public boolean resetExtractor() {
        return resetExtractor(this.mCurrReadPts);
    }

    public void seekTo(long j, int i2) {
        Lock lock;
        Lock lock2;
        if (b.f().debug()) {
            b.f().d(this.TAG, "seekTo " + j + "us");
        }
        if (j < 0) {
            if (b.f().debug()) {
                b.f().eLF(this.TAG, "seekTo " + j + "us invalid");
                return;
            }
            return;
        }
        this.mLock.lock();
        try {
            try {
                this.mSeektimeUs = j;
                this.mSeekMode = i2;
                this.mExtractorDone = false;
                this.mReadIsFailed = false;
                this.mAudioLock.lock();
                try {
                    try {
                        this.mAudioSeekDone = false;
                        this.mAudioReadPaused = true;
                        this.mAudioCondition.signalAll();
                        lock = this.mAudioLock;
                    } catch (Throwable th) {
                        this.mAudioLock.unlock();
                        throw th;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    lock = this.mAudioLock;
                }
                lock.unlock();
                this.mVideoLock.lock();
                try {
                    try {
                        this.mVideoSeekDone = false;
                        this.mVideoReadPaused = true;
                        this.mVideoCondition.signalAll();
                        lock2 = this.mVideoLock;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        lock2 = this.mVideoLock;
                    }
                    lock2.unlock();
                    this.mCondition.signalAll();
                    if (!this.mThreadIsRun) {
                        StartThread();
                    }
                } catch (Throwable th2) {
                    this.mVideoLock.unlock();
                    throw th2;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.mLock.unlock();
            if (b.f().debug()) {
                b.f().d(this.TAG, "seekTo end");
            }
        } catch (Throwable th3) {
            this.mLock.unlock();
            throw th3;
        }
    }

    public void setReadState(int i2) {
        if (b.f().debug()) {
            b.f().d(this.TAG, "setReadState start");
        }
        if (i2 == this.mVideoIndex || i2 == -1) {
            if (b.f().debug()) {
                b.f().d(this.TAG, "setReadState video...");
            }
            this.mVideoLock.lock();
            this.mVideoReadPaused = false;
            this.mVideoLock.unlock();
        }
        if (i2 == this.mAudioIndex || i2 == -1) {
            if (b.f().debug()) {
                b.f().d(this.TAG, "setReadState audio...");
            }
            this.mAudioLock.lock();
            this.mAudioReadPaused = false;
            this.mAudioLock.unlock();
        }
        if (b.f().debug()) {
            b.f().d(this.TAG, "setReadState end");
        }
    }

    public void stop() {
        if (b.f().debug()) {
            b.f().d(this.TAG, " stop entry");
        }
        this.mLock.lock();
        try {
            try {
                this.mStop = true;
                this.mCondition.signalAll();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mLock.unlock();
            if (b.f().debug()) {
                b.f().d(this.TAG, " stop 1");
            }
            this.mAudioLock.lock();
            try {
                try {
                    this.mAudioReadPaused = true;
                    this.mAudioCondition.signalAll();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.mAudioLock.unlock();
                this.mVideoLock.lock();
                try {
                    try {
                        this.mVideoReadPaused = true;
                        this.mVideoCondition.signalAll();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    this.mVideoLock.unlock();
                    if (b.f().debug()) {
                        b.f().d(this.TAG, " stop end");
                    }
                } catch (Throwable th) {
                    this.mVideoLock.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                this.mAudioLock.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            this.mLock.unlock();
            throw th3;
        }
    }

    private boolean resetExtractor(long j) {
        e.c.e.a.a.b bVarF;
        String str;
        StringBuilder sb;
        MediaExtractor mediaExtractorCreateExtractor;
        boolean z;
        try {
            try {
                if (b.f().debug()) {
                    b.f().d(this.TAG, "resetExtractor createExtractor filepath(" + this.mFile + ")");
                }
                mediaExtractorCreateExtractor = createExtractor();
                z = false;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (b.f().debug()) {
                    b.f().eLF(this.TAG, "resetExtractor Exception:" + e2);
                }
                if (b.f().debug()) {
                    bVarF = b.f();
                    str = this.TAG;
                    sb = new StringBuilder();
                }
            }
            if (mediaExtractorCreateExtractor == null) {
                if (b.f().debug()) {
                    b.f().eLF(this.TAG, "resetExtractor createExtractor failed");
                }
                return false;
            }
            if (j > 0) {
                mediaExtractorCreateExtractor.seekTo(j, 0);
                while (true) {
                    int sampleTrackIndex = mediaExtractorCreateExtractor.getSampleTrackIndex();
                    if (sampleTrackIndex >= 0) {
                        long sampleTime = mediaExtractorCreateExtractor.getSampleTime();
                        if (sampleTime >= j) {
                            if (b.f().debug()) {
                                b.f().d(this.TAG, "resetExtractor seek end, ptsUs:" + sampleTime + " seekUs:" + j);
                            }
                            z = true;
                        } else if (mediaExtractorCreateExtractor.advance()) {
                            if (b.f().debug()) {
                                b.f().d(this.TAG, "resetExtractor ignore, ptsUs:" + sampleTime + " seekUs:" + j);
                            }
                        } else if (b.f().debug()) {
                            b.f().eLF(this.TAG, "resetExtractor advance is false, mExtractor:" + this.mExtractor);
                        }
                    } else if (b.f().debug()) {
                        b.f().eLF(this.TAG, "resetExtractor read error, index:" + sampleTrackIndex);
                    }
                }
                if (!z) {
                    if (b.f().debug()) {
                        b.f().d(this.TAG, "resetExtractor error,mExtractor:" + this.mExtractor + " this:" + this);
                    }
                    if (b.f().debug()) {
                        b.f().d(this.TAG, "resetExtractor end,mExtractor:" + this.mExtractor + " this:" + this);
                    }
                    return z;
                }
            }
            this.mLock.lock();
            MediaExtractor mediaExtractor = this.mExtractor;
            this.mExtractor = mediaExtractorCreateExtractor;
            this.mLock.unlock();
            mediaExtractor.release();
            if (b.f().debug()) {
                bVarF = b.f();
                str = this.TAG;
                sb = new StringBuilder();
                sb.append("resetExtractor end,mExtractor:");
                sb.append(this.mExtractor);
                sb.append(" this:");
                sb.append(this);
                bVarF.d(str, sb.toString());
            }
            return true;
        } finally {
            if (b.f().debug()) {
                b.f().d(this.TAG, "resetExtractor end,mExtractor:" + this.mExtractor + " this:" + this);
            }
        }
    }
}
