package e.c.a.g.a.g.h.n;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.MainFragment;
import e.c.a.g.a.p.l;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import f.u.i;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e.c.a.g.a.g.h.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f825d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: e.c.a.g.a.g.h.n.d$a$a, reason: collision with other inner class name */
        public static final class RunnableC0136a implements Runnable {
            public final /* synthetic */ d a;

            public RunnableC0136a(d dVar) {
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                s0.a.s(this.a.a().getText().toString());
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            u0.d(d.this.a.requireActivity(), new RunnableC0136a(d.this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MainFragment mainFragment, TextView textView) {
        super(mainFragment, textView);
        j.e(mainFragment, "host");
        j.e(textView, "entryView");
        this.f825d = textView;
        b(null);
        textView.setOnClickListener(new a());
    }

    public final TextView a() {
        return this.f825d;
    }

    public final void b(l lVar) {
        Boolean boolValueOf = lVar == null ? null : Boolean.valueOf(lVar.a());
        boolean zE = boolValueOf == null ? e.c.a.g.a.f.m.c.a.e("KEY_ENABLE_PERSONALITY_REC", true) : boolValueOf.booleanValue();
        int i2 = zE ? R.drawable.icon_recommend_entry : R.drawable.icon_hot_listen_entry;
        this.f825d.setText(zE ? "为你推荐" : "大家都在听");
        Drawable drawable = ContextCompat.getDrawable(KGApplication.getContext(), i2);
        Drawable[] compoundDrawables = this.f825d.getCompoundDrawables();
        j.d(compoundDrawables, "entryView.compoundDrawables");
        Drawable drawable2 = (Drawable) i.i(compoundDrawables);
        Rect bounds = drawable2 == null ? null : drawable2.getBounds();
        if (bounds != null && drawable != null) {
            drawable.setBounds(bounds);
        }
        this.f825d.setCompoundDrawables(drawable, null, null, null);
    }
}
