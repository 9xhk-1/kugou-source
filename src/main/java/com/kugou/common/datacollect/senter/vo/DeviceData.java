package com.kugou.common.datacollect.senter.vo;

import com.kugou.android.watch.lite.common.INoGuard;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceData implements INoGuard {
    public String emd;
    public String eud;
    public String machine;
    public int[] wh;

    public DeviceData(String str, String str2, String str3, int[] iArr) {
        this.eud = str;
        this.emd = str2;
        this.machine = str3;
        this.wh = iArr;
    }

    public String getEmd() {
        return this.emd;
    }

    public String getMachine() {
        return this.machine;
    }

    public int[] getWh() {
        return this.wh;
    }

    public void setEmd(String str) {
        this.emd = str;
    }

    public void setEud(String str) {
        this.eud = str;
    }

    public void setMachine(String str) {
        this.machine = str;
    }

    public void setWh(int[] iArr) {
        this.wh = iArr;
    }

    public String toString() {
        return "DeviceData{mid='" + this.eud + "', uuid='" + this.emd + "', machine='" + this.machine + "', wh=" + Arrays.toString(this.wh) + '}';
    }
}
