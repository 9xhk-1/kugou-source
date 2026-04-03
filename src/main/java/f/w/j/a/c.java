package f.w.j.a;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements f.w.d<Object> {
    public static final c a = new c();

    @Override // f.w.d
    public f.w.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // f.w.d
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
