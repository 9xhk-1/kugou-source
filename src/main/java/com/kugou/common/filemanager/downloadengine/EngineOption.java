package com.kugou.common.filemanager.downloadengine;

import com.kugou.common.filemanager.downloadengine.Engine;

/* JADX INFO: loaded from: classes2.dex */
public class EngineOption {
    public int AppID;
    public String CacheID;
    public int ChannelID;
    public String ChecknatIPv6;
    public int ClientVersion;
    public boolean EnableHttpsSupport;
    public int EnginePort;
    public boolean IsVip;
    public String LastFlowInfo;
    public String MVCacheDirectory;
    public String MachineToken;
    public int MaxDownloadSourceCount;
    public int MaxPCPeerID;
    public int MinPCPeerID;
    public Engine.INetFlowCallback NetFlowCallback;
    public int P2PMode;
    public P2PParam P2pParam;
    public long PeerID;
    public long PeerID6;
    public ISeedCallback SeedCallback;
    public String ServerList;
    public String UUID;
    public Engine.IUnicomProxy UnicomProxy;
    public String UserAgent;
    public long UserID;
    public String UserToken;
    public int VipType;
    public Engine.IWriteMediaStoreCallback WriteMediaStoreCallback;
}
