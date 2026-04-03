package e.c.a.b.a.a.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class a extends e.c.a.g.a.f.k.g.a {
    public String b;

    public a(int i2, String str) {
        super(i2);
        this.b = str;
    }

    @Override // e.c.a.g.a.f.k.g.a
    public String a() {
        return TextUtils.isEmpty(this.b) ? "请求响应错误" : this.b;
    }

    public a(int i2) {
        super(i2);
    }
}
