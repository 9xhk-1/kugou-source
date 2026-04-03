package com.kugou.framework.bilib.bi.easytrace;

import com.kugou.framework.libcommon.netcore.BaseConnection;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KeyValueList {
    private List<KeyValue> mList;

    public static class KeyValue {
        private String mKey;
        private String mValue;

        public KeyValue(String str, String str2) {
            this.mKey = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.mKey;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    public KeyValueList() {
        this.mList = null;
        this.mList = new ArrayList();
    }

    private String specialChar(String str) {
        return str.replace('=', ' ').replace('&', ' ').replace('\r', ' ').replace('\n', ' ');
    }

    public void add(String str, String str2) {
        if (str2 != null) {
            this.mList.add(new KeyValue(str, specialChar(str2)));
        }
    }

    public String format() {
        List<KeyValue> list = this.mList;
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (KeyValue keyValue : this.mList) {
            sb.append(keyValue.getKey());
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(keyValue.getValue());
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String get(String str) {
        for (int i2 = 0; i2 < this.mList.size(); i2++) {
            if (this.mList.get(i2).getKey().equals(str)) {
                return this.mList.get(i2).getValue() + "";
            }
        }
        return "";
    }

    public List<KeyValue> getList() {
        return this.mList;
    }

    public boolean isEmpty() {
        List<KeyValue> list = this.mList;
        return list == null || list.size() == 0;
    }

    public void remove(KeyValue keyValue) {
        if (keyValue != null) {
            this.mList.remove(keyValue);
        }
    }

    public String toString() {
        return format();
    }

    public void add(KeyValue keyValue) {
        if (keyValue != null) {
            this.mList.add(keyValue);
        }
    }

    public void add(String str, int i2) {
        this.mList.add(new KeyValue(str, String.valueOf(i2)));
    }

    public void add(String str, long j) {
        this.mList.add(new KeyValue(str, String.valueOf(j)));
    }
}
