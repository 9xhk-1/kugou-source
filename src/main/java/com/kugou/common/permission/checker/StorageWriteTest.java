package com.kugou.common.permission.checker;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class StorageWriteTest implements PermissionTest {
    @Override // com.kugou.common.permission.checker.PermissionTest
    public boolean test() throws Throwable {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (!externalStorageDirectory.exists() || !externalStorageDirectory.canWrite()) {
            return false;
        }
        File file = new File(externalStorageDirectory, "Android");
        if (file.exists() && file.isFile() && !file.delete()) {
            return false;
        }
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(file, "ANDROID.PERMISSION.TEST");
        return file2.exists() ? file2.delete() : file2.createNewFile();
    }
}
