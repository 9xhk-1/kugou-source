package e.c.a.g.a.r.c;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable {
    public String a;
    public long b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1158d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1159f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1160h;

    public String a() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public String toString() {
        return "ImageEntry{mPath='" + this.a + "', mSize=" + this.b + ", isSelected=" + this.f1158d + ", filename='" + this.f1159f + "', url='" + this.f1160h + "'}";
    }
}
