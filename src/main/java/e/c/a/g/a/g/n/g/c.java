package e.c.a.g.a.g.n.g;

import android.support.annotation.Nullable;
import com.kugou.common.filemanager.downloadengine.utils.FileUtil;
import e.c.a.g.a.s.g0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static a[] c = {e.c.a.g.a.g.n.g.a.n(), e.c.a.g.a.g.n.g.b.k(), d.k()};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList<String> f987d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static HashMap<String, a> f988e = new HashMap<>();
    public b a = null;
    public File b = null;

    public interface a {
        c create();

        String[] getSupportedExtensions();
    }

    public interface b {
        boolean reportProgress(double d2);
    }

    static {
        for (a aVar : c) {
            for (String str : aVar.getSupportedExtensions()) {
                f987d.add(str);
                f988e.put(str, aVar);
            }
        }
    }

    public static c c(String str, String str2, b bVar) throws IOException {
        e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
        if (!aVar.exists()) {
            throw new FileNotFoundException(str);
        }
        String lowerCase = aVar.getName().toLowerCase();
        String[] strArrSplit = lowerCase.split("\\.");
        if (strArrSplit.length < 2) {
            return null;
        }
        if (FileUtil.isTempCachePath(lowerCase)) {
            strArrSplit[strArrSplit.length - 1] = str2;
            if (g0.a) {
                g0.b("hch-ringtonemake", " KGRecordAndDiyActivity.REAL_EXTNAME =" + str2);
            }
        }
        a aVar2 = f988e.get(strArrSplit[strArrSplit.length - 1]);
        if (aVar2 == null) {
            return null;
        }
        c cVarCreate = aVar2.create();
        cVarCreate.j(bVar);
        cVarCreate.a(aVar);
        return cVarCreate;
    }

    public void a(File file) throws IOException {
        this.b = file;
    }

    public void b(File file, int i2, int i3) throws IOException {
    }

    public int[] d() {
        return null;
    }

    @Nullable
    public File e() {
        return this.b;
    }

    public int f() {
        return 0;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return 0;
    }

    public int i(int i2) {
        return -1;
    }

    public void j(b bVar) {
        this.a = bVar;
    }
}
