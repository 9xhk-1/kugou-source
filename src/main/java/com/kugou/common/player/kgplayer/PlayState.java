package com.kugou.common.player.kgplayer;

/* JADX INFO: loaded from: classes2.dex */
public interface PlayState {
    public static final int KGMC_STATUS_BUFFERING_END = 1;
    public static final int KGMC_STATUS_BUFFERING_START = 0;
    public static final int KGMC_STATUS_IDLE = -1;
    public static final int KGMC_STATUS_SeekCompletion = 3;
    public static final int KGMC_STATUS_SeekTo = 2;
    public static final int KGMC_STATUS_SpeedChange = 4;
    public static final int KPLAYER_CMD_PLAY_MUTE = 2;
    public static final int KPLAYER_CMD_PLAY_UNMUTE = 3;
    public static final int KPLAYER_CMD_RECEIVE_AUDIO_ONLY = 0;
    public static final int KPLAYER_CMD_RECEIVE_AUDIO_VIDEO = 1;
    public static final int KPLAYER_ERROR_BROKEN_FILE = 2;
    public static final int KPLAYER_ERROR_CONNECT_FAILED = 5;
    public static final int KPLAYER_ERROR_DATASOURCE = 4;
    public static final int KPLAYER_ERROR_INIT_AUDIOPLAYER_FAIL = 24;
    public static final int KPLAYER_ERROR_NONE = 0;
    public static final int KPLAYER_ERROR_NOSTREAM = 6;
    public static final int KPLAYER_ERROR_NO_AUDIO = 3;
    public static final int KPLAYER_ERROR_NO_SUCH_FILE = 1;
    public static final int KPLAYER_ERROR_UNKNOWN = 7;
    public static final int KPLAYER_ErrorCode_1005 = 1005;
    public static final int KPLAYER_ErrorCode_1008 = 1008;
    public static final int KPLAYER_ErrorCode_1029 = 1029;
    public static final int KPLAYER_ErrorCode_1030 = 1030;
    public static final int KPLAYER_ErrorCode_1031 = 1031;
    public static final int KPLAYER_INFO_AUDIOTRACK_WRITE_STUCK = 1000;
    public static final int KPLAYER_INFO_BUFFERING_END = 1;
    public static final int KPLAYER_INFO_BUFFERING_START = 0;
    public static final int KPLAYER_INFO_DECODE_STUCK = 1002;
    public static final int KPLAYER_INFO_READ_DATA_AND_EFFECT_STUCK = 1001;
    public static final int KPLAYER_INFO_STARTPLAYING = 2;
    public static final int KPLAYER_STATUS_ERROR = 7;
    public static final int KPLAYER_STATUS_IDLE = 0;
    public static final int KPLAYER_STATUS_INITIALIZED = 2;
    public static final int KPLAYER_STATUS_INITIALIZING = 1;
    public static final int KPLAYER_STATUS_PAUSE = 6;
    public static final int KPLAYER_STATUS_PLAYING = 5;
    public static final int KPLAYER_STATUS_PREPARED = 4;
    public static final int KPLAYER_STATUS_PREPARING = 3;
    public static final int KPLAYER_STATUS_STOP = 8;
}
