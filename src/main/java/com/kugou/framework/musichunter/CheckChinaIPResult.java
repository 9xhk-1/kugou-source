package com.kugou.framework.musichunter;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CheckChinaIPResult {
    private String areaCode;
    private String flag;
    private int is_special_pay;
    private String mData;
    private int netError;

    public boolean canUseService() {
        return (TextUtils.isEmpty(this.areaCode) || "2".equals(this.areaCode)) ? false : true;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public String getFlag() {
        return this.flag;
    }

    public int getIs_special_pay() {
        return this.is_special_pay;
    }

    public int getNetError() {
        return this.netError;
    }

    public String getmData() {
        return this.mData;
    }

    public boolean isChineseMainLand() {
        return !TextUtils.isEmpty(this.areaCode) && "1".equals(this.areaCode);
    }

    public void setAreaCode(String str) {
        this.areaCode = str;
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public void setIs_special_pay(int i2) {
        this.is_special_pay = i2;
    }

    public void setNetError(int i2) {
        this.netError = i2;
    }

    public void setmData(String str) {
        this.mData = str;
    }
}
