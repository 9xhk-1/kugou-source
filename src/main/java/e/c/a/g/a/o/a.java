package e.c.a.g.a.o;

import com.kugou.android.watch.lite.recommend.entity.SheetMusicListResp;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @GET
    Observable<e.c.a.g.a.o.c.b> getZoneHome(@QueryMap Map<String, String> map);

    @POST
    Observable<SheetMusicListResp> queryMusicSheetList(@HeaderMap Map<String, String> map, @QueryMap Map<String, String> map2, @Body RequestBody requestBody);
}
