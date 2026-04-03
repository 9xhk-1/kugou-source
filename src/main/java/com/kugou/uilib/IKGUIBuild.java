package com.kugou.uilib;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes2.dex */
public interface IKGUIBuild {

    public interface IImageAccessibilityListener {
        void processAccessibility(Context context, AttributeSet attributeSet);
    }

    public interface IUploadExceptionListener {
        void processUploadException(Throwable th);
    }

    void build();

    IKGUIBuild setAppContext(Context context);

    IKGUIBuild setImageAccessibility(IImageAccessibilityListener iImageAccessibilityListener);

    IKGUIBuild setKGUILog(boolean z);

    IKGUIBuild setUploadExceptionListener(IUploadExceptionListener iUploadExceptionListener);
}
