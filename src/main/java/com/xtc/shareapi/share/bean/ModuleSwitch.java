package com.xtc.shareapi.share.bean;

/* JADX INFO: loaded from: classes2.dex */
public class ModuleSwitch {
    private boolean module;
    private String tip;

    public ModuleSwitch() {
    }

    public String getTip() {
        return this.tip;
    }

    public boolean isModule() {
        return this.module;
    }

    public void setModule(boolean z) {
        this.module = z;
    }

    public void setTip(String str) {
        this.tip = str;
    }

    public String toString() {
        return "ModuleSwitch{module=" + this.module + ", tip='" + this.tip + "'}";
    }

    public ModuleSwitch(boolean z, String str) {
        this.module = z;
        this.tip = str;
    }
}
