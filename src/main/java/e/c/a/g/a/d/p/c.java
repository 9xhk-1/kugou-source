package e.c.a.g.a.d.p;

import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.util.ViewPager;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class c implements ViewPager.h {
    @Override // com.kugou.android.watch.lite.util.ViewPager.h
    public void transformPage(View view, float f2) {
        if ("main_ui_center_page".equals(view.getTag(R.id.comm_main_center_page_flag))) {
            g0.e("MainUIPageTransformer", "position:" + f2);
            view.setTranslationX((-f2) * ((float) view.getWidth()) * 0.7f);
        }
    }
}
