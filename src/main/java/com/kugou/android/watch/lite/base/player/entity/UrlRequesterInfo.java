package com.kugou.android.watch.lite.base.player.entity;

import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.common.filemanager.downloadengine.TrackerExtraParam;
import e.c.a.g.a.d.x.q.a;

/* JADX INFO: loaded from: classes.dex */
public class UrlRequesterInfo implements INoGuard {
    public long albumId;
    public TrackerExtraParam extraParam;
    public a feeOption;
    private String hash;
    public boolean isListenPart;
    public long mixId;
    public int quality;
    public int trackerType;
    public PageKey pageKey = null;
    public boolean silent = true;
    public boolean isUGC = false;
    public boolean doNotCheckIP = true;

    public String getHash() {
        String str = this.hash;
        return str == null ? "" : str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public String toString() {
        return "UrlRequesterInfo{quality=" + this.quality + ", hash='" + this.hash + "', mixId=" + this.mixId + ", albumId=" + this.albumId + ", isListenPart=" + this.isListenPart + ", feeOption=" + this.feeOption + ", extraParam=" + this.extraParam + ", pageKey=" + this.pageKey + ", trackerType=" + this.trackerType + ", silent=" + this.silent + ", isUGC=" + this.isUGC + ", doNotCheckIP=" + this.doNotCheckIP + '}';
    }
}
