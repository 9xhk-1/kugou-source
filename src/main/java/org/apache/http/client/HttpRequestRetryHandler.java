package org.apache.http.client;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface HttpRequestRetryHandler {
    boolean retryRequest(IOException iOException, int i2, HttpContext httpContext);
}
