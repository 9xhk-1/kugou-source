package e.c.a.g.a.g.n.h;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.q;
import e.c.a.g.a.s.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    public class a implements MediaScannerConnection.OnScanCompletedListener {
        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            KGApplication.getContext().sendBroadcast(intent);
        }
    }

    public static int a(Context context, String str) {
        Uri contentUriForPath = MediaStore.Audio.Media.getContentUriForPath(str);
        long jA = e.c.a.g.a.g.n.h.a.a(context, str);
        if (jA > 0) {
            return context.getContentResolver().delete(contentUriForPath, "_id=?", new String[]{String.valueOf(jA)});
        }
        return -1;
    }

    public static void b(String str) {
        ContentResolver contentResolver;
        Cursor cursorQuery = null;
        try {
            contentResolver = KGApplication.getContext().getContentResolver();
            cursorQuery = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        } catch (Throwable th) {
            try {
                if (g0.a) {
                    g0.b("SettingUtil", "deleteHistoryIllegalRingtone: ex=" + th);
                }
                if (cursorQuery == null) {
                    return;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(DbOpenHelper.ID));
                if (cursorQuery.getInt(cursorQuery.getColumnIndex("is_ringtone")) == 1) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("relative_path"));
                    if (h1.v(string, -1L) != -1 && string2 != null && string2.contains("Music") && (str == null || !str.contains(string))) {
                        contentResolver.delete(ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, i2), "_id=?", new String[]{String.valueOf(i2)});
                    }
                }
                cursorQuery.moveToNext();
            }
            if (cursorQuery == null) {
                return;
            }
            return;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    public static void c(String str, String str2) {
        ContentResolver contentResolver;
        Cursor cursorQuery = null;
        try {
            contentResolver = KGApplication.getContext().getContentResolver();
            cursorQuery = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        } catch (Throwable th) {
            try {
                if (g0.a) {
                    g0.b("SettingUtil", "deleteHistoryInnerRingtoneUri: ex=" + th);
                }
                if (cursorQuery == null) {
                    return;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                if (string.contains(str)) {
                    String strX = q.x(string);
                    if (TextUtils.isEmpty(strX) || str2.contains(strX)) {
                        g0.b("SettingUtil", "deleteHistoryInnerRingtoneUri: ignore default=" + string);
                    } else {
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(DbOpenHelper.ID));
                        if (i2 > 0) {
                            if (g0.a) {
                                g0.b("SettingUtil", "deleteHistoryInnerRingtoneUri: delete=" + string);
                            }
                            contentResolver.delete(ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, i2), "_id=?", new String[]{String.valueOf(i2)});
                            q.k(string);
                        }
                    }
                }
                cursorQuery.moveToNext();
            }
            if (cursorQuery == null) {
                return;
            }
            return;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    public static void d(String str, String str2) {
        ContentResolver contentResolver;
        Cursor cursorQuery = null;
        try {
            contentResolver = KGApplication.getContext().getContentResolver();
            cursorQuery = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, "relative_path =? ", new String[]{str}, null);
        } catch (Throwable th) {
            try {
                if (g0.a) {
                    g0.b("SettingUtil", "deleteHistoryPublicRingtoneUri: ex=" + th);
                }
                if (cursorQuery == null) {
                    return;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(DbOpenHelper.ID));
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                if (i2 > 0 && !TextUtils.isEmpty(string) && (str2 == null || !str2.contains(string))) {
                    contentResolver.delete(ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, i2), "_id=?", new String[]{String.valueOf(i2)});
                }
                cursorQuery.moveToNext();
            }
            if (cursorQuery == null) {
                return;
            }
            return;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    @Nullable
    public static String e(Context context) {
        Ringtone ringtone;
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(context, 1);
        if (actualDefaultRingtoneUri == null || (ringtone = RingtoneManager.getRingtone(context, actualDefaultRingtoneUri)) == null) {
            return null;
        }
        return ringtone.getTitle(context);
    }

    public static Uri f(ContentValues contentValues) {
        return KGApplication.getContext().getContentResolver().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public static Uri g(String str, String str2) {
        Cursor cursorQuery;
        Uri uriWithAppendedId = null;
        try {
            cursorQuery = KGApplication.getContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, "relative_path =? and _display_name =?", new String[]{str, str2}, null);
        } catch (Throwable th) {
            th = th;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            try {
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (g0.a) {
                        g0.b("SettingUtil", "queryPublicRingtoneUri: ex=" + th);
                    }
                    if (cursorQuery != null) {
                    }
                    return uriWithAppendedId;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery.getCount() == 1) {
                cursorQuery.moveToFirst();
                uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, cursorQuery.getInt(cursorQuery.getColumnIndex(DbOpenHelper.ID)));
                if (cursorQuery != null) {
                }
                return uriWithAppendedId;
            }
            cursorQuery.close();
            return uriWithAppendedId;
        }
        return null;
    }

    public static synchronized boolean h(Context context, b bVar) {
        return i(context, bVar, 3);
    }

    public static boolean i(Context context, b bVar, int i2) {
        if (i2 > 0) {
            int i3 = i2 - 1;
            try {
                if (bVar.b() == null || !new e.c.a.g.a.f.g.a(bVar.b()).exists()) {
                    return false;
                }
                j(context, bVar);
                return true;
            } catch (Error unused) {
                if (i3 > 1) {
                    return i(context, bVar, i3);
                }
                if (i3 == 1) {
                    return o(context, bVar, 1);
                }
            } catch (SecurityException e2) {
                g0.i(e2);
                try {
                    RingBiReportHelper.INSTANCE.reportHead("setCall, se = " + e2.getMessage(), "RingtoneGuideDialog", Boolean.FALSE);
                } catch (Exception unused2) {
                }
            } catch (Exception e3) {
                if (g0.a) {
                    g0.b("SettingUtil", "setCall: ex=" + e3);
                }
                try {
                    RingBiReportHelper.INSTANCE.reportHead("setCall, ex = " + e3.getMessage(), "RingtoneGuideDialog", Boolean.FALSE);
                } catch (Exception unused3) {
                }
                if (i3 > 1) {
                    return i(context, bVar, i3);
                }
                if (i3 == 1) {
                    return o(context, bVar, 1);
                }
            }
        }
        return false;
    }

    public static void j(Context context, b bVar) {
        Uri uriK = k(context, bVar);
        if (uriK != null) {
            RingtoneManager.setActualDefaultRingtoneUri(context, 1, uriK);
        }
    }

    public static Uri k(Context context, b bVar) {
        Uri uriInsert;
        OutputStream outputStreamOpenOutputStream;
        FileInputStream fileInputStream;
        File fileA = bVar.a();
        String absolutePath = fileA.getAbsolutePath();
        String strX = q.x(absolutePath);
        String name = fileA.getName();
        ContentValues contentValues = new ContentValues();
        if (!l1.K()) {
            contentValues.put("_data", absolutePath);
            contentValues.put("title", strX);
            contentValues.put("_display_name", name);
            contentValues.put("mime_type", "audio/*");
            contentValues.put("is_ringtone", Boolean.TRUE);
            Uri contentUriForPath = MediaStore.Audio.Media.getContentUriForPath(absolutePath);
            if (contentUriForPath == null) {
                return null;
            }
            long jA = e.c.a.g.a.g.n.h.a.a(context, absolutePath);
            if (jA > 0) {
                Uri uriWithAppendedId = ContentUris.withAppendedId(contentUriForPath, jA);
                context.getContentResolver().update(contentUriForPath, contentValues, "_id=?", new String[]{String.valueOf(jA)});
                uriInsert = uriWithAppendedId;
            } else {
                uriInsert = context.getContentResolver().insert(contentUriForPath, contentValues);
            }
            if (!g0.a) {
                return uriInsert;
            }
            g0.b("young-hqd", "setCallToDatabase: id=" + jA);
            return uriInsert;
        }
        contentValues.put("title", strX);
        contentValues.put("_display_name", name);
        contentValues.put("mime_type", "audio/*");
        contentValues.put("is_ringtone", Boolean.TRUE);
        String strD = e.c.a.g.a.f.f.a.d();
        contentValues.put("relative_path", strD);
        Uri uriG = g(strD, name);
        if (uriG == null) {
            uriG = f(contentValues);
        }
        if (uriG != null) {
            try {
                fileInputStream = new FileInputStream(fileA);
                try {
                    outputStreamOpenOutputStream = KGApplication.getContext().getContentResolver().openOutputStream(uriG);
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i2 = fileInputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                outputStreamOpenOutputStream.write(bArr, 0, i2);
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                if (g0.a) {
                                    g0.b("SettingUtil", "insertRingtone: ex=" + th);
                                }
                                return null;
                            } finally {
                                y.a(fileInputStream);
                                y.a(outputStreamOpenOutputStream);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStreamOpenOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamOpenOutputStream = null;
                fileInputStream = null;
            }
        }
        return uriG;
    }

    public static void l(Context context, String str, String str2) {
        Uri uriInsert;
        e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", aVar.getAbsolutePath());
        contentValues.put("title", str2);
        contentValues.put("mime_type", "audio/*");
        contentValues.put("is_notification", Boolean.TRUE);
        Uri contentUriForPath = MediaStore.Audio.Media.getContentUriForPath(aVar.getAbsolutePath());
        long jA = e.c.a.g.a.g.n.h.a.a(context, aVar.getAbsolutePath());
        if (jA > 0) {
            uriInsert = ContentUris.withAppendedId(contentUriForPath, jA);
            context.getContentResolver().update(contentUriForPath, contentValues, "_id=?", new String[]{String.valueOf(jA)});
        } else {
            uriInsert = context.getContentResolver().insert(contentUriForPath, contentValues);
        }
        e.a(context, uriInsert, "");
        RingtoneManager.setActualDefaultRingtoneUri(context, 2, uriInsert);
    }

    public static synchronized boolean m(Context context, b bVar) {
        return n(context, bVar, 3);
    }

    public static boolean n(Context context, b bVar, int i2) {
        if (i2 > 0) {
            int i3 = i2 - 1;
            try {
                if (bVar.b() == null || !new e.c.a.g.a.f.g.a(bVar.b()).exists()) {
                    return false;
                }
                l(context, bVar.b(), bVar.a().getName());
                return true;
            } catch (Error unused) {
                if (i3 > 1) {
                    return n(context, bVar, i3);
                }
                if (i3 == 1) {
                    return o(context, bVar, 2);
                }
            } catch (SecurityException e2) {
                g0.i(e2);
            } catch (Exception unused2) {
                if (i3 > 1) {
                    return n(context, bVar, i3);
                }
                if (i3 == 1) {
                    return o(context, bVar, 2);
                }
            }
        }
        return false;
    }

    public static boolean o(Context context, b bVar, int i2) {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                MediaScannerConnection.scanFile(KGApplication.getContext(), new String[]{Environment.getExternalStorageDirectory().getAbsolutePath()}, null, new a());
            } else {
                KGApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory().getAbsolutePath())));
            }
            RingBiReportHelper.INSTANCE.reportHead("updataMedia", "SettingUtil", Boolean.FALSE);
            Thread.sleep(2000L);
        } catch (Exception e2) {
            RingBiReportHelper.INSTANCE.reportHead("updataMedia, e = " + Log.getStackTraceString(e2), "SettingUtil", Boolean.FALSE);
            g0.k(e2);
        }
        if (i2 == 1) {
            return i(context, bVar, 1);
        }
        if (i2 == 2) {
            return n(context, bVar, 1);
        }
        return false;
    }
}
