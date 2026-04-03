package com.kugou.common.network.retry;

import android.os.Parcel;
import android.os.Parcelable;
import com.kugou.common.network.RFCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RetryConfigInfo implements Parcelable {
    public static final int INDEX_ACKDNS = 0;
    public static final int INDEX_DNS = 1;
    public static final int INDEX_NETGATE = 2;
    public static final int RECORD_SIZE = 3;
    public static final int STATE_FAIL = -1;
    public static final int STATE_NONE = -2;
    public static final int STATE_OK = 1;
    public static final int STATE_UNKNOW = 0;
    public List<RetryRecord> mRetryRecords;
    public RetryRecord originHostRecord;
    public int version;
    public static final int[] RECORD_STATES = {1, 0, -1, -2};
    public static final Parcelable.Creator<RetryConfigInfo> CREATOR = new Parcelable.Creator<RetryConfigInfo>() { // from class: com.kugou.common.network.retry.RetryConfigInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RetryConfigInfo createFromParcel(Parcel parcel) {
            return new RetryConfigInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RetryConfigInfo[] newArray(int i2) {
            return new RetryConfigInfo[i2];
        }
    };

    public RetryConfigInfo() {
        this.mRetryRecords = new ArrayList();
        this.originHostRecord = null;
        this.version = RFCode.RETRY_CONFIG_INFO_DEFAULT;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RetryConfigInfo{mRetryRecords=" + this.mRetryRecords + ", originHostRecord=" + this.originHostRecord + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.mRetryRecords);
        parcel.writeParcelable(this.originHostRecord, i2);
        parcel.writeInt(this.version);
    }

    public static class RetryRecord implements Parcelable {
        public static final Parcelable.Creator<RetryRecord> CREATOR = new Parcelable.Creator<RetryRecord>() { // from class: com.kugou.common.network.retry.RetryConfigInfo.RetryRecord.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RetryRecord createFromParcel(Parcel parcel) {
                return new RetryRecord(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RetryRecord[] newArray(int i2) {
                return new RetryRecord[i2];
            }
        };
        public String domain;
        public int protocolType;
        public int[] records;

        public RetryRecord(String str) {
            this.protocolType = 3;
            this.domain = str;
            this.records = new int[]{0, 0, 0};
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void setProtocolType(int i2) {
            this.protocolType = i2;
        }

        public String toString() {
            return "RetryRecord{domain='" + this.domain + "', protocolType=" + this.protocolType + ", records=" + Arrays.toString(this.records) + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.domain);
            parcel.writeInt(this.protocolType);
            parcel.writeIntArray(this.records);
        }

        public RetryRecord(Parcel parcel) {
            this.protocolType = 3;
            this.domain = parcel.readString();
            this.protocolType = parcel.readInt();
            this.records = parcel.createIntArray();
        }
    }

    public RetryConfigInfo(Parcel parcel) {
        this.mRetryRecords = new ArrayList();
        this.originHostRecord = null;
        this.version = RFCode.RETRY_CONFIG_INFO_DEFAULT;
        this.mRetryRecords = parcel.createTypedArrayList(RetryRecord.CREATOR);
        this.originHostRecord = (RetryRecord) parcel.readParcelable(RetryRecord.class.getClassLoader());
        this.version = parcel.readInt();
    }
}
