package com.kugou.framework.lyric4.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.kugou.framework.lyric4.cell.Cell;

/* JADX INFO: loaded from: classes2.dex */
public class Span {
    public transient Cell cell;
    public float mBottom;
    public float mHeight;
    public int mIndex;
    public float mLeft;
    public boolean mNeedClick;
    public float mRight;
    public Object mTag;
    public float mTop;
    public float mWidth;
    public String mWord;

    public Span(int i2, String str) {
        this.mIndex = i2;
        this.mWord = str;
    }

    public boolean draw(Canvas canvas, String str, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        setRect(f2, f3, f4, f5);
        return false;
    }

    public float getBottom() {
        return this.mBottom;
    }

    public Cell getCell() {
        return this.cell;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getLeft() {
        return this.mLeft;
    }

    public float getRight() {
        return this.mRight;
    }

    public Object getTag() {
        return this.mTag;
    }

    public float getTop() {
        return this.mTop;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public String getWord() {
        return this.mWord;
    }

    public boolean isNeedClick() {
        return this.mNeedClick;
    }

    public boolean measure(Paint paint) {
        return false;
    }

    public void onClick(Span span) {
    }

    public void setBottom(float f2) {
        this.mBottom = f2;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setHeight(float f2) {
        this.mHeight = f2;
    }

    public void setLeft(float f2) {
        this.mLeft = f2;
    }

    public void setNeedClick(boolean z) {
        this.mNeedClick = z;
    }

    public void setRect(float f2, float f3, float f4, float f5) {
        this.mLeft = f2;
        this.mTop = f3;
        this.mRight = f4;
        this.mBottom = f5;
    }

    public void setRight(float f2) {
        this.mRight = f2;
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public void setTop(float f2) {
        this.mTop = f2;
    }

    public void setWidth(float f2) {
        this.mWidth = f2;
    }

    public void setWord(String str) {
        this.mWord = str;
    }

    public String toString() {
        return "Span{left=" + this.mLeft + ", top=" + this.mTop + ", right=" + this.mRight + ", bottom=" + this.mBottom + ", index=" + this.mIndex + ", word=" + this.mWord + '}';
    }
}
