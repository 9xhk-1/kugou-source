package e.c.a.g.a.d.r.j.d;

import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;
import e.c.a.g.a.d.r.p.a.g;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    void attachActivity(AbsFrameworkActivity absFrameworkActivity);

    List<e.c.a.g.a.d.r.n.a<?>> combineData(List<e.c.a.g.a.d.r.n.a<?>> list, List<e.c.a.g.a.d.r.p.a.c> list2);

    List<g> feeDataToPrivilegeResource(List<e.c.a.g.a.d.r.n.a<?>> list);

    List<e.c.a.g.a.d.r.n.a<?>> getALlFeeResource(List<e.c.a.g.a.d.r.n.a<?>> list);

    int getFeeResourceCount();

    e.c.a.g.a.d.r.p.a.c getTargetGoods(e.c.a.g.a.d.r.p.a.c cVar);

    void hideLoadingView();

    boolean isCurrentAlbumBuy();

    boolean isSkipBuy();

    void jumpMusicBuy(List<e.c.a.g.a.d.r.n.a<?>> list, int i2);

    void onCreate();

    void onDestroy();

    void onEndCheckPrivilege(e.c.a.g.a.d.r.p.a.a aVar);

    void onFinishFeesDialog(int i2);

    void onFinishFeesDialogOnlyFinish();

    void onPayInBackGuound();

    List<e.c.a.g.a.d.r.n.a<?>> onProcessDataForCalaulatePrice(List<e.c.a.g.a.d.r.n.a<?>> list, int i2);

    void onShowFeesDialog();

    void setControlFeesAction(a aVar);

    void setDownloadSize(float f2);

    void urlListener(List<e.c.a.g.a.d.r.n.a<?>> list);
}
