package e.f.a.a.b.f;

import com.tencent.tmachine.trace.looper.data.KeyPendingMsg;
import com.tencent.tmachine.trace.looper.data.SyncBarrierMsg;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public Long a = null;
    public Integer b = null;
    public List<SyncBarrierMsg> c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<KeyPendingMsg> f1390d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1393g;

    public String toString() {
        return "AnrExtraInfo{blockTime=" + this.a + ", pendingMsgCnt=" + this.b + ", syncBarrierMsgList=" + this.c + ", keyPendingMsgList=" + this.f1390d + ", methodTracePath='" + this.f1391e + "', cpuTracePath='" + this.f1392f + "', looperMsgTracePath='" + this.f1393g + "'}";
    }
}
