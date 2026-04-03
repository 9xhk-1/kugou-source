package e.c.a.g.a.g.g.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public Context a;
    public Resources b;

    public class a {
        public String a;
        public int b;
        public Drawable c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f788d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f789e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f790f;

        public a(b bVar) {
        }

        public String toString() {
            return "ApkInfo [packageName=" + this.a + ", iconId=" + this.b + ", iconDrawable=" + this.c + ", programName=" + this.f788d + ", versionCode=" + this.f789e + ", versionName=" + this.f790f + "]";
        }
    }

    public b(Context context) {
        this.a = context;
        this.b = context.getResources();
    }

    public a a() {
        a aVar = new a(this);
        try {
            ApplicationInfo applicationInfo = this.a.getApplicationInfo();
            aVar.a = applicationInfo.packageName;
            int i2 = applicationInfo.icon;
            aVar.b = i2;
            aVar.c = this.b.getDrawable(i2);
            aVar.f788d = this.b.getText(applicationInfo.labelRes).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(aVar.a, 0);
            aVar.f789e = packageInfo.versionCode;
            aVar.f790f = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
        }
        return aVar;
    }
}
