package com.kugou.framework.lyric4.Entity;

/* JADX INFO: loaded from: classes2.dex */
public class BulletinEntity {
    private int btnRId;
    private String btnText;
    private String bulletin;

    public BulletinEntity(String str) {
        this.bulletin = str;
    }

    public int getBtnRId() {
        return this.btnRId;
    }

    public String getBtnText() {
        return this.btnText;
    }

    public String getBulletin() {
        return this.bulletin;
    }

    public void setBtnRId(int i2) {
        this.btnRId = i2;
    }

    public void setBtnText(String str) {
        this.btnText = str;
    }

    public void setBulletin(String str) {
        this.bulletin = str;
    }

    public BulletinEntity(String str, String str2, int i2) {
        this.bulletin = str;
        this.btnText = str2;
        this.btnRId = i2;
    }
}
