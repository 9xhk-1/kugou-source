package e.c.a.g.a.g.j.h;

import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public final int a;
    public Drawable b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f960d;

    public b(int i2, String str, int i3) {
        this.a = i2;
        this.c = str;
        this.b = ContextCompat.getDrawable(KGApplication.getContext(), i3);
    }
}
