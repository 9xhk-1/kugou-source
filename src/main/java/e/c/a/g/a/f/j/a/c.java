package e.c.a.g.a.f.j.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.common.music.entity.CExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.KGFile;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static String a = "isinsterplay";
    public static String b = "trace_source";

    public static KGMusicWrapper a(Initiator initiator, String str, KGMusic kGMusic) {
        KGMusicWrapper kGMusicWrapperD = d(kGMusic, initiator);
        kGMusicWrapperD.setUserPlay(kGMusicWrapperD.isUserPlay());
        KGMusic kgmusic = kGMusicWrapperD.getKgmusic();
        if (kgmusic != null) {
            kgmusic.applyExtraInfo(CExtraInfo.addSource(str));
        }
        return kGMusicWrapperD;
    }

    public static KGMusicWrapper b(Initiator initiator, String str, KGPlaylistMusic kGPlaylistMusic) {
        KGMusicWrapper kGMusicWrapperD = d(kGPlaylistMusic.k(), initiator);
        kGMusicWrapperD.setUserPlay(kGMusicWrapperD.isUserPlay());
        KGMusic kgmusic = kGMusicWrapperD.getKgmusic();
        if (kgmusic != null) {
            kgmusic.applyExtraInfo(CExtraInfo.addSource(str));
        }
        return kGMusicWrapperD;
    }

    public static KGMusicWrapper c(KGMusic kGMusic, Bundle bundle, Initiator initiator) {
        KGMusicWrapper kGMusicWrapper = new KGMusicWrapper(kGMusic, initiator.peekPagePath());
        kGMusicWrapper.getInitiator().update(initiator);
        if (bundle != null && bundle.containsKey(a)) {
            kGMusicWrapper.setIsInsertPlay(bundle.getBoolean(a));
        }
        if (kGMusic != null) {
            if (kGMusic.isFileDownloaded()) {
                kGMusicWrapper.setIsDownloadOrCache(2);
            } else if (kGMusic.isDownloaded()) {
                kGMusicWrapper.setIsDownloadOrCache(1);
            }
        }
        return kGMusicWrapper;
    }

    public static KGMusicWrapper d(KGMusic kGMusic, Initiator initiator) {
        return c(kGMusic, null, initiator);
    }

    public static KGMusicWrapper e(KGSong kGSong, Bundle bundle, Initiator initiator) {
        KGMusicWrapper kGMusicWrapper;
        if (kGSong == null) {
            return null;
        }
        if (kGSong.B2() == 0) {
            KGFile kGFile = new KGFile();
            kGFile.setFileid(kGSong.z1());
            kGFile.setExtname(kGSong.u1());
            kGFile.setFilepath(kGSong.A1());
            kGFile.setFilesize(kGSong.i2());
            kGFile.setDuration(kGSong.t1());
            kGFile.setMimetype(kGSong.S1());
            kGFile.setBitrate(kGSong.o1());
            kGFile.setMusicname(kGSong.s1());
            kGFile.setMusichash(kGSong.J1());
            kGFile.setQualitytype(kGSong.m2());
            kGFile.setFileuserkey(kGSong.A1());
            kGFile.setFailProcess(kGSong.x1());
            kGFile.setPayType(kGSong.e2());
            kGFile.setMusicFeeType(kGSong.V1());
            kGFile.setUpdateFeeStatusTime(kGSong.C2());
            kGFile.setOldCpy(kGSong.d2());
            kGFile.setMusicLinkSource(kGSong.X0);
            kGFile.setMusicLinkExtInfo(kGSong.W1());
            kGFile.setSource(kGSong.q2());
            kGFile.setSourceType(kGSong.s2());
            kGFile.setSourceHash(kGSong.r2());
            kGFile.setMixId(kGSong.T1());
            kGFile.setGuessYouLikeMark(kGSong.G1());
            kGFile.setGuessYouLikeBiString(kGSong.F1());
            kGFile.setMaskOfForceDownload(kGSong.R1());
            kGFile.setFailProcess(kGSong.x1());
            kGFile.setPayType(kGSong.e2());
            kGFile.setMusicFeeType(kGSong.V1());
            kGFile.setUpdateFeeStatusTime(kGSong.C2());
            kGFile.setOldCpy(kGSong.d2());
            kGFile.setMusicTransParamEnenty(kGSong.getMusicTransParamEnenty());
            kGFile.setAudioType(kGSong.m1());
            kGFile.setSort(kGSong.p2());
            kGMusicWrapper = new KGMusicWrapper(kGFile, initiator.peekPagePath());
        } else {
            kGMusicWrapper = new KGMusicWrapper(kGSong.S4(), initiator.peekPagePath());
        }
        String string = "";
        if (bundle != null) {
            if (bundle.containsKey(a)) {
                kGMusicWrapper.setIsInsertPlay(bundle.getBoolean(a));
            }
            string = bundle.getString(b, "");
        }
        if (kGSong.F2()) {
            kGMusicWrapper.setIsDownloadOrCache(2);
        } else if (kGSong.E2()) {
            kGMusicWrapper.setIsDownloadOrCache(1);
        }
        if (e.c.a.g.a.f.a.n() && "28".equals(string)) {
            kGMusicWrapper.setHashOffset(kGSong.H1());
        }
        kGMusicWrapper.setIsInsertPlay(kGSong.H2());
        kGMusicWrapper.setCharge(kGSong.q1());
        kGMusicWrapper.getInitiator().update(initiator);
        if (!TextUtils.isEmpty(initiator.fo)) {
            kGMusicWrapper.setSource(initiator.fo);
        }
        return kGMusicWrapper;
    }

    public static KGMusicWrapper f(KGSong kGSong, Initiator initiator) {
        return e(kGSong, null, initiator);
    }

    public static List<KGMusicWrapper> g(List<KGSong> list, Initiator initiator, String str) {
        return h(list, initiator, str, false);
    }

    public static List<KGMusicWrapper> h(List<KGSong> list, Initiator initiator, String str, boolean z) {
        if (list == null) {
            return new ArrayList();
        }
        Bundle bundle = null;
        if (e.c.a.g.a.f.a.n() && z) {
            bundle = new Bundle();
            bundle.putString(b, str);
        }
        ArrayList arrayList = new ArrayList();
        for (KGSong kGSong : list) {
            KGMusicWrapper kGMusicWrapperF = (!z || bundle == null) ? f(kGSong, initiator) : e(kGSong, bundle, initiator);
            if (kGMusicWrapperF != null) {
                kGMusicWrapperF.setUserPlay(kGSong.J2());
                KGMusic kgmusic = kGMusicWrapperF.getKgmusic();
                if (kgmusic != null) {
                    kgmusic.applyExtraInfo(CExtraInfo.addSource(str));
                }
                arrayList.add(kGMusicWrapperF);
            }
        }
        return arrayList;
    }

    public static KGSong i(KGMusicWrapper kGMusicWrapper) {
        return kGMusicWrapper != null ? j(kGMusicWrapper, kGMusicWrapper.getSongType()) : new KGSong("未知来源");
    }

    public static KGSong j(KGMusicWrapper kGMusicWrapper, int i2) {
        KGFile innerKGfile;
        if (kGMusicWrapper == null) {
            return new KGSong("未知来源");
        }
        KGSong kGSong = new KGSong(kGMusicWrapper.getSource());
        if (kGMusicWrapper.isConstructFromKGmusic()) {
            KGMusic kgmusic = kGMusicWrapper.getKgmusic();
            if (kgmusic != null) {
                KGFile innerKGfile2 = kGMusicWrapper.getInnerKGfile(false);
                if (innerKGfile2 != null) {
                    kGSong.p3((int) innerKGfile2.getFileid());
                    kGSong.j3(innerKGfile2.getExtname());
                    kGSong.q3(innerKGfile2.getFilepath());
                    kGSong.g3(innerKGfile2.getDuration());
                    kGSong.P3(innerKGfile2.getMimetype());
                    kGSong.X2(innerKGfile2.getBitrate());
                    kGSong.e3(innerKGfile2.getMusicname());
                    kGSong.B3(innerKGfile2.getMusichash());
                    kGSong.t4(innerKGfile2.getQualitytype());
                } else {
                    kGSong.p3(-1);
                    kGSong.j3("");
                    kGSong.q3("");
                    kGSong.g3(kgmusic.getDuration());
                    kGSong.X2(kgmusic.getBitrate());
                    kGSong.e3(kgmusic.getDisplayName());
                    kGSong.B3(kgmusic.getHashValue());
                }
                kGSong.o4(kgmusic.getSize());
                kGSong.C3(kgmusic.getHash320());
                kGSong.p4((int) kgmusic.getSize320());
                kGSong.C4(kgmusic.getSqHash());
                kGSong.D4((int) kgmusic.getSqSize());
                kGSong.E3(kgmusic.getSid());
                kGSong.A3(kgmusic.getHashType());
                kGSong.F3(kgmusic.getImgUrl());
                kGSong.A4(kgmusic.getSourceType());
                kGSong.R3(kgmusic.getModule());
                kGSong.X3(kgmusic.getMvHashValue());
                kGSong.O2((int) kgmusic.getAlbumID());
                kGSong.P2(kgmusic.getAlbumName());
                kGSong.z4(kgmusic.getSourceHash());
                kGSong.m3(kgmusic.getFailProcess());
                kGSong.U3(kgmusic.getMusicFeeType());
                kGSong.e4(kgmusic.getPayType());
                kGSong.O4(kgmusic.getUpdateFeeStatusTime());
                kGSong.b4(kgmusic.getOldCpy());
                kGSong.d3(kgmusic.getCurMark());
                kGSong.n4(kgmusic.getSingerInfos());
                kGSong.b3(kgmusic.getCharge());
                kGSong.x3(kgmusic.getGuessYouLikeMark());
                kGSong.i4(kgmusic.getRecSongInfo());
                kGSong.b1(kgmusic.getExtraInfo());
                kGSong.w3(kgmusic.getGuessYouLikeBiString());
                kGSong.Q3(kgmusic.getMixId());
                kGSong.k3(kgmusic.getExtParams());
            }
        } else if (kGMusicWrapper.isConstructFromKGFile() && (innerKGfile = kGMusicWrapper.getInnerKGfile()) != null) {
            kGSong.p3((int) innerKGfile.getFileid());
            kGSong.j3(innerKGfile.getExtname());
            kGSong.q3(innerKGfile.getFilepath());
            kGSong.o4(innerKGfile.getFilesize());
            kGSong.g3(innerKGfile.getDuration());
            kGSong.P3(innerKGfile.getMimetype());
            kGSong.X2(innerKGfile.getBitrate());
            kGSong.e3(innerKGfile.getMusicname());
            kGSong.B3(innerKGfile.getMusichash());
            kGSong.A3(-100);
            kGSong.t4(innerKGfile.getQualitytype());
            kGSong.F3("");
            kGSong.A4(innerKGfile.getSourceType());
            kGSong.R3(innerKGfile.getModule());
            kGSong.m3(innerKGfile.getFailProcess());
            kGSong.U3(innerKGfile.getMusicFeeType());
            kGSong.e4(innerKGfile.getPayType());
            kGSong.O4(innerKGfile.getUpdateFeeStatusTime());
            kGSong.b4(innerKGfile.getOldCpy());
            kGSong.b3(innerKGfile.getPrivilege());
            kGSong.Q3(innerKGfile.getMixId());
            kGSong.k3(innerKGfile.getExtParams());
        }
        kGSong.setMusicTransParamEnenty(kGMusicWrapper.getMusicTransParamEnenty());
        kGSong.n3(kGMusicWrapper.getFeeAlbumID());
        kGSong.u4(kGMusicWrapper.getSongSource());
        kGSong.W3(kGMusicWrapper.getMusicSource());
        kGSong.q4(kGMusicWrapper.getSk());
        kGSong.M4(i2);
        kGSong.H3(kGMusicWrapper.isInsertPlay());
        kGSong.b3(kGMusicWrapper.getCharge());
        return kGSong;
    }
}
