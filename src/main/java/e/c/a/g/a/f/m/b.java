package e.c.a.g.a.f.m;

import android.text.TextUtils;
import e.c.a.g.a.s.k;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile b a;

    public static b m() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public void A() {
        c.a.g("key_vip_bar_show_count", t() + 1);
    }

    public boolean B() {
        return c.a.e("hasforce_upload_xlog_file", false);
    }

    public boolean C() {
        return c.a.e("key_fav_has_reset_force_reload_count", false);
    }

    public String D() {
        return c.a.d("need_upload_feedback_files", "");
    }

    public boolean E() {
        return c.a.e("KEY_UPDATE_USER_GOODS_SONG", false);
    }

    public boolean F() {
        if (e.c.a.g.a.g.f.c.a.p()) {
            return c.a.e("key_need_update_fav_data", false);
        }
        return false;
    }

    public void G() {
        c.a.j("hasforce_upload_xlog_file", false);
    }

    public void H(String str) {
        if (TextUtils.isEmpty(str)) {
            c.a.i("a_device_id", "");
        } else {
            c.a.i("a_device_id", str);
        }
    }

    public void I(long j) {
        c.a.h("key_cache_device_id_key", j);
    }

    public void J(long j) {
        c.a.h("key_cache_machine_id_key", j);
    }

    public void K(int i2) {
        c.a.g("key_fav_songs_count", i2);
    }

    public void L(String str) {
        c.a.i("key_device_finger_id_date", str);
    }

    public void M(String str) {
        c.a.i("key_device_finger_info", str);
    }

    public void N(int i2, long j) {
        c.a.h("device_info_key_" + i2, j);
    }

    public void O(int i2) {
        c.a.g("key_cache_device_id_version_key", i2);
    }

    public void P(long j) {
        c.a.h("key_dialog_show_time", j);
    }

    public void Q(int i2) {
        c.a.g("key_fav_last_api_error", i2);
    }

    public void R(boolean z) {
        c.a.j("key_has_fix_song_queue_strategy", z);
    }

    public void S(int i2) {
        c.a.g("key_fav_has_force_reload_count", i2);
    }

    public void T(boolean z) {
        if (e.c.a.g.a.d.d0.c.a.h()) {
            c.a.j("hasforce_upload_xlog_file", z);
        }
    }

    public void U() {
        c.a.j("key_fav_has_reset_force_reload_count", true);
    }

    public void V(boolean z) {
        c.a.j("KEY_HAS_UPDATE_USER_ASSERT", z);
    }

    public void W(String str, int i2) {
        c.a.i("need_upload_feedback_fid_count", str + "_" + i2);
    }

    public void X(boolean z) {
        if (e.c.a.g.a.g.f.c.a.p()) {
            c.a.j("key_need_update_fav_data", z);
        }
    }

    public void Y(long j) {
        c.a.h("key_last_login_guide_time", j);
    }

    public void Z(int i2) {
        c.a.g("key_login_guide_count", i2);
    }

    public boolean a() {
        return c.a.a("key_fav_has_force_reload_count");
    }

    public void a0(long j, int i2) {
        c.a.g("mediastore_paid_record" + j, i2);
    }

    public String b() {
        return c.a.d("a_device_id", "_");
    }

    public void b0(long j, long j2) {
        c.a.h("mediastore_paid_record_last_update_time" + j, j2);
    }

    public long c() {
        return c.a.c("key_cache_device_id_key", 0L);
    }

    public void c0(boolean z, String str) {
        c.a.i("need_upload_feedback_files", z + "_" + str);
    }

    public long d() {
        return c.a.c("key_cache_machine_id_key", 0L);
    }

    public void d0(boolean z) {
        c.a.j("KEY_UPDATE_USER_GOODS_SONG", z);
    }

    public int e() {
        return c.a.b("key_fav_songs_count", 0);
    }

    public boolean e0(int i2) {
        if (e.c.a.g.a.r.b.o() <= 0) {
            return false;
        }
        c.a.g("KEY_USER_GOODS_SONG_VERSION_" + e.c.a.g.a.r.b.o(), i2);
        return true;
    }

    public String f() {
        String strD = c.a.d("key_device_finger_id_date", "");
        return TextUtils.isEmpty(strD) ? "-" : strD;
    }

    public void f0(long j) {
        c.a.h("key_vip_bar_show_time", j);
    }

    public String g() {
        return c.a.d("key_device_finger_info", "");
    }

    public void g0(String str) {
        c.a.i("key_vip_promote_config", str);
    }

    public long h(int i2) {
        return c.a.c("device_info_key_" + i2, -1L);
    }

    public void h0(long j) {
        c.a.h("key_vip_promote_cache_time", j);
    }

    public long i() {
        return c.a.b("key_cache_device_id_version_key", 0);
    }

    public long j() {
        return c.a.c("key_dialog_show_time", 0L);
    }

    public int k() {
        return c.a.b("key_fav_last_api_error", 0);
    }

    public int l() {
        return c.a.b("key_fav_has_force_reload_count", 0);
    }

    public String n() {
        return c.a.d("need_upload_feedback_fid_count", "");
    }

    public long o() {
        return c.a.c("key_last_login_guide_time", 0L);
    }

    public int p() {
        return c.a.b("key_login_guide_count", 0);
    }

    public int q(long j) {
        return c.a.b("mediastore_paid_record" + j, 0);
    }

    public long r(long j) {
        c cVar = c.a;
        return cVar.b("mediastore_paid_record_last_update_time" + j, 0);
    }

    public int s() {
        return c.a.b("KEY_USER_GOODS_SONG_VERSION_" + e.c.a.g.a.r.b.o(), 0);
    }

    public int t() {
        if (k.d(u()) != k.d(l1.b())) {
            c.a.g("key_vip_bar_show_count", 0);
        }
        return c.a.b("key_vip_bar_show_count", 0);
    }

    public long u() {
        return c.a.c("key_vip_bar_show_time", 0L);
    }

    public String v() {
        return c.a.d("key_vip_promote_config", "");
    }

    public long w() {
        return c.a.c("key_vip_promote_cache_time", 0L);
    }

    public boolean x(int i2) {
        return c.a.a("device_info_key_" + i2);
    }

    public boolean y() {
        return c.a.e("key_has_fix_song_queue_strategy", false);
    }

    public boolean z() {
        return c.a.e("KEY_HAS_UPDATE_USER_ASSERT", false);
    }
}
