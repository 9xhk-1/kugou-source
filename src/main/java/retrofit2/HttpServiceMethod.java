package retrofit2;

import com.kugou.framework.lyric.LyricManager;
import f.w.d;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Call;
import okhttp3.ResponseBody;
import org.apache.http.client.methods.HttpHead;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final Call.Factory callFactory;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, ResponseT> responseConverter;

    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        public CallAdapted(RequestFactory requestFactory, Call.Factory factory, CallAdapter<ResponseT, ReturnT> callAdapter, Converter<ResponseBody, ResponseT> converter) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        public ReturnT adapt(OkHttpCall<ResponseT> okHttpCall, Object[] objArr) {
            return this.callAdapter.adapt(okHttpCall);
        }
    }

    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final boolean isNullable;

        public SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, boolean z) {
            super(requestFactory, factory, converter);
            this.isNullable = z;
        }

        @Override // retrofit2.HttpServiceMethod
        public Object adapt(OkHttpCall<ResponseT> okHttpCall, Object[] objArr) {
            d dVar = (d) objArr[objArr.length - 1];
            return this.isNullable ? KotlinExtensions.awaitNullable(okHttpCall, dVar) : KotlinExtensions.await(okHttpCall, dVar);
        }
    }

    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        public SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
            super(requestFactory, factory, converter);
        }

        @Override // retrofit2.HttpServiceMethod
        public Object adapt(OkHttpCall<ResponseT> okHttpCall, Object[] objArr) {
            return KotlinExtensions.awaitResponse(okHttpCall, (d) objArr[objArr.length - 1]);
        }
    }

    public HttpServiceMethod(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.requestFactory = requestFactory;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method) {
        Type genericReturnType = method.getGenericReturnType();
        try {
            return (CallAdapter<ResponseT, ReturnT>) retrofit.callAdapter(genericReturnType, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw Utils.methodError(method, e2, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw Utils.methodError(method, e2, "Unable to create converter for %s", type);
        }
    }

    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory) {
        CallAdapter callAdapterCreateCallAdapter;
        Type typeResponseType;
        boolean z;
        if (requestFactory.isKotlinSuspendFunction) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            z = true;
            typeResponseType = Utils.getParameterLowerBound(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.getRawType(typeResponseType) == Response.class && (typeResponseType instanceof ParameterizedType)) {
                typeResponseType = Utils.getParameterUpperBound(0, (ParameterizedType) typeResponseType);
            } else {
                z = false;
            }
            callAdapterCreateCallAdapter = null;
        } else {
            callAdapterCreateCallAdapter = createCallAdapter(retrofit, method);
            typeResponseType = callAdapterCreateCallAdapter.responseType();
            z = false;
        }
        if (typeResponseType == okhttp3.Response.class) {
            throw Utils.methodError(method, LyricManager.STR_REPLACE_RESULT_TAG + Utils.getRawType(typeResponseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (typeResponseType == Response.class) {
            throw Utils.methodError(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (requestFactory.httpMethod.equals(HttpHead.METHOD_NAME) && !Void.class.equals(typeResponseType)) {
            throw Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        Converter converterCreateResponseConverter = createResponseConverter(retrofit, method, typeResponseType);
        Call.Factory factory = retrofit.callFactory;
        return callAdapterCreateCallAdapter != null ? new CallAdapted(requestFactory, factory, callAdapterCreateCallAdapter, converterCreateResponseConverter) : z ? new SuspendForResponse(requestFactory, factory, converterCreateResponseConverter) : new SuspendForBody(requestFactory, factory, converterCreateResponseConverter, false);
    }

    public abstract ReturnT adapt(OkHttpCall<ResponseT> okHttpCall, Object[] objArr);

    @Override // retrofit2.ServiceMethod
    public final ReturnT invoke(Object[] objArr) {
        return adapt(new OkHttpCall<>(this.requestFactory, objArr, this.callFactory, this.responseConverter), objArr);
    }
}
