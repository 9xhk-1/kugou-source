package com.kugou.common.network.networkutils;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.Header;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.impl.cookie.NetscapeDraftSpec;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public class HttpHeaderParser {
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>() { // from class: com.kugou.common.network.networkutils.HttpHeaderParser.1
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(HttpHeaderParser.UTC);
            return simpleDateFormat;
        }
    };

    public static class HeaderEntry {
        public String etag;
        public String expiresDate;
        public boolean hasCacheControl;
        public Header[] headers;
        public long lastModified;
        public String lastModifiedDate;
        public long serverDate;
        public long serverExpires = 0;
        public boolean mustRevalidate = false;
        public long maxAgeMillis = 0;
        public long staleWhileRevalidate = 0;
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", DateUtils.PATTERN_RFC1036, DateUtils.PATTERN_ASCTIME, NetscapeDraftSpec.EXPIRES_PATTERN, "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = strArr;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[strArr.length];
    }

    public static String getHeaderValueByKey(String str, Header[] headerArr) {
        String value;
        if (headerArr == null) {
            return null;
        }
        for (Header header : headerArr) {
            if (str.equalsIgnoreCase(header.getName()) && (value = header.getValue()) != null) {
                return value.trim();
            }
        }
        return null;
    }

    private static Date parse(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = STANDARD_DATE_FORMAT.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        String[] strArr = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                DateFormat[] dateFormatArr = BROWSER_COMPATIBLE_DATE_FORMATS;
                DateFormat simpleDateFormat = dateFormatArr[i2];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i2], Locale.US);
                    simpleDateFormat.setTimeZone(UTC);
                    dateFormatArr[i2] = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = simpleDateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
            }
            return null;
        }
    }

    public static HeaderEntry parseCacheHeaders(Header[] headerArr) {
        long j;
        long j2;
        long dateAsEpoch;
        long dateAsEpoch2;
        String headerValueByKey = getHeaderValueByKey(HTTP.DATE_HEADER, headerArr);
        long dateAsEpoch3 = headerValueByKey != null ? parseDateAsEpoch(headerValueByKey) : 0L;
        String headerValueByKey2 = getHeaderValueByKey("Cache-Control", headerArr);
        boolean z = true;
        String str = null;
        boolean z2 = false;
        if (headerValueByKey2 != null) {
            boolean z3 = false;
            j = 0;
            j2 = 0;
            for (String str2 : headerValueByKey2.split(",")) {
                String strTrim = str2.trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z3 = true;
                }
            }
            z2 = z3;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String headerValueByKey3 = getHeaderValueByKey("Expires", headerArr);
        if (headerValueByKey3 != null) {
            dateAsEpoch = parseDateAsEpoch(headerValueByKey3);
        } else {
            headerValueByKey3 = null;
            dateAsEpoch = 0;
        }
        String headerValueByKey4 = getHeaderValueByKey("Last-Modified", headerArr);
        if (headerValueByKey4 != null) {
            str = headerValueByKey4;
            dateAsEpoch2 = parseDateAsEpoch(headerValueByKey4);
        } else {
            dateAsEpoch2 = 0;
        }
        String headerValueByKey5 = getHeaderValueByKey("ETag", headerArr);
        boolean z4 = z;
        HeaderEntry headerEntry = new HeaderEntry();
        headerEntry.etag = headerValueByKey5;
        headerEntry.serverDate = dateAsEpoch3;
        headerEntry.lastModifiedDate = str;
        headerEntry.expiresDate = headerValueByKey3;
        headerEntry.serverExpires = dateAsEpoch;
        headerEntry.lastModified = dateAsEpoch2;
        headerEntry.headers = headerArr;
        headerEntry.maxAgeMillis = j * 1000;
        headerEntry.mustRevalidate = z2;
        headerEntry.staleWhileRevalidate = j2;
        headerEntry.hasCacheControl = z4;
        return headerEntry;
    }

    private static long parseDateAsEpoch(String str) {
        try {
            Date date = parse(str);
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }
}
