package org.apache.http.entity.mime.content;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractContentBody implements ContentBody {
    private final String mediaType;
    private final String mimeType;
    private final String subType;

    public AbstractContentBody(String str) {
        if (str == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        this.mimeType = str;
        int iIndexOf = str.indexOf(47);
        if (iIndexOf != -1) {
            this.mediaType = str.substring(0, iIndexOf);
            this.subType = str.substring(iIndexOf + 1);
        } else {
            this.mediaType = str;
            this.subType = null;
        }
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getSubType() {
        return this.subType;
    }
}
