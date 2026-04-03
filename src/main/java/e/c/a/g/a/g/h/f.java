package e.c.a.g.a.g.h;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.common.apm.task.PicEntryAPM;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.v1;

/* JADX INFO: loaded from: classes2.dex */
public class f implements View.OnClickListener {
    public final DelegateFragment a;
    public final View b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f793d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f794f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PicEntryAPM f796i = new PicEntryAPM();
    public boolean j = ApmReportHelper.INSTANCE.enablePicReport();
    public StringBuilder k = new StringBuilder();

    public class a implements RequestListener<Drawable> {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: e.c.a.g.a.g.h.f$a$a, reason: collision with other inner class name */
        public class RunnableC0125a implements Runnable {
            public RunnableC0125a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.d(e.c.a.g.a.r.b.s(), 2);
            }
        }

        public a(int i2, String str) {
            this.a = i2;
            this.b = str;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(@NonNull Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            Log.d("mhs_watch_pic", "头像 图片加载成功");
            f.this.f796i.success(this.b);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            if (glideException != null) {
                if (g0.f()) {
                    Log.e("mhs_watch_pic", "加载失败: " + glideException.getMessage(), glideException);
                }
                f.this.k.append("source = " + this.a + ", 图片加载失败: " + glideException.getMessage());
            }
            int i2 = this.a;
            if (i2 == 1) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0125a());
                return false;
            }
            if (i2 != 2) {
                return false;
            }
            f.this.f796i.fail(Integer.valueOf(TextUtils.isEmpty(this.b) ? 2 : 1), f.this.k.toString());
            f.this.k = new StringBuilder();
            return false;
        }
    }

    public f(DelegateFragment delegateFragment, View view) {
        this.a = delegateFragment;
        this.b = view;
        ImageView imageView = (ImageView) view.findViewById(R.id.icon_login);
        this.f793d = imageView;
        TextView textView = (TextView) view.findViewById(R.id.login_title);
        this.f794f = textView;
        this.f795h = (ImageView) view.findViewById(R.id.iv_vip_state);
        imageView.setOnClickListener(this);
        textView.setOnClickListener(this);
        c();
    }

    public void c() {
        if (e.c.a.g.a.r.b.F()) {
            if (this.j) {
                this.f796i.start();
            }
            this.f794f.setText(e.c.a.g.a.r.b.r());
            int iC = v1.c();
            if (iC > 0) {
                this.f795h.setImageResource(iC);
                this.f795h.setVisibility(0);
            } else {
                this.f795h.setVisibility(8);
            }
            String strS = e.c.a.g.a.r.b.s();
            String strT = e.c.a.g.a.r.b.t();
            try {
                if (this.j) {
                    d(strT, 1);
                } else {
                    Glide.with(this.a).load(strT).placeholder(R.drawable.icon_main_login_entry).error(Glide.with(this.a).load(strS).placeholder(R.drawable.icon_main_login_entry)).into(this.f793d);
                }
            } catch (Exception e2) {
                g0.l(e2, true);
                e2.printStackTrace();
            }
        } else {
            this.f795h.setVisibility(8);
            this.f793d.setImageResource(R.drawable.icon_main_login_entry);
            this.f794f.setText("点击登录");
        }
        this.b.setVisibility(0);
    }

    public final void d(String str, int i2) {
        Glide.with(this.a).load(str).placeholder(R.drawable.icon_main_login_entry).error(R.drawable.icon_main_login_entry).listener(new a(i2, str)).into(this.f793d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (e.c.a.g.a.r.b.F()) {
            s0.a.y();
        } else {
            s0.a.l("1");
        }
    }
}
