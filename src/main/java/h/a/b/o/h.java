package h.a.b.o;

import h.a.b.m;
import h.a.b.n;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends m.b {
    public final m.b a;

    public h(m.b bVar) {
        this.a = bVar;
    }

    @Override // h.a.b.m.b
    public void onCanceled(m mVar, n nVar) {
        this.a.onCanceled(mVar, nVar);
    }

    @Override // h.a.b.m.b
    public void onFailed(m mVar, n nVar, h.a.b.d dVar) {
        this.a.onFailed(mVar, nVar, dVar);
    }

    @Override // h.a.b.m.b
    public void onReadCompleted(m mVar, n nVar, ByteBuffer byteBuffer) throws Exception {
        this.a.onReadCompleted(mVar, nVar, byteBuffer);
    }

    @Override // h.a.b.m.b
    public void onRedirectReceived(m mVar, n nVar, String str) throws Exception {
        this.a.onRedirectReceived(mVar, nVar, str);
    }

    @Override // h.a.b.m.b
    public void onResponseStarted(m mVar, n nVar) throws Exception {
        this.a.onResponseStarted(mVar, nVar);
    }

    @Override // h.a.b.m.b
    public void onSucceeded(m mVar, n nVar) {
        this.a.onSucceeded(mVar, nVar);
    }
}
