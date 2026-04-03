package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.breakline.BreakLineStrategy;
import com.kugou.framework.lyric4.cell.breakline.LyricLineInfo;
import com.kugou.framework.lyric4.cell.breakline.WrapLineStrategy;
import com.kugou.framework.lyric4.utils.SplitLyricStringUtils;
import com.kugou.framework.lyric4.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class FooterCell extends EmptyCell {
    private AttachInfo mAttachInfo;
    public BreakLineStrategy mBreakLineStrategy;
    private Paint mFooterPaint;
    private String mFooterText;
    public LyricLineInfo[] mLyricLineInfo;
    private int mMarginTop;

    public FooterCell(Context context, int i2, String str, AttachInfo attachInfo) {
        super(context, i2);
        Paint paint = new Paint(1);
        this.mFooterPaint = paint;
        this.mFooterText = str;
        this.mAttachInfo = attachInfo;
        paint.setTextSize(attachInfo.getFooterTextSize());
        this.mFooterPaint.setColor(this.mAttachInfo.getFooterTextColor());
        this.mFooterPaint.setTypeface(this.mAttachInfo.getTypeface());
        this.mBreakLineStrategy = new WrapLineStrategy();
        this.mMarginTop = Utils.dip2px(getContext(), 20.0f);
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInBlankArea(float f2, float f3) {
        return true;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        float lineHeight = 0.0f;
        int i2 = 0;
        while (true) {
            LyricLineInfo[] lyricLineInfoArr = this.mLyricLineInfo;
            if (i2 >= lyricLineInfoArr.length) {
                return;
            }
            float lineHeight2 = lineHeight + (lyricLineInfoArr[i2].getLineHeight() / 2.0f);
            float baseLineOffset = this.mVisibleRect.top + lineHeight2 + this.mLyricLineInfo[i2].getBaseLineOffset();
            lineHeight = lineHeight2 + (this.mLyricLineInfo[i2].getLineHeight() / 2.0f) + 2.0f;
            canvas.drawText(this.mLyricLineInfo[i2].getLyricLine(), getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mLyricLineInfo[i2].getLineWidth()) / 2.0f), baseLineOffset + this.mMarginTop, this.mFooterPaint);
            int length = this.mLyricLineInfo[i2].getLyricWords().length;
            i2++;
        }
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.mLyricLineInfo = this.mBreakLineStrategy.getBreakLineResult(this.mAttachInfo.getSpanMap(this.mLine), SplitLyricStringUtils.splitLyricString(this.mFooterText), (i2 - getPaddingLeft()) - getPaddingRight(), this.mFooterPaint, this.mAttachInfo.getBreakFactor());
    }

    public FooterCell(Context context, int i2, String str, AttachInfo attachInfo, float f2) {
        this(context, i2, str, attachInfo);
        this.scrollOffsetScale = f2;
    }
}
