package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BulletinTextCell extends EmptyCell {
    private AttachInfo mAttachInfo;
    private float mBaseline;
    private Paint.FontMetrics mFontMetrics;
    private boolean mIsMeasure;
    private float mLineHeight;
    private List<Line> mLineList;
    private float mLineSpacing;
    private int mMarginLR;
    private int mMarginTop;
    private TextPaint mPaint;
    private String mText;

    public class Line {
        public String text;
        public int width;

        public Line(String str, int i2) {
            this.text = str;
            this.width = i2;
        }
    }

    public BulletinTextCell(Context context, int i2, String str, AttachInfo attachInfo) {
        super(context, i2);
        this.mIsMeasure = false;
        this.mPaint = new TextPaint(1);
        this.mLineList = new ArrayList();
        this.mText = str;
        this.mAttachInfo = attachInfo;
        this.mMarginLR = Utils.dip2px(getContext(), 60.0f);
        this.mMarginTop = Utils.dip2px(getContext(), 30.0f) + (this.mAttachInfo.getCellRowMargin() / 2);
        this.mLineSpacing = this.mAttachInfo.getCellRowMargin();
        this.mPaint.setTextSize(this.mAttachInfo.getTextSize());
        this.mPaint.setColor(this.mAttachInfo.getTextColor());
        this.mPaint.setTypeface(this.mAttachInfo.getTypeface());
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        this.mFontMetrics = fontMetrics;
        float f2 = fontMetrics.bottom - fontMetrics.top;
        this.mLineHeight = f2;
        this.mBaseline = (f2 / 2.0f) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        int i2 = (int) (getVisibleRect().top + this.mMarginTop + this.mBaseline);
        for (Line line : this.mLineList) {
            int cellAlignMode = this.mAttachInfo.getCellAlignMode();
            float f2 = i2;
            canvas.drawText(line.text, cellAlignMode != 1 ? cellAlignMode != 2 ? getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - line.width) / 2) : (getVisibleRect().right - getVisibleRect().left) - line.width : getVisibleRect().left, f2, this.mPaint);
            i2 = (int) (f2 + this.mLineHeight + this.mLineSpacing);
        }
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        float size = i3;
        int i4 = (i2 - getVisibleRect().right) - getVisibleRect().left;
        int i5 = this.mMarginLR;
        int i6 = (i4 - i5) - i5;
        if (!this.mIsMeasure) {
            this.mLineList.clear();
            for (String str : this.mText.split("\\n")) {
                this.mIsMeasure = true;
                StaticLayout staticLayout = staticLayout;
                StaticLayout staticLayout2 = new StaticLayout(str, this.mPaint, i6, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                int lineCount = staticLayout.getLineCount();
                int i7 = 0;
                while (i7 < lineCount) {
                    StaticLayout staticLayout3 = staticLayout;
                    CharSequence charSequenceSubSequence = str.subSequence(staticLayout3.getLineStart(i7), staticLayout3.getLineEnd(i7));
                    if (charSequenceSubSequence != null && charSequenceSubSequence.length() > 0) {
                        this.mLineList.add(new Line(charSequenceSubSequence.toString(), (int) this.mPaint.measureText(charSequenceSubSequence.toString())));
                    }
                    i7++;
                    staticLayout = staticLayout3;
                }
            }
            size = (this.mLineHeight * this.mLineList.size()) + (this.mLineSpacing * (this.mLineList.size() - 1));
        }
        setMeasureResult(i2, (int) (size + this.mMarginTop));
    }
}
