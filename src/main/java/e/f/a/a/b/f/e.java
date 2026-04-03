package e.f.a.a.b.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    public class a implements d {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public a(c cVar, String str, boolean z) {
            this.a = cVar;
            this.b = str;
            this.c = z;
        }

        @Override // e.f.a.a.b.f.e.d
        public boolean onVisitProcessEnd(long j) {
            e.f.a.a.a.k.c.b("process end %d", Long.valueOf(j));
            c cVar = this.a;
            return cVar.a <= 0 || cVar.c <= 0 || cVar.b == null;
        }

        @Override // e.f.a.a.b.f.e.d
        public boolean onVisitProcessStart(long j, long j2, String str) {
            e.f.a.a.a.k.c.b("new process %s", str);
            if (!str.equals(this.b)) {
                return true;
            }
            c cVar = this.a;
            cVar.a = j;
            cVar.b = str;
            cVar.c = j2;
            return this.c;
        }

        @Override // e.f.a.a.b.f.e.d
        public boolean onVisitThread(String str, int i2, String str2, String str3, boolean z) {
            e.f.a.a.a.k.c.b("new thread %s", str);
            c cVar = this.a;
            if (cVar.a > 0 && cVar.c > 0 && cVar.b != null) {
                if (cVar.f1402d == null) {
                    cVar.f1402d = new HashMap();
                }
                this.a.f1402d.put(str, new String[]{str2, str3, "" + i2});
            }
            return true;
        }

        @Override // e.f.a.a.b.f.e.d
        public boolean onVisitTraceFile(String str, long j, long j2) {
            return true;
        }
    }

    public class b implements d {
        public final /* synthetic */ c a;
        public final /* synthetic */ boolean b;

        public b(c cVar, boolean z) {
            this.a = cVar;
            this.b = z;
        }

        @Override // e.f.a.a.b.f.e.d
        public boolean onVisitProcessEnd(long j) {
            e.f.a.a.a.k.c.b("process end %d", Long.valueOf(j));
            return false;
        }

        @Override // e.f.a.a.b.f.e.d
        public boolean onVisitProcessStart(long j, long j2, String str) {
            e.f.a.a.a.k.c.b("new process %s", str);
            c cVar = this.a;
            cVar.a = j;
            cVar.b = str;
            cVar.c = j2;
            return this.b;
        }

        @Override // e.f.a.a.b.f.e.d
        public boolean onVisitThread(String str, int i2, String str2, String str3, boolean z) {
            e.f.a.a.a.k.c.b("new thread %s", str);
            c cVar = this.a;
            if (cVar.f1402d == null) {
                cVar.f1402d = new HashMap();
            }
            this.a.f1402d.put(str, new String[]{str2, str3, "" + i2});
            return true;
        }

        @Override // e.f.a.a.b.f.e.d
        public boolean onVisitTraceFile(String str, long j, long j2) {
            return true;
        }
    }

    public static class c {
        public long a;
        public String b;
        public long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f1402d;
    }

    public interface d {
        boolean onVisitProcessEnd(long j);

        boolean onVisitProcessStart(long j, long j2, String str);

        boolean onVisitThread(String str, int i2, String str2, String str3, boolean z);

        boolean onVisitTraceFile(String str, long j, long j2);
    }

    public static c a(String str, boolean z) throws Throwable {
        if (str == null) {
            e.f.a.a.a.k.c.c("path:%s", str);
            return null;
        }
        c cVar = new c();
        e(str, new b(cVar, z));
        if (cVar.a > 0 && cVar.c > 0 && cVar.b != null) {
            return cVar;
        }
        e.f.a.a.a.k.c.c("first dump error %s", cVar.a + " " + cVar.c + " " + cVar.b);
        return null;
    }

    public static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    public static c c(String str, String str2, boolean z) throws Throwable {
        if (str != null && str2 != null) {
            c cVar = new c();
            e(str2, new a(cVar, str, z));
            if (cVar.a > 0 && cVar.c > 0 && cVar.b != null) {
                return cVar;
            }
        }
        return null;
    }

    public static String d(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 3; i2++) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x014a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0150, code lost:
    
        if (e.f.a.a.a.k.c.k(r0) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0152, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0155, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(java.lang.String r18, e.f.a.a.b.f.e.d r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.b.f.e.e(java.lang.String, e.f.a.a.b.f.e$d):void");
    }

    public static Object[] f(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                for (Pattern pattern : patternArr) {
                    if (pattern.matcher(line).matches()) {
                        return new Object[]{pattern, line};
                    }
                }
            }
        }
        return null;
    }
}
