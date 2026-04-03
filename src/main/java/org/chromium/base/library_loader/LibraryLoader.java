package org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes2.dex */
public class LibraryLoader {
    private static native boolean nativeForkAndPrefetchNativeLibrary();

    private native String nativeGetVersionNumber();

    private native boolean nativeLibraryLoaded();

    private static native int nativePercentageOfResidentNativeLibraryCode();

    private static native void nativePeriodicallyCollectResidency();

    private native void nativeRecordChromiumAndroidLinkerBrowserHistogram(boolean z, boolean z2, int i2, long j);

    private native void nativeRecordLibraryPreloaderBrowserHistogram(int i2);

    private native void nativeRegisterChromiumAndroidLinkerRendererHistogram(boolean z, boolean z2, long j);

    private native void nativeRegisterLibraryPreloaderRendererHistogram(int i2);
}
