package com.google.gson;

import com.google.gson.callback.ErrorValueException;
import com.google.gson.callback.ISyncDeserializeCallback;
import com.google.gson.callback.MsgDeserialize;
import com.google.gson.callback.NecessaryFieldException;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public abstract class SafeGson {
    private static final ThreadLocal<MsgDeserialize> threadLocalOfDeserialize = new ThreadLocal<>();

    private static void assertFullConsumption(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                } else {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    public static boolean compatibleErrorValue() {
        return true;
    }

    public static MsgDeserialize getThreadMsgDeserialize() {
        return threadLocalOfDeserialize.get();
    }

    public static boolean isDebug() {
        return false;
    }

    public static boolean isEnableNecessaryField() {
        return true;
    }

    public static void log(String str, String str2) {
        System.out.println("----------");
        System.out.println(String.valueOf(str) + " - " + str2);
        System.out.println("----------");
    }

    public static void missNecessary(String str, Throwable th) throws NecessaryFieldException {
        MsgDeserialize msgDeserialize = threadLocalOfDeserialize.get();
        if (msgDeserialize == null || !isEnableNecessaryField()) {
            return;
        }
        msgDeserialize.missNecessary();
        msgDeserialize.appendMsgNecessary(str);
        throw new NecessaryFieldException(msgDeserialize.getMsgNecessary().toString(), th);
    }

    public static MsgDeserialize putErrorValue(int i2, Throwable th) {
        MsgDeserialize msgDeserialize;
        if (th != null) {
            msgDeserialize = threadLocalOfDeserialize.get();
            if (msgDeserialize != null) {
                if (msgDeserialize.hasTypeError(i2)) {
                    msgDeserialize.putThrowable(th);
                    msgDeserialize.setHasTypeError();
                }
                if (msgDeserialize.isJsonSyntaxError(i2)) {
                    msgDeserialize.putThrowable(th);
                    msgDeserialize.setJsonSyntaxError();
                }
            }
        } else {
            msgDeserialize = null;
        }
        if (msgDeserialize == null || compatibleErrorValue()) {
            return msgDeserialize;
        }
        throw new ErrorValueException(th);
    }

    public <T> T fromJson(String str, Class<T> cls, ISyncDeserializeCallback<T> iSyncDeserializeCallback) {
        return (T) Primitives.wrap(cls).cast(fromJson(str, (Type) cls, (ISyncDeserializeCallback) iSyncDeserializeCallback));
    }

    public abstract <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken);

    public abstract JsonReader newJsonReader(Reader reader);

    public <T> T fromJson(String str, Type type, ISyncDeserializeCallback<T> iSyncDeserializeCallback) {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), type, iSyncDeserializeCallback);
    }

    public static void log(String str) {
        System.out.println("----------");
        System.out.println(str);
        System.out.println("----------");
    }

    private <T> T fromJson(Reader reader, Type type, ISyncDeserializeCallback<T> iSyncDeserializeCallback) {
        return (T) fromJson(newJsonReader(reader), type, iSyncDeserializeCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> T fromJson(com.google.gson.stream.JsonReader r7, java.lang.reflect.Type r8, com.google.gson.callback.ISyncDeserializeCallback<T> r9) {
        /*
            r6 = this;
            boolean r0 = r7.isLenient()
            r1 = 1
            r7.setLenient(r1)
            com.google.gson.callback.MsgDeserialize r2 = new com.google.gson.callback.MsgDeserialize
            r2.<init>()
            java.lang.ThreadLocal<com.google.gson.callback.MsgDeserialize> r3 = com.google.gson.SafeGson.threadLocalOfDeserialize
            r3.set(r2)
            r4 = 8
            r5 = 0
            r7.peek()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 com.google.gson.callback.NecessaryFieldException -> L3c com.google.gson.JsonIOException -> L49 java.lang.IllegalStateException -> L53 com.google.gson.JsonSyntaxException -> L5d java.io.EOFException -> L67
            r1 = 0
            com.google.gson.reflect.TypeToken r8 = com.google.gson.reflect.TypeToken.get(r8)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 com.google.gson.callback.NecessaryFieldException -> L3c com.google.gson.JsonIOException -> L49 java.lang.IllegalStateException -> L53 com.google.gson.JsonSyntaxException -> L5d java.io.EOFException -> L67
            com.google.gson.TypeAdapter r8 = r6.getAdapter(r8)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 com.google.gson.callback.NecessaryFieldException -> L3c com.google.gson.JsonIOException -> L49 java.lang.IllegalStateException -> L53 com.google.gson.JsonSyntaxException -> L5d java.io.EOFException -> L67
            java.lang.Object r8 = r8.read(r7)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 com.google.gson.callback.NecessaryFieldException -> L3c com.google.gson.JsonIOException -> L49 java.lang.IllegalStateException -> L53 com.google.gson.JsonSyntaxException -> L5d java.io.EOFException -> L67
            assertFullConsumption(r8, r7)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32 com.google.gson.callback.NecessaryFieldException -> L3c com.google.gson.JsonIOException -> L49 java.lang.IllegalStateException -> L53 com.google.gson.JsonSyntaxException -> L5d java.io.EOFException -> L67
            r7.setLenient(r0)
            r3.set(r5)
            r5 = r8
            goto L7e
        L30:
            r8 = move-exception
            goto L8b
        L32:
            r8 = move-exception
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L30
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L30
            putErrorValue(r4, r1)     // Catch: java.lang.Throwable -> L30
            goto L40
        L3c:
            r8 = move-exception
            log(r8)     // Catch: java.lang.Throwable -> L30
        L40:
            r7.setLenient(r0)
            java.lang.ThreadLocal<com.google.gson.callback.MsgDeserialize> r7 = com.google.gson.SafeGson.threadLocalOfDeserialize
            r7.set(r5)
            goto L7e
        L49:
            r8 = move-exception
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L30
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L30
            putErrorValue(r4, r1)     // Catch: java.lang.Throwable -> L30
            goto L40
        L53:
            r8 = move-exception
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L30
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L30
            putErrorValue(r4, r1)     // Catch: java.lang.Throwable -> L30
            goto L40
        L5d:
            r8 = move-exception
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L30
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L30
            putErrorValue(r4, r1)     // Catch: java.lang.Throwable -> L30
            goto L40
        L67:
            r8 = move-exception
            if (r1 == 0) goto L75
            com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = "string is empty"
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L30
            putErrorValue(r4, r8)     // Catch: java.lang.Throwable -> L30
            goto L40
        L75:
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L30
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L30
            putErrorValue(r4, r1)     // Catch: java.lang.Throwable -> L30
            goto L40
        L7e:
            if (r5 == 0) goto L87
            r2.success()
            r9.onSuccess(r5, r2)
            goto L8a
        L87:
            r9.onFailed(r2)
        L8a:
            return r5
        L8b:
            r7.setLenient(r0)
            java.lang.ThreadLocal<com.google.gson.callback.MsgDeserialize> r7 = com.google.gson.SafeGson.threadLocalOfDeserialize
            r7.set(r5)
            goto L95
        L94:
            throw r8
        L95:
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.SafeGson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type, com.google.gson.callback.ISyncDeserializeCallback):java.lang.Object");
    }

    public static void log(Throwable th) {
        System.out.println("----------");
        th.printStackTrace();
        System.out.println("----------");
    }
}
