package e.c.a.g.a.r.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.s.l1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseAdapter {
    public Context a;
    public List<String> b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1161d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1162f = l1.c(47.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, Bitmap> f1163h = new HashMap();

    /* JADX INFO: renamed from: e.c.a.g.a.r.d.a$a, reason: collision with other inner class name */
    public class C0177a extends CustomTarget<Bitmap> {
        public final /* synthetic */ String a;
        public final /* synthetic */ b b;

        public C0177a(String str, b bVar) {
            this.a = str;
            this.b = bVar;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            a.this.f1163h.put(this.a, bitmap);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.b.a.setImageBitmap(bitmap);
        }
    }

    public static class b {
        public ImageView a;
        public View b;

        public b() {
        }

        public /* synthetic */ b(C0177a c0177a) {
            this();
        }
    }

    public a(Context context, List<String> list) {
        this.a = context;
        this.b = list;
    }

    public void a() {
        for (Bitmap bitmap : this.f1163h.values()) {
            if (bitmap != null) {
                bitmap.isRecycled();
            }
        }
        this.f1163h.clear();
    }

    public void b(int i2) {
        this.f1161d = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.b.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.choose_item_avatar, viewGroup, false);
            bVar = new b(null);
            bVar.a = (ImageView) view.findViewById(R.id.avatarImage);
            bVar.b = view.findViewById(R.id.selectedIndicator);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        String str = this.b.get(i2);
        RequestBuilder requestBuilderError = Glide.with(this.a).asBitmap().centerCrop().placeholder(R.drawable.ic_avatar_default_office).error(R.drawable.ic_avatar_default_office);
        int i3 = this.f1162f;
        requestBuilderError.override(i3, i3).load(str).into(new C0177a(str, bVar));
        if (i2 == this.f1161d) {
            bVar.b.setVisibility(0);
        } else {
            bVar.b.setVisibility(8);
        }
        return view;
    }
}
