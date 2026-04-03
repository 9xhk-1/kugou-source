package g.a;

/* JADX INFO: loaded from: classes2.dex */
public interface g2 {
    long currentTimeMillis();

    long nanoTime();

    void parkNanos(Object obj, long j);

    void registerTimeLoopThread();

    void trackTask();

    void unTrackTask();

    void unpark(Thread thread);

    void unregisterTimeLoopThread();

    Runnable wrapTask(Runnable runnable);
}
