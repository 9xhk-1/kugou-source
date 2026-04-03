package com.kugou.android.watch.lite.component.player.wdiget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u1;
import f.s;
import f.z.c.p;
import f.z.d.j;
import f.z.d.k;
import java.util.Objects;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class PlayerSoundDialog extends e.c.a.g.a.d.h.b.e implements View.OnClickListener {
    public final AudioManager a;
    public ProgressBar b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f176d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f177f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f179i;
    public e.c.a.g.a.g.j.d.b j;
    public boolean k;
    public BroadcastReceiver l;
    public final boolean m;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PlayerSoundDialog.this.dismiss();
        }
    }

    public static final class b extends k implements p<Float, Float, s> {
        public b() {
            super(2);
        }

        public final void a(float f2, float f3) {
            PlayerSoundDialog.this.g(f.a0.b.a(f2 * PlayerSoundDialog.this.f179i));
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ s invoke(Float f2, Float f3) {
            a(f2.floatValue(), f3.floatValue());
            return s.a;
        }
    }

    public static final class c extends k implements f.z.c.a<s> {
        public c() {
            super(0);
        }

        public final void a() {
            PlayerSoundDialog.this.dismiss();
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ s invoke() {
            a();
            return s.a;
        }
    }

    public static final class d<T> implements Action1 {
        public final /* synthetic */ int b;

        public d(int i2) {
            this.b = i2;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            try {
                PlayerSoundDialog.this.a.setStreamVolume(3, this.b, 0);
                Log.e("mhs_watch_anr", "setVolume setStreamVolume.");
            } catch (SecurityException e2) {
                p1.h(PlayerSoundDialog.this.getContext(), "音量调整失败");
                e2.printStackTrace();
            }
        }
    }

    public static final class e<T> implements Action1 {
        public final /* synthetic */ int b;

        public e(int i2) {
            this.b = i2;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            PlayerSoundDialog.this.h(this.b);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PlayerSoundDialog(e.c.a.g.a.g.j.c.b bVar) {
        j.e(bVar, "provider");
        DelegateFragment fragment = bVar.getFragment();
        Context contextRequireContext = fragment == null ? null : fragment.requireContext();
        super(contextRequireContext == null ? KGApplication.getContext() : contextRequireContext, R.style.PopDialogTheme);
        Object systemService = getContext().getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.a = (AudioManager) systemService;
        this.m = e.c.a.g.a.s.c.a.a();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        e.c.a.g.a.g.j.d.b bVar = this.j;
        if (bVar != null) {
            bVar.i();
        }
        e.c.a.g.a.f.d.a.h(this.l);
    }

    public final void f() {
        this.k = true;
    }

    public final void g(int i2) {
        ProgressBar progressBar = this.b;
        if (progressBar == null) {
            j.t("progressVol");
            throw null;
        }
        if (i2 == progressBar.getProgress()) {
            return;
        }
        if (this.m) {
            Observable.just("").subscribeOn(Schedulers.io()).doOnNext(new d(i2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(i2));
            return;
        }
        try {
            this.a.setStreamVolume(3, i2, 0);
        } catch (SecurityException e2) {
            p1.h(getContext(), "音量调整失败");
            e2.printStackTrace();
        }
        h(i2);
    }

    public final void h(int i2) {
        ProgressBar progressBar = this.b;
        if (progressBar == null) {
            j.t("progressVol");
            throw null;
        }
        progressBar.setProgress(i2);
        e.c.a.g.a.g.j.d.b bVar = this.j;
        if (bVar != null) {
            if (this.b == null) {
                j.t("progressVol");
                throw null;
            }
            float progress = r3.getProgress() * 1.0f;
            if (this.b == null) {
                j.t("progressVol");
                throw null;
            }
            bVar.j(progress / r0.getMax());
        }
        Log.e("mhs_watch_anr", "setVolume updateProgressVol.");
    }

    public final void i() {
        int streamMaxVolume = this.a.getStreamMaxVolume(3);
        int streamVolume = this.a.getStreamVolume(3);
        ProgressBar progressBar = this.b;
        if (progressBar == null) {
            j.t("progressVol");
            throw null;
        }
        progressBar.setMax(streamMaxVolume);
        this.f179i = streamMaxVolume;
        h(streamVolume);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_des) {
            g(this.a.getStreamVolume(3) - 1);
        } else {
            if (id != R.id.iv_inc) {
                return;
            }
            g(this.a.getStreamVolume(3) + 1);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        View viewFindViewById;
        super.onCreate(bundle);
        setContentView(R.layout.dialog_player_sound);
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.simple_exit_anim);
        }
        setCanceledOnTouchOutside(false);
        this.f178h = findViewById(R.id.iv_close);
        this.f176d = findViewById(R.id.iv_des);
        this.f177f = findViewById(R.id.iv_inc);
        View viewFindViewById2 = findViewById(R.id.progress_vol);
        j.c(viewFindViewById2);
        j.d(viewFindViewById2, "findViewById(R.id.progress_vol)!!");
        this.b = (ProgressBar) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.lv_content);
        if (viewFindViewById3 != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l1.c(20.0f));
            gradientDrawable.setColor(ContextCompat.getColor(getContext(), R.color.c_1a1a1a));
            s sVar = s.a;
            viewFindViewById3.setBackground(gradientDrawable);
        }
        View view = this.f177f;
        if (view != null) {
            view.setOnClickListener(this);
        }
        View view2 = this.f176d;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        u1.b(new a(), this.f178h, findViewById(R.id.view_click_dismiss_area1), findViewById(R.id.view_click_dismiss_area2));
        if (l1.f0() && (viewFindViewById = findViewById(R.id.holder_scroll_view)) != null) {
            e.c.a.g.a.g.j.d.b bVar = new e.c.a.g.a.g.j.d.b(viewFindViewById);
            bVar.l(1500);
            bVar.m(new b());
            if (this.k) {
                bVar.k(new c());
            }
            s sVar2 = s.a;
            this.j = bVar;
        }
        if (l1.X()) {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.component.player.wdiget.PlayerSoundDialog.onCreate.4
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    j.e(intent, "intent");
                    if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                        PlayerSoundDialog.this.i();
                    }
                }
            };
            this.l = broadcastReceiver;
            e.c.a.g.a.f.d.a.c(broadcastReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        }
        i();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.c.a.g.a.g.j.d.b bVar = this.j;
        if (bVar == null) {
            return;
        }
        bVar.i();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        i();
    }

    @Override // e.c.a.g.a.d.h.b.e, android.app.Dialog
    public void show() {
        super.show();
        e.c.a.g.a.g.j.d.b bVar = this.j;
        if (bVar == null) {
            return;
        }
        bVar.p();
    }
}
