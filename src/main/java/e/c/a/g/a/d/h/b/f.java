package e.c.a.g.a.d.h.b;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import e.c.a.g.a.d.h.b.b;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class f extends ProgressDialog {
    public final b.d a;

    public f(Context context, int i2) {
        super(context, i2);
        this.a = new b.d(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Context context = getContext();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            super.dismiss();
        } catch (IllegalArgumentException e2) {
            if (g0.a) {
                g0.c("lzm", "dialog.dismiss() cast an Exception : " + e2.toString());
            }
        }
    }

    @Override // android.app.ProgressDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        this.a.e();
    }
}
