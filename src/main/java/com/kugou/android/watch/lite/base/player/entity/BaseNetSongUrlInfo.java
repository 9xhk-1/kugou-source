package com.kugou.android.watch.lite.base.player.entity;

import android.text.TextUtils;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.android.watch.lite.common.music.entity.SongQuality;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseNetSongUrlInfo implements INoGuard {
    public int bitRate;
    public String errorJson;
    public int errorType;
    public String extName;
    public String fileName;
    public int fileSize;
    public String hash;
    public int quality = SongQuality.QUALITY_NONE.getType();
    public String requestUrl;
    public String songSource;
    public List<String> spareUrls;
    public String url;

    public void forceUseLess() {
        setUrl(null);
        setSpareUrls(null);
    }

    public int getBitRate() {
        if (this.bitRate <= 0 && isUseful()) {
            if (this.url.endsWith(".m4a")) {
                this.bitRate = 36000;
            } else {
                this.bitRate = 192000;
            }
        }
        return this.bitRate;
    }

    public String getErrorJson() {
        return this.errorJson;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public String getExtName() {
        return this.extName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public String getHash() {
        return this.hash;
    }

    public int getQuality() {
        return this.quality;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public String getSongSource() {
        return this.songSource;
    }

    public List<String> getSpareUrls() {
        return this.spareUrls;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isError() {
        return this.errorType != 0;
    }

    public boolean isUseful() {
        return !TextUtils.isEmpty(this.url) && this.fileSize > 0;
    }

    public void setBitRate(int i2) {
        this.bitRate = i2;
    }

    public void setErrorJson(String str) {
        this.errorJson = str;
    }

    public void setErrorType(int i2) {
        this.errorType = i2;
    }

    public void setExtName(String str) {
        this.extName = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(int i2) {
        this.fileSize = i2;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setQuality(int i2) {
        this.quality = i2;
    }

    public void setRequestUrl(String str) {
        this.requestUrl = str;
    }

    public void setSongSource(String str) {
        this.songSource = str;
    }

    public void setSpareUrls(List<String> list) {
        this.spareUrls = list;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
