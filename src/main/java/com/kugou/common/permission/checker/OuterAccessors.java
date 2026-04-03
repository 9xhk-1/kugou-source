package com.kugou.common.permission.checker;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.kugou.common.utils.SecretAccess;

/* JADX INFO: loaded from: classes2.dex */
public class OuterAccessors {
    private static boolean ENABLE = checkEnable();

    public static class Provider {
        public final Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            return SecretAccess.query(contentResolver, uri, strArr, str, strArr2, str2);
        }
    }

    private static boolean checkEnable() {
        try {
            Log.e("kgPermission", "outer accessor enable: " + SecretAccess.class.getName());
            return true;
        } catch (Throwable unused) {
            Log.e("kgPermission", "outer accessor disable.");
            return false;
        }
    }

    public Provider pickProvider() {
        if (ENABLE) {
            return new Provider();
        }
        return null;
    }
}
