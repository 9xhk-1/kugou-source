package e.c.a.g.a.d.d0;

import android.text.TextUtils;
import android.util.Log;
import f.e0.n;
import f.u.m;
import f.u.u;
import f.z.d.j;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b();

    public static final class a implements FilenameFilter {
        public static final a a = new a();

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            j.d(str, "name");
            return n.k(str, ".xlog", false, 2, null);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.d0.b$b, reason: collision with other inner class name */
    public static final class C0047b<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return f.v.a.a(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
        }
    }

    public static final class c implements FilenameFilter {
        public static final c a = new c();

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            j.d(str, "name");
            return n.k(str, ".xlog", false, 2, null);
        }
    }

    public static final class d<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return f.v.a.a(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
        }
    }

    public static final class e implements FilenameFilter {
        public static final e a = new e();

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            j.d(str, "name");
            return n.k(str, ".xlog", false, 2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.util.List<? extends java.io.File> r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.d.d0.b.a(java.util.List, java.lang.String):boolean");
    }

    public final void b(String str, long j) {
        ArrayList<File> arrayList;
        j.e(str, "directoryPath");
        if (TextUtils.isEmpty(str)) {
            Log.e("XLogCacheManager", j.l("deleteFilesOlderThan 目录不存在或不是一个有效的目录: ", str));
            return;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            Log.e("XLogCacheManager", j.l("目录不存在或不是一个有效的目录: ", str));
            return;
        }
        Date date = new Date();
        File[] fileArrListFiles = file.listFiles(a.a);
        if (fileArrListFiles == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    arrayList2.add(file2);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return;
        }
        for (File file3 : arrayList) {
            try {
                long time = (date.getTime() - new Date(file3.lastModified()).getTime()) / ((long) 86400000);
                if (time > j) {
                    if (file3.delete()) {
                        Log.d("XLogCacheManager", "已删除文件: " + ((Object) file3.getName()) + " （年龄: " + time + " 天）");
                    } else {
                        Log.e("XLogCacheManager", "无法删除文件: " + ((Object) file3.getName()) + " （年龄: " + time + " 天）");
                    }
                }
            } catch (Exception e2) {
                Log.e("XLogCacheManager", "处理文件 " + ((Object) file3.getName()) + " 时发生错误: " + ((Object) e2.getMessage()));
            }
        }
    }

    public final List<File> c(String str, int i2) {
        ArrayList arrayList;
        j.e(str, "directoryPath");
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            Log.e("FileUtils", j.l("目录不存在或不是一个有效的目录: ", str));
            return m.d();
        }
        File[] fileArrListFiles = file.listFiles(c.a);
        if (fileArrListFiles == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    arrayList2.add(file2);
                }
            }
            arrayList = arrayList2;
        }
        return arrayList == null ? m.d() : u.J(u.I(arrayList, new C0047b()), i2);
    }

    public final void d(String str, int i2) {
        ArrayList arrayList;
        j.e(str, "directoryPath");
        if (TextUtils.isEmpty(str)) {
            Log.e("XLogCacheManager", j.l("keepLatestFiles 目录不存在或不是一个有效的目录: ", str));
            return;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println((Object) j.l("目录不存在或不是一个有效的目录: ", str));
            return;
        }
        File[] fileArrListFiles = file.listFiles(e.a);
        if (fileArrListFiles == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    arrayList2.add(file2);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() <= i2) {
            System.out.println((Object) "目录中的文件数量不超过 10 个，无需删除。");
            return;
        }
        for (File file3 : u.q(u.I(arrayList, new d()), i2)) {
            if (file3.delete()) {
                System.out.println((Object) j.l("已删除文件: ", file3.getName()));
            } else {
                System.out.println((Object) j.l("无法删除文件: ", file3.getName()));
            }
        }
    }
}
