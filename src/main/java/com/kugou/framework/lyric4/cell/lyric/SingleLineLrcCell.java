package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.kugou.framework.lyric4.AttachInfo;

/* JADX INFO: loaded from: classes2.dex */
public class SingleLineLrcCell extends SingleLineCell {
    private float mHighLightPercentage;

    public SingleLineLrcCell(Context context, String[] strArr, AttachInfo attachInfo, int i2) {
        super(context, strArr, attachInfo, i2);
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.SingleLineCell
    public void drawLyricLine(Canvas canvas, String str, float f2, float f3, float f4, Paint paint) {
        boolean z = getAttachInfo().getCurrentHighLightLine() == ((SingleLineCell) this).mLine;
        this.mIsHighLighting = z;
        if (!z) {
            if (this.mAttachInfo.isStroke()) {
                canvas.drawText(str, f2 - this.mAttachInfo.getStrokeSize(), this.mAttachInfo.getStrokeSize() + f4, getStrokePaint());
            }
            canvas.drawText(str, f2, f4, getSelectLinePaint(getDefaultPaint()));
            return;
        }
        updateHighLightPosition(getAttachInfo().getCurrentHighLightWord(), getAttachInfo().getCurrentHighLightPercentage());
        if (this.mLyricLineInfo.getLineWidth() > getVisibleRect().right - getVisibleRect().left && this.mHighLightPercentage > 0.1d) {
            canvas.translate((int) (((getVisibleRect().right - getVisibleRect().left) - this.mLyricLineInfo.getLineWidth()) * this.mHighLightPercentage), 0.0f);
        }
        if (this.mAttachInfo.isStroke()) {
            canvas.drawText(str, f2 - this.mAttachInfo.getStrokeSize(), this.mAttachInfo.getStrokeSize() + f4, getStrokePaint());
        }
        canvas.drawText(str, f2, f4, getHighLightPaint());
    }

    public void updateHighLightPosition(int i2, int i3) {
        this.mHighLightWordIndex = i2;
        this.mHighLightWordPercentage = i3;
        float lyricWordWidth = 0.0f;
        int i4 = 0;
        while (i4 <= i2 && i4 < this.mLyricLineInfo.getLyricWords().length) {
            lyricWordWidth += i4 != i2 ? this.mLyricLineInfo.getLyricWords()[i4].getLyricWordWidth() : (this.mLyricLineInfo.getLyricWords()[i4].getLyricWordWidth() * i3) / 100.0f;
            i4++;
        }
        this.mHighLightPercentage = lyricWordWidth / this.mLyricLineInfo.getLineWidth();
    }
}
