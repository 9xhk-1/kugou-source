package com.kugou.android.watch.lite.component.ringtone;

import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.component.ringtone.widget.AudioSliderBar;
import com.kugou.common.apm.task.MusicRingToneAPM;
import com.kugou.common.apm.task.SetRingClickBtnAPM;
import com.kugou.common.apm.task.SetRingPageAPM;
import com.kugou.common.event.RingToneStatusItemEvent;
import com.kugou.common.permission.Action;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Permission;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.kugou.common.utils.PermissionsUtil;
import e.c.a.g.a.g.n.a;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u1;
import f.z.d.u;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.apache.http.HttpStatus;
import org.apache.http.cookie.ClientCookie;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class RingtoneFragment extends DelegateFragment implements View.OnClickListener {
    public e.c.a.g.a.g.n.a A;
    public e.c.a.g.a.g.n.g.c B;
    public e.c.a.g.a.g.n.c C;
    public Subscription D;
    public Subscription E;
    public boolean F = true;
    public final ForegroundColorSpan G = new ForegroundColorSpan(ContextCompat.getColor(KGApplication.getContext(), R.color.app_blue));
    public final SetRingPageAPM H = new SetRingPageAPM();
    public final SetRingClickBtnAPM I = new SetRingClickBtnAPM();
    public View r;
    public AudioSliderBar s;
    public TextView t;
    public ImageView u;
    public View v;
    public View w;
    public TextView x;
    public TextView y;
    public KGMusicWrapper z;

    public static final class a<T> implements Action {
        public a() {
        }

        @Override // com.kugou.common.permission.Action
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onAction(List<String> list) {
            p1.h(RingtoneFragment.this.getContext(), "授权存储权限才可保存铃声哦");
            SetRingClickBtnAPM.fail$default(RingtoneFragment.this.I, 3, "授权存储权限才可保存铃声哦", null, 4, null);
        }
    }

    public static final class b<T> implements Action {
        public b() {
        }

        @Override // com.kugou.common.permission.Action
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onAction(List<String> list) {
            RingtoneFragment.this.U0();
        }
    }

    public static final class c implements a.b {

        public static final class a implements Runnable {
            public final /* synthetic */ RingtoneFragment a;

            public a(RingtoneFragment ringtoneFragment) {
                this.a = ringtoneFragment;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.j1();
            }
        }

        public c() {
        }

        @Override // e.c.a.g.a.g.n.a.b
        public void onLoadFail(Integer num, String str) {
            RingtoneFragment ringtoneFragment = RingtoneFragment.this;
            ringtoneFragment.n0(new a(ringtoneFragment));
            SetRingPageAPM.fail$default(RingtoneFragment.this.H, num, str, null, 4, null);
        }

        @Override // e.c.a.g.a.g.n.a.b
        public void onLoadSuccess(String str) {
            f.z.d.j.e(str, ClientCookie.PATH_ATTR);
            RingtoneFragment.this.V0();
            RingtoneFragment.this.S0(str);
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = new d();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (g0.f()) {
                g0.b("RingtoneFragment", "loadingViewContainer click");
            }
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RingtoneFragment.this.T0();
        }
    }

    public static final class f<T, R> implements Func1 {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Observable<? extends e.c.a.g.a.g.n.g.c> call(String str) throws IOException {
            String str2;
            File file = new File(this.a);
            e.c.a.g.a.g.n.g.c cVarC = e.c.a.g.a.g.n.g.c.c(this.a, "mp3", null);
            if (cVarC != null && cVarC.f() >= 1) {
                return Observable.just(cVarC);
            }
            String name = file.getName();
            f.z.d.j.d(name, "file.name");
            Locale locale = Locale.getDefault();
            f.z.d.j.d(locale, "getDefault()");
            String lowerCase = name.toLowerCase(locale);
            f.z.d.j.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            Object[] array = f.e0.o.S(lowerCase, new String[]{"\\."}, false, 0, 6, null).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            if (l0.f(strArr) < 2) {
                str2 = "该文件格式不支持,请重新选择";
            } else {
                str2 = "对不起,暂不支持" + ((String) f.u.i.o(strArr)) + "格式,请重新选择";
            }
            return Observable.error(new e.c.a.g.a.f.k.b(str2));
        }
    }

    public static final class g<T> implements Action1 {
        public final /* synthetic */ String b;

        public g(String str) {
            this.b = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.g.n.g.c cVar) {
            int[] iArrD;
            RingtoneFragment.this.B = cVar;
            RingtoneFragment.this.l1();
            RingtoneFragment.this.g1();
            RingtoneFragment.this.d1(f.z.d.j.l("cheapSoundFile path = ", this.b), "loadRingtoneFile");
            try {
                RingtoneFragment ringtoneFragment = RingtoneFragment.this;
                StringBuilder sb = new StringBuilder();
                sb.append("frameLens = ");
                e.c.a.g.a.g.n.g.c cVar2 = RingtoneFragment.this.B;
                Integer numValueOf = null;
                if (cVar2 != null && (iArrD = cVar2.d()) != null) {
                    numValueOf = Integer.valueOf(iArrD.length);
                }
                sb.append(numValueOf);
                sb.append(", cheapSoundFile path = ");
                sb.append(this.b);
                sb.append(", size = ");
                sb.append(new File(this.b).length());
                sb.append(", getSongName = ");
                sb.append((Object) RingtoneFragment.this.O0());
                ringtoneFragment.Y0(sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static final class h<T> implements Action1 {
        public final /* synthetic */ String b;

        public h(String str) {
            this.b = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            if (th instanceof e.c.a.g.a.f.k.b) {
                RingtoneFragment.this.h1(th.getMessage());
            } else {
                RingtoneFragment.this.h1("铃声文件读取失败，请退出重试");
            }
            RingtoneFragment.this.d1(f.z.d.j.l("error =", Log.getStackTraceString(th)), "loadRingtoneFile");
            RingtoneFragment.this.X0(th, 3, ", cheapSoundFile path = " + this.b + ", size = " + new File(this.b).length() + ", getSongName = " + ((Object) RingtoneFragment.this.O0()));
        }
    }

    public static final class i<T> implements Action {
        public i() {
        }

        @Override // com.kugou.common.permission.Action
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onAction(Void r7) {
            if (RingtoneFragment.this.P0()) {
                RingtoneFragment.this.k1();
            } else {
                p1.h(RingtoneFragment.this.getContext(), "授权系统设置权限才可设置铃声哦");
                SetRingClickBtnAPM.fail$default(RingtoneFragment.this.I, 4, "授权系统设置权限才可设置铃声哦", null, 4, null);
            }
        }
    }

    public static final class j<T> implements Action {
        public j() {
        }

        @Override // com.kugou.common.permission.Action
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onAction(Void r1) {
            RingtoneFragment.this.k1();
        }
    }

    public static final class k implements PermissionsUtil.OnPermissionDilaogListener {
        public k() {
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onNo() {
            Log.d("mhs_watch", "initData onNo");
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onYes() {
            Log.d("mhs_watch", "initData onYes");
            RingtoneFragment.this.M0();
        }
    }

    public static final class l<T> implements Action1 {
        public l() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<e.c.a.g.a.d.d.b> cVar) {
            String strL = f.z.d.j.l("isProgressDialogShowing = ", Boolean.valueOf(RingtoneFragment.this.m0()));
            if (RingtoneFragment.this.m0()) {
                RingtoneFragment.this.i0();
                e.c.a.g.a.d.d.b bVarA = cVar.a();
                String str = strL + ", resp.isSuccess = " + cVar.f() + ", data = " + bVarA;
                if (!cVar.f() || bVarA == null) {
                    p1.h(KGApplication.getContext(), "请求失败，请稍后重试");
                    strL = f.z.d.j.l(str, "请求失败，请稍后重试");
                } else {
                    long j = 1000;
                    int i2 = (int) (bVarA.f373e / j);
                    int iMin = (int) (bVarA.f374f / j);
                    if (i2 >= iMin || iMin <= 0) {
                        AudioSliderBar audioSliderBar = RingtoneFragment.this.s;
                        if (audioSliderBar == null) {
                            f.z.d.j.t("mSliderBar");
                            throw null;
                        }
                        iMin = Math.min(30, audioSliderBar.getMaxProgress());
                        i2 = 0;
                    }
                    AudioSliderBar audioSliderBar2 = RingtoneFragment.this.s;
                    if (audioSliderBar2 == null) {
                        f.z.d.j.t("mSliderBar");
                        throw null;
                    }
                    audioSliderBar2.l(i2, iMin);
                    RingtoneFragment.this.m1(false);
                    strL = str + i2 + iMin;
                }
            }
            RingtoneFragment.this.d1(f.z.d.j.l("接口返回成功 = ", strL), "onSmartCutClick");
        }
    }

    public static final class m<T> implements Action1 {
        public m() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            RingtoneFragment.this.i0();
            p1.h(KGApplication.getContext(), "网络异常，请稍后重试");
            RingtoneFragment.this.d1("网络异常，请稍后重试", "onSmartCutClick");
        }
    }

    public static final class n<T, R> implements Func1 {
        public final /* synthetic */ e.c.a.g.a.g.n.g.c a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f185d;

        public n(e.c.a.g.a.g.n.g.c cVar, int i2, int i3) {
            this.a = cVar;
            this.b = i2;
            this.f185d = i3;
        }

        public final File a(File file) throws e.c.a.g.a.f.k.b {
            try {
                e.c.a.g.a.g.n.g.c cVar = this.a;
                int i2 = this.b;
                cVar.b(file, i2, this.f185d - i2);
                return file;
            } catch (IOException e2) {
                g0.i(e2);
                throw new e.c.a.g.a.f.k.b("铃声写入失败", e2);
            }
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) throws e.c.a.g.a.f.k.b {
            File file = (File) obj;
            a(file);
            return file;
        }
    }

    public static final class o<T, R> implements Func1 {
        public final /* synthetic */ int b;

        public o(int i2) {
            this.b = i2;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean call(File file) throws e.c.a.g.a.f.k.b {
            if (g0.a) {
                g0.b("ringtone_frag", f.z.d.j.l("saveRingtone: finish cut out: ", file));
            }
            try {
                long length = e.c.a.g.a.s.q.F(file.getAbsolutePath()) ? new File(file.getAbsolutePath()).length() : -10L;
                RingtoneFragment ringtoneFragment = RingtoneFragment.this;
                StringBuilder sb = new StringBuilder();
                sb.append("out = ");
                sb.append((Object) (file == null ? null : file.getAbsolutePath()));
                sb.append(", size = ");
                sb.append(length);
                ringtoneFragment.d1("铃声设置本地本地位置", sb.toString());
            } catch (Exception unused) {
            }
            if (!e.c.a.g.a.s.q.F(file.getAbsolutePath())) {
                throw new e.c.a.g.a.f.k.b("铃声裁剪失败", null);
            }
            RingtoneFragment ringtoneFragment2 = RingtoneFragment.this;
            f.z.d.j.d(file, "out");
            return Boolean.valueOf(ringtoneFragment2.f1(file, this.b));
        }
    }

    public static final class p<T> implements Action1 {

        public static final class a implements DialogInterface.OnDismissListener {
            public final /* synthetic */ RingtoneFragment a;

            public a(RingtoneFragment ringtoneFragment) {
                this.a = ringtoneFragment;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.e();
            }
        }

        public p() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Boolean bool) {
            RingtoneFragment.this.i0();
            if (!RingtoneFragment.this.P0()) {
                f.z.d.j.d(bool, "success");
                String strL = f.z.d.j.l("铃声设置", bool.booleanValue() ? "成功" : "失败");
                RingtoneFragment.this.I.success(strL);
                p1.h(RingtoneFragment.this.getContext(), strL);
                RingtoneFragment.this.e();
                RingtoneFragment.this.d1(strL, "saveRingtone");
                return;
            }
            FragmentActivity activity = RingtoneFragment.this.getActivity();
            if (activity != null && !activity.isFinishing()) {
                e.c.a.g.a.g.n.b bVar = new e.c.a.g.a.g.n.b(activity);
                bVar.setOnDismissListener(new a(RingtoneFragment.this));
                bVar.show();
            }
            RingtoneFragment.this.d1("华为自己设置", "saveRingtone");
            RingtoneFragment.this.I.success("华为系统自己设置,弹引导弹窗提示。");
        }
    }

    public static final class q<T> implements Action1 {
        public q() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            int i2;
            g0.i(th);
            RingtoneFragment.this.i0();
            RingtoneFragment.this.I.fail(th, (Integer) 9, "设置中出现异常");
            if (th instanceof e.c.a.g.a.f.k.b) {
                p1.h(RingtoneFragment.this.getContext(), th.getMessage());
                i2 = 2;
            } else {
                p1.h(RingtoneFragment.this.getContext(), (th.getMessage() == null || !f.z.d.j.a(th.getMessage(), "No space left on device")) ? "铃声设置失败" : "存储空间不足，无法裁剪铃声");
                i2 = 3;
            }
            RingtoneFragment.this.d1("设置失败=" + i2 + ", stack = " + Log.getStackTraceString(th), "saveRingtone");
        }
    }

    public static final class r extends f.z.d.k implements f.z.c.a<f.s> {
        public r() {
            super(0);
        }

        public final void a() {
            RingtoneFragment ringtoneFragment = RingtoneFragment.this;
            KGMusicWrapper kGMusicWrapper = ringtoneFragment.z;
            if (kGMusicWrapper == null) {
                f.z.d.j.t("song");
                throw null;
            }
            ringtoneFragment.e1(kGMusicWrapper, 1);
            YoungBITask youngBITask = new YoungBITask(12820846, "click");
            KGMusicWrapper kGMusicWrapper2 = RingtoneFragment.this.z;
            if (kGMusicWrapper2 != null) {
                e.c.a.g.a.e.b.b(youngBITask.setMixsongid(String.valueOf(kGMusicWrapper2.getMixId())).setTab("1"));
            } else {
                f.z.d.j.t("song");
                throw null;
            }
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ f.s invoke() {
            a();
            return f.s.a;
        }
    }

    public static final class s extends f.z.d.k implements f.z.c.a<f.s> {
        public s() {
            super(0);
        }

        public final void a() {
            YoungBITask youngBITask = new YoungBITask(12820846, "click");
            KGMusicWrapper kGMusicWrapper = RingtoneFragment.this.z;
            if (kGMusicWrapper == null) {
                f.z.d.j.t("song");
                throw null;
            }
            e.c.a.g.a.e.b.b(youngBITask.setMixsongid(String.valueOf(kGMusicWrapper.getMixId())).setTab("2"));
            SetRingClickBtnAPM.fail$default(RingtoneFragment.this.I, 6, "用户取消", null, 4, null);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ f.s invoke() {
            a();
            return f.s.a;
        }
    }

    public static /* synthetic */ void n1(RingtoneFragment ringtoneFragment, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        ringtoneFragment.m1(z);
    }

    public final void M0() {
        KGPermission.with(getActivity()).runtime().permission(Permission.WRITE_EXTERNAL_STORAGE).onDenied(new a()).onGranted(new b()).start();
    }

    public final e.c.a.g.a.g.n.g.c N0() {
        e.c.a.g.a.g.n.g.c cVar = this.B;
        if (cVar == null) {
            p1.h(getContext(), "铃声文件读取失败");
            d1("铃声文件读取失败", "getAvailableSoundFile");
            return null;
        }
        File fileE = cVar.e();
        if (e.c.a.g.a.s.q.F(fileE == null ? null : fileE.getAbsolutePath())) {
            return cVar;
        }
        p1.h(getContext(), "铃声文件不存在，请退出重试");
        File fileE2 = cVar.e();
        d1(f.z.d.j.l("铃声文件不存在，请退出重试 absolutePath = ", fileE2 == null ? null : fileE2.getAbsolutePath()), "getAvailableSoundFile");
        return null;
    }

    public final String O0() {
        if (this.z == null) {
            f.z.d.j.t("song");
            throw null;
        }
        StringBuilder sb = new StringBuilder();
        KGMusicWrapper kGMusicWrapper = this.z;
        if (kGMusicWrapper == null) {
            f.z.d.j.t("song");
            throw null;
        }
        sb.append(kGMusicWrapper.getDisplayName());
        sb.append(", ");
        KGMusicWrapper kGMusicWrapper2 = this.z;
        if (kGMusicWrapper2 != null) {
            sb.append(kGMusicWrapper2.getMixId());
            return sb.toString();
        }
        f.z.d.j.t("song");
        throw null;
    }

    public final boolean P0() {
        return l1.V();
    }

    public final void Q0() {
        KGMusicWrapper kGMusicWrapper = this.z;
        if (kGMusicWrapper == null) {
            f.z.d.j.t("song");
            throw null;
        }
        e.c.a.g.a.g.n.a aVar = new e.c.a.g.a.g.n.a(kGMusicWrapper);
        aVar.j(new c());
        f.s sVar = f.s.a;
        this.A = aVar;
        T0();
    }

    public final void R0() {
        this.r = j0(R.id.content_container);
        View viewJ0 = j0(R.id.slider_bar_view);
        Objects.requireNonNull(viewJ0, "null cannot be cast to non-null type com.kugou.android.watch.lite.component.ringtone.widget.AudioSliderBar");
        AudioSliderBar audioSliderBar = (AudioSliderBar) viewJ0;
        this.s = audioSliderBar;
        if (audioSliderBar == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        audioSliderBar.setOnSlideListener(new e.c.a.g.a.g.n.i.a(this));
        AudioSliderBar audioSliderBar2 = this.s;
        if (audioSliderBar2 == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        KGMusicWrapper kGMusicWrapper = this.z;
        if (kGMusicWrapper == null) {
            f.z.d.j.t("song");
            throw null;
        }
        audioSliderBar2.setMaxProgress((int) (kGMusicWrapper.getDuration() / ((long) 1000)));
        AudioSliderBar audioSliderBar3 = this.s;
        if (audioSliderBar3 == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        b(audioSliderBar3);
        View viewJ02 = j0(R.id.view_adjust_bg);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(requireContext(), R.color.c_1a1a1a));
        gradientDrawable.setCornerRadius(l1.c(50.0f));
        f.s sVar = f.s.a;
        viewJ02.setBackground(gradientDrawable);
        View viewJ03 = j0(R.id.tv_adjust_current);
        Objects.requireNonNull(viewJ03, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) viewJ03;
        n1(this, false, 1, null);
        this.u = (ImageView) j0(R.id.listen_ringtone_play);
        this.v = j0(R.id.common_loading);
        View viewJ04 = j0(R.id.common_loading_container);
        this.w = viewJ04;
        if (viewJ04 != null) {
            viewJ04.setOnClickListener(d.a);
        }
        this.y = (TextView) j0(R.id.common_err);
        TextView textView = (TextView) j0(R.id.common_refresh);
        this.x = textView;
        if (textView != null) {
            textView.setOnClickListener(new e());
        }
        u1.b(this, j0(R.id.iv_inc), j0(R.id.iv_des), j0(R.id.listen_ringtone), j0(R.id.btn_smart_cut), j0(R.id.btn_set_ringtone));
    }

    public final void S0(String str) {
        Observable.just(str).subscribeOn(Schedulers.io()).flatMap(new f(str)).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(str), new h(str));
    }

    public final void T0() {
        e.c.a.g.a.g.n.a aVar = this.A;
        if (aVar != null) {
            aVar.f();
        }
        i1();
    }

    public final void U0() {
        KGPermission.with(getActivity()).particular().onDenied(new i()).onGranted(new j()).start();
    }

    public final void V0() {
        this.H.netFinish();
    }

    public final void W0() {
        this.H.start();
    }

    public final void X0(Throwable th, Integer num, String str) {
        this.H.fail(th, num, str);
    }

    public final void Y0(String str) {
        f.z.d.j.e(str, ClientCookie.PATH_ATTR);
        this.H.success(str);
    }

    public final void Z0(boolean z) {
        ImageView imageView = this.u;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(z ? R.drawable.ic_player_act_pause : R.drawable.ic_player_act_play);
    }

    public final void a1() {
        if (e.c.a.g.a.s.d.d(getContext()) < 10485760) {
            p1.h(getContext(), "当前存储空间低于10M，暂无法设置铃声，请清理空间后尝试");
            SetRingClickBtnAPM.fail$default(this.I, 1, "当前存储空间低于10M，暂无法设置铃声，请清理空间后尝试", null, 4, null);
            return;
        }
        AudioSliderBar audioSliderBar = this.s;
        if (audioSliderBar == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        int leftProgress = audioSliderBar.getLeftProgress();
        AudioSliderBar audioSliderBar2 = this.s;
        if (audioSliderBar2 == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        if (audioSliderBar2.getRightProgress() - leftProgress <= 0) {
            p1.h(getContext(), "建议裁剪至少1秒时长哦");
            SetRingClickBtnAPM.fail$default(this.I, 2, "建议裁剪至少1秒时长哦", null, 4, null);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Permission.WRITE_EXTERNAL_STORAGE);
        PermissionsUtil permissionsUtil = PermissionsUtil.getInstance();
        FragmentActivity activity = getActivity();
        FragmentActivity activity2 = getActivity();
        permissionsUtil.showPermissionRequestDialogCommon(activity, activity2 != null ? activity2.getString(R.string.storage_permissions_tips) : null, new k(), arrayList);
    }

    public final void b1() {
        p0();
        i1.a(this.E);
        KGMusicWrapper kGMusicWrapper = this.z;
        if (kGMusicWrapper == null) {
            f.z.d.j.t("song");
            throw null;
        }
        long audioId = kGMusicWrapper.getAudioId();
        KGMusicWrapper kGMusicWrapper2 = this.z;
        if (kGMusicWrapper2 != null) {
            this.E = e.c.a.g.a.d.d.a.a(audioId, kGMusicWrapper2.getHashValue()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(), new m());
        } else {
            f.z.d.j.t("song");
            throw null;
        }
    }

    public final void c1() {
        if (e.c.a.g.a.d.x.f.q()) {
            e.c.a.g.a.d.x.f.t();
        }
        e.c.a.g.a.g.n.g.c cVarN0 = N0();
        if (cVarN0 == null) {
            return;
        }
        AudioSliderBar audioSliderBar = this.s;
        if (audioSliderBar == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        int leftProgress = audioSliderBar.getLeftProgress();
        AudioSliderBar audioSliderBar2 = this.s;
        if (audioSliderBar2 == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        int rightProgress = audioSliderBar2.getRightProgress();
        if (rightProgress - leftProgress <= 0) {
            p1.h(getContext(), "至少选择1秒时长哦");
            return;
        }
        if (this.C == null) {
            File fileE = cVarN0.e();
            String absolutePath = fileE == null ? null : fileE.getAbsolutePath();
            if (!e.c.a.g.a.s.q.F(absolutePath)) {
                KGMusicWrapper kGMusicWrapper = this.z;
                if (kGMusicWrapper == null) {
                    f.z.d.j.t("song");
                    throw null;
                }
                String hashValue = kGMusicWrapper.getHashValue();
                KGMusicWrapper kGMusicWrapper2 = this.z;
                if (kGMusicWrapper2 == null) {
                    f.z.d.j.t("song");
                    throw null;
                }
                int songQuality = kGMusicWrapper2.getSongQuality();
                KGMusicWrapper kGMusicWrapper3 = this.z;
                if (kGMusicWrapper3 == null) {
                    f.z.d.j.t("song");
                    throw null;
                }
                long mixId = kGMusicWrapper3.getMixId();
                KGMusicWrapper kGMusicWrapper4 = this.z;
                if (kGMusicWrapper4 == null) {
                    f.z.d.j.t("song");
                    throw null;
                }
                String strD = e.c.a.g.a.d.x.d.d(e.c.a.g.a.d.x.d.e(hashValue, songQuality, mixId, kGMusicWrapper4.isNeedListenPart()));
                if (e.c.a.g.a.s.q.F(strD)) {
                    absolutePath = strD;
                }
            }
            if (absolutePath == null || !e.c.a.g.a.s.q.F(absolutePath)) {
                p1.h(getContext(), "音频文件不存在，请退出重试");
                return;
            }
            this.C = new e.c.a.g.a.g.n.c(this, absolutePath);
        }
        e.c.a.g.a.g.n.c cVar = this.C;
        if (cVar == null) {
            return;
        }
        if (cVar.f()) {
            cVar.h();
            return;
        }
        cVar.g(leftProgress, rightProgress, cVarN0.i(e.c.a.g.a.g.n.h.c.k(leftProgress, cVarN0)), cVarN0.i(e.c.a.g.a.g.n.h.c.k(rightProgress, cVarN0)));
    }

    public final void d1(String str, String str2) {
        RingBiReportHelper.reportHead$default(RingBiReportHelper.INSTANCE, str, str2, null, 4, null);
    }

    public final void e1(KGMusicWrapper kGMusicWrapper, int i2) {
        String strQ;
        String strQ2;
        String strQ3;
        e.c.a.g.a.g.n.g.c cVarN0 = N0();
        if (cVarN0 == null) {
            return;
        }
        AudioSliderBar audioSliderBar = this.s;
        String strQ4 = null;
        if (audioSliderBar == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        int leftProgress = audioSliderBar.getLeftProgress();
        AudioSliderBar audioSliderBar2 = this.s;
        if (audioSliderBar2 == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        int rightProgress = audioSliderBar2.getRightProgress();
        int iK = e.c.a.g.a.g.n.h.c.k(leftProgress, cVarN0);
        int iK2 = e.c.a.g.a.g.n.h.c.k(rightProgress, cVarN0);
        String displayName = kGMusicWrapper.getDisplayName();
        if (displayName != null && (strQ = f.e0.n.q(displayName, " ", "", false, 4, null)) != null && (strQ2 = f.e0.n.q(strQ, ",", "_", false, 4, null)) != null && (strQ3 = f.e0.n.q(strQ2, "，", "_", false, 4, null)) != null) {
            strQ4 = f.e0.n.q(strQ3, "%", "_", false, 4, null);
        }
        String strD = h1.d(strQ4);
        if ((strD == null || strD.length() == 0) || strD.length() > 50) {
            strD = kGMusicWrapper.getTrackName();
        }
        if ((strD == null || strD.length() == 0) || strD.length() > 50) {
            strD = "剪辑铃声";
        }
        f.z.d.j.d(strD, "title");
        String strJ = e.c.a.g.a.g.n.h.c.j(strD, ".mp3");
        if (TextUtils.isEmpty(strJ)) {
            p1.h(getContext(), "无法找到文件名");
            d1("无法找到文件名", "saveRingtone");
            SetRingClickBtnAPM.fail$default(this.I, 8, "无法找到文件名", null, 4, null);
        } else {
            if (g0.a) {
                g0.b("ringtone_frag", f.z.d.j.l("saveRingtone: path=", strJ));
            }
            d1("设置中", "saveRingtone");
            r0(true, "设置中");
            i1.a(this.D);
            this.D = Observable.just(new File(strJ)).subscribeOn(Schedulers.io()).map(new n(cVarN0, iK, iK2)).map(new o(i2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(), new q());
        }
    }

    public final boolean f1(File file, int i2) {
        if (g0.a) {
            g0.b("ringtone_frag", "setRingtone: type：" + i2 + ", file:" + file);
        }
        if (i2 == 1) {
            return e.c.a.g.a.g.n.h.d.h(requireContext(), new e.c.a.g.a.g.n.h.b(file));
        }
        if (i2 != 2) {
            return false;
        }
        return e.c.a.g.a.g.n.h.d.m(requireContext(), new e.c.a.g.a.g.n.h.b(file));
    }

    public final void g1() {
        View view = this.r;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.v;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.w;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.y;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        EventBus.getDefault().post(new RingToneStatusItemEvent(true, ""));
    }

    public final void h1(String str) {
        View view = this.r;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.v;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.w;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.y;
        if (textView2 != null) {
            textView2.setVisibility(0);
            textView2.setText(str == null || str.length() == 0 ? "未知错误" : str);
        }
        EventBus.getDefault().post(new RingToneStatusItemEvent(false, str));
    }

    public final void i1() {
        View view = this.r;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.v;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.w;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.y;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(8);
    }

    public final void j1() {
        View view = this.r;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.v;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.w;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.y;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        EventBus.getDefault().post(new RingToneStatusItemEvent(false, MusicRingToneAPM.KEY_DATA_RETYR_RINGTONG));
    }

    public final void k1() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            SetRingClickBtnAPM.fail$default(this.I, 5, "activity == null || activity.isFinishing || activity.isDestroyed", null, 4, null);
            return;
        }
        e.c.a.g.a.g.n.e eVar = new e.c.a.g.a.g.n.e(activity);
        eVar.b(new r());
        eVar.a(new s());
        eVar.show();
    }

    public final void l1() {
        this.H.uiLoadFinish();
    }

    public final void m1(boolean z) {
        String str;
        int rightProgress;
        AudioSliderBar audioSliderBar = this.s;
        if (audioSliderBar == null) {
            f.z.d.j.t("mSliderBar");
            throw null;
        }
        if (audioSliderBar.d()) {
            AudioSliderBar audioSliderBar2 = this.s;
            if (audioSliderBar2 == null) {
                f.z.d.j.t("mSliderBar");
                throw null;
            }
            rightProgress = audioSliderBar2.getLeftProgress();
            str = "起点";
        } else {
            AudioSliderBar audioSliderBar3 = this.s;
            if (audioSliderBar3 == null) {
                f.z.d.j.t("mSliderBar");
                throw null;
            }
            if (audioSliderBar3.e()) {
                AudioSliderBar audioSliderBar4 = this.s;
                if (audioSliderBar4 == null) {
                    f.z.d.j.t("mSliderBar");
                    throw null;
                }
                rightProgress = audioSliderBar4.getRightProgress();
                str = "终点";
            } else {
                str = "";
                rightProgress = 0;
            }
        }
        u uVar = u.a;
        String str2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(rightProgress / 60), Integer.valueOf(rightProgress % 60)}, 2));
        f.z.d.j.d(str2, "java.lang.String.format(format, *args)");
        SpannableString spannableString = new SpannableString(str + ' ' + str2);
        spannableString.setSpan(this.G, str.length(), spannableString.length(), 33);
        TextView textView = this.t;
        if (textView == null) {
            f.z.d.j.t("mCurLocationTv");
            throw null;
        }
        textView.setText(spannableString);
        this.F = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f.z.d.j.e(view, "v");
        if (u1.h(HttpStatus.SC_BAD_REQUEST)) {
            return;
        }
        switch (view.getId()) {
            case R.id.btn_set_ringtone /* 2131230851 */:
                this.I.start();
                e.c.a.g.a.g.n.c cVar = this.C;
                if (cVar != null) {
                    cVar.h();
                }
                a1();
                YoungBITask youngBITask = new YoungBITask(12820843, "click");
                KGMusicWrapper kGMusicWrapper = this.z;
                if (kGMusicWrapper == null) {
                    f.z.d.j.t("song");
                    throw null;
                }
                e.c.a.g.a.e.b.b(youngBITask.setMixsongid(String.valueOf(kGMusicWrapper.getMixId())).setType(this.F ? "1" : "2"));
                RingBiReportHelper.INSTANCE.reportHead("btn_set_ringtone", "onClick", Boolean.TRUE);
                return;
            case R.id.btn_smart_cut /* 2131230852 */:
                b1();
                YoungBITask youngBITask2 = new YoungBITask(12820842, "click");
                KGMusicWrapper kGMusicWrapper2 = this.z;
                if (kGMusicWrapper2 == null) {
                    f.z.d.j.t("song");
                    throw null;
                }
                e.c.a.g.a.e.b.b(youngBITask2.setMixsongid(String.valueOf(kGMusicWrapper2.getMixId())));
                d1("btn_smart_cut", "onClick");
                return;
            case R.id.iv_des /* 2131231070 */:
                e.c.a.g.a.g.n.c cVar2 = this.C;
                if (cVar2 != null) {
                    cVar2.h();
                }
                AudioSliderBar audioSliderBar = this.s;
                if (audioSliderBar == null) {
                    f.z.d.j.t("mSliderBar");
                    throw null;
                }
                if (audioSliderBar.d()) {
                    audioSliderBar.setLeftProgress(audioSliderBar.getLeftProgress() - 1);
                } else if (audioSliderBar.e()) {
                    audioSliderBar.setRightProgress(audioSliderBar.getRightProgress() - 1);
                }
                n1(this, false, 1, null);
                d1("iv_des", "onClick");
                return;
            case R.id.iv_inc /* 2131231075 */:
                e.c.a.g.a.g.n.c cVar3 = this.C;
                if (cVar3 != null) {
                    cVar3.h();
                }
                AudioSliderBar audioSliderBar2 = this.s;
                if (audioSliderBar2 == null) {
                    f.z.d.j.t("mSliderBar");
                    throw null;
                }
                if (audioSliderBar2.d()) {
                    audioSliderBar2.setLeftProgress(audioSliderBar2.getLeftProgress() + 1);
                } else if (audioSliderBar2.e()) {
                    audioSliderBar2.setRightProgress(audioSliderBar2.getRightProgress() + 1);
                }
                n1(this, false, 1, null);
                d1("iv_inc", "onClick");
                return;
            case R.id.listen_ringtone /* 2131231104 */:
                c1();
                d1("listen_ringtone", "onClick");
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.z.d.j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_ringtone, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e.c.a.g.a.g.n.c cVar = this.C;
        if (cVar != null) {
            cVar.e();
        }
        e.c.a.g.a.g.n.a aVar = this.A;
        if (aVar != null) {
            aVar.d();
        }
        i1.a(this.D, this.E);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        f.z.d.j.e(view, "view");
        super.onViewCreated(view, bundle);
        g().D0(this, false);
        Bundle arguments = getArguments();
        KGMusicWrapper kGMusicWrapper = arguments == null ? null : (KGMusicWrapper) arguments.getParcelable("key_song_data");
        if (kGMusicWrapper == null) {
            p1.h(getContext(), "歌曲数据传递异常");
            e();
            return;
        }
        this.z = kGMusicWrapper;
        W0();
        if (e.c.a.g.a.d.x.f.q()) {
            e.c.a.g.a.d.x.f.t();
        }
        KGMusicWrapper kGMusicWrapper2 = this.z;
        if (kGMusicWrapper2 == null) {
            f.z.d.j.t("song");
            throw null;
        }
        d1(f.z.d.j.l("", kGMusicWrapper2), "/进入页面");
        R0();
        Q0();
    }
}
