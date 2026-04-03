package com.tencent.tmachine.trace.provider.stacktrace;

import com.tencent.tmachine.trace.core.ErrorExtra;
import f.e0.o;
import f.u.q;
import f.v.a;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class ThreadTracer$innerListener$1 implements IThreadTracerListener {
    public final /* synthetic */ ThreadTracer this$0;

    public ThreadTracer$innerListener$1(ThreadTracer threadTracer) {
        this.this$0 = threadTracer;
    }

    @Override // com.tencent.tmachine.trace.provider.stacktrace.IThreadTracerListener
    public void onDumpSuccess(ThreadTracer threadTracer, ArrayList<StackLink> arrayList, String str) {
        j.f(threadTracer, "threadTracer");
        j.f(str, "tracePath");
        if (arrayList == null) {
            this.this$0.listener.onDumpSuccess(threadTracer, null, str);
            return;
        }
        ArrayList<StackLink> arrayList2 = new ArrayList<>();
        if (arrayList.size() > 1) {
            if (arrayList.size() > 1) {
                q.k(arrayList, new Comparator<T>() { // from class: com.tencent.tmachine.trace.provider.stacktrace.ThreadTracer$innerListener$1$onDumpSuccess$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return a.a(Double.valueOf(((StackLink) t2).getTimeConsume()), Double.valueOf(((StackLink) t).getTimeConsume()));
                    }
                });
            }
            for (StackLink stackLink : arrayList) {
                if (stackLink.getLink().size() > 0) {
                    String str2 = stackLink.getLink().get(0);
                    j.b(str2, "it.link[0]");
                    if (!o.v(str2, "nSyncAndDrawFrame", false, 2, null)) {
                        String str3 = stackLink.getLink().get(0);
                        j.b(str3, "it.link[0]");
                        if (!o.v(str3, "nativePollOnce", false, 2, null)) {
                            arrayList2.add(stackLink);
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0 && arrayList.size() > 0) {
            arrayList2.add(arrayList.get(0));
        }
        this.this$0.listener.onDumpSuccess(threadTracer, arrayList2, str);
    }

    @Override // com.tencent.tmachine.trace.provider.stacktrace.IThreadTracerListener
    public void onError(ThreadTracer threadTracer, ErrorExtra errorExtra) {
        j.f(threadTracer, "threadTracer");
        this.this$0.listener.onError(threadTracer, errorExtra);
    }

    @Override // com.tencent.tmachine.trace.provider.stacktrace.IThreadTracerListener
    public void onStart(ThreadTracer threadTracer) {
        j.f(threadTracer, "threadTracer");
        this.this$0.listener.onStart(threadTracer);
    }

    @Override // com.tencent.tmachine.trace.provider.stacktrace.IThreadTracerListener
    public void onStop(ThreadTracer threadTracer) {
        j.f(threadTracer, "threadTracer");
        this.this$0.listener.onStop(threadTracer);
    }
}
