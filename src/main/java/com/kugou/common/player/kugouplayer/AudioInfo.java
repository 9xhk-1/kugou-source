package com.kugou.common.player.kugouplayer;

/* JADX INFO: loaded from: classes2.dex */
public class AudioInfo {
    public static final int AV_SAMPLE_FMT_DBL = 4;
    public static final int AV_SAMPLE_FMT_DBLP = 9;
    public static final int AV_SAMPLE_FMT_FLT = 3;
    public static final int AV_SAMPLE_FMT_FLTP = 8;
    public static final int AV_SAMPLE_FMT_NB = 10;
    public static final int AV_SAMPLE_FMT_NONE = -1;
    public static final int AV_SAMPLE_FMT_S16 = 1;
    public static final int AV_SAMPLE_FMT_S16P = 6;
    public static final int AV_SAMPLE_FMT_S32 = 2;
    public static final int AV_SAMPLE_FMT_S32P = 7;
    public static final int AV_SAMPLE_FMT_U8 = 0;
    public static final int AV_SAMPLE_FMT_U8P = 5;
    public byte[] _artist = null;
    public byte[] _title = null;
    public byte[] _album = null;
    public byte[] _genre = null;
    public byte[] _comment = null;
    public byte[] _copyright = null;
    public byte[] _mimetype = null;
    public byte[] _codeName = null;
    public long mDuration = 0;
    public int mBitrate = 0;
    public int mSampleRate = 0;
    public int mChannels = 0;
    public int mSample_fmt = -1;

    public static int sampleFmtToBits(int i2) {
        switch (i2) {
            case 0:
            case 5:
                return 8;
            case 1:
            case 6:
                return 16;
            case 2:
            case 3:
            case 7:
            case 8:
                return 32;
            case 4:
            case 9:
                return 64;
            default:
                return 0;
        }
    }
}
