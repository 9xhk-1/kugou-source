package com.kugou.common.filemanager.downloadengine;

import android.support.annotation.IntRange;
import android.text.TextUtils;
import com.kugou.common.filemanager.downloadengine.TrackerExtraParam;
import com.kugou.common.filemanager.downloadengine.entity.CloudVersion;
import com.kugou.common.filemanager.downloadengine.entity.SeedResourceType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadFileInfo {
    private String ackDns;
    private String albumID;
    private String auth;
    private int behavior;
    private int bitrate;
    private String busiJson;
    private String clientTime;
    private int cloudVersion;
    private String discardFileDir;
    private boolean enableFileLog;
    private boolean encryption;
    private long entireFileSize;
    private String entireHash;
    private String extName;
    private int fileClassID;
    private String fileHash;
    private String filePath;
    private long fileSize;

    @HashSource
    private int hashSource;

    @HashType
    private int hashType;
    private String holderTag;
    private HugeFileInfo hugeFileInfo;
    private int iOSQuality;

    @Deprecated
    private boolean isFree;
    private boolean isHugeFile;
    private long javaTime;
    private String key;
    private boolean lastDone;
    private boolean memoryOnly;
    private String mggKey;
    private long mixSongID;
    private String module;
    private int moduleID;
    private boolean monthlyPay;
    private String openTime;
    private String p2pHash;
    private String p3;
    private String peerCacheKey;
    private String plainHash;
    private String qualityName;
    private long radioTimestamp;
    private String radioToken;
    private boolean streamSizeAccuracy;
    private String t1;
    private String t2;
    private String transformCachePath;
    private boolean transformID3;
    private String transformTempDir;
    private String[] urls;
    private String[] xcdnUrls;
    private long offsetByteStart = -1;
    private long offsetByteEnd = -1;

    @SeedResourceType
    private int seedResourceType = 0;

    public DownloadFileInfo(String str, String str2, String[] strArr, String[] strArr2, String str3, String str4, String str5, long j, boolean z, int i2, String str6, int i3, String str7, long j2, TrackerExtraParam trackerExtraParam, @Deprecated boolean z2, int i4, @HashSource int i5, @HashType int i6, boolean z3, String str8, String str9) {
        this.hashType = 0;
        this.key = str;
        this.filePath = str2;
        this.urls = strArr;
        this.xcdnUrls = strArr2;
        this.p2pHash = str3;
        this.fileHash = str4;
        this.extName = str5;
        this.fileSize = j;
        this.monthlyPay = z;
        this.isFree = z2;
        this.module = str6;
        this.behavior = i3;
        this.albumID = str7;
        this.mixSongID = j2;
        if (trackerExtraParam != null) {
            TrackerExtraParam.CommonAuth commonAuth = trackerExtraParam.commonAuth;
            if (commonAuth != null) {
                this.auth = commonAuth.auth;
                this.moduleID = commonAuth.moduleId;
                this.openTime = commonAuth.openTime;
            }
            TrackerExtraParam.MusicRadio musicRadio = trackerExtraParam.musicRadio;
            if (musicRadio != null) {
                this.radioTimestamp = musicRadio.radioTimestamp;
                this.radioToken = musicRadio.radioToken;
            }
            try {
                this.busiJson = trackerExtraParam.businessJson;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            NetLog.d("siganid-pagekey", "busiJson:" + this.busiJson);
        }
        this.iOSQuality = i2;
        this.bitrate = i4;
        this.hashSource = i5;
        this.hashType = i6;
        this.encryption = z3;
        this.ackDns = str8;
        this.peerCacheKey = str9;
    }

    public void addPartlyHashToBusiJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.busiJson)) {
            this.busiJson = "{\"clip_hash\":\"" + str + "\"}";
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.busiJson);
            jSONObject.put("clip_hash", str);
            this.busiJson = jSONObject.toString();
            if (NetLog.isDebug()) {
                NetLog.d("addPartlyHashToBusiJson " + this.busiJson);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public String getAckDns() {
        return this.ackDns;
    }

    public String getAlbumID() {
        return this.albumID;
    }

    public String getAuth() {
        return this.auth;
    }

    public int getBehavior() {
        return this.behavior;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public String getBusiJson() {
        return this.busiJson;
    }

    public String getClientTime() {
        return this.clientTime;
    }

    public int getCloudVersion() {
        return this.cloudVersion;
    }

    public String getDiscardFileDir() {
        return this.discardFileDir;
    }

    public boolean getEnableFileLog() {
        return this.enableFileLog;
    }

    public boolean getEncryption() {
        return this.encryption;
    }

    public long getEntireFileSize() {
        return this.entireFileSize;
    }

    public String getEntireHash() {
        return this.entireHash;
    }

    public String getExtName() {
        return this.extName;
    }

    public int getFileClassID() {
        return this.fileClassID;
    }

    public String getFileHash() {
        return this.fileHash;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getHashSource() {
        return this.hashSource;
    }

    public int getHashType() {
        return this.hashType;
    }

    @HashType
    public int getHashTypeEnum() {
        return this.hashType;
    }

    public String getHolderTag() {
        return this.holderTag;
    }

    public HugeFileInfo getHugeFileInfo() {
        return this.hugeFileInfo;
    }

    public Object getHugeInfo() {
        return this.hugeFileInfo;
    }

    public int getIOSQuality() {
        return this.iOSQuality;
    }

    @Deprecated
    public boolean getIsFree() {
        return false;
    }

    public boolean getIsHuge() {
        return this.isHugeFile;
    }

    public long getJavaTime() {
        return this.javaTime;
    }

    public String getKey() {
        return this.key;
    }

    public boolean getLastDone() {
        return this.lastDone;
    }

    public boolean getMemoryOnly() {
        return this.memoryOnly;
    }

    public String getMggKey() {
        return this.mggKey;
    }

    public String getMixSongID() {
        return String.valueOf(this.mixSongID);
    }

    public String getModule() {
        return this.module;
    }

    public int getModuleID() {
        return this.moduleID;
    }

    public boolean getMonthlyPay() {
        return this.monthlyPay;
    }

    public long getOffsetByteEnd() {
        return this.offsetByteEnd;
    }

    public long getOffsetByteStart() {
        return this.offsetByteStart;
    }

    public String getOpenTime() {
        return this.openTime;
    }

    public String getP2PHash() {
        return this.p2pHash;
    }

    public String getP3() {
        return this.p3;
    }

    public String getPeerCacheKey() {
        return this.peerCacheKey;
    }

    public String getPlainHash() {
        return this.plainHash;
    }

    public String getQualityName() {
        return this.qualityName;
    }

    public long getRadioTimestamp() {
        return this.radioTimestamp;
    }

    public String getRadioToken() {
        return this.radioToken;
    }

    public int getSeedResourceType() {
        return this.seedResourceType;
    }

    public boolean getStreamSizeAccuracy() {
        return this.streamSizeAccuracy;
    }

    public String getT1() {
        return this.t1;
    }

    public String getT2() {
        return this.t2;
    }

    public String getTransformCachePath() {
        return this.transformCachePath;
    }

    public boolean getTransformID3() {
        return this.transformID3;
    }

    public String getTransformTempDir() {
        return this.transformTempDir;
    }

    public String[] getUrls() {
        return this.urls;
    }

    public String[] getXcdnUrls() {
        return this.xcdnUrls;
    }

    public boolean hasUrl() {
        String[] strArr = this.urls;
        return (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(strArr[0])) ? false : true;
    }

    public boolean isHugeFile() {
        return this.isHugeFile;
    }

    public void setAckDns(String str) {
        this.ackDns = str;
    }

    public void setAlbumID(String str) {
        this.albumID = str;
    }

    public void setAuth(String str) {
        this.auth = str;
    }

    public void setBehavior(int i2) {
        this.behavior = i2;
    }

    public void setBitrate(int i2) {
        this.bitrate = i2;
    }

    public void setBusiJson(String str) {
        this.busiJson = str;
    }

    public void setCloudVersion(@CloudVersion int i2) {
        this.cloudVersion = i2;
    }

    public void setDiscardFileDir(String str) {
        this.discardFileDir = str;
    }

    public void setEnableFileLog(boolean z) {
        this.enableFileLog = z;
    }

    public void setEncryptToken(String str, String str2, String str3, String str4) {
        this.p3 = str;
        this.clientTime = str2;
        this.t1 = str3;
        this.t2 = str4;
    }

    public void setEncryption(boolean z) {
        this.encryption = z;
    }

    public void setExtName(String str) {
        this.extName = str;
    }

    public void setFileClassID(@IntRange(from = 0) int i2) {
        this.fileClassID = i2;
    }

    public void setFileHash(String str) {
        this.fileHash = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setHashSource(@HashSource int i2) {
        this.hashSource = i2;
    }

    public void setHashType(@HashType int i2) {
        this.hashType = i2;
    }

    public void setHolderTag(String str) {
        this.holderTag = str;
    }

    public void setHugeFileInfo(HugeFileInfo hugeFileInfo) {
        this.hugeFileInfo = hugeFileInfo;
    }

    public void setIOSQuality(int i2) {
        this.iOSQuality = i2;
    }

    @Deprecated
    public void setIsFree(boolean z) {
        this.isFree = z;
    }

    public void setIsHugeFile(boolean z) {
        this.isHugeFile = z;
    }

    public void setJavaTime(@IntRange(from = 0) long j) {
        this.javaTime = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLastDone(boolean z) {
        this.lastDone = z;
    }

    public void setMemoryOnly(boolean z) {
        this.memoryOnly = z;
    }

    public void setMggKey(String str) {
        this.mggKey = str;
    }

    public void setMixSongID(long j) {
        this.mixSongID = j;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setModuleID(int i2) {
        this.moduleID = i2;
    }

    public void setMonthlyPay(boolean z) {
        this.monthlyPay = z;
    }

    public void setOpenTime(String str) {
        this.openTime = str;
    }

    public void setP2PHash(String str) {
        this.p2pHash = str;
    }

    public void setPartlyP2PInfo(String str, @IntRange(from = 0) long j, @IntRange(from = 0) long j2, @IntRange(from = 0) long j3) {
        if (!TextUtils.isEmpty(str) && j2 >= 0 && j3 >= j2) {
            this.entireHash = str;
            this.entireFileSize = j;
            this.offsetByteStart = j2;
            this.offsetByteEnd = j3;
            return;
        }
        if (NetLog.isDebug()) {
            NetLog.e("invalid partly p2p info: " + str + ", " + j2 + ", " + j3 + ", " + j);
        }
    }

    public void setPeerCacheKey(String str) {
        this.peerCacheKey = str;
    }

    public void setPlainHash(String str) {
        this.plainHash = str;
    }

    public void setQualityName(String str) {
        this.qualityName = str;
    }

    public void setSeedResourceType(@SeedResourceType int i2) {
        this.seedResourceType = i2;
    }

    public void setStreamSizeAccuracy(boolean z) {
        this.streamSizeAccuracy = z;
    }

    public void setTransformCachePath(String str) {
        this.transformCachePath = str;
    }

    public void setTransformID3(boolean z) {
        this.transformID3 = z;
    }

    public void setTransformTempDir(String str) {
        this.transformTempDir = str;
    }

    public void setUrls(String[] strArr) {
        this.urls = strArr;
    }

    public void setViperTransformParams(String str, String str2, String str3, boolean z) {
        this.transformCachePath = str;
        this.transformTempDir = str2;
        this.discardFileDir = str3;
        this.transformID3 = z;
    }

    public void setXcdnUrls(String[] strArr) {
        this.xcdnUrls = strArr;
    }
}
