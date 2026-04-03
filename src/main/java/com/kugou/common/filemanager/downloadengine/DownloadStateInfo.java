package com.kugou.common.filemanager.downloadengine;

import android.support.annotation.IntRange;
import android.text.TextUtils;
import com.kugou.common.filemanager.downloadengine.entity.DownloadStatistics;
import com.kugou.common.filemanager.downloadengine.entity.FileDownloadState;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadStateInfo {
    private String KgRF;
    private int actionSource = 5;
    private int authErrorCode;
    private int buyVipError;
    private String criticalInfo;
    private String discardPath;
    private int error;
    private String errorDetail;
    private int errorNo;
    private String hugeKey;
    private String key;
    private boolean lastDone;
    private String p2pInfo;
    private String rangesInfo;
    private int sliceIndex;
    private int state;
    private DownloadStatistics statistics;
    private String targetPath;
    private String transformPath;
    private String trySwitchDirContent;
    private boolean writeToMediaStore;

    public Object createStatistics() {
        if (this.statistics == null) {
            this.statistics = new DownloadStatistics();
        }
        return this.statistics;
    }

    public int getActionSource() {
        return this.actionSource;
    }

    public int getAuthErrorCode() {
        return this.authErrorCode;
    }

    public int getBuyVipError() {
        return this.buyVipError;
    }

    public String getCriticalInfo() {
        return this.criticalInfo;
    }

    public String getDiscardPath() {
        return this.discardPath;
    }

    public int getError() {
        return this.error;
    }

    public String getErrorDetail() {
        return this.errorDetail;
    }

    public int getErrorNo() {
        return this.errorNo;
    }

    public FileDownloadState getFileDownloadState() {
        return FileDownloadState.stateOf(this.state);
    }

    public String getHugeKey() {
        return this.hugeKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getKgRF() {
        return this.KgRF;
    }

    public boolean getLastDone() {
        return this.lastDone;
    }

    public String getP2pInfo() {
        return this.p2pInfo;
    }

    public String getRangesInfo() {
        return this.rangesInfo;
    }

    public int getSliceIndex() {
        return this.sliceIndex;
    }

    public int getState() {
        return this.state;
    }

    public DownloadStatistics getStatistics() {
        DownloadStatistics downloadStatistics = this.statistics;
        if (downloadStatistics != null && this.authErrorCode > 0) {
            downloadStatistics.setAuthErrorInfo(this.authErrorCode + "," + this.buyVipError);
        }
        return this.statistics;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public String getTransformPath() {
        return this.transformPath;
    }

    public String getTrySwitchDirContent() {
        return this.trySwitchDirContent;
    }

    public boolean isFormatID3Success() {
        return getStatistics() != null && getStatistics().isFormatID3Success();
    }

    public boolean isWriteToMediaStore() {
        return this.writeToMediaStore;
    }

    public void retainStatistics(DownloadStatistics downloadStatistics) {
        this.statistics = downloadStatistics;
        downloadStatistics.setErrorNo(this.errorNo);
        this.statistics.setAuthErrorInfo(this.authErrorCode + "," + this.buyVipError);
    }

    public void setActionSource(int i2) {
        this.actionSource = i2;
    }

    public void setAuthErrorCode(@IntRange(from = 0) int i2) {
        this.authErrorCode = i2;
    }

    public void setBuyVipError(@IntRange(from = 0) int i2) {
        this.buyVipError = i2;
    }

    public void setCriticalInfo(String str) {
        this.criticalInfo = str;
    }

    public void setDiscardPath(String str) {
        this.discardPath = str;
    }

    public void setError(int i2) {
        this.error = i2;
    }

    public void setErrorDetail(String str) {
        this.errorDetail = str;
        setErrorNo(str);
    }

    public void setErrorNo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int iIndexOf = str.indexOf("errno=");
            if (iIndexOf < 0) {
                return;
            }
            int iIndexOf2 = str.indexOf(RetryStaticsLOG.MARK_END, iIndexOf);
            if (iIndexOf2 < 0) {
                iIndexOf2 = str.length();
            }
            this.errorNo = Integer.parseInt(str.substring(iIndexOf + 6, iIndexOf2));
        } catch (Exception e2) {
            NetLog.printException(e2);
        }
    }

    public void setHugeKey(String str) {
        this.hugeKey = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setKgRF(String str) {
        this.KgRF = str;
    }

    public void setLastDone(boolean z) {
        this.lastDone = z;
    }

    public void setP2pInfo(String str) {
        this.p2pInfo = str;
    }

    public void setRangesInfo(String str) {
        this.rangesInfo = str;
    }

    public void setSliceIndex(int i2) {
        this.sliceIndex = i2;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setTargetPath(String str) {
        this.targetPath = str;
    }

    public void setTransformPath(String str) {
        this.transformPath = str;
    }

    public void setTrySwitchDirContent(String str) {
        this.trySwitchDirContent = str;
    }

    public void setWriteToMediaStore(boolean z) {
        this.writeToMediaStore = z;
    }
}
