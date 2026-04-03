package com.kugou.framework.musichunter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.kugou.framework.libcommon.KGThreadPool;
import com.kugou.framework.musichunter.MusicHunter;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class Global {
    public static final int CLIENT_VER = 11350;
    public static boolean DEBUG = false;
    private static final String FOLDER_NAME = "/kugou/.fp/";
    private static final String KEY_AREA_CODE = "area_code";
    private static final String KEY_ENABLE_FC = "enable_fc";
    private static final String KEY_ENABLE_SECOND_LEVER = "enable_second_lever";
    public static String MUSIC_RADAR_CACHE_DIR = null;
    public static final String SP_NAME = "tgsq_sdk";
    public static final boolean TEST_BLOCK_FIRST_LEVER = false;
    public static String appId = null;
    public static String appKey = null;
    public static String area_code = "1";
    public static boolean enableFC = true;
    public static boolean enableSecondLever = true;
    public static MusicHunter.Config globalConfig;

    @SuppressLint({"StaticFieldLeak"})
    public static Context globalContext;
    public static String plat;

    public static void createDirectory(Context context) {
        MUSIC_RADAR_CACHE_DIR = context.getExternalFilesDir(null) + FOLDER_NAME;
        File file = new File(MUSIC_RADAR_CACHE_DIR);
        if (file.exists()) {
            return;
        }
        try {
            file.mkdirs();
        } catch (Exception unused) {
        }
    }

    public static boolean enableAndroidId() {
        MusicHunter.Config config = globalConfig;
        return config != null && config.canAccessDeviceId();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Context getGlobalContext() {
        return globalContext;
    }

    public static boolean hasInit() {
        return (TextUtils.isEmpty(appId) || TextUtils.isEmpty(appKey)) ? false : true;
    }

    public static void init(final Context context, String str, String str2, MusicHunter.Config config) {
        globalContext = context.getApplicationContext();
        globalConfig = config;
        appId = str;
        appKey = str2;
        plat = str;
        final SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, 0);
        area_code = sharedPreferences.getString(KEY_AREA_CODE, "1");
        enableFC = sharedPreferences.getBoolean(KEY_ENABLE_FC, true);
        enableSecondLever = sharedPreferences.getBoolean(KEY_ENABLE_SECOND_LEVER, true);
        BIDelegate.init(context, str, DEBUG);
        KGThreadPool.getInstance().execute(new Runnable() { // from class: com.kugou.framework.musichunter.Global.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CheckChinaIPResult checkChinaIPResultCheckCanUseNetService = CheckChinaIPProtocol.checkCanUseNetService(context);
                    if (checkChinaIPResultCheckCanUseNetService.getNetError() == 0) {
                        Global.area_code = checkChinaIPResultCheckCanUseNetService.getAreaCode();
                        sharedPreferences.edit().putString(Global.KEY_AREA_CODE, Global.area_code).apply();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public static boolean isDebugModel() {
        return DEBUG;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setDebugModel(boolean z) {
        DEBUG = z;
    }

    public static void setMusicHunterCacheDir(String str) {
        try {
            if (new File(str).isFile()) {
                Log.e(MusicHunter.TAG, "设置路径错误，请设置一个目录", new IllegalArgumentException("文件路径错误, 请设置一个目录"));
                return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        MUSIC_RADAR_CACHE_DIR = str + FOLDER_NAME;
    }
}
