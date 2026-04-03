package com.kugou.uilib.widget.imageview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kugou.uilib.IKGUIBuild;
import com.kugou.uilib.KGUI;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIAccessibleImageView extends ImageView {
    public static final String TAG = "AccessibilityImageView";

    public KGUIAccessibleImageView(Context context) {
        this(context, null);
    }

    public KGUIAccessibleImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGUIAccessibleImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        IKGUIBuild.IImageAccessibilityListener imageAccessibilityListener = KGUI.getInstance().getImageAccessibilityListener();
        if (imageAccessibilityListener != null) {
            imageAccessibilityListener.processAccessibility(context, attributeSet);
        }
    }
}
