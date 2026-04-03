package com.kugou.framework.worker;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public class WorkScheduler {
    private final Callback mCallback;
    private final String mName;
    public int mPriority;
    private final InstructionQueue mQueue;
    private final Serializer mSerializer;

    public interface Callback {
        boolean handleInstruction(Instruction instruction);
    }

    public static final class Serializer {
        private boolean mOccupied;

        public final void free() {
            this.mOccupied = false;
        }

        public final boolean tryOccupy() {
            if (this.mOccupied) {
                return false;
            }
            this.mOccupied = true;
            return true;
        }
    }

    public WorkScheduler() {
        this(null, null);
    }

    private boolean enqueueInstruction(InstructionQueue instructionQueue, Instruction instruction, long j) {
        instruction.target = this;
        return instructionQueue.enqueue(instruction, j);
    }

    private static Instruction getPostInstruction(Runnable runnable) {
        Instruction instructionObtain = Instruction.obtain();
        instructionObtain.callback = runnable;
        return instructionObtain;
    }

    public void dispatchInstruction(Instruction instruction) {
        Runnable runnable = instruction.callback;
        if (runnable != null) {
            runnable.run();
            return;
        }
        Callback callback = this.mCallback;
        if (callback == null || !callback.handleInstruction(instruction)) {
            handleInstruction(instruction);
        }
    }

    public final void free() {
        this.mSerializer.free();
    }

    public final Serializer getSerializer() {
        return this.mSerializer;
    }

    public void handleInstruction(Instruction instruction) {
    }

    public final boolean hasInstructions(int i2) {
        return this.mQueue.hasInstructions(this, i2, (Object) null);
    }

    public final Instruction obtainInstruction() {
        return Instruction.obtain(this);
    }

    public final boolean post(Runnable runnable) {
        return sendInstructionDelayed(getPostInstruction(runnable), 0L);
    }

    public final boolean postAtTime(Runnable runnable, long j) {
        return sendInstructionAtTime(getPostInstruction(runnable), j);
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return sendInstructionDelayed(getPostInstruction(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        this.mQueue.removeInstructions(this, runnable, (Object) null);
    }

    public final void removeCallbacksAndInstructions(Object obj) {
        this.mQueue.removeCallbacksAndInstructions(this, obj);
    }

    public final void removeInstructions(int i2) {
        this.mQueue.removeInstructions(this, i2, (Object) null);
    }

    public final boolean sendEmptyInstruction(int i2) {
        return sendEmptyInstructionDelayed(i2, 0L);
    }

    public final boolean sendEmptyInstructionAtTime(int i2, long j) {
        Instruction instructionObtain = Instruction.obtain();
        instructionObtain.what = i2;
        return sendInstructionAtTime(instructionObtain, j);
    }

    public final boolean sendEmptyInstructionDelayed(int i2, long j) {
        Instruction instructionObtain = Instruction.obtain();
        instructionObtain.what = i2;
        return sendInstructionDelayed(instructionObtain, j);
    }

    public final boolean sendInstruction(Instruction instruction) {
        return sendInstructionDelayed(instruction, 0L);
    }

    public final boolean sendInstructionAtFront(Instruction instruction) {
        return sendInstructionAtTime(instruction, 0L);
    }

    public boolean sendInstructionAtTime(Instruction instruction, long j) {
        InstructionQueue instructionQueue = this.mQueue;
        if (instructionQueue == null) {
            return false;
        }
        return enqueueInstruction(instructionQueue, instruction, j);
    }

    public final boolean sendInstructionDelayed(Instruction instruction, long j) {
        if (j < 0) {
            j = 0;
        }
        return sendInstructionAtTime(instruction, SystemClock.uptimeMillis() + j);
    }

    public final void setPriority(int i2) {
        this.mPriority = i2;
    }

    public final boolean tryOccupy() {
        return this.mSerializer.tryOccupy();
    }

    public WorkScheduler(String str) {
        this(str, null);
    }

    public final boolean hasInstructions(int i2, Object obj) {
        return this.mQueue.hasInstructions(this, i2, obj);
    }

    public final Instruction obtainInstruction(int i2) {
        return Instruction.obtain(this, i2);
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j) {
        return sendInstructionAtTime(getPostInstruction(runnable, obj), j);
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        this.mQueue.removeInstructions(this, runnable, obj);
    }

    public final void removeInstructions(int i2, Object obj) {
        this.mQueue.removeInstructions(this, i2, obj);
    }

    public WorkScheduler(Callback callback) {
        this(null, callback);
    }

    private static Instruction getPostInstruction(Runnable runnable, Object obj) {
        Instruction instructionObtain = Instruction.obtain();
        instructionObtain.callback = runnable;
        instructionObtain.obj = obj;
        return instructionObtain;
    }

    public final Instruction obtainInstruction(int i2, Object obj) {
        return Instruction.obtain(this, i2, obj);
    }

    public WorkScheduler(String str, Callback callback) {
        this(str, callback, null);
    }

    public final Instruction obtainInstruction(int i2, int i3, int i4) {
        return Instruction.obtain(this, i2, i3, i4);
    }

    public WorkScheduler(String str, Callback callback, Serializer serializer) {
        this.mQueue = ScheduleManager.get().mQueue;
        this.mName = str;
        this.mCallback = callback;
        this.mSerializer = serializer == null ? new Serializer() : serializer;
        this.mPriority = 0;
    }

    public final Instruction obtainInstruction(int i2, int i3, int i4, Object obj) {
        return Instruction.obtain(this, i2, i3, i4, obj);
    }
}
