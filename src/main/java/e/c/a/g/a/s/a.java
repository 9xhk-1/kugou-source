package e.c.a.g.a.s;

import android.os.Process;
import android.os.StatFs;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Map<String, a> b = new HashMap();
    public b a;

    public class b {
        public final AtomicLong a;
        public final AtomicInteger b;
        public final long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<File, Long> f1200e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public File f1201f;

        /* JADX INFO: renamed from: e.c.a.g.a.s.a$b$a, reason: collision with other inner class name */
        public class RunnableC0196a implements Runnable {
            public RunnableC0196a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles = b.this.f1201f.listFiles();
                if (fileArrListFiles != null) {
                    int iJ = 0;
                    int i2 = 0;
                    for (File file : fileArrListFiles) {
                        iJ = (int) (((long) iJ) + b.this.j(file));
                        i2++;
                        b.this.f1200e.put(file, Long.valueOf(file.lastModified()));
                    }
                    b.this.a.set(iJ);
                    b.this.b.set(i2);
                }
            }
        }

        public final void i() {
            new Thread(new RunnableC0196a()).start();
        }

        public final long j(File file) {
            if (file == null) {
                return 0L;
            }
            return file.length();
        }

        public final File k(String str) {
            File fileL = l(str);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            fileL.setLastModified(lValueOf.longValue());
            this.f1200e.put(fileL, lValueOf);
            return fileL;
        }

        public final File l(String str) {
            return new File(this.f1201f, str.hashCode() + "");
        }

        public final void m(File file) {
            int iAddAndGet = this.b.get();
            while (iAddAndGet + 1 > this.f1199d) {
                this.a.addAndGet(-o());
                iAddAndGet = this.b.addAndGet(-1);
            }
            this.b.addAndGet(1);
            long j = j(file);
            long jAddAndGet = this.a.get();
            while (jAddAndGet + j > this.c) {
                jAddAndGet = this.a.addAndGet(-o());
            }
            this.a.addAndGet(j);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(lValueOf.longValue());
            this.f1200e.put(file, lValueOf);
        }

        public final boolean n(String str) {
            return k(str).delete();
        }

        public final long o() {
            File key;
            if (this.f1200e.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> setEntrySet = this.f1200e.entrySet();
            synchronized (this.f1200e) {
                key = null;
                Long value = null;
                for (Map.Entry<File, Long> entry : setEntrySet) {
                    if (key == null) {
                        key = entry.getKey();
                        value = entry.getValue();
                    } else {
                        Long value2 = entry.getValue();
                        if (value2.longValue() < value.longValue()) {
                            key = entry.getKey();
                            value = value2;
                        }
                    }
                }
            }
            long j = j(key);
            if (key != null && key.delete()) {
                this.f1200e.remove(key);
            }
            return j;
        }

        public b(a aVar, File file, long j, int i2) {
            this.f1200e = Collections.synchronizedMap(new HashMap());
            this.f1201f = file;
            this.c = j;
            this.f1199d = i2;
            this.a = new AtomicLong();
            this.b = new AtomicInteger();
            i();
        }
    }

    public static class c {
        public static String c(String str) {
            return (str == null || !f(str.getBytes())) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        public static byte[] d(byte[] bArr, int i2, int i3) {
            int i4 = i3 - i2;
            if (i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, Math.min(bArr.length - i2, i4));
                return bArr2;
            }
            throw new IllegalArgumentException(i2 + " > " + i3);
        }

        public static String[] e(byte[] bArr) {
            if (f(bArr)) {
                return new String[]{new String(d(bArr, 0, 13)), new String(d(bArr, 14, g(bArr, ' ')))};
            }
            return null;
        }

        public static boolean f(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && g(bArr, ' ') > 14;
        }

        public static int g(byte[] bArr, char c) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] == c) {
                    return i2;
                }
            }
            return -1;
        }

        public static boolean h(String str) {
            return i(str.getBytes());
        }

        public static boolean i(byte[] bArr) {
            String[] strArrE = e(bArr);
            if (strArrE != null && strArrE.length == 2) {
                String strSubstring = strArrE[0];
                while (strSubstring.startsWith("0")) {
                    strSubstring = strSubstring.substring(1, strSubstring.length());
                }
                try {
                    if (System.currentTimeMillis() > Long.valueOf(strSubstring).longValue() + (Long.valueOf(strArrE[1]).longValue() * 1000)) {
                        return true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
    }

    public a(File file, long j, int i2) {
        c(file);
        this.a = new b(file, j, i2);
    }

    public static a a(File file, long j, int i2) {
        a aVar = b.get(file.getAbsoluteFile() + d());
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(file, j, i2);
        b.put(file.getAbsolutePath() + d(), aVar2);
        return aVar2;
    }

    public static void c(File file) {
        if (file.exists() || file.mkdirs()) {
            return;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            long blockSize = ((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024;
        } catch (Exception e2) {
            Log.e("ACache", "can't make dirs in " + file.getAbsolutePath() + ", size : 0");
            e2.printStackTrace();
        }
    }

    public static String d() {
        return "_" + Process.myPid();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            e.c.a.g.a.s.a$b r0 = r5.a
            java.io.File r0 = e.c.a.g.a.s.a.b.h(r0, r6)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 != 0) goto Le
            return r2
        Le:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L57 java.lang.OutOfMemoryError -> L59 java.io.IOException -> L5b
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L57 java.lang.OutOfMemoryError -> L59 java.io.IOException -> L5b
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L57 java.lang.OutOfMemoryError -> L59 java.io.IOException -> L5b
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L57 java.lang.OutOfMemoryError -> L59 java.io.IOException -> L5b
            java.lang.String r0 = ""
        L1a:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.OutOfMemoryError -> L53 java.io.IOException -> L55 java.lang.Throwable -> L6d
            if (r3 == 0) goto L30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.OutOfMemoryError -> L53 java.io.IOException -> L55 java.lang.Throwable -> L6d
            r4.<init>()     // Catch: java.lang.OutOfMemoryError -> L53 java.io.IOException -> L55 java.lang.Throwable -> L6d
            r4.append(r0)     // Catch: java.lang.OutOfMemoryError -> L53 java.io.IOException -> L55 java.lang.Throwable -> L6d
            r4.append(r3)     // Catch: java.lang.OutOfMemoryError -> L53 java.io.IOException -> L55 java.lang.Throwable -> L6d
            java.lang.String r0 = r4.toString()     // Catch: java.lang.OutOfMemoryError -> L53 java.io.IOException -> L55 java.lang.Throwable -> L6d
            goto L1a
        L30:
            boolean r3 = e.c.a.g.a.s.a.c.a(r0)     // Catch: java.lang.OutOfMemoryError -> L53 java.io.IOException -> L55 java.lang.Throwable -> L6d
            if (r3 != 0) goto L45
            java.lang.String r6 = e.c.a.g.a.s.a.c.b(r0)     // Catch: java.lang.OutOfMemoryError -> L53 java.io.IOException -> L55 java.lang.Throwable -> L6d
            r1.close()     // Catch: java.lang.OutOfMemoryError -> L3e java.io.IOException -> L40
            goto L44
        L3e:
            r0 = move-exception
            goto L41
        L40:
            r0 = move-exception
        L41:
            r0.printStackTrace()
        L44:
            return r6
        L45:
            r1.close()     // Catch: java.lang.OutOfMemoryError -> L49 java.io.IOException -> L4b
            goto L4f
        L49:
            r0 = move-exception
            goto L4c
        L4b:
            r0 = move-exception
        L4c:
            r0.printStackTrace()
        L4f:
            r5.f(r6)
            return r2
        L53:
            r6 = move-exception
            goto L5d
        L55:
            r6 = move-exception
            goto L5d
        L57:
            r6 = move-exception
            goto L6f
        L59:
            r6 = move-exception
            goto L5c
        L5b:
            r6 = move-exception
        L5c:
            r1 = r2
        L5d:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L6d
            if (r1 == 0) goto L6c
            r1.close()     // Catch: java.lang.OutOfMemoryError -> L66 java.io.IOException -> L68
            goto L6c
        L66:
            r6 = move-exception
            goto L69
        L68:
            r6 = move-exception
        L69:
            r6.printStackTrace()
        L6c:
            return r2
        L6d:
            r6 = move-exception
            r2 = r1
        L6f:
            if (r2 == 0) goto L7b
            r2.close()     // Catch: java.lang.OutOfMemoryError -> L75 java.io.IOException -> L77
            goto L7b
        L75:
            r0 = move-exception
            goto L78
        L77:
            r0 = move-exception
        L78:
            r0.printStackTrace()
        L7b:
            goto L7d
        L7c:
            throw r6
        L7d:
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.s.a.b(java.lang.String):java.lang.String");
    }

    public void e(String str, String str2) throws Throwable {
        File fileL = this.a.l(str);
        c(fileL.getParentFile());
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(fileL), 1024);
                try {
                    bufferedWriter2.write(str2);
                    try {
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    this.a.m(fileL);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
        this.a.m(fileL);
    }

    public boolean f(String str) {
        return this.a.n(str);
    }
}
