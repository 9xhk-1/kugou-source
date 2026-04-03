package h.a.b.p;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class i implements Executor {
    public boolean b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1690d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1691f = -1;
    public final BlockingQueue<Runnable> a = new LinkedBlockingQueue();

    public void a() throws IOException {
        b(0);
    }

    public void b(int i2) throws IOException {
        long jNanoTime = System.nanoTime();
        long jConvert = TimeUnit.NANOSECONDS.convert(i2, TimeUnit.MILLISECONDS);
        if (this.f1690d) {
            throw new IllegalStateException("Cannot run loop as an exception has occurred previously.");
        }
        if (this.b) {
            throw new IllegalStateException("Cannot run loop when it is already running.");
        }
        this.b = true;
        while (this.b) {
            if (i2 == 0) {
                try {
                    d(false, 0L).run();
                } catch (InterruptedIOException | RuntimeException e2) {
                    this.b = false;
                    this.f1690d = true;
                    throw e2;
                }
            } else {
                d(true, (jConvert - System.nanoTime()) + jNanoTime).run();
            }
        }
    }

    public void c() {
        this.b = false;
    }

    public final Runnable d(boolean z, long j) throws InterruptedIOException {
        try {
            Runnable runnableTake = !z ? this.a.take() : this.a.poll(j, TimeUnit.NANOSECONDS);
            if (runnableTake != null) {
                return runnableTake;
            }
            throw new SocketTimeoutException();
        } catch (InterruptedException e2) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e2);
            throw interruptedIOException;
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException {
        if (runnable == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.a.put(runnable);
        } catch (InterruptedException e2) {
            throw new RejectedExecutionException(e2);
        }
    }
}
