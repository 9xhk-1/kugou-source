package e.c.a.g.a.f.g;

import e.c.a.g.a.s.g0;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a extends File {
    public a(File file, String str) {
        super(file, str);
    }

    public boolean a(int i2) {
        return super.delete();
    }

    public boolean b() {
        return super.delete();
    }

    @Override // java.io.File
    @Deprecated
    public boolean delete() {
        return a(0);
    }

    @Override // java.io.File
    @Deprecated
    public void deleteOnExit() {
        super.deleteOnExit();
        if (g0.a) {
            g0.c("vz-DelFile", "deleteOnExit:" + getAbsolutePath());
        }
    }

    public a(String str) {
        super(str);
    }

    public a(String str, String str2) {
        super(str, str2);
    }
}
