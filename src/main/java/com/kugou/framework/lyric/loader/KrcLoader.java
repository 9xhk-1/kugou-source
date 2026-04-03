package com.kugou.framework.lyric.loader;

import android.text.TextUtils;
import com.kugou.framework.lyric.LyricConstent;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.LyricInfo;
import com.kugou.framework.lyric.LyricManager;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import e.b.a.d;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/* JADX INFO: loaded from: classes2.dex */
public class KrcLoader implements ILyricLoader {
    public static final String TAG_LANGUAGE = "language";
    private String[][] chineseWords;
    private HashMap<String, String> headers;
    private long[] rowBeginTime;
    private long[] rowDelayTime;
    private String[][] translateWords;
    private String[][] transliterationWords;
    private long[][] wordBeginTime;
    private long[][] wordDelayTime;
    private String[][] words;
    private List<String> allLines = new ArrayList();
    private int rowIndex = 0;
    private int errorLineNum = -1;
    private String errorLine = null;
    private boolean isTranslateLineError = false;
    private boolean isTransliterationLineError = false;
    private boolean isChineseLineError = false;
    public String mWordInfo = "";
    public boolean hasNext = true;

    private void checkLanguageCorrect(LyricData lyricData) {
        if (lyricData == null || lyricData.getWords() == null) {
            return;
        }
        if (lyricData.getTranslateWords() != null) {
            int i2 = 0;
            for (String[] strArr : lyricData.getTranslateWords()) {
                if (strArr != null) {
                    i2++;
                }
            }
            if (lyricData.getWords().length != i2) {
                lyricData.setTranslateWords(null);
            }
        }
        if (lyricData.getTransliterationWords() != null) {
            int length = 0;
            for (String[] strArr2 : lyricData.getWords()) {
                if (strArr2 != null) {
                    length += strArr2.length;
                }
            }
            int length2 = 0;
            for (String[] strArr3 : lyricData.getTransliterationWords()) {
                if (strArr3 != null) {
                    length2 += strArr3.length;
                }
            }
            if (length != length2) {
                lyricData.setTransliterationWords(null);
            }
        }
        if (lyricData.getChineseWords() != null) {
            int length3 = 0;
            for (String[] strArr4 : lyricData.getWords()) {
                if (strArr4 != null) {
                    length3 += strArr4.length;
                }
            }
            int length4 = 0;
            for (String[] strArr5 : lyricData.getChineseWords()) {
                if (strArr5 != null) {
                    length4 += strArr5.length;
                }
            }
            if (length3 != length4) {
                lyricData.setChineseWords(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4 A[Catch: Exception -> 0x0133, TryCatch #0 {Exception -> 0x0133, blocks: (B:6:0x002d, B:9:0x005c, B:10:0x0061, B:12:0x0067, B:14:0x0075, B:29:0x00b8, B:30:0x00c4, B:19:0x009e, B:22:0x00a8, B:31:0x00cf, B:32:0x00d2, B:34:0x00d8, B:35:0x00dd, B:37:0x00e3, B:39:0x00f1, B:48:0x0124, B:42:0x0116), top: B:54:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean doParseWidthLanguage(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric.loader.KrcLoader.doParseWidthLanguage(java.lang.String):boolean");
    }

    private boolean doParseWithContent(String str) {
        try {
            if (!standardMatch(str)) {
                return false;
            }
            int iCountWordInfo = countWordInfo(str);
            long[][] jArr = this.wordBeginTime;
            int i2 = this.rowIndex;
            int i3 = iCountWordInfo + 1;
            jArr[i2] = new long[i3];
            this.wordDelayTime[i2] = new long[i3];
            this.words[i2] = new String[iCountWordInfo];
            String[] strArrSplitWordInfo = splitWordInfo(str);
            int i4 = 0;
            while (true) {
                if (strArrSplitWordInfo == null) {
                    break;
                }
                this.wordBeginTime[this.rowIndex][i4] = Long.parseLong(strArrSplitWordInfo[0]);
                this.wordDelayTime[this.rowIndex][i4] = Long.parseLong(strArrSplitWordInfo[1]);
                long[][] jArr2 = this.wordDelayTime;
                int i5 = this.rowIndex;
                if (jArr2[i5][i4] < 0) {
                    jArr2[i5][i4] = 0;
                }
                this.words[i5][i4] = strArrSplitWordInfo[3];
                i4++;
                strArrSplitWordInfo = splitWordInfo(str);
            }
            this.mWordInfo = "";
            this.hasNext = true;
            long[][] jArr3 = this.wordBeginTime;
            int i6 = this.rowIndex;
            long[] jArr4 = jArr3[i6];
            int i7 = iCountWordInfo - 1;
            long j = jArr3[i6][i7];
            long[][] jArr5 = this.wordDelayTime;
            jArr4[iCountWordInfo] = j + jArr5[i6][i7];
            jArr5[i6][iCountWordInfo] = 0;
            String[] strArrSplitLineInfo = splitLineInfo(str);
            if (strArrSplitLineInfo != null) {
                String str2 = strArrSplitLineInfo[0];
                String str3 = strArrSplitLineInfo[1];
                if (!TextUtils.isEmpty(str2)) {
                    this.rowBeginTime[this.rowIndex] = Long.parseLong(str2);
                    int i8 = this.rowIndex;
                    boolean z = i8 > 0;
                    long j2 = z ? this.rowBeginTime[i8 - 1] : 0L;
                    long[] jArr6 = this.rowBeginTime;
                    if (jArr6[i8] < j2) {
                        jArr6[i8] = z ? this.rowDelayTime[i8 - 1] + j2 : 0L;
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.rowDelayTime[this.rowIndex] = Long.parseLong(str3);
                }
            }
            this.rowIndex++;
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            LyricDebug.e("match failed: " + e2.getMessage() + "  ==>of line: " + str);
            return false;
        }
    }

    private boolean doParseWithHead(String str) {
        try {
            String[] strArrSplitHeadInfo = splitHeadInfo(str);
            if (strArrSplitHeadInfo != null) {
                LyricDebug.d("key: " + strArrSplitHeadInfo[0] + "  value: " + strArrSplitHeadInfo[1]);
                this.headers.put(strArrSplitHeadInfo[0], strArrSplitHeadInfo[1]);
                return true;
            }
        } catch (Exception e2) {
            LyricDebug.e("match failed: " + e2.getMessage() + "  ==>of line: " + str);
        }
        return false;
    }

    private String getKrcString(LyricInfo lyricInfo, byte[] bArr) throws UnsupportedEncodingException {
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ LyricConstent.magic[i2 % 16]);
        }
        String strHandleLyricError = handleLyricError(new String(d.a(bArr), "UTF-8"));
        lyricInfo.krcStr = strHandleLyricError;
        return strHandleLyricError;
    }

    private LyricInfo getLyricInfo(LyricInfo lyricInfo, String str) {
        if (!parse(str)) {
            lyricInfo.lyricData = null;
            lyricInfo.hasError = true;
            lyricInfo.errorLineNum = this.errorLineNum;
            lyricInfo.errorLine = this.errorLine;
            if (this.rowIndex == 0) {
                lyricInfo.errorInfo = "EmptyContent";
            }
            return lyricInfo;
        }
        LyricData lyricData = new LyricData();
        lyricData.setLyricType(1);
        lyricData.setHeaders(this.headers);
        lyricData.setRowBeginTime(this.rowBeginTime);
        lyricData.setRowDelayTime(this.rowDelayTime);
        lyricData.setWords(this.words);
        lyricData.setTranslateWords(this.translateWords);
        lyricData.setTransliterationWords(this.transliterationWords);
        lyricData.setChineseWords(this.chineseWords);
        lyricData.setWordBeginTime(this.wordBeginTime);
        lyricData.setWordDelayTime(this.wordDelayTime);
        lyricInfo.lyricData = lyricData;
        lyricInfo.hasError = false;
        lyricInfo.errorLineNum = -1;
        lyricInfo.errorLine = null;
        checkLanguageCorrect(lyricData);
        return lyricInfo;
    }

    private String handleLyricError(String str) {
        return !TextUtils.isEmpty(str) ? str.replace("[<", "［<").replace(">]", ">］") : str;
    }

    private LyricInfo loadKrc(byte[] bArr) {
        LyricInfo lyricInfo = new LyricInfo();
        try {
            byte[] bArr2 = new byte[4];
            for (int i2 = 0; i2 < 4 && i2 < bArr.length; i2++) {
                bArr2[i2] = bArr[i2];
            }
            if (!"krc1".equalsIgnoreCase(new String(bArr2))) {
                lyricInfo.errorInfo = "not a correct krc file";
                lyricInfo.hasError = true;
                return lyricInfo;
            }
            byte[] bArr3 = new byte[bArr.length];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                int i4 = i3 + 4;
                if (i4 >= bArr.length) {
                    bArr3[i3] = 0;
                } else {
                    bArr3[i3] = bArr[i4];
                }
            }
            String krcString = getKrcString(lyricInfo, bArr3);
            lyricInfo.lyricPath = ".krc";
            lyricInfo.lyricSize = bArr.length;
            return getLyricInfo(lyricInfo, krcString);
        } catch (Exception e2) {
            e2.printStackTrace();
            lyricInfo.errorInfo = e2.getMessage() + "  -  " + e2.toString();
            return lyricInfo;
        }
    }

    private boolean parse(String str) {
        int i2;
        int i3;
        int i4;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("歌词文件为空");
        }
        Scanner scanner = new Scanner(LyricManager.getEscapeCharacter(str));
        scanner.useDelimiter("[\\n|\\r\\n]");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (!TextUtils.isEmpty(next)) {
                if (next.charAt(0) == 65279) {
                    next = next.substring(1, next.length());
                }
                this.allLines.add(next);
            }
        }
        int size = this.allLines.size();
        if (size == 0) {
            return false;
        }
        this.headers = new HashMap<>();
        boolean z = false;
        boolean z2 = false;
        for (int i5 = 0; i5 < size; i5++) {
            String str2 = this.allLines.get(i5);
            LyricDebug.assertFalse(TextUtils.isEmpty(str2));
            if (!z) {
                int i6 = size - i5;
                int i7 = i6 + 1;
                this.rowBeginTime = new long[i7];
                this.rowDelayTime = new long[i7];
                this.words = new String[i6][];
                this.wordBeginTime = new long[i6][];
                this.wordDelayTime = new long[i6][];
                z = true;
            }
            try {
                if (!doParseWithHead(str2)) {
                    if (!z2 && this.headers.containsKey(TAG_LANGUAGE)) {
                        doParseWidthLanguage(this.headers.get(TAG_LANGUAGE));
                        z2 = true;
                    }
                    doParseWithContent(str2.trim());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.errorLineNum = i5 + 1;
                this.errorLine = str2 + TopicHighlightHelper.AT + e2.getMessage();
                return false;
            }
        }
        int i8 = this.rowIndex;
        if (i8 <= 0) {
            return false;
        }
        int i9 = i8 - 1;
        long[] jArr = this.rowBeginTime;
        long j = jArr[i9];
        long[] jArr2 = this.wordBeginTime[i9];
        long[] jArr3 = this.wordDelayTime[i9];
        jArr[i8] = Math.max(j, jArr2[jArr2.length - 1] + jArr3[jArr3.length - 1] + j);
        long[] jArr4 = this.rowDelayTime;
        int i10 = this.rowIndex;
        jArr4[i10] = 0;
        int i11 = i10 + 1;
        long[] jArr5 = this.rowBeginTime;
        if (i11 != jArr5.length) {
            long[] jArr6 = new long[i10 + 1];
            this.rowBeginTime = jArr6;
            System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        }
        int i12 = this.rowIndex;
        long[][] jArr7 = this.wordBeginTime;
        if (i12 != jArr7.length) {
            long[][] jArr8 = new long[i12][];
            this.wordBeginTime = jArr8;
            System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        }
        int i13 = this.rowIndex;
        long[][] jArr9 = this.wordDelayTime;
        if (i13 != jArr9.length) {
            long[][] jArr10 = new long[i13][];
            this.wordDelayTime = jArr10;
            System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        }
        int i14 = this.rowIndex;
        String[][] strArr = this.words;
        if (i14 != strArr.length) {
            String[][] strArr2 = new String[i14][];
            this.words = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr2.length);
        }
        String[][] strArr3 = this.translateWords;
        if (strArr3 != null && (i4 = this.rowIndex) != strArr3.length) {
            String[][] strArr4 = new String[i4][];
            this.translateWords = strArr4;
            if (strArr3.length != strArr4.length) {
                this.isTranslateLineError = true;
            } else {
                System.arraycopy(strArr3, 0, strArr4, 0, strArr3.length);
            }
        }
        String[][] strArr5 = this.transliterationWords;
        if (strArr5 != null && (i3 = this.rowIndex) != strArr5.length) {
            String[][] strArr6 = new String[i3][];
            this.transliterationWords = strArr6;
            if (strArr5.length != strArr6.length) {
                this.isTransliterationLineError = true;
            } else {
                System.arraycopy(strArr5, 0, strArr6, 0, strArr5.length);
            }
        }
        String[][] strArr7 = this.chineseWords;
        if (strArr7 != null && (i2 = this.rowIndex) != strArr7.length) {
            String[][] strArr8 = new String[i2][];
            this.chineseWords = strArr8;
            if (strArr7.length != strArr8.length) {
                this.isChineseLineError = true;
            } else {
                System.arraycopy(strArr7, 0, strArr8, 0, strArr7.length);
            }
        }
        return true;
    }

