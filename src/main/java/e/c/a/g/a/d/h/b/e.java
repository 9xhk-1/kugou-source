package e.c.a.g.a.d.h.b;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import e.c.a.g.a.d.h.b.b;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class e extends AppCompatDialog {
    private static final String TAG = e.class.getSimpleName();
    private final b.d member;
    private d showHookListener;

    public e(@NonNull Context context) {
        this(context, 0);
    }

    private void configWindow() {
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setDimAmount(0.8f);
        }
    }

    private void onDialogShow() {
        c cVar = c.a;
        if (cVar.c(getDialogAuthority())) {
            cVar.d(getDialogAuthority());
        }
    }

    public final void askShow() {
        askShow(getDialogAuthority());
    }

    public final void clearBehinds() {
        this.member.a();
    }

    public float getDialogAuthority() {
        a aVar = (a) getClass().getAnnotation(a.class);
        if (aVar == null) {
            return 100.0f;
        }
        return aVar.authority();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        e.c.a.g.a.d.g.b.b().c((ViewGroup) getWindow().getDecorView());
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        this.member.e();
    }

    public e setShowHookerListener(d dVar) {
        this.showHookListener = dVar;
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        c cVar = c.a;
        if (cVar.c(getDialogAuthority()) && !cVar.b()) {
            if (g0.a) {
                g0.e(TAG, "show: hook show:" + getDialogAuthority());
            }
            d dVar = this.showHookListener;
            if (dVar != null) {
                dVar.onHook();
            }
            this.member.e();
            return;
        }
        Context context = getContext();
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        try {
            super.show();
            onDialogShow();
        } catch (Exception unused) {
        }
        if (g0.a) {
            g0.e(TAG, getClass().getName());
        }
    }

    public e(@NonNull Context context, int i2) {
        super(context, i2);
        this.member = new b.d(this);
        this.showHookListener = null;
        configWindow();
    }

    public final void askShow(float f2) {
        this.member.f(f2);
    }
}
