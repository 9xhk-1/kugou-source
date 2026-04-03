package com.kugou.common.permission.checker;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface PermissionChecker {
    boolean hasPermission(Context context, List<String> list);

    boolean hasPermission(Context context, String... strArr);
}
