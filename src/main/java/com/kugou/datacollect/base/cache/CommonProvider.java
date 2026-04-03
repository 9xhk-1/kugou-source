package com.kugou.datacollect.base.cache;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.AndroidRuntimeException;
import android.util.Log;
import e.c.c.k.f.a;
import e.c.c.k.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CommonProvider extends ContentProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static UriMatcher f247d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f248f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f249h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f250i = 2;
    public Map<String, a> a;
    public ConcurrentHashMap<String, Uri> b;

    public final a a(Uri uri) {
        a aVar;
        String lastPathSegment = uri.getLastPathSegment();
        synchronized (CommonProvider.class) {
            aVar = this.a.get(lastPathSegment);
            if (aVar == null) {
                try {
                    try {
                        try {
                            aVar = (a) Class.forName(lastPathSegment).newInstance();
                        } catch (ClassNotFoundException e2) {
                            e2.printStackTrace();
                        }
                    } catch (IllegalAccessException e3) {
                        e3.printStackTrace();
                    }
                } catch (InstantiationException e4) {
                    e4.printStackTrace();
                }
                if (aVar == null) {
                    throw new AndroidRuntimeException(lastPathSegment + " cannot be instanced.");
                }
                aVar.f(getContext());
                this.a.put(lastPathSegment, aVar);
            }
        }
        return aVar;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        SQLiteDatabase writableDatabase = ((arrayList == null || arrayList.size() <= 0) ? null : a(arrayList.get(0).getUri())).c().getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentProviderResult[] contentProviderResultArrApplyBatch = super.applyBatch(arrayList);
            writableDatabase.setTransactionSuccessful();
            return contentProviderResultArrApplyBatch;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public void b() {
        if (f247d != null) {
            return;
        }
        UriMatcher uriMatcher = new UriMatcher(-1);
        f247d = uriMatcher;
        uriMatcher.addURI(c.a(), c.a + "/*", f248f);
        f247d.addURI(c.a(), c.b + "/*", f249h);
        f247d.addURI(c.a(), c.c + "/*", f250i);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase writableDatabase = a(uri).c().getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int iBulkInsert = super.bulkInsert(uri, contentValuesArr);
            writableDatabase.setTransactionSuccessful();
            return iBulkInsert;
        } finally {
            try {
                writableDatabase.endTransaction();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final Uri c(Uri uri) {
        String string = uri.toString();
        Uri uri2 = this.b.get(string);
        if (uri2 != null) {
            return uri2;
        }
        String strSubstring = string.substring(0, string.lastIndexOf("/"));
        Uri uri3 = Uri.parse(strSubstring);
        this.b.put(strSubstring, uri3);
        return uri3;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return a(uri).b(c(uri), str, strArr);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return a(uri).d(c(uri));
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return a(uri).e(c(uri), contentValues);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.a = new HashMap(10);
        this.b = new ConcurrentHashMap<>();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        b();
        try {
            a aVarA = a(uri);
            if (f247d.match(uri) == f248f) {
                return aVarA.h(str, strArr2);
            }
            if (f247d.match(uri) == f249h) {
                return aVarA.a(str, strArr2);
            }
            if (f247d.match(uri) != f250i) {
                return aVarA.g(c(uri), strArr, str, strArr2, str2);
            }
            aVarA.j();
            return null;
        } catch (AndroidRuntimeException e2) {
            Log.e("CommonProvider", e2.getMessage());
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return a(uri).i(c(uri), contentValues, str, strArr);
    }
}
