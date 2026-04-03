package e.c.a.g.a.s;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static final Gson a = new Gson();

    public static class b implements ParameterizedType {
        public final Type a;

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return new Type[]{this.a};
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return ArrayList.class;
        }

        public b(Type type) {
            this.a = type;
        }
    }

    @Nullable
    public static <T> T a(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (T) a.fromJson(str, (Class) cls);
        } catch (Exception e2) {
            g0.i(e2);
            return null;
        }
    }

    @Nullable
    public static <T> List<T> b(String str, Class<T> cls) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return (List) a.fromJson(str, new b(cls));
            } catch (Exception e2) {
                g0.i(e2);
            }
        }
        return null;
    }

    @NonNull
    public static String c(Object obj) {
        try {
            return a.toJson(obj);
        } catch (Exception e2) {
            g0.i(e2);
            return "";
        }
    }
}
