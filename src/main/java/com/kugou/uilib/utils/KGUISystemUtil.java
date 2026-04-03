package com.kugou.uilib.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.WindowManager;
import com.kugou.uilib.KGUI;

/* JADX INFO: loaded from: classes2.dex */
public class KGUISystemUtil {
    public static int dp2px(float f2) {
        return (int) ((f2 * KGUI.getInstance().getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int px2dp(float f2) {
        return (int) ((f2 / KGUI.getInstance().getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float sp2px(int i2) {
        return (int) TypedValue.applyDimension(2, i2, KGUI.getInstance().getAppContext().getResources().getDisplayMetrics());
    }
}
