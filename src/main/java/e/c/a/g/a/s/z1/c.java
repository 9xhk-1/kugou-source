package e.c.a.g.a.s.z1;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Toast {

    @NonNull
    public final Toast a;
    public TextView b;

    public c(Context context, @NonNull Toast toast) {
        super(context);
        this.a = toast;
    }

    public static c a(Context context, CharSequence charSequence, int i2) {
        b bVar = new b(context);
        Toast toastMakeText = Toast.makeText(bVar, charSequence, i2);
        bVar.c(toastMakeText);
        View view = toastMakeText.getView();
        if (view != null) {
            b(view, bVar);
        }
        return new c(bVar, toastMakeText);
    }

    public static void b(@NonNull View view, @NonNull Context context) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c(TextView textView) {
        this.b = textView;
    }

    @Override // android.widget.Toast
    public void cancel() {
        this.a.cancel();
    }

    @Override // android.widget.Toast
    public int getDuration() {
        return this.a.getDuration();
    }

    @Override // android.widget.Toast
    public int getGravity() {
        return this.a.getGravity();
    }

    @Override // android.widget.Toast
    public float getHorizontalMargin() {
        return this.a.getHorizontalMargin();
    }

    @Override // android.widget.Toast
    public float getVerticalMargin() {
        return this.a.getVerticalMargin();
    }

    @Override // android.widget.Toast
    public View getView() {
        return this.a.getView();
    }

    @Override // android.widget.Toast
    public int getXOffset() {
        return this.a.getXOffset();
    }

    @Override // android.widget.Toast
    public int getYOffset() {
        return this.a.getYOffset();
    }

    @Override // android.widget.Toast
    public void setDuration(int i2) {
        this.a.setDuration(i2);
    }

    @Override // android.widget.Toast
    public void setGravity(int i2, int i3, int i4) {
        this.a.setGravity(i2, i3, i4);
    }

    @Override // android.widget.Toast
    public void setMargin(float f2, float f3) {
        this.a.setMargin(f2, f3);
    }

    @Override // android.widget.Toast
    public void setText(int i2) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(i2);
        } else {
            this.a.setText(i2);
        }
    }

    @Override // android.widget.Toast
    public void setView(View view) {
        this.a.setView(view);
        b(view, new b(view.getContext(), this));
    }

    @Override // android.widget.Toast
    public void show() {
        this.a.show();
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.a.setText(charSequence);
        }
    }
}
