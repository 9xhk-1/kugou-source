package com.kugou.common.permission.source;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentSource extends Source {
    private Fragment mFragment;

    public FragmentSource(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Override // com.kugou.common.permission.source.Source
    public Context getContext() {
        return this.mFragment.getActivity();
    }

    @Override // com.kugou.common.permission.source.Source
    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return this.mFragment.shouldShowRequestPermissionRationale(str);
    }

    @Override // com.kugou.common.permission.source.Source
    public void startActivity(Intent intent) {
        this.mFragment.startActivity(intent);
    }

    @Override // com.kugou.common.permission.source.Source
    public void startActivityForResult(Intent intent, int i2) {
        this.mFragment.startActivityForResult(intent, i2);
    }
}
