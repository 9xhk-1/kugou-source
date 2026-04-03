package com.kugou.framework.lyric.check;

/* JADX INFO: loaded from: classes2.dex */
public class CellChecker {
    private long[] rowWordBegin;
    private long[] rowWordDelay;
    private String[] rowWords;

    public CellChecker(String[] strArr, long[] jArr, long[] jArr2) {
        this.rowWords = strArr;
        this.rowWordBegin = jArr;
        this.rowWordDelay = jArr2;
    }

    public void checkAndResize() {
        String[] strArr = this.rowWords;
        int length = strArr.length;
        int length2 = this.rowWordBegin.length;
        int length3 = this.rowWordDelay.length;
        int i2 = length > length2 ? length2 : length;
        if (i2 > length3) {
            i2 = length3;
        }
        if (length > i2) {
            String[] strArr2 = new String[i2];
            System.arraycopy(strArr, 0, strArr2, 0, i2);
            this.rowWords = strArr2;
        }
        if (length2 > i2) {
            long[] jArr = new long[i2];
            System.arraycopy(this.rowWordBegin, 0, jArr, 0, i2);
            this.rowWordBegin = jArr;
        }
        if (length3 > i2) {
            long[] jArr2 = new long[i2];
            System.arraycopy(this.rowWordDelay, 0, jArr2, 0, i2);
            this.rowWordDelay = jArr2;
        }
    }

    public long[] getRowWordBegin() {
        return this.rowWordBegin;
    }

    public long[] getRowWordDelay() {
        return this.rowWordDelay;
    }

    public String[] getRowWords() {
        return this.rowWords;
    }
}
