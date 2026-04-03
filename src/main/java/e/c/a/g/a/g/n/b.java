package e.c.a.g.a.g.n;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.s.p1;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e.c.a.g.a.d.h.b.e {

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                Intent intent = new Intent("android.settings.SETTINGS");
                intent.addFlags(268435456);
                KGApplication.getContext().startActivity(intent);
                RingBiReportHelper.reportHead$default(RingBiReportHelper.INSTANCE, "前往设置", "RingtoneGuideDialog", null, 4, null);
            } catch (Throwable th) {
                p1.h(b.this.getContext(), "快去设置吧~");
                RingBiReportHelper.reportHead$default(RingBiReportHelper.INSTANCE, j.l("快去设置吧, stack = ", Log.getStackTraceString(th)), "RingtoneGuideDialog", null, 4, null);
            }
            b.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.n.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0149b implements View.OnClickListener {
        public ViewOnClickListenerC0149b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.PopDialogTheme);
        j.e(context, "context");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_ringtone_guide);
        TextView textView = (TextView) findViewById(R.id.tv_content);
        TextView textView2 = (TextView) findViewById(R.id.tv_confirm);
        TextView textView3 = (TextView) findViewById(R.id.tv_cancel);
        if (textView != null) {
            textView.setText("由于手表系统限制，需要前往手表设置完成铃声设置\n路径：设置-> 声音->来电铃声");
        }
        if (textView2 != null) {
            textView2.setOnClickListener(new a());
        }
        if (textView3 == null) {
            return;
        }
        textView3.setOnClickListener(new ViewOnClickListenerC0149b());
    }
}
