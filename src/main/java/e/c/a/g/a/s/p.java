package e.c.a.g.a.s;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    public class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            boolean z = !q.J(str);
            if (g0.f() && !z) {
                if (g0.a) {
                    g0.c("vz-delete-FileUtil", "getNonNusicFilterOfKugou3 accept ret " + z);
                }
                f0.d(null);
            }
            return z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007e A[Catch: IOException -> 0x0082, TRY_ENTER, TryCatch #5 {IOException -> 0x0082, blocks: (B:23:0x0054, B:44:0x007e, B:48:0x0086), top: B:69:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086 A[Catch: IOException -> 0x0082, TRY_LEAVE, TryCatch #5 {IOException -> 0x0082, blocks: (B:23:0x0054, B:44:0x007e, B:48:0x0086), top: B:69:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b A[Catch: IOException -> 0x0097, TRY_LEAVE, TryCatch #2 {IOException -> 0x0097, blocks: (B:55:0x0093, B:59:0x009b), top: B:67:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 4
            r1 = 0
            r2 = 0
            e.c.a.g.a.f.g.a r3 = new e.c.a.g.a.f.g.a     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            e.c.a.g.a.f.g.a r5 = new e.c.a.g.a.f.g.a     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r4 == 0) goto L68
            boolean r4 = r3.isDirectory()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r4 == 0) goto L1a
            goto L68
        L1a:
            boolean r4 = r3.isDirectory()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r4 == 0) goto L22
            r5 = 2
            return r5
        L22:
            boolean r4 = r5.exists()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r4 != 0) goto L2e
            d(r6)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r5.createNewFile()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
        L2e:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L64
            r5 = 5120(0x1400, float:7.175E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
        L46:
            int r2 = r6.read(r5)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4 = -1
            if (r2 == r4) goto L51
            r3.write(r5, r1, r2)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            goto L46
        L51:
            r3.flush()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r6.close()     // Catch: java.io.IOException -> L82
            r3.close()     // Catch: java.io.IOException -> L82
            r0 = 0
            goto L8f
        L5c:
            r5 = move-exception
            goto L62
        L5e:
            r5 = move-exception
            goto L66
        L60:
            r5 = move-exception
            r3 = r2
        L62:
            r2 = r6
            goto L91
        L64:
            r5 = move-exception
            r3 = r2
        L66:
            r2 = r6
            goto L6f
        L68:
            r5 = 1
            return r5
        L6a:
            r5 = move-exception
            r3 = r2
            goto L91
        L6d:
            r5 = move-exception
            r3 = r2
        L6f:
            r6 = 3
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L90
            java.lang.String r1 = "wwhSkin"
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L90
            e.c.a.g.a.s.g0.c(r1, r5)     // Catch: java.lang.Throwable -> L90
            if (r2 == 0) goto L84
            r2.close()     // Catch: java.io.IOException -> L82
            goto L84
        L82:
            r5 = move-exception
            goto L8a
        L84:
            if (r3 == 0) goto L8e
            r3.close()     // Catch: java.io.IOException -> L82
            goto L8e
        L8a:
            r5.printStackTrace()
            goto L8f
        L8e:
            r0 = 3
        L8f:
            return r0
        L90:
            r5 = move-exception
        L91:
            if (r2 == 0) goto L99
            r2.close()     // Catch: java.io.IOException -> L97
            goto L99
        L97:
            r6 = move-exception
            goto L9f
        L99:
            if (r3 == 0) goto La2
            r3.close()     // Catch: java.io.IOException -> L97
            goto La2
        L9f:
            r6.printStackTrace()
        La2:
            goto La4
        La3:
            throw r5
        La4:
            goto La3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.s.p.a(java.lang.String, java.lang.String):int");
    }

    public static boolean b(String str, int i2) {
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
                g0.b("mhs_watch_feed", "createFile : " + str);
                g(aVar, 0);
                aVar.createNewFile();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void c(String str, int i2) {
        try {
            e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
            if (!aVar.exists()) {
                aVar.mkdirs();
            } else if (i2 == 1) {
                g0.b("mhs_watch_feed", "createFolder : " + aVar.getAbsolutePath());
                g(aVar, 3);
                aVar.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(String str) {
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

    @Deprecated
    public static void e(String str) {
        File[] fileArrL;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
            if (aVar.exists()) {
                if (aVar.isDirectory() && (fileArrL = l(aVar)) != null) {
                    for (File file : fileArrL) {
                        e(file.getAbsolutePath());
                    }
                }
                f(aVar);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean f(File file) {
        return g(file, 0);
    }

    public static boolean g(File file, int i2) {
        boolean zB = file != null ? file instanceof e.c.a.g.a.f.g.a ? ((e.c.a.g.a.f.g.a) file).b() : file.delete() : false;
        if (g0.a) {
            g0.b("DeleteTips", "ret: " + zB);
        }
        return zB;
    }

    public static boolean h(File file) {
        boolean zB = file != null ? file instanceof e.c.a.g.a.f.g.a ? ((e.c.a.g.a.f.g.a) file).b() : file.delete() : false;
        if (g0.a) {
            g0.b("vz-delete-FileUtil", "deleteFile f " + file + ", ret " + zB);
        }
        return zB;
    }

    public static FilenameFilter i(File file) {
        String absolutePath = file.getAbsolutePath();
        int iIndexOf = absolutePath.indexOf("kugou");
        if (iIndexOf <= 0 || '/' != absolutePath.charAt(iIndexOf - 1)) {
            return null;
        }
        return new a();
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new e.c.a.g.a.f.g.a(str).isDirectory();
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new e.c.a.g.a.f.g.a(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static File[] l(File file) {
        FilenameFilter filenameFilterI = i(file);
        return filenameFilterI != null ? file.listFiles(filenameFilterI) : file.listFiles();
    }

    public static byte[] m(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        int i2 = inputStream.read(bArr);
        while (-1 != i2) {
            byteArrayOutputStream.write(bArr, 0, i2);
            i2 = inputStream.read(bArr);
        }
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void n(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
                    if (aVar.exists()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream((File) aVar, false);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            fileOutputStream = fileOutputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            if (fileOutputStream == null) {
                                return;
                            } else {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }
}
