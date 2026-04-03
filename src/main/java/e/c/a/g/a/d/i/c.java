package e.c.a.g.a.d.i;

import android.database.SQLException;
import android.os.RemoteException;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.i.e;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.q;
import java.io.File;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class c extends e.a {
    public static volatile c a;

    public class a implements Runnable {
        public final /* synthetic */ int[] a;

        public a(c cVar, int[] iArr) {
            this.a = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 : this.a) {
                try {
                    e.c.a.g.a.g.d.d dVar = e.c.a.g.a.g.d.d.a;
                    e.c.a.g.a.d.f.c.a.a aVarE = dVar.e(i2);
                    dVar.b(i2);
                    if (aVarE == null) {
                        p1.h(KGApplication.getContext(), "删除失败，该记录不存在");
                    } else {
                        q.l(new File(aVarE.i()));
                        q.l(new File(aVarE.u()));
                        p1.h(KGApplication.getContext(), "删除成功");
                        EventBus.getDefault().post(new e.c.a.g.a.g.d.b(i2));
                    }
                } catch (SQLException e2) {
                    p1.h(KGApplication.getContext(), "删除失败，数据库异常：" + e2.getMessage());
                }
            }
        }
    }

    public static c h() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    @Override // e.c.a.g.a.d.i.e
    public void deleteDownloadFile(int[] iArr) throws RemoteException {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        j0.b().a(new a(this, iArr));
    }

    public void i() {
    }

    @Override // e.c.a.g.a.d.i.e
    public void startDownload(List<KGMusicWrapper> list) throws RemoteException {
        if (list != null) {
            e.c.a.g.a.d.i.a.m().k(list);
        }
    }
}
