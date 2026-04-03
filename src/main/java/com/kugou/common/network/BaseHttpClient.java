package com.kugou.common.network;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class BaseHttpClient extends AbsHttpClient {
    private BaseHttpClient(boolean z, Context context) {
        super(z, context, new BaseHttpVars());
    }

    public static BaseHttpClient getInstance(Context context) {
        return new BaseHttpClient(context, new BaseHttpVars());
    }

    public BaseHttpClient(Context context, AbsHttpVars absHttpVars) {
        super(context, absHttpVars);
    }

    public static BaseHttpClient getInstance(Context context, AbsHttpVars absHttpVars) {
        return new BaseHttpClient(context, absHttpVars);
    }

    public static BaseHttpClient getInstance(boolean z, Context context) {
        return new BaseHttpClient(z, context);
    }
}
