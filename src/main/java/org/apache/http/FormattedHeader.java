package org.apache.http;

import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
