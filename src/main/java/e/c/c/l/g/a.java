package e.c.c.l.g;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final Descriptors.Descriptor a;
    public static final GeneratedMessageV3.FieldAccessorTable b;
    public static final Descriptors.Descriptor c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f1265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Descriptors.FileDescriptor f1266e;

    /* JADX INFO: renamed from: e.c.c.l.g.a$a, reason: collision with other inner class name */
    public class C0204a implements Descriptors.FileDescriptor.InternalDescriptorAssigner {
        @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = a.f1266e = fileDescriptor;
            return null;
        }
    }

    public static final class b extends GeneratedMessageV3 implements MessageOrBuilder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f1267d = new b();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Parser<b> f1268f = new C0205a();
        public ByteString a;
        public byte b;

        /* JADX INFO: renamed from: e.c.c.l.g.a$b$a, reason: collision with other inner class name */
        public class C0205a extends AbstractParser<b> {
            @Override // com.google.protobuf.Parser
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new b(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* JADX INFO: renamed from: e.c.c.l.g.a$b$b, reason: collision with other inner class name */
        public static final class C0206b extends GeneratedMessageV3.Builder<C0206b> implements Object {
            public ByteString a;

            public /* synthetic */ C0206b(GeneratedMessageV3.BuilderParent builderParent, C0204a c0204a) {
                this(builderParent);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0206b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (C0206b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b build() {
                b bVarBuildPartial = buildPartial();
                if (bVarBuildPartial.isInitialized()) {
                    return bVarBuildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) bVarBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public b buildPartial() {
                b bVar = new b(this, (C0204a) null);
                bVar.a = this.a;
                onBuilt();
                return bVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                d();
                return this;
            }

            public C0206b d() {
                super.clear();
                this.a = ByteString.EMPTY;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public C0206b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (C0206b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public C0206b clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (C0206b) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public C0206b mo9clone() {
                return (C0206b) super.mo9clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return a.a;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public b getDefaultInstanceForType() {
                return b.c();
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public e.c.c.l.g.a.b.C0206b i(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = e.c.c.l.g.a.b.access$700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    e.c.c.l.g.a$b r3 = (e.c.c.l.g.a.b) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.k(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    e.c.c.l.g.a$b r4 = (e.c.c.l.g.a.b) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.k(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: e.c.c.l.g.a.b.C0206b.i(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):e.c.c.l.g.a$b$b");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return a.b.ensureFieldAccessorsInitialized(b.class, C0206b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public C0206b j(Message message) {
                if (message instanceof b) {
                    k((b) message);
                    return this;
                }
                super.mergeFrom(message);
                return this;
            }

            public C0206b k(b bVar) {
                if (bVar == b.c()) {
                    return this;
                }
                if (bVar.b() != ByteString.EMPTY) {
                    m(bVar.b());
                }
                onChanged();
                return this;
            }

            public final C0206b l(UnknownFieldSet unknownFieldSet) {
                return this;
            }

            public C0206b m(ByteString byteString) {
                Objects.requireNonNull(byteString);
                this.a = byteString;
                onChanged();
                return this;
            }

            public final void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                i(codedInputStream, extensionRegistryLite);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                l(unknownFieldSet);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public C0206b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (C0206b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public C0206b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i2, Object obj) {
                return (C0206b) super.setRepeatedField(fieldDescriptor, i2, obj);
            }

            public final C0206b p(UnknownFieldSet unknownFieldSet) {
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                p(unknownFieldSet);
                return this;
            }

            public /* synthetic */ C0206b(C0204a c0204a) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                d();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message message) {
                j(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                l(unknownFieldSet);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                p(unknownFieldSet);
                return this;
            }

            public C0206b() {
                this.a = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                d();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                i(codedInputStream, extensionRegistryLite);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                l(unknownFieldSet);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                d();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                i(codedInputStream, extensionRegistryLite);
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message message) {
                j(message);
                return this;
            }

            public C0206b(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.a = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                i(codedInputStream, extensionRegistryLite);
                return this;
            }
        }

        public /* synthetic */ b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C0204a c0204a) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static b c() {
            return f1267d;
        }

        public static C0206b e() {
            return f1267d.toBuilder();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return a.a;
        }

        public static Parser<b> parser() {
            return f1268f;
        }

        public ByteString b() {
            return this.a;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b getDefaultInstanceForType() {
            return f1267d;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return !(obj instanceof b) ? super.equals(obj) : b().equals(((b) obj).b());
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public C0206b newBuilderForType() {
            return e();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public C0206b newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new C0206b(builderParent, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<b> getParserForType() {
            return f1268f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeBytesSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeBytesSize(1, this.a);
            this.memoizedSize = iComputeBytesSize;
            return iComputeBytesSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return UnknownFieldSet.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public C0206b toBuilder() {
            C0204a c0204a = null;
            if (this == f1267d) {
                return new C0206b(c0204a);
            }
            C0206b c0206b = new C0206b(c0204a);
            c0206b.k(this);
            return c0206b;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int iHashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + b().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return a.b.ensureFieldAccessorsInitialized(b.class, C0206b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.b;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.b = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.a.isEmpty()) {
                return;
            }
            codedOutputStream.writeBytes(1, this.a);
        }

        public /* synthetic */ b(GeneratedMessageV3.Builder builder, C0204a c0204a) {
            this(builder);
        }

        public b(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.b = (byte) -1;
        }

        public b() {
            this.b = (byte) -1;
            this.a = ByteString.EMPTY;
        }

        public b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag != 10) {
                                    if (!codedInputStream.skipField(tag)) {
                                    }
                                } else {
                                    this.a = codedInputStream.readBytes();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    public static final class c extends GeneratedMessageV3 implements MessageOrBuilder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f1269d = new c();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Parser<c> f1270f = new C0207a();
        public List<b> a;
        public byte b;

        /* JADX INFO: renamed from: e.c.c.l.g.a$c$a, reason: collision with other inner class name */
        public class C0207a extends AbstractParser<c> {
            @Override // com.google.protobuf.Parser
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite, null);
            }
        }

        public static final class b extends GeneratedMessageV3.Builder<b> implements Object {
            public int a;
            public List<b> b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public RepeatedFieldBuilderV3<b, b.C0206b, Object> f1271d;

            public /* synthetic */ b(GeneratedMessageV3.BuilderParent builderParent, C0204a c0204a) {
                this(builderParent);
            }

            public b a(b bVar) {
                RepeatedFieldBuilderV3<b, b.C0206b, Object> repeatedFieldBuilderV3 = this.f1271d;
                if (repeatedFieldBuilderV3 == null) {
                    Objects.requireNonNull(bVar);
                    i();
                    this.b.add(bVar);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(bVar);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public c build() {
                c cVarBuildPartial = buildPartial();
                if (cVarBuildPartial.isInitialized()) {
                    return cVarBuildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) cVarBuildPartial);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                e();
                return this;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public c buildPartial() {
                c cVar = new c(this, (C0204a) null);
                int i2 = this.a;
                RepeatedFieldBuilderV3<b, b.C0206b, Object> repeatedFieldBuilderV3 = this.f1271d;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i2 & 1) == 1) {
                        this.b = Collections.unmodifiableList(this.b);
                        this.a &= -2;
                    }
                    cVar.a = this.b;
                } else {
                    cVar.a = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return cVar;
            }

            public b e() {
                super.clear();
                RepeatedFieldBuilderV3<b, b.C0206b, Object> repeatedFieldBuilderV3 = this.f1271d;
                if (repeatedFieldBuilderV3 == null) {
                    this.b = Collections.emptyList();
                    this.a &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (b) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return a.c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public b mo9clone() {
                return (b) super.mo9clone();
            }

            public final void i() {
                if ((this.a & 1) != 1) {
                    this.b = new ArrayList(this.b);
                    this.a |= 1;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return a.f1265d.ensureFieldAccessorsInitialized(c.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public final RepeatedFieldBuilderV3<b, b.C0206b, Object> j() {
                if (this.f1271d == null) {
                    this.f1271d = new RepeatedFieldBuilderV3<>(this.b, (this.a & 1) == 1, getParentForChildren(), isClean());
                    this.b = null;
                }
                return this.f1271d;
            }

            public List<b> k() {
                RepeatedFieldBuilderV3<b, b.C0206b, Object> repeatedFieldBuilderV3 = this.f1271d;
                return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.b) : repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public c getDefaultInstanceForType() {
                return c.h();
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public e.c.c.l.g.a.c.b m(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = e.c.c.l.g.a.c.e()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    e.c.c.l.g.a$c r3 = (e.c.c.l.g.a.c) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.o(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    e.c.c.l.g.a$c r4 = (e.c.c.l.g.a.c) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.o(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: e.c.c.l.g.a.c.b.m(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):e.c.c.l.g.a$c$b");
            }

            public final void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    j();
                }
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                m(codedInputStream, extensionRegistryLite);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                p(unknownFieldSet);
                return this;
            }

            public b n(Message message) {
                if (message instanceof c) {
                    o((c) message);
                    return this;
                }
                super.mergeFrom(message);
                return this;
            }

            public b o(c cVar) {
                if (cVar == c.h()) {
                    return this;
                }
                if (this.f1271d == null) {
                    if (!cVar.a.isEmpty()) {
                        if (this.b.isEmpty()) {
                            this.b = cVar.a;
                            this.a &= -2;
                        } else {
                            i();
                            this.b.addAll(cVar.a);
                        }
                        onChanged();
                    }
                } else if (!cVar.a.isEmpty()) {
                    if (this.f1271d.isEmpty()) {
                        this.f1271d.dispose();
                        this.f1271d = null;
                        this.b = cVar.a;
                        this.a &= -2;
                        this.f1271d = GeneratedMessageV3.alwaysUseFieldBuilders ? j() : null;
                    } else {
                        this.f1271d.addAllMessages(cVar.a);
                    }
                }
                onChanged();
                return this;
            }

            public final b p(UnknownFieldSet unknownFieldSet) {
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i2, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i2, obj);
            }

            public final b s(UnknownFieldSet unknownFieldSet) {
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                s(unknownFieldSet);
                return this;
            }

            public /* synthetic */ b(C0204a c0204a) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                e();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message message) {
                n(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                p(unknownFieldSet);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                s(unknownFieldSet);
                return this;
            }

            public b() {
                this.b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                e();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                m(codedInputStream, extensionRegistryLite);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                p(unknownFieldSet);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                e();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                m(codedInputStream, extensionRegistryLite);
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message message) {
                n(message);
                return this;
            }

            public b(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                m(codedInputStream, extensionRegistryLite);
                return this;
            }
        }

        public /* synthetic */ c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C0204a c0204a) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return a.c;
        }

        public static c h() {
            return f1269d;
        }

        public static b j() {
            return f1269d.toBuilder();
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return !(obj instanceof c) ? super.equals(obj) : g().equals(((c) obj).g());
        }

        public int f() {
            return this.a.size();
        }

        public List<b> g() {
            return this.a;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<c> getParserForType() {
            return f1270f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeMessageSize = 0;
            for (int i3 = 0; i3 < this.a.size(); i3++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.a.get(i3));
            }
            this.memoizedSize = iComputeMessageSize;
            return iComputeMessageSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return UnknownFieldSet.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (f() > 0) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + g().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public c getDefaultInstanceForType() {
            return f1269d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return a.f1265d.ensureFieldAccessorsInitialized(c.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.b;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.b = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return j();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new b(builderParent, null);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            C0204a c0204a = null;
            if (this == f1269d) {
                return new b(c0204a);
            }
            b bVar = new b(c0204a);
            bVar.o(this);
            return bVar;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                codedOutputStream.writeMessage(1, this.a.get(i2));
            }
        }

        public /* synthetic */ c(GeneratedMessageV3.Builder builder, C0204a c0204a) {
            this(builder);
        }

        public c(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.b = (byte) -1;
        }

        public c() {
            this.b = (byte) -1;
            this.a = Collections.emptyList();
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                if (z) {
                    break;
                }
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag != 10) {
                                if (!codedInputStream.skipField(tag)) {
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.a = new ArrayList();
                                    z2 |= true;
                                }
                                this.a.add((b) codedInputStream.readMessage(b.parser(), extensionRegistryLite));
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.a = Collections.unmodifiableList(this.a);
                    }
                    makeExtensionsImmutable();
                }
            }
        }
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012MobileAction.proto\u0012\u0005proto\"\u001d\n\fMobileAction\u0012\r\n\u0005datas\u0018\u0001 \u0001(\f\"5\n\rMobileActions\u0012$\n\u0007actions\u0018\u0001 \u0003(\u000b2\u0013.proto.MobileActionB8\n&com.com.kugou.datacollect.biimpl.voB\u000eMobileActionVob\u0006proto3"}, new Descriptors.FileDescriptor[0], new C0204a());
        Descriptors.Descriptor descriptor = f().getMessageTypes().get(0);
        a = descriptor;
        b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Datas"});
        Descriptors.Descriptor descriptor2 = f().getMessageTypes().get(1);
        c = descriptor2;
        f1265d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Actions"});
    }

    public static Descriptors.FileDescriptor f() {
        return f1266e;
    }
}
