package org.chromium.base.library_loader;

import org.chromium.base.library_loader.Linker;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyLinker extends Linker {
    private static native boolean nativeCreateSharedRelro(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibraryInZipFile(String str, String str2, long j, Linker.LibInfo libInfo);

    private static native void nativeRunCallbackOnUiThread(long j);

    private static native boolean nativeUseSharedRelro(String str, Linker.LibInfo libInfo);
}
