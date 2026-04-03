package com.kugou.common.player.kugouplayer;

import android.media.AudioTrack;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.kugou.android.watch.lite.base.player.Initiator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAudioTrack {
    private static final long PLAYER_OPTIONS_FADEIN_BY_PLAYER = 4;
    private static final long PLAYER_OPTIONS_LARGEBUFFER = 1;
    private static final long PLAYER_OPTIONS_MV = 16;
    private static final long PLAYER_OPTIONS_NONE = 0;
    private static final long PLAYER_OPTIONS_NO_FADEIN_AT_BEGIN = 2;
    private static final long PLAYER_OPTIONS_NO_FADEIN_WHEN_SEEK = 8;
    private static final String TAG = "KugouPlayer";
    private static long unsupportsamplerate = -1;
    public int mBufferMs;
    public int mChannels;
    private Lock mLock;
    private int mMinBufferSize;
    private long mNativeContext;
    public boolean mNeedFadeInFlag;
    public long mOptions;
    public int mSampleRate;
    public int mTrackBufferSize;
    private Condition mWorkCondition;
    private AudioTrack mAudioTrack = null;
    private boolean mThreadFlag = false;
    private boolean mStartFlag = false;
    private Thread mThread = null;
    private byte[] mAudioBuffer = null;
    public int mCurrentVolume = 100;
    public float mVolume = 1.0f;
    public long mLastPosition = 0;
    public boolean mFadeInThreadRunFlag = false;
    public Thread mFadeInThread = null;
    public int mWriteLength = 0;
    public int mFill = 0;
    public Runnable mFadeInThreadRunnable = new Runnable() { // from class: com.kugou.common.player.kugouplayer.NativeAudioTrack.1
        @Override // java.lang.Runnable
        public void run() {
            NativeAudioTrack nativeAudioTrack;
            int i2;
            while (true) {
                NativeAudioTrack nativeAudioTrack2 = NativeAudioTrack.this;
                if (!nativeAudioTrack2.mFadeInThreadRunFlag || nativeAudioTrack2.mAudioTrack == null || (i2 = (nativeAudioTrack = NativeAudioTrack.this).mCurrentVolume) > 100) {
                    return;
                }
                if (i2 >= 0) {
                    float f2 = (nativeAudioTrack.mVolume * i2) / 100.0f;
                    try {
                        nativeAudioTrack.mAudioTrack.setStereoVolume(f2, f2);
                    } catch (Exception unused) {
                        Log.i(NativeAudioTrack.TAG, "mAudioTrack setStereoVolume get Exception");
                    }
                } else {
                    try {
                        nativeAudioTrack.mAudioTrack.setStereoVolume(0.0f, 0.0f);
                    } catch (Exception unused2) {
                        Log.i(NativeAudioTrack.TAG, "mAudioTrack setStereoVolume get Exception");
                    }
                }
                NativeAudioTrack nativeAudioTrack3 = NativeAudioTrack.this;
                int i3 = nativeAudioTrack3.mCurrentVolume;
                if (i3 < 0) {
                    nativeAudioTrack3.mCurrentVolume = i3 + 10;
                } else {
                    nativeAudioTrack3.mCurrentVolume = i3 + 10;
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    };

    public NativeAudioTrack(int i2, int i3, long j) {
        int i4;
        this.mLock = null;
        this.mWorkCondition = null;
        this.mMinBufferSize = 0;
        this.mBufferMs = 0;
        this.mNeedFadeInFlag = false;
        this.mOptions = 0L;
        this.mSampleRate = 0;
        this.mChannels = 0;
        this.mTrackBufferSize = 0;
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i3 > 1 ? 12 : 4, 2);
        this.mMinBufferSize = minBufferSize;
        int i5 = minBufferSize * 2;
        Log.i(TAG, "mAudioTrack mMinBufferSize:" + this.mMinBufferSize + " samplerate:" + i2);
        this.mSampleRate = i2;
        this.mChannels = i3;
        this.mOptions = j;
        if ((16 & j) != 0) {
            int i6 = (i2 * i3) / 2;
            i5 = i6 > i5 ? i6 : i5;
            Log.i(TAG, "mAudioTrack mMinBufferSize:" + this.mMinBufferSize + " samplerate:" + i2 + " trackBufferSize:" + i5);
        } else if ((j & 1) != 0 && (i4 = i2 * i3 * 2) > i5) {
            i5 = i4;
        }
        this.mNeedFadeInFlag = (this.mOptions & 2) == 0;
        this.mTrackBufferSize = i5;
        int i7 = (i5 * 1000) / ((i2 * i3) * 2);
        this.mBufferMs = i7;
        if (i7 > 1000) {
            this.mBufferMs = 1000;
        }
        initAudioTrack();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mWorkCondition = reentrantLock.newCondition();
        Log.i(TAG, "audio track buffer size:" + this.mTrackBufferSize + " mBufferMs:" + this.mBufferMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int _FillUpCallBack(byte[] bArr, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int _OnComplete();

    private int flush() {
        stop();
        initAudioTrack();
        this.mNeedFadeInFlag = (this.mOptions & 8) == 0;
        return prepare();
    }

    public static long getUnSupportedSampleRates() {
        if (unsupportsamplerate < 0) {
            unsupportsamplerate = 0L;
            if (AudioTrack.getMinBufferSize(8000, 4, 2) < 0) {
                unsupportsamplerate |= 1;
            }
            if (AudioTrack.getMinBufferSize(8000, 12, 2) < 0) {
                unsupportsamplerate |= 2;
            }
            if (AudioTrack.getMinBufferSize(11025, 4, 2) < 0) {
                unsupportsamplerate |= 4;
            }
            if (AudioTrack.getMinBufferSize(11025, 12, 2) < 0) {
                unsupportsamplerate |= 8;
            }
            if (AudioTrack.getMinBufferSize(16000, 4, 2) < 0) {
                unsupportsamplerate |= 16;
            }
            if (AudioTrack.getMinBufferSize(16000, 12, 2) < 0) {
                unsupportsamplerate |= 32;
            }
            if (AudioTrack.getMinBufferSize(22050, 4, 2) < 0) {
                unsupportsamplerate |= 64;
            }
            if (AudioTrack.getMinBufferSize(22050, 12, 2) < 0) {
                unsupportsamplerate |= 128;
            }
            if (AudioTrack.getMinBufferSize(32000, 4, 2) < 0) {
                unsupportsamplerate |= 256;
            }
            if (AudioTrack.getMinBufferSize(32000, 12, 2) < 0) {
                unsupportsamplerate |= 512;
            }
            if (AudioTrack.getMinBufferSize(44100, 4, 2) < 0) {
                unsupportsamplerate |= 1024;
            }
            if (AudioTrack.getMinBufferSize(44100, 12, 2) < 0) {
                unsupportsamplerate |= 2048;
            }
            if (AudioTrack.getMinBufferSize(48000, 4, 2) < 0) {
                unsupportsamplerate |= 4096;
            }
            if (AudioTrack.getMinBufferSize(48000, 12, 2) < 0) {
                unsupportsamplerate |= 8192;
            }
            if (AudioTrack.getMinBufferSize(88200, 4, 2) < 0) {
                unsupportsamplerate |= 16384;
            }
            if (AudioTrack.getMinBufferSize(88200, 12, 2) < 0) {
                unsupportsamplerate |= 32768;
            }
            if (AudioTrack.getMinBufferSize(96000, 4, 2) < 0) {
                unsupportsamplerate |= 65536;
            }
            if (AudioTrack.getMinBufferSize(96000, 12, 2) < 0) {
                unsupportsamplerate |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            if (AudioTrack.getMinBufferSize(176400, 4, 2) < 0) {
                unsupportsamplerate |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            if (AudioTrack.getMinBufferSize(176400, 12, 2) < 0) {
                unsupportsamplerate |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            if (AudioTrack.getMinBufferSize(192000, 4, 2) < 0) {
                unsupportsamplerate |= 1048576;
            }
            if (AudioTrack.getMinBufferSize(192000, 12, 2) < 0) {
                unsupportsamplerate |= 2097152;
            }
            if (AudioTrack.getMinBufferSize(352800, 4, 2) < 0) {
                unsupportsamplerate |= 4194304;
            }
            if (AudioTrack.getMinBufferSize(352800, 12, 2) < 0) {
                unsupportsamplerate |= Initiator.ESP_IDENTIFY_APP;
            }
            if (AudioTrack.getMinBufferSize(384000, 4, 2) < 0) {
                unsupportsamplerate |= Initiator.ESP_FX_MUSIC_SV;
            }
            if (AudioTrack.getMinBufferSize(384000, 12, 2) < 0) {
                unsupportsamplerate |= Initiator.ESP_SPLASH_PUSH;
            }
        }
        Log.i(TAG, "unsupportsamplerate is " + unsupportsamplerate);
        return unsupportsamplerate;
    }

    private void initAudioTrack() {
        int i2 = this.mChannels > 1 ? 12 : 4;
        try {
            this.mAudioTrack = new AudioTrack(3, this.mSampleRate, i2, 2, this.mTrackBufferSize, 1);
        } catch (IllegalArgumentException unused) {
            Log.i(TAG, "init AudioTrack fail");
        }
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null || audioTrack.getState() == 0) {
            int i3 = this.mMinBufferSize * 2;
            this.mTrackBufferSize = i3;
            int i4 = (i3 * 1000) / ((this.mSampleRate * this.mChannels) * 2);
            this.mBufferMs = i4;
            if (i4 > 1000) {
                this.mBufferMs = 1000;
            }
            Log.i(TAG, "try init AudioTrack again, make it least " + this.mTrackBufferSize);
            try {
                this.mAudioTrack = new AudioTrack(3, this.mSampleRate, i2, 2, this.mTrackBufferSize, 1);
            } catch (IllegalArgumentException unused2) {
                Log.i(TAG, "init AudioTrack fail");
            }
        }
    }

    private void pause() {
        this.mStartFlag = false;
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack.pause();
            } catch (IllegalStateException unused) {
                Log.i(TAG, "AudioTrack pause fail");
            }
        }
    }

    private long position() {
        AudioTrack audioTrack = this.mAudioTrack;
        long playbackHeadPosition = 0;
        if (audioTrack != null) {
            try {
                int sampleRate = audioTrack.getSampleRate();
                if (sampleRate > 0) {
                    playbackHeadPosition = (((long) this.mAudioTrack.getPlaybackHeadPosition()) * 1000) / ((long) sampleRate);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        long j = this.mLastPosition;
        if (playbackHeadPosition < j) {
            playbackHeadPosition = j;
        }
        this.mLastPosition = playbackHeadPosition;
        return playbackHeadPosition;
    }

    private int prepare() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null || audioTrack.getState() == 0) {
            Log.e(TAG, "audiotrack initialize fail!");
            return -1;
        }
        this.mThreadFlag = true;
        this.mLastPosition = 0L;
        setVolume(this.mVolume);
        this.mAudioBuffer = new byte[this.mTrackBufferSize];
        Log.d(TAG, "audiotrack prepare mTrackBufferSize:" + this.mTrackBufferSize);
        Thread thread = new Thread(new Runnable() { // from class: com.kugou.common.player.kugouplayer.NativeAudioTrack.2
            @Override // java.lang.Runnable
            public void run() {
                int iWrite;
                int i2 = (NativeAudioTrack.this.mChannels > 1 ? 2 : 1) * 2;
                long j = 0;
                while (NativeAudioTrack.this.mThreadFlag) {
                    if (!NativeAudioTrack.this.mStartFlag || NativeAudioTrack.this.mAudioTrack == null) {
                        NativeAudioTrack.this.mLock.lock();
                        Log.i(NativeAudioTrack.TAG, "not start, wait to quit mThreadFlag is " + NativeAudioTrack.this.mThreadFlag);
                        if (NativeAudioTrack.this.mThreadFlag) {
                            try {
                                NativeAudioTrack.this.mWorkCondition.await();
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                        NativeAudioTrack.this.mLock.unlock();
                    } else {
                        NativeAudioTrack nativeAudioTrack = NativeAudioTrack.this;
                        if (nativeAudioTrack.mWriteLength >= nativeAudioTrack.mFill) {
                            nativeAudioTrack.mWriteLength = 0;
                            nativeAudioTrack.mFill = nativeAudioTrack._FillUpCallBack(nativeAudioTrack.mAudioBuffer, NativeAudioTrack.this.mTrackBufferSize);
                            NativeAudioTrack nativeAudioTrack2 = NativeAudioTrack.this;
                            if (nativeAudioTrack2.mFill == 0) {
                                nativeAudioTrack2.mLock.lock();
                                Log.i(NativeAudioTrack.TAG, "fill is 0, try again");
                                if (NativeAudioTrack.this.mThreadFlag) {
                                    try {
                                        NativeAudioTrack.this.mWorkCondition.await(100L, TimeUnit.MILLISECONDS);
                                    } catch (InterruptedException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                NativeAudioTrack.this.mLock.unlock();
                            }
                        }
                        NativeAudioTrack nativeAudioTrack3 = NativeAudioTrack.this;
                        int i3 = nativeAudioTrack3.mFill;
                        if (i3 > 0) {
                            try {
                                AudioTrack audioTrack2 = nativeAudioTrack3.mAudioTrack;
                                byte[] bArr = NativeAudioTrack.this.mAudioBuffer;
                                NativeAudioTrack nativeAudioTrack4 = NativeAudioTrack.this;
                                int i4 = nativeAudioTrack4.mWriteLength;
                                iWrite = audioTrack2.write(bArr, i4, nativeAudioTrack4.mFill - i4);
                            } catch (Exception unused) {
                                Log.i(NativeAudioTrack.TAG, "mAudioTrack write get Exception");
                                iWrite = 0;
                            }
                            if (iWrite < 0) {
                                NativeAudioTrack nativeAudioTrack5 = NativeAudioTrack.this;
                                nativeAudioTrack5.mWriteLength = 0;
                                nativeAudioTrack5.mFill = 0;
                            } else {
                                NativeAudioTrack.this.mWriteLength += iWrite;
                                j += (long) iWrite;
                            }
                        } else if (i3 < 0) {
                            if (nativeAudioTrack3.mStartFlag) {
                                try {
                                    long playbackHeadPosition = (j / ((long) i2)) - ((long) NativeAudioTrack.this.mAudioTrack.getPlaybackHeadPosition());
                                    if (playbackHeadPosition > 0) {
                                        long sampleRate = ((playbackHeadPosition * 1000) / ((long) NativeAudioTrack.this.mAudioTrack.getSampleRate())) + 100;
                                        if (sampleRate > 2000) {
                                            sampleRate = 2000;
                                        }
                                        Log.d(NativeAudioTrack.TAG, String.format("before send eof, sleep %d ms to make pcm play over", Long.valueOf(sampleRate)));
                                        try {
                                            Thread.sleep(sampleRate);
                                        } catch (InterruptedException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                                NativeAudioTrack.this._OnComplete();
                            } else {
                                NativeAudioTrack.this.mFill = 0;
                            }
                            NativeAudioTrack.this.mLock.lock();
                            Log.i(NativeAudioTrack.TAG, "fill return negative, read complete, wait to quit mThreadFlag is " + NativeAudioTrack.this.mThreadFlag);
                            if (NativeAudioTrack.this.mThreadFlag) {
                                try {
                                    NativeAudioTrack.this.mWorkCondition.await();
                                } catch (InterruptedException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            NativeAudioTrack.this.mLock.unlock();
                        }
                    }
                }
                Log.i(NativeAudioTrack.TAG, "quit fill thread");
            }
        });
        this.mThread = thread;
        thread.start();
        return 0;
    }

    private void resume() {
        startFadeIn();
        this.mStartFlag = true;
        this.mLock.lock();
        this.mWorkCondition.signal();
        this.mLock.unlock();
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack.play();
            } catch (IllegalStateException unused) {
                Log.i(TAG, "AudioTrack play fail");
            }
        }
    }

    private void setVolume(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.mVolume = f2;
        if (this.mAudioTrack != null) {
            try {
                Log.i(TAG, "setVolume " + this.mVolume);
                AudioTrack audioTrack = this.mAudioTrack;
                float f3 = this.mVolume;
                audioTrack.setStereoVolume(f3, f3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void start() {
        startFadeIn();
        this.mStartFlag = true;
        this.mLock.lock();
        this.mWorkCondition.signal();
        this.mLock.unlock();
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack.play();
            } catch (IllegalStateException unused) {
                Log.i(TAG, "AudioTrack play fail");
            }
        }
    }

    private void startFadeIn() {
        if (this.mNeedFadeInFlag) {
            this.mNeedFadeInFlag = false;
            this.mCurrentVolume = 0;
            AudioTrack audioTrack = this.mAudioTrack;
            if (audioTrack != null) {
                audioTrack.setStereoVolume(0.0f, 0.0f);
            }
            Thread thread = this.mFadeInThread;
            if (thread != null) {
                this.mFadeInThreadRunFlag = false;
                try {
                    thread.join(1000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            Thread thread2 = new Thread(this.mFadeInThreadRunnable);
            this.mFadeInThread = thread2;
            this.mFadeInThreadRunFlag = true;
            thread2.start();
        }
    }

    private void stop() {
        this.mStartFlag = false;
        this.mThreadFlag = false;
        this.mLock.lock();
        this.mWorkCondition.signal();
        this.mLock.unlock();
        Thread thread = this.mThread;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        this.mThread = null;
        Thread thread2 = this.mFadeInThread;
        if (thread2 != null) {
            this.mFadeInThreadRunFlag = false;
            try {
                thread2.join(1000L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        this.mFadeInThread = null;
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack.stop();
                this.mAudioTrack.flush();
                this.mAudioTrack.release();
            } catch (IllegalStateException unused) {
                Log.i(TAG, "AudioTrack stop fail");
            }
            this.mAudioTrack = null;
        }
        this.mWriteLength = 0;
        this.mFill = 0;
    }
}
