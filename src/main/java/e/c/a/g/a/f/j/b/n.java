package e.c.a.g.a.f.j.b;

import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import e.c.a.g.a.f.j.b.j;

/* JADX INFO: loaded from: classes.dex */
public interface n extends o {
    boolean feeKeyVaild();

    boolean fromCache();

    /* synthetic */ String getAlbumId();

    int getCharge();

    int getFailProcess();

    @Override // e.c.a.g.a.f.j.b.o
    /* synthetic */ String getFeeKey();

    /* synthetic */ String getHash();

    @Override // e.c.a.g.a.f.j.b.o
    /* synthetic */ long getMixId();

    String getMusicFeeType();

    MusicTransParamEnenty getMusicTransParamEnenty();

    /* synthetic */ String getName();

    int getOldCpy();

    int getPayType();

    int getUpdataFlag();

    long getUpdateFeeStatusTime();

    /* synthetic */ boolean isUpdateFeeStatusTimeOut();

    void updateData(n nVar);

    void updateData(n nVar, j.c cVar);
}
