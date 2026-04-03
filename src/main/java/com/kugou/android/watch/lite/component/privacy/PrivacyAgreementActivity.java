package com.kugou.android.watch.lite.component.privacy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.StateFragmentActivity;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.ipc.core.RemoteConnector;
import com.kugou.android.watch.lite.base.player.CheckPlayDelegate;
import com.kugou.android.watch.lite.component.MainActivity;
import e.c.a.g.a.d.x.v.e;
import e.c.a.g.a.s.e1;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.s0;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacyAgreementActivity extends StateFragmentActivity {
    public boolean a;
    public CheckPlayDelegate b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f184d = new c();

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.component.privacy.PrivacyAgreementActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0014a implements Runnable {
            public RunnableC0014a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RemoteConnector.h().f();
                e.c.a.g.a.f.m.c.a.j("sp_key_show_privacy", false);
                PrivacyAgreementActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PrivacyAgreementActivity.this.a) {
                return;
            }
            PrivacyAgreementActivity.this.a = true;
            e.c.a.g.a.d.c.b.c = true;
            PrivacyAgreementActivity.this.getApplication().unregisterActivityLifecycleCallbacks(PrivacyAgreementActivity.this.f184d);
            KGApplication.onPermissionGranted();
            e.c.a.g.a.f.m.c.a.j("sp_key_show_privacy", false);
            PrivacyAgreementActivity.this.startActivity(s0.a.a(PrivacyAgreementActivity.this, MainActivity.class));
            view.postDelayed(new RunnableC0014a(), 300L);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PrivacyAgreementActivity.this.getApplication().unregisterActivityLifecycleCallbacks(PrivacyAgreementActivity.this.f184d);
            PrivacyAgreementActivity.this.finish();
            KGApplication.exit();
        }
    }

    public class c extends e1 {
        public int a = 0;

        public c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            this.a++;
            if (g0.a) {
                g0.b("privacy_agreement", "onActivityStarted:" + this.a);
            }
            if (PrivacyAgreementActivity.this.b != null) {
                PrivacyAgreementActivity.this.b.g(true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            this.a--;
            if (g0.a) {
                g0.b("privacy_agreement", "onActivityStopped:" + this.a);
            }
            if (this.a > 0 || PrivacyAgreementActivity.this.b == null) {
                return;
            }
            PrivacyAgreementActivity.this.b.g(false);
        }
    }

    public static class d {
        public final String a;
        public final String b;
        public final String c;

        public /* synthetic */ d(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }

        public d(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    public static void h(Context context) {
        context.startActivity(s0.a.a(context, PrivacyAgreementActivity.class));
    }

    public final SpannableStringBuilder g(String str, d[] dVarArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        try {
            for (d dVar : dVarArr) {
                String str2 = dVar.a;
                String str3 = dVar.b;
                String str4 = dVar.c;
                try {
                    int iIndexOf = str.indexOf(str2);
                    spannableStringBuilder.setSpan(new e.c.a.g.a.g.l.a(str4, str3), iIndexOf, dVar.a.length() + iIndexOf, 33);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return spannableStringBuilder;
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_privacy_agreement);
        View viewFindViewById = findViewById(R.id.content_view);
        e.c.a.g.a.f.o.d.a(viewFindViewById);
        e.c.a.g.a.f.o.i.c.a().c(1, viewFindViewById);
        TextView textView = (TextView) findViewById(R.id.content);
        a aVar = null;
        d dVar = new d("《用户服务协议》", "用户服务协议", "https://activity.kugou.com/vo-activity/9d1de340-f12f-11ea-a6d8-cb820bfee842/index.html#/service", aVar);
        d dVar2 = new d("《隐私政策》", "隐私政策", "https://activity.kugou.com/terms/v-9d1de340/index.html#/privacy", aVar);
        d dVar3 = new d("《儿童隐私政策》", "儿童隐私政策", "https://activity.kugou.com/vo-activity/9d1de340-f12f-11ea-a6d8-cb820bfee842/index.html#/childrenPrivacy", aVar);
        d dVar4 = new d("《第三方信息共享清单》", "第三方信息共享清单", "https://activity.kugou.com/story/v-be2e4470/index.html", aVar);
        d dVar5 = new d("《个人信息收集清单》", "个人信息收集清单", "https://activity.kugou.com/terms/v-db03d53a/collect.html", aVar);
        d dVar6 = new d("《隐私政策摘要》", "隐私政策摘要", "https://activity.kugou.com/privacy/v-6e20c38f/index.html", aVar);
        String str = "        感谢您信任并使用酷狗概念版！在您使用酷狗概念版服务之前，请您仔细阅读并充分理解" + dVar.a + dVar2.a + dVar3.a + "和" + dVar4.a + dVar5.a + dVar6.a + "的全部内容，以帮助您了解用户权利义务和个人信息处理规则。\n";
        String str2 = "        如需快速、扼要了解我们如何收集您的信息，可以参考" + dVar6.a + "。\n        如果您未满14周岁，您还需要通知您的监护人共同阅读" + dVar3.a + "。\n";
        String str3 = "        如您同意" + dVar.a + dVar2.a + dVar3.a + "和" + dVar4.a + dVar5.a + "请点击“同意”开始接受我们的服务。";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        d[] dVarArr = {dVar, dVar2, dVar3, dVar4, dVar5, dVar6};
        spannableStringBuilder.append((CharSequence) g(str, dVarArr)).append((CharSequence) g(str2, dVarArr)).append((CharSequence) g(str3, dVarArr));
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        findViewById(R.id.agree).setOnClickListener(new a());
        findViewById(R.id.disagree).setOnClickListener(new b());
        getApplication().registerActivityLifecycleCallbacks(this.f184d);
        if (this.b == null) {
            this.b = new CheckPlayDelegate(e.f628d.a().a());
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CheckPlayDelegate checkPlayDelegate = this.b;
        if (checkPlayDelegate != null) {
            checkPlayDelegate.e();
        }
        getApplication().unregisterActivityLifecycleCallbacks(this.f184d);
    }
}
