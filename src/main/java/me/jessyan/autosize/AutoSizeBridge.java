package me.jessyan.autosize;

import android.app.Application;
import android.util.DisplayMetrics;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.s.f1;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class AutoSizeBridge {
    private static final int MIN_DPI = 120;
    private static final int MIN_DPI_CHANGHONG = 160;
    private static final int MIN_DPI_JXW = 160;
    private static final int MIN_DPI_XIAOMI = 160;
    private static final String TAG = "AutoSizeBridge";
    public static boolean isApplyAutoSize = false;

    private static void applyAutoSizeCommon(Application application, int i2, boolean z) {
        AutoSizeConfig.getInstance().enableMaxConstrain = z;
        AutoSizeConfig.getInstance().setLog(g0.a).init(application).setUseDeviceSize(false);
        AutoSizeConfig.getInstance().setCustomFragment(true);
        AutoSizeConfig.getInstance().setDesignWidthInDp(i2);
        onApplyAutoSize();
    }

    public static void applyCompat(Application application) {
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        int i2 = displayMetrics.densityDpi;
        if (g0.a) {
            g0.b(TAG, "applyCompat: dpi=" + i2 + "  metrics=" + displayMetrics);
        }
        if (l1.n0()) {
            if (i2 <= 160) {
                applyAutoSizeCommon(application, 180, false);
                return;
            }
        } else if (l1.X()) {
            if (i2 <= 160) {
                applyAutoSizeCommon(application, caleJXWDeviceDPI(), false);
                return;
            }
        } else if (l1.N() && i2 <= 160) {
            applyAutoSizeCommon(application, 200, false);
            return;
        }
        if (i2 <= 120) {
            applyAutoSizeCommon(application, 180, true);
        }
    }

    private static int caleJXWDeviceDPI() {
        f1 defaultSize = KGApplication.getDefaultSize();
        return (defaultSize.a == 202 && defaultSize.b == 960) ? 180 : 200;
    }

    public static float getTargetScaledDensity() {
        float screenHeight;
        int designHeightInDp;
        AutoSizeConfig autoSizeConfig = AutoSizeConfig.getInstance();
        if (autoSizeConfig.isBaseOnWidth()) {
            screenHeight = autoSizeConfig.getScreenWidth() * 1.0f;
            designHeightInDp = autoSizeConfig.getDesignWidthInDp();
        } else {
            screenHeight = autoSizeConfig.getScreenHeight() * 1.0f;
            designHeightInDp = autoSizeConfig.getDesignHeightInDp();
        }
        return (screenHeight / designHeightInDp) * ((autoSizeConfig.getInitScaledDensity() * 1.0f) / autoSizeConfig.getInitDensity());
    }

    private static void onApplyAutoSize() {
        isApplyAutoSize = true;
    }
}
