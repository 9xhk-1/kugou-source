package com.tencent.tmachine.trace.looper.data;

import android.os.Handler;
import android.os.Message;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class MsgDesc {
    public static final Companion Companion = new Companion(null);
    private final int arg1;
    private final int arg2;
    private final String callback;
    private final String obj;
    private final String target;
    private final int what;

    public static final class Companion {
        private Companion() {
        }

        public final MsgDesc toMsgDesc(Message message) {
            if (message == null) {
                return null;
            }
            int i2 = message.what;
            int i3 = message.arg1;
            int i4 = message.arg2;
            Object obj = message.obj;
            String string = obj != null ? obj.toString() : null;
            Handler target = message.getTarget();
            String string2 = target != null ? target.toString() : null;
            Runnable callback = message.getCallback();
            return new MsgDesc(i2, i3, i4, string, string2, callback != null ? callback.toString() : null);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public MsgDesc(int i2, int i3, int i4, String str, String str2, String str3) {
        this.what = i2;
        this.arg1 = i3;
        this.arg2 = i4;
        this.obj = str;
        this.target = str2;
        this.callback = str3;
    }

    public static /* synthetic */ MsgDesc copy$default(MsgDesc msgDesc, int i2, int i3, int i4, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = msgDesc.what;
        }
        if ((i5 & 2) != 0) {
            i3 = msgDesc.arg1;
        }
        int i6 = i3;
        if ((i5 & 4) != 0) {
            i4 = msgDesc.arg2;
        }
        int i7 = i4;
        if ((i5 & 8) != 0) {
            str = msgDesc.obj;
        }
        String str4 = str;
        if ((i5 & 16) != 0) {
            str2 = msgDesc.target;
        }
        String str5 = str2;
        if ((i5 & 32) != 0) {
            str3 = msgDesc.callback;
        }
        return msgDesc.copy(i2, i6, i7, str4, str5, str3);
    }

    public static final MsgDesc toMsgDesc(Message message) {
        return Companion.toMsgDesc(message);
    }

    public final int component1() {
        return this.what;
    }

    public final int component2() {
        return this.arg1;
    }

    public final int component3() {
        return this.arg2;
    }

    public final String component4() {
        return this.obj;
    }

    public final String component5() {
        return this.target;
    }

    public final String component6() {
        return this.callback;
    }

    public final MsgDesc copy(int i2, int i3, int i4, String str, String str2, String str3) {
        return new MsgDesc(i2, i3, i4, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgDesc)) {
            return false;
        }
        MsgDesc msgDesc = (MsgDesc) obj;
        return this.what == msgDesc.what && this.arg1 == msgDesc.arg1 && this.arg2 == msgDesc.arg2 && j.a(this.obj, msgDesc.obj) && j.a(this.target, msgDesc.target) && j.a(this.callback, msgDesc.callback);
    }

    public final int getArg1() {
        return this.arg1;
    }

    public final int getArg2() {
        return this.arg2;
    }

    public final String getCallback() {
        return this.callback;
    }

    public final String getObj() {
        return this.obj;
    }

    public final String getTarget() {
        return this.target;
    }

    public final int getWhat() {
        return this.what;
    }

    public int hashCode() {
        int i2 = ((((this.what * 31) + this.arg1) * 31) + this.arg2) * 31;
        String str = this.obj;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.target;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.callback;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "MsgDesc(what=" + this.what + ", arg1=" + this.arg1 + ", arg2=" + this.arg2 + ", obj=" + this.obj + ", target=" + this.target + ", callback=" + this.callback + ")";
    }
}
