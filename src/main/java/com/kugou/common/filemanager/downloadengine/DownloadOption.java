package com.kugou.common.filemanager.downloadengine;

import android.support.annotation.IntRange;
import com.kugou.common.filemanager.downloadengine.types.TargetCryptType;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadOption {
    private boolean canSuspendBuffer;

    @TargetCryptType
    private int decrypt;
    private long ensureCacheSize;
    private String extraHeaders;
    private boolean formatID3;
    private boolean isCaching;
    private boolean isDownload;
    private boolean isP2POnly;
    private boolean isP2PPriority;
    private boolean isPlaying;
    private boolean isSpeedUp;
    private long maxSpeed;
    private int p2pTurnCDNMilliseconds;
    private boolean passiveCDN;
    private boolean passiveMode;
    private int recvBufferKB;
    private boolean soonCDN;
    private int speedPriority;
    private String targetPath;
    private String taskua;
    private boolean topTcpSpeed;
    private boolean writeToMediaStore;

    @HashSourcePolicy
    private int hashSourcePolicy = 0;
    private int combineSourcePercent = 0;
    private boolean canShoot = false;
    private boolean preCache = false;
    private long headSize = 0;
    private int playHeadSeconds = 0;

    public DownloadOption(@DownloadSpeedPriority int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, long j, boolean z6, boolean z7) {
        this.passiveMode = false;
        this.passiveCDN = false;
        this.speedPriority = i2;
        this.isDownload = z;
        this.isPlaying = z2;
        this.isCaching = z3;
        this.isSpeedUp = z4;
        this.isP2PPriority = z5;
        this.maxSpeed = j;
        this.passiveMode = z6;
        this.passiveCDN = z7;
    }

    public boolean getCanShoot() {
        return this.canShoot;
    }

    public boolean getCanSuspendBuffer() {
        return this.canSuspendBuffer;
    }

    public int getCombineSourcePercent() {
        return this.combineSourcePercent;
    }

    @TargetCryptType
    public int getDecrypt() {
        return this.decrypt;
    }

    @DownloadSpeedPriority
    public int getDownloadSpeedPriority() {
        return this.speedPriority;
    }

    public long getEnsureCacheSize() {
        return this.ensureCacheSize;
    }

    public String getExtraHeaders() {
        return this.extraHeaders;
    }

    public boolean getFormatID3() {
        return this.formatID3;
    }

    @HashSourcePolicy
    public int getHashSourcePolicy() {
        return this.hashSourcePolicy;
    }

    public long getHeadSize() {
        return this.headSize;
    }

    public boolean getIsCaching() {
        return this.isCaching;
    }

    public boolean getIsDownload() {
        return this.isDownload;
    }

    public boolean getIsP2PPriority() {
        return this.isP2PPriority;
    }

    public boolean getIsPlaying() {
        return this.isPlaying;
    }

    public boolean getIsSpeedUp() {
        return this.isSpeedUp;
    }

    public long getMaxSpeed() {
        return this.maxSpeed;
    }

    public boolean getP2POnly() {
        return this.isP2POnly;
    }

    public int getP2PTurnCDNMilliseconds() {
        return this.p2pTurnCDNMilliseconds;
    }

    public boolean getPassiveCDN() {
        return this.passiveCDN;
    }

    public boolean getPassiveMode() {
        return this.passiveMode;
    }

    public int getPlayHeadSeconds() {
        return this.playHeadSeconds;
    }

    public boolean getPreCache() {
        return this.preCache;
    }

    public int getRecvBufferKB() {
        return this.recvBufferKB;
    }

    public boolean getSoonCDN() {
        return this.soonCDN;
    }

    public int getSpeedPriority() {
        return this.speedPriority;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public String getTaskua() {
        return this.taskua;
    }

    public boolean getTopTcpSpeed() {
        return this.topTcpSpeed;
    }

    public int getTurnCDN() {
        return this.p2pTurnCDNMilliseconds;
    }

    public boolean getWriteToMediaStore() {
        return this.writeToMediaStore;
    }

    public void setCanShoot(boolean z) {
        this.canShoot = z;
    }

    public void setCanSuspendBuffer(boolean z) {
        this.canSuspendBuffer = z;
    }

    public void setEnsureCacheSize(@IntRange(from = 0) long j) {
        this.ensureCacheSize = j;
    }

    public void setExtraHeaders(String str) {
        this.extraHeaders = str;
    }

    public void setFormatID3(boolean z) {
        this.formatID3 = z;
    }

    public void setHeadSize(long j) {
        this.headSize = j;
    }

    public void setIsCaching(boolean z) {
        this.isCaching = z;
    }

    public void setIsDownload(boolean z) {
        this.isDownload = z;
    }

    public void setMaxSpeed(long j) {
        this.maxSpeed = j;
    }

    public void setP2POnly(boolean z) {
        this.isP2POnly = z;
    }

    public void setP2PPriority(boolean z) {
        this.isP2PPriority = z;
    }

    public void setP2PTurnCDNMilliseconds(int i2) {
        this.p2pTurnCDNMilliseconds = i2;
    }

    public void setPassiveCDN(boolean z) {
        this.passiveCDN = z;
    }

    public void setPassiveMode(boolean z) {
        this.passiveMode = z;
    }

    public void setPlayHeadSeconds(@IntRange(from = 0, to = 99) int i2) {
        this.playHeadSeconds = i2;
    }

    public void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public void setPreCache(boolean z) {
        this.preCache = z;
    }

    public void setRecvBufferKB(@IntRange(from = 0, to = 1024) int i2) {
        this.recvBufferKB = i2;
    }

    public void setSoonCDN(boolean z) {
        this.soonCDN = z;
    }

    public void setSpeedPriority(@DownloadSpeedPriority int i2) {
        this.speedPriority = i2;
    }

    public void setSpeedUp(boolean z) {
        this.isSpeedUp = z;
    }

    public void setTargetPath(String str, @TargetCryptType int i2, boolean z) {
        this.targetPath = str;
        this.decrypt = i2;
        this.writeToMediaStore = z;
    }

    public void setTaskua(String str) {
        this.taskua = str;
    }

    public void setTheHashSourcePolicy(@HashSourcePolicy int i2, int i3) {
        this.hashSourcePolicy = i2;
        this.combineSourcePercent = i3;
    }

    public void setTopTcpSpeed(boolean z) {
        this.topTcpSpeed = z;
    }
}
