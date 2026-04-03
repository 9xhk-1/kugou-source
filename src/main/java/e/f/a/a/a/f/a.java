package e.f.a.a.a.f;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Comparable<a>, Serializable {
    public String a;
    public long b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1334d;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        return (int) (this.b - aVar.b);
    }
}
