package e.c.a.g.a.s;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class o1 extends Handler {
    public final Handler a;

    public o1(Handler handler) {
        this.a = handler;
    }

    public static void a(Toast toast) {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(toast);
            if (obj != null) {
                Field declaredField2 = obj.getClass().getDeclaredField("mHandler");
                declaredField2.setAccessible(true);
                declaredField2.set(obj, new o1((Handler) declaredField2.get(obj)));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Handler
    public void dispatchMessage(@NonNull Message message) {
        this.a.dispatchMessage(message);
    }

    @Override // android.os.Handler
    @NonNull
    public String getMessageName(@NonNull Message message) {
        return this.a.getMessageName(message);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        try {
            this.a.handleMessage(message);
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(@NonNull Message message, long j) {
        return this.a.sendMessageAtTime(message, j);
    }
}
