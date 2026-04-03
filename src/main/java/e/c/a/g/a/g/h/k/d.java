package e.c.a.g.a.g.h.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.widget.MarqueeTextView;
import com.kugou.android.watch.lite.guessyoulike.GuessYouLikeHelper;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.h.h;
import e.c.a.g.a.h.i;
import e.c.a.g.a.p.l;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.r;
import e.c.a.g.a.s.u0;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends e.c.a.g.a.g.h.a implements View.OnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f809d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f810f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f812i;
    public final TextView j;
    public ArrayList<KGSong> k;
    public boolean l;
    public long m;
    public KGSong n;
    public volatile boolean o;
    public final BroadcastReceiver p;
    public String q;
    public int r;
    public final e.c.a.g.a.k.d.a s;

    public class a extends BroadcastReceiver {
        public a() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
            }
            action.hashCode();
            byte b = -1;
            switch (action.hashCode()) {
                case -1399257652:
                    if (action.equals("com.kugou.young.watch.playtotail")) {
                        b = 0;
                    }
                    break;
                case -816261678:
                    if (action.equals("com.kugou.android.login_token_expire")) {
                        b = 1;
                    }
                    break;
                case -643285989:
                    if (action.equals("com.kugou.android.user_login_out")) {
                        b = 2;
                    }
                    break;
                case -411132336:
                    if (action.equals("com.kugou.android.user_login_success")) {
                        b = 3;
                    }
                    break;
                case 764269154:
                    if (action.equals("com.kugou.young.watch.metachanged")) {
                        b = 4;
                    }
                    break;
                case 1416841241:
                    if (action.equals("com.kugou.young.watch.resumedsuccess")) {
                        b = 5;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    d.this.p();
                    break;
                case 1:
                case 2:
                case 3:
                    d.this.t(false, null);
                    break;
                case 4:
                    Bundle extras = intent.getExtras();
                    KGMusicWrapper kGMusicWrapper = extras != null ? (KGMusicWrapper) extras.getParcelable("arg_song") : null;
                    if (kGMusicWrapper != null) {
                        d.this.l(kGMusicWrapper.getKgmusic());
                    }
                    break;
                case 5:
                    d.this.z();
                    break;
            }
        }
    }

    public class b implements Runnable {

        public class a implements r<KGSong> {
            public a(b bVar) {
            }

            @Override // e.c.a.g.a.s.r
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean isFilter(KGSong kGSong) {
                return e.c.a.g.a.g.o.b.g(kGSong);
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.g.h.k.d$b$b, reason: collision with other inner class name */
        public class RunnableC0128b implements Runnable {
            public RunnableC0128b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.A();
                d.this.z();
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zG;
            e.c.a.g.a.h.d dVar;
            i iVarF = GuessYouLikeHelper.g().f("刷新");
            d.this.l = true;
            d.this.o();
            if (iVarF == null || iVarF.a != 1 || (dVar = iVarF.f1071h) == null) {
                zG = false;
            } else {
                ArrayList<KGSong> arrayListA = dVar.a();
                l0.a(arrayListA, new a(this));
                d.this.k = arrayListA;
                d.this.x();
                d.this.f811h.post(new RunnableC0128b());
                zG = true ^ l0.g(arrayListA);
            }
            if (!zG) {
                RingBiReportHelper.INSTANCE.reportHead3("推荐列表无数据", "radio");
            }
            d.this.r(iVarF);
            d.this.o = false;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ KGSong a;
        public final /* synthetic */ StringBuilder b;

        public c(KGSong kGSong, StringBuilder sb) {
            this.a = kGSong;
            this.b = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            Glide.with(d.this.a).load(a0.d(this.a.r1())).error(R.drawable.album_img_default).into(d.this.f811h);
            d.this.z();
            d.this.w(this.a, this.b.toString());
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.h.k.d$d, reason: collision with other inner class name */
    public class RunnableC0129d implements Runnable {
        public RunnableC0129d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.y(true, e.c.a.g.a.f.j.a.c.g(d.this.k, Initiator.create(d.this.a.m()).carryPagePath(d.this.a.n()), "28"), d.this.j(), true, d.this.a.l());
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c.a.g.a.h.d dVar;
            i iVarF = GuessYouLikeHelper.g().f("播放器追加");
            if (iVarF == null || iVarF.a != 1 || (dVar = iVarF.f1071h) == null) {
                return;
            }
            d.this.k = dVar.a();
            f.c(false, e.c.a.g.a.f.j.a.c.h(d.this.k, Initiator.create(d.this.a.m()).carryPagePath(d.this.a.n()), "28", true));
        }
    }

    public d(DelegateFragment delegateFragment, View view) {
        super(delegateFragment, view);
        this.f809d = e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.y2, true);
        this.l = false;
        this.m = -1L;
        this.n = null;
        this.o = false;
        a aVar = new a();
        this.p = aVar;
        this.q = "猜你喜欢入口";
        this.r = 10;
        this.s = new e.c.a.g.a.k.d.a(ApmDataTypeID.RCM_ENTRY_REPORT);
        this.f810f = (TextView) view.findViewById(R.id.radio_title);
        this.f811h = (ImageView) view.findViewById(R.id.recommend_img);
        this.f812i = (TextView) view.findViewById(R.id.radio_song_name);
        this.j = (TextView) view.findViewById(R.id.radio_song_singer);
        view.setOnClickListener(this);
        t(false, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.android.user_login_success");
        intentFilter.addAction("com.kugou.android.login_token_expire");
        intentFilter.addAction("com.kugou.android.user_login_out");
        intentFilter.addAction("com.kugou.young.watch.playtotail");
        intentFilter.addAction("com.kugou.young.watch.metachanged");
        intentFilter.addAction("com.kugou.young.watch.resumedsuccess");
        e.c.a.g.a.f.d.a.b(aVar, intentFilter);
    }

    public final void A() {
        if (l0.g(this.k)) {
            y();
        } else {
            B(this.k.get(0));
            Log.e("mhs_watch_radio", "updateUi has data.");
        }
    }

    public final void B(KGSong kGSong) {
        if (kGSong == null) {
            return;
        }
        this.n = kGSong;
        this.f812i.setText(kGSong.A2());
        String[] strArrH2 = kGSong.h2();
        StringBuilder sb = new StringBuilder();
        if (strArrH2.length > 0) {
            int length = strArrH2.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(strArrH2[i2]);
                if (i2 != length - 1) {
                    sb.append("、");
                }
            }
        }
        this.j.setText(sb.toString());
        if (k()) {
            this.f811h.setImageResource(R.drawable.young_ic_def_radio);
        } else {
            e.c.a.g.a.d.a.b.d().b(Collections.singletonList(kGSong), new c(kGSong, sb));
        }
    }

    public final void C(String str, String str2, String str3) {
        this.f812i.setText(str);
        this.j.setText(str2);
        Glide.with(this.a).load(a0.d(str3)).error(R.drawable.album_img_default).into(this.f811h);
    }

    public void h() {
        KGSong kGSong = this.k.get(0);
        if (kGSong != null) {
            e.c.a.g.a.e.b.b(new YoungBITask(20477, "click").setMixsongid(String.valueOf(kGSong.T1())));
            if (e.c.a.g.a.r.b.O() || h.a(kGSong)) {
                return;
            }
            RingBiReportHelper.INSTANCE.reportHead3("推荐列表 不能播放 resetSongOrder isvip = " + e.c.a.g.a.r.b.O(), "");
        }
    }

    public void i() {
        e.c.a.g.a.f.d.a.g(this.p);
    }

    public final int j() {
        if (this.n != null && !l0.g(this.k)) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                KGSong kGSong = this.k.get(i2);
                if (kGSong.T1() != 0 && this.n.T1() == kGSong.T1()) {
                    return i2;
                }
            }
        }
        return 0;
    }

    public final boolean k() {
        return e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.v2, false);
    }

    public void l(KGMusic kGMusic) {
        if (!f.n() || kGMusic == null) {
            return;
        }
        B(KGSong.e1(kGMusic));
    }

    public void m() {
        TextView textView;
        TextView textView2;
        if (this.f809d && (textView2 = this.j) != null && (textView2 instanceof MarqueeTextView)) {
            ((MarqueeTextView) textView2).setFocus(false);
        }
        if (this.f809d && (textView = this.f812i) != null && (textView instanceof MarqueeTextView)) {
            ((MarqueeTextView) textView).setFocus(false);
        }
    }

    public void n() {
        TextView textView;
        TextView textView2;
        if (this.f809d && (textView2 = this.j) != null && (textView2 instanceof MarqueeTextView)) {
            ((MarqueeTextView) textView2).setFocus(true);
        }
        if (this.f809d && (textView = this.f812i) != null && (textView instanceof MarqueeTextView)) {
            ((MarqueeTextView) textView).setFocus(true);
        }
    }

    public void o() {
        this.s.e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u0.n(KGApplication.getApplication(), true)) {
            if (l0.g(this.k)) {
                p1.h(this.a.getContext(), "暂无歌曲");
            } else {
                h();
                u0.d(this.a.requireActivity(), new RunnableC0129d());
            }
        }
    }

    public void p() {
        if (f.n()) {
            j0.b().a(new e());
        }
    }

    public void q() {
        this.s.h(true);
    }

    public void r(i iVar) {
        e.c.a.g.a.h.d dVar;
        if (iVar == null || iVar.f1072i == null || (dVar = iVar.f1071h) == null) {
            this.s.b(null, this.r, this.q, 10);
        } else if (l0.g(dVar.a())) {
            this.s.b(new e.c.a.b.a.a.a.a(iVar.b), this.r, this.q, 11);
        } else {
            this.s.i(true);
        }
    }

    public void s() {
        if (g0.f()) {
            Log.e("mhs_watch_radio", "onResume: channelSongs = " + this.k + ", ListUtil.isEmpty(channelSongs) = " + l0.g(this.k));
        }
        if (l0.g(this.k)) {
            y();
            if (this.o) {
                return;
            }
            t(false, null);
        }
    }

    public void t(boolean z, l lVar) {
        u(lVar);
        if (!u0.n(KGApplication.getApplication(), false)) {
            v();
            this.s.b(null, this.r, this.q, 12);
            return;
        }
        if (this.m != e.c.a.g.a.r.b.o() || z) {
            q();
            this.o = true;
            this.m = e.c.a.g.a.r.b.o();
            j0.b().a(new b());
        }
    }

    public final void u(l lVar) {
        this.f810f.setText(lVar != null ? lVar.a() : e.c.a.g.a.f.m.c.a.e("KEY_ENABLE_PERSONALITY_REC", true) ? "为你推荐" : "大家都在听");
    }

    public void v() {
        if (k()) {
            this.f811h.setImageResource(R.drawable.young_ic_def_radio);
            return;
        }
        String strD = e.c.a.g.a.f.m.c.a.d("key_radio_entry_last_data", "{}");
        if (strD != null) {
            try {
                JSONObject jSONObject = new JSONObject(strD);
                C(jSONObject.optString("song"), jSONObject.optString("singer"), jSONObject.optString("img"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void w(KGSong kGSong, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("song", kGSong.A2());
            jSONObject.put("singer", str);
            jSONObject.put("img", kGSong.r1());
            e.c.a.g.a.f.m.c.a.i("key_radio_entry_last_data", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void x() {
        this.s.j();
    }

    public final void y() {
        TextView textView = this.f812i;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setText("");
        }
        ImageView imageView = this.f811h;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.album_img_default);
        }
        Log.e("mhs_watch_radio", "updateDefaultUi.");
    }

    public void z() {
        if (this.l) {
            l0.g(this.k);
        }
    }
}
