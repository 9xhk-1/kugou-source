package f.e0;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(Appendable appendable, T t, f.z.c.l<? super T, ? extends CharSequence> lVar) {
        f.z.d.j.e(appendable, "$this$appendElement");
        if (lVar != null) {
            appendable.append(lVar.invoke(t));
            return;
        }
        if (t != 0 ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
