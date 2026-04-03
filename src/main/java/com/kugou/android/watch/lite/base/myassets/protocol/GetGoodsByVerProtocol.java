package com.kugou.android.watch.lite.base.myassets.protocol;

import com.kugou.android.watch.lite.common.INoGuard;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r1;
import f.f;
import f.z.d.j;
import f.z.d.k;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes.dex */
public final class GetGoodsByVerProtocol {
    public static final GetGoodsByVerProtocol a = new GetGoodsByVerProtocol();
    public static final f.d b = f.b(e.a);

    public static final class Data implements INoGuard {
        private final List<Good> goods;
        private int last_version;
        private final int total;

        public Data(List<Good> list, int i2, int i3) {
            j.e(list, "goods");
            this.goods = list;
            this.last_version = i2;
            this.total = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data data, List list, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                list = data.goods;
            }
            if ((i4 & 2) != 0) {
                i2 = data.last_version;
            }
            if ((i4 & 4) != 0) {
                i3 = data.total;
            }
            return data.copy(list, i2, i3);
        }

        public final List<Good> component1() {
            return this.goods;
        }

        public final int component2() {
            return this.last_version;
        }

        public final int component3() {
            return this.total;
        }

        public final Data copy(List<Good> list, int i2, int i3) {
            j.e(list, "goods");
            return new Data(list, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return j.a(this.goods, data.goods) && this.last_version == data.last_version && this.total == data.total;
        }

        public final List<Good> getGoods() {
            return this.goods;
        }

        public final int getLast_version() {
            return this.last_version;
        }

        public final int getTotal() {
            return this.total;
        }

        public int hashCode() {
            return (((this.goods.hashCode() * 31) + this.last_version) * 31) + this.total;
        }

        public final void setLast_version(int i2) {
            this.last_version = i2;
        }

        public String toString() {
            return "Data(goods=" + this.goods + ", last_version=" + this.last_version + ", total=" + this.total + ')';
        }
    }

    public static final class Good implements INoGuard {
        private final long addtime;
        private final String author_name;
        private final long good_scid;
        private final long id;
        private final String name;
        private final int status;
        private final String type;

        public Good(long j, long j2, String str, String str2, long j3, String str3, int i2) {
            j.e(str, "type");
            j.e(str2, "author_name");
            j.e(str3, "name");
            this.addtime = j;
            this.id = j2;
            this.type = str;
            this.author_name = str2;
            this.good_scid = j3;
            this.name = str3;
            this.status = i2;
        }

        public final long component1() {
            return this.addtime;
        }

        public final long component2() {
            return this.id;
        }

        public final String component3() {
            return this.type;
        }

        public final String component4() {
            return this.author_name;
        }

        public final long component5() {
            return this.good_scid;
        }

        public final String component6() {
            return this.name;
        }

        public final int component7() {
            return this.status;
        }

        public final Good copy(long j, long j2, String str, String str2, long j3, String str3, int i2) {
            j.e(str, "type");
            j.e(str2, "author_name");
            j.e(str3, "name");
            return new Good(j, j2, str, str2, j3, str3, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Good)) {
                return false;
            }
            Good good = (Good) obj;
            return this.addtime == good.addtime && this.id == good.id && j.a(this.type, good.type) && j.a(this.author_name, good.author_name) && this.good_scid == good.good_scid && j.a(this.name, good.name) && this.status == good.status;
        }

        public final long getAddtime() {
            return this.addtime;
        }

        public final String getAuthor_name() {
            return this.author_name;
        }

        public final long getGood_scid() {
            return this.good_scid;
        }

