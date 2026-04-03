package com.kugou.android.watch.lite.user.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.kugou.android.watch.lite.common.INoGuard;

/* JADX INFO: loaded from: classes2.dex */
public class LoginExtraEntity implements Parcelable, INoGuard {
    public static final Parcelable.Creator<LoginExtraEntity> CREATOR = new a();
    private String accessID;
    private String accessKey;
    private String accessToken;
    private int commOperator;
    private boolean quickLogin = false;
    private String selectedUserID;
    private TeleSecurityParam teleSecurityParam;
    private String verifyUserID;

    public static class TeleSecurityParam implements Parcelable {
        public static final Parcelable.Creator<TeleSecurityParam> CREATOR = new a();
        public String a;
        public String b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f230d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f231f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f232h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f233i;

        public class a implements Parcelable.Creator<TeleSecurityParam> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TeleSecurityParam createFromParcel(Parcel parcel) {
                TeleSecurityParam teleSecurityParam = new TeleSecurityParam();
                teleSecurityParam.a = parcel.readString();
                teleSecurityParam.b = parcel.readString();
                teleSecurityParam.f230d = parcel.readString();
                teleSecurityParam.f231f = parcel.readString();
                teleSecurityParam.f232h = parcel.readString();
                teleSecurityParam.f233i = parcel.readString();
                return teleSecurityParam;
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public TeleSecurityParam[] newArray(int i2) {
                return new TeleSecurityParam[i2];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.f230d);
            parcel.writeString(this.f231f);
            parcel.writeString(this.f232h);
            parcel.writeString(this.f233i);
        }
    }

    public class a implements Parcelable.Creator<LoginExtraEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginExtraEntity createFromParcel(Parcel parcel) {
            LoginExtraEntity loginExtraEntity = new LoginExtraEntity();
            loginExtraEntity.selectedUserID = parcel.readString();
            loginExtraEntity.quickLogin = parcel.readInt() == 1;
            loginExtraEntity.accessToken = parcel.readString();
            loginExtraEntity.accessID = parcel.readString();
            loginExtraEntity.accessKey = parcel.readString();
            loginExtraEntity.commOperator = parcel.readInt();
            loginExtraEntity.teleSecurityParam = (TeleSecurityParam) parcel.readParcelable(TeleSecurityParam.class.getClassLoader());
            return loginExtraEntity;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LoginExtraEntity[] newArray(int i2) {
            return new LoginExtraEntity[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccessID() {
        return this.accessID;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public int getCommOperator() {
        return this.commOperator;
    }

    public String getSelectedUserID() {
        return this.selectedUserID;
    }

    public TeleSecurityParam getTeleSecurityParam() {
        return this.teleSecurityParam;
    }

    public String getVerifyUserID() {
        return this.verifyUserID;
    }

    public boolean isQuickLogin() {
        return this.quickLogin;
    }

    public void setAccessID(String str) {
        this.accessID = str;
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setCommOperator(int i2) {
        this.commOperator = i2;
    }

    public void setQuickLogin(boolean z) {
        this.quickLogin = z;
    }

    public void setSelectedUserID(String str) {
        this.selectedUserID = str;
    }

    public void setTeleSecurityParam(TeleSecurityParam teleSecurityParam) {
        this.teleSecurityParam = teleSecurityParam;
    }

    public void setVerifyUserID(String str) {
        this.verifyUserID = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.selectedUserID);
        parcel.writeInt(this.quickLogin ? 1 : 0);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.accessID);
        parcel.writeString(this.accessKey);
        parcel.writeInt(this.commOperator);
        parcel.writeParcelable(this.teleSecurityParam, i2);
    }
}
