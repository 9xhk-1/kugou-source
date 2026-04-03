package e.c.a.g.a.d.r.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class i implements Handler.Callback {
    public static volatile i b;
    public Handler a = new Handler(Looper.getMainLooper(), this);

    public static i a() {
        if (b == null) {
            b = new i();
        }
        return b;
    }

    public void b(e.c.a.g.a.d.r.e eVar) {
        Message messageObtainMessage = this.a.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = eVar;
        messageObtainMessage.sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        if (message.what != 1 || (obj = message.obj) == null || !(obj instanceof e.c.a.g.a.d.r.e)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (g0.a) {
            g0.b("musicfees", "--startActivity--" + jCurrentTimeMillis);
        }
        ((e.c.a.g.a.d.r.e) message.obj).onCreate();
        if (!g0.a) {
            return false;
        }
        g0.b("musicfees", "--startActivity--" + System.currentTimeMillis() + " | " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return false;
    }
}