    public int countMatches(String str, String str2) {
        int length = 0;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf == -1) {
                return i2;
            }
            i2++;
            length = iIndexOf + str2.length();
        }
    }

    public int countWordInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i2 = 0;
        for (char c : str.toCharArray()) {
            if ('<' == c) {
                i2++;
            }
        }
        return i2;
    }

    public boolean isNumeric(String str) {
        for (int i2 = (!str.startsWith("-") || str.length() <= 1) ? 0 : 1; i2 < str.length(); i2++) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public boolean isTrueArrowData(String str, int i2) {
        int iCountMatches = countMatches(str, "<");
        if (iCountMatches != countMatches(str, ">")) {
            return false;
        }
        int iIndexOf = i2;
        int iIndexOf2 = iIndexOf;
        for (int i3 = 0; i3 < iCountMatches; i3++) {
            iIndexOf = str.indexOf("<", iIndexOf + 1);
            iIndexOf2 = str.indexOf(">", iIndexOf2 + 1);
            if ((i3 == 0 && iIndexOf - i2 != 1) || iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf >= iIndexOf2) {
                return false;
            }
            String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            if (TextUtils.isEmpty(strSubstring)) {
                return false;
            }
            String[] strArrSplit = strSubstring.split(",");
            if (strArrSplit.length != 3) {
                return false;
            }
            for (int i4 = 0; i4 < strArrSplit.length; i4++) {
                if (TextUtils.isEmpty(strArrSplit[i4]) || !isNumeric(strArrSplit[i4])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.kugou.framework.lyric.loader.ILyricLoader
    public LyricInfo load(String str) {
        LyricInfo lyricInfo = new LyricInfo();
        if (TextUtils.isEmpty(str)) {
            lyricInfo.errorInfo = "lyric path is empty";
            lyricInfo.hasError = true;
            return lyricInfo;
        }
        File file = new File(str);
        if (file.exists()) {
            return loadKrc(file);
        }
        lyricInfo.errorInfo = "lyric file not exists";
        lyricInfo.hasError = true;
        return lyricInfo;
    }

    public String[] splitHeadInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(str.indexOf("[") + 1, str.indexOf("]")).split(":");
    }

    public String[] splitLineInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(str.indexOf("[") + 1, str.indexOf("]")).split(",");
    }

    public String[] splitWordInfo(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.isEmpty(this.mWordInfo)) {
                this.mWordInfo = str;
            }
            if (!this.hasNext) {
                return null;
            }
            int iIndexOf = this.mWordInfo.indexOf("<");
            int iIndexOf2 = this.mWordInfo.indexOf(">");
            int i2 = iIndexOf + 1;
            int iIndexOf3 = this.mWordInfo.indexOf("<", i2);
            if (iIndexOf3 < iIndexOf) {
                iIndexOf3 = this.mWordInfo.length();
                this.hasNext = false;
            }
            String strSubstring = this.mWordInfo.substring(i2, iIndexOf2);
            String strSubstring2 = this.mWordInfo.substring(iIndexOf2 + 1, iIndexOf3);
            String[] strArrSplit = strSubstring.split(",");
            String[] strArr = {strArrSplit[0], strArrSplit[1], strArrSplit[2], strSubstring2};
            if (this.hasNext) {
                String str2 = this.mWordInfo;
                this.mWordInfo = str2.substring(iIndexOf3, str2.length());
            }
            return strArr;
        } catch (Exception unused) {
            this.mWordInfo = "";
            return null;
        }
    }

    public boolean standardMatch(String str) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith("[") || (iIndexOf = str.indexOf("]")) < 1) {
            return false;
        }
        String strSubstring = str.substring(1, iIndexOf);
        if (TextUtils.isEmpty(strSubstring)) {
            return false;
        }
        String[] strArrSplit = strSubstring.split(",");
        if (strArrSplit.length != 2) {
            return false;
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (TextUtils.isEmpty(strArrSplit[i2]) || !isNumeric(strArrSplit[i2])) {
                return false;
            }
        }
        return isTrueArrowData(str, iIndexOf);
    }

    @Override // com.kugou.framework.lyric.loader.ILyricLoader
    public LyricInfo load(byte[] bArr) {
        return loadKrc(bArr);
    }

    private LyricInfo loadKrc(File file) throws Throwable {
        FileInputStream fileInputStream;
        LyricInfo lyricInfo = new LyricInfo();
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                    try {
                        byte[] bArr = new byte[4];
                        bufferedInputStream2.read(bArr);
                        if (!"krc1".equalsIgnoreCase(new String(bArr))) {
                            lyricInfo.errorInfo = "not a correct krc file";
                            lyricInfo.hasError = true;
                            try {
                                bufferedInputStream2.close();
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                lyricInfo.errorInfo = e2.toString();
                            }
                            return lyricInfo;
                        }
                        byte[] bArr2 = new byte[(int) file.length()];
                        bufferedInputStream2.read(bArr2);
                        String krcString = getKrcString(lyricInfo, bArr2);
                        lyricInfo.lyricPath = file.getAbsolutePath();
                        lyricInfo.lyricSize = file.length();
                        LyricInfo lyricInfo2 = getLyricInfo(lyricInfo, krcString);
                        try {
                            bufferedInputStream2.close();
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            lyricInfo.errorInfo = e3.toString();
                        }
                        return lyricInfo2;
                    } catch (Exception e4) {
                        e = e4;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        lyricInfo.errorInfo = e.getMessage() + "  -  " + e.toString();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                lyricInfo.errorInfo = e5.toString();
                                return lyricInfo;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return lyricInfo;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                lyricInfo.errorInfo = e6.toString();
                                throw th;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                }
            } catch (Exception e8) {
                e = e8;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
