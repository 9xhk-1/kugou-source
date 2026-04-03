package okhttp3;

import java.io.IOException;
import okio.Timeout;

/* JADX INFO: loaded from: classes2.dex */
public interface Call extends Cloneable {

    /* JADX INFO: loaded from: classes.dex */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    String getStackHash();

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    void setStackHash(String str);

    Timeout timeout();
}
