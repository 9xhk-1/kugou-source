package com.kugou.common.filemanager.downloadengine.mv;

import android.text.TextUtils;
import com.kugou.common.filemanager.downloadengine.NetLog;
import java.io.File;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes2.dex */
public class MVProxyManager {
    private String cacheDirectory;

    private String buildSavePath(String str) {
        return getCacheDirectory() + str + ".kgtmp";
    }

    private String getCacheDirectory() {
        return this.cacheDirectory;
    }

    private void initCacheDirectory(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.charAt(str.length() - 1) != '/') {
            str = str + '/';
        }
        File file = new File(str);
        if (!file.exists()) {
            if (NetLog.isDebug()) {
                NetLog.d("MVProxy", "MVProxyManager create directory: " + str);
            }
            file.mkdirs();
        }
        this.cacheDirectory = str;
    }

    public String getMVCacheDirectory() {
        return this.cacheDirectory;
    }

    public String getMVSavePath(String str, String str2, String str3) {
        String str4;
        int iIndexOf = str.indexOf(63);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        int iLastIndexOf = str.lastIndexOf(47, iIndexOf);
        if (TextUtils.isEmpty(str2)) {
            return buildSavePath(iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1, iIndexOf) : URLEncoder.encode(str).replace('/', '_'));
        }
        if (TextUtils.isEmpty(str3)) {
            str4 = "";
        } else {
            str4 = "_" + str3;
        }
        int iLastIndexOf2 = str.lastIndexOf(46, iIndexOf);
        if (iLastIndexOf >= 0 && iLastIndexOf2 > iLastIndexOf) {
            str4 = str4 + str.substring(iLastIndexOf2, iIndexOf);
        }
        return buildSavePath(str2 + str4);
    }

    public void init(String str) {
        initCacheDirectory(str);
    }
}
