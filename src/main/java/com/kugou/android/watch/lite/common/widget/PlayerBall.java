package com.kugou.android.watch.lite.common.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.component.MainActivity;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.m;
import f.u.l;
import f.u.u;
import f.z.d.g;
import f.z.d.j;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerBall extends FrameLayout implements View.OnClickListener {
    public final ImageView a;
    public Receiver b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f121d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DelegateFragment f122f;

    public static final class Receiver extends BroadcastReceiver {
        public final WeakReference<PlayerBall> a;

        public Receiver(PlayerBall playerBall) {
            j.e(playerBall, "fragment");
            this.a = new WeakReference<>(playerBall);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PlayerBall playerBall;
            if (intent == null || (playerBall = this.a.get()) == null) {
                return;
            }
            playerBall.f(intent);
        }
    }

    public static abstract class a {
        public final View a;

        public a(View view) {
            j.e(view, "root");
            this.a = view;
        }

        public final View a() {
            return this.a;
        }

        public abstract void b();

        public abstract void c();
    }

    public static final class b extends a {
        public final ImageView b;
        public final AnimationDrawable c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            j.e(view, "root");
            ImageView imageView = (ImageView) view.findViewById(R.id.play_anim);
            this.b = imageView;
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.anim_play_entry);
            Drawable drawable = imageView.getDrawable();
            Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            this.c = (AnimationDrawable) drawable;
        }

        @Override // com.kugou.android.watch.lite.common.widget.PlayerBall.a
        public void b() {
            if (this.c.isRunning()) {
                return;
            }
            this.c.start();
        }

        @Override // com.kugou.android.watch.lite.common.widget.PlayerBall.a
        public void c() {
            if (this.c.isRunning()) {
                this.c.stop();
            }
        }
    }

    public static final class c extends a {
        public Animation b;
        public boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            j.e(view, "root");
        }

        @Override // com.kugou.android.watch.lite.common.widget.PlayerBall.a
        public void b() {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.b == null) {
                this.b = AnimationUtils.loadAnimation(a().getContext(), R.anim.anim_rotate);
            }
            a().startAnimation(this.b);
        }

        @Override // com.kugou.android.watch.lite.common.widget.PlayerBall.a
        public void c() {
            if (this.c) {
                this.c = false;
                Animation animation = this.b;
                if (animation == null) {
                    return;
                }
                animation.cancel();
            }
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ List<KGSong> b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends KGSong> list) {
            this.b = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PlayerBall.this.e(((KGSong) u.u(this.b)).r1());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerBall(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        j.e(context, "context");
    }

    public /* synthetic */ PlayerBall(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final RequestManager getRequestManager() {
        RequestManager requestManagerWith;
        String str;
        DelegateFragment delegateFragment = this.f122f;
        if (delegateFragment != null) {
            j.c(delegateFragment);
            requestManagerWith = Glide.with(delegateFragment);
            str = "with(fragment!!)";
        } else {
            requestManagerWith = Glide.with(getContext());
            str = "with(context)";
        }
        j.d(requestManagerWith, str);
        return requestManagerWith;
    }

    public final void c(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper != null) {
            List<KGSong> listB = l.b(e.c.a.g.a.f.j.a.c.i(kGMusicWrapper));
            e.c.a.g.a.d.a.b.d().b(listB, new d(listB));
        }
    }

    public final void d() {
        this.f121d = m.m() ? new c(this) : new b(this);
        h(f.e());
    }

    public final void e(String str) {
        RequestManager requestManager = getRequestManager();
        requestManager.clear(this.a);
        requestManager.load(a0.d(str)).placeholder(R.drawable.album_img_default).error(R.drawable.album_img_default).into(this.a);
    }

    public final void f(Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -1203446588) {
                if (action.equals("com.kugou.young.watch.playstatechanged")) {
                    j(intent.getBooleanExtra("arg_is_playing", false));
                    return;
                }
                return;
            }
            if (iHashCode == 764269154) {
                if (action.equals("com.kugou.young.watch.metachanged")) {
                    Bundle extras = intent.getExtras();
                    h(extras != null ? (KGMusicWrapper) extras.getParcelable("arg_song") : null);
                    return;
                }
                return;
            }
            if (iHashCode == 1522534442 && action.equals("com.kugou.young.watch.coverchanged")) {
                Bundle extras2 = intent.getExtras();
                g(extras2 == null ? null : extras2.getString("arg_song_cover"), null);
            }
        }
    }

    public final void g(String str, KGMusicWrapper kGMusicWrapper) {
        if (!TextUtils.isEmpty(str)) {
            e(str);
        } else {
            this.a.setImageResource(R.drawable.album_img_default);
            c(kGMusicWrapper);
        }
    }

    public final void h(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper != null) {
            g(kGMusicWrapper.getImgUrl(), kGMusicWrapper);
            j(f.q());
        } else {
            g("", kGMusicWrapper);
            j(false);
        }
    }

    public final void i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.young.watch.metachanged");
        intentFilter.addAction("com.kugou.young.watch.coverchanged");
        intentFilter.addAction("com.kugou.young.watch.playstatechanged");
        Receiver receiver = new Receiver(this);
        this.b = receiver;
        e.c.a.g.a.f.d.a.b(receiver, intentFilter);
    }

    public final void j(boolean z) {
        if (z) {
            a aVar = this.f121d;
            if (aVar == null) {
                return;
            }
            aVar.b();
            return;
        }
        a aVar2 = this.f121d;
        if (aVar2 == null) {
            return;
        }
        aVar2.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        Object context = getContext();
        if (context instanceof DelegateFragment) {
            ((DelegateFragment) context).g().F0(true);
        } else if (context instanceof MainActivity) {
            ((MainActivity) context).K(true);
        }
        YoungBITask youngBITask = new YoungBITask(20480, "click");
        KGMusicWrapper kGMusicWrapperE = f.e();
        String str = "";
        if (kGMusicWrapperE != null && (string = Long.valueOf(kGMusicWrapperE.getMixId()).toString()) != null) {
            str = string;
        }
        e.c.a.g.a.e.b.b(youngBITask.setMixsongid(str));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j(false);
        e.c.a.g.a.f.d.a.g(this.b);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        d();
    }

    public final void setupFragment(DelegateFragment delegateFragment) {
        j.e(delegateFragment, "fragment");
        this.f122f = delegateFragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerBall(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        j.e(context, "context");
        LayoutInflater.from(context).inflate(R.layout.widget_player_ball, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R.id.song_cover);
        j.d(viewFindViewById, "findViewById(R.id.song_cover)");
        ImageView imageView = (ImageView) viewFindViewById;
        this.a = imageView;
        imageView.setColorFilter(ContextCompat.getColor(context, R.color.black_20), PorterDuff.Mode.SRC_ATOP);
        setOnClickListener(this);
    }
}
