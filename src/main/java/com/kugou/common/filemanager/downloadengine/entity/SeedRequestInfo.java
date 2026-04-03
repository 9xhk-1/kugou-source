package com.kugou.common.filemanager.downloadengine.entity;

/* JADX INFO: loaded from: classes2.dex */
public class SeedRequestInfo {

    @SeedResourceType
    private int resource;
    private int spaceMB;

    public int getResourceType() {
        return this.resource;
    }

    public int getSpaceMB() {
        return this.spaceMB;
    }

    public void setResourceType(@SeedResourceType int i2) {
        this.resource = i2;
    }

    public void setSpaceMB(int i2) {
        this.spaceMB = i2;
    }
}
