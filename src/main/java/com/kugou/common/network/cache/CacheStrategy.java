package com.kugou.common.network.cache;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.kugou.common.network.KGHttpCache;
import com.kugou.common.network.networkutils.HttpHeaderParser;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* JADX INFO: loaded from: classes2.dex */
public class CacheStrategy {
    private KGHttpCache.Entry entry;
    private HttpHeaderParser.HeaderEntry headerEntry;

    public CacheStrategy(KGHttpCache.Entry entry) {
        this.entry = entry;
        this.headerEntry = HttpHeaderParser.parseCacheHeaders(entry.getResponseHeaders());
    }

    private static boolean hasConditions(Header[] headerArr) {
        return (TextUtils.isEmpty(HttpHeaderParser.getHeaderValueByKey("If-Modified-Since", headerArr)) && TextUtils.isEmpty(HttpHeaderParser.getHeaderValueByKey("If-None-Match", headerArr))) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean canUseCache(long r9) {
        /*
            r8 = this;
            com.kugou.common.network.networkutils.HttpHeaderParser$HeaderEntry r0 = r8.headerEntry
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.kugou.common.network.KGHttpCache$Entry r0 = r8.entry
            org.apache.http.Header[] r0 = r0.getResponseHeaders()
            boolean r0 = hasConditions(r0)
            if (r0 == 0) goto L13
            return r1
        L13:
            com.kugou.common.network.KGHttpCache$Entry r0 = r8.entry
            long r2 = r0.getReceivedResponseMillis()
            long r9 = r9 - r2
            com.kugou.common.network.networkutils.HttpHeaderParser$HeaderEntry r0 = r8.headerEntry
            long r2 = r0.maxAgeMillis
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L25
            goto L43
        L25:
            long r2 = r0.serverExpires
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L42
            long r2 = r0.serverDate
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L37
            com.kugou.common.network.KGHttpCache$Entry r0 = r8.entry
            long r2 = r0.getReceivedResponseMillis()
        L37:
            com.kugou.common.network.networkutils.HttpHeaderParser$HeaderEntry r0 = r8.headerEntry
            long r6 = r0.serverExpires
            long r6 = r6 - r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L42
            r2 = r6
            goto L43
        L42:
            r2 = r4
        L43:
            com.kugou.common.network.networkutils.HttpHeaderParser$HeaderEntry r0 = r8.headerEntry
            boolean r6 = r0.mustRevalidate
            if (r6 != 0) goto L50
            long r6 = r0.staleWhileRevalidate
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L50
            goto L51
        L50:
            r6 = r4
        L51:
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 <= 0) goto L5b
            long r2 = r2 + r6
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 >= 0) goto L5b
            r1 = 1
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.cache.CacheStrategy.canUseCache(long):boolean");
    }

    @Nullable
    public Header createHeaderForCache() {
        HttpHeaderParser.HeaderEntry headerEntry = this.headerEntry;
        if (headerEntry.lastModified != 0) {
            return new BasicHeader("If-Modified-Since", headerEntry.expiresDate);
        }
        if (TextUtils.isEmpty(headerEntry.etag)) {
            return null;
        }
        return new BasicHeader("If-None-Match", this.headerEntry.etag);
    }
}
