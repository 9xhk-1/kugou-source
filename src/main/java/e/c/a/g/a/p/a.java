package e.c.a.g.a.p;

import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.startAppAPM.task.MemoryReportHelper;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.p0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.q;
import f.z.d.r;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnClickListener {
    public TextView a;

    /* JADX INFO: renamed from: e.c.a.g.a.p.a$a, reason: collision with other inner class name */
    public static final class RunnableC0172a implements Runnable {
        public final /* synthetic */ r<String> b;

        public RunnableC0172a(r<String> rVar) {
            this.b = rVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.c.a.g.a.f.m.b.m().e0(0);
            String strC = a.this.c();
            q.b();
            p0.a();
            String strC2 = a.this.c();
            MemoryReportHelper.INSTANCE.memoryReport2(4, "清除缓存前后对比， beforeData = " + strC + ", afterData = " + strC2 + ", 清除前展示 = " + ((Object) this.b.a));
        }
    }

    public static final class b<T, R> implements Func1 {
        public static final b<T, R> a = new b<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String call(Integer num) {
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            return h1.i(q.r(kGMusicWrapperE == null ? null : kGMusicWrapperE.getFileHashValue())[1]);
        }
    }

    public static final class c<T> implements Action1 {
        public c() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            TextView textView = a.this.a;
            if (textView == null) {
                return;
            }
            textView.setText(str);
        }
    }

    public static final class d<T> implements Action1 {
        public d() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            TextView textView = a.this.a;
            if (textView == null) {
                return;
            }
            textView.setText("0M");
        }
    }

    public a(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        this.a = (TextView) view.findViewById(R.id.tv_cache_size);
        view.findViewById(R.id.clear_cache_entry).setOnClickListener(this);
        d();
    }

    public final String c() {
        try {
            long jH = e.c.a.g.a.f.m.b.m().h(2);
            long j = 1024;
            long jB = (e.c.a.g.a.s.l.b(KGApplication.getContext()) / j) / j;
            long jC = e.c.a.g.a.s.l.c();
            StringBuilder sb = new StringBuilder();
            sb.append(jH);
            sb.append('-');
            sb.append(jC);
            sb.append('-');
            sb.append(jB);
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final void d() {
        Observable.just(1).subscribeOn(Schedulers.io()).map(b.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(), new d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CharSequence text;
        YoungBITask youngBITask = new YoungBITask(20588, "click");
        TextView textView = this.a;
        T string = 0;
        string = 0;
        e.c.a.g.a.e.b.b(youngBITask.setSvar1(String.valueOf(textView == null ? null : textView.getText())));
        r rVar = new r();
        TextView textView2 = this.a;
        if (textView2 != null && (text = textView2.getText()) != null) {
            string = text.toString();
        }
        rVar.a = string;
        j0.b().a(new RunnableC0172a(rVar));
        p1.h(KGApplication.getContext(), "缓存清除成功");
        TextView textView3 = this.a;
        if (textView3 != null) {
            textView3.setText("0M");
        }
        e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("3").setTab(e.c.a.g.a.r.b.F() ? "1" : "0"));
    }
}
