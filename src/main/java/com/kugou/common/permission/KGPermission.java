package com.kugou.common.permission;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.RestrictTo;
import android.support.v4.app.Fragment;
import com.kugou.common.BuildConfig;
import com.kugou.common.permission.checker.PermissionChecker;
import com.kugou.common.permission.checker.StandardChecker;
import com.kugou.common.permission.overlay.setting.CheckFloatWindowPermissionUtils;
import com.kugou.common.permission.particular.setting.CheckWriteSettingPermissionUtils;
import com.kugou.common.permission.rationale.BaseKGRationale;
import com.kugou.common.permission.source.ContextSource;
import com.kugou.common.permission.source.FragmentSource;
import com.kugou.common.permission.source.Source;
import com.kugou.common.permission.source.SupportFragmentSource;
import com.kugou.common.permission.util.FileUtil;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class KGPermission {
    private static final PermissionChecker PERMISSION_CHECKER = new StandardChecker();
    private static final Map<String, List<String>> TOKEN_MAP = new HashMap();
    public static boolean canUseHasPermissionChecker = false;
    public static boolean enableChecker = true;

    public static class AndPermission {
        private AndPermission() {
        }

        public static Options with(Fragment fragment) {
            return new Options(new SupportFragmentSource(fragment));
        }

        public static Options with(android.app.Fragment fragment) {
            return new Options(new FragmentSource(fragment));
        }

        public static Options with(Context context) {
            return new Options(new ContextSource(context));
        }
    }

    public static boolean checkPermissionByToken(String str, String str2) {
        List<String> list = TOKEN_MAP.get(str);
        return list != null && list.contains(str2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String genTokenForPermission(Rationale<?> rationale, String[] strArr) {
        return genTokenForPermission(rationale, (List<String>) Arrays.asList(strArr));
    }

    public static Uri getFileUri(Fragment fragment, File file) {
        return getFileUri(fragment.getContext(), file);
    }

    public static boolean hasAlwaysDeniedPermission(Fragment fragment, List<String> list) {
        return hasAlwaysDeniedPermission(new SupportFragmentSource(fragment), list);
    }

    @Deprecated
    public static boolean hasFloatWindowPermission(Context context) {
        return CheckFloatWindowPermissionUtils.checkHasPermission(context);
    }

    @Deprecated
    public static boolean hasPermissions(Fragment fragment, String... strArr) {
        return hasPermissions(fragment.getContext(), strArr);
    }

    @Deprecated
    public static boolean hasWriteSettingPermission(Context context) {
        return CheckWriteSettingPermissionUtils.checkHasPermission(context);
    }

    @Deprecated
    public static Setting permissionSetting(Fragment fragment) {
        return AndPermission.with(fragment).runtime().setting();
    }

    public static boolean uCantAskMePermissionState(Context context, String... strArr) {
        return PERMISSION_CHECKER.hasPermission(context, strArr);
    }

    public static Options with(Context context) {
        return AndPermission.with(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String genTokenForPermission(Rationale<?> rationale, List<String> list) {
        String strValueOf;
        if (rationale == null) {
            return "";
        }
        if (rationale instanceof BaseKGRationale) {
            strValueOf = ((BaseKGRationale) rationale).rationaleKey(list);
        } else {
            if (BuildConfig.DEBUG) {
                throw new IllegalArgumentException("the Rationale must be implements BaseKGRationale!");
            }
            strValueOf = String.valueOf(rationale.getClass().getName().hashCode());
        }
        TOKEN_MAP.put(strValueOf, list);
        return strValueOf;
    }

    public static Uri getFileUri(android.app.Fragment fragment, File file) {
        return getFileUri(fragment.getActivity(), file);
    }

    public static boolean hasAlwaysDeniedPermission(android.app.Fragment fragment, List<String> list) {
        return hasAlwaysDeniedPermission(new FragmentSource(fragment), list);
    }

    @Deprecated
    public static boolean hasPermissions(android.app.Fragment fragment, String... strArr) {
        return hasPermissions(fragment.getActivity(), strArr);
    }

    @Deprecated
    public static Setting permissionSetting(android.app.Fragment fragment) {
        return AndPermission.with(fragment).runtime().setting();
    }

    public static Options with(Fragment fragment) {
        return AndPermission.with(fragment);
    }

    public static Uri getFileUri(Context context, File file) {
        return FileUtil.getFileUri(context, file);
    }

    public static boolean hasAlwaysDeniedPermission(Context context, List<String> list) {
        return hasAlwaysDeniedPermission(new ContextSource(context), list);
    }

    @Deprecated
    public static boolean hasPermissions(Context context, String... strArr) {
        return canUseHasPermissionChecker && PERMISSION_CHECKER.hasPermission(context, strArr);
    }

    @Deprecated
    public static Setting permissionSetting(Context context) {
        return AndPermission.with(context).runtime().setting();
    }

    private static boolean hasAlwaysDeniedPermission(Source source, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!source.isShowRationalePermission(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean hasPermissions(Fragment fragment, String[]... strArr) {
        return hasPermissions(fragment.getContext(), strArr);
    }

    @Deprecated
    public static boolean hasPermissions(android.app.Fragment fragment, String[]... strArr) {
        return hasPermissions(fragment.getActivity(), strArr);
    }

    public static boolean hasAlwaysDeniedPermission(Fragment fragment, String... strArr) {
        return hasAlwaysDeniedPermission(new SupportFragmentSource(fragment), strArr);
    }

    @Deprecated
    public static boolean hasPermissions(Context context, String[]... strArr) {
        if (!canUseHasPermissionChecker) {
            return false;
        }
        for (String[] strArr2 : strArr) {
            if (!PERMISSION_CHECKER.hasPermission(context, strArr2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasAlwaysDeniedPermission(android.app.Fragment fragment, String... strArr) {
        return hasAlwaysDeniedPermission(new FragmentSource(fragment), strArr);
    }

    public static boolean hasAlwaysDeniedPermission(Context context, String... strArr) {
        return hasAlwaysDeniedPermission(new ContextSource(context), strArr);
    }

    private static boolean hasAlwaysDeniedPermission(Source source, String... strArr) {
        for (String str : strArr) {
            if (!source.isShowRationalePermission(str)) {
                return true;
            }
        }
        return false;
    }
}
