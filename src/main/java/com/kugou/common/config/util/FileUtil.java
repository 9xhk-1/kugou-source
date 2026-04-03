package com.kugou.common.config.util;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtil {
    public static boolean deleteFile(File file) {
        if (file != null) {
            return file.delete();
        }
        return false;
    }
}
