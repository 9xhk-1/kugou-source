package com.kugou.common.filemanager.downloadengine.stat;

/* JADX INFO: loaded from: classes2.dex */
public interface IP2PStatEvent {
    void OnNatProxyClientStatEvent(NatProxyClientStat natProxyClientStat);

    void OnNatProxyServeStatEvent(NatProxyServeStat natProxyServeStat);

    void OnOnlineStatEvent(OnlineStat onlineStat);

    void OnPeerID6Changed(long j);

    void OnPeerIDChanged(long j);

    void OnRefreshStatEvent(RefreshStat refreshStat);

    void OnSaveLastFlowInfo(String str);

    void OnUploaderStatEvent(UploaderStat uploaderStat);
}
