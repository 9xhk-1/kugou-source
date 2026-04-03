package com.kugou.common.permission.checker;

import android.content.Context;
import android.location.LocationManager;
import android.net.http.Headers;

/* JADX INFO: loaded from: classes2.dex */
public class LocationCoarseTest implements PermissionTest {
    private Context mContext;

    public LocationCoarseTest(Context context) {
        this.mContext = context;
    }

    @Override // com.kugou.common.permission.checker.PermissionTest
    public boolean test() throws Throwable {
        if (!((LocationManager) this.mContext.getSystemService(Headers.LOCATION)).getProviders(true).contains("network") && this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.network")) {
            return !r0.isProviderEnabled("network");
        }
        return true;
    }
}
