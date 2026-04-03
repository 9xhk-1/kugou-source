package com.kugou.common.network.ackutils;

import com.kugou.framework.lyric.LyricManager;
import java.net.URL;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class IPAddressUtil {
    private static final long H_AUTH_DELIMS = 671088641;
    private static final long H_BACKSLASH = 268435456;
    private static final long H_COLON = 0;
    private static final long H_EXCLUDE = -9223372035915251711L;
    private static final long H_GEN_DELIMS = 671088641;
    private static final long H_IPV6_DELIMS = 671088640;
    private static final long H_NON_PRINTABLE = Long.MIN_VALUE;
    private static final long H_SLASH = 0;
    private static final int INADDR16SZ = 16;
    private static final int INADDR4SZ = 4;
    private static final int INT16SZ = 2;
    private static final long L_AUTH_DELIMS = 288230376151711744L;
    private static final long L_BACKSLASH = 0;
    private static final long L_COLON = 288230376151711744L;
    private static final long L_EXCLUDE = -8935000884560003073L;
    private static final long L_GEN_DELIMS = -8935000888854970368L;
    private static final long L_IPV6_DELIMS = 0;
    private static final long L_NON_PRINTABLE = 4294967295L;
    private static final long L_SLASH = 140737488355328L;
    private static final char[] OTHERS = {8263, 8264, 8265, 8448, 8449, 8453, 8454, 10868, 65109, 65110, 65119, 65131, 65283, 65295, 65306, 65311, 65312};

    private static String checkAuth(String str) {
        int iScan = scan(str, -9223231260711714817L, -9223372036586340352L);
        if (iScan < 0) {
            return null;
        }
        return "Illegal character found in authority: " + describeChar(str.charAt(iScan));
    }

    public static String checkAuthority(URL url) {
        if (url == null) {
            return null;
        }
        String userInfo = url.getUserInfo();
        String strCheckUserInfo = checkUserInfo(userInfo);
        if (strCheckUserInfo != null) {
            return strCheckUserInfo;
        }
        String host = url.getHost();
        String strCheckHost = checkHost(host);
        if (strCheckHost != null) {
            return strCheckHost;
        }
        if (host == null && userInfo == null) {
            return checkAuth(url.getAuthority());
        }
        return null;
    }

    public static String checkExternalForm(URL url) {
        if (url == null) {
            return null;
        }
        String userInfo = url.getUserInfo();
        int iScan = scan(userInfo, 140741783322623L, Long.MIN_VALUE);
        if (iScan >= 0) {
            return "Illegal character found in authority: " + describeChar(userInfo.charAt(iScan));
        }
        String strCheckHostString = checkHostString(url.getHost());
        if (strCheckHostString != null) {
            return strCheckHostString;
        }
        return null;
    }

    private static String checkHost(String str) {
        String strSubstring;
        int iScan;
        if (!str.startsWith("[") || !str.endsWith("]")) {
            int iScan2 = scan(str, L_EXCLUDE, H_EXCLUDE);
            if (iScan2 < 0) {
                return null;
            }
            return "Illegal character found in host: " + describeChar(str.charAt(iScan2));
        }
        String strSubstring2 = str.substring(1, str.length() - 1);
        if (!isIPv6LiteralAddress(strSubstring2)) {
            return "Unrecognized IPv6 address format";
        }
        int iIndexOf = strSubstring2.indexOf(37);
        if (iIndexOf < 0 || (iScan = scan((strSubstring = strSubstring2.substring(iIndexOf)), L_NON_PRINTABLE, -9223372036183687168L)) < 0) {
            return null;
        }
        return "Illegal character found in IPv6 scoped address: " + describeChar(strSubstring.charAt(iScan));
    }

    public static String checkHostString(String str) {
        int iScan;
        if (str == null || (iScan = scan(str, 140741783322623L, Long.MIN_VALUE, OTHERS)) < 0) {
            return null;
        }
        return "Illegal character found in host: " + describeChar(str.charAt(iScan));
    }

    private static String checkUserInfo(String str) {
        int iScan = scan(str, -9223231260711714817L, H_EXCLUDE);
        if (iScan < 0) {
            return null;
        }
        return "Illegal character found in user-info: " + describeChar(str.charAt(iScan));
    }

    public static byte[] convertFromIPv4MappedAddress(byte[] bArr) {
        if (!isIPv4MappedAddress(bArr)) {
            return null;
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 12, bArr2, 0, 4);
        return bArr2;
    }

    private static String describeChar(char c) {
        if (c >= ' ' && c != 127) {
            if (c == '\\') {
                return "'\\'";
            }
            return LyricManager.STR_REPLACE_RESULT_TAG + c + LyricManager.STR_REPLACE_RESULT_TAG;
        }
        if (c == '\n') {
            return "LF";
        }
        if (c == '\r') {
            return "CR";
        }
        return "control char (code=" + ((int) c) + ")";
    }

    public static boolean isIPv4LiteralAddress(String str) {
        return textToNumericFormatV4(str) != null;
    }

    private static boolean isIPv4MappedAddress(byte[] bArr) {
        return bArr.length >= 16 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 0 && bArr[6] == 0 && bArr[7] == 0 && bArr[8] == 0 && bArr[9] == 0 && bArr[10] == -1 && bArr[11] == -1;
    }

    public static boolean isIPv6LiteralAddress(String str) {
        return textToNumericFormatV6(str) != null;
    }

    public static boolean match(char c, long j, long j2) {
        return c < '@' ? (j & (1 << c)) != 0 : c < 128 && ((1 << (c - 64)) & j2) != 0;
    }

    public static int scan(String str, long j, long j2) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            boolean zMatch = false;
            int i2 = -1;
            do {
                i2++;
                if (i2 >= length) {
                    break;
                }
                zMatch = match(str.charAt(i2), j, j2);
            } while (!zMatch);
            if (zMatch) {
                return i2;
            }
        }
        return -1;
    }

    public static byte[] textToNumericFormatV4(String str) {
        byte[] bArr = new byte[4];
        int length = str.length();
        if (length != 0 && length <= 15) {
            long j = 0;
            boolean z = true;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '.') {
                    int iDigit = Character.digit(cCharAt, 10);
                    if (iDigit < 0) {
                        return null;
                    }
                    j = (j * 10) + ((long) iDigit);
                    z = false;
                } else {
                    if (z || j < 0 || j > 255 || i2 == 3) {
                        return null;
                    }
                    bArr[i2] = (byte) (j & 255);
                    j = 0;
                    i2++;
                    z = true;
                }
            }
            if (!z && j >= 0 && j < (1 << ((4 - i2) * 8))) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 == 3) {
                            }
                            return bArr;
                        }
                        bArr[3] = (byte) ((j >> 0) & 255);
                        return bArr;
                    }
                    bArr[2] = (byte) ((j >> 8) & 255);
                    bArr[3] = (byte) ((j >> 0) & 255);
                    return bArr;
                }
                bArr[0] = (byte) ((j >> 24) & 255);
                bArr[1] = (byte) ((j >> 16) & 255);
                bArr[2] = (byte) ((j >> 8) & 255);
                bArr[3] = (byte) ((j >> 0) & 255);
                return bArr;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
    
        if (r13 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
    
        if ((r14 + 2) <= 16) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ba, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bb, code lost:
    
        r0 = r14 + 1;
        r4[r14] = (byte) ((r12 >> 8) & 255);
        r14 = r0 + 1;
        r4[r0] = (byte) (r12 & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cb, code lost:
    
        if (r15 == (-1)) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00cd, code lost:
    
        r0 = r14 - r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cf, code lost:
    
        if (r14 != 16) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d2, code lost:
    
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d3, code lost:
    
        if (r10 > r0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d5, code lost:
    
        r5 = (r15 + r0) - r10;
        r4[16 - r10] = r4[r5];
        r4[r5] = 0;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e4, code lost:
    
        r14 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e6, code lost:
    
        if (r14 == 16) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e8, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e9, code lost:
    
        r0 = convertFromIPv4MappedAddress(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ed, code lost:
    
        if (r0 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ef, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00f0, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] textToNumericFormatV6(java.lang.String r16) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.ackutils.IPAddressUtil.textToNumericFormatV6(java.lang.String):byte[]");
    }

    public static int scan(String str, long j, long j2, char[] cArr) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            boolean z = false;
            char c = cArr[0];
            int i2 = -1;
            while (true) {
                i2++;
                if (i2 < length) {
                    char cCharAt = str.charAt(i2);
                    boolean zMatch = match(cCharAt, j, j2);
                    if (!zMatch) {
                        if (cCharAt >= c && Arrays.binarySearch(cArr, cCharAt) > -1) {
                            z = true;
                            break;
                        }
                        z = zMatch;
                    } else {
                        z = zMatch;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                return i2;
            }
        }
        return -1;
    }
}
