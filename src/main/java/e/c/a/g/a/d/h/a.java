package e.c.a.g.a.d.h;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.R;
import com.kugou.uilib.widget.textview.KGUITextView;
import e.c.a.g.a.d.h.b.e;
import e.c.a.g.a.f.o.i.c;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes.dex */
public class a extends e implements View.OnClickListener {
    public final TextView a;
    public final KGUITextView b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final KGUITextView f425d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f426f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f428i;

    public a(@NonNull Context context) {
        this(context, R.style.PopDialogTheme);
    }

    public a a(String str) {
        this.b.setText(str);
        return this;
    }

    public a b(String str) {
        this.f425d.setText(str);
        return this;
    }

    public a c(View.OnClickListener onClickListener) {
        this.f426f = onClickListener;
        return this;
    }

    public a d(View.OnClickListener onClickListener) {
        this.f427h = onClickListener;
        return this;
    }

    public a e(String str) {
        this.a.setText(str);
        return this;
    }

    public a f(int i2) {
        this.a.setGravity(i2);
        return this;
    }

    public a g() {
        this.b.setVisibility(8);
        this.f425d.setCorner(this.f428i);
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        if (u1.g()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            View.OnClickListener onClickListener2 = this.f426f;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else if (id == R.id.tv_confirm && (onClickListener = this.f427h) != null) {
            onClickListener.onClick(view);
        }
        dismiss();
    }

    public a(@NonNull Context context, int i2) {
        super(context, i2);
        this.f428i = l1.c(40.0f);
        setContentView(R.layout.dialog_message);
        c.a().c(3, findViewById(R.id.content_view));
        this.a = (TextView) findViewById(R.id.tv_title);
        KGUITextView kGUITextView = (KGUITextView) findViewById(R.id.tv_cancel);
        this.b = kGUITextView;
        KGUITextView kGUITextView2 = (KGUITextView) findViewById(R.id.tv_confirm);
        this.f425d = kGUITextView2;
        if (kGUITextView != null) {
            kGUITextView.setOnClickListener(this);
        }
        if (kGUITextView2 != null) {
            kGUITextView2.setOnClickListener(this);
        }
    }
}
