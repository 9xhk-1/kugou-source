package e.c.a.g.a.g.p.c;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.uilib.widget.textview.KGUITextView;
import e.c.a.g.a.d.h.b.e;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.u1;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e implements View.OnClickListener {
    public final TextView a;
    public final KGUITextView b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f1025d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1026f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GestureDetector f1027h;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public d a;

        public a(d dVar) {
            j.e(dVar, "vipPayTipsFirstMessageDialog");
            this.a = dVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            d dVar;
            j.e(motionEvent, "e1");
            j.e(motionEvent2, "e2");
            float x = motionEvent2.getX() - motionEvent.getX();
            if (Math.abs(x) <= Math.abs(motionEvent2.getY() - motionEvent.getY()) || Math.abs(x) <= 20.0f || Math.abs(f2) <= 10.0f) {
                return false;
            }
            if (x <= 0.0f || (dVar = this.a) == null) {
                return true;
            }
            dVar.dismiss();
            return true;
        }
    }

    public /* synthetic */ d(Context context, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? R.style.PopDialogTheme : i2);
    }

    public final d a(View.OnClickListener onClickListener) {
        this.f1025d = onClickListener;
        return this;
    }

    public final d b(String str) {
        TextView textView = this.a;
        j.c(textView);
        textView.setText(str);
        return this;
    }

    public final void c() {
        e.c.a.g.a.e.b.b(new YoungBITask(22020020, "click"));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.f1027h = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "v");
        if (u1.g()) {
            return;
        }
        if (view.getId() == R.id.tv_confirm) {
            View.OnClickListener onClickListener = this.f1025d;
            if (onClickListener != null) {
                j.c(onClickListener);
                onClickListener.onClick(view);
            }
            c();
        }
        dismiss();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        j.e(motionEvent, NotificationCompat.CATEGORY_EVENT);
        try {
            GestureDetector gestureDetector = this.f1027h;
            if (gestureDetector == null) {
                return super.onTouchEvent(motionEvent);
            }
            j.c(gestureDetector);
            if (!gestureDetector.onTouchEvent(motionEvent) && !super.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // e.c.a.g.a.d.h.b.e, android.app.Dialog
    public void show() {
        super.show();
        e.c.a.g.a.e.b.b(new YoungBITask(22020019, "exposure"));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, int i2) {
        super(context, i2);
        j.e(context, "context");
        int iC = l1.c(15.0f);
        this.f1026f = iC;
        setContentView(R.layout.dialog_vip_pay_frist_message);
        e.c.a.g.a.f.o.i.c.a().c(3, findViewById(R.id.content_view));
        TextView textView = (TextView) findViewById(R.id.tv_title);
        this.a = textView;
        KGUITextView kGUITextView = (KGUITextView) findViewById(R.id.tv_confirm);
        this.b = kGUITextView;
        if (kGUITextView != null) {
            kGUITextView.setOnClickListener(this);
        }
        if (kGUITextView != null) {
            kGUITextView.setCorner(iC);
        }
        if (textView != null) {
            textView.setEnabled(false);
        }
        this.f1027h = new GestureDetector(context, new a(this));
    }
}
