package e.c.a.g.a.s;

import android.os.Handler;
import android.os.Message;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v<T extends DelegateFragment> extends Handler {
    public final WeakReference<T> a;

    public v(T t) {
        super(t.u());
        this.a = new WeakReference<>(t);
    }

    public abstract void a(T t, Message message);

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        T t = this.a.get();
        if (t == null || !t.z()) {
            return;
        }
        a(t, message);
    }
}
