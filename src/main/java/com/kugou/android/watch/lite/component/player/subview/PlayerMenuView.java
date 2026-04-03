package com.kugou.android.watch.lite.component.player.subview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.player.wdiget.PlayerSoundDialog;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.g.j.f.g;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.t.e;
import f.s;
import f.z.d.j;
import f.z.d.k;
import f.z.d.q;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerMenuView extends e.c.a.g.a.g.j.c.a implements View.OnClickListener {
    public final View b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f162d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f163f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f165i;
    public PlayerSoundDialog j;
    public Handler k;
    public final BroadcastReceiver l;

    /* JADX INFO: loaded from: classes2.dex */
    public static final class a implements Runnable {
        public final /* synthetic */ q b;

        public a(q qVar) {
            this.b = qVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.d("mhs_watch", "changePlayMode = onResume step 3");
            PlayerMenuView.this.F(this.b.a);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class b extends k implements f.z.c.a<s> {
        public b() {
            super(0);
        }

        public final void a() {
            PlayerMenuView.this.I(true);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            PlayerMenuView.this.f165i = false;
            PlayerMenuView.this.j = null;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                PlayerMenuView.this.A();
            } catch (Exception e2) {
                g0.k(e2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerMenuView(View view, e.c.a.g.a.g.j.c.b bVar) {
        super(bVar);
        j.e(view, "contentView");
        j.e(bVar, "provider");
        this.b = view;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_sound);
        this.f162d = imageView;
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_play_mode);
        this.f163f = imageView2;
        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_more);
        this.f164h = imageView3;
        this.k = new Handler(Looper.getMainLooper());
        this.l = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.component.player.subview.PlayerMenuView$mBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                j.e(context, "context");
                j.e(intent, "intent");
                if (j.a("com.kugou.young.watch.playmodechanged", intent.getAction())) {
                    this.a.J();
                    Log.d("mhs_watch", "service updatePlaybackState， ");
                }
            }
        };
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
    }

    public final void A() {
        if (e.c.a.g.a.t.c.b) {
            if (e.c.a.g.a.t.c.f1231f == null && e.c.a.g.a.t.c.f1233h == null) {
                return;
            }
            boolean zE = e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true);
            q qVar = new q();
            qVar.a = -1;
            Log.d("mhs_watch", j.l("changePlayMode = show = ", Boolean.valueOf(zE)));
            if (!zE) {
                Log.d("mhs_watch", "changePlayMode = onResume step 1");
                Pair<Boolean, Integer> pair = e.c.a.g.a.t.c.f1231f;
                if (pair != null) {
                    Object obj = pair.second;
                    j.d(obj, "sPlayModePair.second");
                    qVar.a = ((Number) obj).intValue();
                    e.c.a.g.a.t.c.f1231f = null;
                }
            }
            if (!zE) {
                Log.d("mhs_watch", "changePlayMode = onResume step 2");
                Pair<Boolean, Integer> pair2 = e.c.a.g.a.t.c.f1233h;
                if (pair2 != null) {
                    Object obj2 = pair2.second;
                    j.d(obj2, "sAutoSendChangeModePair.second");
                    qVar.a = ((Number) obj2).intValue();
                    e.c.a.g.a.t.c.f1233h = null;
                }
            }
            if (qVar.a != -1) {
                this.k.postDelayed(new a(qVar), 1000L);
            }
        }
    }

    public final void B() {
        View viewFindViewById = this.b.findViewById(R.id.holder_scroll_view);
        j.d(viewFindViewById, "contentView.findViewById(R.id.holder_scroll_view)");
        new g(viewFindViewById).c(new b());
    }

    public final String C(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? "已切换 顺序播放" : "已切换 随机播放" : "已切换 单曲循环" : "已切换 顺序播放";
    }

    public final int D(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? R.drawable.ic_mode_all : R.drawable.ic_mode_random : R.drawable.ic_mode_single : R.drawable.ic_mode_all;
    }

    public final void E() {
        int iB = e.c.a.g.a.f.m.c.a.b("play_mode", 0);
        f.F(iB);
        this.f163f.setImageResource(D(iB));
    }

    public final void F(int i2) {
        if (g0.f()) {
            g0.b("mhs_watch", j.l("Handling setting loop mode action loopMode = ", Integer.valueOf(i2)));
        }
        if (i2 == 0) {
            ImageView imageView = this.f163f;
            j.d(imageView, "ivPlayMode");
            z(imageView, 0);
        } else if (i2 == 1) {
            ImageView imageView2 = this.f163f;
            j.d(imageView2, "ivPlayMode");
            z(imageView2, 1);
        } else {
            if (i2 != 2) {
                return;
            }
            ImageView imageView3 = this.f163f;
            j.d(imageView3, "ivPlayMode");
            z(imageView3, 2);
        }
    }

    public final void G(View view) {
        if (e.c.a.g.a.g.j.c.a.b(this, false, false, false, true, view, null, 32, null)) {
            e.c.a.g.a.g.j.g.a.a(14, d().getCur());
            s0.a.r(d().getFragment());
        }
    }

    public final void H(View view) {
        if (e.c.a.g.a.g.j.c.a.b(this, false, false, false, true, view, null, 32, null)) {
            I(false);
            e.c.a.g.a.g.j.g.a.a(46, d().getCur());
        }
    }

    public final void I(boolean z) {
        if (this.f165i) {
            return;
        }
        this.f165i = true;
        PlayerSoundDialog playerSoundDialog = new PlayerSoundDialog(d());
        playerSoundDialog.setOnDismissListener(new c());
        if (z) {
            playerSoundDialog.f();
        }
        s sVar = s.a;
        this.j = playerSoundDialog;
        if (playerSoundDialog == null) {
            return;
        }
        playerSoundDialog.show();
    }

    public final void J() {
        Log.d("mhs_watch", "updatePlayMode, 监听到模式切换");
        int i2 = f.i();
        Log.d("mhs_watch", j.l("updatePlayMode, mode = ", Integer.valueOf(i2)));
        this.f163f.setImageResource(D(i2));
        this.f163f.requestLayout();
    }

    public final void K() {
        if (e.a.x()) {
            this.k.post(new d());
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void e() {
        E();
        if (l1.f0()) {
            B();
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        e.c.a.g.a.t.c.f1232g = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.young.watch.playmodechanged");
        e.c.a.g.a.f.d.a.b(this.l, intentFilter);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void j() {
        super.j();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        e.c.a.g.a.t.c.f1232g = false;
        Log.e("mhs_watch_resume", "PlayerMenuView onDestroy");
        e.c.a.g.a.f.d.a.g(this.l);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void l() {
        PlayerSoundDialog playerSoundDialog;
        super.l();
        if (this.f165i && (playerSoundDialog = this.j) != null) {
            playerSoundDialog.dismiss();
        }
        Log.e("mhs_watch", ", 播放组件不可见 sHasShowPlayerPage = " + e.c.a.g.a.t.c.f1232g + ", hashcode = " + hashCode());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_more) {
            G(view);
        } else if (id == R.id.iv_play_mode) {
            y(view);
        } else {
            if (id != R.id.iv_sound) {
                return;
            }
            H(view);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.t.b bVar) {
        j.e(bVar, NotificationCompat.CATEGORY_EVENT);
        K();
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void p() {
        super.p();
        if (e.a.x()) {
            if (g0.f()) {
                g0.b("mhs_watch", "menu, onResume = " + hashCode() + ", 展示了播放页面 VoiceCmdEvent.sHasFinishLoginCheck = " + e.c.a.g.a.t.c.b + ", VoiceCmdEvent.sPlayModePair = " + e.c.a.g.a.t.c.f1231f + ", VoiceCmdEvent.sAutoSendChangeModePair = " + e.c.a.g.a.t.c.f1233h + ", SystemUtils.isXTC() = " + l1.m0());
            }
            Log.e("mhs_watch", j.l("sHasShowPlayerPage = true, 播放组件可见 hash code = ", Integer.valueOf(hashCode())));
            K();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void s(boolean z) {
        super.s(z);
        e.c.a.g.a.g.f.e.a(d().getFragment());
    }

    public final void y(View view) {
        if (e.c.a.g.a.g.j.c.a.b(this, false, false, false, true, view, null, 32, null)) {
            int i2 = f.i();
            Integer[] numArr = {0, 2, 1};
            int i3 = 0;
            for (int i4 = 0; i4 < 3; i4++) {
                i3++;
                if (numArr[i4].intValue() == i2) {
                    int iIntValue = numArr[i3 % 3].intValue();
                    f.F(iIntValue);
                    this.f163f.setImageResource(D(iIntValue));
                    e.c.a.g.a.f.m.c.a.g("play_mode", iIntValue);
                    p1.h(KGApplication.getContext(), C(iIntValue));
                }
            }
            e.c.a.g.a.g.j.g.a.a(22, d().getCur());
        }
    }

    public final void z(View view, int i2) {
        Log.d("mhs_watch", "changePlayMode = 1");
        if (e.c.a.g.a.g.j.c.a.b(this, false, false, false, false, view, null, 32, null)) {
            f.F(i2);
            Log.d("mhs_watch", j.l("changePlayMode = mode = ", Integer.valueOf(i2)));
            this.f163f.setImageResource(D(i2));
            this.f163f.requestLayout();
            e.c.a.g.a.f.m.c.a.g("play_mode", i2);
            g0.b("mhs_watch", "setImageResource changePlayMode = " + i2 + ", ivPlayMode = " + this.f163f + ", contentView.findViewById<ImageView>(R.id.iv_play_mode) = " + this.b.findViewById(R.id.iv_play_mode));
            Context context = KGApplication.getContext();
            if (context == null) {
                View view2 = this.b;
                context = view2 == null ? null : view2.getContext();
            }
            p1.h(context, C(i2));
            g0.b("mhs_watch", "setImageResource getDescText(mode) = " + C(i2) + ", content = " + KGApplication.getContext() + ", contentView = " + this.b);
            e.c.a.g.a.g.j.g.a.a(22, d().getCur());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.t.c cVar) {
        j.e(cVar, NotificationCompat.CATEGORY_EVENT);
        int i2 = cVar.a;
        if (i2 == 5 || i2 == 6 || i2 == 7) {
            Log.d("mhs_watch_mode", j.l("VoiceCmdEvent setting loop mode action, 切换模式 event.eventType = ", Integer.valueOf(i2)));
        }
        int i3 = cVar.a;
        if (i3 == 5) {
            ImageView imageView = this.f163f;
            j.d(imageView, "ivPlayMode");
            z(imageView, 0);
        } else if (i3 == 6) {
            ImageView imageView2 = this.f163f;
            j.d(imageView2, "ivPlayMode");
            z(imageView2, 1);
        } else if (i3 == 7) {
            ImageView imageView3 = this.f163f;
            j.d(imageView3, "ivPlayMode");
            z(imageView3, 2);
        }
    }
}
