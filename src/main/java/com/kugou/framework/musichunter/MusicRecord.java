package com.kugou.framework.musichunter;

import android.media.AudioRecord;

/* JADX INFO: loaded from: classes2.dex */
public class MusicRecord {
    public static final String FAIL_AUDIO = "fail_audio";
    public static final int TYPE_OTHER_APP_RECORD_ERROR = 2;
    public static final int TYPE_SUCCESS = 1;
    public static final int TYPE_UNKNOW_ERROR = 3;
    public static int samples = 8000;
    private int audioChannelType;
    private AudioRecord audioRecord;
    private AudioQueue mBufferQueue;
    private int mRecordBufferSize;
    private int maxSize;
    private Class<?> noiseSuppressorClazz;
    private int recordType;
    private boolean isRecording = false;
    private int channels = 1;
    private byte[] mAudioRecordLock = new byte[0];
    private byte[] lock = new byte[0];
    private boolean isSaveRecord = false;
    private RecordListener mListener = null;

    public MusicRecord(int i2) {
        this.recordType = i2;
        if (RecordType.isHunterType(i2)) {
            samples = 8000;
        } else {
            samples = 16000;
        }
        init();
    }

    private void changeVolume(byte[] bArr, int i2) {
        RecordListener recordListener = this.mListener;
        if (recordListener == null) {
            return;
        }
        if (bArr == 0) {
            recordListener.onVolumeChanged(0.0d);
            return;
        }
        int i3 = samples / 1000;
        long j = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < i2; i7 += 2) {
            int i8 = bArr[i7];
            if (i8 >= 128) {
                i8 = 256 - i8;
            }
            if (i8 > i5) {
                i5 = i8;
            }
            i6++;
            if (i6 == i3 || i7 + 1 == i2) {
                j += (long) ((i5 == true ? 1 : 0) * (i5 == true ? 1 : 0));
                i4++;
                i5 = 0;
                i6 = 0;
            }
        }
        double dLog1p = 0.1d;
        if (j > 0 && i4 > 0) {
            double d2 = j;
            Double.isNaN(d2);
            double d3 = i4;
            Double.isNaN(d3);
            dLog1p = Math.log1p((d2 * 1.0d) / d3) / Math.log1p(Math.pow(128.0d, 2.0d));
        }
        this.mListener.onVolumeChanged(dLog1p);
    }

    private void clearCache() {
        if (this.mBufferQueue.getmQueueSize() > 0) {
            this.mBufferQueue.clearCache();
        }
    }

    private AudioRecord findUsefulAudioRecord() {
        AudioRecord audioRecord = new AudioRecord(1, samples, this.audioChannelType, 2, this.mRecordBufferSize);
        this.audioRecord = audioRecord;
        if (audioRecord == null || audioRecord.getState() != 1) {
            this.audioRecord = new AudioRecord(7, samples, this.audioChannelType, 2, this.mRecordBufferSize);
        }
        return this.audioRecord;
    }

    private AudioBuffer getData() {
        if (this.isRecording || this.mBufferQueue.getmQueueSize() != 0) {
            return this.mBufferQueue.pop();
        }
        return null;
    }

    private void init() {
        this.mBufferQueue = new AudioQueue();
    }

    private void initAudioRecord() {
        int i2 = this.channels >= 2 ? 12 : 16;
        this.audioChannelType = i2;
        int minBufferSize = AudioRecord.getMinBufferSize(samples, i2, 2);
        this.mRecordBufferSize = minBufferSize;
        if (minBufferSize < 2048) {
            this.mRecordBufferSize = 2048;
            return;
        }
        if (minBufferSize < 4096) {
            this.mRecordBufferSize = 4096;
        } else if (minBufferSize < 8192) {
            this.mRecordBufferSize = 8192;
        } else if (minBufferSize < 16384) {
            this.mRecordBufferSize = 16384;
        }
    }

    private void initNoiseSuppressor() {
        try {
            this.noiseSuppressorClazz = Class.forName("android.media.audiofx.NoiseSuppressor");
        } catch (Exception unused) {
        }
    }

    private void putData(byte[] bArr, int i2) {
        this.mBufferQueue.push(bArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
    
        r6.isRecording = false;
        r7 = r6.mListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        if (r7 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
    
        r7.onRecordError(com.kugou.framework.musichunter.MusicRecord.FAIL_AUDIO);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void record(int r7, boolean r8, boolean r9) {
        /*
            r6 = this;
            r0 = 1
            r6.isRecording = r0
            r6.clearCache()
            int r1 = r6.startAudioRecord(r8)
            if (r1 == r0) goto L34
            int r2 = r6.recordType
            boolean r2 = com.kugou.framework.musichunter.RecordType.isHunterType(r2)
            if (r2 == 0) goto L1a
            int r2 = com.kugou.framework.musichunter.MusicRecord.samples
            r3 = 8000(0x1f40, float:1.121E-41)
            if (r2 == r3) goto L26
        L1a:
            int r2 = r6.recordType
            int r3 = com.kugou.framework.musichunter.RecordType.TYPE_HUMMING
            if (r2 != r3) goto L34
            int r2 = com.kugou.framework.musichunter.MusicRecord.samples
            r3 = 16000(0x3e80, float:2.2421E-41)
            if (r2 != r3) goto L34
        L26:
            r6.stopRecord()
            r1 = 44100(0xac44, float:6.1797E-41)
            com.kugou.framework.musichunter.MusicRecord.samples = r1
            r6.isRecording = r0
            int r1 = r6.startAudioRecord(r8)
        L34:
            r8 = 0
            if (r1 == r0) goto L51
            byte[] r0 = r6.mAudioRecordLock
            monitor-enter(r0)
            android.media.AudioRecord r7 = r6.audioRecord     // Catch: java.lang.Throwable -> L4e
            if (r7 == 0) goto L42
            int r8 = r7.getState()     // Catch: java.lang.Throwable -> L4e
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            r6.stopRecord()
            com.kugou.framework.musichunter.RecordListener r7 = r6.mListener
            if (r7 == 0) goto L4d
            r7.onRecordInitFailure(r8, r1)
        L4d:
            return
        L4e:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            throw r7
        L51:
            com.kugou.framework.libcommon.KGThreadPool r0 = com.kugou.framework.libcommon.KGThreadPool.getInstance()
            com.kugou.framework.musichunter.MusicRecord$2 r1 = new com.kugou.framework.musichunter.MusicRecord$2
            r1.<init>()
            r0.execute(r1)
            int r0 = com.kugou.framework.musichunter.MusicRecord.samples
            int r1 = r6.channels
            int r0 = r0 * r1
            int r0 = r0 * 2
            int r0 = r0 * r7
            r6.maxSize = r0
            r0 = 0
        L6a:
            boolean r1 = r6.isRecording
            r2 = 0
            if (r1 == 0) goto Lae
            int r1 = r6.mRecordBufferSize
            byte[] r1 = new byte[r1]
            byte[] r3 = r6.mAudioRecordLock
            monitor-enter(r3)
            android.media.AudioRecord r4 = r6.audioRecord     // Catch: java.lang.Throwable -> Lab
            if (r4 == 0) goto L81
            int r5 = r6.mRecordBufferSize     // Catch: java.lang.Throwable -> Lab
            int r4 = r4.read(r1, r8, r5)     // Catch: java.lang.Throwable -> Lab
            goto L82
        L81:
            r4 = -1
        L82:
            if (r4 > 0) goto L91
            r6.isRecording = r8     // Catch: java.lang.Throwable -> Lab
            com.kugou.framework.musichunter.RecordListener r7 = r6.mListener     // Catch: java.lang.Throwable -> Lab
            if (r7 == 0) goto L8f
            java.lang.String r8 = "fail_audio"
            r7.onRecordError(r8)     // Catch: java.lang.Throwable -> Lab
        L8f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
            goto Lae
        L91:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
            if (r4 <= 0) goto L99
            int r0 = r0 + r4
            r6.putData(r1, r4)
            goto L9f
        L99:
            if (r4 >= 0) goto L9f
            r6.putData(r2, r4)
            return
        L9f:
            if (r7 <= 0) goto L6a
            int r1 = r6.maxSize
            if (r0 < r1) goto L6a
            if (r9 != 0) goto L6a
            r6.stopRecord(r8)
            goto Lae
        Lab:
            r7 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
            throw r7
        Lae:
            int r7 = r6.mRecordBufferSize
            r6.putData(r2, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.musichunter.MusicRecord.record(int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveRecord() {
        int length;
        AudioBuffer data;
        RecordListener recordListener = this.mListener;
        if (recordListener != null) {
            recordListener.onAudioInit(samples);
        }
        this.isSaveRecord = true;
        while (this.isRecording && (data = getData()) != null) {
            try {
                byte[] data2 = data.getData();
                length = data.getLength();
                if (data2 == null) {
                    break;
                }
                RecordListener recordListener2 = this.mListener;
                if (recordListener2 != null) {
                    recordListener2.onAudioBuffer(data2, length);
                }
                changeVolume(data2, length);
            } catch (Exception e2) {
                RecordListener recordListener3 = this.mListener;
                if (recordListener3 != null) {
                    recordListener3.onRecordError(e2.toString());
                }
            }
        }
        length = 0;
        RecordListener recordListener4 = this.mListener;
        if (recordListener4 != null) {
            recordListener4.onAudioBuffer(null, 0);
        }
        changeVolume(null, 0);
        RecordListener recordListener5 = this.mListener;
        if (recordListener5 != null) {
            if (length < 0) {
                recordListener5.onRecordError("录音出错：" + length);
            } else {
                recordListener5.onRecordComplete(samples, this.channels, 16);
            }
        }
        this.isSaveRecord = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    private int startAudioRecord(boolean z) {
        synchronized (this.lock) {
            if (this.isSaveRecord) {
                try {
                    this.lock.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    return 3;
                }
            }
        }
        synchronized (this.mAudioRecordLock) {
            initAudioRecord();
            try {
                this.audioRecord = findUsefulAudioRecord();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null && audioRecord.getState() == 1) {
                if (z) {
                    tryEnableNoiseSuppressor();
                }
                AudioRecord audioRecord2 = this.audioRecord;
                if (audioRecord2 == null || audioRecord2.getState() != 1) {
                    return 3;
                }
                try {
                    this.audioRecord.startRecording();
                    return this.audioRecord.getRecordingState() != 3 ? 2 : 1;
                } catch (Exception unused) {
                    return 3;
                }
            }
            return 3;
        }
    }

    private void stopAudioRecord(boolean z) {
        synchronized (this.mAudioRecordLock) {
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null && audioRecord.getState() == 1) {
                this.audioRecord.stop();
                this.audioRecord.release();
                this.audioRecord = null;
            }
            if (z) {
                clearCache();
            }
        }
    }

    private void tryEnableNoiseSuppressor() {
        try {
            Class<?> cls = Class.forName("android.media.audiofx.NoiseSuppressor");
            this.noiseSuppressorClazz = cls;
            if (((Boolean) cls.getMethod("isAvailable", new Class[0]).invoke(null, new Object[0])).booleanValue()) {
                this.noiseSuppressorClazz.getMethod("create", Integer.TYPE).invoke(null, (Integer) this.audioRecord.getClass().getMethod("getAudioSessionId", new Class[0]).invoke(this.audioRecord, new Object[0]));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean isNoiseSuppressorAvailable() {
        return this.noiseSuppressorClazz != null;
    }

    public boolean isRecording() {
        return this.isRecording;
    }

    public void setRecordListener(RecordListener recordListener) {
        this.mListener = recordListener;
    }

    public void startRecord() {
        startRecord(0, false, false);
    }

    public void stopRecord(boolean z) {
        this.isRecording = false;
        stopAudioRecord(z);
    }

    public void updateMaxSize(int i2) {
        this.maxSize = samples * this.channels * 2 * i2;
    }

    public void startRecord(final int i2, final boolean z, final boolean z2) {
        stopRecord();
        new Thread(new Runnable() { // from class: com.kugou.framework.musichunter.MusicRecord.1
            @Override // java.lang.Runnable
            public void run() {
                MusicRecord.this.record(i2, z, z2);
            }
        }).start();
    }

    public void stopRecord() {
        stopRecord(true);
    }
}