        public final long getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final int getStatus() {
            return this.status;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            long j = this.addtime;
            long j2 = this.id;
            int iHashCode = ((((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.type.hashCode()) * 31) + this.author_name.hashCode()) * 31;
            long j3 = this.good_scid;
            return ((((iHashCode + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.name.hashCode()) * 31) + this.status;
        }

        public String toString() {
            return "Good(addtime=" + this.addtime + ", id=" + this.id + ", type=" + this.type + ", author_name=" + this.author_name + ", good_scid=" + this.good_scid + ", name=" + this.name + ", status=" + this.status + ')';
        }
    }

    public static final class GoodsSongResponse implements INoGuard {
        private final Data data;
        private final int error_code;
        private final String message;
        private final int status;

        public GoodsSongResponse(Data data, int i2, String str, int i3) {
            j.e(data, "data");
            j.e(str, "message");
            this.data = data;
            this.error_code = i2;
            this.message = str;
            this.status = i3;
        }

        public static /* synthetic */ GoodsSongResponse copy$default(GoodsSongResponse goodsSongResponse, Data data, int i2, String str, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                data = goodsSongResponse.data;
            }
            if ((i4 & 2) != 0) {
                i2 = goodsSongResponse.error_code;
            }
            if ((i4 & 4) != 0) {
                str = goodsSongResponse.message;
            }
            if ((i4 & 8) != 0) {
                i3 = goodsSongResponse.status;
            }
            return goodsSongResponse.copy(data, i2, str, i3);
        }

        public final Data component1() {
            return this.data;
        }

        public final int component2() {
            return this.error_code;
        }

        public final String component3() {
            return this.message;
        }

        public final int component4() {
            return this.status;
        }

        public final GoodsSongResponse copy(Data data, int i2, String str, int i3) {
            j.e(data, "data");
            j.e(str, "message");
            return new GoodsSongResponse(data, i2, str, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GoodsSongResponse)) {
                return false;
            }
            GoodsSongResponse goodsSongResponse = (GoodsSongResponse) obj;
            return j.a(this.data, goodsSongResponse.data) && this.error_code == goodsSongResponse.error_code && j.a(this.message, goodsSongResponse.message) && this.status == goodsSongResponse.status;
        }

        public final Data getData() {
            return this.data;
        }

        public final int getError_code() {
            return this.error_code;
        }

        public final String getMessage() {
            return this.message;
        }

        public final int getStatus() {
            return this.status;
        }

        public int hashCode() {
            return (((((this.data.hashCode() * 31) + this.error_code) * 31) + this.message.hashCode()) * 31) + this.status;
        }

        public String toString() {
            return "GoodsSongResponse(data=" + this.data + ", error_code=" + this.error_code + ", message=" + this.message + ", status=" + this.status + ')';
        }
    }

    public interface a {
        @POST
        Call<GoodsSongResponse> getGoodsByVer(@HeaderMap Map<String, String> map, @QueryMap(encoded = true) Map<String, String> map2, @Body RequestBody requestBody);
    }

    public static final class b<T, R> implements Func1 {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f49d;

        public b(int i2, int i3, String str) {
            this.a = i2;
            this.b = i3;
            this.f49d = str;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GoodsSongResponse call(Integer num) {
            return GetGoodsByVerProtocol.a.c(this.a, this.b, this.f49d);
        }
    }

    public static final class c<T, R> implements Func1 {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public c(int i2, String str) {
            this.a = i2;
            this.b = str;
        }

        public final GoodsSongResponse a(GoodsSongResponse goodsSongResponse) throws JSONException {
            int i2;
            if (goodsSongResponse != null) {
                int i3 = this.a;
                String str = this.b;
                int total = goodsSongResponse.getData().getTotal();
                GetGoodsByVerProtocol getGoodsByVerProtocol = GetGoodsByVerProtocol.a;
                int iD = total > getGoodsByVerProtocol.d() ? getGoodsByVerProtocol.d() : goodsSongResponse.getData().getTotal();
                List<Good> goods = goodsSongResponse.getData().getGoods();
                if (iD > goods.size() && 1 < (i2 = (iD / 50) + 1)) {
                    int i4 = 1;
                    do {
                        i4++;
                        GoodsSongResponse goodsSongResponseC = GetGoodsByVerProtocol.a.c(i3, i4, str);
                        if (goodsSongResponseC != null && (goodsSongResponseC.getData().getGoods().isEmpty() ^ true)) {
                            goods.addAll(goodsSongResponseC.getData().getGoods());
                        }
                        if (!(goodsSongResponseC != null && goodsSongResponseC.getData().getLast_version() == 0)) {
                            goodsSongResponse.getData().setLast_version(goodsSongResponseC != null ? goodsSongResponseC.getData().getLast_version() : 0);
                        }
                    } while (i4 < i2);
                }
            }
            return goodsSongResponse;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) throws JSONException {
            GoodsSongResponse goodsSongResponse = (GoodsSongResponse) obj;
            a(goodsSongResponse);
            return goodsSongResponse;
        }
    }

