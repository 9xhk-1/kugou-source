package e.c.a.g.a.s;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
public class h1 {
    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (char c : charArray) {
            char cG = g(c);
            i2 = cG < 128 ? i2 + 1 : cG < 2048 ? i2 + 2 : i2 + 3;
            sb.append(cG);
            if (i2 > 200) {
                break;
            }
        }
        return sb.toString();
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("<em>", "").replace("</em>", "");
    }

    public static String c(@NonNull String str, float f2) {
        if (Build.VERSION.SDK_INT != 25) {
            DecimalFormat decimalFormat = new DecimalFormat(str);
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat.format(f2);
        }
        return String.format("%." + Math.max(1, str.length() - 2) + "f", Float.valueOf(f2));
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replace("\\", "").replace("/", "").replace("*", "").replace("?", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "").replace(RetryStaticsLOG.MARK_SEPERATE, "");
    }

    public static String e(int i2) {
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        return String.format("%s:%s%s", Integer.valueOf(i3), Integer.valueOf(i4 / 10), Integer.valueOf(i4 % 10));
    }

    public static String f(int i2) {
        return String.format("%02d:%02d", Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60));
    }

    public static char g(char c) {
        if (c == '\"') {
            return (char) 65282;
        }
        if (c == '*') {
            return (char) 215;
        }
        if (c == '/') {
            return (char) 65295;
        }
        if (c == ':') {
            return (char) 65306;
        }
        if (c == '<') {
            return (char) 65308;
        }
        if (c == '\\') {
            return (char) 65340;
        }
        if (c == '|') {
            return (char) 65372;
        }
        if (c == '>') {
            return (char) 65310;
        }
        if (c != '?') {
            return c;
        }
        return (char) 65311;
    }

    public static String h(String str, int i2) {
        return (TextUtils.isEmpty(str) || str.length() < i2) ? str : str.substring(0, i2 - 1);
    }

    public static String i(long j) {
        if (j <= 0) {
            return "0M";
        }
        if (j > 0 && j < 102.4d) {
            return c("#.#", 0.1f) + "K";
        }
        if (j < 102.4d || j >= 1048576) {
            return c("#.#", (j / 1024.0f) / 1024.0f) + "M";
        }
        return c("#.#", j / 1024.0f) + "K";
    }

    public static String j(String str) {
        try {
            BigInteger bigInteger = new BigInteger("0");
            BigInteger bigInteger2 = new BigInteger("16");
            String strE = new e.c.c.o.i().e(str);
            int length = strE.length();
            for (int i2 = 0; i2 < length; i2++) {
                bigInteger = bigInteger.add(new BigInteger("" + strE.charAt(i2), 16).multiply(bigInteger2.pow((length - 1) - i2)));
            }
            return bigInteger.toString();
        } catch (Exception unused) {
            return "0";
        }
    }

    public static boolean k(String str) {
        return TextUtils.isEmpty(str) || "null".equals(str);
    }

    public static boolean l(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("[+-]?[1-9]+[0-9]*(\\.[0-9]+)?");
    }

    public static boolean m(String str) {
        return str == null || str.trim().replace(" ", "").length() == 0;
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^1[3-9][0-9]{9}$");
    }

    public static boolean o(String str, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static CharSequence p(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll("<em>", "<font color=" + i2 + ">").replaceAll("</em>", "</font>");
    }

    public static String q(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    public static e.c.a.g.a.f.j.a.e r(String str) {
        String str2;
        e.c.a.g.a.f.j.a.e eVar = new e.c.a.g.a.f.j.a.e();
        String str3 = "";
        String strSubstring = str;
        while (true) {
            try {
                int iIndexOf = strSubstring.indexOf("【");
                if (iIndexOf == -1) {
                    str2 = str3 + strSubstring;
                    break;
                }
                int iIndexOf2 = strSubstring.indexOf("】", iIndexOf);
                if (iIndexOf >= iIndexOf2) {
                    str2 = str3 + strSubstring;
                    break;
                }
                str3 = str3 + strSubstring.substring(0, iIndexOf);
                strSubstring = strSubstring.substring(iIndexOf2 + 1, strSubstring.length());
            } catch (Exception unused) {
                eVar.c(str);
                eVar.d(str);
            }
        }
        eVar.c(str2);
        eVar.d(str);
        return eVar;
    }

    public static String[] s(String str) {
        return t(str, ",");
    }

    public static String[] t(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.split(str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int u(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return i2;
    }

    public static long v(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
            }
        }
        return j;
    }

    public static String w(String str) {
        return str;
    }

    public static String x(String str) {
        if (k(str)) {
            return str;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\\') {
                i2 = i3 + 1;
                char cCharAt2 = str.charAt(i3);
                if (cCharAt2 == 'u') {
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < 4) {
                        int i6 = i2 + 1;
                        char cCharAt3 = str.charAt(i2);
                        switch (cCharAt3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i5 = ((i5 << 4) + cCharAt3) - 48;
                                break;
                            default:
                                switch (cCharAt3) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        i5 = (((i5 << 4) + 10) + cCharAt3) - 65;
                                        break;
                                    default:
                                        switch (cCharAt3) {
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                i5 = (((i5 << 4) + 10) + cCharAt3) - 97;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                        }
                                        break;
                                }
                                break;
                        }
                        i4++;
                        i2 = i6;
                    }
                    stringBuffer.append((char) i5);
                } else {
                    if (cCharAt2 == 't') {
                        cCharAt2 = '\t';
                    } else if (cCharAt2 == 'r') {
                        cCharAt2 = '\r';
                    } else if (cCharAt2 == 'n') {
                        cCharAt2 = '\n';
                    } else if (cCharAt2 == 'f') {
                        cCharAt2 = '\f';
                    }
                    stringBuffer.append(cCharAt2);
                }
            } else {
                stringBuffer.append(cCharAt);
                i2 = i3;
            }
        }
        return stringBuffer.toString();
    }
}
