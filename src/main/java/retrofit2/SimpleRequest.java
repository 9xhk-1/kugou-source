package retrofit2;

import java.util.List;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleRequest extends Retrofit {
    public SimpleRequest(Call.Factory factory, HttpUrl httpUrl, List<Converter.Factory> list, List<CallAdapter.Factory> list2, Executor executor, boolean z, boolean z2, String str, boolean z3) {
        super(factory, httpUrl, list, list2, executor, z, z2, str, z3);
    }
}
