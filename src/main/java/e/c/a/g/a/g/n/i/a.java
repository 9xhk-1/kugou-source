package e.c.a.g.a.g.n.i;

import android.view.View;
import com.kugou.android.watch.lite.component.ringtone.RingtoneFragment;
import com.kugou.android.watch.lite.component.ringtone.widget.AudioSliderBar;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements AudioSliderBar.a {
    public final RingtoneFragment a;

    public a(RingtoneFragment ringtoneFragment) {
        j.e(ringtoneFragment, "frag");
        this.a = ringtoneFragment;
    }

    @Override // com.kugou.android.watch.lite.component.ringtone.widget.AudioSliderBar.a
    public void onLeftBarClick(View view) {
        j.e(view, "view");
        RingtoneFragment.n1(this.a, false, 1, null);
    }

    @Override // com.kugou.android.watch.lite.component.ringtone.widget.AudioSliderBar.a
    public void onLeftSlide(int i2) {
        RingtoneFragment.n1(this.a, false, 1, null);
    }

    @Override // com.kugou.android.watch.lite.component.ringtone.widget.AudioSliderBar.a
    public void onRightBarClick(View view) {
        j.e(view, "view");
        RingtoneFragment.n1(this.a, false, 1, null);
    }

    @Override // com.kugou.android.watch.lite.component.ringtone.widget.AudioSliderBar.a
    public void onRightSlide(int i2) {
        RingtoneFragment.n1(this.a, false, 1, null);
    }

    @Override // com.kugou.android.watch.lite.component.ringtone.widget.AudioSliderBar.a
    public void onTouchFocus(boolean z) {
        this.a.g().D0(this.a, !z);
    }
}
