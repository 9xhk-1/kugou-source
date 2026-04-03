package e.c.a.g.a.g.n;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.component.ringtone.RingtoneFragment;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.s.g0;
import f.z.d.j;
import java.io.File;
import java.io.FileInputStream;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public final RingtoneFragment a;
    public final String b;
    public final MediaPlayer c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HandlerC0150c f969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f970e;

    public static final class a implements MediaPlayer.OnErrorListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            c.this.f970e = false;
            return true;
        }
    }

    public static final class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            c.this.f970e = false;
            c.this.a.Z0(false);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.n.c$c, reason: collision with other inner class name */
    public final class HandlerC0150c extends Handler {
        public final /* synthetic */ c a;

        /* JADX INFO: renamed from: e.c.a.g.a.g.n.c$c$a */
        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            public a(c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.Z0(true);
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.g.n.c$c$b */
        public static final class b implements Runnable {
            public final /* synthetic */ c a;

            public b(c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.Z0(false);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0150c(c cVar, Looper looper) {
            super(looper);
            j.e(cVar, "this$0");
            j.e(looper, "looper");
            this.a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j.e(message, NotificationCompat.CATEGORY_MESSAGE);
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                try {
                    this.a.c.stop();
                    this.a.c.reset();
                    this.a.a.n0(new b(this.a));
                    return;
                } catch (Exception e2) {
                    g0.l(e2, true);
                    return;
                }
            }
            try {
                if (TextUtils.isEmpty(this.a.b) || !new File(this.a.b).exists()) {
                    RingBiReportHelper.reportHead$default(RingBiReportHelper.INSTANCE, "数据异常上报", j.l("path = ", this.a.b), null, 4, null);
                    Log.e("RingtonePlayer", j.l("path = ", this.a.b));
                }
                Object obj = message.obj;
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.kugou.android.watch.lite.component.ringtone.RingtonePlayer.OffsetData");
                }
                d dVar = (d) obj;
                this.a.c.reset();
                this.a.c.setDataSource(new FileInputStream(this.a.b).getFD(), dVar.b(), dVar.a() - dVar.b());
                this.a.c.prepare();
                this.a.c.seekTo(dVar.c());
                this.a.c.start();
                this.a.a.n0(new a(this.a));
            } catch (Exception e3) {
                g0.l(e3, true);
            }
        }
    }

    public static final class d {
        public final int a;
        public final int b;
        public final long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f971d;

        public d(int i2, int i3, long j, long j2) {
            this.a = i2;
            this.b = i3;
            this.c = j;
            this.f971d = j2;
        }

        public final long a() {
            return this.f971d;
        }

        public final long b() {
            return this.c;
        }

        public final int c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c && this.f971d == dVar.f971d;
        }

        public int hashCode() {
            int i2 = ((this.a * 31) + this.b) * 31;
            long j = this.c;
            int i3 = (i2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.f971d;
            return i3 + ((int) (j2 ^ (j2 >>> 32)));
        }

        public String toString() {
            return "OffsetData(startTime=" + this.a + ", endTime=" + this.b + ", startByte=" + this.c + ", endByte=" + this.f971d + ')';
        }
    }

    public c(RingtoneFragment ringtoneFragment, String str) {
        j.e(ringtoneFragment, "frag");
        j.e(str, ClientCookie.PATH_ATTR);
        this.a = ringtoneFragment;
        this.b = str;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.c = mediaPlayer;
        Looper looperU = ringtoneFragment.u();
        j.d(looperU, "frag.workLooper");
        this.f969d = new HandlerC0150c(this, looperU);
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnErrorListener(new a());
        mediaPlayer.setOnCompletionListener(new b());
    }

    public final void e() {
        this.c.stop();
        this.c.release();
        this.c.setOnCompletionListener(null);
        this.c.setOnErrorListener(null);
        this.f969d.removeCallbacksAndMessages(null);
    }

    public final boolean f() {
        return this.c.isPlaying();
    }

    public final void g(int i2, int i3, long j, long j2) {
        if (this.f970e) {
            return;
        }
        this.f970e = true;
        this.f969d.removeMessages(1);
        this.f969d.obtainMessage(1, new d(i2, i3, j, j2)).sendToTarget();
    }

    public final void h() {
        if (this.f970e) {
            this.f970e = false;
            this.f969d.removeMessages(1);
            this.f969d.sendEmptyMessage(2);
        }
    }
}
