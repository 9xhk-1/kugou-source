package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive((Number) l);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive(String.valueOf(l));
        }
    };

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static LongSerializationPolicy[] valuesCustom() {
        LongSerializationPolicy[] longSerializationPolicyArrValuesCustom = values();
        int length = longSerializationPolicyArrValuesCustom.length;
        LongSerializationPolicy[] longSerializationPolicyArr = new LongSerializationPolicy[length];
        System.arraycopy(longSerializationPolicyArrValuesCustom, 0, longSerializationPolicyArr, 0, length);
        return longSerializationPolicyArr;
    }

    public abstract JsonElement serialize(Long l);

    /* synthetic */ LongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this();
    }
}
