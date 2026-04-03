package com.google.zxing.common;

import com.kugou.common.network.AbsHttpClient;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class CharacterSetECI {
    public static final CharacterSetECI ASCII;
    public static final CharacterSetECI Big5;
    public static final CharacterSetECI Cp1250;
    public static final CharacterSetECI Cp1251;
    public static final CharacterSetECI Cp1252;
    public static final CharacterSetECI Cp1256;
    public static final CharacterSetECI Cp437;
    public static final CharacterSetECI EUC_KR;
    public static final CharacterSetECI GB18030;
    public static final CharacterSetECI ISO8859_1;
    public static final CharacterSetECI ISO8859_10;
    public static final CharacterSetECI ISO8859_11;
    public static final CharacterSetECI ISO8859_13;
    public static final CharacterSetECI ISO8859_14;
    public static final CharacterSetECI ISO8859_15;
    public static final CharacterSetECI ISO8859_16;
    public static final CharacterSetECI ISO8859_2;
    public static final CharacterSetECI ISO8859_3;
    public static final CharacterSetECI ISO8859_4;
    public static final CharacterSetECI ISO8859_5;
    public static final CharacterSetECI ISO8859_6;
    public static final CharacterSetECI ISO8859_7;
    public static final CharacterSetECI ISO8859_8;
    public static final CharacterSetECI ISO8859_9;
    private static final Map<String, CharacterSetECI> NAME_TO_ECI;
    public static final CharacterSetECI SJIS;
    public static final CharacterSetECI UTF8;
    public static final CharacterSetECI UnicodeBigUnmarked;
    private final String name;
    private final String[] otherEncodingNames;
    private final int[] values;

    static {
        CharacterSetECI characterSetECI = new CharacterSetECI("Cp437", new int[]{0, 2}, new String[0]);
        Cp437 = characterSetECI;
        CharacterSetECI characterSetECI2 = new CharacterSetECI("ISO8859_1", new int[]{1, 3}, "ISO-8859-1");
        ISO8859_1 = characterSetECI2;
        CharacterSetECI characterSetECI3 = new CharacterSetECI("ISO8859_2", 4, "ISO-8859-2");
        ISO8859_2 = characterSetECI3;
        CharacterSetECI characterSetECI4 = new CharacterSetECI("ISO8859_3", 5, "ISO-8859-3");
        ISO8859_3 = characterSetECI4;
        CharacterSetECI characterSetECI5 = new CharacterSetECI("ISO8859_4", 6, "ISO-8859-4");
        ISO8859_4 = characterSetECI5;
        CharacterSetECI characterSetECI6 = new CharacterSetECI("ISO8859_5", 7, "ISO-8859-5");
        ISO8859_5 = characterSetECI6;
        CharacterSetECI characterSetECI7 = new CharacterSetECI("ISO8859_6", 8, "ISO-8859-6");
        ISO8859_6 = characterSetECI7;
        CharacterSetECI characterSetECI8 = new CharacterSetECI("ISO8859_7", 9, "ISO-8859-7");
        ISO8859_7 = characterSetECI8;
        CharacterSetECI characterSetECI9 = new CharacterSetECI("ISO8859_8", 10, "ISO-8859-8");
        ISO8859_8 = characterSetECI9;
        CharacterSetECI characterSetECI10 = new CharacterSetECI("ISO8859_9", 11, "ISO-8859-9");
        ISO8859_9 = characterSetECI10;
        CharacterSetECI characterSetECI11 = new CharacterSetECI("ISO8859_10", 12, "ISO-8859-10");
        ISO8859_10 = characterSetECI11;
        CharacterSetECI characterSetECI12 = new CharacterSetECI("ISO8859_11", 13, "ISO-8859-11");
        ISO8859_11 = characterSetECI12;
        CharacterSetECI characterSetECI13 = new CharacterSetECI("ISO8859_13", 15, "ISO-8859-13");
        ISO8859_13 = characterSetECI13;
        CharacterSetECI characterSetECI14 = new CharacterSetECI("ISO8859_14", 16, "ISO-8859-14");
        ISO8859_14 = characterSetECI14;
        CharacterSetECI characterSetECI15 = new CharacterSetECI("ISO8859_15", 17, "ISO-8859-15");
        ISO8859_15 = characterSetECI15;
        CharacterSetECI characterSetECI16 = new CharacterSetECI("ISO8859_16", 18, "ISO-8859-16");
        ISO8859_16 = characterSetECI16;
        CharacterSetECI characterSetECI17 = new CharacterSetECI("SJIS", 20, "Shift_JIS");
        SJIS = characterSetECI17;
        CharacterSetECI characterSetECI18 = new CharacterSetECI("Cp1250", 21, "windows-1250");
        Cp1250 = characterSetECI18;
        CharacterSetECI characterSetECI19 = new CharacterSetECI("Cp1251", 22, "windows-1251");
        Cp1251 = characterSetECI19;
        CharacterSetECI characterSetECI20 = new CharacterSetECI("Cp1252", 23, "windows-1252");
        Cp1252 = characterSetECI20;
        CharacterSetECI characterSetECI21 = new CharacterSetECI("Cp1256", 24, "windows-1256");
        Cp1256 = characterSetECI21;
        CharacterSetECI characterSetECI22 = new CharacterSetECI("UnicodeBigUnmarked", 25, "UTF-16BE", "UnicodeBig");
        UnicodeBigUnmarked = characterSetECI22;
        CharacterSetECI characterSetECI23 = new CharacterSetECI("UTF8", 26, "UTF-8");
        UTF8 = characterSetECI23;
        CharacterSetECI characterSetECI24 = new CharacterSetECI(HTTP.ASCII, new int[]{27, 170}, "US-ASCII");
        ASCII = characterSetECI24;
        CharacterSetECI characterSetECI25 = new CharacterSetECI("Big5", 28);
        Big5 = characterSetECI25;
        CharacterSetECI characterSetECI26 = new CharacterSetECI("GB18030", 29, AbsHttpClient.GB2312, "EUC_CN", "GBK");
        GB18030 = characterSetECI26;
        CharacterSetECI characterSetECI27 = new CharacterSetECI("EUC_KR", 30, "EUC-KR");
        EUC_KR = characterSetECI27;
        NAME_TO_ECI = new HashMap();
        CharacterSetECI[] characterSetECIArr = {characterSetECI, characterSetECI2, characterSetECI3, characterSetECI4, characterSetECI5, characterSetECI6, characterSetECI7, characterSetECI8, characterSetECI9, characterSetECI10, characterSetECI11, characterSetECI12, characterSetECI13, characterSetECI14, characterSetECI15, characterSetECI16, characterSetECI17, characterSetECI18, characterSetECI19, characterSetECI20, characterSetECI21, characterSetECI22, characterSetECI23, characterSetECI24, characterSetECI25, characterSetECI26, characterSetECI27};
        for (int i2 = 0; i2 < 27; i2++) {
            CharacterSetECI characterSetECI28 = characterSetECIArr[i2];
            int length = characterSetECI28.values.length;
            NAME_TO_ECI.put(characterSetECI28.getName(), characterSetECI28);
            for (String str : characterSetECI28.otherEncodingNames) {
                NAME_TO_ECI.put(str, characterSetECI28);
            }
        }
    }

    private CharacterSetECI(String str, int i2) {
        this(str, new int[]{i2}, new String[0]);
    }

    public static CharacterSetECI getCharacterSetECIByName(String str) {
        return NAME_TO_ECI.get(str);
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.values[0];
    }

    private CharacterSetECI(String str, int i2, String... strArr) {
        this(str, new int[]{i2}, strArr);
    }

    private CharacterSetECI(String str, int[] iArr, String... strArr) {
        this.name = str;
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }
}
