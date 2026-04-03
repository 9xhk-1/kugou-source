package e.c.a.g.a.d.x.v;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes.dex */
public final class n extends e.c.a.g.a.d.h.b.e implements View.OnClickListener {
    public final long a;
    public View b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f629d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f630f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context, long j) {
        super(context, R.style.PopDialogTheme);
        f.z.d.j.e(context, "context");
        this.a = j;
    }

    public final n a(Runnable runnable) {
        this.f630f = runnable;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f.z.d.j.e(view, "view");
        if (u1.i(view)) {
            return;
        }
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            e.c.a.g.a.e.b.b(new YoungBITask(20587, "click").setType("2"));
            dismiss();
        } else {
            if (id != R.id.tv_delete) {
                return;
            }
            Runnable runnable = this.f630f;
            if (runnable != null) {
                runnable.run();
            }
            e.c.a.g.a.e.b.b(new YoungBITask(20587, "click").setType("1"));
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_space_guide);
        this.b = findViewById(R.id.tv_delete);
        this.f629d = findViewById(R.id.tv_cancel);
        View view = this.b;
        if (view != null) {
            view.setOnClickListener(this);
        }
        View view2 = this.f629d;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        TextView textView = (TextView) findViewById(R.id.tv_title);
        if (textView == null) {
            return;
        }
        textView.setText("应用缓存已超过" + ((this.a / ((long) 1024)) / 1024) + 'M');
    }
}
