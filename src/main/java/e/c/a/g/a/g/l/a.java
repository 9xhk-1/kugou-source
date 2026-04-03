package e.c.a.g.a.g.l;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.privacy.PrivacyActivity;
import e.c.a.g.a.s.s0;

/* JADX INFO: loaded from: classes2.dex */
public class a extends ClickableSpan {
    public final String a;
    public final String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f967d;

    public a(String str, String str2) {
        this(str, str2, KGApplication.getContext().getResources().getColor(R.color.auto_ht));
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        Context context = view.getContext();
        Intent intentA = s0.a.a(context, PrivacyActivity.class);
        intentA.putExtra("privacy_url", this.a);
        intentA.putExtra("privacy_name", this.b);
        context.startActivity(intentA);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.f967d);
        textPaint.clearShadowLayer();
    }

    public a(String str, String str2, int i2) {
        this.a = str;
        this.b = str2;
        this.f967d = i2;
    }
}
