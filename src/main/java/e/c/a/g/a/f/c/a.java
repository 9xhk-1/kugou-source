package e.c.a.g.a.f.c;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.d.h.b.e;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e implements View.OnClickListener {
    public final Drawable a;
    public final Drawable b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f635d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AbsFrameworkFragment absFrameworkFragment, Drawable drawable, Drawable drawable2, b bVar) {
        super(absFrameworkFragment.requireContext(), R.style.PopDialogTheme);
        j.e(absFrameworkFragment, "fragment");
        j.e(drawable, "coverImg");
        j.e(drawable2, "buttonImg");
        j.e(bVar, "adEntity");
        this.a = drawable;
        this.b = drawable2;
        this.f635d = bVar;
    }

    public final void a() {
        e.c.a.g.a.e.b.b(new YoungBITask(22020008, "click").setSvar1(String.valueOf(this.f635d.d())));
    }

    @Override // e.c.a.g.a.d.h.b.e
    public float getDialogAuthority() {
        return 115.0f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "v");
        int id = view.getId();
        if (id == R.id.close_iv) {
            dismiss();
            return;
        }
        if (id != R.id.confirm_iv) {
            return;
        }
        int iE = this.f635d.e();
        if (iE == 1) {
            s0.a.A();
        } else if (iE == 2) {
            s0.a.C(new Bundle());
        }
        a();
        dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_com_activity);
        View viewFindViewById = findViewById(R.id.content_view);
        if (l1.X()) {
            u1.l(viewFindViewById, 17);
        } else {
            u1.k(viewFindViewById);
        }
        ImageView imageView = (ImageView) findViewById(R.id.cover_iv);
        ImageView imageView2 = (ImageView) findViewById(R.id.confirm_iv);
        ImageView imageView3 = (ImageView) findViewById(R.id.close_iv);
        if (imageView != null) {
            imageView.setImageDrawable(this.a);
        }
        if (imageView2 != null) {
            imageView2.setImageDrawable(this.b);
        }
        u1.b(this, imageView2, imageView3);
    }

    @Override // e.c.a.g.a.d.h.b.e, android.app.Dialog
    public void show() {
        super.show();
        e.c.a.g.a.e.b.b(new YoungBITask(22020007, "exposure").setSvar1(String.valueOf(this.f635d.d())));
    }
}
