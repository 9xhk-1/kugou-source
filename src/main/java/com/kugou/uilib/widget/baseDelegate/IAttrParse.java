package com.kugou.uilib.widget.baseDelegate;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IAttrParse {
    <E extends IViewDelegate> E getCommonDelegate(Class<E> cls);

    <T extends IViewDelegate> List<T> getDelegates(TypedArray typedArray);

    void parseAttributeSet(@NonNull Context context, AttributeSet attributeSet, int i2);
}
