package h.a.b;

import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends RejectedExecutionException {
    public j() {
        super("Inline execution is prohibited for this request");
    }
}
