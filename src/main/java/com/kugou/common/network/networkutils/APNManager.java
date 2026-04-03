package com.kugou.common.network.networkutils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes2.dex */
public class APNManager {
    public static Uri CURRENT_PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    public static String[] APN_COLUMN = {"apn"};
    private static boolean sWap = true;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039 A[PHI: r0
  0x0039: PHI (r0v7 android.database.Cursor) = (r0v6 android.database.Cursor), (r0v8 android.database.Cursor) binds: [B:20:0x0037, B:13:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getAPNName(android.content.Context r7) throws java.lang.Throwable {
        /*
            android.content.ContentResolver r0 = r7.getContentResolver()
            r7 = 0
            android.net.Uri r1 = com.kugou.common.network.networkutils.APNManager.CURRENT_PREFERRED_APN_URI     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L32
            java.lang.String[] r2 = com.kugou.common.network.networkutils.APNManager.APN_COLUMN     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L32
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L32
            if (r0 == 0) goto L2a
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L3d
            if (r1 == 0) goto L2a
            java.lang.String r1 = "apn"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L3d
            java.lang.String r7 = r0.getString(r1)     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L3d
            if (r0 == 0) goto L27
            r0.close()
        L27:
            return r7
        L28:
            r1 = move-exception
            goto L34
        L2a:
            if (r0 == 0) goto L3c
            goto L39
        L2d:
            r0 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L3e
        L32:
            r1 = move-exception
            r0 = r7
        L34:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            if (r0 == 0) goto L3c
        L39:
            r0.close()
        L3c:
            return r7
        L3d:
            r7 = move-exception
        L3e:
            if (r0 == 0) goto L43
            r0.close()
        L43:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.networkutils.APNManager.getAPNName(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004b A[PHI: r6
  0x004b: PHI (r6v2 android.database.Cursor) = (r6v1 android.database.Cursor), (r6v4 android.database.Cursor) binds: [B:20:0x0049, B:14:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isWap(android.content.Context r6) {
        /*
            android.content.ContentResolver r0 = r6.getContentResolver()
            r6 = 0
            android.net.Uri r1 = com.kugou.common.network.networkutils.APNManager.CURRENT_PREFERRED_APN_URI     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String[] r2 = com.kugou.common.network.networkutils.APNManager.APN_COLUMN     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r6 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r6 == 0) goto L40
            boolean r0 = r6.moveToFirst()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r0 == 0) goto L40
            java.lang.String r0 = "apn"
            int r0 = r6.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r0 = r6.getString(r0)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r2 = 1
            if (r1 == 0) goto L2c
            com.kugou.common.network.networkutils.APNManager.sWap = r2     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            goto L40
        L2c:
            java.util.Locale r1 = java.util.Locale.US     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r0 = r0.toLowerCase(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r1 = "net"
            boolean r0 = r0.endsWith(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r0 == 0) goto L3e
            r0 = 0
            com.kugou.common.network.networkutils.APNManager.sWap = r0     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            goto L40
        L3e:
            com.kugou.common.network.networkutils.APNManager.sWap = r2     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
        L40:
            if (r6 == 0) goto L4e
            goto L4b
        L43:
            r0 = move-exception
            goto L51
        L45:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L43
            if (r6 == 0) goto L4e
        L4b:
            r6.close()
        L4e:
            boolean r6 = com.kugou.common.network.networkutils.APNManager.sWap
            return r6
        L51:
            if (r6 == 0) goto L56
            r6.close()
        L56:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.networkutils.APNManager.isWap(android.content.Context):boolean");
    }

    public static void printInfo(Context context) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(CURRENT_PREFERRED_APN_URI, null, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        if (context == null) {
                            NetLog.e("sensen", "apn : " + cursorQuery.getString(cursorQuery.getColumnIndex("apn")) + " proxy : " + cursorQuery.getString(cursorQuery.getColumnIndex("proxy")) + " port : " + cursorQuery.getString(cursorQuery.getColumnIndex(ClientCookie.PORT_ATTR)));
                        }
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery == null) {
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery == null) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
