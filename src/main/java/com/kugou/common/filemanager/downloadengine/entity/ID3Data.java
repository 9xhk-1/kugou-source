package com.kugou.common.filemanager.downloadengine.entity;

/* JADX INFO: loaded from: classes2.dex */
public class ID3Data {
    private String id3FieldsJson;
    private byte[] picData;

    public String getID3FieldsJson() {
        return this.id3FieldsJson;
    }

    public byte[] getPicData() {
        return this.picData;
    }

    public void setID3FieldsJson(String str) {
        this.id3FieldsJson = str;
    }

    public void setPicData(byte[] bArr) {
        this.picData = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID3Data{json = ");
        sb.append(this.id3FieldsJson);
        sb.append(", picData.length = ");
        byte[] bArr = this.picData;
        sb.append(bArr == null ? -1 : bArr.length);
        sb.append('}');
        return sb.toString();
    }
}
