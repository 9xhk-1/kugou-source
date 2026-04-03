package com.kugou.framework.worker;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InstructionQueue {
    private boolean mBlocked;
    private Instruction mInstructions;
    private List<Instruction> mPending;
    private final Object mWaiter = new Object();
    private boolean mWakeCalled;

    private void freeTargetLocked(Instruction instruction) {
        instruction.target.free();
    }

    private boolean tryOccupyTargetLocked(Instruction instruction) {
        return instruction.target.tryOccupy();
    }

    private void waitingTimeUp(int i2) {
        if (i2 == 0) {
            return;
        }
        synchronized (this.mWaiter) {
            try {
                if (!this.mWakeCalled) {
                    if (i2 < 0) {
                        this.mWaiter.wait();
                    } else {
                        this.mWaiter.wait(i2);
                    }
                }
                this.mWakeCalled = false;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void wakeup() {
        synchronized (this.mWaiter) {
            this.mWakeCalled = true;
            this.mWaiter.notify();
        }
    }

    public boolean enqueue(Instruction instruction, long j) {
        Instruction instruction2;
        if (instruction.target == null) {
            throw new IllegalArgumentException("Instruction must have a target.");
        }
        if (instruction.isInUse()) {
            throw new IllegalStateException(instruction + " This instruction is already in use.");
        }
        synchronized (this) {
            instruction.markInUse();
            instruction.when = j;
            Instruction instruction3 = this.mInstructions;
            boolean z = false;
            if (instruction3 == null || j == 0 || j < instruction3.when) {
                instruction.next = instruction3;
                this.mInstructions = instruction;
                z = this.mBlocked;
            } else {
                while (true) {
                    instruction2 = instruction3.next;
                    if (instruction2 == null || j < instruction2.when) {
                        break;
                    }
                    instruction3 = instruction2;
                }
                instruction.next = instruction2;
                instruction3.next = instruction;
            }
            if (z) {
                wakeup();
            }
        }
        return true;
    }

    public boolean hasInstructions(WorkScheduler workScheduler, int i2, Object obj) {
        if (workScheduler == null) {
            return false;
        }
        synchronized (this) {
            for (Instruction instruction = this.mInstructions; instruction != null; instruction = instruction.next) {
                if (instruction.target == workScheduler && instruction.what == i2 && (obj == null || instruction.obj == obj)) {
                    return true;
                }
            }
            List<Instruction> list = this.mPending;
            if (list != null && list.size() > 0) {
                for (Instruction instruction2 : this.mPending) {
                    if (instruction2.target == workScheduler && instruction2.what == i2 && (obj == null || instruction2.obj == obj)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        r7.mInstructions = r3.next;
        r3.next = null;
        r3.markInUse();
        r7.mBlocked = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (tryOccupyTargetLocked(r3) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r7.mPending != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        r7.mPending = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
    
        r7.mPending.add(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.kugou.framework.worker.Instruction next() {
        /*
            r7 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            r7.waitingTimeUp(r1)
            monitor-enter(r7)
            java.util.List<com.kugou.framework.worker.Instruction> r1 = r7.mPending     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L2f
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L76
            if (r1 <= 0) goto L2f
            java.util.List<com.kugou.framework.worker.Instruction> r1 = r7.mPending     // Catch: java.lang.Throwable -> L76
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L76
        L16:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L2f
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L76
            com.kugou.framework.worker.Instruction r2 = (com.kugou.framework.worker.Instruction) r2     // Catch: java.lang.Throwable -> L76
            boolean r3 = r7.tryOccupyTargetLocked(r2)     // Catch: java.lang.Throwable -> L76
            if (r3 == 0) goto L16
            r1.remove()     // Catch: java.lang.Throwable -> L76
            r7.mBlocked = r0     // Catch: java.lang.Throwable -> L76
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            return r2
        L2f:
            long r1 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L76
            com.kugou.framework.worker.Instruction r3 = r7.mInstructions     // Catch: java.lang.Throwable -> L76
            if (r3 == 0) goto L70
            long r4 = r3.when     // Catch: java.lang.Throwable -> L76
            long r4 = r4 - r1
            r1 = 0
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 <= 0) goto L4a
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r1 = java.lang.Math.min(r4, r1)     // Catch: java.lang.Throwable -> L76
            int r2 = (int) r1     // Catch: java.lang.Throwable -> L76
            r1 = r2
            goto L71
        L4a:
            com.kugou.framework.worker.Instruction r1 = r3.next     // Catch: java.lang.Throwable -> L76
            r7.mInstructions = r1     // Catch: java.lang.Throwable -> L76
            r1 = 0
            r3.next = r1     // Catch: java.lang.Throwable -> L76
            r3.markInUse()     // Catch: java.lang.Throwable -> L76
            r7.mBlocked = r0     // Catch: java.lang.Throwable -> L76
            boolean r1 = r7.tryOccupyTargetLocked(r3)     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L5e
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            return r3
        L5e:
            java.util.List<com.kugou.framework.worker.Instruction> r1 = r7.mPending     // Catch: java.lang.Throwable -> L76
            if (r1 != 0) goto L69
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L76
            r7.mPending = r1     // Catch: java.lang.Throwable -> L76
        L69:
            java.util.List<com.kugou.framework.worker.Instruction> r1 = r7.mPending     // Catch: java.lang.Throwable -> L76
            r1.add(r3)     // Catch: java.lang.Throwable -> L76
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            goto L1
        L70:
            r1 = -1
        L71:
            r2 = 1
            r7.mBlocked = r2     // Catch: java.lang.Throwable -> L76
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            goto L2
        L76:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            goto L7a
        L79:
            throw r0
        L7a:
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.worker.InstructionQueue.next():com.kugou.framework.worker.Instruction");
    }

    public void notifyInstructionFinish(Instruction instruction) {
        List<Instruction> list;
        synchronized (this) {
            freeTargetLocked(instruction);
            instruction.recycleUnchecked();
            if (this.mBlocked && (list = this.mPending) != null && list.size() > 0) {
                wakeup();
            }
        }
    }

    public void removeCallbacksAndInstructions(WorkScheduler workScheduler, Object obj) {
        if (workScheduler == null) {
            return;
        }
        synchronized (this) {
            Instruction instruction = this.mInstructions;
            while (instruction != null && instruction.target == workScheduler && (obj == null || instruction.obj == obj)) {
                Instruction instruction2 = instruction.next;
                this.mInstructions = instruction2;
                instruction.recycleUnchecked();
                instruction = instruction2;
            }
            while (instruction != null) {
                Instruction instruction3 = instruction.next;
                if (instruction3 != null && instruction3.target == workScheduler && (obj == null || instruction3.obj == obj)) {
                    Instruction instruction4 = instruction3.next;
                    instruction3.recycleUnchecked();
                    instruction.next = instruction4;
                } else {
                    instruction = instruction3;
                }
            }
            List<Instruction> list = this.mPending;
            if (list != null && list.size() > 0) {
                Iterator<Instruction> it = this.mPending.iterator();
                while (it.hasNext()) {
                    Instruction next = it.next();
                    if (next.target == workScheduler && (obj == null || next.obj == obj)) {
                        next.recycleUnchecked();
                        it.remove();
                    }
                }
            }
        }
    }

    public void removeInstructions(WorkScheduler workScheduler, int i2, Object obj) {
        if (workScheduler == null) {
            return;
        }
        synchronized (this) {
            Instruction instruction = this.mInstructions;
            while (instruction != null && instruction.target == workScheduler && instruction.what == i2 && (obj == null || instruction.obj == obj)) {
                Instruction instruction2 = instruction.next;
                this.mInstructions = instruction2;
                instruction.recycleUnchecked();
                instruction = instruction2;
            }
            while (instruction != null) {
                Instruction instruction3 = instruction.next;
                if (instruction3 != null && instruction3.target == workScheduler && instruction3.what == i2 && (obj == null || instruction3.obj == obj)) {
                    Instruction instruction4 = instruction3.next;
                    instruction3.recycleUnchecked();
                    instruction.next = instruction4;
                } else {
                    instruction = instruction3;
                }
            }
            List<Instruction> list = this.mPending;
            if (list != null && list.size() > 0) {
                Iterator<Instruction> it = this.mPending.iterator();
                while (it.hasNext()) {
                    Instruction next = it.next();
                    if (next.target == workScheduler && next.what == i2 && (obj == null || next.obj == obj)) {
                        next.recycleUnchecked();
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean hasInstructions(WorkScheduler workScheduler, Runnable runnable, Object obj) {
        if (workScheduler == null) {
            return false;
        }
        synchronized (this) {
            for (Instruction instruction = this.mInstructions; instruction != null; instruction = instruction.next) {
                if (instruction.target == workScheduler && instruction.callback == runnable && (obj == null || instruction.obj == obj)) {
                    return true;
                }
            }
            List<Instruction> list = this.mPending;
            if (list != null && list.size() > 0) {
                for (Instruction instruction2 : this.mPending) {
                    if (instruction2.target == workScheduler && instruction2.callback == runnable && (obj == null || instruction2.obj == obj)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public void removeInstructions(WorkScheduler workScheduler, Runnable runnable, Object obj) {
        if (workScheduler == null || runnable == null) {
            return;
        }
        synchronized (this) {
            Instruction instruction = this.mInstructions;
            while (instruction != null && instruction.target == workScheduler && instruction.callback == runnable && (obj == null || instruction.obj == obj)) {
                Instruction instruction2 = instruction.next;
                this.mInstructions = instruction2;
                instruction.recycleUnchecked();
                instruction = instruction2;
            }
            while (instruction != null) {
                Instruction instruction3 = instruction.next;
                if (instruction3 != null && instruction3.target == workScheduler && instruction3.callback == runnable && (obj == null || instruction3.obj == obj)) {
                    Instruction instruction4 = instruction3.next;
                    instruction3.recycleUnchecked();
                    instruction.next = instruction4;
                } else {
                    instruction = instruction3;
                }
            }
            List<Instruction> list = this.mPending;
            if (list != null && list.size() > 0) {
                Iterator<Instruction> it = this.mPending.iterator();
                while (it.hasNext()) {
                    Instruction next = it.next();
                    if (next.target == workScheduler && next.callback == runnable && (obj == null || next.obj == obj)) {
                        next.recycleUnchecked();
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean hasInstructions(WorkScheduler workScheduler) {
        if (workScheduler == null) {
            return false;
        }
        synchronized (this) {
            for (Instruction instruction = this.mInstructions; instruction != null; instruction = instruction.next) {
                if (instruction.target == workScheduler) {
                    return true;
                }
            }
            List<Instruction> list = this.mPending;
            if (list != null && list.size() > 0) {
                Iterator<Instruction> it = this.mPending.iterator();
                while (it.hasNext()) {
                    if (it.next().target == workScheduler) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
