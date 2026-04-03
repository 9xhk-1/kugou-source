package com.kugou.uilib;

import android.content.Context;
import com.kugou.uilib.IKGUIBuild;

/* JADX INFO: loaded from: classes2.dex */
public class KGUI implements IKGUI {
    private static volatile KGUI mInstance;
    private KGUIBuild mBuild;

    public static KGUI getInstance() {
        if (mInstance == null) {
            synchronized (KGUI.class) {
                if (mInstance == null) {
                    mInstance = new KGUI();
                }
            }
        }
        return mInstance;
    }

    @Override // com.kugou.uilib.IKGUI
    public Context getAppContext() {
        return this.mBuild.mContext;
    }

    @Override // com.kugou.uilib.IKGUI
    public IKGUIBuild.IImageAccessibilityListener getImageAccessibilityListener() {
        return this.mBuild.mIImageAccessibilityListener;
    }

    @Override // com.kugou.uilib.IKGUI
    public IKGUIBuild.IUploadExceptionListener getUploadExceptionListener() {
        return this.mBuild.mIUploadExceptionListener;
    }

    public IKGUIBuild init() {
        if (getInstance().mBuild == null) {
            getInstance().mBuild = new KGUIBuild();
        }
        return getInstance().mBuild;
    }

    @Override // com.kugou.uilib.IKGUI
    public boolean isDebugOpen() {
        return this.mBuild.isLogOpen;
    }
}
