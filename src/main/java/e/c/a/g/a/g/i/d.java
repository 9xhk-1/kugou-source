package e.c.a.g.a.g.i;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fav.CloudMusicModel;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import com.kugou.common.event.FavSongStatusItemEvent;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.n1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<KGMusic> f842d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e.c.a.g.a.d.f.c.a.j f843f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f845i = 0;

    public d(List<KGMusic> list, e.c.a.g.a.d.f.c.a.j jVar) {
        this.f842d = list;
        this.f843f = jVar;
        e.c.a.g.a.r.b.o();
        this.f844h = KGApplication.getContext();
        if (list != null) {
            Iterator<KGMusic> it = list.iterator();
            while (it.hasNext()) {
                KGMusic next = it.next();
                if (next != null && TextUtils.isEmpty(next.getHashValue())) {
                    it.remove();
                }
            }
        }
    }

    @Override // e.c.a.g.a.g.i.a
    public void a() {
        String str;
        int i2;
        int i3;
        Integer num;
        int iIntValue;
        if (u0.n(this.f844h, false)) {
            String str2 = "yabinCloudSync";
            if (g0.a) {
                g0.b("yabinCloudSync", "添加歌曲到收藏列表--数量:" + this.f842d.size());
            }
            e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
            e.c.a.g.a.d.f.c.a.j jVarH = bVar.h(this.f843f.d(), false);
            if (jVarH == null) {
                EventBus eventBus = EventBus.getDefault();
                List<KGMusic> list = this.f842d;
                eventBus.post(new FavSongStatusItemEvent(104, list, ApmReportHelper.INSTANCE.getJsonErrorMsg(list, "playlist is null")));
                return;
            }
            r rVar = new r(e.c.a.g.a.r.b.o(), jVarH.m(), jVarH.H(), jVarH.p());
            int size = this.f842d.size();
            int iG = bVar.g(jVarH.d());
            rVar.l(iG);
            Integer numValueOf = null;
            int i4 = 0;
            while (i4 < size) {
                KGMusic kGMusic = this.f842d.get(i4);
                String hashValue = kGMusic.getHashValue();
                if (l1.O("mp3", hashValue)) {
                    boolean zK = e.c.a.g.a.d.k.a.k(kGMusic);
                    if (iG == 1) {
                        if (numValueOf == null) {
                            numValueOf = Integer.valueOf(e.c.a.g.a.g.k.b.a.e(jVarH.d()));
                        }
                        num = numValueOf;
                        iIntValue = numValueOf.intValue() + i4 + 1;
                    } else {
                        num = numValueOf;
                        iIntValue = i4;
                    }
                    if (zK) {
                        kGMusic.setHashValue(hashValue);
                        str = str2;
                        i2 = i4;
                        i3 = size;
                        rVar.h(1, 0, hashValue, (int) kGMusic.getDuration(), (int) kGMusic.getSize(), iIntValue, (short) kGMusic.getBitrate(), kGMusic.getDisplayName() + ".mp3", 1, kGMusic.getMvHashValue(), kGMusic.getMvTracks(), kGMusic.getMvType(), kGMusic.getFeeAlbumId(), kGMusic.getMixId(), false);
                    } else {
                        str = str2;
                        i2 = i4;
                        i3 = size;
                    }
                    if (g0.a && !zK) {
                        p1.h(KGApplication.getContext(), "警告：歌曲收藏数据异常，请联系开发");
                    }
                    numValueOf = num;
                } else {
                    str = str2;
                    i2 = i4;
                    i3 = size;
                }
                i4 = i2 + 1;
                size = i3;
                str2 = str;
            }
            String str3 = str2;
            if (rVar.i() > 0) {
                s sVarA = rVar.a();
                if (sVarA == null || sVarA.d() != 144) {
                    if (g0.a) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("CloudAddMusicsToList failed");
                        sb.append(sVarA != null ? Integer.valueOf(sVarA.d()) : " null ");
                        g0.c(str3, sb.toString());
                    }
                    EventBus.getDefault().post(new FavSongStatusItemEvent(107, this.f842d, f(sVarA)));
                } else {
                    if (g0.a) {
                        g0.b("zhpu_cloud", "add song oldver:" + jVarH.H() + ",newVer:" + sVarA.c());
                    }
                    if (jVarH.H() == sVarA.c() || (sVarA.c() == 0 && jVarH.H() == 1)) {
                        ArrayList<e.c.a.g.a.g.k.c.a> arrayListG = sVarA.g();
                        if (arrayListG.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (e.c.a.g.a.g.k.c.a aVar : arrayListG) {
                                Iterator<KGMusic> it = this.f842d.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    KGMusic next = it.next();
                                    if (next != null && !TextUtils.isEmpty(next.getHashValue()) && next.getHashValue().equalsIgnoreCase(aVar.n())) {
                                        aVar.J(e.c.a.g.a.g.k.b.a.d(jVarH.d(), next.getMixId(), next.getSid()));
                                        arrayList.add(aVar);
                                        break;
                                    }
                                }
                            }
                            x.d(this.f844h, arrayList, jVarH.d(), KGMusic.MUSIC_SOURCE_CLOUD, false, true, true, false, null);
                            if (this.a) {
                                if (x.j(sVarA.e(), e.c.a.g.a.g.k.b.a.b(jVarH.d()))) {
                                    c();
                                }
                            }
                        } else {
                            e.c.a.g.a.r.b.V(0);
                            c();
                        }
                        if (this.a) {
                            e.c.a.g.a.g.k.b.a.A(jVarH.d(), sVarA.f());
                            if (e.c.a.g.a.d.k.b.a() && KGApplication.getContext().getString(R.string.kg_navigation_my_fav).equals(jVarH.y()) && jVarH.p() == 0) {
                                e.c.a.g.a.r.b.a0(sVarA.f());
                                e.c.a.g.a.f.m.b.m().X(true);
                            }
                        }
                        if (g0.a) {
                            g0.b(str3, "添加歌曲到收藏列表成功:" + jVarH.e());
                        }
                        EventBus.getDefault().post(new FavSongStatusItemEvent(105, this.f842d));
                    } else {
                        if (g0.a) {
                            g0.c("BLUE", "cloud add musics thread version mismatch, local base version is " + jVarH.H() + ", server base version is " + sVarA.c());
                        }
                        c();
                        EventBus eventBus2 = EventBus.getDefault();
                        List<KGMusic> list2 = this.f842d;
                        eventBus2.post(new FavSongStatusItemEvent(106, list2, ApmReportHelper.INSTANCE.getJsonErrorMsg(list2, "版本不一致，重新同步")));
                    }
                }
                if (sVarA != null && sVarA.b() == 205) {
                    if (g0.a) {
                        g0.c("wwhSync", "205是单个歌单数量超过最大容量的上限，能到这里说明本地数据跟云端数据不一致，需要同步一遍。");
                    }
                    e.c.a.g.a.g.k.b.a.A(jVarH.d(), 0);
                    e.c.a.g.a.r.b.V(0);
                    c();
                }
            } else {
                EventBus.getDefault().post(new FavSongStatusItemEvent(108, this.f842d, "cloudRequest.getmCount() == 0"));
            }
            if (g0.a) {
                g0.c("zzm", "addMusicToPlayList--updatePlayListCoverPic()");
            }
        }
    }

    public boolean d() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(java.util.List<com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic> r13) {
        /*
            r12 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.Iterator r13 = r13.iterator()
        Le:
            boolean r2 = r13.hasNext()
            r3 = 0
            if (r2 == 0) goto L44
            java.lang.Object r2 = r13.next()
            com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic r2 = (com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic) r2
            if (r2 == 0) goto Le
            long r5 = r2.p()
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L32
            long r2 = r2.p()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.add(r2)
            goto Le
        L32:
            java.lang.String r3 = r2.i()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto Le
            java.lang.String r2 = r2.i()
            r0.add(r2)
            goto Le
        L44:
            java.util.List<com.kugou.android.watch.lite.common.music.entity.KGMusic> r13 = r12.f842d
            java.util.Iterator r13 = r13.iterator()
        L4a:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto Laa
            r2 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.Object r7 = r13.next()
            com.kugou.android.watch.lite.common.music.entity.KGMusic r7 = (com.kugou.android.watch.lite.common.music.entity.KGMusic) r7
            long r8 = r7.getMixId()
            java.lang.String r7 = r7.getHashValue()
            r10 = 1
            int r11 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r11 <= 0) goto L82
            java.lang.Long r7 = java.lang.Long.valueOf(r8)
            boolean r7 = r1.contains(r7)
            if (r7 == 0) goto L7a
        L78:
            r2 = 1
            goto L92
        L7a:
            java.lang.Long r7 = java.lang.Long.valueOf(r8)
            r6.add(r7)
            goto L92
        L82:
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L92
            boolean r8 = r0.contains(r7)
            if (r8 == 0) goto L8f
            goto L78
        L8f:
            r5.add(r7)
        L92:
            if (r2 == 0) goto L97
            r13.remove()
        L97:
            int r2 = r6.size()
            if (r2 <= 0) goto La0
            r1.addAll(r6)
        La0:
            int r2 = r5.size()
            if (r2 <= 0) goto L4a
            r0.addAll(r5)
            goto L4a
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.i.d.e(java.util.List):void");
    }

    public final String f(s sVar) {
        if (sVar == null) {
            return "data = null";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("getFileErrorCode", sVar.b());
            jSONObject.put("getmCMD", sVar.d());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean g(Initiator initiator, boolean z) {
        long jW;
        int iIntValue;
        List<KGMusic> listQ;
        List<KGMusic> listQ2;
        n1.a().b("start insert cloud music");
        List<KGMusic> list = this.f842d;
        if (list != null && list.size() > 0) {
            List<KGPlaylistMusic> listM = e.c.a.g.a.g.k.b.a.m(this.f843f.d());
            e(listM);
            if (this.f842d.size() == 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (KGMusic kGMusic : this.f842d) {
                if (kGMusic.getMixId() > 0) {
                    arrayList3.add(Long.valueOf(kGMusic.getMixId()));
                } else {
                    arrayList2.add(kGMusic.getHashValue());
                }
            }
            ArrayList<KGMusic> arrayList4 = new ArrayList();
            if (arrayList3.size() > 0 && (listQ2 = e.c.a.g.a.g.k.a.a.q(arrayList3)) != null && !listQ2.isEmpty()) {
                arrayList4.addAll(listQ2);
            }
            if (arrayList2.size() > 0 && (listQ = e.c.a.g.a.g.k.a.a.q(arrayList3)) != null && !listQ.isEmpty()) {
                arrayList4.addAll(listQ);
            }
            HashMap map = new HashMap();
            for (KGMusic kGMusic2 : arrayList4) {
                if (!TextUtils.isEmpty(kGMusic2.getHashValue())) {
                    map.put(kGMusic2.getHashValue(), kGMusic2);
                }
                if (!TextUtils.isEmpty(kGMusic2.getSqHash())) {
                    map.put(kGMusic2.getSqHash(), kGMusic2);
                }
                if (!TextUtils.isEmpty(kGMusic2.getHash320())) {
                    map.put(kGMusic2.getHash320(), kGMusic2);
                }
            }
            n1.a().b("finish for action");
            int iG = e.c.a.g.a.g.k.b.a.g(this.f843f.d());
            if (iG == 0) {
                iG = 2;
            }
            Integer numValueOf = null;
            if (iG == 1) {
                listM = null;
            }
            for (int i2 = 0; i2 < this.f842d.size(); i2++) {
                KGMusic kGMusic3 = this.f842d.get(i2);
                KGMusic kGMusic4 = (KGMusic) map.get(kGMusic3.getHashValue());
                if (kGMusic4 != null) {
                    jW = kGMusic4.getSid();
                    if (kGMusic4.getHashValue().equalsIgnoreCase(kGMusic3.getHashValue()) && ((!TextUtils.isEmpty(kGMusic3.getSqHash()) && TextUtils.isEmpty(kGMusic4.getSqHash())) || ((!TextUtils.isEmpty(kGMusic3.getHash320()) && TextUtils.isEmpty(kGMusic4.getHash320())) || (!TextUtils.isEmpty(kGMusic3.getMvHashValue()) && TextUtils.isEmpty(kGMusic4.getMvHashValue()))))) {
                        kGMusic3.setSid(kGMusic4.getSid());
                    }
                } else {
                    jW = e.c.a.g.a.g.k.a.a.w(kGMusic3);
                }
                kGMusic3.setSid(jW);
                if (iG == 1) {
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(e.c.a.g.a.g.k.b.a.e(this.f843f.d()));
                    }
                    iIntValue = numValueOf.intValue() + i2 + 1;
                } else {
                    iIntValue = i2;
                }
                this.f845i++;
                KGPlaylistMusic kGPlaylistMusic = new KGPlaylistMusic(kGMusic3, this.f843f.d());
                kGPlaylistMusic.M(iIntValue);
                arrayList.add(kGPlaylistMusic);
                if (g0.a) {
                    g0.b("wwhLogPM--insert", "name :" + kGMusic3.getDisplayName() + "--kgpm cloudfileId:" + kGMusic3.getFileId() + "--weight :" + iIntValue);
                }
            }
            n1.a().b("finish add music");
            e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
            int iR = bVar.r(arrayList);
            e.c.a.g.a.f.j.b.j.b().d(this.f842d).b();
            if (iR > 0) {
                if (listM != null && listM.size() > 0) {
                    bVar.z(this.f843f.d(), iR, listM);
                }
                n1.a().b("finish insert songs");
                return true;
            }
        }
        return false;
    }

    public void h(CloudMusicModel cloudMusicModel) {
    }
}
