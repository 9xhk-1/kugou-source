package com.kugou.common.filemanager.downloadengine.entity;

/* JADX INFO: loaded from: classes2.dex */
public class FileManagerErrorCode {
    public static final int ACCESS_DB_ERROR = 10;
    public static final int ALREADY_DOWNLOADED = 200;
    public static final int ALREADY_DOWNLOADING = 201;
    public static final int CALL_ENGINE_FUNCTION_FAILED = 9;
    public static final int CANT_CREATE_TARGET_FILE = 17;
    public static final int CANT_DOWNLOAD_LOCAL_FILE = 5;
    public static final int DOWNLOAD_URL_TRACKER_FAILED = 6;
    public static final int ENGINE_BAD_CRYPTED_FILE = 137;
    public static final int ENGINE_CANT_CREATE_FILE = 104;
    public static final int ENGINE_CANT_CREATE_TARGET_FILE = 133;
    public static final int ENGINE_CANT_CRYPT_FILE = 135;
    public static final int ENGINE_CANT_DECRYPT_FILE = 136;
    public static final int ENGINE_CANT_OPEN_FILE = 119;
    public static final int ENGINE_CANT_OPEN_SOURCE_FILE = 131;
    public static final int ENGINE_CANT_READ_FILE = 106;
    public static final int ENGINE_CANT_READ_SOURCE_FILE = 132;
    public static final int ENGINE_CANT_WRITE_FILE = 105;
    public static final int ENGINE_CANT_WRITE_TARGET_FILE = 134;
    public static final int ENGINE_CHECK_SUM_ERROR = 117;
    public static final int ENGINE_CLOSE_STREAM_BY_DELETE = 110;
    public static final int ENGINE_CLOSE_STREAM_BY_STOP = 107;
    public static final int ENGINE_CREATE_PROTOCOL_ERROR = 125;
    public static final int ENGINE_DISK_FULL = 115;
    public static final int ENGINE_DNS_RESOLVE_ERROR = 111;
    public static final int ENGINE_ERROR_ADDER = 100;
    public static final int ENGINE_GET_FILE_SIZE_ERROR = 108;
    public static final int ENGINE_HTTP_CONNECT_ERROR = 112;
    public static final int ENGINE_HTTP_RESOURCE_ERROR = 113;
    public static final int ENGINE_HTTP_STATUS_CODE_ERROR = 114;
    public static final int ENGINE_HUGE_STREAM_CONFLICT = 141;
    public static final int ENGINE_NO_KEY = 101;
    public static final int ENGINE_NO_NETWORK = 109;
    public static final int ENGINE_P2P_FILE_SIZE_CONFLICT = 129;
    public static final int ENGINE_P2P_NO_ENOUGH_SOURCE = 128;
    public static final int ENGINE_P2P_SEAFILE_TIMEOUT = 127;
    public static final int ENGINE_P2P_SEAFILE_TOO_MANY = 126;
    public static final int ENGINE_SEAFILE_AUTH_FAIL = 142;
    public static final int ENGINE_SHOUD_CHANGE_URL = 102;
    public static final int ENGINE_STOP_BY_TRAFFIC_PROECTION = 118;
    public static final int ENGINE_STOP_BY_WIFI_ONLY = 116;
    public static final int ENGINE_TARGET_ALREADY_EXISTS = 130;
    public static final int ENGINE_TIMEOUT = 103;
    public static final int ENGINE_TRACKER_FORBIDDEN = 123;
    public static final int ENGINE_TRACKER_NEEDCHARGE = 122;
    public static final int ENGINE_TRACKER_NO_M4A = 124;
    public static final int ENGINE_USE_COUPOM_BAD_BEHAVIOUR_ERROR = 27;
    public static final int ENGINE_USE_COUPOM_CRASH_ERROR = 26;
    public static final int ENGINE_USE_COUPOM_ERROR = 25;
    public static final int ENGINE_USE_COUPOM_FAIL_ERROR = 28;
    public static final int ENGINE_USE_COUPOM_FAIL_HAS_USED = 31;
    public static final int ENGINE_USE_COUPOM_FAIL_IS_EXPIRED = 30;
    public static final int ENGINE_USE_COUPOM_NOT_EXITS = 29;
    public static final int ENGIN_SEAFILE_FORBIDDEN = 121;
    public static final int ENGIN_SEAFILE_NEEDCHARGE = 120;
    public static final int FILE_CANT_FOUND = 2;
    public static final int IP_LIMIT = 16;
    public static final int JOB_WRONG_ID = 3;
    public static final int JOB_WRONG_STATE = 8;
    public static final int NEED_TRACKER_URL = 202;
    public static final int OK = 0;
    public static final int PARAMETER_INVALID = 1;
    public static final int RUNTIME_ERROR = 4;
    public static final int SPACE_NOT_ENOUGH = 7;
    public static final int TEMP_FILE_UNEXPECTED_REMOVED = 12;
    public static final int TRACKER_AUTHORIZE_FAIL = 18;
    public static final int TRACKER_BAD_KEY = 22;
    public static final int TRACKER_FORBIDDEN = 19;
    public static final int TRACKER_GRAY_LIST_MUSIC = 32;
    public static final int TRACKER_INVALID_HUGE_FILE_INFO = 24;
    public static final int TRACKER_M4A_NOTFOUND = 20;
    public static final int TRACKER_NO_HASH = 13;
    public static final int TRACKER_NO_URLS = 15;
    public static final int TRACKER_OTHER_ERROR = 14;
    public static final int TRACKER_PRIVILEGE_NETERROR = 21;
    public static final int TRACKER_SERVERINTERNALERROR = 23;
    public static final int UNKNOWN_ERROR = 11;

    public static boolean isP2PError(int i2) {
        if (i2 == 103) {
            return true;
        }
        switch (i2) {
            case 126:
            case 127:
            case 128:
            case ENGINE_P2P_FILE_SIZE_CONFLICT /* 129 */:
                return true;
            default:
                return false;
        }
    }
}
