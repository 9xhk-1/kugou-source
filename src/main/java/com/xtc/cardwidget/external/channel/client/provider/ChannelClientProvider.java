package com.xtc.cardwidget.external.channel.client.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import defpackage.c;
import e.g.a.b.b.a.d;
import e.g.b.b;
import f.s;
import f.z.d.j;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ChannelClientProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        s sVar;
        j.e(str, "method");
        if (!j.a(str, "pull") || c.a(str2)) {
            b.a.b("ChannelClientProvider", "on called failed with: method = " + str + ", arg = " + ((Object) str2));
            return null;
        }
        Iterator<d> it = e.g.a.b.b.a.c.a.c().iterator();
        j.d(it, "ClientChannel.clients.iterator()");
        d dVar = null;
        while (it.hasNext()) {
            d next = it.next();
            if (j.a(next.i(), str2)) {
                dVar = next;
            }
        }
        if (dVar == null) {
            sVar = null;
        } else {
            dVar.n();
            sVar = s.a;
        }
        if (sVar == null) {
            b.a.b("ChannelClientProvider", j.l("on called failed with: client name: ", str2));
        }
        return null;
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
