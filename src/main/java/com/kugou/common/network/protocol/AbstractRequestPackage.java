package com.kugou.common.network.protocol;

import com.kugou.common.network.AbsHttpClient;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractRequestPackage implements RequestPackage, AbsHttpClient.IStaticsRequest {
    public Hashtable<String, Object> mParams;

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getGetRequestParams() {
        Hashtable<String, Object> hashtable = this.mParams;
        if (hashtable == null || hashtable.size() < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        Set<String> setKeySet = this.mParams.keySet();
        if (needOrderedParams()) {
            setKeySet = new TreeSet(setKeySet);
        }
        for (String str : setKeySet) {
            sb.append(str);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(this.mParams.get(str));
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public Header[] getHttpHeaders() {
        return new Header[0];
    }

    public Hashtable<String, Object> getParams() {
        return this.mParams;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IStaticsRequest
    public boolean isNetTrafficTask() {
        return false;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IStaticsRequest
    public boolean isStaticsReqeustPackage() {
        return false;
    }

    public boolean needOrderedParams() {
        return false;
    }

    public void setParams(Hashtable<String, Object> hashtable) {
        this.mParams = hashtable;
    }
}
