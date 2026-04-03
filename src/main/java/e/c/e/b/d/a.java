package e.c.e.b.d;

import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: e.c.e.b.d.a$a, reason: collision with other inner class name */
    public static class C0221a implements a {
        @Override // e.c.e.b.d.a
        public void onBufferEnd() {
        }

        @Override // e.c.e.b.d.a
        public void onBufferStart() {
        }

        @Override // e.c.e.b.d.a
        public void onBufferingUpdate(int i2) {
        }

        @Override // e.c.e.b.d.a
        public void onCompletion() {
        }

        @Override // e.c.e.b.d.a
        public void onError(int i2, int i3) {
        }

        @Override // e.c.e.b.d.a
        public void onInfo(int i2, int i3) {
        }

        @Override // e.c.e.b.d.a
        public void onInfo(int i2, int i3, String str) {
        }

        @Override // e.c.e.b.d.a
        public void onInfo(int i2, int i3, byte[] bArr) {
        }

        @Override // e.c.e.b.d.a
        public void onPause() {
        }

        @Override // e.c.e.b.d.a
        public void onPlay() {
        }

        @Override // e.c.e.b.d.a
        public void onPlayerMessageReceived(Message message) {
        }

        @Override // e.c.e.b.d.a
        public void onPrepared() {
        }

        @Override // e.c.e.b.d.a
        public void onSeekComplete() {
        }

        @Override // e.c.e.b.d.a
        public void onStop() {
        }
    }

    void onBufferEnd();

    void onBufferStart();

    void onBufferingUpdate(int i2);

    void onCompletion();

    void onError(int i2, int i3);

    void onInfo(int i2, int i3);

    void onInfo(int i2, int i3, String str);

    void onInfo(int i2, int i3, byte[] bArr);

    void onPause();

    void onPlay();

    void onPlayerMessageReceived(Message message);

    void onPrepared();

    void onSeekComplete();

    void onStop();
}
