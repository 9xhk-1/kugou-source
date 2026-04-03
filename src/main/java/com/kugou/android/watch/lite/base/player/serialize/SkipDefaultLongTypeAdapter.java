package com.kugou.android.watch.lite.base.player.serialize;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class SkipDefaultLongTypeAdapter extends TypeAdapter<Number> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Number read(JsonReader jsonReader) throws IOException {
        return Long.valueOf(jsonReader.nextLong());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        if (number == null || number.longValue() == 0) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(number);
        }
    }
}
