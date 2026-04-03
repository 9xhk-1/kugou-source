package com.kugou.framework.musichunter;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class AudioQueue {
    public int mMaxSize;
    public LinkedBlockingQueue<AudioBuffer> mQueue;

    public AudioQueue() {
        this.mMaxSize = 500;
        ininQueue(500);
    }

    public void clearCache() {
        this.mQueue.clear();
    }

    public int getmQueueSize() {
        return this.mQueue.size();
    }

    public void ininQueue(int i2) {
        this.mQueue = new LinkedBlockingQueue<>(i2);
    }

    public AudioBuffer pop() {
        try {
            return this.mQueue.take();
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public void push(byte[] bArr, int i2) {
        try {
            if (bArr != null) {
                this.mQueue.put(new AudioBuffer(bArr, i2));
            } else {
                this.mQueue.put(new AudioBuffer(null, 0));
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public AudioQueue(int i2) {
        this.mMaxSize = i2;
        ininQueue(i2);
    }
}
