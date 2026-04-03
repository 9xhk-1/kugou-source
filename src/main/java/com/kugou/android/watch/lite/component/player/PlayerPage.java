package com.kugou.android.watch.lite.component.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.v.c;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.g.j.c.b;
import e.c.a.g.a.g.j.f.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import f.s;
import f.z.d.j;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class PlayerPage {
    public b a;
    public View b;
    public DelegateFragment c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Receiver f159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f160f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f158d = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f161g = new a();

    public static final class Receiver extends BroadcastReceiver {
        public final WeakReference<PlayerPage> a;

        public Receiver(PlayerPage playerPage) {
            j.e(playerPage, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.a = new WeakReference<>(playerPage);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j.e(context, "context");
            j.e(intent, "intent");
            PlayerPage playerPage = this.a.get();
            if ((playerPage == null ? null : playerPage.c()) != null) {
                playerPage.o(intent);
            }
        }
    }

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVarE = PlayerPage.this.e();
            e.c.a.g.a.g.j.g.a.a(0, bVarE == null ? null : bVarE.getCur());
        }
    }

    public final void b(DelegateFragment delegateFragment, int i2) {
        j.e(delegateFragment, "base");
        this.c = delegateFragment;
        b bVar = this.a;
        if (bVar != null) {
            bVar.changeBaseAndHostType(delegateFragment, i2);
        }
        d dVar = this.f160f;
        if (dVar == null) {
            return;
        }
        dVar.g(delegateFragment, i2);
    }

    public final DelegateFragment c() {
        return this.c;
    }

    public final int d() {
        return this.f158d;
    }

    public final b e() {
        return this.a;
    }

    public final View f() {
        return this.b;
    }

    public final void g() {
        d dVar = this.f160f;
        if (dVar == null) {
            return;
        }
        dVar.i(e.c.a.g.a.f.n.a.b().e(40, ""));
    }

    public final void h(String str) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.onCoverChanged(str);
        }
        d dVar = this.f160f;
        if (dVar == null) {
            return;
        }
        dVar.i(str);
    }

    public final void i() {
        View viewInflate = LayoutInflater.from(KGApplication.getContext()).inflate(R.layout.fragment_player, (ViewGroup) null, false);
        this.b = viewInflate;
        e.c.a.g.a.f.o.d.a(viewInflate);
    }

    public final void j() {
        d dVar = this.f160f;
        if (dVar != null) {
            dVar.j();
        }
        e.c.a.g.a.f.d.a.g(this.f159e);
        this.c = null;
        this.a = null;
        this.b = null;
    }

    public final void k(KGMusicWrapper kGMusicWrapper) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.onMetaDataChanged(kGMusicWrapper);
        }
        if (kGMusicWrapper == null) {
            d dVar = this.f160f;
            if (dVar == null) {
                return;
            }
            dVar.o();
            return;
        }
        d dVar2 = this.f160f;
        if (dVar2 == null) {
            return;
        }
        dVar2.k();
    }

    public final void l() {
        DelegateFragment fragment;
        b bVar = this.a;
        if (bVar != null) {
            bVar.setResume(false);
        }
        d dVar = this.f160f;
        if (dVar != null) {
            dVar.l();
        }
        e.c.a.g.a.g.j.g.b.d().h();
        b bVar2 = this.a;
        FragmentActivity activity = null;
        if (bVar2 != null && (fragment = bVar2.getFragment()) != null) {
            activity = fragment.getActivity();
        }
        if (activity == null || !l1.U()) {
            return;
        }
        l1.I(activity);
    }

    public final void m(boolean z) {
        FragmentActivity fragmentActivityRequireActivity;
        b bVar = this.a;
        if (bVar != null) {
            bVar.onPlayStateChanged(z);
        }
        d dVar = this.f160f;
        if (dVar != null) {
            dVar.m();
        }
        AbsFrameworkFragment absFrameworkFragmentB = c.b();
        FragmentActivity activity = null;
        if (absFrameworkFragmentB == null) {
            fragmentActivityRequireActivity = null;
        } else {
            try {
                try {
                    fragmentActivityRequireActivity = absFrameworkFragmentB.requireActivity();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    fragmentActivityRequireActivity = null;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                g0.l(e3, true);
                return;
            }
        }
        if (fragmentActivityRequireActivity == null) {
            DelegateFragment delegateFragment = this.c;
            if (delegateFragment != null) {
                activity = delegateFragment.getActivity();
            }
            fragmentActivityRequireActivity = activity;
        }
        if (fragmentActivityRequireActivity == null) {
            return;
        }
        e.c.a.g.a.g.h.l.c.a.e(fragmentActivityRequireActivity, z);
    }

    public final void n() {
        d dVar = this.f160f;
        if (dVar == null) {
            return;
        }
        dVar.n();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void o(Intent intent) {
        String action;
        d dVar;
        d dVar2;
        d dVar3;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        switch (action.hashCode()) {
            case -1501101020:
                if (action.equals("com.kugou.android.mymusic.fav.list_id_done") && (dVar = this.f160f) != null) {
                    dVar.s(true);
                    return;
                }
                return;
            case -1203446588:
                if (action.equals("com.kugou.young.watch.playstatechanged")) {
                    boolean booleanExtra = intent.getBooleanExtra("arg_is_playing", false);
                    m(booleanExtra);
                    if (booleanExtra) {
                        b bVar = this.a;
                        if (bVar != null && bVar.isResume()) {
                            e.c.a.g.a.g.j.g.b.d().i();
                            return;
                        }
                    }
                    e.c.a.g.a.g.j.g.b.d().h();
                    return;
                }
                return;
            case -643285989:
                if (action.equals("com.kugou.android.user_login_out") && (dVar2 = this.f160f) != null) {
                    dVar2.s(false);
                    return;
                }
                return;
            case -502153045:
                if (!action.equals("com.kugou.android.update_fav_btn_state")) {
                    return;
                }
                break;
            case -411132336:
                action.equals("com.kugou.android.user_login_success");
                return;
            case 147483024:
                if (action.equals("com.kugou.young.watch.queuechanged")) {
                    n();
                    return;
                }
                return;
            case 764269154:
                if (action.equals("com.kugou.young.watch.metachanged")) {
                    KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) intent.getParcelableExtra("arg_song");
                    k(kGMusicWrapper);
                    v(kGMusicWrapper);
                    return;
                }
                return;
            case 875757098:
                if (!action.equals("com.kugou.android.cloud_music_delete_success")) {
                    return;
                }
                break;
            case 1522534442:
                if (action.equals("com.kugou.young.watch.coverchanged")) {
                    Bundle extras = intent.getExtras();
                    h(extras == null ? null : extras.getString("arg_song_cover"));
                    return;
                }
                return;
            case 1937871315:
                if (action.equals("com.kugou.android.action.config.update.complete") && (dVar3 = this.f160f) != null) {
                    dVar3.h();
                    return;
                }
                return;
            default:
                return;
        }
        d dVar4 = this.f160f;
        if (dVar4 == null) {
            return;
        }
        dVar4.s(false);
    }

    public final void p() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.setResume(true);
        }
        d dVar = this.f160f;
        if (dVar != null) {
            dVar.p();
        }
        w();
        e.c.a.g.a.g.j.g.b.d().i();
    }

    public final void q() {
        if (this.a == null) {
            this.a = new e.c.a.g.a.g.j.b(this.c, this.f158d);
        }
        b bVar = this.a;
        if (bVar != null) {
            bVar.changeBaseAndHostType(this.c, this.f158d);
        }
        if (this.f160f == null) {
            b bVar2 = this.a;
            j.c(bVar2);
            View view = this.b;
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            this.f160f = new d(bVar2, (ViewGroup) view);
        }
        if (this.f159e == null) {
            Receiver receiver = new Receiver(this);
            this.f159e = receiver;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.kugou.young.watch.metachanged");
            intentFilter.addAction("com.kugou.young.watch.queuechanged");
            intentFilter.addAction("com.kugou.young.watch.playstatechanged");
            intentFilter.addAction("com.kugou.young.watch.coverchanged");
            intentFilter.addAction("com.kugou.android.user_login_success");
            intentFilter.addAction("com.kugou.android.user_login_out");
            intentFilter.addAction("com.kugou.android.cloud_music_delete_success");
            intentFilter.addAction("com.kugou.android.update_fav_btn_state");
            intentFilter.addAction("com.kugou.android.mymusic.fav.list_id_done");
            intentFilter.addAction("com.kugou.android.action.config.update.complete");
            s sVar = s.a;
            e.c.a.g.a.f.d.a.b(receiver, intentFilter);
        }
        v(f.e());
    }

    public final void r() {
        View view = this.b;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public final void s(DelegateFragment delegateFragment) {
        this.c = delegateFragment;
    }

    public final void t(int i2) {
        this.f158d = i2;
    }

    public final void u(boolean z) {
        d dVar = this.f160f;
        if (dVar == null) {
            return;
        }
        dVar.r(z);
    }

    public final void v(KGMusicWrapper kGMusicWrapper) {
        e.c.a.g.a.g.j.g.b.d().c();
        e.c.a.g.a.g.j.g.b.d().f(kGMusicWrapper);
        b bVar = this.a;
        boolean z = false;
        if (bVar != null && bVar.isResume()) {
            z = true;
        }
        if (z) {
            e.c.a.g.a.g.j.g.b.d().i();
        }
    }

    public final void w() {
        View view = this.b;
        if (view != null) {
            view.removeCallbacks(this.f161g);
        }
        View view2 = this.b;
        if (view2 == null) {
            return;
        }
        view2.postDelayed(this.f161g, 3000L);
    }
}
