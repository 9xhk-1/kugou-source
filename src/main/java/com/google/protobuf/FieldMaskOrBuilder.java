package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface FieldMaskOrBuilder extends MessageOrBuilder {
    String getPaths(int i2);

    ByteString getPathsBytes(int i2);

    int getPathsCount();

    List<String> getPathsList();
}
