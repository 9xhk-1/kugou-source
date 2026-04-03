package com.kugou.uilib.widget.popupwindow;

import android.content.Context;
import com.kugou.uilib.widget.popupwindow.BasePopup;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIPopupWindow extends BasePopup<KGUIPopupWindow> {
    private BasePopup.OnViewListener mOnViewListener;

    public KGUIPopupWindow() {
    }

    public static KGUIPopupWindow create() {
        return new KGUIPopupWindow();
    }

    @Override // com.kugou.uilib.widget.popupwindow.BasePopup
    public void initAttributes() {
    }

    public KGUIPopupWindow(Context context) {
        setContext(context);
    }

    public static KGUIPopupWindow create(Context context) {
        return new KGUIPopupWindow(context);
    }
}
