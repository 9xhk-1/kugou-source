package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.uilib.R;
import com.kugou.uilib.compile.build.KGUIDelegateHelper;
import com.kugou.uilib.widget.baseDelegate.KGUIDelegateManager;

/* JADX INFO: loaded from: classes2.dex */
public class CommonDelegateHelper {
    public static TypedArray getCommonTypeArray(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        return context.obtainStyledAttributes(attributeSet, R.styleable.KGUIView, i2, 0);
    }

    public static <T extends View> KGUIDelegateManager<T> initCommonDelegate(TypedArray typedArray) {
        KGUIDelegateManager<T> kGUIDelegateManager = new KGUIDelegateManager<>();
        kGUIDelegateManager.addList(KGUIDelegateHelper.getCommonPlugin(typedArray));
        int i2 = R.styleable.KGUIView_kgui_skin_delegate;
        if (typedArray.hasValue(i2)) {
            try {
                kGUIDelegateManager.add((SkinDelegate) Class.forName(typedArray.getString(i2)).getConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return kGUIDelegateManager;
    }
}
