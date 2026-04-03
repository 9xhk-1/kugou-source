package com.kugou.oaid;

import android.content.Context;
import com.heytap.openid.sdk.OpenIDSDK;

/* JADX INFO: loaded from: classes2.dex */
public class OppoOaid {
    public String getOaid(Context context) {
        return getOppoOaid(OpenIDSDK.getOAID(context));
    }

    public native String getOppoOaid(String str);

    public void init(Context context) {
        OpenIDSDK.init(context);
    }
}
