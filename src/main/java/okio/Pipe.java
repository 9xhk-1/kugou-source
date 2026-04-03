package okio;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class Pipe {
    public final long maxBufferSize;
    public boolean sinkClosed;
    public boolean sourceClosed;
    public final Buffer buffer = new Buffer();
    private final Sink sink = new PipeSink();
    private final Source source = new PipeSource();

    public final class PipeSink implements Sink {
        public final Timeout timeout = new Timeout();

        public PipeSink() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (pipe.sinkClosed) {
                    return;
                }
                if (pipe.sourceClosed && pipe.buffer.size() > 0) {
                    throw new IOException("source is closed");
                }
                Pipe pipe2 = Pipe.this;
                pipe2.sinkClosed = true;
                pipe2.buffer.notifyAll();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (pipe.sinkClosed) {
                    throw new IllegalStateException("closed");
                }
                if (pipe.sourceClosed && pipe.buffer.size() > 0) {
                    throw new IOException("source is closed");
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sinkClosed) {
                    throw new IllegalStateException("closed");
                }
                while (j > 0) {
                    Pipe pipe = Pipe.this;
                    if (pipe.sourceClosed) {
                        throw new IOException("source is closed");
                    }
                    long size = pipe.maxBufferSize - pipe.buffer.size();
                    if (size == 0) {
                        this.timeout.waitUntilNotified(Pipe.this.buffer);
                    } else {
                        long jMin = Math.min(size, j);
                        Pipe.this.buffer.write(buffer, jMin);
                        j -= jMin;
                        Pipe.this.buffer.notifyAll();
                    }
                }
            }
        }
    }

    public final class PipeSource implements Source {
        public final Timeout timeout = new Timeout();

        public PipeSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sourceClosed) {
                    throw new IllegalStateException("closed");
                }
                while (Pipe.this.buffer.size() == 0) {
                    Pipe pipe = Pipe.this;
                    if (pipe.sinkClosed) {
                        return -1L;
                    }
                    this.timeout.waitUntilNotified(pipe.buffer);
                }
                long j2 = Pipe.this.buffer.read(buffer, j);
                Pipe.this.buffer.notifyAll();
                return j2;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j) {
        if (j >= 1) {
            this.maxBufferSize = j;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j);
    }

    public Sink sink() {
        return this.sink;
    }

    public Source source() {
        return this.source;
    }
}
