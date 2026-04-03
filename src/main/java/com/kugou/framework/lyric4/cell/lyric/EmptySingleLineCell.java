package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import com.kugou.framework.lyric4.AttachInfo;

/* JADX INFO: loaded from: classes2.dex */
public class EmptySingleLineCell extends SingleLineCell {
    public EmptySingleLineCell(Context context, AttachInfo attachInfo) {
        super(context, new String[]{""}, attachInfo, 0);
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.SingleLineCell, com.kugou.framework.lyric4.cell.Cell
    public boolean isInBlankArea(float f2, float f3) {
        return true;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.SingleLineCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
    }
}
