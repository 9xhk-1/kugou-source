package e.c.a.g.a.p;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.common.permission.Action;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Permission;
import com.kugou.common.utils.PermissionsUtil;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u1;
import f.s;
import java.util.ArrayList;
import java.util.List;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements View.OnClickListener {
    public final DelegateFragment a;
    public Subscription b;

    public static final class a<T> implements Action {
        public static final a<T> a = new a<>();

        @Override // com.kugou.common.permission.Action
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onAction(List<String> list) {
            p1.h(KGApplication.getContext(), "删除铃声需要存储读写权限哦");
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.p.b$b, reason: collision with other inner class name */
    public static final class C0173b<T> implements Action {
        public C0173b() {
        }

        @Override // com.kugou.common.permission.Action
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onAction(List<String> list) {
            b.this.h();
        }
    }

    public static final class c implements PermissionsUtil.OnPermissionDilaogListener {
        public c() {
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onNo() {
            Log.d("mhs_watch", "initData onNo");
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onYes() {
            Log.d("mhs_watch", "initData onYes");
            b.this.f();
        }
    }

    public static final class d<T, R> implements Func1 {
        public final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f1152d;

        public d(boolean z, boolean z2) {
            this.b = z;
            this.f1152d = z2;
        }

        public final void a(String str) {
            Ringtone ringtone;
            Uri defaultUri = RingtoneManager.getDefaultUri(1);
            String title = null;
            if (defaultUri != null && (ringtone = RingtoneManager.getRingtone(b.this.a.getContext(), defaultUri)) != null) {
                title = ringtone.getTitle(b.this.a.getContext());
            }
            if (g0.a) {
                g0.b("ClearRingtone", "default ringtone : " + ((Object) title) + ",  write setting:" + this.b + "   write storage:" + this.f1152d);
            }
            if (l1.K()) {
                e.c.a.g.a.g.n.h.d.d(e.c.a.g.a.f.f.a.d(), title);
                e.c.a.g.a.g.n.h.d.b(title);
            }
            e.c.a.g.a.g.n.h.d.c(e.c.a.g.a.f.f.a.c(), title);
            e.c.a.g.a.f.m.c.a.j("ClearRingtone", true);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((String) obj);
            return s.a;
        }
    }

    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(s sVar) {
            p1.h(b.this.a.getContext(), "删除成功");
            b.this.b = null;
        }
    }

    public static final class f<T> implements Action1 {
        public f() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            p1.h(b.this.a.getContext(), "删除失败");
            b.this.b = null;
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.this.g();
        }
    }

    public b(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "root");
        this.a = delegateFragment;
        View viewFindViewById = view.findViewById(R.id.clear_ringtone_entry);
        viewFindViewById.setOnClickListener(this);
        f.z.d.j.d(viewFindViewById, "entry");
        viewFindViewById.setVisibility(e.c.a.g.a.f.a.o() ^ true ? 0 : 8);
    }

    public final void f() {
        KGPermission.with(this.a.getActivity()).runtime().permission(Permission.WRITE_EXTERNAL_STORAGE).onDenied(a.a).onGranted(new C0173b()).start();
    }

    public final void g() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Permission.WRITE_EXTERNAL_STORAGE);
        PermissionsUtil permissionsUtil = PermissionsUtil.getInstance();
        FragmentActivity activity = this.a.getActivity();
        Context context = this.a.getContext();
        permissionsUtil.showPermissionRequestDialogCommon(activity, context == null ? null : context.getString(R.string.storage_permissions_tips), new c(), arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h() {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.p.b.h():void");
    }

    public final boolean i() {
        return e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.M1, true);
    }

    public final void j() {
        i1.a(this.b);
        this.b = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u1.g()) {
            return;
        }
        e.c.a.g.a.d.h.a aVar = new e.c.a.g.a.d.h.a(this.a.requireActivity());
        aVar.e("是否清空全部已下载铃声\n注意：正在使用的铃声无法直接删除\n该操作会同步清除应用历史设置过的铃声记录");
        aVar.a("取消");
        aVar.b("确认");
        aVar.d(new g());
        aVar.show();
    }
}
