package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageLite;

/* JADX INFO: loaded from: classes.dex */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    public enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    public enum MessageType {
        PROTO1,
        PROTO2
    }

    public abstract Object fromReflectionType(Object obj);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    public ExtensionType getExtensionType() {
        return ExtensionType.IMMUTABLE;
    }

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }

    @Override // com.google.protobuf.ExtensionLite
    public final boolean isLite() {
        return false;
    }

    public abstract Object singularFromReflectionType(Object obj);

    public abstract Object singularToReflectionType(Object obj);

    public abstract Object toReflectionType(Object obj);
}
