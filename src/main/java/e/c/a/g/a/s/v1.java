package e.c.a.g.a.s;

import android.text.TextUtils;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.user.entity.BusiVip;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;

/* JADX INFO: loaded from: classes2.dex */
public class v1 {
    public static long a() {
        if (!e.c.a.g.a.r.b.M()) {
            return -1L;
        }
        String su_vip_end_time = SVIPExtInfoUtil.getMineSVIPExtInfo().getSu_vip_end_time();
        if (TextUtils.isEmpty(su_vip_end_time)) {
            return -1L;
        }
        return k.e(su_vip_end_time);
    }

    public static long b() {
        if (e.c.a.g.a.r.b.M()) {
            return -1L;
        }
        if (!(e.c.a.g.a.r.b.z() == 6)) {
            return -1L;
        }
        String strF = e.c.a.g.a.r.b.f();
        if (TextUtils.isEmpty(strF)) {
            return -1L;
        }
        return k.e(strF);
    }

    public static int c() {
        int iZ = e.c.a.g.a.r.b.z();
        int i2 = e.c.a.g.a.r.b.i();
        boolean z = iZ == 6;
        boolean z2 = i2 > 0 && i2 < 5;
        boolean zE = e.c.a.g.a.r.b.E();
        boolean zD = e.c.a.g.a.r.b.D();
        boolean zQ = e.c.a.g.a.r.b.Q();
        int iB = e.c.a.g.a.r.b.B();
        if (e.c.a.g.a.r.b.M()) {
            return e.c.a.g.a.r.b.P() ? R.drawable.ic_sign_super_vip_year : R.drawable.ic_sign_super_vip;
        }
        if (zQ) {
            return BusiVip.isYearVip(zQ, iB) ? R.drawable.ic_sign_young_vip_year : R.drawable.ic_sign_young_vip;
        }
        if (z) {
            if (zE) {
                return R.drawable.ic_sign_vip_year;
            }
            if (!z2 || !zD) {
                return R.drawable.ic_sign_vip;
            }
        } else {
            if (!z2) {
                return 0;
            }
            if (!zD) {
                return R.drawable.ic_sign_music_pac;
            }
        }
        return R.drawable.ic_sign_year_music_pac;
    }

    public static long d() {
        if (!e.c.a.g.a.r.b.Q()) {
            return -1L;
        }
        String strA = e.c.a.g.a.r.b.A();
        if (TextUtils.isEmpty(strA)) {
            return -1L;
        }
        return k.e(strA);
    }
}
