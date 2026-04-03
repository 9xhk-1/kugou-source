package com.tencent.tmachine.trace.cpu;

import androidx.core.app.NotificationCompat;
import f.z.d.j;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class PseudoException extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PseudoException(String str, Exception exc) {
        super(str, exc);
        j.f(str, NotificationCompat.CATEGORY_MESSAGE);
    }
}