    public static final class d<T, R> implements Func1 {
        public static final d<T, R> a = new d<>();

        public final GoodsSongResponse a(GoodsSongResponse goodsSongResponse) {
            if (!e.c.a.g.a.f.m.b.m().E()) {
                e.c.a.g.a.f.m.b.m().d0(true);
            }
            e.c.a.g.a.f.m.b.m().e0(goodsSongResponse == null ? 0 : goodsSongResponse.getData().getLast_version());
            return goodsSongResponse;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            GoodsSongResponse goodsSongResponse = (GoodsSongResponse) obj;
            a(goodsSongResponse);
            return goodsSongResponse;
        }
    }

    public static final class e extends k implements f.z.c.a<Integer> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        public final int a() {
            return e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.o4, 10000);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(a());
        }
    }

    public final Observable<GoodsSongResponse> b(int i2, int i3, String str) {
        j.e(str, "kgTid");
        Observable<GoodsSongResponse> map = Observable.just(0).map(new b(i2, i3, str)).map(new c(i2, str)).map(d.a);
        j.d(map, "version: Int, fromPage: Int,kgTid:String): Observable<GoodsSongResponse?> {\n        return Observable.just(0).map {\n            return@map getGoodsByVer(version, fromPage,kgTid)\n        }.map {\n            it?.let{\n                val total = if (it.data.total > userAssertMaxCount) userAssertMaxCount else it.data.total\n                val list = it.data.goods\n                if(total > list.size){\n                    for (i in 1 until total / pageSize + 1){\n                        val response = getGoodsByVer(version, i + 1,kgTid)\n                        if(response?.data?.goods?.isNotEmpty() == true){\n                            list.addAll(response.data.goods)\n                        }\n                        if(response?.data?.last_version != 0){\n                            it.data.last_version = response?.data?.last_version ?: 0\n                        }\n                    }\n                }\n            }\n            return@map it\n        }.map {response ->\n\n            if (!CommonSettingPrefs.getInstance().isUpdateUserGoodsSong) {\n                CommonSettingPrefs.getInstance().isUpdateUserGoodsSong = true\n            }\n            CommonSettingPrefs.getInstance().userGoodsSongVersion = response?.data?.last_version ?: 0\n            return@map response\n        }");
        return map;
    }

    public final GoodsSongResponse c(int i2, int i3, String str) throws JSONException {
        Retrofit retrofitBuild = new Retrofit.Builder().setModuleName("AsssetSong").setMultiUrl(r1.c(e.c.a.g.a.f.e.b.n4, "https://gateway.kugou.com/media.store/v2/audio/get_goods_by_version")).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).setExcludeEndChar().build();
        e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
        cVarZ.c("KG-TID", str);
        Map<String, String> mapE = cVarZ.E();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", l1.f());
        jSONObject.put("userid", e.c.a.g.a.r.b.o());
        jSONObject.put("token", e.c.a.g.a.r.b.n());
        jSONObject.put("page", i3);
        jSONObject.put("pagesize", 50);
        jSONObject.put(ClientCookie.VERSION_ATTR, i2);
        jSONObject.put("clientver", String.valueOf(l1.G()));
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jSONObject.toString());
        j.d(requestBodyCreate, "create(\n            MediaType.parse(\"application/json;charset=utf-8\"),\n            bodyJson.toString()\n        )");
        e.c.a.g.a.r.g.c cVarZ2 = e.c.a.g.a.r.g.c.z();
        cVarZ2.f(new String[0]);
        cVarZ2.i(new String[0]);
        cVarZ2.h(new String[0]);
        cVarZ2.o(new String[0]);
        cVarZ2.m(new String[0]);
        return ((a) retrofitBuild.create(a.class)).getGoodsByVer(mapE, cVarZ2.F(jSONObject.toString()), requestBodyCreate).execute().body();
    }

    public final int d() {
        return ((Number) b.getValue()).intValue();
    }
}
