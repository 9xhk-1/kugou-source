package com.tencent.tmachine.trace.looper.data;

import defpackage.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyPendingMsg {
    private final long blockTime;
    private final String desc;
    private final MsgDesc msgDesc;

    public KeyPendingMsg(long j, String str, MsgDesc msgDesc) {
        j.f(str, "desc");
        this.blockTime = j;
        this.desc = str;
        this.msgDesc = msgDesc;
    }

    public static /* synthetic */ KeyPendingMsg copy$default(KeyPendingMsg keyPendingMsg, long j, String str, MsgDesc msgDesc, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = keyPendingMsg.blockTime;
        }
        if ((i2 & 2) != 0) {
            str = keyPendingMsg.desc;
        }
        if ((i2 & 4) != 0) {
            msgDesc = keyPendingMsg.msgDesc;
        }
        return keyPendingMsg.copy(j, str, msgDesc);
    }

    public final long component1() {
        return this.blockTime;
    }

    public final String component2() {
        return this.desc;
    }

    public final MsgDesc component3() {
        return this.msgDesc;
    }

    public final KeyPendingMsg copy(long j, String str, MsgDesc msgDesc) {
        j.f(str, "desc");
        return new KeyPendingMsg(j, str, msgDesc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyPendingMsg)) {
            return false;
        }
        KeyPendingMsg keyPendingMsg = (KeyPendingMsg) obj;
        return this.blockTime == keyPendingMsg.blockTime && j.a(this.desc, keyPendingMsg.desc) && j.a(this.msgDesc, keyPendingMsg.msgDesc);
    }

    public final long getBlockTime() {
        return this.blockTime;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final MsgDesc getMsgDesc() {
        return this.msgDesc;
    }

    public int hashCode() {
        int iA = b.a(this.blockTime) * 31;
        String str = this.desc;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        MsgDesc msgDesc = this.msgDesc;
        return iHashCode + (msgDesc != null ? msgDesc.hashCode() : 0);
    }

    public String toString() {
        return "KeyPendingMsg(blockTime=" + this.blockTime + ", desc=" + this.desc + ", msgDesc=" + this.msgDesc + ")";
    }
}
