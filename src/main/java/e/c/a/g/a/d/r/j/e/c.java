package e.c.a.g.a.d.r.j.e;

import com.kugou.android.watch.lite.common.music.entity.KGFile;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.r.g;
import e.c.a.g.a.d.r.j.c.f;
import e.c.a.g.a.s.g0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e.c.a.g.a.d.r.o.c f494i;

    public c(e.c.a.g.a.d.r.o.c cVar) {
        super(cVar);
        this.f494i = cVar;
    }

    public final void B(e.c.a.g.a.d.r.n.a<?> aVar) {
        e.c.a.g.a.d.r.p.a.c cVarB = aVar.b();
        KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) aVar.a();
        kGMusicWrapper.setCharge(cVarB.y());
        KGMusic kgmusic = kGMusicWrapper.getKgmusic();
        if (kgmusic != null) {
            kgmusic.setMusicTransParamEnenty(cVarB.r());
        }
        KGFile innerKGfile = kGMusicWrapper.getInnerKGfile();
        if (innerKGfile != null) {
            innerKGfile.setMusicTransParamEnenty(cVarB.r());
        }
        if (cVarB.F()) {
            kGMusicWrapper.setHashOffset(cVarB.l());
        }
    }

    @Override // e.c.a.g.a.d.r.j.c.b
    public boolean c(e.c.a.g.a.d.r.n.a<?> aVar, e.c.a.g.a.d.r.p.a.c cVar) {
        if (!cVar.E() || cVar.G() || aVar.a() == null || !g.y(((KGMusicWrapper) aVar.a()).getCharge())) {
            return false;
        }
        aVar.e(e.c.a.g.a.d.r.p.a.c.a(((KGMusicWrapper) aVar.a()).getCharge()));
        if (!g0.a) {
            return true;
        }
        g0.e("zzm-log", "--recovery--" + ((KGMusicWrapper) aVar.a()).getDisplayName() + "--charge:" + ((KGMusicWrapper) aVar.a()).getCharge());
        return true;
    }

    @Override // e.c.a.g.a.d.r.j.c.b
    public void d(e.c.a.g.a.d.r.n.a<?> aVar, List<e.c.a.g.a.d.r.p.a.c> list) {
        KGMusicWrapper kGMusicWrapper;
        KGMusic kgmusic;
        int i2;
        int iY;
        super.d(aVar, list);
        if (getSongSource() >= 9 && getSongSource() <= 11 && (kGMusicWrapper = (KGMusicWrapper) aVar.a()) != null && (kgmusic = kGMusicWrapper.getKgmusic()) != null) {
            if (list == null || list.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 0;
                for (e.c.a.g.a.d.r.p.a.c cVar : list) {
                    if (cVar.p() == 2) {
                        kgmusic.setDuration(cVar.o().b());
                        kgmusic.setSize(cVar.o().d());
                        iY = cVar.y();
                    } else if (cVar.p() == 4) {
                        kgmusic.setSize320(cVar.o().d());
                        kgmusic.setHash320(cVar.k());
                        iY = cVar.y() << 4;
                    } else if (cVar.p() == 5) {
                        kgmusic.setSqSize(cVar.o().d());
                        kgmusic.setSqHash(cVar.k());
                        iY = cVar.y() << 8;
                    }
                    i2 |= iY;
                }
            }
            if (kgmusic.getSongSource() == 9) {
                kgmusic.setModule("kUgcUpload");
                kgmusic.setSongSource(10);
                kgmusic.setCharge(i2);
            } else if (kgmusic.getSongSource() == 10) {
                kgmusic.setModule("kUgcMusicLib");
                kgmusic.setCharge(i2);
            } else {
                kgmusic.setModule("");
                kgmusic.setCharge(0);
            }
        }
        B(aVar);
    }

    @Override // e.c.a.g.a.d.r.j.c.b, e.c.a.g.a.d.r.j.d.c
    public List<e.c.a.g.a.d.r.p.a.g> feeDataToPrivilegeResource(List<e.c.a.g.a.d.r.n.a<?>> list) {
        List<e.c.a.g.a.d.r.p.a.g> listFeeDataToPrivilegeResource = super.feeDataToPrivilegeResource(list);
        this.f494i.p0();
        return listFeeDataToPrivilegeResource;
    }

    @Override // e.c.a.g.a.d.r.j.c.b, e.c.a.g.a.d.r.j.d.c
    public int getFeeResourceCount() {
        return this.f494i.B0();
    }

    @Override // e.c.a.g.a.d.r.j.c.c, e.c.a.g.a.d.r.j.d.b
    public void listenSongPart(e.c.a.g.a.d.r.p.a.c cVar) {
        this.f494i.W(cVar);
        onDestroy();
    }

    @Override // e.c.a.g.a.d.r.j.c.f, e.c.a.g.a.d.r.j.d.c
    public void onFinishFeesDialog(int i2) {
        super.onFinishFeesDialog(i2);
    }

    @Override // e.c.a.g.a.d.r.j.c.f, e.c.a.g.a.d.r.j.d.c
    public void onFinishFeesDialogOnlyFinish() {
        if (this.f494i.c0()) {
            if (g0.a) {
                g0.e(this.a, "onFinishFeesDialogOnlyFinish：no finish");
            }
        } else {
            if (g0.a) {
                g0.e(this.a, "onFinishFeesDialogOnlyFinish super.onFinishFeesDialogOnlyFinish()");
            }
            super.onFinishFeesDialogOnlyFinish();
        }
    }

    @Override // e.c.a.g.a.d.r.j.c.f, e.c.a.g.a.d.r.j.d.c
    public void onShowFeesDialog() {
        if (this.f488d.r()) {
            super.onShowFeesDialog();
        }
    }
}
