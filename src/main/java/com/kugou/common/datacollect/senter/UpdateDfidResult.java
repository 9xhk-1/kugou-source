package com.kugou.common.datacollect.senter;

import com.kugou.android.watch.lite.common.INoGuard;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateDfidResult implements INoGuard {
    private DataBean data;
    private int error_code;
    private int status;

    public static class DataBean implements INoGuard {
        public static final int SCHEME_ALL = 1;
        public static final int SCHEME_ALL_AND_INSTALL = 2;
        public static final int SCHEME_SMALL = 0;
        private String dfid;
        private int scheme;

        public String getDfid() {
            return this.dfid;
        }

        public int getScheme() {
            return this.scheme;
        }

        public void setDfid(String str) {
            this.dfid = str;
        }

        public void setScheme(int i2) {
            this.scheme = i2;
        }

        public String toString() {
            return "DataBean{dfid='" + this.dfid + "', scheme=" + this.scheme + '}';
        }
    }

    public UpdateDfidResult(int i2, int i3, DataBean dataBean) {
        this.status = i2;
        this.error_code = i3;
        this.data = dataBean;
    }

    public DataBean getData() {
        return this.data;
    }

    public int getError_code() {
        return this.error_code;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setError_code(int i2) {
        this.error_code = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "UpdateDfidResult{status=" + this.status + ", error_code=" + this.error_code + ", data=" + this.data + '}';
    }
}
