package com.kugou.uilib;

import android.content.Context;
import com.kugou.uilib.IKGUIBuild;

/* JADX INFO: loaded from: classes2.dex */
public interface IKGUI {
    Context getAppContext();

    IKGUIBuild.IImageAccessibilityListener getImageAccessibilityListener();

    IKGUIBuild.IUploadExceptionListener getUploadExceptionListener();

    boolean isDebugOpen();
}
