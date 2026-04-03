package e.c.e.c.a;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public static class a implements b {
        @Override // e.c.e.c.a.b
        public void onBufferEnd(int i2, long j) {
        }

        @Override // e.c.e.c.a.b
        public void onBufferStart(int i2, long j) {
        }

        @Override // e.c.e.c.a.b
        public void onBufferingUpdate(int i2, long j, int i3) {
        }

        @Override // e.c.e.c.a.b
        public void onCompletion(int i2, long j) {
        }

        @Override // e.c.e.c.a.b
        public void onSeekComplete(int i2, long j) {
        }

        @Override // e.c.e.c.a.b
        public void onSeekTo(int i2, long j, int i3) {
        }
    }

    void onBufferEnd(int i2, long j);

    void onBufferStart(int i2, long j);

    void onBufferingUpdate(int i2, long j, int i3);

    void onCompletion(int i2, long j);

    void onLoad(int i2, long j);

    void onPause(int i2, long j);

    void onPlay(int i2, long j);

    void onSeekComplete(int i2, long j);

    void onSeekTo(int i2, long j, int i3);
}
