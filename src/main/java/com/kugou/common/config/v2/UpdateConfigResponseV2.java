package com.kugou.common.config.v2;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateConfigResponseV2 {
    public int cursorId;
    public List<String> profileList;

    public UpdateConfigResponseV2(int i2, List<String> list) {
        this.cursorId = i2;
        this.profileList = list;
    }

    public String toString() {
        return "UpdateConfigResponseV2{cursorId=" + this.cursorId + ", profileList=" + this.profileList + '}';
    }
}
