package com.kugou.framework.lyric;

/* JADX INFO: loaded from: classes2.dex */
public class LyricInfo {
    public boolean hasError = false;
    public int errorLineNum = -1;
    public String errorLine = null;
    public String errorInfo = null;
    public LyricData lyricData = null;
    public String lyricPath = null;
    public String lyricHash = null;
    public long lyricSize = -1;
    public String krcStr = null;

    public String toString() {
        return this.errorInfo + "   errorline: " + this.errorLine + "  errorNum: " + this.errorLineNum;
    }
}
