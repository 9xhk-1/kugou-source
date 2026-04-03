package e.c.a.g.a.g.n;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.s.u1;
import f.s;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends e.c.a.g.a.d.h.b.e implements View.OnClickListener {
    public f.z.c.a<s> a;
    public f.z.c.a<s> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context, R.style.PopDialogTheme);
        j.e(context, "context");
    }

    public final e a(f.z.c.a<s> aVar) {
        this.b = aVar;
        return this;
    }

    public final e b(f.z.c.a<s> aVar) {
        this.a = aVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "v");
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            f.z.c.a<s> aVar = this.b;
            if (aVar != null) {
                aVar.invoke();
            }
            dismiss();
            return;
        }
        if (id != R.id.tv_confirm) {
            return;
        }
        f.z.c.a<s> aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.invoke();
        }
        dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_set_ringtone);
        u1.b(this, findViewById(R.id.tv_confirm), findViewById(R.id.tv_cancel));
    }
}
