package e.c.a.g.a.d.r.j.c;

import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends c {

    public class a implements Comparator<e.c.a.g.a.d.r.p.a.c> {
        public a(b bVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e.c.a.g.a.d.r.p.a.c cVar, e.c.a.g.a.d.r.p.a.c cVar2) {
            return cVar.p() - cVar2.p();
        }
    }

    public b(e.c.a.g.a.d.r.n.d dVar) {
        super(dVar);
    }

    public void a() {
        this.b.callFinishFeesDialog(0);
    }

    public List<e.c.a.g.a.d.r.n.a<?>> b() {
        return this.b.getMultipleTypeResourceDatas(7);
    }

    public boolean c(e.c.a.g.a.d.r.n.a<?> aVar, e.c.a.g.a.d.r.p.a.c cVar) {
        return false;
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public List<e.c.a.g.a.d.r.n.a<?>> combineData(List<e.c.a.g.a.d.r.n.a<?>> list, List<e.c.a.g.a.d.r.p.a.c> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return new ArrayList();
        }
        List<e.c.a.g.a.d.r.p.a.c> listA = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            e.c.a.g.a.d.r.p.a.c cVar = list2.get(i2);
            e.c.a.g.a.d.r.n.a<?> aVar = list.get(i2);
            if (!c(aVar, cVar)) {
                aVar.e(cVar);
            }
            if (cVar != null) {
                listA = cVar.A();
            }
            if (listA != null) {
                Collections.sort(listA, new a(this));
            }
            d(aVar, listA);
        }
        return list;
    }

    public void d(e.c.a.g.a.d.r.n.a<?> aVar, List<e.c.a.g.a.d.r.p.a.c> list) {
        if (aVar.b() != null && (aVar.b().C() == 2 || aVar.b().C() == 4)) {
            aVar.g(1);
        } else if (aVar.b() != null && aVar.b().E() && aVar.b().G()) {
            aVar.g(1);
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public List<e.c.a.g.a.d.r.p.a.g> feeDataToPrivilegeResource(List<e.c.a.g.a.d.r.n.a<?>> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        ArrayList<e.c.a.g.a.d.r.n.a> arrayList2 = new ArrayList();
        arrayList2.addAll(list);
        for (e.c.a.g.a.d.r.n.a aVar : arrayList2) {
            if (getFeeTaskImpl().F(aVar)) {
                if (aVar.b() != null) {
                    arrayList.add(e.c.a.g.a.d.r.g.P(getTargetGoods(aVar.b())));
                } else {
                    arrayList.add(aVar.c());
                }
                e.c.a.g.a.d.r.p.a.g gVarC = aVar.c();
                Object objA = aVar.a();
                if (objA instanceof KGMusicWrapper) {
                    KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) objA;
                    PageKey pageKey = kGMusicWrapper.getPageKey();
                    Initiator initiator = kGMusicWrapper.getInitiator();
                    if (pageKey != null) {
                        gVarC.o(pageKey);
                    } else if (initiator != null) {
                        long j = initiator.pageCode;
                        if (j > 0) {
                            gVarC.o(PageKey.make(initiator.url, (int) j, initiator.stack));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public List<e.c.a.g.a.d.r.n.a<?>> getALlFeeResource(List<e.c.a.g.a.d.r.n.a<?>> list) {
        if (list == null) {
            list = getFeeResourceDatas();
        }
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (e.c.a.g.a.d.r.n.a<?> aVar : list) {
            if (getFeeTaskImpl().F(aVar)) {
                arrayList.add(aVar);
                if (aVar.c() == null) {
                    aVar.f(getFeeTaskImpl().j(aVar.a()));
                }
            }
        }
        return arrayList;
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public int getFeeResourceCount() {
        return getALlFeeResource(getFeeResourceDatas()).size();
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public e.c.a.g.a.d.r.p.a.c getTargetGoods(e.c.a.g.a.d.r.p.a.c cVar) {
        return cVar;
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public List<e.c.a.g.a.d.r.n.a<?>> onProcessDataForCalaulatePrice(List<e.c.a.g.a.d.r.n.a<?>> list, int i2) {
        return list;
    }
}
