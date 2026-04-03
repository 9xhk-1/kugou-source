package f.e0;

import f.u.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class o extends n {

    public static final class a extends f.z.d.k implements f.z.c.p<CharSequence, Integer, f.i<? extends Integer, ? extends Integer>> {
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List list, boolean z) {
            super(2);
            this.a = list;
            this.b = z;
        }

        public final f.i<Integer, Integer> a(CharSequence charSequence, int i2) {
            f.z.d.j.e(charSequence, "$receiver");
            f.i iVarW = o.w(charSequence, this.a, i2, this.b, false);
            if (iVarW != null) {
                return f.o.a(iVarW.c(), Integer.valueOf(((String) iVarW.d()).length()));
            }
            return null;
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ f.i<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    public static final class b extends f.z.d.k implements f.z.c.l<f.b0.d, String> {
        public final /* synthetic */ CharSequence a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CharSequence charSequence) {
            super(1);
            this.a = charSequence;
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(f.b0.d dVar) {
            f.z.d.j.e(dVar, "it");
            return o.V(this.a, dVar);
        }
    }

    public static final int A(CharSequence charSequence, String str, int i2, boolean z) {
        f.z.d.j.e(charSequence, "$this$indexOf");
        f.z.d.j.e(str, "string");
        return (z || !(charSequence instanceof String)) ? C(charSequence, str, i2, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i2);
    }

    public static final int B(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        f.b0.b dVar = !z2 ? new f.b0.d(f.b0.f.b(i2, 0), f.b0.f.e(i3, charSequence.length())) : f.b0.f.i(f.b0.f.e(i2, y(charSequence)), f.b0.f.b(i3, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iA = dVar.a();
            int iB = dVar.b();
            int iC = dVar.c();
            if (iC >= 0) {
                if (iA > iB) {
                    return -1;
                }
            } else if (iA < iB) {
                return -1;
            }
            while (!n.o((String) charSequence2, 0, (String) charSequence, iA, charSequence2.length(), z)) {
                if (iA == iB) {
                    return -1;
                }
                iA += iC;
            }
            return iA;
        }
        int iA2 = dVar.a();
        int iB2 = dVar.b();
        int iC2 = dVar.c();
        if (iC2 >= 0) {
            if (iA2 > iB2) {
                return -1;
            }
        } else if (iA2 < iB2) {
            return -1;
        }
        while (!P(charSequence2, 0, charSequence, iA2, charSequence2.length(), z)) {
            if (iA2 == iB2) {
                return -1;
            }
            iA2 += iC2;
        }
        return iA2;
    }

    public static /* synthetic */ int C(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return B(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int D(CharSequence charSequence, char c, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return z(charSequence, c, i2, z);
    }

    public static /* synthetic */ int E(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return A(charSequence, str, i2, z);
    }

    public static final int F(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        boolean z2;
        f.z.d.j.e(charSequence, "$this$indexOfAny");
        f.z.d.j.e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(f.u.i.p(cArr), i2);
        }
        int iB = f.b0.f.b(i2, 0);
        int iY = y(charSequence);
        if (iB > iY) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                if (f.e0.b.d(cArr[i3], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return iB;
            }
            if (iB == iY) {
                return -1;
            }
            iB++;
        }
    }

    public static final int G(CharSequence charSequence, char c, int i2, boolean z) {
        f.z.d.j.e(charSequence, "$this$lastIndexOf");
        return (z || !(charSequence instanceof String)) ? K(charSequence, new char[]{c}, i2, z) : ((String) charSequence).lastIndexOf(c, i2);
    }

    public static final int H(CharSequence charSequence, String str, int i2, boolean z) {
        f.z.d.j.e(charSequence, "$this$lastIndexOf");
        f.z.d.j.e(str, "string");
        return (z || !(charSequence instanceof String)) ? B(charSequence, str, i2, 0, z, true) : ((String) charSequence).lastIndexOf(str, i2);
    }

    public static /* synthetic */ int I(CharSequence charSequence, char c, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = y(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return G(charSequence, c, i2, z);
    }

    public static /* synthetic */ int J(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = y(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return H(charSequence, str, i2, z);
    }

    public static final int K(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        f.z.d.j.e(charSequence, "$this$lastIndexOfAny");
        f.z.d.j.e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(f.u.i.p(cArr), i2);
        }
        for (int iE = f.b0.f.e(i2, y(charSequence)); iE >= 0; iE--) {
            char cCharAt = charSequence.charAt(iE);
            int length = cArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (f.e0.b.d(cArr[i3], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return iE;
            }
        }
        return -1;
    }

    public static final f.d0.b<String> L(CharSequence charSequence) {
        f.z.d.j.e(charSequence, "$this$lineSequence");
        return U(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> M(CharSequence charSequence) {
        f.z.d.j.e(charSequence, "$this$lines");
        return f.d0.i.h(L(charSequence));
    }

    public static final f.d0.b<f.b0.d> N(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new d(charSequence, i2, i3, new a(f.u.h.a(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    public static /* synthetic */ f.d0.b O(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return N(charSequence, strArr, i2, z, i3);
    }

    public static final boolean P(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        f.z.d.j.e(charSequence, "$this$regionMatchesImpl");
        f.z.d.j.e(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!f.e0.b.d(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static final List<String> Q(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        f.z.d.j.e(charSequence, "$this$split");
        f.z.d.j.e(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return R(charSequence, str, z, i2);
            }
        }
        Iterable iterableE = f.d0.i.e(O(charSequence, strArr, 0, z, i2, 2, null));
        ArrayList arrayList = new ArrayList(f.u.n.j(iterableE, 10));
        Iterator it = iterableE.iterator();
        while (it.hasNext()) {
            arrayList.add(V(charSequence, (f.b0.d) it.next()));
        }
        return arrayList;
    }

    public static final List<String> R(CharSequence charSequence, String str, boolean z, int i2) {
        int length = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        int iA = A(charSequence, str, 0, z);
        if (iA == -1 || i2 == 1) {
            return f.u.l.b(charSequence.toString());
        }
        boolean z2 = i2 > 0;
        ArrayList arrayList = new ArrayList(z2 ? f.b0.f.e(i2, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iA).toString());
            length = str.length() + iA;
            if (z2 && arrayList.size() == i2 - 1) {
                break;
            }
            iA = A(charSequence, str, length, z);
        } while (iA != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List S(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return Q(charSequence, strArr, z, i2);
    }

    public static final f.d0.b<String> T(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        f.z.d.j.e(charSequence, "$this$splitToSequence");
        f.z.d.j.e(strArr, "delimiters");
        return f.d0.i.f(O(charSequence, strArr, 0, z, i2, 2, null), new b(charSequence));
    }

    public static /* synthetic */ f.d0.b U(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return T(charSequence, strArr, z, i2);
    }

    public static final String V(CharSequence charSequence, f.b0.d dVar) {
        f.z.d.j.e(charSequence, "$this$substring");
        f.z.d.j.e(dVar, "range");
        return charSequence.subSequence(dVar.getStart().intValue(), dVar.getEndInclusive().intValue() + 1).toString();
    }

    public static final String W(String str, char c, String str2) {
        f.z.d.j.e(str, "$this$substringAfter");
        f.z.d.j.e(str2, "missingDelimiterValue");
        int iD = D(str, c, 0, false, 6, null);
        if (iD == -1) {
            return str2;
        }
        String strSubstring = str.substring(iD + 1, str.length());
        f.z.d.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String X(String str, String str2, String str3) {
        f.z.d.j.e(str, "$this$substringAfter");
        f.z.d.j.e(str2, "delimiter");
        f.z.d.j.e(str3, "missingDelimiterValue");
        int iE = E(str, str2, 0, false, 6, null);
        if (iE == -1) {
            return str3;
        }
        String strSubstring = str.substring(iE + str2.length(), str.length());
        f.z.d.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String Y(String str, char c, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return W(str, c, str2);
    }

    public static /* synthetic */ String Z(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return X(str, str2, str3);
    }

    public static final String a0(String str, char c, String str2) {
        f.z.d.j.e(str, "$this$substringAfterLast");
        f.z.d.j.e(str2, "missingDelimiterValue");
        int I = I(str, c, 0, false, 6, null);
        if (I == -1) {
            return str2;
        }
        String strSubstring = str.substring(I + 1, str.length());
        f.z.d.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String b0(String str, char c, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return a0(str, c, str2);
    }

    public static final CharSequence c0(CharSequence charSequence) {
        f.z.d.j.e(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zC = f.e0.a.c(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final boolean u(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        f.z.d.j.e(charSequence, "$this$contains");
        f.z.d.j.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (E(charSequence, (String) charSequence2, 0, z, 2, null) >= 0) {
                return true;
            }
        } else if (C(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean v(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return u(charSequence, charSequence2, z);
    }

    public static final f.i<Integer, String> w(CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        Object next;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) u.G(collection);
            int iE = !z2 ? E(charSequence, str, i2, false, 4, null) : J(charSequence, str, i2, false, 4, null);
            if (iE < 0) {
                return null;
            }
            return f.o.a(Integer.valueOf(iE), str);
        }
        f.b0.b dVar = !z2 ? new f.b0.d(f.b0.f.b(i2, 0), charSequence.length()) : f.b0.f.i(f.b0.f.e(i2, y(charSequence)), 0);
        if (charSequence instanceof String) {
            int iA = dVar.a();
            int iB = dVar.b();
            int iC = dVar.c();
            if (iC < 0 ? iA >= iB : iA <= iB) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (n.o(str2, 0, (String) charSequence, iA, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (iA == iB) {
                            break;
                        }
                        iA += iC;
                    } else {
                        return f.o.a(Integer.valueOf(iA), str3);
                    }
                }
            }
        } else {
            int iA2 = dVar.a();
            int iB2 = dVar.b();
            int iC2 = dVar.c();
            if (iC2 < 0 ? iA2 >= iB2 : iA2 <= iB2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (P(str4, 0, charSequence, iA2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (iA2 == iB2) {
                            break;
                        }
                        iA2 += iC2;
                    } else {
                        return f.o.a(Integer.valueOf(iA2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static final f.b0.d x(CharSequence charSequence) {
        f.z.d.j.e(charSequence, "$this$indices");
        return new f.b0.d(0, charSequence.length() - 1);
    }

    public static final int y(CharSequence charSequence) {
        f.z.d.j.e(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int z(CharSequence charSequence, char c, int i2, boolean z) {
        f.z.d.j.e(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? F(charSequence, new char[]{c}, i2, z) : ((String) charSequence).indexOf(c, i2);
    }
}
