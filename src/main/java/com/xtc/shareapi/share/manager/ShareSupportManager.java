package com.xtc.shareapi.share.manager;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.xtc.log.LogUtil;
import com.xtc.secretapi.XTCGetUtil;
import com.xtc.shareapi.share.bean.DbApkInfo;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IObserverChangeListener;
import com.xtc.utils.common.CollectionUtil;
import com.xtc.utils.encode.JSONUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ShareSupportManager {
    private static final String TAG = "ShareSupportManager";
    private static final String XTCSERVICE_PACKAGE_NAME = "com.xtc.xws";
    private static volatile ShareSupportManager instance;
    private final Context context;
    private boolean isRegisterObserver;
    private final ContentResolver mContentResolver;
    private final IObserverChangeListener mObserverChangeListener = new IObserverChangeListener() { // from class: e.g.d.a.a.a
        @Override // com.xtc.shareapi.share.interfaces.IObserverChangeListener
        public final void onApkObserverChange(Uri uri) {
            this.a.b(uri);
        }
    };
    private final ContentObserver mConversationObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xtc.shareapi.share.manager.ShareSupportManager.2
        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            ShareSupportManager.this.mObserverChangeListener.onApkObserverChange(uri);
        }
    };

    private ShareSupportManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.mContentResolver = applicationContext.getContentResolver();
        registerContentObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Uri uri) {
        String string = uri.toString();
        if (TextUtils.isEmpty(string)) {
            Log.e(TAG, "IObserverChangeListener.onApkObserverChange: url is empty.");
            return;
        }
        Log.i(TAG, "IObserverChangeListener.onApkObserverChange: " + string);
        if (string.contains(OpenApiConstant.ShareSupport.URI_UPDATE_APK_INFO)) {
            ShareHandlerUtil.runOnBackground(new Runnable() { // from class: com.xtc.shareapi.share.manager.ShareSupportManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Log.i(ShareSupportManager.TAG, "init#onNext: init = " + ShareSupportManager.this.init());
                    } catch (Exception e2) {
                        Log.e(ShareSupportManager.TAG, "init#onError", e2);
                    }
                }
            });
        }
    }

    private String getApkCertificate(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Log.i(TAG, "getApkCertificate: packageName is null.");
            return null;
        }
        DbApkInfo dbApkInfo = ApkCacheInfoManager.getInstance().getApkInfoCache().get(str);
        if (dbApkInfo != null) {
            return z ? dbApkInfo.getCertificateList() : dbApkInfo.getCertificate();
        }
        Log.i(TAG, "getApkCertificate: apkInfoCache don't has packageName " + str);
        return null;
    }

    private int getCertificateVersion(Context context) {
        try {
            int i2 = context.getPackageManager().getApplicationInfo(XTCSERVICE_PACKAGE_NAME, 128).metaData.getInt(OpenApiConstant.App.META_DATA_XTCSERVICE_VERSION);
            LogUtil.i(TAG, "getCertificateVersion = " + i2);
            return i2;
        } catch (PackageManager.NameNotFoundException e2) {
            LogUtil.e(TAG, "getCertificateVersion error = " + e2);
            return -1;
        }
    }

    public static ShareSupportManager getInstance(Context context) {
        if (instance == null) {
            synchronized (ShareSupportManager.class) {
                if (instance == null) {
                    instance = new ShareSupportManager(context);
                }
            }
        }
        return instance;
    }

    private int isSupportShareFunctionOld(String str) {
        LogUtil.i(TAG, "isSupportShareFunctionOld");
        String apkCertificate = getApkCertificate(str, false);
        if (TextUtils.isEmpty(apkCertificate)) {
            LogUtil.e(TAG, "Verification failed, old signature does not exist.");
            return 2;
        }
        if (TextUtils.equals(XTCGetUtil.init(this.context, apkCertificate, str), XTCGetUtil.gete())) {
            LogUtil.i(TAG, "old Verification succeeded.");
            return 1;
        }
        LogUtil.e(TAG, "Verification failed, old signature inconsistent.");
        return 3;
    }

    private List<DbApkInfo> queryAllApkInfo() {
        ContentResolver contentResolver = this.mContentResolver;
        if (contentResolver == null) {
            Log.w(TAG, "mContentResolver == null");
            return null;
        }
        Cursor cursorQuery = contentResolver.query(Uri.parse(OpenApiConstant.ShareSupport.URI_QUERY_ALL_APK_INFO), null, null, null, null);
        if (cursorQuery == null) {
            Log.w(TAG, "queryAllApkInfo, cursor is null");
            return null;
        }
        List<DbApkInfo> arrayList = new ArrayList<>();
        if (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(0);
            if (TextUtils.isEmpty(string)) {
                Log.w(TAG, "queryAllApkInfo, cursorString is empty");
            } else {
                arrayList = JSON.parseArray(string, DbApkInfo.class);
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    private void registerContentObserver() {
        if (this.isRegisterObserver) {
            Log.d(TAG, "registerContentObserver fail: isRegisterObserver = true");
            return;
        }
        try {
            this.mContentResolver.registerContentObserver(Uri.parse(OpenApiConstant.ShareSupport.URI_UPDATE_APK_INFO), true, this.mConversationObserver);
            this.isRegisterObserver = true;
            Log.d(TAG, "registerContactObserver successful");
        } catch (RuntimeException e2) {
            Log.e(TAG, "registerContactObserver failure", e2);
        }
    }

    public boolean init() {
        List<DbApkInfo> listQueryAllApkInfo = queryAllApkInfo();
        if (listQueryAllApkInfo != null && listQueryAllApkInfo.size() != 0) {
            return ApkCacheInfoManager.getInstance().updateApkInfoCache(listQueryAllApkInfo);
        }
        Log.e(TAG, "init: dbApkInfoList is null.");
        return false;
    }

    @OpenApiConstant.ShareSupport
    public int isSupportShareFunction(String str) {
        if (TextUtils.equals(XTCGetUtil.init(this.context, "06A2FDC33830396B3BA5F31DA0D1BDEA40713C58", str), XTCGetUtil.gete())) {
            LogUtil.i(TAG, "Verification ps succeeded.");
            return 1;
        }
        if (ApkCacheInfoManager.getInstance().getApkInfoCache().size() == 0) {
            Log.i(TAG, "uninitialized.");
            return 0;
        }
        if (getCertificateVersion(this.context) < 1) {
            return isSupportShareFunctionOld(str);
        }
        List list = (List) JSONUtil.toCollection(getApkCertificate(str, true), List.class, new Class[]{String.class});
        if (CollectionUtil.isEmpty(list)) {
            LogUtil.e(TAG, "Verification failed, signature does not exist.");
            return 2;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(XTCGetUtil.init(this.context, (String) it.next(), str), XTCGetUtil.gete())) {
                LogUtil.i(TAG, "Verification succeeded.");
                return 1;
            }
        }
        LogUtil.e(TAG, "Verification failed, signature inconsistent.");
        return 3;
    }
}
