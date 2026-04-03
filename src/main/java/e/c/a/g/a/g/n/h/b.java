package e.c.a.g.a.g.n.h;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public final File a;

    public b(@NonNull File file) {
        this.a = file;
    }

    public File a() {
        return this.a;
    }

    public String b() {
        return this.a.getAbsolutePath();
    }
}
