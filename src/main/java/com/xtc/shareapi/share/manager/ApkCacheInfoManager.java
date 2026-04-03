package com.xtc.shareapi.share.manager;

import android.text.TextUtils;
import com.xtc.log.LogUtil;
import com.xtc.shareapi.share.bean.DbApkInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ApkCacheInfoManager {
    private static final String TAG = "ApkCacheInfoManager";
    private static final LinkedHashMap<String, DbApkInfo> apkInfoCache = new LinkedHashMap<>();
    private static volatile ApkCacheInfoManager instance;

    private ApkCacheInfoManager() {
    }

    public static ApkCacheInfoManager getInstance() {
        if (instance == null) {
            synchronized (ShareSupportManager.class) {
                if (instance == null) {
                    instance = new ApkCacheInfoManager();
                }
            }
        }
        return instance;
    }

    public synchronized Map<String, DbApkInfo> getApkInfoCache() {
        return apkInfoCache;
    }

    public synchronized boolean updateApkInfoCache(List<DbApkInfo> list) {
        try {
            apkInfoCache.clear();
            for (DbApkInfo dbApkInfo : list) {
                if (dbApkInfo != null) {
                    String packageName = dbApkInfo.getPackageName();
                    if (TextUtils.isEmpty(packageName)) {
                        LogUtil.w(TAG, "updateApkInfoCache packageName is null");
                    } else {
                        apkInfoCache.put(packageName, dbApkInfo);
                    }
                }
            }
        } catch (Exception e2) {
            LogUtil.e(TAG, "updateApkInfoCache error", e2);
        }
        return true;
    }
}
