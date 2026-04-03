package com.kugou.common.permission.checker;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class StorageReadTest implements PermissionTest {
    @Override // com.kugou.common.permission.checker.PermissionTest
    public boolean test() throws Throwable {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists() && externalStorageDirectory.canRead()) {
            return externalStorageDirectory.lastModified() > 0 && externalStorageDirectory.list() != null;
        }
        return false;
    }
}
