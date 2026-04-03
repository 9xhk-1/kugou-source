package org.apache.http.entity.mime;

import com.kugou.framework.libcommon.netcore.BaseConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class HttpMultipart {
    private static final ByteArrayBuffer CR_LF;
    private static final ByteArrayBuffer FIELD_SEP;
    private static final ByteArrayBuffer TWO_DASHES;
    private final String boundary;
    private final Charset charset;
    private final HttpMultipartMode mode;
    private final List<FormBodyPart> parts;
    private final String subType;

    /* JADX INFO: renamed from: org.apache.http.entity.mime.HttpMultipart$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode;

        static {
            int[] iArr = new int[HttpMultipartMode.values().length];
            $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode = iArr;
            try {
                iArr[HttpMultipartMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        Charset charset = MIME.DEFAULT_CHARSET;
        FIELD_SEP = encode(charset, ": ");
        CR_LF = encode(charset, "\r\n");
        TWO_DASHES = encode(charset, BaseConnection.HTTP_REQ_ENTITY_PREFIX);
    }

    public HttpMultipart(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        if (str == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        }
        this.subType = str;
        this.charset = charset == null ? MIME.DEFAULT_CHARSET : charset;
        this.boundary = str2;
        this.parts = new ArrayList();
        this.mode = httpMultipartMode;
    }

    private void doWriteTo(HttpMultipartMode httpMultipartMode, OutputStream outputStream, boolean z) throws IOException {
        ByteArrayBuffer byteArrayBufferEncode = encode(this.charset, getBoundary());
        for (FormBodyPart formBodyPart : this.parts) {
            writeBytes(TWO_DASHES, outputStream);
            writeBytes(byteArrayBufferEncode, outputStream);
            writeBytes(CR_LF, outputStream);
            Header header = formBodyPart.getHeader();
            int i2 = AnonymousClass1.$SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[httpMultipartMode.ordinal()];
            if (i2 == 1) {
                Iterator<MinimalField> it = header.iterator();
                while (it.hasNext()) {
                    writeField(it.next(), outputStream);
                }
            } else if (i2 == 2) {
                writeField(formBodyPart.getHeader().getField("Content-Disposition"), this.charset, outputStream);
                if (formBodyPart.getBody().getFilename() != null) {
                    writeField(formBodyPart.getHeader().getField("Content-Type"), this.charset, outputStream);
                }
            }
            ByteArrayBuffer byteArrayBuffer = CR_LF;
            writeBytes(byteArrayBuffer, outputStream);
            if (z) {
                formBodyPart.getBody().writeTo(outputStream);
            }
            writeBytes(byteArrayBuffer, outputStream);
        }
        ByteArrayBuffer byteArrayBuffer2 = TWO_DASHES;
        writeBytes(byteArrayBuffer2, outputStream);
        writeBytes(byteArrayBufferEncode, outputStream);
        writeBytes(byteArrayBuffer2, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    private static ByteArrayBuffer encode(Charset charset, String str) {
        ByteBuffer byteBufferEncode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(byteBufferEncode.remaining());
        byteArrayBuffer.append(byteBufferEncode.array(), byteBufferEncode.position(), byteBufferEncode.remaining());
        return byteArrayBuffer;
    }

    private static void writeBytes(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) throws IOException {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    private static void writeField(MinimalField minimalField, OutputStream outputStream) throws IOException {
        writeBytes(minimalField.getName(), outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), outputStream);
        writeBytes(CR_LF, outputStream);
    }

    public void addBodyPart(FormBodyPart formBodyPart) {
        if (formBodyPart == null) {
            return;
        }
        this.parts.add(formBodyPart);
    }

    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    public String getBoundary() {
        return this.boundary;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public HttpMultipartMode getMode() {
        return this.mode;
    }

    public String getSubType() {
        return this.subType;
    }

    public long getTotalLength() {
        Iterator<FormBodyPart> it = this.parts.iterator();
        long j = 0;
        while (it.hasNext()) {
            long contentLength = it.next().getBody().getContentLength();
            if (contentLength < 0) {
                return -1L;
            }
            j += contentLength;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            doWriteTo(this.mode, byteArrayOutputStream, false);
            return j + ((long) byteArrayOutputStream.toByteArray().length);
        } catch (IOException unused) {
            return -1L;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        doWriteTo(this.mode, outputStream, true);
    }

    private static void writeBytes(String str, Charset charset, OutputStream outputStream) throws IOException {
        writeBytes(encode(charset, str), outputStream);
    }

    private static void writeBytes(String str, OutputStream outputStream) throws IOException {
        writeBytes(encode(MIME.DEFAULT_CHARSET, str), outputStream);
    }

    private static void writeField(MinimalField minimalField, Charset charset, OutputStream outputStream) throws IOException {
        writeBytes(minimalField.getName(), charset, outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), charset, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    public HttpMultipart(String str, Charset charset, String str2) {
        this(str, charset, str2, HttpMultipartMode.STRICT);
    }

    public HttpMultipart(String str, String str2) {
        this(str, null, str2);
    }
}
