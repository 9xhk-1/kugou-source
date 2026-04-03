package com.kugou.common.network.protocol;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes2.dex */
public interface RequestPackage {
    String getGetRequestParams();

    Header[] getHttpHeaders();

    HttpEntity getPostRequestEntity();

    String getRequestModuleName();

    String getRequestType();

    String getUrl();
}
