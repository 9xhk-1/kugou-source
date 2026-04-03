package com.kugou.common.filemanager.downloadengine.stat;

/* JADX INFO: loaded from: classes2.dex */
public interface IStatInterface {
    void OnNatProxyClientStatEvent(NatProxyClientStat natProxyClientStat);

    void OnNatProxyServeStatEvent(NatProxyServeStat natProxyServeStat);

    void OnOnlineStatEvent(OnlineStat onlineStat);

    void OnRefreshStatEvent(RefreshStat refreshStat);

    void OnUploaderStatEvent(UploaderStat uploaderStat);

    void exit();

    void onPeerIDInvalidWhenLogin(long j);

    void onPeerIDInvalidWhenStart(long j);
}
