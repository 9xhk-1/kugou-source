package org.apache.http;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
