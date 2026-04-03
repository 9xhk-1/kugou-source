package e.c.a.g.a.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.component.SplashActivity;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.r.b;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.y0;
import f.z.d.j;
import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();
    public static final Drawable b = ContextCompat.getDrawable(KGApplication.getContext(), R.drawable.album_img_default);

    /* JADX INFO: renamed from: e.c.a.g.a.m.a$a, reason: collision with other inner class name */
    public static final class C0168a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return f.v.a.a(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
        }
    }

    public String a() {
        try {
            if (!f.o()) {
                return "0";
            }
            KGMusicWrapper kGMusicWrapperE = f.e();
            Long lValueOf = kGMusicWrapperE == null ? null : Long.valueOf(kGMusicWrapperE.getMixId());
            return lValueOf == null ? "0" : lValueOf.toString();
        } catch (Exception e2) {
            Log.e("mhs_watch", j.l("currentMixId = ", e2));
            return "0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(android.content.Context r17, java.lang.String r18, java.lang.String r19, int r20) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.m.a.b(android.content.Context, java.lang.String, java.lang.String, int):boolean");
    }

    public final int c(KGMusicWrapper kGMusicWrapper) {
        return (kGMusicWrapper == null || kGMusicWrapper.getDuration() <= 0) ? f.g() : (int) kGMusicWrapper.getDuration();
    }

    public boolean d() {
        try {
            Log.d("XtcWidgetHelper", j.l("isSafePlaying() -> PlayerController.isPlaying() = ", Boolean.valueOf(f.q())));
            return f.q();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void e() {
        KGApplication.getContext().startActivity(s0.a.a(KGApplication.getContext(), SplashActivity.class));
    }

    public final void f(int i2, int i3) {
        f.E(i3);
    }

    public final void g(int i2, int i3) {
        KGMusicWrapper kGMusicWrapperE = f.e();
        if (kGMusicWrapperE != null) {
            int iC = c(kGMusicWrapperE);
            int i4 = (iC * i2) / i3;
            if (kGMusicWrapperE.isListenPart() && !b.O()) {
                long jB = y0.b(kGMusicWrapperE, 60000L);
                if (i4 < 0 || jB < i4) {
                    f(0 / iC, 0);
                    if (!b.F()) {
                        p1.m("请登录后再尝试操作");
                        return;
                    }
                    p1.m("会员专属歌曲，可试听" + y0.c(kGMusicWrapperE, 30) + (char) 31186);
                    return;
                }
            }
            f(i2, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean h(Context context, String str) {
        j.e(context, "context");
        try {
            if (!l1.m0()) {
                Log.e("XtcWidgetHelper", "writeImage 图片保存失败 不是 xtc");
                return false;
            }
            int iC = l1.c(40.0f);
            RequestBuilder requestBuilderDiskCacheStrategy = Glide.with(KGApplication.getContext()).asBitmap().load(a0.d(str)).diskCacheStrategy(DiskCacheStrategy.ALL);
            Drawable drawable = b;
            Bitmap bitmap = (Bitmap) requestBuilderDiskCacheStrategy.placeholder(drawable).error(drawable).submit(iC, iC).get();
            KGMusicWrapper kGMusicWrapperE = f.e();
            return i(context, "xtc_widget_cover_" + (kGMusicWrapperE == null ? null : Long.valueOf(kGMusicWrapperE.getMixId())) + ".png", bitmap);
        } catch (Exception e2) {
            Log.e("XtcWidgetHelper", "writeImage 图片保存失败", e2);
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf A[PHI: r2
  0x00bf: PHI (r2v3 java.io.FileOutputStream) = (r2v2 java.io.FileOutputStream), (r2v4 java.io.FileOutputStream) binds: [B:34:0x00bc, B:39:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i(android.content.Context r8, java.lang.String r9, android.graphics.Bitmap r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.m.a.i(android.content.Context, java.lang.String, android.graphics.Bitmap):boolean");
    }
}
