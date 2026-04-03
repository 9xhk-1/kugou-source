package com.kugou.android.watch.lite.musicrank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.widget.PlayerBall;
import e.c.a.g.a.d.x.f;
import e.c.c.l.f.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
@b(id = -1)
public final class FamilyHomeRankFragment extends DelegateFragment {
    public PlayerBall r;
    public final FamilyRankFragment s = new FamilyRankFragment();

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
        PlayerBall playerBall = this.r;
        if (playerBall == null) {
            return;
        }
        playerBall.j(false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
        PlayerBall playerBall = this.r;
        if (playerBall == null) {
            return;
        }
        playerBall.j(f.q());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_family_music_rank, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PlayerBall playerBall = this.r;
        if (playerBall == null) {
            return;
        }
        playerBall.j(false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PlayerBall playerBall = this.r;
        if (playerBall == null) {
            return;
        }
        playerBall.j(f.q());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        PlayerBall playerBall = (PlayerBall) view.findViewById(R.id.play_ball);
        this.r = playerBall;
        if (playerBall != null) {
            playerBall.setupFragment(this);
        }
        View viewFindViewById = view.findViewById(R.id.fragment_container);
        j.d(viewFindViewById, "view.findViewById(R.id.fragment_container)");
        u0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "音乐排行榜";
    }

    public final void u0() {
        getChildFragmentManager().beginTransaction().add(R.id.fragment_container, this.s).commit();
    }
}
