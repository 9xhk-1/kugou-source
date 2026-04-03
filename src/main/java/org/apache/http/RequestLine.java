package org.apache.http;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
