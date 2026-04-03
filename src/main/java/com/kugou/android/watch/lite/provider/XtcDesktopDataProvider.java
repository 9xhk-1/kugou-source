package com.kugou.android.watch.lite.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.common.apm.sdk.ApmDataKey;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.e.b;
import e.c.a.g.a.m.a;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class XtcDesktopDataProvider extends ContentProvider {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "method"
            f.z.d.j.e(r8, r0)
            int r0 = r8.hashCode()
            java.lang.String r1 = "nextSong"
            java.lang.String r2 = "togglePlay"
            java.lang.String r3 = "prevSong"
            r4 = 1
            switch(r0) {
                case -1274431000: goto L2f;
                case -852561752: goto L27;
                case -130906602: goto L1d;
                case 1424376488: goto L15;
                default: goto L13;
            }
        L13:
            goto Lab
        L15:
            boolean r0 = r8.equals(r1)
            if (r0 != 0) goto L37
            goto Lab
        L1d:
            java.lang.String r0 = "updateProgress"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L37
            goto Lab
        L27:
            boolean r0 = r8.equals(r2)
            if (r0 != 0) goto L37
            goto Lab
        L2f:
            boolean r0 = r8.equals(r3)
            if (r0 != 0) goto L37
            goto Lab
        L37:
            e.c.a.g.a.f.m.c r0 = e.c.a.g.a.f.m.c.a
            java.lang.String r5 = "sp_key_show_privacy"
            boolean r0 = r0.e(r5, r4)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r0)
            java.lang.String r6 = "checkCommon, show = "
            java.lang.String r5 = f.z.d.j.l(r6, r5)
            java.lang.String r6 = "XtcDesktopDataProvider"
            e.c.a.g.a.s.g0.c(r6, r5)
            r5 = 0
            if (r0 == 0) goto L5c
            e.c.a.g.a.m.a r8 = e.c.a.g.a.m.a.a
            r8.e()
            java.lang.String r8 = "checkCommon, 请先同意隐私政策."
            android.util.Log.e(r6, r8)
            return r5
        L5c:
            boolean r0 = e.c.a.g.a.d.x.f.o()
            if (r0 != 0) goto L74
            boolean r8 = e.c.a.g.a.d.x.f.o()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            java.lang.String r0 = "call() -> 未初始化播放器无法操作 importance call but not isInitialized, PlayerController.isInitialized() = "
            java.lang.String r8 = f.z.d.j.l(r0, r8)
            android.util.Log.e(r6, r8)
            return r5
        L74:
            boolean r0 = f.z.d.j.a(r8, r2)
            if (r0 != 0) goto L89
            boolean r0 = f.z.d.j.a(r8, r1)
            if (r0 != 0) goto L89
            boolean r8 = f.z.d.j.a(r8, r3)
            if (r8 == 0) goto L87
            goto L89
        L87:
            r8 = 0
            goto L8a
        L89:
            r8 = 1
        L8a:
            if (r8 == 0) goto L9a
            r8 = 700(0x2bc, float:9.81E-43)
            boolean r8 = e.c.a.g.a.s.u1.h(r8)
            if (r8 == 0) goto L9a
            java.lang.String r8 = "call() -> 点击事件过快"
            android.util.Log.e(r6, r8)
            return r5
        L9a:
            boolean r8 = e.c.a.g.a.d.x.f.r()
            if (r8 == 0) goto Lab
            e.c.a.g.a.m.a r8 = e.c.a.g.a.m.a.a
            r8.e()
            java.lang.String r8 = "checkCommon, 队列为空，打开app."
            android.util.Log.e(r6, r8)
            return r5
        Lab:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.provider.XtcDesktopDataProvider.a(java.lang.String):boolean");
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        int i2;
        j.e(str, "method");
        Log.e("XtcDesktopDataProvider", "call method: " + str + " extras: " + bundle + " arg: " + ((Object) str2));
        if (j.a(str, "openapp")) {
            b.b(new YoungBITask(22020023, "click").setSvar1("1").setMixsongid(a.a.a()));
            return super.call(str, str2, bundle);
        }
        if (!a(str)) {
            Log.d("XtcDesktopDataProvider", "call checkCommon false");
            return super.call(str, str2, bundle);
        }
        if (j.a(str, "updateProgress")) {
            Log.d("XtcDesktopDataProvider", "call() -> progressChange");
            String string = bundle == null ? null : bundle.getString("current");
            String string2 = bundle == null ? null : bundle.getString("max");
            Log.d("XtcDesktopDataProvider", "call() -> progressChange: max progress is " + ((Object) string2) + " current progress is " + ((Object) string));
            if (string != null) {
                try {
                    int i3 = Integer.parseInt(string);
                    if (string2 != null) {
                        a.a.g(i3, Integer.parseInt(string2));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            b.b(new YoungBITask(22020023, "click").setSvar1("2").setMixsongid(a.a.a()));
        }
        if (j.a(str, "togglePlay")) {
            Log.d("XtcDesktopDataProvider", "call() -> pausePlayer");
            String string3 = bundle != null ? bundle.getString(ApmDataKey.STATE) : null;
            if (f.q()) {
                f.t();
                i2 = 1;
            } else {
                f.x();
                i2 = 2;
            }
            if (bundle != null && bundle.getString(ApmDataKey.STATE) != null) {
                Log.d("XtcDesktopDataProvider", j.l("call() -> pausePlayer: state is ", string3));
            }
            e.g.a.a.a.a.a.b(i2);
            if (i2 == 1) {
                b.b(new YoungBITask(22020023, "click").setSvar1("5").setMixsongid(a.a.a()));
            } else {
                b.b(new YoungBITask(22020023, "click").setSvar1("6").setMixsongid(a.a.a()));
            }
        }
        if (j.a(str, "nextSong")) {
            Log.d("XtcDesktopDataProvider", "call() -> pausePlayer");
            f.s();
            b.b(new YoungBITask(22020023, "click").setSvar1("4").setMixsongid(a.a.a()));
        }
        if (j.a(str, "prevSong")) {
            Log.d("XtcDesktopDataProvider", "call() -> prevSong");
            f.B();
            b.b(new YoungBITask(22020023, "click").setSvar1("3").setMixsongid(a.a.a()));
        }
        return super.call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        j.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        j.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        j.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        j.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        j.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return 0;
    }
}
