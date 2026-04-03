package e.c.a.g.a.r.d.d;

import com.kugou.common.config.ConfigKey;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class e extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1167d;

    public e(String str) {
        this.f1167d = str;
    }

    @Override // e.c.a.g.a.r.d.d.d
    public String a() {
        return "https://imgphpulssl.kugou.com/imageupload/v3/post.php";
    }

    @Override // e.c.a.g.a.r.d.d.d
    public String b() {
        return "UploadUserImage";
    }

    @Override // e.c.a.g.a.r.d.d.d
    public String c() {
        return "kugouicon";
    }

    @Override // e.c.a.g.a.r.d.d.d
    public Hashtable<String, String> d() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("authorization", this.f1167d);
        if (e.c.a.g.a.r.b.F()) {
            hashtable.put("userid", String.valueOf(e.c.a.g.a.r.b.o()));
        }
        hashtable.put("appid", String.valueOf(l1.f()));
        hashtable.put("clientver", Integer.toString(l1.G()));
        hashtable.put("clienttime", Long.toString(l1.b() / 1000));
        hashtable.put("mid", l1.n(e.c.c.o.f.a()));
        hashtable.put("uuid", m.h());
        hashtable.put("dfid", m.e());
        return hashtable;
    }

    @Override // e.c.a.g.a.r.d.d.d
    public ConfigKey e() {
        return e.c.a.g.a.f.e.b.z0;
    }
}
