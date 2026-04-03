package com.kugou.common.permission.checker;

import android.content.Context;
import android.location.LocationManager;
import android.net.http.Headers;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LocationFineTest implements PermissionTest {
    private Context mContext;

    public LocationFineTest(Context context) {
        this.mContext = context;
    }

    @Override // com.kugou.common.permission.checker.PermissionTest
    public boolean test() throws Throwable {
        List<String> providers = ((LocationManager) this.mContext.getSystemService(Headers.LOCATION)).getProviders(true);
        boolean zContains = providers.contains("gps");
        boolean zContains2 = providers.contains("passive");
        if (zContains || zContains2 || !this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            return true;
        }
        return !r0.isProviderEnabled("gps");
    }
}
