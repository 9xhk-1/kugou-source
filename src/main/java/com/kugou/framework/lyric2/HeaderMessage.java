package com.kugou.framework.lyric2;

import android.text.TextPaint;
import com.kugou.framework.lyric2.render.cell.CellUtils;

/* JADX INFO: loaded from: classes2.dex */
public class HeaderMessage {
    public static final String LYRIC_AUTHOR_STR = "歌词制作";
    private float defaultStrWidth;
    private int detailMarginLeft;
    private int dotsWidth;
    private int extraClickTopAndBottomSize;
    private float height;
    private boolean isMoreAuthor;
    private int marginBottom;
    private int marginPoint;
    private float messageTotalWidth;
    private TextPaint paint;
    private String text;
    private float textHeight;
    private float textWidth;

    public HeaderMessage(String str, int i2, TextPaint textPaint, int i3, int i4, boolean z, int i5, int i6) {
        this.text = str;
        this.marginBottom = i2;
        this.paint = textPaint;
        this.detailMarginLeft = i3;
        this.extraClickTopAndBottomSize = i4;
        this.isMoreAuthor = z;
        this.marginPoint = i5;
        this.dotsWidth = i6;
        this.textWidth = textPaint.measureText(str);
        this.defaultStrWidth = textPaint.measureText(LYRIC_AUTHOR_STR);
        this.textHeight = CellUtils.getWordHeight(textPaint);
        if (z) {
            this.messageTotalWidth = textPaint.measureText(str) + textPaint.measureText(LYRIC_AUTHOR_STR);
        } else {
            this.messageTotalWidth = textPaint.measureText(str) + (i5 * 2) + i6 + textPaint.measureText(LYRIC_AUTHOR_STR);
        }
        this.height = this.textHeight;
    }

    public float getDefaultStrWidth() {
        return this.defaultStrWidth;
    }

    public int getDetailMarginLeft() {
        return this.detailMarginLeft;
    }

    public int getDotsWidth() {
        return this.dotsWidth;
    }

    public int getExtraClickTopAndBottomSize() {
        return this.extraClickTopAndBottomSize;
    }

    public float getHeight() {
        return this.height;
    }

    public int getMarginBottom() {
        return this.marginBottom;
    }

    public int getMarginPoint() {
        return this.marginPoint;
    }

    public float getMessageTotalWidth() {
        return this.messageTotalWidth;
    }

    public TextPaint getPaint() {
        return this.paint;
    }

    public String getText() {
        return this.text;
    }

    public float getTextHeight() {
        return this.textHeight;
    }

    public float getTextWidth() {
        return this.textWidth;
    }

    public boolean isMoreAuthor() {
        return this.isMoreAuthor;
    }

    public void setDetailMarginLeft(int i2) {
        this.detailMarginLeft = i2;
    }

    public void setDotsWidth(int i2) {
        this.dotsWidth = i2;
    }

    public void setExtraClickTopAndBottomSize(int i2) {
        this.extraClickTopAndBottomSize = i2;
    }

    public void setHeight(float f2) {
        this.height = f2;
    }

    public void setMarginBottom(int i2) {
        this.marginBottom = i2;
    }

    public void setMoreAuthor(boolean z) {
        this.isMoreAuthor = z;
        if (z) {
            this.messageTotalWidth = this.paint.measureText(this.text) + this.paint.measureText(LYRIC_AUTHOR_STR);
        } else {
            this.messageTotalWidth = this.paint.measureText(this.text) + (this.marginPoint * 2) + this.dotsWidth + this.paint.measureText(LYRIC_AUTHOR_STR);
        }
    }

    public void setPaint(TextPaint textPaint) {
        this.paint = textPaint;
        this.textWidth = textPaint.measureText(this.text);
        this.textHeight = CellUtils.getWordHeight(textPaint);
        if (this.isMoreAuthor) {
            this.messageTotalWidth = textPaint.measureText(this.text) + textPaint.measureText(LYRIC_AUTHOR_STR);
        } else {
            this.messageTotalWidth = textPaint.measureText(this.text) + (this.marginPoint * 2) + this.dotsWidth + textPaint.measureText(LYRIC_AUTHOR_STR);
        }
    }

    public void setText(String str) {
        this.text = str;
        this.textWidth = this.paint.measureText(str);
        this.textHeight = CellUtils.getWordHeight(this.paint);
        if (this.isMoreAuthor) {
            this.messageTotalWidth = this.paint.measureText(str) + this.paint.measureText(LYRIC_AUTHOR_STR);
        } else {
            this.messageTotalWidth = this.paint.measureText(str) + (this.marginPoint * 2) + this.dotsWidth + this.paint.measureText(LYRIC_AUTHOR_STR);
        }
    }
}
