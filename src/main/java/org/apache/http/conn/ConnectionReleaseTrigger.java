package org.apache.http.conn;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface ConnectionReleaseTrigger {
    void abortConnection() throws IOException;

    void releaseConnection() throws IOException;
}
