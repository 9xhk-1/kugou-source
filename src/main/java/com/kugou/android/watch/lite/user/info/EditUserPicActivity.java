package com.kugou.android.watch.lite.user.info;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.DelegateActivity;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.image.CropImage;
import com.kugou.common.apm.task.ChangePicAPM;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.ExceptionParse;
import com.kugou.common.permission.Permission;
import com.kugou.common.utils.PermissionsUtil;
import e.c.a.g.a.r.d.d.f;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.q;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import f.u.r;
import f.z.d.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class EditUserPicActivity extends DelegateActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Subscription f224d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f225f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BroadcastReceiver f226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f227i;
    public final ChangePicAPM j;

    public static final class a implements PermissionsUtil.OnPermissionDilaogListener {
        public final /* synthetic */ String[] b;

        public a(String[] strArr) {
            this.b = strArr;
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onNo() {
            Log.d("mhs_watch", "initData onNo");
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onYes() {
            Log.d("mhs_watch", "initData onYes");
            EditUserPicActivity.this.y(this.b);
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (u1.h(1000)) {
                return;
            }
            EditUserPicActivity.this.A();
        }
    }

    public static final class c implements View.OnClickListener {

        public static final class a implements PermissionsUtil.OnPermissionDilaogListener {
            public final /* synthetic */ EditUserPicActivity a;

            public a(EditUserPicActivity editUserPicActivity) {
                this.a = editUserPicActivity;
            }

            @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
            public void onNo() {
                Log.d("mhs_watch", "initData onNo");
            }

            @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
            public void onYes() {
                Log.d("mhs_watch", "initData onYes");
                this.a.z();
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            if (u1.h(1000)) {
                return;
            }
            EditUserPicActivity editUserPicActivity = EditUserPicActivity.this;
            String[] strArr = e.c.a.g.a.r.g.e.b;
            j.d(strArr, "STORAGE_PERMISSIONS");
            boolean zF = editUserPicActivity.F(editUserPicActivity, strArr);
            EditUserPicActivity.this.j.start(2);
            if (zF) {
                ArrayList<String> arrayList = new ArrayList<>();
                j.d(strArr, "STORAGE_PERMISSIONS");
                r.l(arrayList, strArr);
                PermissionsUtil permissionsUtil = PermissionsUtil.getInstance();
                EditUserPicActivity editUserPicActivity2 = EditUserPicActivity.this;
                permissionsUtil.showPermissionRequestDialogCommon(editUserPicActivity2, editUserPicActivity2.getString(R.string.storage_permissions_tips), new a(EditUserPicActivity.this), arrayList);
                str = ExceptionParse.NET_DNS_FAIL;
            } else {
                EditUserPicActivity.this.E();
                str = ExceptionParse.NET_PING_FAIL;
            }
            EditUserPicActivity.this.J("点击相册按钮 " + str + ", isHonor = " + l1.U());
        }
    }

    public static final class d<T, R> implements Func1 {
        public d() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f.b call(Bitmap bitmap) {
            q.k(e.c.a.g.a.r.g.e.f());
            a0.f(bitmap, e.c.a.g.a.r.g.e.f(), Bitmap.CompressFormat.JPEG);
            EditUserPicActivity.this.J("uploadAvatar start");
            return new e.c.a.g.a.r.d.d.f().b();
        }
    }

    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(f.b bVar) {
            EditUserPicActivity.this.d();
            if (bVar.a) {
                EditUserPicActivity editUserPicActivity = EditUserPicActivity.this;
                p1.h(editUserPicActivity, editUserPicActivity.getString(R.string.upload_image_success));
                e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.action.user_avatar_update"));
                EventBus.getDefault().post(new e.c.a.g.a.r.d.b(1, 300));
                EditUserPicActivity.this.J("uploadAvatar end api suc");
            } else if (TextUtils.isEmpty(bVar.b)) {
                p1.g(EditUserPicActivity.this, R.string.net_error);
                u0.A(11, "uploadAvatar-beforeLoad", "net_error");
                EditUserPicActivity.this.J("step = other net");
            } else {
                p1.h(EditUserPicActivity.this, bVar.b);
                u0.A(10, "uploadAvatar-beforeLoad", j.l("errorMsg=", bVar.b));
                EditUserPicActivity.this.J(j.l("step = api, result.errorMsg = ", bVar.b));
            }
            EditUserPicActivity editUserPicActivity2 = EditUserPicActivity.this;
            j.d(bVar, "result");
            editUserPicActivity2.H(bVar);
            EditUserPicActivity.this.finish();
        }
    }

    public static final class f<T> implements Action1 {
        public f() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            th.printStackTrace();
            p1.g(EditUserPicActivity.this, R.string.net_error);
            u0.B(12, "uploadAvatar", "网络错误", th);
            EditUserPicActivity.this.J("step = other net 2");
            EditUserPicActivity.this.G(th);
        }
    }

    public EditUserPicActivity() {
        this.f227i = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.m0, 1) == 1;
        this.j = new ChangePicAPM();
    }

    public static /* synthetic */ void M(EditUserPicActivity editUserPicActivity, Uri uri, Bitmap bitmap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uri = null;
        }
        if ((i2 & 2) != 0) {
            bitmap = null;
        }
        editUserPicActivity.L(uri, bitmap);
    }

    public final void A() {
        String[] strArr = l1.m0() ? new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE} : new String[]{Permission.CAMERA};
        this.j.start(1);
        if (!F(this, strArr)) {
            D();
            J("点击拍照按钮  jumpToCamera");
        } else {
            ArrayList<String> arrayList = new ArrayList<>();
            r.l(arrayList, strArr);
            PermissionsUtil.getInstance().showPermissionRequestDialogCommon(this, getString(R.string.camera_permissions_tips), new a(strArr), arrayList);
            J("点击拍照按钮  no permission");
        }
    }

    public final String B() {
        return e.c.a.g.a.f.e.c.a.a().b(e.c.a.g.a.f.e.b.g2, "");
    }

    public final String C() {
        return e.c.a.g.a.f.e.c.a.a().b(e.c.a.g.a.f.e.b.e2, "");
    }

    public final void D() {
        this.f225f = e.c.a.g.a.d.x.f.q();
        if (e.c.a.g.a.d.x.f.q()) {
            e.c.a.g.a.d.x.f.t();
            e.c.a.g.a.d.x.e.d(6);
        }
        e.c.a.g.a.r.g.e.i(this);
    }

    public final void E() {
        e.c.a.g.a.r.g.e.k(this);
    }

    public final boolean F(Context context, String[] strArr) {
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

    public final void G(Throwable th) {
        this.j.fail(th, (Integer) 5, "接口异常");
    }

    public final void H(f.b bVar) {
        j.e(bVar, "songResp");
        if (bVar.a) {
            this.j.netFinish();
            this.j.success("修改头像成功");
            return;
        }
        ChangePicAPM changePicAPM = this.j;
        e.c.a.b.a.a.a.a aVar = new e.c.a.b.a.a.a.a(bVar.c);
        String str = bVar.b;
        j.d(str, "songResp.errorMsg");
        changePicAPM.fail((Throwable) aVar, (Integer) 6, str);
    }

    public final void I() {
        if (l1.U() && this.f226h == null) {
            this.f226h = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.user.info.EditUserPicActivity$registerHonorPicReceiver$1
                /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
                @Override // android.content.BroadcastReceiver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onReceive(android.content.Context r14, android.content.Intent r15) {
                    /*
                        Method dump skipped, instruction units count: 219
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.user.info.EditUserPicActivity$registerHonorPicReceiver$1.onReceive(android.content.Context, android.content.Intent):void");
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.eqc.gallery.ui.LocalAlbumDetail.getPic");
            intentFilter.addAction("com.eqc.camera.TakePictureActivity.getPic");
            e.c.a.g.a.f.d.a.c(this.f226h, intentFilter);
        }
    }

    public final void J(String str) {
        if (this.f227i) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setFo("编辑头像").setType("1").setSvar1(str));
            e.c.a.g.a.d.d0.a.a("EditUserPicActivity", j.l("reportHead 1, ", str));
        } else if (g0.f()) {
            g0.c("mhs_watch", j.l("TYPE_PIC needReport = ", Boolean.valueOf(this.f227i)));
        }
    }

    public final void K() {
        if (this.f225f) {
            e.c.a.g.a.d.x.f.x();
        }
    }

    public final void L(Uri uri, Bitmap bitmap) {
        Intent intentC = e.c.a.g.a.r.g.e.c(this, CropImage.class);
        intentC.putExtra("moduleId", 1);
        intentC.putExtra("outputX", AbsHttpClient.SC_CUSTOM_LIMIT);
        intentC.putExtra("outputY", AbsHttpClient.SC_CUSTOM_LIMIT);
        if (uri != null) {
            intentC.setData(uri);
        }
        if (bitmap != null) {
            intentC.putExtra("data", bitmap);
        }
        startActivityForResult(intentC, 2);
        J("startCropImage = , uri = " + uri + ", bitmap = " + bitmap + "stack" + Log.getStackTraceString(new Throwable("startCropImage")));
    }

    public final void N(Bitmap bitmap) {
        n(e.c.a.g.a.d.w.a.e(this), 4);
        i1.a(this.f224d);
        this.f224d = Observable.just(bitmap).subscribeOn(Schedulers.io()).map(new d()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(), new f());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle extras;
        Bundle extras2;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 12 && !l1.P()) {
            K();
        }
        Bitmap bitmap = null;
        if (i3 == -1 && i2 == 12) {
            e.c.a.g.a.r.g.e.a = false;
            Object obj = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.get("output");
            if (obj instanceof String) {
                String str = (String) obj;
                if (q.F(str)) {
                    M(this, Uri.fromFile(new File(str)), null, 2, null);
                    return;
                }
            }
            if (obj instanceof Uri) {
                M(this, (Uri) obj, null, 2, null);
                return;
            }
            Bitmap bitmap2 = (intent == null || (extras2 = intent.getExtras()) == null) ? null : (Bitmap) extras2.getParcelable("data");
            if (bitmap2 != null) {
                M(this, null, bitmap2, 1, null);
                return;
            }
            File file = new File(e.c.a.g.a.r.g.e.d());
            if (file.exists()) {
                M(this, Uri.fromFile(file), null, 2, null);
                return;
            }
            ChangePicAPM.fail$default(this.j, 22, "拍照后，无效资源，无法剪切, bitmap = " + bitmap2 + ", imgFile = " + file + ", output = " + obj, null, 4, null);
            return;
        }
        if (i3 == -1 && i2 == 11 && intent != null) {
            Bundle extras3 = intent.getExtras();
            String str2 = (String) (extras3 == null ? null : extras3.get("output"));
            if (str2 != null) {
                M(this, Uri.fromFile(new e.c.a.g.a.f.g.a(str2)), null, 2, null);
                return;
            }
            Uri data = intent.getData();
            if (data != null) {
                M(this, data, null, 2, null);
                return;
            }
            ChangePicAPM.fail$default(this.j, 2, "选中图片后，无效资源，无法剪切, filePath = " + ((Object) str2) + ", imgUri = " + data, null, 4, null);
            return;
        }
        if (i3 == -1 && i2 == 2 && intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (j.a("inline-data", action)) {
                        String stringExtra = intent.getStringExtra("data");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            bitmap = e.c.a.g.a.s.f.i(stringExtra);
                        }
                    } else {
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(action));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (!u0.m(this)) {
                    J("无网");
                    ChangePicAPM.fail$default(this.j, 3, "切完图片后无网络", null, 4, null);
                } else if (bitmap != null) {
                    N(bitmap);
                    J(j.l("action = ", action));
                } else {
                    p1.h(KGApplication.getContext(), "读取照片失败~");
                    J("读取照片失败~");
                    ChangePicAPM.fail$default(this.j, 4, "读取照片失败", null, 4, null);
                }
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                J(j.l("step = e", Log.getStackTraceString(e3)));
            }
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_edit_user_pic);
        View viewFindViewById = findViewById(R.id.tv_take_pic);
        if (e.c.a.g.a.f.a.c()) {
            viewFindViewById.setVisibility(8);
        }
        viewFindViewById.setOnClickListener(new b());
        View viewFindViewById2 = findViewById(R.id.tv_from_gallery);
        if (e.c.a.g.a.f.a.d()) {
            viewFindViewById2.setVisibility(8);
        }
        viewFindViewById2.setOnClickListener(new c());
        I();
        J("进入到相册编辑页面 isHonor = " + l1.U() + ", phoneMode = " + ((Object) l1.q()) + ", brand = " + ((Object) l1.p()));
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.c.a.g.a.f.d.a.h(this.f226h);
        i1.a(this.f224d);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("KEY_ACTIVITY_RESULT_BY_NEW_INTENT", false);
        int intExtra = intent.getIntExtra("KEY_ACTIVITY_RESULT_REQUEST_CODE", -1);
        if (!booleanExtra || intExtra <= 0) {
            return;
        }
        onActivityResult(intExtra, -1, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        j.e(strArr, "permissions");
        j.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        int i3 = 0;
        if (i2 == 11) {
            int length = iArr.length;
            while (i3 < length) {
                int i4 = iArr[i3];
                i3++;
                if (i4 == -1) {
                    J("step = action =SELECT_PICTURE_FROM_LIB  PERMISSION_DENIED");
                    String strB = B();
                    if (!TextUtils.isEmpty(strB)) {
                        p1.h(KGApplication.getContext(), strB);
                    }
                    ChangePicAPM.fail$default(this.j, 1, "no 没有相册设置权限", null, 4, null);
                    return;
                }
            }
            e.c.a.g.a.f.f.a.f();
            E();
            J("step = action =jumpToGallery");
            return;
        }
        if (i2 != 12) {
            return;
        }
        int length2 = iArr.length;
        while (i3 < length2) {
            int i5 = iArr[i3];
            i3++;
            if (i5 == -1) {
                J("step = action =SELECT_PICTURE_FROM_CAMERA PERMISSION_DENIED");
                String strC = C();
                if (!TextUtils.isEmpty(strC)) {
                    p1.h(KGApplication.getContext(), strC);
                }
                ChangePicAPM.fail$default(this.j, 21, "没有拍照设置权限", null, 4, null);
                return;
            }
        }
        e.c.a.g.a.f.f.a.f();
        D();
        J("step = action =jumpToCamera");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && l1.P()) {
            K();
        }
    }

    public final void y(String[] strArr) {
        ActivityCompat.requestPermissions(this, strArr, 12);
    }

    public final void z() {
        ActivityCompat.requestPermissions(this, e.c.a.g.a.r.g.e.b, 11);
    }
}
