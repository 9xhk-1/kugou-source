package com.tencent.tmachine.trace.cpu;

import f.z.d.j;
import java.io.IOException;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes2.dex */
public final class PseudoReadException extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PseudoReadException(String str, String str2, Exception exc) {
        super("read " + str + " failed, " + str2, exc);
        j.f(str, ClientCookie.PATH_ATTR);
        j.f(str2, "message");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PseudoReadException(String str, Exception exc) {
        super("read " + str + " failed", exc);
        j.f(str, ClientCookie.PATH_ATTR);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PseudoReadException(String str) {
        super("read " + str + " failed");
        j.f(str, ClientCookie.PATH_ATTR);
    }
}
