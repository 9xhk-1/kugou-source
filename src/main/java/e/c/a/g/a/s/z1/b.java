package e.c.a.g.a.s.z1;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ContextWrapper {

    @NonNull
    public Toast a;

    @Nullable
    public e.c.a.g.a.s.z1.a b;

    /* JADX INFO: renamed from: e.c.a.g.a.s.z1.b$b, reason: collision with other inner class name */
    public final class C0197b extends ContextWrapper {
        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(@NonNull String str) {
            return "window".equals(str) ? new c((WindowManager) getBaseContext().getSystemService(str)) : super.getSystemService(str);
        }

        public C0197b(@NonNull Context context) {
            super(context);
        }
    }

    public final class c implements WindowManager {

        @NonNull
        public final WindowManager a;

        @Override // android.view.ViewManager
        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            try {
                this.a.addView(view, layoutParams);
            } catch (WindowManager.BadTokenException | WindowManager.InvalidDisplayException | IllegalStateException unused) {
                if (b.this.b != null) {
                    b.this.b.onBadTokenCaught(b.this.a);
                }
            } catch (Throwable th) {
                Log.e("WindowManagerWrapper", "[addView]", th);
            }
        }

        @Override // android.view.WindowManager
        public Display getDefaultDisplay() {
            return this.a.getDefaultDisplay();
        }

        @Override // android.view.ViewManager
        public void removeView(View view) {
            this.a.removeView(view);
        }

        @Override // android.view.WindowManager
        public void removeViewImmediate(View view) {
            this.a.removeViewImmediate(view);
        }

        @Override // android.view.ViewManager
        public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
            this.a.updateViewLayout(view, layoutParams);
        }

        public c(@NonNull WindowManager windowManager) {
            this.a = windowManager;
        }
    }

    public b(@NonNull Context context, @NonNull Toast toast) {
        super(context);
        this.a = toast;
    }

    public void c(@NonNull Toast toast) {
        this.a = toast;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return new C0197b(getBaseContext().getApplicationContext());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return "window".equals(str) ? new c((WindowManager) getBaseContext().getSystemService(str)) : super.getSystemService(str);
    }

    public b(Context context) {
        super(context);
    }
}
