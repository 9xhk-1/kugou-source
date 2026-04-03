package e.c.a.g.a.r.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.config.util.FileUtil;
import e.c.a.g.a.s.q;
import e.c.a.g.a.s.r1;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String[] a = {"gif", "bmp", "png", "jpg", "jpeg", "webp"};

    /* JADX INFO: renamed from: e.c.a.g.a.r.f.a$a, reason: collision with other inner class name */
    public class C0194a implements Func1<c, c> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f1197d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f1198f;

        public C0194a(boolean z, String str, boolean z2, String str2) {
            this.a = z;
            this.b = str;
            this.f1197d = z2;
            this.f1198f = str2;
        }

        public c a(c cVar) {
            if (this.a) {
                FileUtil.deleteFile(new File(this.b));
            }
            if (this.f1197d) {
                FileUtil.deleteFile(new File(this.f1198f));
            }
            return cVar;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ c call(c cVar) {
            c cVar2 = cVar;
            a(cVar2);
            return cVar2;
        }
    }

    public class b implements Func1<ResponseBody, c> {
        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c call(ResponseBody responseBody) {
            JSONObject jSONObject;
            int iOptInt;
            c cVar = new c();
            try {
                jSONObject = new JSONObject(responseBody.string());
                iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                jSONObject.optInt("error_code");
            } catch (Exception e2) {
                cVar.a = 0;
                e2.printStackTrace();
            }
            if (iOptInt == 0) {
                cVar.a = iOptInt;
                return cVar;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.optString("x-bss-bucket");
                cVar.b = jSONObjectOptJSONObject.optString("x-bss-filename");
                jSONObjectOptJSONObject.optString("x-bss-hash");
                jSONObjectOptJSONObject.optString("x-bss-Etag");
                cVar.a = 1;
            }
            return cVar;
        }
    }

    public static class c {
        public int a;
        public String b;
    }

    public interface d {
        @POST
        Observable<ResponseBody> upload(@QueryMap Map<String, Object> map, @Body RequestBody requestBody);
    }

    public static String a(String str) throws Throwable {
        if (!e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.f647i, true)) {
            return null;
        }
        byte[] bArrN = q.N(str);
        byte b2 = bArrN[8];
        byte b3 = bArrN[9];
        byte b4 = bArrN[10];
        byte b5 = bArrN[11];
        if (b2 == 104 && b3 == 101 && b4 == 105 && b5 == 99) {
            try {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
                String str2 = e.c.a.g.a.f.f.a.f652h + "temp.jpg";
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                bitmapDecodeFile.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return str2;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String[] b() {
        return r1.c(e.c.a.g.a.f.e.b.k, "https://bssul.service.kugou.com/v3/upload");
    }

    public static boolean c(String str) {
        String strZ = q.z(str);
        if (strZ != null) {
            for (String str2 : a) {
                if (strZ.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Observable<c> d(byte[] bArr, String str, String str2, int i2, String str3, String str4, String str5, String[] strArr, MediaType mediaType) {
        Retrofit retrofitBuild = new Retrofit.Builder().setModuleName("Bss").setMultiUrl(strArr).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setExcludeEndChar().build();
        HashMap map = new HashMap();
        map.put("bucket", str);
        map.put("extendname", str2);
        map.put("use_ext", Integer.valueOf(i2));
        map.put("filename", str3);
        map.put("type", str4);
        map.put("authorization", str5);
        map.put("userid", Long.valueOf(e.c.a.g.a.r.b.o()));
        map.put("token", e.c.a.g.a.r.b.n());
        map.put("body_empty", "1");
        e.c.a.g.a.r.g.c.a(map, "");
        return ((d) retrofitBuild.create(d.class)).upload(map, RequestBody.create(mediaType, bArr)).map(new b());
    }

    public static Observable<c> e(String str, String str2, String str3) throws Throwable {
        boolean z;
        String strA = a(str);
        boolean zIsEmpty = TextUtils.isEmpty(strA);
        if (!zIsEmpty) {
            str = strA;
        }
        boolean z2 = !zIsEmpty;
        if (!c(str)) {
            return Observable.error(new IllegalArgumentException("上传文件格式错误"));
        }
        String strC = e.c.a.g.a.r.f.b.c(str, 2097152, 1620, 85);
        if (strC == null) {
            z = false;
            strC = str;
        } else {
            z = true;
        }
        return f(q.N(strC), str2, str.substring(str.lastIndexOf(".") + 1), 1, "", "", str3).map(new C0194a(z, strC, z2, str));
    }

    public static Observable<c> f(byte[] bArr, String str, String str2, int i2, String str3, String str4, String str5) {
        return d(bArr, str, str2, i2, str3, str4, str5, b(), MediaType.parse("image/jpg"));
    }
}
