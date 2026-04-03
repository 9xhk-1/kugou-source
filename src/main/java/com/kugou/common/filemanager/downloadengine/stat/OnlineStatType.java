package com.kugou.common.filemanager.downloadengine.stat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlineStatType {
    public static final int BACKGROUND_PLAY_SONG_BLOCK = 15;
    public static final int BACKGROUND_PLAY_SONG_SPEED_LIMIT = 14;
    public static final int CHANGE_PROXY = 6;
    public static final int CHANGE_PROXY_IPV6 = 25;
    public static final int CHECK_NAT = 7;
    public static final int CHECK_NAT_IPV6 = 26;
    public static final int CHECK_NAT_IPV6_TEST = 10;
    public static final int CONNECT_PROXY = 5;
    public static final int CONNECT_PROXY_IPV6 = 24;
    public static final int GET_PROXY = 4;
    public static final int GET_PROXY_IPV6 = 23;
    public static final int HTTPS_SUPPORT = 16;
    public static final int HTTP_CONNECT = 18;
    public static final int HTTP_IPV6_CONNECT = 12;
    public static final int HTTP_IPV6_FAIL = 13;
    public static final int HTTP_PRE_CONNECT = 19;
    public static final int KEEP_ALIVE = 3;
    public static final int KEEP_ALIVE_IPV6 = 22;
    public static final int LOGIN = 1;
    public static final int LOGIN_IPV6 = 20;
    public static final int LOGOUT = 2;
    public static final int LOGOUT_IPV6 = 21;
    public static final int NONE = 0;
    public static final int OTHER_DOWNLOAD = 17;
    public static final int PUSH_MODE_DETECT_SPEED = 8;
    public static final int REALTIME_DELAY = 11;
    public static final int SONG_MV_SWITCH_DOMAIN = 9;
}
