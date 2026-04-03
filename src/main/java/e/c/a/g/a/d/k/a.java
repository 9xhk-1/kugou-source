package e.c.a.g.a.d.k;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fav.CloudMusicModel;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.LocalMusic;
import com.kugou.android.watch.lite.component.fav.MusicInfo;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import com.kugou.common.event.FavSongStatusItemEvent;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.d.f.c.a.j;
import e.c.a.g.a.d.r.e;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.g.i.d;
import e.c.a.g.a.g.i.y;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.n1;
import e.c.a.g.a.s.p1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static volatile a a;
    public static boolean b;

    /* JADX INFO: renamed from: e.c.a.g.a.d.k.a$a, reason: collision with other inner class name */
    public class RunnableC0058a implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ Initiator b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CloudMusicModel f444d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ j f445f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ e f446h;

        public RunnableC0058a(a aVar, List list, Initiator initiator, CloudMusicModel cloudMusicModel, j jVar, e eVar) {
            this.a = list;
            this.b = initiator;
            this.f444d = cloudMusicModel;
            this.f445f = jVar;
            this.f446h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.H(this.b, KGMusic.toKgSongArray((List<? extends KGMusic>) this.a), this.f444d, this.f445f, this.f446h);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ j b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f447d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f448f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f449h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ CloudMusicModel f450i;
        public final /* synthetic */ Initiator j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ String l;
        public final /* synthetic */ List m;

        public b(List list, j jVar, boolean z, String str, int i2, CloudMusicModel cloudMusicModel, Initiator initiator, boolean z2, String str2, List list2) {
            this.a = list;
            this.b = jVar;
            this.f447d = z;
            this.f448f = str;
            this.f449h = i2;
            this.f450i = cloudMusicModel;
            this.j = initiator;
            this.k = z2;
            this.l = str2;
            this.m = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (this.a.size() <= 0) {
                a.this.j(this.f448f, this.b.y(), true, false, this.f449h, this.a, this.f450i);
                return;
            }
            ArrayList arrayList = new ArrayList(this.a);
            if (g0.a) {
                g0.c("wwhLog", "insert playlist type :" + this.b.E());
            }
            if (e.c.a.g.a.r.b.o() != 0) {
                this.b.d0(2);
            } else {
                this.b.d0(1);
            }
            d dVar = new d(arrayList, this.b);
            if (this.f447d && this.b.E() == 2 && dVar.d()) {
                e.c.a.g.a.f.d.a.d(new Intent("android.intent.action.cloudmusic.fail.fav.outofspace"));
                a.this.j(this.f448f, this.b.y(), false, true, this.f449h, this.a, this.f450i);
                return;
            }
            dVar.h(this.f450i);
            boolean z = false;
            dVar.g(this.j, false);
            if (this.b.E() == 2) {
                y.e().a(6, this.b.e(), dVar);
            }
            String strD = null;
            if (this.k) {
                int i2 = this.f449h;
                if (i2 == 2) {
                    strD = this.f450i.d();
                } else {
                    if (i2 == 1) {
                        strD = this.f450i.d();
                    } else if (i2 != 3) {
                        if (i2 == 0) {
                            strD = this.f450i.i() ? this.f450i.d() : (this.l.equals(this.b.y()) && this.m.size() == 0) ? e.c.c.o.f.a().getString(R.string.kg_tip_addtoplaylist_success) : (this.l.equals(this.b.y()) || this.m.size() != 0) ? e.c.c.o.f.a().getString(R.string.kg_tip_addtoplaylist_part_success) : e.c.c.o.f.a().getString(R.string.kg_tip_addtoplaylist_success);
                        }
                    }
                    str = strD;
                    z = true;
                }
                str = strD;
            } else {
                str = strD;
                z = true;
            }
            a.this.s(z, this.k, str, this.b.e(), arrayList, this.f450i, this.j);
            e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.update_fav_btn_state"));
            a.this.j(this.f448f, this.b.y(), true, false, this.f449h, this.a, this.f450i);
        }
    }

    static {
        b = c.c().getConfigAsInt(e.c.a.g.a.f.e.b.z2, 1) == 1;
    }

    public static boolean k(KGMusic kGMusic) {
        boolean z = false;
        if (kGMusic != null) {
            int ifCanDownload = kGMusic.getIfCanDownload();
            if (ifCanDownload != 0) {
                if (ifCanDownload == 1) {
                    return true;
                }
            } else if (!TextUtils.isEmpty(kGMusic.getHashValue())) {
                if (g0.f()) {
                    Log.d("mhs_watch_favapm", "CAN_DOWNLOAD_UNKNOWN, enableFavSwith = " + b);
                }
                if (b && kGMusic.mixId > 0) {
                    if (g0.f()) {
                        Log.d("mhs_watch_favapm", "解决不上传的问题");
                    }
                    z = true;
                }
                if (kGMusic.getIfCanDownload() == 1) {
                    return true;
                }
                return z;
            }
        }
        return false;
    }

    public static a p() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public static int q(j jVar) {
        if (jVar != null) {
            return r(jVar) ? e.c.a.g.a.f.m.c.a.b("cloud_fav_playlist_max_music_count", 10000) : e.c.a.g.a.f.m.c.a.b("cloud_playlist_max_music_count", 1000);
        }
        return 0;
    }

    public static boolean r(j jVar) {
        return jVar != null && "我喜欢".equals(jVar.y()) && jVar.p() == 0;
    }

    public void c(Context context, Initiator initiator, List<? extends KGMusic> list, j jVar, CloudMusicModel cloudMusicModel) {
        if (jVar == null || context == null) {
            return;
        }
        if (g(e.c.c.o.f.a(), jVar, list, cloudMusicModel)) {
            boolean zH = cloudMusicModel.h();
            boolean zF = cloudMusicModel.f();
            String strB = cloudMusicModel.b();
            int iC = cloudMusicModel.c();
            String string = context.getString(R.string.kg_navigation_my_fav);
            context.getString(R.string.kg_my_cloud_playlist_default_list);
            Iterator<? extends KGMusic> it = list.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                KGMusic next = it.next();
                if ((next instanceof LocalMusic) && next.isFromLocalMusic()) {
                    arrayList.add((LocalMusic) next);
                    it.remove();
                } else if (next == null) {
                    it.remove();
                } else if (TextUtils.isEmpty(next.getHashValue())) {
                    it.remove();
                }
            }
            if (list.size() == 0) {
                if (iC == 2) {
                    p1.g(KGApplication.getContext(), R.string.fees_cloud_fail_need_buy);
                    return;
                } else if (arrayList.size() > 0) {
                    p1.g(KGApplication.getContext(), R.string.local_music_edit_mode_selected_song_not_exist);
                    return;
                }
            }
            j0.b().a(new b(list, jVar, zF, strB, iC, cloudMusicModel, initiator, zH, string, arrayList));
        }
    }

    public void d(Initiator initiator, boolean z, List<? extends KGMusic> list, j jVar, CloudMusicModel cloudMusicModel, e eVar) {
        if (g(e.c.c.o.f.a(), jVar, list, cloudMusicModel)) {
            boolean z2 = false;
            Iterator<? extends KGMusic> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    it.remove();
                    z2 = true;
                }
            }
            if (z2 && list.size() == 0) {
                return;
            }
            if (list.size() > 0) {
                j0.b().a(new RunnableC0058a(this, list, initiator, cloudMusicModel, jVar, eVar));
                return;
            }
            list.size();
            if (cloudMusicModel.e() || cloudMusicModel.g()) {
                cloudMusicModel.z(cloudMusicModel.d() == null ? "" : cloudMusicModel.d());
                o(e.c.c.o.f.a(), initiator, list, jVar, cloudMusicModel);
            }
        }
    }

    public void e(Initiator initiator, boolean z, List<? extends KGMusic> list, j jVar, boolean z2, boolean z3, String str, String str2, boolean z4, e eVar, boolean z5, String str3) {
        CloudMusicModel cloudMusicModel = new CloudMusicModel(z2, z3, str, str2, z4, z5);
        cloudMusicModel.l(str3);
        d(initiator, z, list, jVar, cloudMusicModel, eVar);
    }

    public boolean f(Context context, j jVar, List<? extends KGMusic> list) {
        return h(context, jVar, list, null, true);
    }

    public boolean g(Context context, j jVar, List<? extends KGMusic> list, CloudMusicModel cloudMusicModel) {
        return h(context, jVar, list, cloudMusicModel, true);
    }

    public boolean h(Context context, j jVar, List<? extends KGMusic> list, CloudMusicModel cloudMusicModel, boolean z) {
        return i(context, jVar, list, cloudMusicModel, true, null);
    }

    public boolean i(Context context, j jVar, List<? extends KGMusic> list, CloudMusicModel cloudMusicModel, boolean z, String str) {
        if (context == null || jVar == null || list == null) {
            return false;
        }
        if (jVar.E() == -1 || list.isEmpty()) {
            return true;
        }
        int iZ = jVar.z();
        if (iZ <= 0 && jVar.e() > 0) {
            iZ = e.c.a.g.a.g.k.b.a.b(jVar.d());
        }
        boolean zR = r(jVar);
        int iQ = q(jVar);
        if (g0.a) {
            g0.c("wwhCloudMax", "是否是我喜欢歌单 :" + zR + "--歌曲数 :" + iZ + "--最大值 :" + iQ + "当期歌曲数量 :" + list.size());
        }
        if (iZ + list.size() <= iQ) {
            return true;
        }
        if (!"用户登录第一次同步".equals(list.get(0).getSource()) && z) {
            if (TextUtils.isEmpty(str)) {
                str = "该歌单收藏歌曲超过上限" + iQ + "，无法收藏，请删除后再添加。";
            }
            p1.h(e.c.c.o.f.a(), str);
            EventBus.getDefault().post(new FavSongStatusItemEvent(112, list, ApmReportHelper.INSTANCE.getJsonErrorMsg(list, str)));
            Intent intent = new Intent("com.kugou.android.update_fav_btn_state");
            if (list.size() == 1) {
                intent.putExtra("hash", list.get(0).getHashValue());
                intent.putExtra("mixid", list.get(0).getMixId());
            }
            intent.putExtra(NotificationCompat.CATEGORY_STATUS, false);
            e.c.a.g.a.f.d.a.d(intent);
        }
        return false;
    }

    public final void j(String str, String str2, boolean z, boolean z2, int i2, List<? extends KGMusic> list, CloudMusicModel cloudMusicModel) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        e.c.a.g.a.f.d.a.d(new Intent("android.intent.action.cloudmusic.success"));
    }

    public boolean l(Context context, Initiator initiator, List<KGPlaylistMusic> list, String str, boolean z) {
        return m(context, initiator, list, str, z, true, null, true);
    }

    public boolean m(Context context, Initiator initiator, List<KGPlaylistMusic> list, String str, boolean z, boolean z2, String str2, boolean z3) {
        n1.a().c("click delete music by songs");
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("deleteMusicsBySongs, broadcast ACTION_CLOUD_MUSIC_DELETE_SUCCESS sent, playlistId is ");
            sb.append(str);
            sb.append(", song count is ");
            sb.append(list != null ? Integer.valueOf(list.size()) : " null");
            g0.b("BLUE", sb.toString());
        }
        j jVarH = e.c.a.g.a.g.k.b.a.h(str, false);
        if (jVarH == null) {
            return false;
        }
        n1.a().b("get playlist finish");
        e.c.a.g.a.g.i.f fVar = new e.c.a.g.a.g.i.f(list, jVarH);
        fVar.b(z2);
        fVar.d();
        n1.a().b("delete musicByPlaylist finish");
        if (z) {
            p1.g(context, R.string.kg_tip_cancelfromplaylist_success);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        if (list != null && list.size() > 0) {
            int i2 = 0;
            while (i2 < list.size()) {
                KGPlaylistMusic kGPlaylistMusic = list.get(i2);
                if (kGPlaylistMusic.k() != null) {
                    arrayList.add(kGPlaylistMusic.k().getDisplayName());
                }
                arrayList2.add(kGPlaylistMusic.i());
                MusicInfo musicInfo = new MusicInfo();
                e.c.a.g.a.g.i.f fVar2 = fVar;
                musicInfo.e(kGPlaylistMusic.p());
                musicInfo.d(kGPlaylistMusic.i());
                arrayList5.add(musicInfo);
                if (kGPlaylistMusic.p() > 0) {
                    arrayList3.add(String.valueOf(kGPlaylistMusic.p()));
                } else {
                    arrayList4.add(kGPlaylistMusic.i());
                }
                i2++;
                fVar = fVar2;
            }
        }
        e.c.a.g.a.g.i.f fVar3 = fVar;
        n1 n1VarA = n1.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("finish make data :");
        sb2.append(list == null ? "" : Integer.valueOf(list.size()));
        n1VarA.b(sb2.toString());
        Intent intent = new Intent("com.kugou.android.cloud_music_delete_success");
        intent.putExtra("clearCache", z3);
        intent.putExtra("globalId", str);
        intent.putExtra(context.getString(R.string.kg_tip_cancelfromplaylist_success), (String[]) arrayList.toArray(new String[0]));
        intent.putExtra("delSongHash", (String[]) arrayList2.toArray(new String[0]));
        intent.putExtra("del_cloud_mixids", (String[]) arrayList3.toArray(new String[0]));
        intent.putExtra("del_cloud_mixid_is_0_only_hash", (String[]) arrayList4.toArray(new String[0]));
        intent.putExtra("del_cloud_music_info", arrayList5);
        e.c.a.g.a.f.d.a.d(intent);
        if (jVarH.E() != 2) {
            return true;
        }
        y.e().a(7, jVarH.e(), fVar3);
        return true;
    }

    public void n(Initiator initiator, List<? extends KGMusic> list, j jVar, CloudMusicModel cloudMusicModel) {
        if (!cloudMusicModel.e() && !cloudMusicModel.g()) {
            c(e.c.c.o.f.a(), initiator, list, jVar, cloudMusicModel);
        } else {
            cloudMusicModel.z(cloudMusicModel.d() == null ? "" : cloudMusicModel.d());
            o(e.c.c.o.f.a(), initiator, list, jVar, cloudMusicModel);
        }
    }

    public final boolean o(Context context, Initiator initiator, List<? extends KGMusic> list, j jVar, CloudMusicModel cloudMusicModel) {
        p1.h(context, "暂不支持新建歌单");
        return true;
    }

    public final void s(boolean z, boolean z2, String str, int i2, List<KGMusic> list, CloudMusicModel cloudMusicModel, Initiator initiator) {
        if (z2) {
            p1.h(KGApplication.getContext(), str);
        }
    }
}
