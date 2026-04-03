package org.apache.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface HttpConnection {
    void close() throws IOException;

    HttpConnectionMetrics getMetrics();

    int getSocketTimeout();

    boolean isOpen();

    boolean isStale();

    void setSocketTimeout(int i2);

    void shutdown() throws IOException;
}
