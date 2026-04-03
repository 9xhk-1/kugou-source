package e.c.c.n;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog {
    public TextView a;
    public Button b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f1274d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f1275f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InterfaceC0209a f1276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1277i;

    /* JADX INFO: renamed from: e.c.c.n.a$a, reason: collision with other inner class name */
    public interface InterfaceC0209a {
        void onNegativeClick();

        void onPositiveClick();
    }

    public a(Context context) {
        super(context);
        this.f1277i = true;
    }

    public void a(InterfaceC0209a interfaceC0209a) {
        this.f1276h = interfaceC0209a;
    }

    public void b(boolean z) {
        this.f1277i = z;
    }

    public void c(CharSequence charSequence) {
        this.f1275f.setText(charSequence);
    }

    public void d(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public void e(CharSequence charSequence) {
        this.f1274d.setText(charSequence);
    }

    public void f(boolean z) {
        this.a.setVisibility(z ? 0 : 8);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.a.setText(charSequence);
    }
}
