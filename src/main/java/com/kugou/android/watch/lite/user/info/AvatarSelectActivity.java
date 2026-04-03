package com.kugou.android.watch.lite.user.info;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.DelegateActivity;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import com.kugou.common.apm.task.ChangePicAPM;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.r.d.d.f;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.q;
import e.c.a.g.a.s.u0;
import f.z.d.j;
import f.z.d.r;
import java.util.ArrayList;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class AvatarSelectActivity extends DelegateActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GridView f220d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f221f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e.c.a.g.a.r.d.a f222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f223i = -1;
    public final ArrayList<String> j = new ArrayList<>();
    public String k = "";
    public Handler l = new Handler(Looper.getMainLooper());
    public Subscription m;
    public Subscription n;
    public final boolean o;
    public final ChangePicAPM p;
    public final String q;
    public final int r;
    public final e.c.a.g.a.k.d.a s;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.c.a.g.a.r.d.a aVar = AvatarSelectActivity.this.f222h;
            if (aVar == null) {
                return;
            }
            aVar.notifyDataSetChanged();
        }
    }

    public static final class b<T> implements Action1 {

        public static final class a implements Runnable {
            public final /* synthetic */ AvatarSelectActivity a;

            public a(AvatarSelectActivity avatarSelectActivity) {
                this.a = avatarSelectActivity;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e.c.a.g.a.r.d.a aVar = this.a.f222h;
                if (aVar == null) {
                    return;
                }
                aVar.notifyDataSetChanged();
            }
        }

        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<String> cVar) {
            Log.e("mhs_watch_avatar", j.l("getAvatarList api resp.isSuccess = ", Boolean.valueOf(cVar.f())));
            AvatarSelectActivity.this.d();
            String str = cVar.f() ? "成功" : "失败";
            AvatarSelectActivity.this.I();
            int i2 = 0;
            if (cVar.f()) {
                try {
                    JSONArray jSONArray = new JSONObject(cVar.a()).getJSONArray("list");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        try {
                            AvatarSelectActivity.this.j.clear();
                            int length2 = jSONArray.length();
                            if (length2 > 0) {
                                int i3 = 0;
                                while (true) {
                                    int i4 = i2 + 1;
                                    try {
                                        Object obj = jSONArray.get(i2);
                                        if (obj == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                        }
                                        String strOptString = ((JSONObject) obj).optString("img", "");
                                        if (!TextUtils.isEmpty(strOptString) && i3 < 9) {
                                            AvatarSelectActivity.this.j.add(strOptString);
                                            i3++;
                                        }
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                    if (i4 >= length2) {
                                        break;
                                    } else {
                                        i2 = i4;
                                    }
                                }
                            }
                            AvatarSelectActivity avatarSelectActivity = AvatarSelectActivity.this;
                            avatarSelectActivity.P(avatarSelectActivity.j);
                            Log.e("mhs_watch_avatar", j.l("getAvatarList 大小 = ", Integer.valueOf(AvatarSelectActivity.this.j.size())));
                            e.c.a.g.a.r.d.a aVar = AvatarSelectActivity.this.f222h;
                            if (aVar != null) {
                                aVar.notifyDataSetChanged();
                            }
                            AvatarSelectActivity.this.S();
                            i2 = length;
                        } catch (Exception e3) {
                            e = e3;
                            i2 = length;
                            e.printStackTrace();
                        }
                    }
                    Log.e("mhs_watch_avatar", "getAvatarList success resp mixsongids = " + jSONArray + ", concatenatedString = " + AvatarSelectActivity.this.j);
                } catch (Exception e4) {
                    e = e4;
                }
                AvatarSelectActivity avatarSelectActivity2 = AvatarSelectActivity.this;
                if (avatarSelectActivity2.C(avatarSelectActivity2.j)) {
                    AvatarSelectActivity.this.G().post(new a(AvatarSelectActivity.this));
                }
                AvatarSelectActivity avatarSelectActivity3 = AvatarSelectActivity.this;
                j.d(cVar, "resp");
                avatarSelectActivity3.N(cVar);
            } else {
                AvatarSelectActivity.this.L(null, 13);
            }
            if (AvatarSelectActivity.this.j.size() < 9) {
                AvatarSelectActivity.this.E();
            }
            RingBiReportHelper.reportHeadGrade$default(RingBiReportHelper.INSTANCE, "官方头像修改，getAvatarList 上传结果 result = " + str + ", resp.listSize = " + i2 + ", resp.errorMsg = " + ((Object) cVar.c()) + ", resp.errcode = " + cVar.b(), null, 2, null);
        }
    }

    public static final class c<T> implements Action1 {
        public c() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            Log.e("mhs_watch_avatar", j.l("uploadGradeResult success resp.error error = ", th));
            AvatarSelectActivity.this.L(th, 12);
            AvatarSelectActivity.this.d();
        }
    }

    public static final class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            AvatarSelectActivity.this.f223i = i2;
            e.c.a.g.a.r.d.a aVar = AvatarSelectActivity.this.f222h;
            j.c(aVar);
            aVar.b(i2);
            AvatarSelectActivity avatarSelectActivity = AvatarSelectActivity.this;
            Object obj = avatarSelectActivity.j.get(AvatarSelectActivity.this.f223i);
            j.d(obj, "avatarUrls[selectedPosition]");
            avatarSelectActivity.k = (String) obj;
            e.c.a.g.a.e.b.b(new YoungBITask(22020034, "click").setSvar1(AvatarSelectActivity.this.k));
        }
    }

    public static final class e implements View.OnClickListener {

        public static final class a extends CustomTarget<Bitmap> {
            public final /* synthetic */ AvatarSelectActivity a;
            public final /* synthetic */ r<String> b;

            public a(AvatarSelectActivity avatarSelectActivity, r<String> rVar) {
                this.a = avatarSelectActivity;
                this.b = rVar;
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.String] */
            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(Drawable drawable) {
                super.onLoadFailed(drawable);
                try {
                    this.b.a = this.b.a + "onLoadFailed, selectedAvatarUrl = " + this.a.k;
                    this.a.R(this.b.a);
                } catch (Exception unused) {
                }
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.String] */
            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                j.e(bitmap, "resource");
                this.a.T(bitmap);
                this.b.a = this.b.a + ",onResourceReady selectedAvatarUrl = " + this.a.k;
                this.a.R(this.b.a);
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (AvatarSelectActivity.this.f223i == -1) {
                Toast.makeText(AvatarSelectActivity.this, "请先选择头像", 0).show();
                return;
            }
            AvatarSelectActivity.this.p.start(3);
            AvatarSelectActivity avatarSelectActivity = AvatarSelectActivity.this;
            Object obj = avatarSelectActivity.j.get(AvatarSelectActivity.this.f223i);
            j.d(obj, "avatarUrls[selectedPosition]");
            avatarSelectActivity.k = (String) obj;
            e.c.a.g.a.r.d.a aVar = AvatarSelectActivity.this.f222h;
            Map<String, Bitmap> map = aVar == null ? null : aVar.f1163h;
            j.c(map);
            Bitmap bitmap = map.get(AvatarSelectActivity.this.k);
            if (bitmap != null) {
                AvatarSelectActivity.this.T(bitmap);
                return;
            }
            r rVar = new r();
            rVar.a = "图片拿不到";
            Glide.with((FragmentActivity) AvatarSelectActivity.this).asBitmap().load(AvatarSelectActivity.this.k).into(new a(AvatarSelectActivity.this, rVar));
        }
    }

    public static final class f<T, R> implements Func1 {
        public f() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f.b call(Bitmap bitmap) {
            q.k(e.c.a.g.a.r.g.e.f());
            a0.f(bitmap, e.c.a.g.a.r.g.e.f(), Bitmap.CompressFormat.JPEG);
            AvatarSelectActivity.this.R("uploadAvatar start");
            return new e.c.a.g.a.r.d.d.f().b();
        }
    }

    public static final class g<T> implements Action1 {
        public g() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(f.b bVar) {
            AvatarSelectActivity.this.d();
            if (bVar.a) {
                p1.h(AvatarSelectActivity.this, "头像保存成功");
                e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.action.user_avatar_update"));
                EventBus.getDefault().post(new e.c.a.g.a.r.d.b(1, 200, AvatarSelectActivity.this.k));
                AvatarSelectActivity.this.R("uploadAvatar end api suc");
            } else if (TextUtils.isEmpty(bVar.b)) {
                p1.g(AvatarSelectActivity.this, R.string.net_error);
                AvatarSelectActivity.this.R("step = other net");
            } else {
                p1.h(AvatarSelectActivity.this, bVar.b);
                AvatarSelectActivity.this.R(j.l("step = api, result.errorMsg = ", bVar.b));
            }
            AvatarSelectActivity avatarSelectActivity = AvatarSelectActivity.this;
            j.d(bVar, "result");
            avatarSelectActivity.M(bVar);
            AvatarSelectActivity.this.finish();
        }
    }

    public static final class h<T> implements Action1 {
        public h() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            th.printStackTrace();
            p1.g(AvatarSelectActivity.this, R.string.net_error);
            AvatarSelectActivity.this.R("step = other net 2");
            AvatarSelectActivity.this.K(th);
        }
    }

    public AvatarSelectActivity() {
        this.o = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.m0, 1) == 1;
        this.p = new ChangePicAPM();
        this.q = "选择官方头像";
        this.r = 1;
        this.s = new e.c.a.g.a.k.d.a(ApmDataTypeID.OFFICE_IMG_PIC);
    }

    public final boolean C(ArrayList<String> arrayList) {
        if (arrayList.size() == 9) {
            return false;
        }
        arrayList.clear();
        arrayList.add("https://youthimgbssdl.kugou.com/8c67b7e4176e556918bc9627e2592e90.jpg");
        arrayList.add("https://youthimgbssdl.kugou.com/9fe87f0f31c5feef2fb697575ffbd3f2.jpg");
        arrayList.add("https://youthimgbssdl.kugou.com/4035851cbe3a5b855bf640306416ac4c.jpg");
        arrayList.add("https://youthimgbssdl.kugou.com/a2534710e0d792f31143c358da37826a.jpg");
        arrayList.add("https://youthimgbssdl.kugou.com/976001f0ede61a4033a71e2d39dde254.jpg");
        arrayList.add("https://youthimgbssdl.kugou.com/633878bdafc09e0c993750f180da7666.jpg");
        arrayList.add("https://youthimgbssdl.kugou.com/05132f753e87fd509f212ac70bcdf12e.jpg");
        arrayList.add("https://youthimgbssdl.kugou.com/f34e8b1ecd9fd02a2b7c5438955c83c6.jpg");
        arrayList.add("https://youthimgbssdl.kugou.com/04d5fe7c7a637e2e0cb1b311f63ee926.jpg");
        return true;
    }

    public final int D(int i2, Context context) {
        j.e(context, "context");
        return (int) (i2 * context.getResources().getDisplayMetrics().density);
    }

    public final void E() {
        try {
            this.j.clear();
            if (TextUtils.isEmpty(e.c.a.g.a.f.m.c.a.d("last_change_avatar_save_pic_0", ""))) {
                C(this.j);
                P(this.j);
                Log.d("mhs_watch_avatar", "首次添加做缓存");
            } else {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    try {
                        String strD = e.c.a.g.a.f.m.c.a.d(j.l("last_change_avatar_save_pic_", Integer.valueOf(i2)), "");
                        if (!TextUtils.isEmpty(strD)) {
                            ArrayList<String> arrayList = this.j;
                            j.c(strD);
                            arrayList.add(strD);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (i3 >= 9) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
                Log.d("mhs_watch_avatar", "读取上次内容");
                C(this.j);
            }
            this.l.post(new a());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void F() {
        boolean zH = H();
        Log.d("mhs_watch_avatar", j.l("checkAndReportIfNeeded do. watch.switch.upload_history_enable = ", Boolean.valueOf(zH)));
        if (!zH) {
            Log.e("mhs_watch_avatar", "checkAndReportIfNeeded switch false.");
        } else {
            if (!u0.n(KGApplication.getContext(), false)) {
                Log.e("mhs_watch_avatar", j.l("checkAndReportIfNeeded 没有login直接返回, isGlobalNetAvailable = ", Boolean.valueOf(u0.n(KGApplication.getContext(), false))));
                return;
            }
            o(e.c.a.g.a.d.w.a.e(this), 4, true);
            i1.a(this.m);
            this.m = e.c.a.g.a.g.e.a.a.a().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(), new c());
        }
    }

    public final Handler G() {
        return this.l;
    }

    public final boolean H() {
        return l1.m0() && e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.o3, 1) == 1;
    }

    public final void I() {
        this.s.e();
    }

    public final void J() {
        this.s.g();
    }

    public final void K(Throwable th) {
        this.p.fail(th, (Integer) 5, "接口异常");
    }

    public final void L(Throwable th, Integer num) {
        this.s.b(th, this.r, this.q, num);
        E();
    }

    public final void M(f.b bVar) {
        j.e(bVar, "songResp");
        if (bVar.a) {
            this.p.netFinish();
            this.p.success("修改头像成功");
            return;
        }
        ChangePicAPM changePicAPM = this.p;
        e.c.a.b.a.a.a.a aVar = new e.c.a.b.a.a.a.a(bVar.c);
        String str = bVar.b;
        j.d(str, "songResp.errorMsg");
        changePicAPM.fail((Throwable) aVar, (Integer) 6, str);
    }

    public final void N(e.c.a.g.a.f.k.c<String> cVar) {
        j.e(cVar, "songResp");
        if (!cVar.f()) {
            L(new e.c.a.b.a.a.a.a(cVar.b()), 11);
            return;
        }
        boolean z = false;
        try {
            JSONArray jSONArray = new JSONObject(cVar.a()).getJSONArray("list");
            if (jSONArray != null) {
                if (jSONArray.length() > 0) {
                    z = true;
                }
            }
        } catch (Exception unused) {
        }
        this.s.i(z);
    }

    public final void O() {
    }

    public final void P(ArrayList<String> arrayList) {
        j.e(arrayList, "avatarUrls");
        Log.e("mhs_watch_avatar", j.l("putImageUrl2MMKV 大小 = ", Integer.valueOf(arrayList.size())));
        if (arrayList.size() != 9) {
            return;
        }
        int i2 = 0;
        int size = arrayList.size();
        if (size <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            try {
                String str = arrayList.get(i2);
                j.d(str, "avatarUrls.get(i)");
                e.c.a.g.a.f.m.c.a.i(j.l("last_change_avatar_save_pic_", Integer.valueOf(i2)), str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i3 >= size) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public final void Q() {
        e.c.a.g.a.e.b.b(new YoungBITask(22020032, "exposure"));
    }

    public final void R(String str) {
        if (this.o) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setFo("编辑头像官方").setType("1").setSvar1(str));
            e.c.a.g.a.d.d0.a.a("EditUserPicActivity", j.l("reportHead 1, ", str));
        } else if (g0.f()) {
            g0.c("mhs_watch", j.l("TYPE_PIC needReport = ", Boolean.valueOf(this.o)));
        }
    }

    public final void S() {
        this.s.j();
    }

    public final void T(Bitmap bitmap) {
        n(e.c.a.g.a.d.w.a.e(this), 4);
        i1.a(this.n);
        this.n = Observable.just(bitmap).subscribeOn(Schedulers.io()).map(new f()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(), new h());
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_choose_user_pic);
        J();
        this.f220d = (GridView) findViewById(R.id.gridViewAvatars);
        this.f221f = (TextView) findViewById(R.id.btnSave);
        e.c.a.g.a.r.d.a aVar = new e.c.a.g.a.r.d.a(this, this.j);
        this.f222h = aVar;
        GridView gridView = this.f220d;
        if (gridView != null) {
            gridView.setAdapter((ListAdapter) aVar);
        }
        GridView gridView2 = this.f220d;
        if (gridView2 != null) {
            gridView2.setHorizontalSpacing(D(2, this));
        }
        GridView gridView3 = this.f220d;
        if (gridView3 != null) {
            gridView3.setVerticalSpacing(D(2, this));
        }
        GridView gridView4 = this.f220d;
        if (gridView4 != null) {
            gridView4.setOnItemClickListener(new d());
        }
        TextView textView = this.f221f;
        if (textView != null) {
            textView.setOnClickListener(new e());
        }
        O();
        F();
        Q();
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        i1.a(this.m);
        i1.a(this.n);
        e.c.a.g.a.r.d.a aVar = this.f222h;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }
}
