package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.SafeGson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.Necessary;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.JsonDefaultVaule;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SafeReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final BoundFieldsBean boundFieldsBean;
        private final ObjectConstructor<T> constructor;

        public Adapter(ObjectConstructor<T> objectConstructor, BoundFieldsBean boundFieldsBean) {
            this.constructor = objectConstructor;
            this.boundFieldsBean = boundFieldsBean;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            T t = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T tConstruct = this.constructor.construct();
            int i2 = 0;
            try {
                try {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        BoundField boundField = this.boundFieldsBean.get(jsonReader.nextName());
                        if (boundField == null || !boundField.deserialized) {
                            jsonReader.skipValue();
                        } else {
                            try {
                                boundField.read(jsonReader, tConstruct);
                                e = null;
                            } catch (JsonSyntaxException e2) {
                                e = e2;
                            } catch (IllegalStateException e3) {
                                e = e3;
                            }
                            if (e != null) {
                                if (boundField.necessary || !jsonReader.hasNext()) {
                                    if (boundField.necessary) {
                                        SafeGson.missNecessary("field " + boundField.name + "type convert failed", e);
                                    }
                                    throw new JsonSyntaxException(e);
                                }
                                jsonReader.skipValue();
                                boundField.setDefaultValue(tConstruct);
                                SafeGson.putErrorValue(4, e);
                                SafeGson.log(e);
                            }
                            if (boundField.necessary) {
                                i2++;
                            }
                        }
                    }
                    if (i2 != this.boundFieldsBean.necessaryCount) {
                        String str = "failed there is some necessary fields has no data:countNecessaryOfJson,countNecessaryOfFields:" + i2 + "," + this.boundFieldsBean.necessaryCount + " T " + tConstruct.getClass().getName();
                        SafeGson.missNecessary(str, null);
                        SafeGson.log(str);
                    } else {
                        t = tConstruct;
                    }
                    jsonReader.endObject();
                    return t;
                } catch (IllegalStateException e4) {
                    throw new JsonSyntaxException(e4);
                }
            } catch (IllegalAccessException e5) {
                throw new AssertionError(e5);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFieldsBean.values()) {
                    if (boundField.writeField(t)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public static abstract class BoundField {
        public final boolean deserialized;
        public final String name;
        public final boolean necessary;
        public final boolean serialized;

        public BoundField(String str, boolean z, boolean z2, boolean z3) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
            this.necessary = z3;
        }

        public abstract void read(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException;

        public abstract void setDefaultValue(Object obj);

        public abstract void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException;

        public abstract boolean writeField(Object obj) throws IllegalAccessException, IOException;
    }

    public static class BoundFieldsBean {
        private final Map<String, BoundField> boundFields = new LinkedHashMap();
        private int necessaryCount;

        public BoundField get(String str) {
            return this.boundFields.get(str);
        }

        public BoundField put(String str, BoundField boundField) {
            return this.boundFields.put(str, boundField);
        }

        public Collection<BoundField> values() {
            return this.boundFields.values();
        }
    }

    public SafeReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private BoundField createBoundField(final Gson gson, final Field field, String str, final TypeToken<?> typeToken, boolean z, boolean z2, boolean z3) {
        final boolean zIsPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter) : null;
        final boolean z4 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        final TypeAdapter<?> typeAdapter2 = typeAdapter;
        return new BoundField(str, z, z2, z3) { // from class: com.google.gson.internal.bind.SafeReflectiveTypeAdapterFactory.1
            @Override // com.google.gson.internal.bind.SafeReflectiveTypeAdapterFactory.BoundField
            public void read(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException {
                Object obj2 = typeAdapter2.read(jsonReader);
                if (obj2 == null && zIsPrimitive) {
                    return;
                }
                field.set(obj, obj2);
            }

            @Override // com.google.gson.internal.bind.SafeReflectiveTypeAdapterFactory.BoundField
            public void setDefaultValue(Object obj) {
                Object defaultVaule;
                try {
                    if (field.get(obj) != null || (defaultVaule = JsonDefaultVaule.getInstance().getDefaultVaule(typeToken.getRawType())) == null) {
                        return;
                    }
                    field.set(obj, defaultVaule);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.google.gson.internal.bind.SafeReflectiveTypeAdapterFactory.BoundField
            public void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
                (z4 ? typeAdapter2 : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, typeToken.getType())).write(jsonWriter, field.get(obj));
            }

            @Override // com.google.gson.internal.bind.SafeReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(Object obj) throws IllegalAccessException, IOException {
                return this.serialized && field.get(obj) != obj;
            }
        };
    }

    private BoundFieldsBean getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        BoundFieldsBean boundFieldsBean = new BoundFieldsBean();
        if (cls.isInterface()) {
            return boundFieldsBean;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean zExcludeField = excludeField(field, true);
                boolean zExcludeField2 = excludeField(field, false);
                if (zExcludeField || zExcludeField2) {
                    boolean z = field.getAnnotation(Necessary.class) != null;
                    field.setAccessible(true);
                    Type typeResolve = C$Gson$Types.resolve(typeToken2.getType(), rawType, field.getGenericType());
                    List<String> fieldNames = getFieldNames(field);
                    BoundField boundFieldPut = null;
                    int i3 = 0;
                    while (i3 < fieldNames.size()) {
                        String str = fieldNames.get(i3);
                        boolean z2 = i3 != 0 ? false : zExcludeField;
                        int i4 = i3;
                        BoundField boundField = boundFieldPut;
                        List<String> list = fieldNames;
                        Field field2 = field;
                        int i5 = i2;
                        boundFieldPut = boundField == null ? boundFieldsBean.put(str, createBoundField(gson, field, str, TypeToken.get(typeResolve), z2, zExcludeField2, z)) : boundField;
                        if (z) {
                            boundFieldsBean.necessaryCount++;
                        }
                        i3 = i4 + 1;
                        zExcludeField = z2;
                        fieldNames = list;
                        field = field2;
                        i2 = i5;
                    }
                    if (boundFieldPut != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundFieldPut.name);
                    }
                }
                i2++;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = typeToken2.getRawType();
        }
        return boundFieldsBean;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String strValue = serializedName.value();
        String[] strArrAlternate = serializedName.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        for (String str : strArrAlternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    public boolean excludeField(Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    public static boolean excludeField(Field field, boolean z, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }
}
