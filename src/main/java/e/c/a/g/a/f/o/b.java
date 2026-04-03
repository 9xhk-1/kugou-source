package e.c.a.g.a.f.o;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.common.widget.loading.CommonLoadingView;
import e.c.a.g.a.d.h.b.f;
import e.c.a.g.a.f.o.g.c;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class b extends f {
    public CommonLoadingView b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f701d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f702f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f703h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f704i;
    public long j;

    public class a implements c.e {
        public a() {
        }

        @Override // e.c.a.g.a.f.o.g.c.e, e.c.a.g.a.f.o.g.c.f
        public void onPrimaryTrigger() {
            b.this.dismiss();
        }

        @Override // e.c.a.g.a.f.o.g.c.e, e.c.a.g.a.f.o.g.c.f
        public void onSecondaryTrigger() {
        }

        @Override // e.c.a.g.a.f.o.g.c.e
        public void onStart() {
        }

        @Override // e.c.a.g.a.f.o.g.c.e, e.c.a.g.a.f.o.g.c.f
        public void onStartTrigger() {
        }
    }

    public b(Context context) {
        super(context, R.style.KGProgressDialogTheme);
        this.f703h = -1;
        this.f704i = 4;
        this.j = 0L;
        b(context);
    }

    public void a() {
        this.b.getLoadingPresenter().setTimerCallback(null);
    }

    public void b(Context context) {
        this.f701d = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.comm_progress_dialog, (ViewGroup) null);
        this.f702f = viewInflate;
        this.b = (CommonLoadingView) viewInflate.findViewById(R.id.loading_view);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(l1.c(10.0f));
        this.f702f.findViewById(R.id.loading_view_layout).setBackgroundDrawable(gradientDrawable);
    }

    public void c(String str) {
        this.b.setPrimaryText(str);
        if (this.f701d.getString(R.string.loading_tips_primary).equals(str)) {
            this.b.setSecondaryText(this.f701d.getString(R.string.loading_tips_secondary));
        } else {
            this.b.setSecondaryText(str);
        }
    }

    public void d(int i2) {
        CommonLoadingView commonLoadingView = this.b;
        if (commonLoadingView == null || commonLoadingView.getLoadingPresenter() == null) {
            return;
        }
        this.b.getLoadingPresenter().setTimeSpec(i2);
    }

    @Override // e.c.a.g.a.d.h.b.f, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.j > 0) {
            this.j = 0L;
        }
        super.dismiss();
    }

    public void e(int i2) {
        this.f704i = i2;
    }

    public void f(int i2) {
        this.f703h = i2;
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f702f);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        View view = this.f702f;
        if (view != null) {
            int i2 = this.f703h;
            if (i2 == -1) {
                view.setTag(805306114, Integer.valueOf(e.c.a.g.a.d.w.a.i(this.b)));
            } else {
                view.setTag(805306114, Integer.valueOf(i2));
            }
            CommonLoadingView commonLoadingView = this.b;
            if (commonLoadingView != null) {
                commonLoadingView.setType(this.f704i);
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = this.f701d;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        super.show();
        this.b.getLoadingPresenter().setTimerCallback(new a());
        this.b.getLoadingPresenter().startAnimWithTimer();
        this.j = System.currentTimeMillis();
    }
}
