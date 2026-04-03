package com.kugou.android.watch.lite.component.player.lyric;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserModel;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.framework.lyric.LyricData;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.f.o.d;
import e.c.a.g.a.g.j.d.a;
import e.c.a.g.a.s.l1;
import e.c.c.l.f.b;
import f.z.d.j;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@b(id = -1)
public final class MainLyricFragment extends DelegateFragment {
    public Receiver r;
    public a s;

    public static final class Receiver extends BroadcastReceiver {
        public final WeakReference<MainLyricFragment> a;

        public Receiver(MainLyricFragment mainLyricFragment) {
            j.e(mainLyricFragment, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.a = new WeakReference<>(mainLyricFragment);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j.e(context, "context");
            j.e(intent, "intent");
            MainLyricFragment mainLyricFragment = this.a.get();
            if (mainLyricFragment == null || !mainLyricFragment.z()) {
                return;
            }
            mainLyricFragment.B0(intent);
        }
    }

    public final void A0(LyricData lyricData) {
        a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.j(lyricData, x0());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void B0(Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        switch (action.hashCode()) {
            case -1203446588:
                if (action.equals("com.kugou.young.watch.playstatechanged")) {
                    boolean z = false;
                    boolean booleanExtra = intent.getBooleanExtra("arg_is_playing", false);
                    a aVar = this.s;
                    if (aVar != null) {
                        if (getUserVisibleHint() && isResumed() && booleanExtra) {
                            z = true;
                        }
                        aVar.k(z);
                        break;
                    }
                }
                break;
            case -12433275:
                if (action.equals("com.kugou.young.watch.lyrloadsuccess")) {
                    Bundle extras = intent.getExtras();
                    LyricData lyricData = extras == null ? null : (LyricData) extras.getParcelable("arg_lyric_data");
                    String string = extras == null ? null : extras.getString("arg_lyric_hash_data");
                    KGMusicWrapper kGMusicWrapperE = f.e();
                    if (string != null) {
                        if (j.a(string, kGMusicWrapperE != null ? kGMusicWrapperE.getHashValue() : null)) {
                            A0(lyricData);
                        }
                    }
                    y0();
                    break;
                }
                break;
            case 865562224:
                if (action.equals("com.kugou.young.watch.lyrstartload")) {
                    z0();
                    break;
                }
                break;
            case 1804168668:
                if (action.equals("com.kugou.young.watch.lyrloadfail")) {
                    y0();
                    break;
                }
                break;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
        a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.k(false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
        a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.k(x0());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_lyric, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Receiver receiver = this.r;
        if (receiver == null) {
            j.t("mReceiver");
            throw null;
        }
        e.c.a.g.a.f.d.a.g(receiver);
        a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.h();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.k(false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.k(x0());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        d.a(view);
        w0(view);
        this.r = new Receiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.young.watch.playstatechanged");
        intentFilter.addAction("com.kugou.young.watch.lyrstartload");
        intentFilter.addAction("com.kugou.young.watch.lyrloadsuccess");
        intentFilter.addAction("com.kugou.young.watch.lyrloadfail");
        Receiver receiver = this.r;
        if (receiver != null) {
            e.c.a.g.a.f.d.a.b(receiver, intentFilter);
        } else {
            j.t("mReceiver");
            throw null;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "主歌词页";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.k(z && f.q());
    }

    public final void v0(View view) {
        this.s = new a((WatchLyricView) view.findViewById(R.id.lyric_view));
        if (l1.f0()) {
            a aVar = this.s;
            j.c(aVar);
            aVar.f(view.findViewById(R.id.holder_scroll_view));
        }
        e.c.a.g.a.d.x.s.a aVar2 = e.c.a.g.a.d.x.s.a.a;
        String strE = aVar2.e();
        LyricData lyricDataD = aVar2.d();
        KGMusicWrapper kGMusicWrapperE = f.e();
        if (!j.a(strE, kGMusicWrapperE == null ? null : kGMusicWrapperE.getHashValue())) {
            y0();
            return;
        }
        a aVar3 = this.s;
        if (aVar3 == null) {
            return;
        }
        aVar3.j(lyricDataD, x0());
    }

    public final void w0(View view) {
        v0(view);
    }

    public final boolean x0() {
        return getUserVisibleHint() && isResumed() && f.q();
    }

    public final void y0() {
        a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.i();
    }

    public final void z0() {
        a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.i();
    }
}
