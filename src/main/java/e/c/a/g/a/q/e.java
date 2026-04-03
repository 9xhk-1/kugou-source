package e.c.a.g.a.q;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends e.c.a.g.a.d.h.b.e {
    public final String a;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.dismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, String str) {
        super(context, R.style.PopDialogTheme);
        j.e(context, "context");
        j.e(str, "errMsg");
        this.a = str;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_share_fail);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        View viewFindViewById = findViewById(R.id.content_view);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new a());
        }
        TextView textView = (TextView) findViewById(R.id.tv_desc);
        if (textView == null) {
            return;
        }
        textView.setText(this.a);
    }
}
