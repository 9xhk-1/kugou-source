package me.jessyan.autosize;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.Locale;
import me.jessyan.autosize.external.ExternalAdaptInfo;
import me.jessyan.autosize.internal.CustomAdapt;
import me.jessyan.autosize.unit.Subunits;
import me.jessyan.autosize.utils.AutoSizeLog;
import me.jessyan.autosize.utils.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoSize {
    private static final int MODE_DEVICE_SIZE = Integer.MIN_VALUE;
    private static final int MODE_MASK = -1073741824;
    private static final int MODE_ON_WIDTH = 1073741824;
    private static final int MODE_SHIFT = 30;
    private static SparseArray<DisplayMetricsInfo> mCache = new SparseArray<>();

    /* JADX INFO: renamed from: me.jessyan.autosize.AutoSize$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$me$jessyan$autosize$unit$Subunits;

        static {
            int[] iArr = new int[Subunits.values().length];
            $SwitchMap$me$jessyan$autosize$unit$Subunits = iArr;
            try {
                iArr[Subunits.PT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$me$jessyan$autosize$unit$Subunits[Subunits.MM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$me$jessyan$autosize$unit$Subunits[Subunits.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$me$jessyan$autosize$unit$Subunits[Subunits.IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private AutoSize() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static void autoConvertDensity(Activity activity, float f2, boolean z) {
        float density;
        int densityDpi;
        float scaledDensity;
        int screenWidthDp;
        int screenHeightDp;
        float f3;
        Preconditions.checkNotNull(activity, "activity == null");
        Preconditions.checkMainThread();
        float designWidth = z ? AutoSizeConfig.getInstance().getUnitsManager().getDesignWidth() : AutoSizeConfig.getInstance().getUnitsManager().getDesignHeight();
        if (designWidth <= 0.0f) {
            designWidth = f2;
        }
        int iRound = Math.round((f2 + designWidth + (z ? AutoSizeConfig.getInstance().getScreenWidth() : AutoSizeConfig.getInstance().getScreenHeight())) * AutoSizeConfig.getInstance().getInitScaledDensity()) & 1073741823;
        int i2 = z ? iRound | 1073741824 : iRound & (-1073741825);
        int i3 = AutoSizeConfig.getInstance().isUseDeviceSize() ? i2 | Integer.MIN_VALUE : i2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        DisplayMetricsInfo displayMetricsInfo = mCache.get(i3);
        if (displayMetricsInfo == null) {
            density = ((z ? AutoSizeConfig.getInstance().getScreenWidth() : AutoSizeConfig.getInstance().getScreenHeight()) * 1.0f) / f2;
            if (AutoSizeConfig.getInstance().enableMaxConstrain) {
                float initDensity = AutoSizeConfig.getInstance().getInitDensity() * AutoSizeConfig.getInstance().MAX_SCALE_FACTOR;
                if (density > initDensity) {
                    density = initDensity;
                }
            }
            float privateFontScale = (AutoSizeConfig.getInstance().getPrivateFontScale() > 0.0f ? AutoSizeConfig.getInstance().getPrivateFontScale() : AutoSizeConfig.getInstance().isExcludeFontScale() ? 1.0f : (AutoSizeConfig.getInstance().getInitScaledDensity() * 1.0f) / AutoSizeConfig.getInstance().getInitDensity()) * density;
            densityDpi = (int) (160.0f * density);
            screenWidthDp = (int) (AutoSizeConfig.getInstance().getScreenWidth() / density);
            screenHeightDp = (int) (AutoSizeConfig.getInstance().getScreenHeight() / density);
            float screenWidth = ((z ? AutoSizeConfig.getInstance().getScreenWidth() : AutoSizeConfig.getInstance().getScreenHeight()) * 1.0f) / designWidth;
            mCache.put(i3, new DisplayMetricsInfo(density, densityDpi, privateFontScale, screenWidth, screenWidthDp, screenHeightDp));
            scaledDensity = privateFontScale;
            f3 = screenWidth;
        } else {
            density = displayMetricsInfo.getDensity();
            densityDpi = displayMetricsInfo.getDensityDpi();
            scaledDensity = displayMetricsInfo.getScaledDensity();
            float xdpi = displayMetricsInfo.getXdpi();
            screenWidthDp = displayMetricsInfo.getScreenWidthDp();
            screenHeightDp = displayMetricsInfo.getScreenHeightDp();
            f3 = xdpi;
        }
        setDensity(activity, density, densityDpi, scaledDensity, f3);
        setScreenSizeDp(activity, screenWidthDp, screenHeightDp);
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[13];
        objArr[0] = activity.getClass().getName();
        objArr[1] = activity.getClass().getSimpleName();
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = z ? "designWidthInDp" : "designHeightInDp";
        objArr[4] = Float.valueOf(f2);
        objArr[5] = z ? "designWidthInSubunits" : "designHeightInSubunits";
        objArr[6] = Float.valueOf(designWidth);
        objArr[7] = Float.valueOf(density);
        objArr[8] = Float.valueOf(scaledDensity);
        objArr[9] = Integer.valueOf(densityDpi);
        objArr[10] = Float.valueOf(f3);
        objArr[11] = Integer.valueOf(screenWidthDp);
        objArr[12] = Integer.valueOf(screenHeightDp);
        AutoSizeLog.d(String.format(locale, "The %s has been adapted! \n%s Info: isBaseOnWidth = %s, %s = %f, %s = %f, targetDensity = %f, targetScaledDensity = %f, targetDensityDpi = %d, targetXdpi = %f, targetScreenWidthDp = %d, targetScreenHeightDp = %d", objArr));
    }

    public static void autoConvertDensityBaseOnHeight(Activity activity, float f2) {
        autoConvertDensity(activity, f2, false);
    }

    public static void autoConvertDensityBaseOnWidth(Activity activity, float f2) {
        autoConvertDensity(activity, f2, true);
    }

    public static void autoConvertDensityOfCustomAdapt(Activity activity, CustomAdapt customAdapt) {
        Preconditions.checkNotNull(customAdapt, "customAdapt == null");
        float sizeInDp = customAdapt.getSizeInDp();
        if (sizeInDp <= 0.0f) {
            sizeInDp = customAdapt.isBaseOnWidth() ? AutoSizeConfig.getInstance().getDesignWidthInDp() : AutoSizeConfig.getInstance().getDesignHeightInDp();
        }
        autoConvertDensity(activity, sizeInDp, customAdapt.isBaseOnWidth());
    }

    public static void autoConvertDensityOfExternalAdaptInfo(Activity activity, ExternalAdaptInfo externalAdaptInfo) {
        Preconditions.checkNotNull(externalAdaptInfo, "externalAdaptInfo == null");
        float sizeInDp = externalAdaptInfo.getSizeInDp();
        if (sizeInDp <= 0.0f) {
            sizeInDp = externalAdaptInfo.isBaseOnWidth() ? AutoSizeConfig.getInstance().getDesignWidthInDp() : AutoSizeConfig.getInstance().getDesignHeightInDp();
        }
        autoConvertDensity(activity, sizeInDp, externalAdaptInfo.isBaseOnWidth());
    }

    public static void autoConvertDensityOfGlobal(Activity activity) {
        if (AutoSizeConfig.getInstance().isBaseOnWidth()) {
            autoConvertDensityBaseOnWidth(activity, AutoSizeConfig.getInstance().getDesignWidthInDp());
        } else {
            autoConvertDensityBaseOnHeight(activity, AutoSizeConfig.getInstance().getDesignHeightInDp());
        }
    }

    public static void cancelAdapt(Activity activity) {
        float f2;
        Preconditions.checkMainThread();
        float initXdpi = AutoSizeConfig.getInstance().getInitXdpi();
        int i2 = AnonymousClass1.$SwitchMap$me$jessyan$autosize$unit$Subunits[AutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits().ordinal()];
        if (i2 != 1) {
            f2 = i2 == 2 ? 25.4f : 72.0f;
            setDensity(activity, AutoSizeConfig.getInstance().getInitDensity(), AutoSizeConfig.getInstance().getInitDensityDpi(), AutoSizeConfig.getInstance().getInitScaledDensity(), initXdpi);
            setScreenSizeDp(activity, AutoSizeConfig.getInstance().getInitScreenWidthDp(), AutoSizeConfig.getInstance().getInitScreenHeightDp());
        }
        initXdpi /= f2;
        setDensity(activity, AutoSizeConfig.getInstance().getInitDensity(), AutoSizeConfig.getInstance().getInitDensityDpi(), AutoSizeConfig.getInstance().getInitScaledDensity(), initXdpi);
        setScreenSizeDp(activity, AutoSizeConfig.getInstance().getInitScreenWidthDp(), AutoSizeConfig.getInstance().getInitScreenHeightDp());
    }

    public static void checkAndInit(Application application) {
        if (checkInit()) {
            return;
        }
        AutoSizeConfig.getInstance().setLog(true).init(application).setUseDeviceSize(false);
    }

    public static boolean checkInit() {
        return AutoSizeConfig.getInstance().getInitDensity() != -1.0f;
    }

    private static DisplayMetrics getMetricsOnMiui(Resources resources) {
        if (AutoSizeConfig.getInstance().isMiui() && AutoSizeConfig.getInstance().getTmpMetricsField() != null) {
            try {
                return (DisplayMetrics) AutoSizeConfig.getInstance().getTmpMetricsField().get(resources);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void initCompatMultiProcess(Context context) {
        context.getContentResolver().query(Uri.parse("content://" + context.getPackageName() + ".autosize-init-provider"), null, null, null, null);
    }

    private static void setDensity(Activity activity, float f2, int i2, float f3, float f4) {
        setDensity(activity.getResources().getDisplayMetrics(), f2, i2, f3, f4);
        setDensity(AutoSizeConfig.getInstance().getApplication().getResources().getDisplayMetrics(), f2, i2, f3, f4);
        DisplayMetrics metricsOnMiui = getMetricsOnMiui(activity.getResources());
        DisplayMetrics metricsOnMiui2 = getMetricsOnMiui(AutoSizeConfig.getInstance().getApplication().getResources());
        if (metricsOnMiui != null) {
            setDensity(metricsOnMiui, f2, i2, f3, f4);
        }
        if (metricsOnMiui2 != null) {
            setDensity(metricsOnMiui2, f2, i2, f3, f4);
        }
    }

    private static void setScreenSizeDp(Activity activity, int i2, int i3) {
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportDP() && AutoSizeConfig.getInstance().getUnitsManager().isSupportScreenSizeDP()) {
            setScreenSizeDp(activity.getResources().getConfiguration(), i2, i3);
            setScreenSizeDp(AutoSizeConfig.getInstance().getApplication().getResources().getConfiguration(), i2, i3);
        }
    }

    private static void setScreenSizeDp(Configuration configuration, int i2, int i3) {
        configuration.screenWidthDp = i2;
        configuration.screenHeightDp = i3;
    }

    private static void setDensity(DisplayMetrics displayMetrics, float f2, int i2, float f3, float f4) {
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportDP()) {
            displayMetrics.density = f2;
            displayMetrics.densityDpi = i2;
        }
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportSP()) {
            displayMetrics.scaledDensity = f3;
        }
        int i3 = AnonymousClass1.$SwitchMap$me$jessyan$autosize$unit$Subunits[AutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits().ordinal()];
        if (i3 == 1) {
            displayMetrics.xdpi = f4 * 72.0f;
        } else if (i3 == 2) {
            displayMetrics.xdpi = f4 * 25.4f;
        } else {
            if (i3 != 4) {
                return;
            }
            displayMetrics.xdpi = f4;
        }
    }
}
