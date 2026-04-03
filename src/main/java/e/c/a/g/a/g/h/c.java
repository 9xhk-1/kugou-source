package e.c.a.g.a.g.h;

import android.media.AudioManager;
import android.os.Build;
import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.j1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public final View a;
    public final View b;
    public boolean c = true;

    public class a implements View.OnClickListener {
        public a(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0.a.b();
            e.c.a.g.a.e.b.b(new YoungBITask(HttpStatus.SC_MOVED_TEMPORARILY, "click").setType("1"));
        }
    }

    public c(DelegateFragment delegateFragment, View view) {
        View viewFindViewById = view.findViewById(R.id.audio_identify);
        this.a = viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.audio_identify_sec_entry);
        this.b = viewFindViewById2;
        u1.b(new a(this), viewFindViewById, viewFindViewById2);
        a();
    }

    public void a() {
        boolean z = true;
        boolean configAsBoolean = e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.H1, true);
        this.c = true;
        try {
            if (!j1.a("hasMicrophone") && "157".equals(l1.j())) {
                AudioManager audioManager = (AudioManager) this.a.getContext().getSystemService("audio");
                boolean z2 = (audioManager == null || audioManager.isMicrophoneMute()) ? false : true;
                this.c = z2;
                if (z2 && Build.VERSION.SDK_INT >= 28) {
                    if (audioManager.getMicrophones().size() <= 0) {
                        z = false;
                    }
                    this.c = z;
                } else if (z2) {
                    if (audioManager.getDevices(1).length <= 0) {
                        z = false;
                    }
                    this.c = z;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!configAsBoolean || !this.c) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
        } else if (e.c.a.g.a.f.a.r()) {
            this.a.setVisibility(8);
            this.b.setVisibility(0);
        } else {
            this.a.setVisibility(0);
            this.b.setVisibility(8);
        }
    }
}
