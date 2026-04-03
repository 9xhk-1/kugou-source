package com.kugou.android.watch.lite.base.player.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.HashOffset;
import com.kugou.android.watch.lite.common.INoGuard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommNetSongUrlInfo extends BaseNetSongUrlInfo implements Parcelable, INoGuard {
    public static final String BEHAVIOR_DOWNLOAD = "download";
    public static final String BEHAVIOR_PLAY = "play";
    public static final Parcelable.Creator<CommNetSongUrlInfo> CREATOR = new a();
    public static final String ERRSTR_BADCMD = "Bad cmd";
    public static final String ERRSTR_BADKEY = "Bad key";
    public static final String ERRSTR_BADPID = "Bad pid";
    public static final String ERRSTR_BAD_BEHAVIOR = "bad behavior";
    public static final String ERRSTR_CRASH = "crash";
    public static final String ERRSTR_ETYAPPID = "Empty appid";
    public static final String ERRSTR_ETYBEHA = "Empty behavior";
    public static final String ERRSTR_ETYHASH = "Empty hash";
    public static final String ERRSTR_ETYKEY = "Empty key";
    public static final String ERRSTR_ETYPID = "Empty pid";
    public static final String ERRSTR_ETYTOKEN = "Empty token";
    public static final String ERRSTR_ETYUSRID = "Empty userid";
    public static final String ERRSTR_ETYVER = "Empty version";
    public static final String ERRSTR_ETYVIP = "Empty vipType";
    public static final String ERRSTR_FAILED = "failed";
    public static final String ERRSTR_GRAY_LIST_MUSIC = "virtual_err_gray_list_music";
    public static final String ERRSTR_INERR = "Internal error";
    public static final String ERRSTR_M4ANOTFOUND = "M4a not found";
    public static final String ERRSTR_NOTFOUNTFILE = "File not found";
    public static final String ERRSTR_NOTFOUNTHASH = "Hash not found";
    public static final String FAIL_PROCESS_BUY = "buy";
    public static final String FAIL_PROCESS_VIP = "vip";
    public static final int NETSONG_FORBIDDEN = 12;
    public static final int NETSONG_GRAY_LIST_MUSIC = 32;
    public static final int NETSONG_INVALID_HUGE_FILE_INFO = 24;
    public static final int NETSONG_IP_LIMIT = 10;
    public static final int NETSONG_M4ANOTFOUND = 20;
    public static final int NETSONG_NEEDCHARGE = 11;
    public static final int NETSONG_NOT_FOUND = 5;
    public static final int NETSONG_NOT_FOUND_NET_ERROR = 6;
    public static final int NETSONG_NOT_FOUND_NET_INVALID = 7;
    public static final int NETSONG_NO_URLS = 8;
    public static final int NETSONG_OTHER_ERROR = 9;
    public static final int NETSONG_TRACKER_BAD_KEY = 22;
    public static final int NETSONG_TRACKER_PRIVILEGE_NETERROR = 21;
    public static final int NETSONG_TRACKER_SERVERINTERNALERROR = 23;
    public static final int NETSONG_UNKNOWNERRE = 13;
    public static final int NETSONG_USE_COUPON_CRASH = 25;
    public static final int NETSONG_USE_COUPON_FAILED = 26;
    public static final int NETSONG_USE_COUPON_HAS_USED = 31;
    public static final int NETSONG_USE_COUPON_IN_BAD_BEHAVIOR = 27;
    public static final int NETSONG_USE_COUPON_IS_EXPIRED = 30;
    public static final int NETSONG_USE_COUPON_NOT_EXIST = 29;
    public static final int NETSONG_USE_COUPON_OTHER_FAILURE = 28;
    public static final int TRACK_RISK_ERROR = 20028;
    private long duration;
    private String errorMessage;
    private List<String> failProcess;
    private int fileHead;
    private HashOffset hashOffset = null;
    private String netEID;
    private String originErrIdentify;
    private int statusCode;

    public class a implements Parcelable.Creator<CommNetSongUrlInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommNetSongUrlInfo createFromParcel(Parcel parcel) {
            CommNetSongUrlInfo commNetSongUrlInfo = new CommNetSongUrlInfo();
            commNetSongUrlInfo.hash = parcel.readString();
            commNetSongUrlInfo.extName = parcel.readString();
            commNetSongUrlInfo.url = parcel.readString();
            commNetSongUrlInfo.fileSize = parcel.readInt();
            commNetSongUrlInfo.bitRate = parcel.readInt();
            commNetSongUrlInfo.songSource = parcel.readString();
            commNetSongUrlInfo.fileName = parcel.readString();
            commNetSongUrlInfo.errorType = parcel.readInt();
            commNetSongUrlInfo.requestUrl = parcel.readString();
            commNetSongUrlInfo.errorJson = parcel.readString();
            commNetSongUrlInfo.duration = parcel.readLong();
            ArrayList arrayList = new ArrayList();
            commNetSongUrlInfo.spareUrls = arrayList;
            parcel.readStringList(arrayList);
            commNetSongUrlInfo.errorMessage = parcel.readString();
            commNetSongUrlInfo.netEID = parcel.readString();
            commNetSongUrlInfo.fileHead = parcel.readInt();
            commNetSongUrlInfo.statusCode = parcel.readInt();
            if (parcel.readInt() == 1) {
                commNetSongUrlInfo.hashOffset = (HashOffset) parcel.readParcelable(HashOffset.class.getClassLoader());
            }
            commNetSongUrlInfo.originErrIdentify = parcel.readString();
            commNetSongUrlInfo.failProcess = parcel.readArrayList(ArrayList.class.getClassLoader());
            return commNetSongUrlInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommNetSongUrlInfo[] newArray(int i2) {
            return new CommNetSongUrlInfo[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public List<String> getFailProcess() {
        return this.failProcess;
    }

    public int getFileHead() {
        return this.fileHead;
    }

    public HashOffset getHashOffset() {
        return this.hashOffset;
    }

    public String getNetEID() {
        return this.netEID;
    }

    public String getOriginErrIdentify() {
        return this.originErrIdentify;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setFailProcess(ArrayList<String> arrayList) {
        this.failProcess = arrayList;
    }

    public void setFileHead(int i2) {
        this.fileHead = i2;
    }

    public void setHashOffset(HashOffset hashOffset) {
        this.hashOffset = hashOffset;
    }

    public void setNetEID(String str) {
        this.netEID = str;
    }

    public void setOriginErrIdentify(String str) {
        this.originErrIdentify = str;
    }

    public void setStatusCode(int i2) {
        this.statusCode = i2;
    }

    public String toString() {
        return "CommNetSongUrlInfo{duration=" + this.duration + ", errorMessage='" + this.errorMessage + "', netEID='" + this.netEID + "', fileHead=" + this.fileHead + ", statusCode=" + this.statusCode + ", hashOffset=" + this.hashOffset + ", originErrIdentify='" + this.originErrIdentify + "', failProcess=" + this.failProcess + ", errorType=" + this.errorType + ", spareUrls=" + this.spareUrls + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.hash);
        parcel.writeString(this.extName);
        parcel.writeString(this.url);
        parcel.writeInt(this.fileSize);
        parcel.writeInt(this.bitRate);
        parcel.writeString(this.songSource);
        parcel.writeString(this.fileName);
        parcel.writeInt(this.errorType);
        parcel.writeString(this.requestUrl);
        parcel.writeString(this.errorJson);
        parcel.writeLong(this.duration);
        parcel.writeStringList(this.spareUrls);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.netEID);
        parcel.writeInt(this.fileHead);
        parcel.writeInt(this.statusCode);
        if (this.hashOffset != null) {
            parcel.writeInt(1);
            parcel.writeParcelable(this.hashOffset, i2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.originErrIdentify);
        parcel.writeList(this.failProcess);
    }
}
