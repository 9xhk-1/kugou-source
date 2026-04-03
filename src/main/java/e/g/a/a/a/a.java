package e.g.a.a.a;

import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();
    public static b b;

    public final void a(b bVar) {
        j.e(bVar, "listener");
        b = bVar;
    }

    public final void b(int i2) {
        b bVar = b;
        if (bVar == null) {
            return;
        }
        bVar.onSongChange(i2);
    }
}
