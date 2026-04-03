package com.kugou.framework.lyric2.render.cell;

/* JADX INFO: loaded from: classes2.dex */
public class CellTime {
    private long[] rowBeginTime;
    private long[][] rowWordBegin;
    private long[][] rowWordDelay;
    private float[] rowsLength;
    private float[][] wordsLength;

    public CellTime(long j, long[] jArr, long[] jArr2) {
        this.rowBeginTime = new long[]{j};
        long[][] jArr3 = {new long[jArr.length]};
        this.rowWordBegin = jArr3;
        this.rowWordDelay = new long[][]{new long[jArr2.length]};
        System.arraycopy(jArr, 0, jArr3[0], 0, jArr.length);
        System.arraycopy(jArr2, 0, this.rowWordDelay[0], 0, jArr2.length);
    }

    public long[] getRowBeginTime() {
        return this.rowBeginTime;
    }

    public long[][] getRowWordBegin() {
        return this.rowWordBegin;
    }

    public long[][] getRowWordDelay() {
        return this.rowWordDelay;
    }

    public float[] getRowsLength() {
        return this.rowsLength;
    }

    public float[][] getWordsLength() {
        return this.wordsLength;
    }

    public void setRowBeginTime(long[] jArr) {
        this.rowBeginTime = jArr;
    }

    public void setRowWordBegin(long[][] jArr) {
        this.rowWordBegin = jArr;
    }

    public void setRowWordDelay(long[][] jArr) {
        this.rowWordDelay = jArr;
    }

    public void setRowsLength(float[] fArr) {
        this.rowsLength = fArr;
    }

    public void setWordsLength(float[][] fArr) {
        this.wordsLength = fArr;
    }
}
