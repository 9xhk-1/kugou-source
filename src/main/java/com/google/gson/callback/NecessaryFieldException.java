package com.google.gson.callback;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class NecessaryFieldException extends IOException {
    private static final long serialVersionUID = 4458522158221754165L;

    public NecessaryFieldException(String str) {
        super(str);
    }

    public NecessaryFieldException(String str, Throwable th) {
        super(str, th);
    }
}
