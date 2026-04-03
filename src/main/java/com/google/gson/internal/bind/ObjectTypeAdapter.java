package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$gson$stream$JsonToken;
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    };
    private final Gson gson;

    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$gson$stream$JsonToken() {
        int[] iArr = $SWITCH_TABLE$com$google$gson$stream$JsonToken;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[JsonToken.valuesCustom().length];
        try {
            iArr2[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[JsonToken.BOOLEAN.ordinal()] = 8;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[JsonToken.END_ARRAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[JsonToken.END_DOCUMENT.ordinal()] = 10;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[JsonToken.END_OBJECT.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[JsonToken.NAME.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[JsonToken.NULL.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[JsonToken.NUMBER.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[JsonToken.STRING.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$com$google$gson$stream$JsonToken = iArr2;
        return iArr2;
    }

    public ObjectTypeAdapter(Gson gson) {
        this.gson = gson;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        int i2 = $SWITCH_TABLE$com$google$gson$stream$JsonToken()[jsonReader.peek().ordinal()];
        if (i2 == 1) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(read(jsonReader));
            }
            jsonReader.endArray();
            return arrayList;
        }
        if (i2 == 3) {
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                linkedTreeMap.put(jsonReader.nextName(), read(jsonReader));
            }
            jsonReader.endObject();
            return linkedTreeMap;
        }
        switch (i2) {
            case 6:
                return jsonReader.nextString();
            case 7:
                return Double.valueOf(jsonReader.nextDouble());
            case 8:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 9:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter adapter = this.gson.getAdapter(obj.getClass());
        if (!(adapter instanceof ObjectTypeAdapter)) {
            adapter.write(jsonWriter, obj);
        } else {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        }
    }
}
