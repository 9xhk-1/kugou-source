package com.google.gson.stream;

/* JADX INFO: loaded from: classes.dex */
public enum JsonToken {
    BEGIN_ARRAY,
    END_ARRAY,
    BEGIN_OBJECT,
    END_OBJECT,
    NAME,
    STRING,
    NUMBER,
    BOOLEAN,
    NULL,
    END_DOCUMENT;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static JsonToken[] valuesCustom() {
        JsonToken[] jsonTokenArrValuesCustom = values();
        int length = jsonTokenArrValuesCustom.length;
        JsonToken[] jsonTokenArr = new JsonToken[length];
        System.arraycopy(jsonTokenArrValuesCustom, 0, jsonTokenArr, 0, length);
        return jsonTokenArr;
    }
}
