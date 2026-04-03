package com.kugou.common.permission.runtime;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.kugou.common.permission.PreRequest;
import com.kugou.common.permission.Setting;
import com.kugou.common.permission.runtime.setting.RuntimeSetting;
import com.kugou.common.permission.source.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Runtime {
    private static final PermissionRequestFactory FACTORY;
    private static List<String> sManifestPermissions;
    private Source mSource;

    public interface PermissionRequestFactory {
        PermissionRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            FACTORY = new MRequestFactory();
        } else {
            FACTORY = new LRequestFactory();
        }
    }

    public Runtime(Source source) {
        this.mSource = source;
    }

    private void checkPermissions(String... strArr) {
        if (sManifestPermissions == null) {
            sManifestPermissions = getManifestPermissions(this.mSource.getContext());
        }
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("Please enter at least one permission.");
        }
        for (String str : strArr) {
            if (!sManifestPermissions.contains(str)) {
                throw new IllegalStateException(String.format("The permission %1$s is not registered in manifest.xml", str));
            }
        }
    }

    private static List<String> getManifestPermissions(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null || strArr.length == 0) {
                throw new IllegalStateException("You did not register any permissions in the manifest.xml.");
            }
            return Collections.unmodifiableList(Arrays.asList(strArr));
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError("Package name cannot be found.");
        }
    }

    public PreRequest.PermissionRequestProxy permission(String... strArr) {
        checkPermissions(strArr);
        return PreRequest.createPermissionRequestProxy(FACTORY.create(this.mSource).permission(strArr));
    }

    public Setting setting() {
        return new RuntimeSetting(this.mSource);
    }

    public PreRequest.PermissionRequestProxy permission(String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr2 : strArr) {
            arrayList.addAll(Arrays.asList(strArr2));
        }
        return permission((String[]) arrayList.toArray(new String[arrayList.size()]));
    }
}
