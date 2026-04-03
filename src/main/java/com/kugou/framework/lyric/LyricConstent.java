package com.kugou.framework.lyric;

/* JADX INFO: loaded from: classes2.dex */
public class LyricConstent {
    public static final String HEAD_CONTENT_TYPE_CHINESE = "2";
    public static final String HEAD_CONTENT_TYPE_TRANSLATION = "1";
    public static final String HEAD_CONTENT_TYPE_TRANSLITERATION = "0";
    public static final String HEAD_LANGUAGE_TYPE_CHINESE = "0";
    public static final String HEAD_LANGUAGE_TYPE_ENGLISH = "3";
    public static final String HEAD_LANGUAGE_TYPE_JAPANESE = "2";
    public static final String HEAD_LANGUAGE_TYPE_KOREAN = "1";
    public static final int LYRIC_ANIMATION_LINE_ZOOM = 3;
    public static final int LYRIC_ANIMATION_NONE = 1;
    public static final int LYRIC_ANIMATION_SCALE = 2;
    public static final int LYRIC_CHANGE_ROW_INTERVAL = 500;
    public static final long LYRIC_REFRESH_INTERVAL = 60;
    public static final int LYRIC_ROLL_BACK_INTERVAL = 500;
    public static final int LYRIC_SCROLL_BY_DIFF_INTERVAL = 300;
    public static final float LYRIC_SCROLL_FRICTION = 0.02f;
    public static final int MAX_ROW_CONUT = -1;
    public static final String REG_CONTENT_INFO = "\\[(0|[1-9]\\d*),(0|[1-9]\\d*)\\](<(0|[1-9]\\d*),(0|[1-9]\\d*),(0|[1-9]\\d*)>([^<]*))*";
    public static final String REG_HEAD_INFO = "\\[(id|ar|ti|by|hash|total|sign|offset|al|re|ve|language):(.*)\\]";
    public static final String REG_LINE_CONTENT = "\\[(0|[1-9]\\d*),(0|[1-9]\\d*)\\]";
    public static final String REG_WORD_CONTENT = "<(0|[1-9]\\d*),(0|[1-9]\\d*),(0|[1-9]\\d*)>([^<|^\\r\\n|^\\n]*)";
    public static final int SCROLL_TIME_NOTICE_DELAY = 3000;
    public static final short TYPE_KRC = 1;
    public static final short TYPE_LRC = 2;
    public static final short TYPE_TXT = 3;
    public static final char[] magic = {'@', 'G', 'a', 'w', '^', '2', 't', 'G', 'Q', '6', '1', '-', 206, 210, 'n', 'i'};
    public static String defaultMsg = "酷狗音乐  就是歌多";
}
