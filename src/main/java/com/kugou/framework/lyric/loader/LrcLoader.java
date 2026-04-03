package com.kugou.framework.lyric.loader;

import android.text.TextUtils;
import android.util.Base64;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.LyricInfo;
import com.kugou.framework.lyric.LyricManager;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric.loader.language.TranslationParser;
import com.kugou.framework.lyric.loader.language.TransliterationParser;
import com.kugou.framework.lyric4.utils.SplitLyricStringUtils;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LrcLoader implements ILyricLoader {
    private static final String TAG = "LrcLoader";
    private HashMap<String, String> headers;
    private long[] rowBeginTime;
    private long[] rowDelayTime;
    private String[][] translateWords;
    private String[][] transliterationWords;
    private long[][] wordBeginTime;
    private long[][] wordDelayTime;
    private String[][] words;
    private ArrayList<String> allLines = new ArrayList<>();
    private int rowIndex = 0;
    private int errorLineNum = -1;
    private String errorLine = null;

    private void checkLanguageCorrect(LyricData lyricData) {
        if (lyricData == null || lyricData.getWords() == null) {
            return;
        }
        int length = lyricData.getWords().length;
        if (lyricData.getTranslateWords() != null) {
            int i2 = 0;
            for (String[] strArr : lyricData.getTranslateWords()) {
                if (strArr != null) {
                    i2++;
                }
            }
            if (length > i2) {
                String[][] strArr2 = new String[length][];
                String[][] translateWords = lyricData.getTranslateWords();
                for (int i3 = 0; i3 < length; i3++) {
                    if (i3 < translateWords.length) {
                        strArr2[i3] = translateWords[i3];
                    } else {
                        strArr2[i3] = new String[]{" "};
                    }
                }
                lyricData.setTranslateWords(strArr2);
            }
        }
        if (lyricData.getTransliterationWords() != null) {
            int i4 = 0;
            for (String[] strArr3 : lyricData.getTransliterationWords()) {
                if (strArr3 != null) {
                    i4++;
                }
            }
            if (length > i4) {
                String[][] strArr4 = new String[length][];
                String[][] transliterationWords = lyricData.getTransliterationWords();
                for (int i5 = 0; i5 < length; i5++) {
                    if (i5 < transliterationWords.length) {
                        strArr4[i5] = transliterationWords[i5];
                    } else {
                        strArr4[i5] = new String[]{" "};
                    }
                }
                lyricData.setTransliterationWords(strArr4);
            }
        }
        if (lyricData.getChineseWords() != null) {
            int i6 = 0;
            for (String[] strArr5 : lyricData.getChineseWords()) {
                if (strArr5 != null) {
                    i6++;
                }
            }
            if (length > i6) {
                String[][] strArr6 = new String[length][];
                String[][] chineseWords = lyricData.getChineseWords();
                for (int i7 = 0; i7 < length; i7++) {
                    if (i7 < chineseWords.length) {
                        strArr6[i7] = chineseWords[i7];
                    } else {
                        strArr6[i7] = new String[]{" "};
                    }
                }
                lyricData.setChineseWords(strArr6);
            }
        }
    }

    private boolean doParseWidthLanguage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = new String(Base64.decode(str.getBytes(), 0));
        LyricDebug.d("resultStr: " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            LyricDebug.d("version: " + jSONObject.getString(ClientCookie.VERSION_ATTR));
            JSONArray jSONArray = jSONObject.getJSONArray("content");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString("type");
                LyricDebug.d("type: " + string + "  language: " + jSONObject2.optString(KrcLoader.TAG_LANGUAGE));
                byte b = -1;
                int iHashCode = string.hashCode();
                if (iHashCode != 48) {
                    if (iHashCode == 49 && string.equals("1")) {
                        b = 0;
                    }
                } else if (string.equals("0")) {
                    b = 1;
                }
                if (b == 0) {
                    this.translateWords = new TranslationParser().parse(jSONObject2);
                } else if (b == 1) {
                    this.transliterationWords = new TransliterationParser().parse(jSONObject2);
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            LyricDebug.d(e2.getMessage());
            return false;
        }
    }

    private void doWithContent(String str) {
        int iIndexOf;
        String strSubstring;
        String strSubstring2;
        int iIndexOf2 = str.indexOf("[");
        int iIndexOf3 = str.indexOf("]", iIndexOf2);
        int i2 = iIndexOf3 + 1;
        if (iIndexOf2 > iIndexOf3 || iIndexOf2 == -1) {
            return;
        }
        String strSubstring3 = str.substring(iIndexOf2 + 1, iIndexOf3);
        if (TextUtils.isEmpty(strSubstring3) || strSubstring3.indexOf(":") == -1 || (iIndexOf = strSubstring3.indexOf(":")) < 0) {
            return;
        }
        try {
            String strSubstring4 = strSubstring3.substring(0, iIndexOf);
            if (strSubstring3.indexOf(".", iIndexOf) != -1) {
                int i3 = iIndexOf + 1;
                int iIndexOf4 = strSubstring3.indexOf(".", iIndexOf);
                if (i3 > iIndexOf4) {
                    return;
                }
                strSubstring = strSubstring3.substring(i3, iIndexOf4);
                strSubstring2 = strSubstring3.substring(iIndexOf4 + 1);
            } else {
                strSubstring = strSubstring3.substring(iIndexOf + 1, iIndexOf + 3);
                strSubstring2 = "0";
            }
            int i4 = Integer.parseInt(strSubstring4);
            int i5 = Integer.parseInt(strSubstring);
            int i6 = Integer.parseInt(strSubstring2);
            String strSubstring5 = str.substring(i2);
            if (i4 < 0 || i5 < 0 || i6 < 0 || TextUtils.isEmpty(strSubstring5)) {
                return;
            }
            long[] jArr = this.rowBeginTime;
            int i7 = this.rowIndex;
            jArr[i7] = (i4 * 60 * 1000) + (i5 * 1000) + (i6 * 10);
            this.words[i7] = getWordsArray(strSubstring5);
            this.rowIndex++;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void doWithHead(String str) {
        int iIndexOf = str.indexOf("[");
        int iIndexOf2 = str.indexOf(":", iIndexOf);
        if (iIndexOf > iIndexOf2) {
            return;
        }
        String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
        int iIndexOf3 = str.indexOf("]");
        if (iIndexOf2 > iIndexOf3) {
            return;
        }
        this.headers.put(strSubstring, str.substring(iIndexOf2 + 1, iIndexOf3));
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
        lyricData.setLyricType(2);
        lyricData.setHeaders(this.headers);
        lyricData.setRowBeginTime(this.rowBeginTime);
        lyricData.setRowDelayTime(this.rowDelayTime);
        lyricData.setWords(this.words);
        lyricData.setWordBeginTime(this.wordBeginTime);
        lyricData.setWordDelayTime(this.wordDelayTime);
        lyricData.setTranslateWords(this.translateWords);
        lyricData.setTransliterationWords(this.transliterationWords);
        checkLanguageCorrect(lyricData);
        lyricInfo.lyricData = lyricData;
        lyricInfo.hasError = false;
        lyricInfo.errorLineNum = -1;
        lyricInfo.errorLine = null;
        return lyricInfo;
    }

    private String[] getWordsArray(String str) {
        return TextUtils.isEmpty(str) ? new String[]{""} : SplitLyricStringUtils.splitLyricString(str);
    }

    private void initWordBeginTime() {
        int length = this.words.length;
        this.wordDelayTime = new long[length][];
        int i2 = 0;
        while (i2 < length) {
            long[] jArr = this.rowBeginTime;
            int i3 = i2 + 1;
            long j = jArr[i3] - jArr[i2];
            this.rowDelayTime[i2] = j;
            int length2 = this.words[i2].length;
            int i4 = length2 + 1;
            this.wordBeginTime[i2] = new long[i4];
            this.wordDelayTime[i2] = new long[i4];
            for (int i5 = 0; i5 < length2; i5++) {
                long j2 = j / ((long) length2);
                this.wordBeginTime[i2][i5] = ((long) i5) * j2;
                this.wordDelayTime[i2][i5] = j2;
            }
            this.wordBeginTime[i2][length2] = j;
            this.wordDelayTime[i2][length2] = 0;
            i2 = i3;
        }
    }

    private boolean isHeadInfo(String str) {
        return (TextUtils.isEmpty(str) || !str.matches("\\[.*(id\\:|ar\\:|language\\:|ti\\:|by\\:|hash\\:|total\\:|sign\\:|offset\\:|al\\:|re\\:|ve\\:).*]") || str.matches("(.*].*){2,}")) ? false : true;
    }

    private LyricInfo loadLrc(byte[] bArr) {
        LyricInfo lyricInfo = new LyricInfo();
        try {
            String str = new String(bArr);
            lyricInfo.lyricPath = ".lrc";
            lyricInfo.lyricSize = bArr.length;
            return getLyricInfo(lyricInfo, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            lyricInfo.errorInfo = e2.toString();
            return lyricInfo;
        }
    }

    private boolean parse(String str) {
        int i2;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Scanner scanner = new Scanner(LyricManager.getEscapeCharacter(str));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next != null && next.endsWith("\r")) {
                next = next.substring(0, next.lastIndexOf("\r"));
            }
            if (!TextUtils.isEmpty(next)) {
                this.allLines.add(next);
            }
        }
        int size = this.allLines.size();
        if (size == 0) {
            return false;
        }
        this.headers = new HashMap<>();
        int i4 = size + 1;
        this.rowBeginTime = new long[i4];
        this.rowDelayTime = new long[i4];
        this.words = new String[size][];
        this.wordBeginTime = new long[size][];
        boolean z = false;
        for (int i5 = 0; i5 < size; i5++) {
            String strReplaceFirst = this.allLines.get(i5);
            int iIndexOf = strReplaceFirst.indexOf("[");
            if (iIndexOf < strReplaceFirst.indexOf("]", iIndexOf)) {
                try {
                    strReplaceFirst = strReplaceFirst.replaceFirst("[\\[]+", "[").replaceFirst("[\\]]+", "]");
                    if (!TextUtils.isEmpty(strReplaceFirst)) {
                        strReplaceFirst = strReplaceFirst.trim();
                    }
                    if (isHeadInfo(strReplaceFirst)) {
                        doWithHead(strReplaceFirst);
                        if (!z && this.headers.containsKey(KrcLoader.TAG_LANGUAGE)) {
                            doParseWidthLanguage(this.headers.get(KrcLoader.TAG_LANGUAGE));
                            z = true;
                        }
                    } else {
                        doWithContent(strReplaceFirst);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.errorLineNum = i5 + 1;
                    this.errorLine = strReplaceFirst + TopicHighlightHelper.AT + e2.getMessage();
                    return false;
                }
            }
        }
        int i6 = this.rowIndex;
        if (i6 <= 0) {
            return false;
        }
        long[] jArr = this.rowBeginTime;
        jArr[i6] = jArr[i6 - 1] + NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME;
        int i7 = i6 + 1;
        long[] jArr2 = new long[i7];
        String[][] strArr = new String[i6][];
        long[][] jArr3 = new long[i6][];
        System.arraycopy(jArr, 0, jArr2, 0, i7);
        System.arraycopy(this.words, 0, strArr, 0, i6);
        System.arraycopy(this.wordBeginTime, 0, jArr3, 0, i6);
        this.rowBeginTime = jArr2;
        this.rowDelayTime[this.rowIndex] = 0;
        this.words = strArr;
        this.wordBeginTime = jArr3;
        sort();
        initWordBeginTime();
        String[][] strArr2 = this.translateWords;
        if (strArr2 != null && (i3 = this.rowIndex) != strArr2.length) {
            String[][] strArr3 = new String[i3][];
            this.translateWords = strArr3;
            if (strArr2.length == strArr3.length) {
                System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            }
        }
        String[][] strArr4 = this.transliterationWords;
        if (strArr4 != null && (i2 = this.rowIndex) != strArr4.length) {
            String[][] strArr5 = new String[i2][];
            this.transliterationWords = strArr5;
            if (strArr4.length == strArr5.length) {
                System.arraycopy(strArr4, 0, strArr5, 0, strArr4.length);
            }
        }
        return true;
    }

    private void sort() {
        int length = this.words.length;
        int i2 = 1;
        while (i2 <= length / 3) {
            i2 = (i2 * 3) + 1;
        }
        while (i2 >= 1) {
            for (int i3 = i2; i3 < length; i3++) {
                long j = this.rowBeginTime[i3];
                String[] strArr = this.words[i3];
                int i4 = i3;
                while (true) {
                    int i5 = i4 - i2;
                    if (i5 < 0) {
                        break;
                    }
                    long[] jArr = this.rowBeginTime;
                    if (jArr[i5] <= j) {
                        break;
                    }
                    jArr[i4] = jArr[i5];
                    String[][] strArr2 = this.words;
                    strArr2[i4] = strArr2[i5];
                    i4 = i5;
                }
                this.rowBeginTime[i4] = j;
                this.words[i4] = new String[strArr.length];
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    this.words[i4][i6] = strArr[i6];
                }
            }
            i2 = (i2 - 1) / 3;
        }
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
            return loadLrc(file);
        }
        lyricInfo.errorInfo = "lyric file not exists";
        lyricInfo.hasError = true;
        return lyricInfo;
    }

    private LyricInfo loadLrc(File file) {
        LyricInfo lyricInfo = new LyricInfo();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] bArr = new byte[(int) file.length()];
            bufferedInputStream.read(bArr);
            bufferedInputStream.close();
            fileInputStream.close();
            String str = new String(bArr);
            lyricInfo.lyricPath = file.getAbsolutePath();
            lyricInfo.lyricSize = file.length();
            return getLyricInfo(lyricInfo, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            lyricInfo.errorInfo = e2.toString();
            return lyricInfo;
        }
    }

    @Override // com.kugou.framework.lyric.loader.ILyricLoader
    public LyricInfo load(byte[] bArr) {
        return loadLrc(bArr);
    }
}
