package e.c.a.g.a.s;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.kugou.android.audioidentify.AudioIdentifyFragment;
import com.kugou.android.audioidentify.IdentifyResultFragment;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.component.download.DownloadListFragment;
import com.kugou.android.watch.lite.component.fav.FavListFragment;
import com.kugou.android.watch.lite.component.feedback.FeedbackActivity;
import com.kugou.android.watch.lite.component.feedback.FeedbackFragment;
import com.kugou.android.watch.lite.component.main.recommend.RecommendFragment;
import com.kugou.android.watch.lite.component.main.recommend.detail.DetailFragment;
import com.kugou.android.watch.lite.component.main.simple.RadioSongListFragment;
import com.kugou.android.watch.lite.component.player.report.SongReportFragment;
import com.kugou.android.watch.lite.component.player.wdiget.PlayerMoreFragment;
import com.kugou.android.watch.lite.component.recentplaylist.RecentPlaySongsFragment;
import com.kugou.android.watch.lite.component.ringtone.RingtoneFragment;
import com.kugou.android.watch.lite.component.search.SearchFragment;
import com.kugou.android.watch.lite.component.vip.VipCenterFragment;
import com.kugou.android.watch.lite.component.vip.payment.VipPaymentFragment;
import com.kugou.android.watch.lite.musicrank.FamilyHomeRankFragment;
import com.kugou.android.watch.lite.musicrank.MusicRankFragment;
import com.kugou.android.watch.lite.newsong.NewSongListFragment;
import com.kugou.android.watch.lite.setting.ClosePersonalityHintFragment;
import com.kugou.android.watch.lite.setting.LogoffGuideFragment;
import com.kugou.android.watch.lite.setting.SettingFragment;
import com.kugou.android.watch.lite.user.info.AvatarSelectActivity;
import com.kugou.android.watch.lite.user.info.EditUserNameFragment;
import com.kugou.android.watch.lite.user.info.EditUserPicActivity;
import com.kugou.android.watch.lite.user.login.UserLoginIntegrationFragment;
import com.kugou.android.watch.lite.user.login.UserLoginIntegrationNewFragment;
import com.kugou.android.watch.lite.user.login.UserLoginIntegrationXtcFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 {
    public static final s0 a = new s0();
    public static final int b = e.c.a.g.a.g.e.d.a.f();

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Bundle a;

        public a(Bundle bundle) {
            this.a = bundle;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.d.v.c.e(VipPaymentFragment.class, this.a);
        }
    }

    public final void A() {
        e.c.a.g.a.d.v.c.e(VipCenterFragment.class, new Bundle());
    }

    public final void B(Bundle bundle) {
        f.z.d.j.e(bundle, "bundle");
        e.c.a.g.a.d.v.c.e(VipCenterFragment.class, bundle);
    }

    public final void C(Bundle bundle) {
        f.z.d.j.e(bundle, "bundle");
        Activity activityC = e.c.a.g.a.d.j.a.e().c();
        if (activityC == null || !l1.m0()) {
            e.c.a.g.a.d.v.c.e(VipPaymentFragment.class, bundle);
            return;
        }
        e.c.a.g.a.g.p.c.d dVar = new e.c.a.g.a.g.p.c.d(activityC, 0, 2, null);
        dVar.setCancelable(false);
        dVar.setCanceledOnTouchOutside(false);
        dVar.b(activityC.getResources().getString(R.string.when_pay_tip_for_xtc));
        dVar.a(new a(bundle));
        dVar.show();
    }

    public final void D() {
        if (e.c.a.g.a.r.b.O()) {
            A();
            return;
        }
        A();
        Bundle bundle = new Bundle();
        bundle.putBoolean("viewpager_framework_delegate_open_two_fragment", true);
        C(bundle);
    }

    public final void E(String str, String str2) {
        f.z.d.j.e(str, "title");
        f.z.d.j.e(str2, "resourceId");
        Bundle bundle = new Bundle();
        bundle.putString("key_title", str);
        bundle.putString("key_resource_id", str2);
        e.c.a.g.a.d.v.c.e(DetailFragment.class, bundle);
    }

    public final Intent a(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        return intent;
    }

    public final void b() {
        e.c.a.g.a.d.v.c.e(AudioIdentifyFragment.class, new Bundle());
    }

    public final void c(Bundle bundle) {
        f.z.d.j.e(bundle, "bundle");
        e.c.a.g.a.d.v.c.e(AudioIdentifyFragment.class, bundle);
    }

    public final void d(Context context) {
        f.z.d.j.e(context, "context");
        context.startActivity(a(context, AvatarSelectActivity.class));
    }

    public final void e() {
        e.c.a.g.a.d.v.c.e(ClosePersonalityHintFragment.class, new Bundle());
    }

    public final void f() {
        e.c.a.g.a.e.b.b(new YoungBITask(2006, "click"));
        e.c.a.g.a.d.v.c.e(DownloadListFragment.class, new Bundle());
    }

    public final void g() {
        e.c.a.g.a.d.v.c.e(EditUserNameFragment.class, new Bundle());
    }

    public final void h(Context context) {
        f.z.d.j.e(context, "context");
        context.startActivity(a(context, EditUserPicActivity.class));
    }

    public final void i() {
        if (!e.c.a.g.a.r.b.F()) {
            l("4");
        } else {
            e.c.a.g.a.e.b.b(new YoungBITask(2005, "click"));
            e.c.a.g.a.d.v.c.e(FavListFragment.class, new Bundle());
        }
    }

    public final void j(int i2) {
        if (i2 == 1 && !e.c.a.g.a.r.b.F()) {
            l("7");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_fun_type", i2);
        if (!e.c.a.g.a.g.g.a.a.a(i2)) {
            e.c.a.g.a.d.v.c.e(FeedbackFragment.class, bundle);
            return;
        }
        Intent intentA = a(KGApplication.getContext(), FeedbackActivity.class);
        intentA.putExtras(bundle);
        KGApplication.getContext().startActivity(intentA);
    }

    public final void k(ArrayList<KGSong> arrayList, int i2) {
        f.z.d.j.e(arrayList, "list");
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("key_song_list", arrayList);
        bundle.putInt("key_source_from", i2);
        e.c.a.g.a.d.v.c.e(IdentifyResultFragment.class, bundle);
    }

    public final void l(String str) {
        f.z.d.j.e(str, "source");
        e.c.a.g.a.g.f.e.b(-1L);
        m(str);
    }

    public final void m(String str) {
        boolean zT = e.c.a.g.a.f.a.t();
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        bundle.putBoolean("key_hide_phone_login", zT);
        if (!e.c.a.g.a.f.a.v()) {
            e.c.a.g.a.d.v.c.e(UserLoginIntegrationFragment.class, bundle);
        } else if (e.c.a.g.a.f.a.u()) {
            e.c.a.g.a.d.v.c.e(UserLoginIntegrationXtcFragment.class, bundle);
        } else {
            e.c.a.g.a.d.v.c.e(UserLoginIntegrationNewFragment.class, bundle);
        }
    }

    public final void n(String str, long j) {
        f.z.d.j.e(str, "source");
        e.c.a.g.a.g.f.e.b(j);
        m(str);
    }

    public final void o() {
        e.c.a.g.a.d.v.c.e(LogoffGuideFragment.class, new Bundle());
    }

    public final void p() {
        if (e.c.a.g.a.g.e.d.a.g()) {
            e.c.a.g.a.d.v.c.e(FamilyHomeRankFragment.class, new Bundle());
            e.c.a.g.a.e.b.b(new YoungBITask(20475, "click").setIvar1(f.z.d.j.l("", Integer.valueOf(b))));
        } else {
            e.c.a.g.a.d.v.c.e(MusicRankFragment.class, new Bundle());
            e.c.a.g.a.e.b.b(new YoungBITask(20475, "click").setIvar1(f.z.d.j.l("", Integer.valueOf(b))));
        }
    }

    public final void q() {
        e.c.a.g.a.d.v.c.e(NewSongListFragment.class, new Bundle());
    }

    public final void r(AbsFrameworkFragment absFrameworkFragment) {
        Bundle bundle = new Bundle();
        if (absFrameworkFragment == null) {
            return;
        }
        absFrameworkFragment.b0(PlayerMoreFragment.class, bundle);
    }

    public final void s(String str) {
        f.z.d.j.e(str, "title");
        Bundle bundle = new Bundle();
        bundle.putString("key_title", str);
        e.c.a.g.a.d.v.c.e(RadioSongListFragment.class, bundle);
    }

    public final void t() {
        e.c.a.g.a.e.b.b(new YoungBITask(2007, "click"));
        e.c.a.g.a.d.v.c.e(RecentPlaySongsFragment.class, new Bundle());
    }

    public final void u() {
        e.c.a.g.a.d.v.c.e(RecommendFragment.class, new Bundle());
    }

    public final void v(KGMusicWrapper kGMusicWrapper) {
        f.z.d.j.e(kGMusicWrapper, "wrapper");
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_song_data", kGMusicWrapper);
        e.c.a.g.a.d.v.c.e(RingtoneFragment.class, bundle);
    }

    public final void w() {
        e.c.a.g.a.d.v.c.e(SearchFragment.class, new Bundle());
    }

    public final void x(Bundle bundle) {
        f.z.d.j.e(bundle, "bundle");
        e.c.a.g.a.d.v.c.e(SearchFragment.class, bundle);
    }

    public final void y() {
        e.c.a.g.a.e.b.b(new YoungBITask(2011, "click"));
        e.c.a.g.a.d.v.c.e(SettingFragment.class, new Bundle());
    }

    public final void z() {
        e.c.a.g.a.d.v.c.e(SongReportFragment.class, new Bundle());
    }
}
