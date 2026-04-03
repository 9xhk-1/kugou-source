package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.kugou.uilib.widget.baseDelegate.AbsViewDelegate;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SkinDelegate<T extends View> extends AbsViewDelegate<T> {
    public static final int[] STATE_ARRAY_NORMAL = new int[0];
    public static final int STATE_CHECKED = -16842912;
    public static final int STATE_CHECKED_FALSE = 16842912;
    public static final int STATE_ENABLED = -16842910;
    public static final int STATE_ENABLED_FALSE = 16842910;
    public static final int STATE_PRESSED = -16842919;
    public static final int STATE_PRESSED_FALSE = 16842919;
    public static final int STATE_SELECTED = -16842913;
    public static final int STATE_SELECTED_FALSE = 16842913;

    public ColorStateList generateStateListColor(Map<int[], Integer> map) {
        Set<Map.Entry<int[], Integer>> setEntrySet = map.entrySet();
        int size = setEntrySet.size();
        int[][] iArr = new int[size][];
        int[] iArr2 = new int[size];
        for (Map.Entry<int[], Integer> entry : setEntrySet) {
            iArr[0] = entry.getKey();
            iArr2[0] = entry.getValue().intValue();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public StateListDrawable generateStateListDrawable(Map<int[], Drawable> map) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        for (Map.Entry<int[], Drawable> entry : map.entrySet()) {
            stateListDrawable.addState(entry.getKey(), entry.getValue());
        }
        return stateListDrawable;
    }
}
