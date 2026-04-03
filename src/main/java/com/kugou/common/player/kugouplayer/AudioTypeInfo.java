package com.kugou.common.player.kugouplayer;

/* JADX INFO: loaded from: classes2.dex */
public class AudioTypeInfo {
    public static final int AudioType_CD = 12;
    public static final int AudioType_DOP = 11;
    public static final int AudioType_DSD_DOP = 17;
    public static final int AudioType_DSD_NATIVE = 16;
    public static final int AudioType_DSD_PCM = 18;
    public static final int AudioType_FX_LIVE = 4;
    public static final int AudioType_HIFI = 1;
    public static final int AudioType_IPOD = 2;
    public static final int AudioType_ISO = 13;
    public static final int AudioType_ISO_DOP = 15;
    public static final int AudioType_ISO_NATIVE = 14;
    public static final int AudioType_KTV_LIVE = 8;
    public static final int AudioType_KUQUN_LIVE_AUDIO = 6;
    public static final int AudioType_KUQUN_MUSIC = 5;
    public static final int AudioType_MP3 = 9;
    public static final int AudioType_MV = 7;
    public static final int AudioType_NATIVE = 10;
    public static final int AudioType_NORMAL = 0;
    public static final int AudioType_PCM = 3;
    public int audioType = 0;
    public int fd = 0;
    public int id = 0;
    public int samplerate = 0;
    public int channels = 0;
    public int sampleformat = -1;
    public int firstCacheSize = -1;
    public int totalCacheSize = -1;
    public int playtype = -1;
}
