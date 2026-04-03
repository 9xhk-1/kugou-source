package com.kugou.framework.libcommon;

import com.kugou.framework.libcommon.netcore.HttpEntity;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface RequestPackage {
    String getGetRequestParams();

    Map<String, String> getHttpHeaders();

    HttpEntity getPostRequestEntity();

    Map<String, Object> getRequestMapParams();

    String getRequestModuleName();

    String getRequestType();

    String getUrl();
}
