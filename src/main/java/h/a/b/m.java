package h.a.b;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    public static abstract class a {
        public abstract a a(String str, String str2);

        public abstract m b();

        public abstract a c();

        public abstract a d(String str);

        public abstract a e(k kVar, Executor executor);
    }

    public static abstract class b {
        public void onCanceled(m mVar, n nVar) {
        }

        public abstract void onFailed(m mVar, n nVar, d dVar);

        public abstract void onReadCompleted(m mVar, n nVar, ByteBuffer byteBuffer) throws Exception;

        public abstract void onRedirectReceived(m mVar, n nVar, String str) throws Exception;

        public abstract void onResponseStarted(m mVar, n nVar) throws Exception;

        public abstract void onSucceeded(m mVar, n nVar);
    }

    public static abstract class c {
    }

    public abstract void a();

    public abstract void b();

    public abstract boolean c();

    public abstract void d(ByteBuffer byteBuffer);

    public abstract void e();
}
