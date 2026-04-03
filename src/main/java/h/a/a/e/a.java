package h.a.a.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    SparseArray<String> getFileDescriptorsIdsToKeys();

    boolean loadNativeLibrary(Context context);

    void onBeforeMain();

    void onConnectionSetup(Bundle bundle, List<IBinder> list);

    void onDestroy();

    void onServiceBound(Intent intent);

    void onServiceCreated();

    void preloadNativeLibrary(Context context);

    void runMain();
}
