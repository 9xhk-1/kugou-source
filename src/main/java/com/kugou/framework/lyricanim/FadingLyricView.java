package com.kugou.framework.lyricanim;

import android.content.Context;
import android.util.AttributeSet;
import com.kugou.framework.lyric4.MultipleLineLyricView;
import com.kugou.framework.lyric4.cell.CellGroup;

/* JADX INFO: loaded from: classes2.dex */
public class FadingLyricView extends MultipleLineLyricView {
    public static final float fadingEdgeLength = 80.0f;
    private float bottomScale;
    private boolean isEnableFadingEdge;
    private float topScale;

    public FadingLyricView(Context context) {
        super(context);
        this.isEnableFadingEdge = true;
        this.topScale = 1.0f;
        this.bottomScale = 1.0f;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.isEnableFadingEdge) {
            return this.bottomScale * 1.0f;
        }
        return 0.0f;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        CellGroup cellGroup;
        if (!this.isEnableFadingEdge) {
            return 0.0f;
        }
        if (!this.isPinTopMode || isTxtLyric() || (cellGroup = this.mCellGroup) == null || cellGroup.getCellSize() <= this.miniCell || this.mIsBeingDragged || this.mCurrentPosition > 0) {
            return super.getTopFadingEdgeStrength() * this.topScale;
        }
        return 0.0f;
    }

    public void setBottomFadingScale(float f2) {
        this.bottomScale = f2;
    }

    public void setEnableFadingEdge(boolean z) {
        this.isEnableFadingEdge = z;
    }

    public void setTopFadingScale(float f2) {
        this.topScale = f2;
    }

    public FadingLyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isEnableFadingEdge = true;
        this.topScale = 1.0f;
        this.bottomScale = 1.0f;
    }

    public FadingLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.isEnableFadingEdge = true;
        this.topScale = 1.0f;
        this.bottomScale = 1.0f;
    }
}
