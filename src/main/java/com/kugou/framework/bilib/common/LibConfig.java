package com.kugou.framework.bilib.common;

import android.content.Context;
import com.kugou.framework.bilib.LibLog;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LibConfig {
    private static Context sContext;
    private static boolean sDebug;
    private static LibConfig sInstance;

    public static Context getContext() {
        return sContext;
    }

    public static LibConfig getInstance() {
        return sInstance;
    }

    public static String getOs() {
        return "1005";
    }

    public static void init(Context context, LibConfig libConfig, boolean z) {
        sContext = context;
        sInstance = libConfig;
        sDebug = z;
        LibLog.DEBUG = z;
        HttpAdapter.init();
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public String getAllPluginDescription() {
        return "00";
    }

    public String getApmUrl() {
        return "http://rt-m.kugou.com/";
    }

    public abstract String getAppId();

    public abstract String getAppKey();

    public String getBaseHost2() {
        return "/";
    }

    public abstract int getBiConfigKey();

    public String getChannelID() {
        return "0";
    }

    public abstract String getMid(Context context);

    public int getMoonType() {
        return 0;
    }

    public long getMsgDelay() {
        return 5000L;
    }

    public String getNorUrl() {
        return "http://d.kugou.com/";
    }

    public abstract String getPublicKey();

    public abstract String getUUID();

    public String getUsePatchCode() {
        return "0";
    }

    public String getUserID() {
        return "0";
    }

    public String getVersionCode() {
        return String.valueOf(ShareCloudFileResource.HEIGHT);
    }

    public int getViptype() {
        return 0;
    }

    public boolean isGrayPackage() {
        return false;
    }

    public boolean isOnline() {
        return true;
    }

    public abstract void log(String str, String str2, String str3);
}
