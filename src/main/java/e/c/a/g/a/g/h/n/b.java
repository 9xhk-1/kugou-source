package e.c.a.g.a.g.h.n;

import android.view.View;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e.c.a.g.a.g.h.a {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DelegateFragment a;

        /* JADX INFO: renamed from: e.c.a.g.a.g.h.n.b$a$a, reason: collision with other inner class name */
        public static final class RunnableC0134a implements Runnable {
            public static final RunnableC0134a a = new RunnableC0134a();

            @Override // java.lang.Runnable
            public final void run() {
                s0.a.p();
            }
        }

        public a(DelegateFragment delegateFragment) {
            this.a = delegateFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            u0.d(this.a.requireActivity(), RunnableC0134a.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(DelegateFragment delegateFragment, View view) {
        super(delegateFragment, view);
        j.e(delegateFragment, "frag");
        j.e(view, "entry");
        view.setOnClickListener(new a(delegateFragment));
    }
}
