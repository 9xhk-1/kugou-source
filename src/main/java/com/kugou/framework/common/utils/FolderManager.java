package com.kugou.framework.common.utils;

import android.content.Context;
import android.text.TextUtils;
import e.c.a.g.a.f.g.a;
import e.c.a.g.a.s.p;

/* JADX INFO: loaded from: classes2.dex */
public class FolderManager {
    public static void checkFolderInCover(Context context, String str, int i2) throws Throwable {
        if (!p.j(str) && !TextUtils.isEmpty(str)) {
            try {
                a aVar = new a(str);
                if (aVar.exists() && !aVar.isDirectory()) {
                    p.g(aVar, 3);
                }
            } catch (Exception unused) {
            }
        }
        if (p.k(str)) {
            return;
        }
        initFolder(context, str, i2, 1);
    }

    private static void createVerFile(String str, byte[] bArr, int i2) throws Throwable {
        p.b(str, i2);
        p.n(str, bArr);
    }

    private static void initFolder(Context context, String str, int i2, int i3) throws Throwable {
        p.c(str, 0);
        createVerFile(str + ".ver", String.valueOf(context.getResources().getInteger(i2)).getBytes(), 1);
    }
}
