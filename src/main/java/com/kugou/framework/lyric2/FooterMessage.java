package com.kugou.framework.lyric2;

import android.graphics.Bitmap;
import android.graphics.Paint;
import com.kugou.framework.lyric2.render.cell.CellUtils;

/* JADX INFO: loaded from: classes2.dex */
public class FooterMessage {
    private Bitmap detailBitmap;
    private int detailMarginLeft;
    private int extraClickTopAndBottomSize;
    private int marginTop;
    private float messageTotalWidth;
    private Paint paint;
    private String text;
    private float textHeight;
    private float textWidth;

    public FooterMessage(String str, int i2, Paint paint, Bitmap bitmap, int i3, int i4) {
        this.text = str;
        this.marginTop = i2;
        this.paint = paint;
        this.detailBitmap = bitmap;
        this.detailMarginLeft = i3;
        this.extraClickTopAndBottomSize = i4;
        this.textWidth = paint.measureText(str);
        this.textHeight = CellUtils.getWordHeight(paint);
        if (bitmap != null) {
            this.messageTotalWidth = paint.measureText(str) + i3 + bitmap.getWidth();
        } else {
            this.messageTotalWidth = paint.measureText(str);
        }
    }

    public Bitmap getDetailBitmap() {
        return this.detailBitmap;
    }

    public int getDetailMarginLeft() {
        return this.detailMarginLeft;
    }

    public int getExtraClickTopAndBottomSize() {
        return this.extraClickTopAndBottomSize;
    }

    public int getMarginTop() {
        return this.marginTop;
    }

    public float getMessageTotalWidth() {
        return this.messageTotalWidth;
    }

    public Paint getPaint() {
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

    public void setDetailBitmap(Bitmap bitmap) {
        this.detailBitmap = bitmap;
        if (bitmap != null) {
            this.messageTotalWidth = this.paint.measureText(this.text) + this.detailMarginLeft + bitmap.getWidth();
        } else {
            this.messageTotalWidth = this.paint.measureText(this.text);
        }
    }

    public void setDetailMarginLeft(int i2) {
        this.detailMarginLeft = i2;
    }

    public void setExtraClickTopAndBottomSize(int i2) {
        this.extraClickTopAndBottomSize = i2;
    }

    public void setMarginTop(int i2) {
        this.marginTop = i2;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
        this.textWidth = paint.measureText(this.text);
        this.textHeight = CellUtils.getWordHeight(paint);
        if (this.detailBitmap != null) {
            this.messageTotalWidth = paint.measureText(this.text) + this.detailMarginLeft + this.detailBitmap.getWidth();
        } else {
            this.messageTotalWidth = paint.measureText(this.text);
        }
    }

    public void setText(String str) {
        this.text = str;
        this.textWidth = this.paint.measureText(str);
        this.textHeight = CellUtils.getWordHeight(this.paint);
        if (this.detailBitmap != null) {
            this.messageTotalWidth = this.paint.measureText(str) + this.detailMarginLeft + this.detailBitmap.getWidth();
        } else {
            this.messageTotalWidth = this.paint.measureText(str);
        }
    }
}
