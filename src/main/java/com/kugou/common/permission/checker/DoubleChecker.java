package com.kugou.common.permission.checker;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DoubleChecker implements PermissionChecker {
    private static final PermissionChecker STANDARD_CHECKER = new StandardChecker();
    private static final PermissionChecker STRICT_CHECKER = new StrictChecker();

    @Override // com.kugou.common.permission.checker.PermissionChecker
    public boolean hasPermission(Context context, String... strArr) {
        return STANDARD_CHECKER.hasPermission(context, strArr) && STRICT_CHECKER.hasPermission(context, strArr);
    }

    @Override // com.kugou.common.permission.checker.PermissionChecker
    public boolean hasPermission(Context context, List<String> list) {
        return STANDARD_CHECKER.hasPermission(context, list) && STRICT_CHECKER.hasPermission(context, list);
    }
}
