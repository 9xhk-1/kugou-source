package e.c.a.g.a.s;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.framework.lyric.LyricManager;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static final String[] a = {".mp3", ".m4a", ".wma", ".ogg", ".aac", ".wav", ".ape", ".flac", ".m4r", ".amr", e.c.a.g.a.f.f.a.j, e.c.a.g.a.f.f.a.k};

    public class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            boolean z = !q.J(str);
            if (g0.f() && !z) {
                if (g0.a) {
                    g0.c("FileUtils", "getNonNusicFilterOfKugou3 accept ret " + z);
                }
                f0.d(null);
            }
            return z;
        }
    }

    public static FilenameFilter A(File file) {
        String absolutePath = file.getAbsolutePath();
        int iIndexOf = absolutePath.indexOf("kugou");
        if (iIndexOf <= 0 || '/' != absolutePath.charAt(iIndexOf - 1)) {
            return null;
        }
        return new a();
    }

    public static String B(String str) {
        int iLastIndexOf;
        if (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf("/")) == -1) {
            return null;
        }
        return str.substring(0, iLastIndexOf + 1);
    }

    public static String C(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (G(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
            } else {
                if (D(uri)) {
                    return u(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (I(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = strArrSplit2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return u(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return u(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean D(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean E(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(e.c.a.g.a.f.f.a.j) || str.endsWith(e.c.a.g.a.f.f.a.k);
    }

    public static boolean F(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new e.c.a.g.a.f.g.a(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean G(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean H(String str) {
        return str.getBytes().length >= 255;
    }

    public static boolean I(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean J(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : a) {
                if (str.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList<File> K(File file) {
        File[] fileArrListFiles;
        ArrayList<File> arrayList = new ArrayList<>();
        if (file.isFile()) {
            arrayList.add(file);
            return arrayList;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                arrayList.addAll(K(file2));
            }
        }
        return arrayList;
    }

    public static File[] L(File file) {
        FilenameFilter filenameFilterA = A(file);
        return filenameFilterA != null ? file.listFiles(filenameFilterA) : file.listFiles();
    }

    public static boolean M(String str, String str2) throws Throwable {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Exception e2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
            if (!aVar.isDirectory() && aVar.exists()) {
                FileOutputStream fileOutputStream = null;
                try {
                    e.c.a.g.a.f.g.a aVar2 = new e.c.a.g.a.f.g.a(str2);
                    if (!aVar2.exists()) {
                        i(str2);
                        aVar2.createNewFile();
                    }
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(aVar));
                    try {
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(aVar2);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i2 = bufferedInputStream.read(bArr);
                                    if (i2 == -1) {
                                        fileOutputStream2.flush();
                                        y.a(fileOutputStream2);
                                        y.a(bufferedInputStream);
                                        return true;
                                    }
                                    fileOutputStream2.write(bArr, 0, i2);
                                }
                            } catch (Exception e3) {
                                e2 = e3;
                                fileOutputStream = fileOutputStream2;
                                e2.printStackTrace();
                                y.a(fileOutputStream);
                                y.a(bufferedInputStream);
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                y.a(fileOutputStream);
                                y.a(bufferedInputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    bufferedInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = null;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] N(java.lang.String r4) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = r0.exists()
            r1 = 0
            if (r4 == 0) goto L3c
            boolean r4 = r0.isFile()
            if (r4 == 0) goto L3c
            long r2 = r0.length()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            int r4 = (int) r2     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            int r0 = r2.read(r4)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            if (r0 != 0) goto L25
            goto L26
        L25:
            r1 = r4
        L26:
            r2.close()     // Catch: java.lang.Exception -> L2a
            goto L3c
        L2a:
            goto L3c
        L2c:
            r4 = move-exception
            r1 = r2
            goto L32
        L2f:
            goto L39
        L31:
            r4 = move-exception
        L32:
            if (r1 == 0) goto L37
            r1.close()     // Catch: java.lang.Exception -> L37
        L37:
            throw r4
        L38:
            r2 = r1
        L39:
            if (r2 == 0) goto L3c
            goto L26
        L3c:
            if (r1 != 0) goto L41
            r4 = 0
            byte[] r1 = new byte[r4]
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.s.q.N(java.lang.String):byte[]");
    }

    public static boolean O(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
            if (aVar.exists()) {
                return aVar.renameTo(new e.c.a.g.a.f.g.a(str2));
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
                if (aVar.exists()) {
                    if (g0.a) {
                        g0.b("hch-file", "file.exists()  appendData path = " + str);
                    }
                    i(str);
                    FileOutputStream fileOutputStream2 = new FileOutputStream((File) aVar, true);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        if (e instanceof NullPointerException) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            return true;
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (g0.a) {
                    g0.b("hch-file", "appendData path = " + str);
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return true;
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b() {
        KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
        String fileHashValue = kGMusicWrapperE != null ? kGMusicWrapperE.getFileHashValue() : null;
        for (String str : t()) {
            j(str, fileHashValue);
        }
    }

    public static void c(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static void d(File file, File file2) throws Throwable {
        e(file, file2, true);
    }

    public static void e(File file, File file2, boolean z) throws Throwable {
        File[] fileArrListFiles;
        Objects.requireNonNull(file, "Source must not be null");
        if (file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException("Source '" + file2 + "' is not a directory");
        }
        Objects.requireNonNull(file2, "Destination must not be null");
        if (file2.exists() && !file2.isDirectory()) {
            throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        ArrayList arrayList = null;
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath()) && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            arrayList = new ArrayList(fileArrListFiles.length);
            for (File file3 : fileArrListFiles) {
                arrayList.add(new e.c.a.g.a.f.g.a(file2, file3.getName()).getCanonicalPath());
            }
        }
        n(file, file2, z, arrayList);
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
        if (aVar.exists()) {
            return true;
        }
        return aVar.mkdirs();
    }

    public static boolean g(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
            if (!aVar.exists()) {
                File parentFile = aVar.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                aVar.createNewFile();
            } else if (i2 == 1) {
                m(aVar, 0);
                aVar.createNewFile();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static File h(String str) {
        e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
        if (!aVar.exists()) {
            File parentFile = aVar.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                aVar.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return aVar;
    }

    public static void i(String str) {
        e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
        if (aVar.exists()) {
            return;
        }
        File parentFile = aVar.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean j(String str, String str2) {
        File[] fileArrL;
        if (str == null) {
            return false;
        }
        if (g0.a) {
            g0.c("FileUtils", "param invalid, filePath: " + str);
        }
        e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
        if (!aVar.exists()) {
            return false;
        }
        if (aVar.isDirectory() && (fileArrL = L(aVar)) != null) {
            for (File file : fileArrL) {
                if (g0.a) {
                    g0.b("FileUtils", "delete filePath: " + file.getAbsolutePath());
                }
                if (TextUtils.isEmpty(str2) || !file.getAbsolutePath().contains(str2)) {
                    if (file.isDirectory()) {
                        j(file.getAbsolutePath(), str2);
                    } else {
                        m(file, 0);
                    }
                } else if (g0.a) {
                    g0.b("FileUtils", "force ignore delete : " + str2);
                }
            }
        }
        if (g0.a) {
            g0.c("FileUtils", "delete filePath: " + aVar.getAbsolutePath());
        }
        m(aVar, 0);
        return true;
    }

    @Deprecated
    public static void k(String str) {
        ArrayList<File> arrayListK;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
            if (aVar.exists()) {
                if (aVar.isDirectory() && (arrayListK = K(aVar)) != null) {
                    for (int i2 = 0; i2 < arrayListK.size(); i2++) {
                        k(arrayListK.get(i2).getAbsolutePath());
                    }
                }
                l(aVar);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean l(File file) {
        return m(file, 0);
    }

    public static boolean m(File file, int i2) {
        boolean zB = file != null ? file instanceof e.c.a.g.a.f.g.a ? ((e.c.a.g.a.f.g.a) file).b() : file.delete() : false;
        if (g0.a) {
            g0.b("DeleteTips", "ret: " + zB);
        }
        return zB;
    }

    public static void n(File file, File file2, boolean z, List<String> list) throws Throwable {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : fileArrListFiles) {
            e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    n(file3, aVar, z, list);
                } else {
                    o(file3, aVar, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable, java.nio.channels.FileChannel, java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable, java.nio.channels.FileChannel] */
    public static void o(File file, File file2, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        ?? channel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        ?? channel2 = 0;
        channel2 = 0;
        channel2 = 0;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            fileOutputStream = null;
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                channel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                channel = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            channel = fileOutputStream;
            y.a(channel2);
            y.a(fileOutputStream);
            y.a(channel);
            y.a(fileInputStream);
            throw th;
        }
        try {
            channel2 = fileOutputStream.getChannel();
            long size = channel.size();
            long jTransferFrom = 0;
            while (jTransferFrom < size) {
                long j = size - jTransferFrom;
                jTransferFrom += channel2.transferFrom(channel, jTransferFrom, j > 10485760 ? 10485760L : j);
            }
            y.a(channel2);
            y.a(fileOutputStream);
            y.a(channel);
            y.a(fileInputStream);
            if (file.length() == file2.length()) {
                if (z) {
                    file2.setLastModified(file.lastModified());
                }
            } else {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + LyricManager.STR_REPLACE_RESULT_TAG);
            }
        } catch (Throwable th4) {
            th = th4;
            y.a(channel2);
            y.a(fileOutputStream);
            y.a(channel);
            y.a(fileInputStream);
            throw th;
        }
    }

    public static ArrayList<File> p(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
            if (aVar.exists() && aVar.isDirectory()) {
                return K(aVar);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static long[] q() {
        return r(null);
    }

    public static long[] r(String str) {
        long[] jArr = new long[2];
        for (String str2 : t()) {
            if (!TextUtils.isEmpty(str2)) {
                long[] jArrS = s(str2, str);
                jArr[0] = jArr[0] + jArrS[0];
                jArr[1] = jArr[1] + jArrS[1];
            }
        }
        return jArr;
    }

    public static long[] s(String str, String str2) {
        long j;
        long[] jArr = new long[2];
        ArrayList<File> arrayListP = p(str);
        long length = 0;
        if (arrayListP == null || arrayListP.size() <= 0) {
            j = 0;
        } else {
            long size = arrayListP.size();
            for (int i2 = 0; i2 < size; i2++) {
                File file = arrayListP.get(i2);
                if (TextUtils.isEmpty(str2) || !file.getAbsolutePath().contains(str2)) {
                    length += file.length();
                } else if (g0.a) {
                    g0.b("FileUtils", "getCacheFileInfo: ignore file:" + str2);
                }
            }
            j = length;
            length = size;
        }
        jArr[0] = length;
        jArr[1] = j;
        return jArr;
    }

    public static String[] t() {
        String absolutePath = (e.c.c.o.f.a() == null || e.c.c.o.f.a().getCacheDir() == null) ? "" : e.c.c.o.f.a().getCacheDir().getAbsolutePath();
        Log.e("mhs_watch_clear", "getCachePathList, cachePath = " + absolutePath);
        return TextUtils.isEmpty(absolutePath) ? new String[]{e.c.a.g.a.f.f.a.l, e.c.a.g.a.f.f.a.c, e.c.a.g.a.f.f.a.p, e.c.a.g.a.d.x.d.a} : new String[]{e.c.a.g.a.f.f.a.l, e.c.a.g.a.f.f.a.c, e.c.a.g.a.f.f.a.p, e.c.a.g.a.d.x.d.a, absolutePath};
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037 A[PHI: r8
  0x0037: PHI (r8v4 android.database.Cursor) = (r8v3 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:20:0x0035, B:13:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String u(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r8 == 0) goto L2b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3b
            if (r9 == 0) goto L2b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3b
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3b
            if (r8 == 0) goto L28
            r8.close()
        L28:
            return r9
        L29:
            r9 = move-exception
            goto L32
        L2b:
            if (r8 == 0) goto L3a
            goto L37
        L2e:
            r9 = move-exception
            goto L3d
        L30:
            r9 = move-exception
            r8 = r7
        L32:
            e.c.a.g.a.s.g0.k(r9)     // Catch: java.lang.Throwable -> L3b
            if (r8 == 0) goto L3a
        L37:
            r8.close()
        L3a:
            return r7
        L3b:
            r9 = move-exception
            r7 = r8
        L3d:
            if (r7 == 0) goto L42
            r7.close()
        L42:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.s.q.u(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String v(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    public static FileInputStream w(String str) {
        try {
            e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
            if (aVar.exists()) {
                return new FileInputStream(aVar);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String x(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf("/");
        int iLastIndexOf2 = str.lastIndexOf(".");
        return (iLastIndexOf == -1 && iLastIndexOf2 == -1) ? str : iLastIndexOf2 > iLastIndexOf ? str.substring(iLastIndexOf + 1, iLastIndexOf2) : str.substring(iLastIndexOf);
    }

    public static int y(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) new e.c.a.g.a.f.g.a(str).length();
    }

    public static String z(String str) {
        String strV = v(str);
        if (strV != null) {
            return strV.toLowerCase();
        }
        return null;
    }
}
