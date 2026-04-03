package com.kugou.common.apm;

import e.c.a.g.a.d.b.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseHandlerForApm {
    public static final String E1 = "E1";
    public static final String E2 = "E2";
    public static final String E3 = "E3";
    public static final String E4 = "E4";
    public static final String E5 = "E5";
    public static final String E6 = "E6";

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TE {
    }

    public a getNetApmDataWhenSuccess(int i2, byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4 = "";
        if (i2 != 200 && i2 != 206) {
            str = i2 + "";
            str2 = E3;
        } else {
            if (bArr != null && bArr.length > 0) {
                str3 = "";
                a aVar = new a();
                aVar.k(str4);
                aVar.g(str3);
                return aVar;
            }
            str = i2 + "";
            str2 = E2;
        }
        String str5 = str;
        str4 = str2;
        str3 = str5;
        a aVar2 = new a();
        aVar2.k(str4);
        aVar2.g(str3);
        return aVar2;
    }

    public void handerParseResponse(int i2) {
    }

    public static a getNetApmDataWhenSuccess(int i2, String str) {
        String str2 = E1;
        switch (i2) {
            case 1000302:
            case 1000303:
            case 1000304:
            case 1000307:
            case 1000401:
            case 1000403:
            case 1000404:
            case 1000407:
            case 1000500:
            case 1000502:
            case 1000503:
                str2 = E3;
                break;
        }
        a aVar = new a();
        aVar.k(str2);
        aVar.g((((long) i2) - 1000000) + "");
        return aVar;
    }
}
