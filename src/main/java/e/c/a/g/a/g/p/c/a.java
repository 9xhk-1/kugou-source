package e.c.a.g.a.g.p.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.d.h.b.e;
import e.c.a.g.a.g.p.d.g;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e implements View.OnClickListener {
    public g a;
    public final Drawable b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f1020d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f1021f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f1022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f1023i;
    public ImageView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, g gVar, Drawable drawable, Drawable drawable2, Drawable drawable3) {
        super(context, R.style.PopDialogTheme);
        j.e(context, "context");
        j.e(gVar, "config");
        j.e(drawable, "coverIcon");
        j.e(drawable2, "closeIcon");
        j.e(drawable3, "confirmIcon");
        this.a = gVar;
        this.b = drawable;
        this.f1020d = drawable2;
        this.f1021f = drawable3;
    }

    public final void a(String str) {
        e.c.a.g.a.e.b.b(new YoungBITask(22020006, "click").setSvar2(str));
    }

    @Override // e.c.a.g.a.d.h.b.e
    public float getDialogAuthority() {
        return 110.0f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "v");
        int id = view.getId();
        if (id == R.id.close_iv) {
            a("2");
            dismiss();
        } else {
            if (id != R.id.confirm_iv) {
                return;
            }
            int iD = this.a.d();
            if (iD == 1) {
                s0.a.A();
            } else if (iD == 2) {
                s0.a.C(new Bundle());
            }
            a("1");
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_vip_expire);
        View viewFindViewById = findViewById(R.id.content_view);
        if (l1.X()) {
            u1.l(viewFindViewById, 17);
        } else {
            u1.k(viewFindViewById);
        }
        this.f1022h = (ImageView) findViewById(R.id.cover_iv);
        this.f1023i = (ImageView) findViewById(R.id.close_iv);
        this.j = (ImageView) findViewById(R.id.confirm_iv);
        ImageView imageView = this.f1022h;
        if (imageView != null) {
            imageView.setImageDrawable(this.b);
        }
        ImageView imageView2 = this.f1023i;
        if (imageView2 != null) {
            imageView2.setImageDrawable(this.f1020d);
        }
        ImageView imageView3 = this.j;
        if (imageView3 != null) {
            imageView3.setImageDrawable(this.f1021f);
        }
        u1.b(this, this.f1023i, this.j);
    }

    @Override // e.c.a.g.a.d.h.b.e, android.app.Dialog
    public void show() {
        super.show();
        e.c.a.g.a.e.b.b(new YoungBITask(22020005, "exposure"));
    }
}
