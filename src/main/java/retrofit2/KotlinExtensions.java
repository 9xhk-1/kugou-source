package retrofit2;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import f.c;
import f.j;
import f.w.d;
import f.w.i.b;
import f.w.j.a.h;
import f.z.d.j;
import g.a.k;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class KotlinExtensions {
    public static final <T> Object await(Call<T> call, d<? super T> dVar) {
        final k kVar = new k(b.c(dVar), 1);
        kVar.invokeOnCancellation(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                j.f(call2, NotificationCompat.CATEGORY_CALL);
                j.f(th, "t");
                g.a.j jVar = kVar;
                j.a aVar = f.j.a;
                Object objA = f.k.a(th);
                f.j.a(objA);
                jVar.resumeWith(objA);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                f.z.d.j.f(call2, NotificationCompat.CATEGORY_CALL);
                f.z.d.j.f(response, "response");
                if (!response.isSuccessful()) {
                    g.a.j jVar = kVar;
                    HttpException httpException = new HttpException(response);
                    j.a aVar = f.j.a;
                    Object objA = f.k.a(httpException);
                    f.j.a(objA);
                    jVar.resumeWith(objA);
                    return;
                }
                T tBody = response.body();
                if (tBody != null) {
                    g.a.j jVar2 = kVar;
                    j.a aVar2 = f.j.a;
                    f.j.a(tBody);
                    jVar2.resumeWith(tBody);
                    return;
                }
                Object objTag = call2.request().tag(Invocation.class);
                if (objTag == null) {
                    f.z.d.j.n();
                    throw null;
                }
                f.z.d.j.b(objTag, "call.request().tag(Invocation::class.java)!!");
                Method method = ((Invocation) objTag).method();
                StringBuilder sb = new StringBuilder();
                sb.append("Response from ");
                f.z.d.j.b(method, "method");
                Class<?> declaringClass = method.getDeclaringClass();
                f.z.d.j.b(declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                c cVar = new c(sb.toString());
                g.a.j jVar3 = kVar;
                j.a aVar3 = f.j.a;
                Object objA2 = f.k.a(cVar);
                f.j.a(objA2);
                jVar3.resumeWith(objA2);
            }
        });
        Object objL = kVar.l();
        if (objL == f.w.i.c.d()) {
            h.c(dVar);
        }
        return objL;
    }

    public static final <T> Object awaitNullable(Call<T> call, d<? super T> dVar) {
        final k kVar = new k(b.c(dVar), 1);
        kVar.invokeOnCancellation(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                f.z.d.j.f(call2, NotificationCompat.CATEGORY_CALL);
                f.z.d.j.f(th, "t");
                g.a.j jVar = kVar;
                j.a aVar = f.j.a;
                Object objA = f.k.a(th);
                f.j.a(objA);
                jVar.resumeWith(objA);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                f.z.d.j.f(call2, NotificationCompat.CATEGORY_CALL);
                f.z.d.j.f(response, "response");
                if (response.isSuccessful()) {
                    g.a.j jVar = kVar;
                    T tBody = response.body();
                    j.a aVar = f.j.a;
                    f.j.a(tBody);
                    jVar.resumeWith(tBody);
                    return;
                }
                g.a.j jVar2 = kVar;
                HttpException httpException = new HttpException(response);
                j.a aVar2 = f.j.a;
                Object objA = f.k.a(httpException);
                f.j.a(objA);
                jVar2.resumeWith(objA);
            }
        });
        Object objL = kVar.l();
        if (objL == f.w.i.c.d()) {
            h.c(dVar);
        }
        return objL;
    }

    public static final <T> Object awaitResponse(Call<T> call, d<? super Response<T>> dVar) {
        final k kVar = new k(b.c(dVar), 1);
        kVar.invokeOnCancellation(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                f.z.d.j.f(call2, NotificationCompat.CATEGORY_CALL);
                f.z.d.j.f(th, "t");
                g.a.j jVar = kVar;
                j.a aVar = f.j.a;
                Object objA = f.k.a(th);
                f.j.a(objA);
                jVar.resumeWith(objA);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                f.z.d.j.f(call2, NotificationCompat.CATEGORY_CALL);
                f.z.d.j.f(response, "response");
                g.a.j jVar = kVar;
                j.a aVar = f.j.a;
                f.j.a(response);
                jVar.resumeWith(response);
            }
        });
        Object objL = kVar.l();
        if (objL == f.w.i.c.d()) {
            h.c(dVar);
        }
        return objL;
    }

    private static final <T> T create(Retrofit retrofit) {
        f.z.d.j.i(4, ExifInterface.GPS_DIRECTION_TRUE);
        throw null;
    }
}
