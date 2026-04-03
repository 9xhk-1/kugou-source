package com.kugou.uilib.widget.textview.font;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.kugou.uilib.utils.KGUILog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FontManager {
    public static final int AKROBAT_EXTRA_BOLD = 2;
    public static final int AKROBAT_SEMI_BOLD = 1;
    public static final int DIN_BOLD = 6;
    public static final int FUTURA_CONDENSED = 5;
    public static final int MANROPE_MEDIUM = 3;
    public static final int MANROPE_SEMI_BOLD = 4;
    public static final int NO_CUSTOM = 0;
    private static final String TAG = "FontManager";
    private static volatile FontManager sFontManager;
    private Context mContext;
    private Map<Integer, Typeface> map;

    private FontManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static FontManager getInstance(Context context) {
        if (sFontManager == null) {
            synchronized (FontManager.class) {
                if (sFontManager == null) {
                    sFontManager = new FontManager(context);
                }
            }
        }
        return sFontManager;
    }

    public Typeface getFontType(int i2) {
        String str;
        Typeface typefaceCreateFromAsset;
        if (this.map == null) {
            this.map = new HashMap();
        }
        if (this.map.get(Integer.valueOf(i2)) != null) {
            return this.map.get(Integer.valueOf(i2));
        }
        switch (i2) {
            case 1:
                str = "fonts/akrobat-semibold.ttf";
                break;
            case 2:
                str = "fonts/akrobat-extrabold.otf";
                break;
            case 3:
                str = "fonts/Manrope-Medium.otf";
                break;
            case 4:
                str = "fonts/Manrope-SemiBold.ttf";
                break;
            case 5:
                str = "fonts/Futura-Condensed.otf";
                break;
            case 6:
                str = "fonts/DIN-Bold.otf";
                break;
            default:
                str = "default";
                break;
        }
        if (TextUtils.isEmpty(str)) {
            Typeface typeface = Typeface.DEFAULT;
            this.map.put(0, typeface);
            return typeface;
        }
        try {
            typefaceCreateFromAsset = Typeface.createFromAsset(this.mContext.getAssets(), str);
            this.map.put(Integer.valueOf(i2), typefaceCreateFromAsset);
        } catch (Exception e2) {
            typefaceCreateFromAsset = Typeface.DEFAULT;
            this.map.put(0, typefaceCreateFromAsset);
            if (KGUILog.DEBUG) {
                KGUILog.e(TAG, "getFontType: " + e2);
            }
        }
        return typefaceCreateFromAsset;
    }
}
