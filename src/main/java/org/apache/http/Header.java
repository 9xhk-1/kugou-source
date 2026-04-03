package org.apache.http;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
