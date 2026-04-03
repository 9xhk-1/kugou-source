package com.tencent.tmachine.trace.provider.stacktrace;

import com.tencent.tmachine.trace.core.ErrorExtra;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface IThreadTracerListener {
    void onDumpSuccess(ThreadTracer threadTracer, ArrayList<StackLink> arrayList, String str);

    void onError(ThreadTracer threadTracer, ErrorExtra errorExtra);

    void onStart(ThreadTracer threadTracer);

    void onStop(ThreadTracer threadTracer);
}
