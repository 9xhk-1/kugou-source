package e.c.a.g.a.g.o;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.s.u1;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e.c.a.g.a.d.h.b.e implements View.OnClickListener {
    public View a;
    public View b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f999d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f1000f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, R.style.PopDialogTheme);
        j.e(context, "context");
    }

    public final c a(Runnable runnable) {
        this.f1000f = runnable;
        return this;
    }

    public final c b(Runnable runnable) {
        this.f999d = runnable;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "view");
        if (u1.i(view)) {
            return;
        }
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            Runnable runnable = this.f1000f;
            if (runnable != null) {
                runnable.run();
            }
            dismiss();
            return;
        }
        if (id != R.id.tv_delete) {
            return;
        }
        Runnable runnable2 = this.f999d;
        if (runnable2 != null) {
            runnable2.run();
        }
        dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_delete_history);
        e.c.a.g.a.f.o.i.c.a().d(3, findViewById(R.id.content_view));
        this.a = findViewById(R.id.tv_delete);
        this.b = findViewById(R.id.tv_cancel);
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(this);
        }
        View view2 = this.b;
        if (view2 == null) {
            return;
        }
        view2.setOnClickListener(this);
    }
}
