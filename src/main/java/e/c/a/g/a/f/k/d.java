package e.c.a.g.a.f.k;

import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    @GET
    Call<ResponseBody> call(@QueryMap Map<String, String> map);

    @POST
    Call<ResponseBody> call(@QueryMap Map<String, String> map, @Body RequestBody requestBody);

    @GET
    Observable<ResponseBody> get(@QueryMap Map<String, String> map);

    @POST
    Observable<ResponseBody> post(@QueryMap Map<String, String> map);

    @POST
    Observable<ResponseBody> post(@QueryMap Map<String, String> map, @Body RequestBody requestBody);
}
