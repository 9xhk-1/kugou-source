package e.c.a.g.a.d.r.j.d;

import e.c.a.g.a.d.r.e;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    void callCheckPrivilege(long j);

    void callDestory();

    void callFinish();

    void callFinishFeesDialog(int i2);

    void callFinishFeesDialogOnlyFinish();

    void callGetMusicPkgAds(String str);

    void callPayInBackGuound();

    void callRefreshUserBalanceAndRemain();

    void callUpdateLocalPrivilegeResult(boolean z);

    void callUpdateUserBalance();

    List<e.c.a.g.a.d.r.n.a<?>> doCalaulatePrice(List<e.c.a.g.a.d.r.n.a<?>> list, int i2);

    void finish();

    List<e.c.a.g.a.d.r.n.a<?>> getMultipleTypeResourceDatas(int i2);

    e getMusicFeesDelegate();

    e.c.a.g.a.d.r.l.a processBuyResource();

    void runOnUIThread(Runnable runnable);

    void runOnUIThreadDelay(Runnable runnable, long j);

    void runOnWorkerThread(Runnable runnable);
}
