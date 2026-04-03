package com.kugou.android.audioidentify;

import android.os.Bundle;
import e.c.c.l.f.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
@b(id = 528178838)
public final class TingIdentifyFragment extends AbsIdentifyFragment {
    public Bundle B;

    public TingIdentifyFragment(Bundle bundle) {
        j.e(bundle, "bundle");
        this.B = bundle;
    }

    @Override // com.kugou.android.audioidentify.AbsIdentifyFragment
    public boolean F0() {
        Bundle bundle = this.B;
        return bundle != null && bundle.getBoolean("startIdentify", false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "听歌识曲";
    }

    @Override // com.kugou.android.audioidentify.AbsIdentifyFragment
    public int x0() {
        return 0;
    }
}
