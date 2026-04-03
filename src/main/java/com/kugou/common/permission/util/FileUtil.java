package com.kugou.common.permission.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.kugou.common.permission.FileProvider;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtil {
    public static Uri getFileUri(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".file.path.share", file);
    }
}
