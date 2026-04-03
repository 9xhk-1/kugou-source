package com.kugou.common.filemanager.downloadengine.http;

/* JADX INFO: loaded from: classes2.dex */
public class HttpSpeed {
    private long avgSpeed;
    private long lastTick;
    private long newBytes;
    private long speed;
    private long startTick;
    private long totalBytes;

    private void doCalc(boolean z) {
        if (this.startTick == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        long j = jNanoTime - this.lastTick;
        if (z || j >= 1000000000) {
            this.lastTick = jNanoTime;
            long j2 = this.newBytes;
            long j3 = this.totalBytes + j2;
            this.totalBytes = j3;
            this.newBytes = 0L;
            if (j > 1000000000) {
                this.speed = (j2 * 1000000000) / j;
            } else {
                this.speed = j2;
            }
            long j4 = jNanoTime - this.startTick;
            if (j4 > 1000000000) {
                this.avgSpeed = (j3 * 1000000000) / j4;
            } else {
                this.avgSpeed = j3;
            }
        }
    }

    public synchronized void addBytes(long j) {
        if (this.startTick == 0) {
            return;
        }
        this.newBytes += j;
    }

    public synchronized void calc() {
        doCalc(false);
    }

    public synchronized void calcFinal() {
        doCalc(true);
    }

    public synchronized long getAvgSpeed() {
        return this.avgSpeed;
    }

    public synchronized long getSpeed() {
        return this.speed;
    }

    public synchronized void start() {
        if (this.startTick != 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        if (jNanoTime == 0) {
            jNanoTime = 1;
        }
        this.startTick = jNanoTime;
        this.lastTick = jNanoTime;
        this.newBytes = 0L;
        this.totalBytes = 0L;
        this.speed = 0L;
        this.avgSpeed = 0L;
    }

    public synchronized void stop() {
        this.startTick = 0L;
        this.lastTick = 0L;
        this.newBytes = 0L;
        this.totalBytes = 0L;
        this.speed = 0L;
        this.avgSpeed = 0L;
    }
}
