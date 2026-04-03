package com.kugou.framework.lyric2.render.cell;

import com.kugou.framework.lyric.loader.language.Language;

/* JADX INFO: loaded from: classes2.dex */
public class CellData {
    public final CellTime cellTime;
    public final Language language;
    private String[] rowString;
    private String[][] words;

    public CellData(Language language, String[] strArr, CellTime cellTime) {
        String[][] strArr2 = {strArr};
        this.words = strArr2;
        this.rowString = new String[]{CellUtils.getRowString(strArr2, 0)};
        this.language = language;
        this.cellTime = cellTime;
    }

    public String[] getRowString() {
        return this.rowString;
    }

    public String[][] getWords() {
        return this.words;
    }

    public void setWords(String[][] strArr) {
        this.words = strArr;
        int length = strArr == null ? 0 : strArr.length;
        if (strArr == null) {
            this.rowString[0] = "";
            return;
        }
        this.rowString = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            this.rowString[i2] = CellUtils.getRowString(strArr, i2);
        }
    }

    public String toString() {
        return super.toString();
    }
}
