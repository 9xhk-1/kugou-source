package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r1 = r8.chars;
        r2 = r8.beg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.end - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String escapedAV() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.beg = r0
            r8.end = r0
        L6:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.chars
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.end
            int r3 = r2 + 1
            r8.end = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L40:
            int r0 = r8.end
            int r2 = r0 + 1
            r8.end = r2
            char r2 = r8.getEscaped()
            r1[r0] = r2
            int r0 = r8.pos
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.end
            r8.cur = r2
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r2 + 1
            r8.end = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L87
            char[] r2 = r8.chars
            char r7 = r2[r0]
            if (r7 != r6) goto L87
            int r1 = r8.end
            int r7 = r1 + 1
            r8.end = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L6e
        L87:
            if (r0 == r1) goto L97
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 == r3) goto L97
            char r2 = r1[r0]
            if (r2 == r4) goto L97
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L97:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.cur
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.DistinguishedNameParser.escapedAV():java.lang.String");
    }

    private int getByte(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        char[] cArr = this.chars;
        char c = cArr[i2];
        if (c >= '0' && c <= '9') {
            i3 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i3 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            i3 = c - '7';
        }
        char c2 = cArr[i5];
        if (c2 >= '0' && c2 <= '9') {
            i4 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i4 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            i4 = c2 - '7';
        }
        return (i3 << 4) + i4;
    }

    private char getEscaped() {
        int i2 = this.pos + 1;
        this.pos = i2;
        if (i2 == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        char[] cArr = this.chars;
        char c = cArr[i2];
        if (c != ' ' && c != '%' && c != '\\' && c != '_' && c != '\"' && c != '#') {
            switch (c) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return getUTF8();
                    }
                    break;
            }
        }
        return cArr[i2];
    }

    private char getUTF8() {
        int i2;
        int i3;
        int i4 = getByte(this.pos);
        this.pos++;
        if (i4 < 128) {
            return (char) i4;
        }
        if (i4 < 192 || i4 > 247) {
            return '?';
        }
        if (i4 <= 223) {
            i3 = i4 & 31;
            i2 = 1;
        } else if (i4 <= 239) {
            i2 = 2;
            i3 = i4 & 15;
        } else {
            i2 = 3;
            i3 = i4 & 7;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = this.pos + 1;
            this.pos = i6;
            if (i6 == this.length || this.chars[i6] != '\\') {
                return '?';
            }
            int i7 = i6 + 1;
            this.pos = i7;
            int i8 = getByte(i7);
            this.pos++;
            if ((i8 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (i8 & 63);
        }
        return (char) i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r6.end = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String hexAV() {
        /*
            r6 = this;
            int r0 = r6.pos
            int r1 = r0 + 4
            int r2 = r6.length
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto La3
            r6.beg = r0
            int r0 = r0 + 1
            r6.pos = r0
        L10:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 == r1) goto L5f
            char[] r1 = r6.chars
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L5f
            char r2 = r1[r0]
            r4 = 44
            if (r2 == r4) goto L5f
            char r2 = r1[r0]
            r4 = 59
            if (r2 != r4) goto L2b
            goto L5f
        L2b:
            char r2 = r1[r0]
            r4 = 32
            if (r2 != r4) goto L48
            r6.end = r0
            int r0 = r0 + 1
            r6.pos = r0
        L37:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 >= r1) goto L61
            char[] r1 = r6.chars
            char r1 = r1[r0]
            if (r1 != r4) goto L61
            int r0 = r0 + 1
            r6.pos = r0
            goto L37
        L48:
            char r2 = r1[r0]
            r5 = 65
            if (r2 < r5) goto L5a
            char r2 = r1[r0]
            r5 = 70
            if (r2 > r5) goto L5a
            char r2 = r1[r0]
            int r2 = r2 + r4
            char r2 = (char) r2
            r1[r0] = r2
        L5a:
            int r0 = r0 + 1
            r6.pos = r0
            goto L10
        L5f:
            r6.end = r0
        L61:
            int r0 = r6.end
            int r1 = r6.beg
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L8c
            r2 = r0 & 1
            if (r2 == 0) goto L8c
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            r4 = 0
            int r1 = r1 + 1
        L74:
            if (r4 >= r2) goto L82
            int r5 = r6.getByte(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L74
        L82:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.chars
            int r3 = r6.beg
            r1.<init>(r2, r3, r0)
            return r1
        L8c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.dn
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.dn
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto Lbb
        Lba:
            throw r0
        Lbb:
            goto Lba
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.DistinguishedNameParser.hexAV():java.lang.String");
    }

    private String nextAT() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        while (true) {
            i2 = this.pos;
            i3 = this.length;
            if (i2 >= i3 || this.chars[i2] != ' ') {
                break;
            }
            this.pos = i2 + 1;
        }
        if (i2 == i3) {
            return null;
        }
        this.beg = i2;
        this.pos = i2 + 1;
        while (true) {
            i4 = this.pos;
            i5 = this.length;
            if (i4 >= i5) {
                break;
            }
            char[] cArr = this.chars;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.pos = i4 + 1;
        }
        if (i4 >= i5) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.end = i4;
        if (this.chars[i4] == ' ') {
            while (true) {
                i6 = this.pos;
                i7 = this.length;
                if (i6 >= i7) {
                    break;
                }
                char[] cArr2 = this.chars;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.pos = i6 + 1;
            }
            if (this.chars[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
        this.pos++;
        while (true) {
            int i8 = this.pos;
            if (i8 >= this.length || this.chars[i8] != ' ') {
                break;
            }
            this.pos = i8 + 1;
        }
        int i9 = this.end;
        int i10 = this.beg;
        if (i9 - i10 > 4) {
            char[] cArr3 = this.chars;
            if (cArr3[i10 + 3] == '.' && ((cArr3[i10] == 'O' || cArr3[i10] == 'o') && ((cArr3[i10 + 1] == 'I' || cArr3[i10 + 1] == 'i') && (cArr3[i10 + 2] == 'D' || cArr3[i10 + 2] == 'd')))) {
                this.beg = i10 + 4;
            }
        }
        char[] cArr4 = this.chars;
        int i11 = this.beg;
        return new String(cArr4, i11, this.end - i11);
    }

    private String quotedAV() {
        int i2 = this.pos + 1;
        this.pos = i2;
        this.beg = i2;
        this.end = i2;
        while (true) {
            int i3 = this.pos;
            if (i3 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            char[] cArr = this.chars;
            if (cArr[i3] == '\"') {
                this.pos = i3 + 1;
                while (true) {
                    int i4 = this.pos;
                    if (i4 >= this.length || this.chars[i4] != ' ') {
                        break;
                    }
                    this.pos = i4 + 1;
                }
                char[] cArr2 = this.chars;
                int i5 = this.beg;
                return new String(cArr2, i5, this.end - i5);
            }
            if (cArr[i3] == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = cArr[i3];
            }
            this.pos++;
            this.end++;
        }
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String strNextAT = nextAT();
        if (strNextAT == null) {
            return null;
        }
        do {
            int i2 = this.pos;
            if (i2 == this.length) {
                return null;
            }
            char c = this.chars[i2];
            String strEscapedAV = c != '\"' ? c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : escapedAV() : hexAV() : quotedAV();
            if (str.equalsIgnoreCase(strNextAT)) {
                return strEscapedAV;
            }
            int i3 = this.pos;
            if (i3 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            this.pos = i3 + 1;
            strNextAT = nextAT();
        } while (strNextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
