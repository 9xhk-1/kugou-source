package com.tencent.tmachine.trace.core;

import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class ErrorExtra {
    private final int code;
    private final String extraMsg;

    public ErrorExtra(int i2, String str) {
        this.code = i2;
        this.extraMsg = str;
    }

    public static /* synthetic */ ErrorExtra copy$default(ErrorExtra errorExtra, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = errorExtra.code;
        }
        if ((i3 & 2) != 0) {
            str = errorExtra.extraMsg;
        }
        return errorExtra.copy(i2, str);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.extraMsg;
    }

    public final ErrorExtra copy(int i2, String str) {
        return new ErrorExtra(i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorExtra)) {
            return false;
        }
        ErrorExtra errorExtra = (ErrorExtra) obj;
        return this.code == errorExtra.code && j.a(this.extraMsg, errorExtra.extraMsg);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getExtraMsg() {
        return this.extraMsg;
    }

    public int hashCode() {
        int i2 = this.code * 31;
        String str = this.extraMsg;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ErrorExtra(code=" + this.code + ", extraMsg=" + this.extraMsg + ")";
    }

    public /* synthetic */ ErrorExtra(int i2, String str, int i3, g gVar) {
        this(i2, (i3 & 2) != 0 ? null : str);
    }
}
