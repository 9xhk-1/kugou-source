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
import e.c.a.g.a.s.u1;
import f.s;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e.c.a.g.a.d.h.b.e implements View.OnClickListener {
    public final a a;
    public View b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f815d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, a aVar) {
        super(context, R.style.PopDialogTheme);
        j.e(context, "context");
        j.e(aVar, "vipData");
        this.a = aVar;
    }

    @Override // e.c.a.g.a.d.h.b.e
    public float getDialogAuthority() {
        return 130.0f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer numValueOf = view == null ? null : Integer.valueOf(view.getId());
        if (numValueOf != null && numValueOf.intValue() == R.id.iv_close) {
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_newer_login);
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
        this.f815d = (TextView) findViewById(R.id.tv_tip);
        this.b = findViewById(R.id.iv_close);
        TextView textView = this.f815d;
        boolean z = true;
        if (textView != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            float fC = l1.c(20.0f);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, fC, fC, fC, fC});
            gradientDrawable.setColor(ContextCompat.getColor(getContext(), R.color.nor_list_bg));
            s sVar = s.a;
            textView.setBackground(gradientDrawable);
        }
        String strA = this.a.a();
        if (strA != null && strA.length() != 0) {
            z = false;
        }
        String strA2 = !z ? this.a.a() : "恭喜获得酷狗概念版VIP，VIP可收听下载VIP歌曲，详情请前往手机端“酷狗概念版”查看";
        TextView textView2 = this.f815d;
        if (textView2 != null) {
            textView2.setText(strA2);
        }
        View view = this.b;
        if (view != null) {
            view.setOnClickListener(this);
        }
        e.c.a.g.a.e.b.b(new YoungBITask(20491, "exposure"));
    }
}
