package e.c.a.g.a.f.j.b;

import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;

/* JADX INFO: loaded from: classes.dex */
public class f extends b<KGMusic> {
    public f(KGMusic kGMusic) {
        super(kGMusic);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public String getAlbumId() {
        return ((KGMusic) this.a).getFeeAlbumId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public int getCharge() {
        return ((KGMusic) this.a).getCharge();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public int getFailProcess() {
        return ((KGMusic) this.a).getFailProcess();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public String getHash() {
        return ((KGMusic) this.a).getHashValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n, e.c.a.g.a.f.j.b.o
    public long getMixId() {
        return ((KGMusic) this.a).getMixId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public String getMusicFeeType() {
        return ((KGMusic) this.a).getMusicFeeType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.b, e.c.a.g.a.f.j.b.n
    public MusicTransParamEnenty getMusicTransParamEnenty() {
        return ((KGMusic) this.a).getMusicTransParamEnenty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public String getName() {
        return ((KGMusic) this.a).getDisplayName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public int getOldCpy() {
        return ((KGMusic) this.a).getOldCpy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public int getPayType() {
        return ((KGMusic) this.a).getPayType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public long getUpdateFeeStatusTime() {
        return ((KGMusic) this.a).getUpdateFeeStatusTime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.c.a.g.a.f.j.b.n
    public void updateData(n nVar) {
        if (nVar != null) {
            if (m.j(nVar.getUpdataFlag())) {
                ((KGMusic) this.a).setFailProcess(nVar.getFailProcess());
                ((KGMusic) this.a).setPayType(nVar.getPayType());
                ((KGMusic) this.a).setMusicFeeType(nVar.getMusicFeeType());
                ((KGMusic) this.a).setOldCpy(nVar.getOldCpy());
                ((KGMusic) this.a).setCharge(nVar.getCharge());
                ((KGMusic) this.a).setUpdateFeeStatusTime(nVar.getUpdateFeeStatusTime());
            }
            MusicTransParamEnenty musicTransParamEnentyW = m.w(null, nVar);
            if (musicTransParamEnentyW != null) {
                ((KGMusic) this.a).setMusicTransParamEnenty(musicTransParamEnentyW);
            }
        }
    }
}
