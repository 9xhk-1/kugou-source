package com.kugou.android.watch.lite.base.player.serialize;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class SkipDefaultBooleanTypeAdapter extends TypeAdapter<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Boolean read(JsonReader jsonReader) throws IOException {
        return Boolean.valueOf(jsonReader.nextBoolean());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
        if (bool == null || !bool.booleanValue()) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(true);
        }
    }
}
