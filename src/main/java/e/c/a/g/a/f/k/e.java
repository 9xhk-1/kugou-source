package e.c.a.g.a.f.k;

import com.kugou.common.config.v2.KGConfigUpdateEntity;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes.dex */
public interface e {
    @GET
    Call<KGConfigUpdateEntity> call(@QueryMap Map<String, String> map);
}
