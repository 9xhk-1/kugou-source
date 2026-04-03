package com.kugou.android.watch.lite.component.feedback;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.common.network.ExceptionParse;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.kugou.common.utils.PermissionsUtil;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class FeedbackFragment extends DelegateFragment {
    public boolean A;
    public e.c.a.g.a.g.g.c.c B;
    public boolean C;
    public EditText r;
    public EditText s;
    public int t = 1;
    public RelativeLayout u;
    public ImageView v;
    public ImageView w;
    public ImageView x;
    public e.c.a.g.a.r.c.a y;
    public Bitmap z;

    public static final class a<T, R> implements Func1 {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FeedbackFragment f155d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f.z.d.r<ArrayList<e.c.a.g.a.r.c.a>> f156f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f157h;

        public a(String str, String str2, FeedbackFragment feedbackFragment, f.z.d.r<ArrayList<e.c.a.g.a.r.c.a>> rVar, int i2) {
            this.a = str;
            this.b = str2;
            this.f155d = feedbackFragment;
            this.f156f = rVar;
            this.f157h = i2;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.g.g.c.e call(Integer num) {
            e.c.a.g.a.g.g.c.e eVarE = e.c.a.g.a.g.g.c.c.e(this.a, this.b, 1, 1, "", "", this.f155d.t, this.f156f.a);
            if (eVarE != null) {
                e.c.a.g.a.g.g.c.c.j(eVarE, this.f157h);
            }
            return eVarE;
        }
    }

    public static final class b<T> implements Action1 {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.g.g.c.e eVar) {
            if (eVar == null || eVar.a() == null) {
                FeedbackFragment.this.Q0();
                return;
            }
            p1.h(KGApplication.getContext(), "提交成功");
            FeedbackFragment.this.e();
            EventBus.getDefault().post(new e.c.a.g.a.g.g.b.a());
        }
    }

    public static final class c<T> implements Action1 {
        public c() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            FeedbackFragment.this.Q0();
        }
    }

    public static final class d<V> implements Callable {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap call() {
            return e.c.a.g.a.s.f.i(this.a);
        }
    }

    public static final class e<T> implements Action1 {
        public final /* synthetic */ String b;

        public e(String str) {
            this.b = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Bitmap bitmap) {
            FeedbackFragment.this.T0(bitmap, e.c.a.g.a.r.g.e.e());
            FeedbackFragment.this.R0(f.z.d.j.l("showBitmap step = filePath", this.b));
        }
    }

    public static final class f<T> implements Action1 {
        public final /* synthetic */ String b;

        public f(String str) {
            this.b = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            th.printStackTrace();
            FeedbackFragment.this.R0("showBitmap step = e" + th + "filePath" + ((Object) this.b));
        }
    }

    public static final class g<V> implements Callable {
        public final /* synthetic */ Uri b;

        public g(Uri uri) {
            this.b = uri;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap call() {
            Context context = FeedbackFragment.this.getContext();
            ContentResolver contentResolver = context == null ? null : context.getContentResolver();
            Objects.requireNonNull(contentResolver, "ContentResolver is null");
            return MediaStore.Images.Media.getBitmap(contentResolver, this.b);
        }
    }

    public static final class h<T> implements Action1 {
        public final /* synthetic */ Uri b;

        public h(Uri uri) {
            this.b = uri;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Bitmap bitmap) {
            FeedbackFragment.this.T0(bitmap, e.c.a.g.a.r.g.e.e());
            FeedbackFragment.this.R0(f.z.d.j.l("showBitmap step = imgUri.path", this.b.getPath()));
        }
    }

    public static final class i<T> implements Action1 {
        public final /* synthetic */ Uri b;

        public i(Uri uri) {
            this.b = uri;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            th.printStackTrace();
            FeedbackFragment.this.R0("showBitmap step = e" + th + ",imgUri" + this.b);
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FeedbackFragment.this.M0();
        }
    }

    public static final class k implements View.OnClickListener {

        public static final class a implements PermissionsUtil.OnPermissionDilaogListener {
            public final /* synthetic */ FeedbackFragment a;

            public a(FeedbackFragment feedbackFragment) {
                this.a = feedbackFragment;
            }

            @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
            public void onNo() {
                Log.d("mhs_watch", "initData onNo");
            }

            @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
            public void onYes() {
                Log.d("mhs_watch", "initData onYes");
                this.a.I0();
            }
        }

        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            if (u1.h(1000)) {
                return;
            }
            FeedbackFragment feedbackFragment = FeedbackFragment.this;
            Context context = view.getContext();
            f.z.d.j.d(context, "it.context");
            String[] strArr = e.c.a.g.a.r.g.e.b;
            f.z.d.j.d(strArr, "STORAGE_PERMISSIONS");
            if (feedbackFragment.O0(context, strArr)) {
                ArrayList<String> arrayList = new ArrayList<>();
                f.z.d.j.d(strArr, "STORAGE_PERMISSIONS");
                f.u.r.l(arrayList, strArr);
                PermissionsUtil.getInstance().showPermissionRequestDialogCommon(FeedbackFragment.this.getActivity(), FeedbackFragment.this.getString(R.string.storage_permissions_tips), new a(FeedbackFragment.this), arrayList);
                str = ExceptionParse.NET_DNS_FAIL;
            } else {
                FeedbackFragment.this.N0();
                str = ExceptionParse.NET_PING_FAIL;
            }
            FeedbackFragment.this.R0("点击添加图片按钮 " + str + ", isHonor = " + l1.U());
        }
    }

    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (u1.h(1000)) {
                return;
            }
            FeedbackFragment.this.T0(null, null);
            FeedbackFragment.this.R0("点击删除按钮");
        }
    }

    public static final class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.j.a.c().f("fd_question", FeedbackFragment.this.getActivity());
        }
    }

    public static final class n<T> implements e.c.a.g.a.s.y1.a {
        public n() {
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(String str) {
            EditText editText = FeedbackFragment.this.r;
            if (editText == null) {
                return;
            }
            editText.setText(str);
        }
    }

    public static final class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.j.a.c().f("fd_contact", FeedbackFragment.this.getActivity());
        }
    }

    public static final class p<T> implements e.c.a.g.a.s.y1.a {
        public p() {
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(String str) {
            EditText editText = FeedbackFragment.this.s;
            if (editText == null) {
                return;
            }
            editText.setText(str);
        }
    }

    public static final class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FeedbackFragment.this.K0(1);
        }
    }

    public static final class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FeedbackFragment.this.K0(2);
        }
    }

    public static final class s<T> implements Action1 {
        public s() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) throws Throwable {
            if (FeedbackFragment.this.z != null) {
                Log.e("mhs_watch_img", "showBitmap step = bm != null 上传图片。");
                e.c.a.g.a.s.q.k(e.c.a.g.a.r.g.e.e());
                a0.h(FeedbackFragment.this.z, e.c.a.g.a.r.g.e.e(), Bitmap.CompressFormat.JPEG, 30);
                File file = new File(e.c.a.g.a.r.g.e.e());
                long length = file.length();
                String str2 = "showBitmap step, TakingUserImageUtil.getFeedBackImageFilePath() = " + ((Object) e.c.a.g.a.r.g.e.e()) + ", 图片上传文件大小 = " + length;
                FeedbackFragment.this.R0(str2);
                Log.e("mhs_watch_img", str2);
                if ((!file.exists() || length == 0) && !FeedbackFragment.this.C) {
                    FeedbackFragment.this.C = true;
                    FeedbackFragment.this.S0();
                }
            }
        }
    }

    public FeedbackFragment() {
        this.A = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.g0, 1) == 1;
        this.B = new e.c.a.g.a.g.g.c.c();
    }

    public final void I0() {
        requestPermissions(e.c.a.g.a.r.g.e.b, 10923);
    }

    public final void J0(String str) {
        String str2;
        String strE = e.c.a.g.a.r.g.e.e();
        try {
            str2 = "key =" + str + "TakingUserImageUtil.getFeedBackImageFilePath()" + ((Object) strE) + ", exist = " + e.c.a.g.a.s.q.F(strE) + ", length = " + new File(strE).length();
        } catch (Exception e2) {
            e2.printStackTrace();
            str2 = "";
        }
        Log.e("mhs_watch_feedback", f.z.d.j.l("checkFileLog, result = ", str2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.util.ArrayList] */
    public final void K0(int i2) {
        int i3;
        e.c.a.g.a.r.c.a aVar;
        if (u0.m(KGApplication.getContext())) {
            EditText editText = this.r;
            String strValueOf = String.valueOf(editText == null ? null : editText.getText());
            EditText editText2 = this.s;
            String strValueOf2 = String.valueOf(editText2 != null ? editText2.getText() : null);
            if (TextUtils.isEmpty(strValueOf)) {
                p1.h(KGApplication.getContext(), this.t == 2 ? "需要填写举报内容后提交哦~" : "需要填写建议或问题后提交哦~");
                return;
            }
            if (strValueOf.length() > 100) {
                p1.h(KGApplication.getContext(), this.t == 2 ? "举报字数最多不超过100个字~~" : "反馈字数最多不超过100个字~");
                return;
            }
            if (TextUtils.isEmpty(strValueOf2)) {
                p1.h(KGApplication.getContext(), "请填写联系方式~");
                return;
            }
            if (u0.n(KGApplication.getContext(), true)) {
                f.z.d.r rVar = new f.z.d.r();
                rVar.a = new ArrayList();
                int i4 = this.t;
                String str = i4 == 2 ? "举报内容提交失败~" : "反馈提交失败~";
                boolean z = false;
                if (i4 == 1 && (aVar = this.y) != null) {
                    f.z.d.j.c(aVar);
                    if (!TextUtils.isEmpty(aVar.a())) {
                        e.c.a.g.a.r.c.a aVar2 = this.y;
                        f.z.d.j.c(aVar2);
                        if (e.c.a.g.a.s.q.F(aVar2.a())) {
                            e.c.a.g.a.r.c.a aVar3 = this.y;
                            f.z.d.j.c(aVar3);
                            if (new File(aVar3.a()).length() > 0) {
                                ArrayList arrayList = (ArrayList) rVar.a;
                                e.c.a.g.a.r.c.a aVar4 = this.y;
                                f.z.d.j.c(aVar4);
                                arrayList.add(aVar4);
                                z = true;
                            }
                        }
                    }
                }
                if (z && (i3 = this.t) == 1) {
                    this.B.k(this, strValueOf, strValueOf2, 1, 1, "", "", i3, (List) rVar.a, str, i2);
                } else {
                    Observable.just(1).subscribeOn(Schedulers.io()).map(new a(strValueOf, strValueOf2, this, rVar, i2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(), new c());
                }
                e.c.a.g.a.e.b.b(new YoungBITask(20488, "statistics"));
            }
        }
    }

    public final String L0() {
        return e.c.a.g.a.f.e.c.a.a().b(e.c.a.g.a.f.e.b.g2, "");
    }

    public final void M0() {
        l1.J(getContext(), this.r);
        l1.J(getContext(), this.s);
    }

    public final void N0() {
        e.c.a.g.a.r.g.e.l(getActivity(), 10923);
    }

    public final boolean O0(Context context, String[] strArr) {
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            if (ContextCompat.checkSelfPermission(context, str) == -1) {
                return true;
            }
        }
        return false;
    }

    public final void P0(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Log.e("mhs_watch_img", "onActivityResult = " + i2 + ", resultCode = " + i3 + ", data = " + intent + ", stack" + Log.getStackTraceString(new Throwable("onActivityResult")));
        if (i3 == -1 && i2 == 10923 && intent != null) {
            Bundle extras = intent.getExtras();
            String str = (String) (extras == null ? null : extras.get("output"));
            try {
                if (TextUtils.isEmpty(str) || !e.c.a.g.a.s.q.F(str)) {
                    Uri data = intent.getData();
                    if (data != null) {
                        Observable.fromCallable(new g(data)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(data), new i(data));
                        return;
                    }
                    return;
                }
                try {
                    Observable.fromCallable(new d(str)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(str), new f(str));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                R0(f.z.d.j.l("showBitmap step = filePath", str));
            } catch (Exception e3) {
                e3.printStackTrace();
                R0(f.z.d.j.l("step = e", Log.getStackTraceString(e3)));
            }
        }
    }

    public final void Q0() {
        p1.h(KGApplication.getContext(), this.t == 2 ? "举报内容提交失败~" : "反馈提交失败~");
    }

    public final void R0(String str) {
        f.z.d.j.e(str, "step");
        RingBiReportHelper.INSTANCE.reportHeadFeedBack(str);
    }

    public final void S0() {
        m1.f(new s());
    }

    public final void T0(Bitmap bitmap, String str) {
        if (bitmap == null || bitmap.isRecycled()) {
            ImageView imageView = this.w;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            ImageView imageView2 = this.x;
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            ImageView imageView3 = this.v;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            this.y = null;
        } else {
            ImageView imageView4 = this.w;
            if (imageView4 != null) {
                imageView4.setImageBitmap(bitmap);
            }
            ImageView imageView5 = this.w;
            if (imageView5 != null) {
                imageView5.setVisibility(0);
            }
            ImageView imageView6 = this.x;
            if (imageView6 != null) {
                imageView6.setVisibility(0);
            }
            ImageView imageView7 = this.v;
            if (imageView7 != null) {
                imageView7.setVisibility(4);
            }
            e.c.a.g.a.r.c.a aVar = new e.c.a.g.a.r.c.a();
            this.y = aVar;
            if (aVar != null) {
                aVar.b(str);
            }
        }
        this.z = bitmap;
        S0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        P0(i2, i3, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        J0("删除开始");
        String strE = e.c.a.g.a.r.g.e.e();
        if (!TextUtils.isEmpty(strE) && !e.c.a.g.a.s.q.F(strE)) {
            e.c.a.g.a.s.q.k(strE);
        }
        J0("删除结束");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.z.d.j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_feed_back, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        M0();
        this.B.i();
        e.c.a.g.a.s.q.k(e.c.a.g.a.r.g.e.e());
        e.c.a.g.a.j.a.c().e("fd_question");
        e.c.a.g.a.j.a.c().e("fd_contact");
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        f.z.d.j.e(strArr, "permissions");
        f.z.d.j.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 10923) {
            int i3 = 0;
            int length = iArr.length;
            while (i3 < length) {
                int i4 = iArr[i3];
                i3++;
                if (i4 == -1) {
                    R0("step = action =SELECT_PICTURE_FROM_FEEDBACK  PERMISSION_DENIED");
                    String strL0 = L0();
                    if (TextUtils.isEmpty(strL0)) {
                        return;
                    }
                    p1.h(KGApplication.getContext(), strL0);
                    return;
                }
            }
            e.c.a.g.a.f.f.a.f();
            N0();
            R0("step = action =jumpToGallery");
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        RelativeLayout relativeLayout;
        f.z.d.j.e(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Integer numValueOf = arguments == null ? null : Integer.valueOf(arguments.getInt("key_fun_type", this.t));
        this.t = numValueOf == null ? this.t : numValueOf.intValue();
        View viewJ0 = j0(R.id.content_view);
        if (viewJ0 != null) {
            viewJ0.setOnClickListener(new j());
        }
        if (l1.V() && this.A) {
            j0(R.id.rootLayout).requestFocus();
        }
        this.r = (EditText) view.findViewById(R.id.et_feed_back_question);
        this.s = (EditText) view.findViewById(R.id.et_feed_back_contact);
        this.u = (RelativeLayout) view.findViewById(R.id.iv_feed_back_add_image);
        this.v = (ImageView) view.findViewById(R.id.iv_feed_back_add_icon);
        this.w = (ImageView) view.findViewById(R.id.iv_feed_back_add_result);
        this.x = (ImageView) view.findViewById(R.id.iv_feed_back_del_icon);
        RelativeLayout relativeLayout2 = this.u;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new k());
        }
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setOnClickListener(new l());
        }
        ((TextView) view.findViewById(R.id.title)).setText(this.t == 2 ? "我要举报" : "我要反馈");
        EditText editText = this.r;
        if (editText != null) {
            editText.setHint(this.t == 2 ? "告诉我你要举报的内容" : "告诉我你遇到的问题");
        }
        if (e.c.a.g.a.j.a.c().b()) {
            EditText editText2 = this.r;
            if (editText2 != null) {
                editText2.setFocusable(false);
                editText2.setFocusableInTouchMode(false);
                editText2.setOnClickListener(new m());
                e.c.a.g.a.j.a.c().a("fd_question", new n());
            }
            EditText editText3 = this.s;
            if (editText3 != null) {
                editText3.setFocusable(false);
                editText3.setFocusableInTouchMode(false);
                editText3.setOnClickListener(new o());
                e.c.a.g.a.j.a.c().a("fd_contact", new p());
            }
        }
        if (!e.c.a.g.a.g.g.a.a.a(this.t) && (relativeLayout = this.u) != null) {
            relativeLayout.setVisibility(8);
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_send_log);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_send);
        e.c.a.g.a.d.d0.c cVar = e.c.a.g.a.d.d0.c.a;
        if (cVar.r() && cVar.e() && this.t == 1) {
            textView.setVisibility(0);
            textView.setTextColor(getResources().getColor(R.color.white));
            textView.setBackgroundResource(R.drawable.common_btn_feedback_blue);
            textView2.setTextColor(getResources().getColor(R.color.E6000000));
            textView2.setBackgroundResource(R.drawable.common_btn_feedback_white);
        } else {
            textView.setVisibility(8);
            textView2.setTextColor(getResources().getColor(R.color.white));
            textView2.setBackgroundResource(R.drawable.common_btn_feedback_blue);
            textView.setTextColor(getResources().getColor(R.color.E6000000));
            textView.setBackgroundResource(R.drawable.common_btn_feedback_white);
        }
        textView.setOnClickListener(new q());
        textView2.setOnClickListener(new r());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "反馈页";
    }
}
