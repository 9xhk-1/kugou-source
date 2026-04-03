package com.kugou.framework.worker;

import android.os.Bundle;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class Instruction {
    public static final int FLAG_IN_USE = 1;
    private static final int MAX_POOL_SIZE = 50;
    private static boolean gCheckRecycle = true;
    private static Instruction sPool;
    private static int sPoolSize;
    private static final Object sPoolSync = new Object();
    public int arg1;
    public int arg2;
    public Runnable callback;
    public Bundle data;
    public int flags;
    public Instruction next;
    public Object obj;
    public WorkScheduler target;
    public int what;
    public long when;

    public static Instruction obtain() {
        synchronized (sPoolSync) {
            Instruction instruction = sPool;
            if (instruction == null) {
                return new Instruction();
            }
            sPool = instruction.next;
            instruction.next = null;
            instruction.flags = 0;
            sPoolSize--;
            return instruction;
        }
    }

    public Runnable getCallback() {
        return this.callback;
    }

    public Bundle getData() {
        if (this.data == null) {
            this.data = new Bundle();
        }
        return this.data;
    }

    public WorkScheduler getTarget() {
        return this.target;
    }

    public long getWhen() {
        return this.when;
    }

    public boolean isInUse() {
        return (this.flags & 1) == 1;
    }

    public void markInUse() {
        this.flags |= 1;
    }

    public Bundle peekData() {
        return this.data;
    }

    public void recycle() {
        if (!isInUse()) {
            recycleUnchecked();
        } else if (gCheckRecycle) {
            throw new IllegalStateException("This instruction cannot be recycled because it is still in use.");
        }
    }

    public void recycleUnchecked() {
        this.flags = 1;
        this.what = 0;
        this.arg1 = 0;
        this.arg2 = 0;
        this.obj = null;
        this.when = 0L;
        this.target = null;
        this.callback = null;
        this.data = null;
        synchronized (sPoolSync) {
            int i2 = sPoolSize;
            if (i2 < 50) {
                this.next = sPool;
                sPool = this;
                sPoolSize = i2 + 1;
            }
        }
    }

    public void sendToTarget() {
        this.target.sendInstruction(this);
    }

    public void setData(Bundle bundle) {
        this.data = bundle;
    }

    public void setTarget(WorkScheduler workScheduler) {
        this.target = workScheduler;
    }

    public Message toMessage() {
        Message message = new Message();
        message.setTarget(null);
        message.what = this.what;
        message.arg1 = this.arg1;
        message.arg2 = this.arg2;
        message.obj = this.obj;
        return message;
    }

    public static Instruction obtain(Instruction instruction) {
        Instruction instructionObtain = obtain();
        instructionObtain.what = instruction.what;
        instructionObtain.arg1 = instruction.arg1;
        instructionObtain.arg2 = instruction.arg2;
        instructionObtain.obj = instruction.obj;
        if (instruction.data != null) {
            instructionObtain.data = new Bundle(instruction.data);
        }
        instructionObtain.target = instruction.target;
        instructionObtain.callback = instruction.callback;
        return instructionObtain;
    }

    public static Instruction obtain(WorkScheduler workScheduler) {
        Instruction instructionObtain = obtain();
        instructionObtain.target = workScheduler;
        return instructionObtain;
    }

    public static Instruction obtain(WorkScheduler workScheduler, Runnable runnable) {
        Instruction instructionObtain = obtain();
        instructionObtain.target = workScheduler;
        instructionObtain.callback = runnable;
        return instructionObtain;
    }

    public static Instruction obtain(WorkScheduler workScheduler, int i2) {
        Instruction instructionObtain = obtain();
        instructionObtain.target = workScheduler;
        instructionObtain.what = i2;
        return instructionObtain;
    }

    public static Instruction obtain(WorkScheduler workScheduler, int i2, Object obj) {
        Instruction instructionObtain = obtain();
        instructionObtain.target = workScheduler;
        instructionObtain.what = i2;
        instructionObtain.obj = obj;
        return instructionObtain;
    }

    public static Instruction obtain(WorkScheduler workScheduler, int i2, int i3, int i4) {
        Instruction instructionObtain = obtain();
        instructionObtain.target = workScheduler;
        instructionObtain.what = i2;
        instructionObtain.arg1 = i3;
        instructionObtain.arg2 = i4;
        return instructionObtain;
    }

    public static Instruction obtain(WorkScheduler workScheduler, int i2, int i3, int i4, Object obj) {
        Instruction instructionObtain = obtain();
        instructionObtain.target = workScheduler;
        instructionObtain.what = i2;
        instructionObtain.arg1 = i3;
        instructionObtain.arg2 = i4;
        instructionObtain.obj = obj;
        return instructionObtain;
    }
}
