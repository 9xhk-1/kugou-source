package com.kugou.android.watch.lite.user.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.android.watch.lite.user.entity.BusiVip;
import com.kugou.common.useraccount.entity.SVIPExtInfo;
import e.c.a.g.a.s.g0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class UserData extends SVIPExtInfo implements Parcelable, INoGuard {
    public static final Parcelable.Creator<UserData> CREATOR = new a();
    public static final int HAS_BIND_PHONE = 1;
    public static final int HAS_BIND_PHONE_UNKNOW = -1;
    public static final int HAS_NOT_BIND_PHONE = 0;
    private ArrayList<AccountSimpleEntity> accounts;
    private String autochargetime;
    private int autochargetype;
    private int autostatus;
    private String birthday;
    private String birthdayMMDD;
    private String birthdayYYYYMMDD;

    @SerializedName("busi_vip")
    private BusiVip[] busiVip;
    private String city;
    private int city_id;
    private String company;
    private int constellation;
    private int contact_status;
    private int error_code;
    private int first_login;
    private int hasBindPhone;
    private String hobby;
    private int isAllowVisit;
    private boolean isVerifyRealName;

    @SerializedName("is_vip")
    private int isVip;
    private String jumpUrl;
    private String last_login_time;
    private String login_email;
    private String login_mobile;
    public int mLoginType;

    @SerializedName("m_is_old")
    private int m_is_old;
    private int marital_status;
    private String memo;
    private String message;

    @SerializedName("m_begin_time")
    private String musicBegin;

    @SerializedName("m_end_time")
    private String musicEnd;

    @SerializedName("m_type")
    private int musicType;

    @SerializedName("m_clearday")
    private String music_clearday;

    @SerializedName("m_reset_time")
    private String music_resetTime;
    private String nickname;
    private String occupation;
    private String offen_appear;
    public int partnerId;
    private String phone;
    private String pic;
    private String producttype;
    private String province;
    private int province_id;
    private String qq;
    private int question_id;
    private String reg_time;
    private String respStr;

    @SerializedName("roam_begin_time")
    private String roamBeginTime;

    @SerializedName("roam_end_time")
    private String roamEndTime;

    @SerializedName("roam_type")
    private int roamType;
    private String s_vip_end_time;
    private String school;
    private int score;
    private String security_email;
    private String servertime;
    private int sex;
    private String signature;
    private SimpleDateFormat simpleDateFormat;
    private int status;
    private String t1;
    private String tags;
    private String token;
    private String totpKey;
    private long totpTimeStamp;
    private String truename;

    @SerializedName("userid")
    private long userid;
    private String username;

    @SerializedName("vip_begin_time")
    private String vip_begin_time;

    @SerializedName("vip_clearday")
    private String vip_clearday;

    @SerializedName("vip_end_time")
    private String vip_end_time;

    @SerializedName("vip_type")
    private int vip_type;
    private String wechat;

    @SerializedName("y_type")
    private int yearType;

    public class a implements Parcelable.Creator<UserData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserData createFromParcel(Parcel parcel) {
            return new UserData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UserData[] newArray(int i2) {
            return new UserData[i2];
        }
    }

    public UserData(Parcel parcel) {
        this.t1 = "null";
        this.status = parcel.readInt();
        this.error_code = parcel.readInt();
        this.userid = parcel.readLong();
        this.username = parcel.readString();
        this.truename = parcel.readString();
        this.nickname = parcel.readString();
        this.sex = parcel.readInt();
        this.pic = parcel.readString();
        this.score = parcel.readInt();
        this.vip_type = parcel.readInt();
        this.vip_begin_time = parcel.readString();
        this.vip_end_time = parcel.readString();
        this.s_vip_end_time = parcel.readString();
        this.reg_time = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.memo = parcel.readString();
        this.signature = parcel.readString();
        this.tags = parcel.readString();
        this.last_login_time = parcel.readString();
        this.birthday = parcel.readString();
        this.vip_clearday = parcel.readString();
        this.music_clearday = parcel.readString();
        this.security_email = parcel.readString();
        this.login_email = parcel.readString();
        this.login_mobile = parcel.readString();
        this.token = parcel.readString();
        this.question_id = parcel.readInt();
        this.respStr = parcel.readString();
        this.message = parcel.readString();
        this.isAllowVisit = parcel.readInt();
        this.first_login = parcel.readInt();
        this.constellation = parcel.readInt();
        this.contact_status = parcel.readInt();
        this.qq = parcel.readString();
        this.wechat = parcel.readString();
        this.city_id = parcel.readInt();
        this.province_id = parcel.readInt();
        this.marital_status = parcel.readInt();
        this.occupation = parcel.readString();
        this.company = parcel.readString();
        this.school = parcel.readString();
        this.hobby = parcel.readString();
        this.offen_appear = parcel.readString();
        this.autochargetime = parcel.readString();
        this.autochargetype = parcel.readInt();
        this.autostatus = parcel.readInt();
        this.phone = parcel.readString();
        this.producttype = parcel.readString();
        this.t1 = parcel.readString();
        this.roamType = parcel.readInt();
        this.roamBeginTime = parcel.readString();
        this.roamEndTime = parcel.readString();
        this.hasBindPhone = parcel.readInt();
        this.isVip = parcel.readInt();
        Parcelable[] parcelableArray = parcel.readParcelableArray(BusiVip.class.getClassLoader());
        if (parcelableArray != null) {
            this.busiVip = (BusiVip[]) Arrays.copyOf(parcelableArray, parcelableArray.length, BusiVip[].class);
        }
        SVIPExtInfo.createFParcel(this, parcel);
        this.accounts = parcel.readArrayList(ArrayList.class.getClassLoader());
    }

    public static UserData newEmptyInstance() {
        return new UserData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<AccountSimpleEntity> getAccounts() {
        return this.accounts;
    }

    public String getAutochargetime() {
        return this.autochargetime;
    }

    public int getAutochargetype() {
        return this.autochargetype;
    }

    public int getAutostatus() {
        return this.autostatus;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getBirthdayMMDD() {
        return this.birthdayMMDD;
    }

    public String getBirthdayYYYYMMDD() {
        return this.birthdayYYYYMMDD;
    }

    public BusiVip[] getBusiVip() {
        return this.busiVip;
    }

    public String getCity() {
        return this.city;
    }

    public int getCity_id() {
        return this.city_id;
    }

    public String getCompany() {
        return this.company;
    }

    public int getConstellation() {
        return this.constellation;
    }

    public int getContact_status() {
        return this.contact_status;
    }

    public int getError_code() {
        return this.error_code;
    }

    public int getFirst_login() {
        return this.first_login;
    }

    public int getHasBindPhone() {
        return this.hasBindPhone;
    }

    public String getHobby() {
        return this.hobby;
    }

    public int getIsAllowVisit() {
        return this.isAllowVisit;
    }

    public int getIsVip() {
        return this.isVip;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getLast_login_time() {
        return this.last_login_time;
    }

    public int getLoginType() {
        return this.mLoginType;
    }

    public String getLogin_email() {
        return this.login_email;
    }

    public String getLogin_mobile() {
        return this.login_mobile;
    }

    public int getM_is_old() {
        return this.m_is_old;
    }

    public int getMarital_status() {
        return this.marital_status;
    }

    public String getMemo() {
        return this.memo;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMusicBegin() {
        return this.musicBegin;
    }

    public String getMusicEnd() {
        return this.musicEnd;
    }

    public int getMusicType() {
        return this.musicType;
    }

    public String getMusic_clearday() {
        return this.music_clearday;
    }

    public String getMusic_resetTime() {
        return this.music_resetTime;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public String getOffen_appear() {
        return this.offen_appear;
    }

    public int getPartnerId() {
        return this.partnerId;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPic() {
        return this.pic;
    }

    public String getProducttype() {
        return this.producttype;
    }

    public String getProvince() {
        return this.province;
    }

    public int getProvince_id() {
        return this.province_id;
    }

    public String getQq() {
        return this.qq;
    }

    public int getQuestion_id() {
        return this.question_id;
    }

    public String getReg_time() {
        return this.reg_time;
    }

    public long getReg_timeLong() {
        if (this.simpleDateFormat == null) {
            this.simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        }
        try {
            return this.simpleDateFormat.parse(this.reg_time).getTime();
        } catch (Exception e2) {
            g0.k(e2);
            return 0L;
        }
    }

    public String getRespStr() {
        return this.respStr;
    }

    public String getRoamBeginTime() {
        return this.roamBeginTime;
    }

    public String getRoamEndTime() {
        return this.roamEndTime;
    }

    public int getRoamType() {
        return this.roamType;
    }

    public String getSchool() {
        return this.school;
    }

    public int getScore() {
        return this.score;
    }

    public String getSecurity_email() {
        return this.security_email;
    }

    public String getServertime() {
        return this.servertime;
    }

    public int getSex() {
        return this.sex;
    }

    public String getSignature() {
        return this.signature;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSuper_Vip_end_time() {
        return this.s_vip_end_time;
    }

    public String getT1() {
        return this.t1;
    }

    public String getTags() {
        return this.tags;
    }

    public String getToken() {
        return this.token;
    }

    public String getTotpKey() {
        return this.totpKey;
    }

    public long getTotpTimeStamp() {
        return this.totpTimeStamp;
    }

    public String getTruename() {
        return this.truename;
    }

    public long getUserid() {
        return this.userid;
    }

    @Deprecated
    public int getUseridInt32() {
        return (int) this.userid;
    }

    public String getUsername() {
        return this.username;
    }

    public BusiVip getValidVip() {
        BusiVip[] busiVipArr = this.busiVip;
        if (busiVipArr == null) {
            return null;
        }
        for (BusiVip busiVip : busiVipArr) {
            if (busiVip.isVip()) {
                return busiVip;
            }
        }
        return null;
    }

    public String getVip_begin_time() {
        return this.vip_begin_time;
    }

    public String getVip_clearday() {
        return this.vip_clearday;
    }

    public String getVip_end_time() {
        return this.vip_end_time;
    }

    public int getVip_type() {
        return this.vip_type;
    }

    public String getWechat() {
        return this.wechat;
    }

    public int getYearType() {
        return this.yearType;
    }

    public String getYoungDVipEndTime() {
        BusiVip[] busiVipArr = this.busiVip;
        if (busiVipArr == null) {
            return "";
        }
        for (BusiVip busiVip : busiVipArr) {
            if ("dvip".equals(busiVip.getProductType())) {
                return busiVip.getVipEndTime();
            }
        }
        return "";
    }

    public int getYoungIsVip() {
        BusiVip[] busiVipArr = this.busiVip;
        if (busiVipArr != null) {
            for (BusiVip busiVip : busiVipArr) {
                if (busiVip.isVip()) {
                    return busiVip.getIsVip();
                }
            }
        }
        return 0;
    }

    public String getYoungQVipEndTime() {
        BusiVip[] busiVipArr = this.busiVip;
        if (busiVipArr == null) {
            return "";
        }
        for (BusiVip busiVip : busiVipArr) {
            if ("qvip".equals(busiVip.getProductType())) {
                return busiVip.getVipEndTime();
            }
        }
        return "";
    }

    public String getYoungSVipEndTime() {
        BusiVip[] busiVipArr = this.busiVip;
        if (busiVipArr == null) {
            return "";
        }
        for (BusiVip busiVip : busiVipArr) {
            if ("svip".equals(busiVip.getProductType())) {
                return busiVip.getVipEndTime();
            }
        }
        return "";
    }

    public String getYoungVipBeginTime() {
        BusiVip[] busiVipArr = this.busiVip;
        if (busiVipArr == null) {
            return "";
        }
        for (BusiVip busiVip : busiVipArr) {
            if (busiVip.isVip()) {
                return busiVip.getVipBeginTime();
            }
        }
        return "";
    }

    public String getYoungVipEndTime() {
        BusiVip[] busiVipArr = this.busiVip;
        if (busiVipArr == null) {
            return "";
        }
        for (BusiVip busiVip : busiVipArr) {
            if (busiVip.isVip()) {
                return busiVip.getVipEndTime();
            }
        }
        for (BusiVip busiVip2 : this.busiVip) {
            if (!TextUtils.isEmpty(busiVip2.getVipEndTime())) {
                return busiVip2.getVipEndTime();
            }
        }
        BusiVip[] busiVipArr2 = this.busiVip;
        return busiVipArr2.length > 0 ? busiVipArr2[0].getVipEndTime() : "";
    }

    public int getYoungVipType() {
        BusiVip[] busiVipArr = this.busiVip;
        if (busiVipArr != null) {
            for (BusiVip busiVip : busiVipArr) {
                if (busiVip.isVip()) {
                    return busiVip.getYType();
                }
            }
            BusiVip[] busiVipArr2 = this.busiVip;
            if (busiVipArr2.length > 0) {
                return busiVipArr2[0].getYType();
            }
        }
        return 0;
    }

    public boolean isMusicPkg() {
        int i2 = this.musicType;
        return i2 > 0 && i2 < 5;
    }

    public boolean isPaidVip() {
        BusiVip[] busiVipArr = this.busiVip;
        return busiVipArr != null && busiVipArr.length > 0 && busiVipArr[0].getIsPaidVip() == 1;
    }

    public boolean isVerifyRealName() {
        return this.isVerifyRealName;
    }

    public boolean isVip() {
        int i2 = this.vip_type;
        return (i2 == 0 || i2 == 5) ? false : true;
    }

    public boolean isYoungVip() {
        return getYoungIsVip() == 1;
    }

    public void setAccounts(ArrayList<AccountSimpleEntity> arrayList) {
        this.accounts = arrayList;
    }

    public void setAutochargetime(String str) {
        this.autochargetime = str;
    }

    public void setAutochargetype(int i2) {
        this.autochargetype = i2;
    }

    public void setAutostatus(int i2) {
        this.autostatus = i2;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setBirthdayMMDD(String str) {
        this.birthdayMMDD = str;
    }

    public void setBirthdayYYYYMMDD(String str) {
        this.birthdayYYYYMMDD = str;
    }

    public void setBusiVip(BusiVip[] busiVipArr) {
        this.busiVip = busiVipArr;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCity_id(int i2) {
        this.city_id = i2;
    }

    public void setCompany(String str) {
        this.company = str;
    }

    public void setConstellation(int i2) {
        this.constellation = i2;
    }

    public void setContact_status(int i2) {
        this.contact_status = i2;
    }

    public void setError_code(int i2) {
        this.error_code = i2;
    }

    public void setFirst_login(int i2) {
        this.first_login = i2;
    }

    public void setHasBindPhone(int i2) {
        this.hasBindPhone = i2;
    }

    public void setHobby(String str) {
        this.hobby = str;
    }

    public void setIsAllowVisit(int i2) {
        this.isAllowVisit = i2;
    }

    public void setIsVip(int i2) {
        this.isVip = i2;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setLast_login_time(String str) {
        this.last_login_time = str;
    }

    public void setLoginType(int i2) {
        this.mLoginType = i2;
    }

    public void setLogin_email(String str) {
        this.login_email = str;
    }

    public void setLogin_mobile(String str) {
        this.login_mobile = str;
    }

    public void setM_is_old(int i2) {
        this.m_is_old = i2;
    }

    public void setMarital_status(int i2) {
        this.marital_status = i2;
    }

    public void setMemo(String str) {
        this.memo = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMusicBegin(String str) {
        this.musicBegin = str;
    }

    public void setMusicEnd(String str) {
        this.musicEnd = str;
    }

    public void setMusicType(int i2) {
        this.musicType = i2;
    }

    public void setMusic_clearday(String str) {
        this.music_clearday = str;
    }

    public void setMusic_resetTime(String str) {
        this.music_resetTime = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOccupation(String str) {
        this.occupation = str;
    }

    public void setOffen_appear(String str) {
        this.offen_appear = str;
    }

    public void setPartnerId(int i2) {
        this.partnerId = i2;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setProducttype(String str) {
        this.producttype = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setProvince_id(int i2) {
        this.province_id = i2;
    }

    public void setQq(String str) {
        this.qq = str;
    }

    public void setQuestion_id(int i2) {
        this.question_id = i2;
    }

    public void setReg_time(String str) {
        this.reg_time = str;
    }

    public void setRespStr(String str) {
        this.respStr = str;
    }

    public void setRoamBeginTime(String str) {
        this.roamBeginTime = str;
    }

    public void setRoamEndTime(String str) {
        this.roamEndTime = str;
    }

    public void setRoamType(int i2) {
        this.roamType = i2;
    }

    public void setSchool(String str) {
        this.school = str;
    }

    public void setScore(int i2) {
        this.score = i2;
    }

    public void setSecurity_email(String str) {
        this.security_email = str;
    }

    public void setServertime(String str) {
        this.servertime = str;
    }

    public void setSex(int i2) {
        this.sex = i2;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setSuper_Vip_end_time(String str) {
        this.s_vip_end_time = str;
    }

    public void setT1(String str) {
        this.t1 = str;
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTotpKey(String str) {
        this.totpKey = str;
    }

    public void setTotpTimeStamp(long j) {
        this.totpTimeStamp = j;
    }

    public void setTruename(String str) {
        this.truename = str;
    }

    public void setUserid(long j) {
        this.userid = j;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setVerifyRealName(boolean z) {
        this.isVerifyRealName = z;
    }

    public void setVip_begin_time(String str) {
        this.vip_begin_time = str;
    }

    public void setVip_clearday(String str) {
        this.vip_clearday = str;
    }

    public void setVip_end_time(String str) {
        this.vip_end_time = str;
    }

    public void setVip_type(int i2) {
        this.vip_type = i2;
    }

    public void setWechat(String str) {
        this.wechat = str;
    }

    public void setYearType(int i2) {
        this.yearType = i2;
    }

    public String toString() {
        return "UserData{status=" + this.status + ", error_code=" + this.error_code + ", userid=" + this.userid + ", username='" + this.username + "', truename='" + this.truename + "', nickname='" + this.nickname + "', vip_type=" + this.vip_type + ", vip_begin_time='" + this.vip_begin_time + "', vip_end_time='" + this.vip_end_time + "', s_vip_end_time='" + this.s_vip_end_time + "', vip_clearday='" + this.vip_clearday + "', isVerifyRealName=" + this.isVerifyRealName + ", servertime='" + this.servertime + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.status);
        parcel.writeInt(this.error_code);
        parcel.writeLong(this.userid);
        parcel.writeString(this.username);
        parcel.writeString(this.truename);
        parcel.writeString(this.nickname);
        parcel.writeInt(this.sex);
        parcel.writeString(this.pic);
        parcel.writeInt(this.score);
        parcel.writeInt(this.vip_type);
        parcel.writeString(this.vip_begin_time);
        parcel.writeString(this.vip_end_time);
        parcel.writeString(this.s_vip_end_time);
        parcel.writeString(this.reg_time);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.memo);
        parcel.writeString(this.signature);
        parcel.writeString(this.tags);
        parcel.writeString(this.last_login_time);
        parcel.writeString(this.birthday);
        parcel.writeString(this.vip_clearday);
        parcel.writeString(this.music_clearday);
        parcel.writeString(this.security_email);
        parcel.writeString(this.login_email);
        parcel.writeString(this.login_mobile);
        parcel.writeString(this.token);
        parcel.writeInt(this.question_id);
        parcel.writeString(this.respStr);
        parcel.writeString(this.message);
        parcel.writeInt(this.isAllowVisit);
        parcel.writeInt(this.first_login);
        parcel.writeInt(this.constellation);
        parcel.writeInt(this.contact_status);
        parcel.writeString(this.qq);
        parcel.writeString(this.wechat);
        parcel.writeInt(this.city_id);
        parcel.writeInt(this.province_id);
        parcel.writeInt(this.marital_status);
        parcel.writeString(this.occupation);
        parcel.writeString(this.company);
        parcel.writeString(this.school);
        parcel.writeString(this.hobby);
        parcel.writeString(this.offen_appear);
        parcel.writeString(this.autochargetime);
        parcel.writeInt(this.autochargetype);
        parcel.writeInt(this.autostatus);
        parcel.writeString(this.phone);
        parcel.writeString(this.producttype);
        parcel.writeString(this.t1);
        parcel.writeInt(this.roamType);
        parcel.writeString(this.roamBeginTime);
        parcel.writeString(this.roamEndTime);
        parcel.writeInt(this.hasBindPhone);
        parcel.writeInt(this.isVip);
        parcel.writeParcelableArray(this.busiVip, i2);
        write2Parcel(parcel);
        parcel.writeList(this.accounts);
    }

    private UserData() {
        this.t1 = "null";
    }
}
