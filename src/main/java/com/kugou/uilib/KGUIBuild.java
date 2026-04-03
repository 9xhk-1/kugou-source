package com.kugou.uilib;

import android.content.Context;
import com.kugou.uilib.IKGUIBuild;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIBuild implements IKGUIBuild {
    public boolean isLogOpen = true;
    public Context mContext;
    public IKGUIBuild.IImageAccessibilityListener mIImageAccessibilityListener;
    public IKGUIBuild.IUploadExceptionListener mIUploadExceptionListener;

    @Override // com.kugou.uilib.IKGUIBuild
    public void build() {
    }

    @Override // com.kugou.uilib.IKGUIBuild
    public IKGUIBuild setAppContext(Context context) {
        this.mContext = context;
        return this;
    }

    @Override // com.kugou.uilib.IKGUIBuild
    public IKGUIBuild setImageAccessibility(IKGUIBuild.IImageAccessibilityListener iImageAccessibilityListener) {
        this.mIImageAccessibilityListener = iImageAccessibilityListener;
        return this;
    }

    @Override // com.kugou.uilib.IKGUIBuild
    public IKGUIBuild setKGUILog(boolean z) {
        this.isLogOpen = z;
        return this;
    }

    @Override // com.kugou.uilib.IKGUIBuild
    public IKGUIBuild setUploadExceptionListener(IKGUIBuild.IUploadExceptionListener iUploadExceptionListener) {
        this.mIUploadExceptionListener = iUploadExceptionListener;
        return this;
    }
}
