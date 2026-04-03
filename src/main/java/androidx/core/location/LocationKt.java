package androidx.core.location;

import android.location.Location;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class LocationKt {
    public static final double component1(Location location) {
        j.f(location, "$this$component1");
        return location.getLatitude();
    }

    public static final double component2(Location location) {
        j.f(location, "$this$component2");
        return location.getLongitude();
    }
}
