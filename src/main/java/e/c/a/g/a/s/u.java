package e.c.a.g.a.s;

import android.os.Handler;
import android.os.Message;
import com.kugou.android.watch.lite.base.activity.DelegateActivity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u<T extends DelegateActivity> extends Handler {
    public final WeakReference<T> a;

    public u(T t) {
        super(t.g());
        this.a = new WeakReference<>(t);
    }

    public abstract void a(T t, Message message);

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        T t = this.a.get();
        if (t == null || t.isDestroyed()) {
            return;
        }
        a(t, message);
    }
}
