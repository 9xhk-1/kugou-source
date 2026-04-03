package e.c.a.g.a.r.g;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.feedback.FeedbackActivity;
import com.kugou.android.watch.lite.user.info.EditUserPicActivity;
import com.kugou.common.permission.Permission;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.q;
import java.io.File;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean a = false;
    public static final String[] b = {Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE};

    public static void a(int i2, Intent intent) {
        if (l1.V()) {
            intent.setAction("android.intent.action.PICK");
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            intent.setClassName("com.huawei.kidwatch.hwgallery", "com.android.camera.ImageGallery");
        } else {
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            b(i2, intent);
        }
    }

    public static void b(int i2, Intent intent) {
        if (l1.m0()) {
            intent.putExtra("com.xtc.camera.LEFT_BUTTON_TEXT", "取消");
            intent.putExtra("com.xtc.camera.RIGHT_BUTTON_TEXT", "确定");
            Intent intent2 = new Intent(KGApplication.getContext(), (Class<?>) EditUserPicActivity.class);
            if (i2 == 10923) {
                intent2 = new Intent(KGApplication.getContext(), (Class<?>) FeedbackActivity.class);
            }
            intent2.putExtra("KEY_ACTIVITY_RESULT_BY_NEW_INTENT", true);
            intent2.putExtra("KEY_ACTIVITY_RESULT_REQUEST_CODE", i2);
            intent.putExtra("targetIntent", intent2.toUri(0));
        }
    }

    public static Intent c(Context context, Class<? extends Activity> cls) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", HttpStatus.SC_BAD_REQUEST);
        intent.putExtra("outputY", HttpStatus.SC_BAD_REQUEST);
        intent.putExtra("scale", true);
        intent.putExtra("setWallpaper", false);
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("fixHighlightView", true);
        return intent;
    }

    public static String d() {
        return g() + "user_image_tmp.jpg";
    }

    public static String e() {
        return g() + "feed_back.jpg";
    }

    public static String f() {
        return g() + "user_upload_image.jpg";
    }

    public static String g() {
        if (e.c.a.g.a.f.f.a.f648d.contains("null")) {
            e.c.a.g.a.f.f.a.f();
        }
        if (g0.a) {
            g0.b("young_xcl", "user image path = " + e.c.a.g.a.f.f.a.c);
        }
        return e.c.a.g.a.f.f.a.f648d + File.separator;
    }

    public static boolean h() {
        return e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.f3, 1) == 1;
    }

    public static void i(Activity activity) {
        j(activity, null);
    }

    public static void j(Activity activity, int[] iArr) {
        if (l1.U()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.eqc.camera", "com.eqc.camera.TakePictureActivity"));
            intent.putExtra("share", false);
            try {
                activity.startActivityForResult(intent, 12);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        q.f(g());
        String strD = d();
        q.k(strD);
        Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        intent2.putExtra("output", h0.a(activity, new e.c.a.g.a.f.g.a(strD)));
        b(12, intent2);
        try {
            activity.startActivityForResult(intent2, 12);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void k(Activity activity) {
        m(activity, null, null, 11);
    }

    public static void l(Activity activity, int i2) {
        m(activity, null, null, i2);
    }

    public static void m(Activity activity, String[] strArr, int[] iArr, int i2) {
        if (l1.U()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.eqc.gallery", "com.eqc.gallery.ui.LocalAlbumDetail"));
            intent.putExtra("key_selection_type", 3);
            intent.putExtra("share", false);
            try {
                activity.startActivity(intent);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        Intent intent2 = new Intent();
        a(i2, intent2);
        if (strArr != null && strArr.length > 0) {
            intent2.putExtra("android.intent.extra.MIME_TYPES", strArr);
        }
        if (h()) {
            try {
                activity.startActivityForResult(intent2, i2);
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (l1.W(activity, intent2)) {
            try {
                activity.startActivityForResult(intent2, i2);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
