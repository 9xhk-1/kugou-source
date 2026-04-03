package com.kugou.android.watch.lite.component.player.lyric;

import android.content.Context;
import android.util.AttributeSet;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.FixMultipleLineLyricView;
import com.kugou.framework.lyric4.adapter.CellAdapter;
import com.kugou.framework.lyric4.adapter.LyricLineCellAdapter;
import com.kugou.framework.lyric4.cell.Cell;
import com.kugou.framework.lyric4.cell.lyric.BaseLyricCell;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class WatchLyricView extends FixMultipleLineLyricView {

    public static final class a extends LyricLineCellAdapter {
        public a(Context context, LyricData lyricData, AttachInfo attachInfo) {
            super(context, lyricData, attachInfo);
        }

        @Override // com.kugou.framework.lyric4.adapter.LyricLineCellAdapter, com.kugou.framework.lyric4.adapter.CellAdapter
        public Cell getCell(int i2) {
            Cell cell = super.getCell(i2);
            if (cell instanceof BaseLyricCell) {
                ((BaseLyricCell) cell).setHighLightWordPercentage(10);
            }
            j.d(cell, "cell");
            return cell;
        }
    }

    public WatchLyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kugou.framework.lyric4.FixMultipleLineLyricView
    public void setAdapter(CellAdapter<?> cellAdapter) {
        super.setAdapter(new a(getContext(), getLyricData(), getAttachInfo()));
    }

    public WatchLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
