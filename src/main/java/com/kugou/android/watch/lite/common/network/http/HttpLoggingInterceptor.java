package com.kugou.android.watch.lite.common.network.http;

import com.kugou.android.watch.lite.common.INoGuard;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class HttpLoggingInterceptor implements Interceptor, INoGuard {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile int level;
    private final a logger;

    public interface a {
        public static final a a = new C0009a();

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.common.network.http.HttpLoggingInterceptor$a$a, reason: collision with other inner class name */
        public class C0009a implements a {
            @Override // com.kugou.android.watch.lite.common.network.http.HttpLoggingInterceptor.a
            public void log(String str) {
                Platform.get().log(4, str, null);
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(a.a);
    }

    private boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get(HTTP.CONTENT_ENCODING);
        return (str == null || str.equalsIgnoreCase(HTTP.IDENTITY_CODING) || str.equalsIgnoreCase("gzip")) ? false : true;
    }

    public static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            for (int i2 = 0; i2 < 16; i2++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int utf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(utf8CodePoint) && !Character.isWhitespace(utf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public int getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        boolean z;
        long j;
        char c;
        String string;
        GzipSource gzipSource;
        boolean z2;
        int i2 = this.level;
        Request request = chain.request();
        if (i2 == 0) {
            return chain.proceed(request);
        }
        boolean z3 = i2 == 3;
        boolean z4 = z3 || i2 == 2;
        RequestBody requestBodyBody = request.body();
        boolean z5 = requestBodyBody != null;
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        sb.append(connection != null ? " " + connection.protocol() : "");
        String string2 = sb.toString();
        if (!z4 && z5) {
            string2 = string2 + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.logger.log(string2);
        if (z4) {
            if (z5) {
                if (requestBodyBody.contentType() != null) {
                    this.logger.log("Content-Type: " + requestBodyBody.contentType());
                }
                if (requestBodyBody.contentLength() != -1) {
                    this.logger.log("Content-Length: " + requestBodyBody.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i3 = 0;
            while (i3 < size) {
                String strName = headers.name(i3);
                int i4 = size;
                if ("Content-Type".equalsIgnoreCase(strName) || "Content-Length".equalsIgnoreCase(strName)) {
                    z2 = z4;
                } else {
                    z2 = z4;
                    this.logger.log(strName + ": " + headers.value(i3));
                }
                i3++;
                size = i4;
                z4 = z2;
            }
            z = z4;
            if (!z3 || !z5) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBodyBody.writeTo(buffer);
                Charset charset = UTF8;
                MediaType mediaTypeContentType = requestBodyBody.contentType();
                if (mediaTypeContentType != null) {
                    charset = mediaTypeContentType.charset(charset);
                }
                this.logger.log("");
                if (isPlaintext(buffer)) {
                    this.logger.log(buffer.readString(charset));
                    this.logger.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z = z4;
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            long jContentLength = responseBodyBody.contentLength();
            String str = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            a aVar = this.logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<-- ");
            sb2.append(responseProceed.code());
            if (responseProceed.message().isEmpty()) {
                j = jContentLength;
                string = "";
                c = ' ';
            } else {
                StringBuilder sb3 = new StringBuilder();
                j = jContentLength;
                c = ' ';
                sb3.append(' ');
                sb3.append(responseProceed.message());
                string = sb3.toString();
            }
            sb2.append(string);
            sb2.append(c);
            sb2.append(responseProceed.request().url());
            sb2.append(" (");
            sb2.append(millis);
            sb2.append("ms");
            sb2.append(z ? "" : ", " + str + " body");
            sb2.append(')');
            aVar.log(sb2.toString());
            if (z) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    this.logger.log(headers2.name(i5) + ": " + headers2.value(i5));
                }
                if (!z3 || !HttpHeaders.hasBody(responseProceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(responseProceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource bufferedSourceSource = responseBodyBody.source();
                    bufferedSourceSource.request(Long.MAX_VALUE);
                    Buffer buffer2 = bufferedSourceSource.buffer();
                    Long l = null;
                    GzipSource gzipSource2 = null;
                    if ("gzip".equalsIgnoreCase(headers2.get(HTTP.CONTENT_ENCODING))) {
                        Long lValueOf = Long.valueOf(buffer2.size());
                        try {
                            gzipSource = new GzipSource(buffer2.clone());
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            gzipSource.close();
                            l = lValueOf;
                        } catch (Throwable th2) {
                            th = th2;
                            gzipSource2 = gzipSource;
                            if (gzipSource2 != null) {
                                gzipSource2.close();
                            }
                            throw th;
                        }
                    }
                    Charset charset2 = UTF8;
                    MediaType mediaTypeContentType2 = responseBodyBody.contentType();
                    if (mediaTypeContentType2 != null) {
                        charset2 = mediaTypeContentType2.charset(charset2);
                    }
                    if (!isPlaintext(buffer2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                        return responseProceed;
                    }
                    if (j != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(charset2));
                    }
                    if (l != null) {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                }
            }
            return responseProceed;
        } catch (Exception e2) {
            this.logger.log("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    public HttpLoggingInterceptor setLevel(int i2) {
        this.level = i2;
        return this;
    }

    public HttpLoggingInterceptor(a aVar) {
        this.level = 3;
        this.logger = aVar;
    }
}
