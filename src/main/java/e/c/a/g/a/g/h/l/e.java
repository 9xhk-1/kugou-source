package e.c.a.g.a.g.h.l;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;
import f.s;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends e.c.a.g.a.d.h.b.e implements View.OnClickListener {
    public View a;
    public View b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context, R.style.PopDialogTheme);
        j.e(context, "context");
    }

    @Override // e.c.a.g.a.d.h.b.e
    public float getDialogAuthority() {
        return 120.0f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer numValueOf = view == null ? null : Integer.valueOf(view.getId());
        if (numValueOf != null && numValueOf.intValue() == R.id.tv_close) {
            dismiss();
            e.c.a.g.a.e.b.b(new YoungBITask(20490, "click").setType("1"));
        } else if (numValueOf != null && numValueOf.intValue() == R.id.tv_login) {
            dismiss();
            c.a.h(true);
            s0.a.l("6");
            e.c.a.g.a.e.b.b(new YoungBITask(20490, "click").setType("2"));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_newer_logout);
        View viewFindViewById = findViewById(R.id.content_view);
        if (viewFindViewById != null) {
            if (l1.X()) {
                u1.l(viewFindViewById, 17);
            } else if (l1.b0()) {
                e.c.a.g.a.f.o.i.c.a().d(3, viewFindViewById);
            }
            int iZ = l1.z(getContext());
            if (iZ > 600) {
                int i2 = (int) (iZ * 0.1f);
                viewFindViewById.setPadding(i2, viewFindViewById.getPaddingTop(), i2, viewFindViewById.getPaddingBottom());
            }
            if (e.c.a.g.a.f.o.i.c.a().b()) {
                e.c.a.g.a.f.o.i.c.a().d(3, viewFindViewById);
            }
        }
        TextView textView = (TextView) findViewById(R.id.tv_tip);
        this.a = findViewById(R.id.tv_close);
        this.b = findViewById(R.id.tv_login);
        String config = e.c.a.g.a.f.e.c.a.a().getConfig(e.c.a.g.a.f.e.b.n1);
        if ((config.length() > 0) && textView != null) {
            textView.setText(config);
        }
        if (textView != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            float fC = l1.c(20.0f);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, fC, fC, fC, fC});
            gradientDrawable.setColor(ContextCompat.getColor(getContext(), R.color.nor_list_bg));
            s sVar = s.a;
            textView.setBackground(gradientDrawable);
        }
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(this);
        }
        View view2 = this.b;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        e.c.a.g.a.e.b.b(new YoungBITask(20489, "exposure"));
    }
}
