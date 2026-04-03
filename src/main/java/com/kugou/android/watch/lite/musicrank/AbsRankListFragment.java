package com.kugou.android.watch.lite.musicrank;

import android.os.Bundle;
import android.view.View;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.f.j.a.c;
import e.c.a.g.a.l.b;
import e.c.a.g.a.l.g;
import e.c.a.g.a.s.j0;
import f.u.m;
import f.z.d.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsRankListFragment extends DelegateListFragment<b, KGSong> {

    public static final class a implements Runnable {
        public final /* synthetic */ ArrayList<KGSong> b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List<KGSong> f213d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ArrayList<KGSong> arrayList, List<? extends KGSong> list) {
            this.b = arrayList;
            this.f213d = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<KGMusicWrapper> listK = f.k();
            if (listK != null && AbsRankListFragment.this.M1(listK, this.b)) {
                f.c(false, c.g(this.f213d, Initiator.create(AbsRankListFragment.this.m()).carryPagePath(AbsRankListFragment.this.n()), "22"));
            }
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public e.c.a.g.a.f.o.h.a<KGSong> D0() {
        return L1();
    }

    public final void K1(List<? extends KGSong> list) {
        j0.b().a(new a(new ArrayList(L1().i()), list));
    }

    public abstract g L1();

    public final boolean M1(List<? extends KGMusicWrapper> list, ArrayList<KGSong> arrayList) {
        if (list.size() > arrayList.size()) {
            return false;
        }
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                m.i();
                throw null;
            }
            KGSong kGSong = arrayList.get(i2);
            j.d(kGSong, "list[idx]");
            if (((KGMusicWrapper) obj).getMixId() != kGSong.T1()) {
                return false;
            }
            i2 = i3;
        }
        return true;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void f1(List<? extends KGSong> list, boolean z) {
        j.e(list, "newAddedData");
        super.f1(list, z);
        if (z) {
            K1(list);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public int o() {
        return 1;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
    }
}
