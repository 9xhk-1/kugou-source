package com.kugou.android.watch.lite.common.image;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.media.ExifInterface;
import android.media.FaceDetector;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.image.CropImageView;
import e.c.a.g.a.s.f1;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.q;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import me.jessyan.autosize.AutoSizeBridge;
import me.jessyan.autosize.internal.CancelAdapt;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public class CropImage extends MonitoredActivity implements CropImageView.a, CancelAdapt {
    public boolean A;
    public String B;
    public CropImageView C;
    public ContentResolver D;
    public Bitmap E;
    public e.c.a.g.a.f.i.d F;
    public e.c.a.g.a.f.i.f G;
    public e.c.a.g.a.f.i.e H;
    public TextView J;
    public TextView K;
    public View L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f94i;
    public int j;
    public int n;
    public int o;
    public int v;
    public int w;
    public boolean x;
    public boolean z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap.CompressFormat f92f = Bitmap.CompressFormat.JPEG;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f93h = false;
    public boolean k = false;
    public Uri l = null;
    public boolean m = false;
    public boolean p = true;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public int t = 0;
    public final Handler u = new Handler();
    public boolean y = true;
    public int I = -1;
    public Runnable M = new g();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("click_type", 0);
            CropImage.this.setResult(0, intent);
            CropImage.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CropImage.this.P();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CropImage.this.O(-90);
        }
    }

    public class d implements Runnable {

        public class a implements Runnable {
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ CountDownLatch b;

            public a(Bitmap bitmap, CountDownLatch countDownLatch) {
                this.a = bitmap;
                this.b = countDownLatch;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a != CropImage.this.E && this.a != null) {
                    CropImage.this.C.k(this.a, true);
                    CropImage.this.E.recycle();
                    CropImage.this.E = this.a;
                }
                if (CropImage.this.C.getScale() == 1.0f) {
                    CropImage.this.C.a(true, true);
                }
                this.b.countDown();
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Bitmap bitmapFullSizeBitmap = CropImage.this.H != null ? CropImage.this.H.fullSizeBitmap(-1, (CropImage.this.t == 2 || CropImage.this.t == 1) ? CropImage.this.N() : 1048576) : CropImage.this.E;
            if (CropImage.this.H != null) {
                CropImage cropImage = CropImage.this;
                bitmapFullSizeBitmap = cropImage.M(cropImage.H.getDataPath(), bitmapFullSizeBitmap);
            }
            CropImage.this.u.post(new a(bitmapFullSizeBitmap, countDownLatch));
            try {
                countDownLatch.await();
                CropImage.this.u.post(CropImage.this.M);
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Bitmap a;

        public e(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            CropImage.this.R(this.a);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ Bitmap a;

        public f(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImage.this.C.b();
            this.a.recycle();
        }
    }

    public class g implements Runnable {
        public Matrix b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f97f;
        public float a = 1.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public FaceDetector.Face[] f96d = new FaceDetector.Face[3];

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                CropImage cropImage = CropImage.this;
                int i2 = gVar.f97f;
                cropImage.z = i2 > 1;
                if (i2 > 0) {
                    int i3 = 0;
                    while (true) {
                        g gVar2 = g.this;
                        if (i3 >= gVar2.f97f) {
                            break;
                        }
                        gVar2.c(gVar2.f96d[i3]);
                        i3++;
                    }
                } else {
                    gVar.d();
                }
                CropImage.this.C.invalidate();
                if (CropImage.this.C.o.size() == 1) {
                    CropImage cropImage2 = CropImage.this;
                    cropImage2.F = cropImage2.C.o.get(0);
                    CropImage.this.F.o(true);
                }
                g gVar3 = g.this;
                if (gVar3.f97f > 1) {
                    p1.g(CropImage.this, R.string.multiface_crop_help);
                }
            }
        }

        public g() {
        }

        public final void c(FaceDetector.Face face) {
            PointF pointF = new PointF();
            int iEyesDistance = ((int) (face.eyesDistance() * this.a)) * 2;
            face.getMidPoint(pointF);
            float f2 = pointF.x;
            float f3 = this.a;
            float f4 = f2 * f3;
            pointF.x = f4;
            float f5 = pointF.y * f3;
            pointF.y = f5;
            e.c.a.g.a.f.i.d dVar = new e.c.a.g.a.f.i.d(CropImage.this.C);
            Rect rect = new Rect(0, 0, CropImage.this.E.getWidth(), CropImage.this.E.getHeight());
            float f6 = (int) f4;
            float f7 = (int) f5;
            RectF rectF = new RectF(f6, f7, f6, f7);
            float f8 = -iEyesDistance;
            rectF.inset(f8, f8);
            float f9 = rectF.left;
            if (f9 < 0.0f) {
                rectF.inset(-f9, -f9);
            }
            float f10 = rectF.top;
            if (f10 < 0.0f) {
                rectF.inset(-f10, -f10);
            }
            float f11 = rectF.right;
            int i2 = rect.right;
            if (f11 > i2) {
                rectF.inset(f11 - i2, f11 - i2);
            }
            float f12 = rectF.bottom;
            int i3 = rect.bottom;
            if (f12 > i3) {
                rectF.inset(f12 - i3, f12 - i3);
            }
            dVar.p(CropImage.this.k);
            dVar.s(this.b, rect, rectF, CropImage.this.q, (CropImage.this.n == 0 || CropImage.this.o == 0) ? false : true);
            CropImage.this.C.p(dVar);
        }

        public final void d() {
            int iC;
            int i2;
            e.c.a.g.a.f.i.d dVar = new e.c.a.g.a.f.i.d(CropImage.this.C);
            int width = CropImage.this.E.getWidth();
            int height = CropImage.this.E.getHeight();
            Rect rect = new Rect(0, 0, width, height);
            int iMin = CropImage.this.k ? Math.min(width, height) : (Math.min(width, height) * 4) / 5;
            if (CropImage.this.n == 0 || CropImage.this.o == 0) {
                iC = iMin;
            } else {
                if (CropImage.this.s) {
                    if (CropImage.this.n > CropImage.this.o) {
                        i2 = (CropImage.this.o * iMin) / CropImage.this.n;
                    } else {
                        i2 = iMin;
                        iMin = (CropImage.this.n * iMin) / CropImage.this.o;
                    }
                } else if ((CropImage.this.o * width) / CropImage.this.n > height) {
                    iMin = (CropImage.this.n * height) / CropImage.this.o;
                    i2 = height;
                } else {
                    i2 = (CropImage.this.o * width) / CropImage.this.n;
                    iMin = width;
                }
                iMin = CropImage.this.k ? iMin - l1.c(10.0f) : (iMin * 4) / 5;
                iC = CropImage.this.k ? i2 - l1.c(10.0f) : (i2 * 4) / 5;
            }
            if (CropImage.this.f93h && CropImage.this.j > 0 && CropImage.this.f94i > 0) {
                iC = (int) (((iMin * 1.0f) * CropImage.this.j) / CropImage.this.f94i);
                if (g0.a) {
                    g0.c("MeetByAccident", "makeDefault 使用自定义比例。宽：" + CropImage.this.f94i + "-高：" + CropImage.this.j + "-计算后宽：" + iMin + "-高：" + iC);
                }
            }
            RectF rectF = new RectF((width - iMin) / 2, (height - iC) / 2, r0 + iMin, r1 + iC);
            dVar.p(CropImage.this.k);
            dVar.s(this.b, rect, rectF, CropImage.this.q, (CropImage.this.n == 0 || CropImage.this.o == 0) ? false : true);
            CropImage.this.C.p(dVar);
        }

        public final Bitmap e() {
            if (CropImage.this.E == null) {
                return null;
            }
            if (CropImage.this.E.getWidth() > 256) {
                this.a = 256.0f / CropImage.this.E.getWidth();
            }
            Matrix matrix = new Matrix();
            float f2 = this.a;
            matrix.setScale(f2, f2);
            return e.c.a.g.a.s.f.f(CropImage.this.E, 0, 0, CropImage.this.E.getWidth(), CropImage.this.E.getHeight(), matrix, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b = CropImage.this.C.getImageMatrix();
            Bitmap bitmapE = e();
            this.a = 1.0f / this.a;
            if (bitmapE != null && CropImage.this.p) {
                this.f97f = new FaceDetector(bitmapE.getWidth(), bitmapE.getHeight(), this.f96d.length).findFaces(bitmapE, this.f96d);
            }
            if (bitmapE != null && bitmapE != CropImage.this.E) {
                bitmapE.recycle();
            }
            CropImage.this.u.post(new a());
        }
    }

    public final void L() {
        if (AutoSizeBridge.isApplyAutoSize) {
            float targetScaledDensity = AutoSizeBridge.getTargetScaledDensity();
            if (targetScaledDensity > 1.0f) {
                ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
                layoutParams.height = (int) (layoutParams.height * targetScaledDensity);
                layoutParams.width = (int) (layoutParams.width * targetScaledDensity);
                TextView textView = this.J;
                textView.setTextSize(textView.getTextSize() * targetScaledDensity);
                TextView textView2 = this.K;
                textView2.setTextSize(textView2.getTextSize() * targetScaledDensity);
            }
        }
    }

    public final Bitmap M(String str, Bitmap bitmap) {
        if (g0.a) {
            g0.b("CropImage", str);
        }
        int i2 = 0;
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt == 3) {
                    i2 = 180;
                } else if (attributeInt == 6) {
                    i2 = 90;
                } else if (attributeInt == 8) {
                    i2 = 270;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (RuntimeException e3) {
                e3.printStackTrace();
            }
        }
        if (g0.a) {
            g0.b("CropImage", "degree : " + i2);
        }
        if (i2 == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i2, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            Bitmap bitmapF = e.c.a.g.a.s.f.f(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == bitmapF) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapF;
        } catch (OutOfMemoryError e4) {
            throw e4;
        }
    }

    public final int N() {
        f1 f1VarY = l1.y(KGApplication.getApplication());
        int i2 = f1VarY.a;
        int i3 = f1VarY.b;
        int i4 = i2 * i3;
        if (i2 == 0 || i3 == 0 || i4 < 1048576) {
            return 1048576;
        }
        return i4;
    }

    public final void O(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (i2 != 0 && this.E != null) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i2, this.E.getWidth() / 2.0f, this.E.getHeight() / 2.0f);
            try {
                Bitmap bitmap = this.E;
                Bitmap bitmapF = e.c.a.g.a.s.f.f(bitmap, 0, 0, bitmap.getWidth(), this.E.getHeight(), matrix, true);
                Bitmap bitmap2 = this.E;
                if (bitmap2 != bitmapF) {
                    bitmap2.recycle();
                    this.E = bitmapF;
                }
            } catch (OutOfMemoryError e2) {
                throw e2;
            }
        }
        this.C.k(this.E, true);
        e.c.a.g.a.f.i.d dVar = new e.c.a.g.a.f.i.d(this.C);
        int width = this.E.getWidth();
        int height = this.E.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        int iMin = (Math.min(width, height) * 4) / 5;
        int i8 = this.n;
        if (i8 == 0 || (i6 = this.o) == 0) {
            i3 = iMin;
        } else {
            if (this.s) {
                if (i8 > i6) {
                    i7 = (i6 * iMin) / i8;
                } else {
                    int i9 = (i8 * iMin) / i6;
                    i7 = iMin;
                    iMin = i9;
                }
            } else if ((width * i6) / i8 > height) {
                iMin = (i8 * height) / i6;
                i7 = height;
            } else {
                i7 = (i6 * width) / i8;
                iMin = width;
            }
            iMin = (iMin * 4) / 5;
            i3 = (i7 * 4) / 5;
        }
        if (this.f93h && (i4 = this.j) > 0 && (i5 = this.f94i) > 0) {
            i3 = (int) (((iMin * 1.0f) * i4) / i5);
            if (g0.a) {
                g0.c("MeetByAccident", "使用自定义比例。宽：" + this.f94i + "-高：" + this.j + "-计算后宽：" + iMin + "-高：" + i3);
            }
        }
        RectF rectF = new RectF((width - iMin) / 2, (height - i3) / 2, r0 + iMin, r2 + i3);
        dVar.p(this.k);
        dVar.s(this.C.getImageMatrix(), rect, rectF, this.q, (this.n == 0 || this.o == 0) ? false : true);
        this.C.o.clear();
        this.C.p(dVar);
        if (this.C.o.size() == 1) {
            e.c.a.g.a.f.i.d dVar2 = this.C.o.get(0);
            this.F = dVar2;
            dVar2.o(true);
        }
    }

    public final void P() {
        Bitmap bitmapY;
        int i2;
        e.c.a.g.a.f.i.d dVar = this.F;
        if (dVar == null || this.A) {
            return;
        }
        this.A = true;
        int i3 = this.v;
        if (i3 == 0 || (i2 = this.w) == 0 || this.x) {
            Rect rectF = dVar.f();
            CropImageView cropImageView = this.C;
            if (cropImageView.t) {
                rectF = cropImageView.getFixHighlightViewCrop();
            }
            int iWidth = rectF.width();
            int iHeight = rectF.height();
            Bitmap bitmapD = e.c.a.g.a.s.f.d(iWidth, iHeight, (this.q || this.r || this.t == 1) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapD);
            Rect rect = new Rect(0, 0, iWidth, iHeight);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(this.E, rectF, rect, paint);
            this.C.b();
            this.E.recycle();
            if (this.q) {
                Canvas canvas2 = new Canvas(bitmapD);
                Path path = new Path();
                float f2 = iWidth / 2.0f;
                path.addCircle(f2, iHeight / 2.0f, f2, Path.Direction.CW);
                canvas2.clipPath(path, Region.Op.DIFFERENCE);
                canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            }
            bitmapY = (this.v == 0 || this.w == 0 || !this.x) ? bitmapD : e.c.a.g.a.s.f.y(new Matrix(), bitmapD, this.v, this.w, this.y, true);
        } else {
            bitmapY = Bitmap.createBitmap(i3, i2, Bitmap.Config.RGB_565);
            Canvas canvas3 = new Canvas(bitmapY);
            Rect rectF2 = this.F.f();
            CropImageView cropImageView2 = this.C;
            if (cropImageView2.t) {
                rectF2 = cropImageView2.getFixHighlightViewCrop();
            }
            Rect rect2 = new Rect(0, 0, this.v, this.w);
            int iWidth2 = (rectF2.width() - rect2.width()) / 2;
            int iHeight2 = (rectF2.height() - rect2.height()) / 2;
            rectF2.inset(Math.max(0, iWidth2), Math.max(0, iHeight2));
            rect2.inset(Math.max(0, -iWidth2), Math.max(0, -iHeight2));
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setFilterBitmap(true);
            canvas3.drawBitmap(this.E, rectF2, rect2, paint2);
            this.C.b();
            this.E.recycle();
        }
        this.C.k(bitmapY, true);
        this.C.a(true, true);
        this.C.o.clear();
        Bundle extras = getIntent().getExtras();
        if (extras == null || (extras.getParcelable("data") == null && !extras.getBoolean("return-data"))) {
            j0.b().a(new e(bitmapY));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", bitmapY);
        setResult(-1, new Intent().setAction("inline-data").putExtras(bundle));
        finish();
    }

    public final void Q(Bundle bundle, Bitmap bitmap, File file, int i2, String str) {
        e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(file.toString());
        if (aVar.exists() || aVar.mkdirs()) {
            String str2 = file.toString() + "/" + str + "-" + i2 + ".jpg";
            e.c.a.g.a.s.f.w(bitmap, str2, Bitmap.CompressFormat.JPEG);
            bundle.putString("data", str2);
            setResult(-1, new Intent().setAction("inline-data").putExtras(bundle));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x01d3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01d4, code lost:
    
        r1 = r15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r24v0, types: [android.app.Activity, android.content.Context, com.kugou.android.watch.lite.common.image.CropImage] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void R(android.graphics.Bitmap r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.common.image.CropImage.R(android.graphics.Bitmap):void");
    }

    public final void S() {
        if (isFinishing()) {
            return;
        }
        this.C.k(this.E, true);
        j0.b().a(new d());
    }

    @Override // com.kugou.android.watch.lite.common.image.CropImageView.a
    public boolean isSaving() {
        return this.A;
    }

    @Override // com.kugou.android.watch.lite.common.image.CropImageView.a
    public boolean isWaitingToPick() {
        return this.z;
    }

    @Override // com.kugou.android.watch.lite.common.image.MonitoredActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(R.style.Theme_YouthWatch_no_swipe_back);
        super.onCreate(bundle);
        this.D = getContentResolver();
        requestWindowFeature(1);
        setContentView(R.layout.cropimage);
        CropImageView cropImageView = (CropImageView) findViewById(R.id.image);
        this.C = cropImageView;
        cropImageView.setContainer(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        boolean z = false;
        if (extras != null) {
            if (extras.getString("circleCrop") != null) {
                this.q = true;
                this.n = 1;
                this.o = 1;
            }
            Uri uri = (Uri) extras.getParcelable("output");
            this.l = uri;
            if (uri != null) {
                String string = extras.getString("outputFormat");
                if (string != null) {
                    this.f92f = Bitmap.CompressFormat.valueOf(string);
                }
            } else {
                this.m = extras.getBoolean("setWallpaper");
            }
            this.E = (Bitmap) extras.getParcelable("data");
            this.n = extras.getInt("aspectX");
            this.o = extras.getInt("aspectY");
            this.v = extras.getInt("outputX");
            this.w = extras.getInt("outputY");
            boolean z2 = extras.getBoolean("extra_is_use_custom_ratio", false);
            this.f93h = z2;
            if (z2) {
                this.f94i = extras.getInt("extra_custom_ratio_x", 0);
                this.j = extras.getInt("extra_custom_ratio_y", 0);
            }
            this.r = extras.getBoolean("circleCrop", false);
            this.s = extras.getBoolean("fixAspect", false);
            this.B = extras.getString("outputFolder");
            this.x = extras.getBoolean("scale", true);
            this.y = extras.getBoolean("scaleUpIfNeeded", true);
            this.p = (extras.containsKey("noFaceDetection") && extras.getBoolean("noFaceDetection")) ? false : true;
            boolean z3 = extras.getBoolean("fixHighlightView", false);
            this.t = extras.getInt("moduleId", 0);
            this.C.t = z3;
            this.I = extras.getInt("quality", -1);
            this.k = extras.getBoolean("user_background");
            z = extras.getBoolean("fromCustomSkin");
        }
        if (this.E == null) {
            Uri data = intent.getData();
            e.c.a.g.a.f.i.f fVarK = ImageManager.k(this.D, data, 1);
            this.G = fVarK;
            e.c.a.g.a.f.i.e imageForUri = fVarK.getImageForUri(data);
            this.H = imageForUri;
            if (imageForUri != null) {
                Bitmap bitmapThumbBitmap = imageForUri.thumbBitmap(true);
                this.E = bitmapThumbBitmap;
                if (bitmapThumbBitmap == null) {
                    Bitmap bitmapS = e.c.a.g.a.s.f.s(this.H.getDataPath());
                    this.E = bitmapS;
                    if (bitmapS == null) {
                        this.E = e.c.a.g.a.s.f.s(q.C(this, data));
                    }
                }
                e.c.a.g.a.f.i.e eVar = this.H;
                if (eVar != null && eVar.getDataPath() != null && !TextUtils.isEmpty(this.H.getDataPath())) {
                    this.E = M(this.H.getDataPath(), this.E);
                }
            }
        }
        if (this.E == null) {
            if (z) {
                intent.getData();
            }
            Log.w("CropImage", "mBitmap is null !  Call finish() ");
            p1.h(this, "数据异常，请稍后重试");
            finish();
            return;
        }
        getWindow().addFlags(1024);
        TextView textView = (TextView) findViewById(R.id.discard);
        this.J = textView;
        textView.setOnClickListener(new a());
        TextView textView2 = (TextView) findViewById(R.id.save);
        this.K = textView2;
        textView2.setOnClickListener(new b());
        View viewFindViewById = findViewById(R.id.rotate_left);
        this.L = viewFindViewById;
        viewFindViewById.setOnClickListener(new c());
        S();
        L();
    }

    @Override // com.kugou.android.watch.lite.common.image.MonitoredActivity, com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        e.c.a.g.a.f.i.f fVar = this.G;
        if (fVar != null) {
            fVar.close();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        Intent intent = new Intent();
        intent.putExtra("click_type", 1);
        setResult(0, intent);
        finish();
        return true;
    }

    @Override // com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.kugou.android.watch.lite.common.image.CropImageView.a
    public void setCropHightlight(e.c.a.g.a.f.i.d dVar) {
        this.F = dVar;
    }
}
