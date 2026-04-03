package org.apache.http;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface HeaderElement {
    String getName();

    NameValuePair getParameter(int i2);

    NameValuePair getParameterByName(String str);

    int getParameterCount();

    NameValuePair[] getParameters();

    String getValue();
}
