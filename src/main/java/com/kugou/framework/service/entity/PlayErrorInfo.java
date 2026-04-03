package com.kugou.framework.service.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class PlayErrorInfo implements Parcelable {
    public static final Parcelable.Creator<PlayErrorInfo> CREATOR = new Parcelable.Creator<PlayErrorInfo>() { // from class: com.kugou.framework.service.entity.PlayErrorInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayErrorInfo createFromParcel(Parcel parcel) {
            PlayErrorInfo playErrorInfo = new PlayErrorInfo();
            playErrorInfo.errorTips = parcel.readString();
            playErrorInfo.errorType = parcel.readInt();
            playErrorInfo.playerErrorTips = parcel.readString();
            return playErrorInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayErrorInfo[] newArray(int i2) {
            return new PlayErrorInfo[i2];
        }
    };
    public static int ERROR_TYPE_DOWNLOAD_TIMEOUT = 11;
    public static int ERROR_TYPE_DOWNLOAD_TIMEOUT_WHEN_BUFFERING = 10;
    public static int ERROR_TYPE_LOCAL_SONG_FILE_NO_EXIT = 7;
    public static int ERROR_TYPE_LOCAL_SONG_FILE_NO_EXIT_WHEN_SETDATASOURCE = 9;
    public static int ERROR_TYPE_LOCAL_SONG_OPEN_FAILED = 13;
    public static int ERROR_TYPE_NETSONG_NOT_FOUND = 12;
    public static int ERROR_TYPE_NET_SONG_FILE_NO_EXIT_WHEN_SETDATASOURCE = 8;
    public static int ERROR_TYPE_NET_SONG_OPEN_FAILED = 4;
    public static int ERROR_TYPE_NET_UNAVAILABLE = 1;
    public static int ERROR_TYPE_NOT_SUPPORT = 6;
    public static int ERROR_TYPE_NO_HASH = 5;
    public static int ERROR_TYPE_PLAY_ERROR_DEFAULT = 3;
    public static int ERROR_TYPE_PLAY_ERROR_UNKNOW = 2;
    public static int ERROR_TYPE_SEAFILE_FORBIDDEN = 14;
    public static int ERROR_TYPE_SEAFILE_NEEDCHARGE = 15;
    public static int ERROR_TYPE_SEAFILE_UNKNOWN = 16;
    private String errorTips;
    private int errorType;
    private boolean isShowGuide;
    private String playerErrorTips;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getErrorTips() {
        return this.errorTips;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public String getPlayerErrorTips() {
        return this.playerErrorTips;
    }

    public boolean isShowGuide() {
        return this.isShowGuide;
    }

    public void setErrorTips(String str) {
        this.errorTips = str;
    }

    public void setErrorType(int i2) {
        this.errorType = i2;
    }

    public void setPlayerErrorTipsV2(String str) {
        this.playerErrorTips = str;
    }

    public void setShowGuide(boolean z) {
        this.isShowGuide = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.errorTips);
        parcel.writeInt(this.errorType);
        parcel.writeString(this.playerErrorTips);
    }
}
