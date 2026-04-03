package e.c.a.g.a.s;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.kugou.android.watch.lite.base.application.KGApplication;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t1 implements View.OnTouchListener {
    public final int a = ViewConfiguration.get(KGApplication.getContext()).getScaledPagingTouchSlop();
    public float b = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1224d = 0.0f;

    public abstract void a(View view);

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.b = motionEvent.getX();
            this.f1224d = motionEvent.getY();
            return false;
        }
        if (motionEvent.getAction() != 1 || Math.abs(motionEvent.getX() - this.b) >= this.a || Math.abs(motionEvent.getY() - this.f1224d) >= this.a) {
            return false;
        }
        a(view);
        return false;
    }
}
