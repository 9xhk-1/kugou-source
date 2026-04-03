package e.c.a.g.a.g.j.f;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.apm.task.PlayerPicAPM;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import f.z.d.j;
import f.z.d.r;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e.c.a.g.a.g.j.c.a {
    public final ImageView b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f942d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PlayerPicAPM f943f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f944h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public StringBuilder f945i;

    public static final class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.c.a.g.a.m.a aVar = e.c.a.g.a.m.a.a;
            Context context = KGApplication.getContext();
            j.d(context, "getContext()");
            aVar.h(context, this.a);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.j.f.b$b, reason: collision with other inner class name */
    public static final class C0142b implements RequestListener<Drawable> {
        public final /* synthetic */ r<String> b;

        public C0142b(r<String> rVar) {
            this.b = rVar;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            j.e(drawable, "resource");
            j.e(obj, "model");
            j.e(target, "target");
            j.e(dataSource, "dataSource");
            Log.d("mhs_watch_pic", "播放器 图片加载成功");
            b.this.f943f.success(this.b.a);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            j.e(obj, "model");
            j.e(target, "target");
            if (glideException != null) {
                if (g0.f()) {
                    Log.e("mhs_watch_pic", j.l("加载失败: ", glideException.getMessage()), glideException);
                }
                b.this.u().append(j.l("图片加载失败: ", glideException.getMessage()));
            }
            b.this.f943f.fail(Integer.valueOf(TextUtils.isEmpty(this.b.a) ? 2 : 1), b.this.u().toString());
            b.this.w(new StringBuilder());
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view, e.c.a.g.a.g.j.c.b bVar) {
        super(bVar);
        j.e(view, "contentView");
        j.e(bVar, "provider");
        this.b = (ImageView) view.findViewById(R.id.song_cover);
        this.f942d = ContextCompat.getDrawable(KGApplication.getContext(), R.drawable.album_img_default);
        new Handler(Looper.getMainLooper());
        this.f943f = new PlayerPicAPM();
        this.f944h = ApmReportHelper.INSTANCE.enablePicReport();
        this.f945i = new StringBuilder();
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void e() {
        ImageView imageView = this.b;
        DelegateFragment fragment = d().getFragment();
        Context contextRequireContext = fragment == null ? null : fragment.requireContext();
        if (contextRequireContext == null) {
            contextRequireContext = KGApplication.getContext();
        }
        imageView.setColorFilter(ContextCompat.getColor(contextRequireContext, R.color.black_20), PorterDuff.Mode.SRC_ATOP);
        k();
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void i(String str) {
        v(str);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void k() {
        KGMusicWrapper cur = d().getCur();
        v(cur == null ? null : cur.getImgUrl());
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void p() {
        super.p();
        KGMusicWrapper cur = d().getCur();
        v(cur == null ? null : cur.getImgUrl());
    }

    public final StringBuilder u() {
        return this.f945i;
    }

    public final void v(String str) {
        DelegateFragment fragment = d().getFragment();
        boolean z = (fragment == null || fragment.getContext() == null) ? false : true;
        if (z) {
            Glide.with(fragment).clear(this.b);
        }
        if (TextUtils.isEmpty(str) || d().isQueueEmpty() || !z) {
            this.b.setImageDrawable(this.f942d);
        } else {
            j.d(fragment, "frag");
            x(fragment, str);
        }
        if (l1.m0()) {
            j0.b().a(new a(str));
        }
    }

    public final void w(StringBuilder sb) {
        j.e(sb, "<set-?>");
        this.f945i = sb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    public final void x(Fragment fragment, String str) {
        if (!this.f944h) {
            Glide.with(fragment).load(a0.d(str)).placeholder(this.f942d).error(this.f942d).into(this.b);
            return;
        }
        try {
            r rVar = new r();
            rVar.a = a0.d(str);
            this.f943f.start();
            Glide.with(fragment).load((String) rVar.a).placeholder(this.f942d).error(this.f942d).listener(new C0142b(rVar)).into(this.b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
