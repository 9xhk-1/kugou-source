package com.kugou.android.watch.lite.component.privacy;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.StateFragmentActivity;
import e.c.a.g.a.f.o.d;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.y0;
import e.c.a.g.a.s.z0;
import f.b0.f;
import f.z.d.j;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class PrivacyActivity extends StateFragmentActivity {
    public ImageView a;
    public Subscription b;

    public static final class a<T, R> implements Func1 {
        public a() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap call(String str) {
            j.d(str, "it");
            return z0.a(str, PrivacyActivity.this.d());
        }
    }

    public static final class b<T> implements Action1 {
        public final /* synthetic */ ImageView a;

        public b(ImageView imageView) {
            this.a = imageView;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Bitmap bitmap) {
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PrivacyActivity.this.finish();
        }
    }

    public final float d() {
        if (l1.X()) {
            return f.g(l1.q0(this, l1.z(this)) - 50.0f, 58.0f, 120.0f);
        }
        return 58.0f;
    }

    public final void e(String str) {
        ImageView imageView = this.a;
        if (imageView != null) {
            if (str == null || str.length() == 0) {
                return;
            }
            this.b = Observable.just(str).map(new a()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(imageView), i1.b);
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_privacy);
        View viewFindViewById = findViewById(R.id.content_view);
        d.a(viewFindViewById);
        e.c.a.g.a.f.o.i.c.a().d(1, viewFindViewById);
        TextView textView = (TextView) findViewById(R.id.content_title);
        View viewFindViewById2 = findViewById(R.id.iv_back);
        this.a = (ImageView) findViewById(R.id.privacy_code);
        String stringExtra = getIntent().getStringExtra("privacy_url");
        String stringExtra2 = getIntent().getStringExtra("privacy_name");
        if (!TextUtils.isEmpty(stringExtra2)) {
            textView.setText(stringExtra2);
        }
        u1.b(new c(), viewFindViewById2, textView);
        e(stringExtra);
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        i1.a(this.b);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (e.c.a.g.a.f.a.l()) {
            y0.e();
        }
    }
}
