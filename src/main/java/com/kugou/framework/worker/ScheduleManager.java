package com.kugou.framework.worker;

import android.os.Process;
import com.kugou.framework.libcommon.KGThreadPool;

/* JADX INFO: loaded from: classes2.dex */
public final class ScheduleManager {
    public final InstructionQueue mQueue;

    public static class ExecuteTask implements Runnable {
        private static final int MAX_POOL_SIZE = 30;
        private static int sPoolSize;
        private static ExecuteTask sTaskPool;
        private static volatile boolean safeguard;
        private Instruction instruction;
        private ExecuteTask next;
        private InstructionQueue queue;

        private ExecuteTask() {
        }

        private void changeThreadPriority(int i2) {
            try {
                Process.setThreadPriority(i2);
            } catch (Exception unused) {
            }
        }

        public static ExecuteTask obtain(InstructionQueue instructionQueue, Instruction instruction) {
            ExecuteTask executeTask;
            synchronized (ExecuteTask.class) {
                executeTask = sTaskPool;
                if (executeTask != null) {
                    sTaskPool = executeTask.next;
                    executeTask.next = null;
                    sPoolSize--;
                } else {
                    executeTask = new ExecuteTask();
                }
                executeTask.queue = instructionQueue;
                executeTask.instruction = instruction;
            }
            return executeTask;
        }

        public void recycle() {
            this.queue = null;
            this.instruction = null;
            synchronized (ExecuteTask.class) {
                int i2 = sPoolSize;
                if (i2 < 30) {
                    this.next = sTaskPool;
                    sTaskPool = this;
                    sPoolSize = i2 + 1;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            changeThreadPriority(this.instruction.target.mPriority);
            boolean z = safeguard;
            Instruction instruction = this.instruction;
            instruction.target.dispatchInstruction(instruction);
            safeguard = !z;
            this.queue.notifyInstructionFinish(this.instruction);
            recycle();
            changeThreadPriority(0);
        }
    }

    public static class Holder {
        public static final ScheduleManager INSTANCE = new ScheduleManager();

        private Holder() {
        }
    }

    private void execute(Runnable runnable) {
        KGThreadPool.getInstance().execute(runnable);
    }

    public static ScheduleManager get() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loop() {
        try {
            Process.setThreadPriority(-8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        InstructionQueue instructionQueue = this.mQueue;
        while (true) {
            Instruction next = instructionQueue.next();
            if (next == null) {
                throw new RuntimeException("Should not happened !!!");
            }
            execute(ExecuteTask.obtain(instructionQueue, next));
        }
    }

    private ScheduleManager() {
        this.mQueue = new InstructionQueue();
        new Thread(new Runnable() { // from class: com.kugou.framework.worker.ScheduleManager.1
            @Override // java.lang.Runnable
            public void run() {
                ScheduleManager.this.loop();
            }
        }, "ScheduleManager").start();
    }
}
