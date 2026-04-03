package com.xtc.cardwidget.external.card.serviceLayer;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.xtc.cardwidget.external.channel.client.provider.ChannelClientProvider;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import e.g.b.b;
import f.j;
import f.k;
import f.s;
import f.u.g0;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class BaseCardStrategyProvider extends ChannelClientProvider {
    public PackageManager a;
    public final Set<Integer> b = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f278d = g0.a(OpenApiConstant.App.LAUNCHER, "com.xtc.cardwidget.server.demo");

    public final boolean a() {
        String nameForUid;
        Context applicationContext;
        int callingUid = Binder.getCallingUid();
        if (this.b.contains(Integer.valueOf(callingUid))) {
            return true;
        }
        if (callingUid == Process.myUid() || callingUid == 1000 || this.f278d.contains(getCallingPackage())) {
            this.b.add(Integer.valueOf(callingUid));
            return true;
        }
        Object objA = null;
        if (this.a == null) {
            Context context = getContext();
            this.a = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getPackageManager();
        }
        try {
            j.a aVar = j.a;
            PackageManager packageManager = this.a;
            if (packageManager != null && (nameForUid = packageManager.getNameForUid(callingUid)) != null) {
                if ((packageManager.getApplicationInfo(nameForUid, 0).flags & 1) == 1) {
                    this.b.add(Integer.valueOf(callingUid));
                }
                objA = s.a;
            }
            j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = j.a;
            objA = k.a(th);
            j.a(objA);
        }
        Throwable thB = j.b(objA);
        if (thB != null) {
            b.a.b("BaseCardStrategyProvider", f.z.d.j.l("checkPermission:e: ", thB));
        }
        b.a.d("BaseCardStrategyProvider", f.z.d.j.l("checkPermission:result: ", Boolean.FALSE));
        return false;
    }

    public final <T> T b(T t) {
        b.a.b("BaseCardStrategyProvider", "call permission limit !");
        return t;
    }

    @Override // com.xtc.cardwidget.external.channel.client.provider.ChannelClientProvider, android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        f.z.d.j.e(str, "method");
        if (a()) {
            return super.call(str, str2, bundle);
        }
        b(null);
        return (Bundle) null;
    }

    @Override // com.xtc.cardwidget.external.channel.client.provider.ChannelClientProvider, android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        f.z.d.j.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (a()) {
            return super.delete(uri, str, strArr);
        }
        b(0);
        return ((Number) 0).intValue();
    }

    @Override // com.xtc.cardwidget.external.channel.client.provider.ChannelClientProvider, android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        f.z.d.j.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (a()) {
            return super.insert(uri, contentValues);
        }
        b(null);
        return (Uri) null;
    }

    @Override // com.xtc.cardwidget.external.channel.client.provider.ChannelClientProvider, android.content.ContentProvider
    public boolean onCreate() {
        String packageName;
        Context context = getContext();
        if (context != null && (packageName = context.getPackageName()) != null) {
            this.f278d.add(packageName);
        }
        return super.onCreate();
    }

    @Override // com.xtc.cardwidget.external.channel.client.provider.ChannelClientProvider, android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        f.z.d.j.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (a()) {
            return super.query(uri, strArr, str, strArr2, str2);
        }
        b(null);
        return (Cursor) null;
    }

    @Override // com.xtc.cardwidget.external.channel.client.provider.ChannelClientProvider, android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        f.z.d.j.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (a()) {
            return super.update(uri, contentValues, str, strArr);
        }
        b(0);
        return ((Number) 0).intValue();
    }
}
