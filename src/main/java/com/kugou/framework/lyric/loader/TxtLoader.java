package com.kugou.framework.lyric.loader;

import android.text.TextUtils;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.LyricInfo;
import com.kugou.framework.lyric.LyricManager;
import com.kugou.framework.lyric4.utils.SplitLyricStringUtils;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* JADX INFO: loaded from: classes2.dex */
public class TxtLoader implements ILyricLoader {
    private static final String TAG = "TxtLoader";
    private HashMap<String, String> headers;
    private long[] rowBeginTime;
    private long[] rowDelayTime;
    private long[][] wordBeginTime;
    private long[][] wordDelayTime;
    private String[][] words;
    private ArrayList<String> allLines = new ArrayList<>();
    private int rowIndex = 0;
    private int errorLineNum = -1;
    private String errorLine = null;

    private void doWithContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("[") && str.contains(":") && str.endsWith("]")) {
            return;
        }
        long[] jArr = this.rowBeginTime;
        int i2 = this.rowIndex;
        jArr[i2] = 0;
        this.words[i2] = getWordsArray(str);
        this.rowIndex++;
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
        lyricData.setLyricType(3);
        lyricData.setHeaders(this.headers);
        lyricData.setRowBeginTime(this.rowBeginTime);
        lyricData.setRowDelayTime(this.rowDelayTime);
        lyricData.setWords(this.words);
        lyricData.setWordBeginTime(this.wordBeginTime);
        lyricData.setWordDelayTime(this.wordDelayTime);
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
        for (int i2 = 0; i2 < length; i2++) {
            this.rowDelayTime[i2] = 0;
            int length2 = this.words[i2].length;
            int i3 = length2 + 1;
            this.wordBeginTime[i2] = new long[i3];
            this.wordDelayTime[i2] = new long[i3];
            for (int i4 = 0; i4 < length2; i4++) {
                this.wordBeginTime[i2][i4] = 0;
                this.wordDelayTime[i2][i4] = 0;
            }
            this.wordBeginTime[i2][length2] = 0;
            this.wordDelayTime[i2][length2] = 0;
        }
    }

    private boolean isHeadInfo(String str) {
        return (TextUtils.isEmpty(str) || !str.matches("\\[.*(id\\:|ar\\:|ti\\:|by\\:|hash\\:|total\\:|sign\\:|offset\\:|al\\:|re\\:|ve\\:).*]") || str.matches("(.*].*){2,}")) ? false : true;
    }

    private LyricInfo loadTxt(byte[] bArr) {
        LyricInfo lyricInfo = new LyricInfo();
        try {
            String str = new String(bArr);
            lyricInfo.lyricPath = ".txt";
            lyricInfo.lyricSize = bArr.length;
            return getLyricInfo(lyricInfo, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            lyricInfo.errorInfo = e2.toString();
            return lyricInfo;
        }
    }

    private boolean parse(String str) {
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
        int i2 = size + 1;
        this.rowBeginTime = new long[i2];
        this.rowDelayTime = new long[i2];
        this.words = new String[size][];
        this.wordBeginTime = new long[size][];
        for (int i3 = 0; i3 < size; i3++) {
            String strTrim = this.allLines.get(i3);
            try {
                if (!TextUtils.isEmpty(strTrim)) {
                    strTrim = strTrim.trim();
                }
                if (isHeadInfo(strTrim)) {
                    doWithHead(strTrim);
                } else {
                    doWithContent(strTrim);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.errorLineNum = i3 + 1;
                this.errorLine = strTrim + TopicHighlightHelper.AT + e2.getMessage();
                return false;
            }
        }
        int i4 = this.rowIndex;
        if (i4 <= 0) {
            return false;
        }
        long[] jArr = this.rowBeginTime;
        jArr[i4] = jArr[i4 - 1] + NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME;
        int i5 = i4 + 1;
        long[] jArr2 = new long[i5];
        String[][] strArr = new String[i4][];
        long[][] jArr3 = new long[i4][];
        System.arraycopy(jArr, 0, jArr2, 0, i5);
        System.arraycopy(this.words, 0, strArr, 0, i4);
        System.arraycopy(this.wordBeginTime, 0, jArr3, 0, i4);
        this.rowBeginTime = jArr2;
        this.rowDelayTime[this.rowIndex] = 0;
        this.words = strArr;
        this.wordBeginTime = jArr3;
        initWordBeginTime();
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
            return loadTxt(file);
        }
        lyricInfo.errorInfo = "lyric file not exists";
        lyricInfo.hasError = true;
        return lyricInfo;
    }

    private LyricInfo loadTxt(File file) {
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
        return loadTxt(bArr);
    }
}
