package e.c.a.g.a.f.i;

import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile m f678d;
    public final boolean a = d();
    public String b = null;
    public List<String> c;

    public static m a() {
        if (f678d == null) {
            synchronized (m.class) {
                if (f678d == null) {
                    f678d = new m();
                }
            }
        }
        return f678d;
    }

    public final String b() {
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.c2);
        return config != null ? config : "";
    }

    public final List<String> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CommNetSongUrlInfo.FAIL_PROCESS_VIP);
        arrayList.add("会员");
        arrayList.add("购买");
        arrayList.add("版权");
        arrayList.add("付费");
        arrayList.add("收费");
        String[] strArrS = h1.s(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.d2));
        if (strArrS != null) {
            for (String str : strArrS) {
                if (!TextUtils.isEmpty(str)) {
                    if (g0.a) {
                        g0.b("VipTipCtrl", "getRiskWords: words=" + str);
                    }
                    arrayList.add(str.toLowerCase());
                }
            }
        }
        return arrayList;
    }

    public final boolean d() {
        String[] strArrS = h1.s(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.b2));
        if (strArrS != null) {
            for (String str : strArrS) {
                if (str != null && str.equals(l1.j())) {
                    Log.d("VipTipCtrl", "isThisChannelHook: hook channel : " + str);
                    return true;
                }
            }
        }
        return false;
    }

    public CharSequence e(CharSequence charSequence) {
        if (!this.a || charSequence == null) {
            return charSequence;
        }
        if (this.b == null) {
            this.b = b();
        }
        if (this.c == null) {
            this.c = c();
        }
        String lowerCase = charSequence.toString().toLowerCase();
        Iterator<String> it = this.c.iterator();
        while (it.hasNext()) {
            if (lowerCase.contains(it.next())) {
                if (g0.a) {
                    g0.b("VipTipCtrl", "refitTip: ignore tip:" + ((Object) charSequence));
                }
                return this.b;
            }
        }
        return charSequence;
    }
}
