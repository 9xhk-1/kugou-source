package com.kugou.common.network.protocol;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMultiUrlRequestPackage extends AbstractRequestPackage {
    private String lastVisitUrl = null;

    public abstract String[] getAllUrls();

    public abstract String getConfigKeyString();

    public abstract int getConfigTryCount();

    public String getLastVisitUrl() {
        return this.lastVisitUrl;
    }

    public void setLastVisitUrl(String str) {
        this.lastVisitUrl = str;
    }

    public abstract void triggerConfigFail(String str, String str2);
}
