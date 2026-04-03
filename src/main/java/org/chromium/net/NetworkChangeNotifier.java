package org.chromium.net;

import h.a.a.c;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkChangeNotifier {
    public NetworkChangeNotifier() {
        new ArrayList();
        new c();
    }

    private native void nativeNotifyConnectionTypeChanged(long j, int i2, long j2);

    private native void nativeNotifyMaxBandwidthChanged(long j, int i2);

    private native void nativeNotifyOfNetworkConnect(long j, long j2, int i2);

    private native void nativeNotifyOfNetworkDisconnect(long j, long j2);

    private native void nativeNotifyOfNetworkSoonToDisconnect(long j, long j2);

    private native void nativeNotifyPurgeActiveNetworkList(long j, long[] jArr);
}
