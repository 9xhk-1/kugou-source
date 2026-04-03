package com.kugou.android.watch.lite.component.player.report;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.t;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import f.i;
import f.o;
import f.u.c0;
import f.u.m;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class SongReportFragment extends DelegateFragment implements View.OnClickListener, e.c.a.g.a.g.j.e.b {
    public EditText A;
    public Subscription C;
    public View u;
    public View v;
    public View w;
    public ImageView x;
    public View y;
    public ImageView z;
    public final ArrayList<e.c.a.g.a.g.j.e.c> r = new ArrayList<>();
    public final ArrayList<e.c.a.g.a.g.j.e.a> s = m.c(new e.c.a.g.a.g.j.e.a(1, "政治反动"), new e.c.a.g.a.g.j.e.a(2, "色情低俗"), new e.c.a.g.a.g.j.e.a(3, "违法犯罪"), new e.c.a.g.a.g.j.e.a(4, "血腥暴力"), new e.c.a.g.a.g.j.e.a(5, "谩骂造谣"), new e.c.a.g.a.g.j.e.a(6, "侵权抄袭"), new e.c.a.g.a.g.j.e.a(15, "饭圈不良信息"), new e.c.a.g.a.g.j.e.a(15, "其他"));
    public final ArrayList<e.c.a.g.a.g.j.e.a> t = m.c(new e.c.a.g.a.g.j.e.a(1, "政治反动"), new e.c.a.g.a.g.j.e.a(2, "色情低俗"), new e.c.a.g.a.g.j.e.a(3, "违法犯罪"), new e.c.a.g.a.g.j.e.a(4, "血腥暴力"), new e.c.a.g.a.g.j.e.a(5, "谩骂造谣"), new e.c.a.g.a.g.j.e.a(15, "其他违规"), new e.c.a.g.a.g.j.e.a(15, "饭圈不良信息"));
    public final KGMusicWrapper B = f.e();
    public final Runnable D = new a();

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SongReportFragment.this.e();
        }
    }

    public static final class b implements TextView.OnEditorActionListener {
        public static final b a = new b();

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            l1.J(textView.getContext(), textView);
            return true;
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SongReportFragment.this.e();
        }
    }

    public static final class d<T> implements Action1 {
        public d() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<String> cVar) {
            SongReportFragment.this.i0();
            if (cVar.f()) {
                SongReportFragment.this.x0();
            } else {
                p1.h(KGApplication.getContext(), "举报失败，请稍后重试");
            }
        }
    }

    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            SongReportFragment.this.i0();
            p1.h(KGApplication.getContext(), "网络异常，请稍后重试");
        }
    }

    public final void A0() {
        View view = this.u;
        if (view == null) {
            j.t("contentContainer");
            throw null;
        }
        view.setVisibility(8);
        View view2 = this.v;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.v;
        if (view3 == null) {
            return;
        }
        view3.setOnClickListener(new c());
    }

    public final void B0() {
        Object next;
        if (u0.m(KGApplication.getContext())) {
            Iterator<T> it = this.r.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((e.c.a.g.a.g.j.e.c) next).e()) {
                        break;
                    }
                }
            }
            e.c.a.g.a.g.j.e.c cVar = (e.c.a.g.a.g.j.e.c) next;
            e.c.a.g.a.g.j.e.a aVarB = cVar == null ? null : cVar.b();
            if (aVarB == null) {
                p1.h(getContext(), "请先选择举报类型");
                return;
            }
            EditText editText = this.A;
            if (editText == null) {
                j.t("questionEt");
                throw null;
            }
            String string = editText.getText().toString();
            KGMusicWrapper kGMusicWrapper = this.B;
            if (kGMusicWrapper == null) {
                x0();
                return;
            }
            i<Integer, String> iVarW0 = w0(kGMusicWrapper);
            int iIntValue = iVarW0.c().intValue();
            String strD = iVarW0.d();
            p0();
            i1.a(this.C);
            this.C = new e.c.a.g.a.g.j.e.d().a(iIntValue, strD, aVarB.b(), aVarB.c(), string).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(), new e());
        }
    }

    public final void C0(int i2) {
        if (i2 == 1) {
            ImageView imageView = this.x;
            if (imageView == null) {
                j.t("contentSelectView");
                throw null;
            }
            imageView.setSelected(true);
            ImageView imageView2 = this.z;
            if (imageView2 == null) {
                j.t("coverSelectView");
                throw null;
            }
            imageView2.setSelected(false);
            y0();
        } else {
            ImageView imageView3 = this.x;
            if (imageView3 == null) {
                j.t("contentSelectView");
                throw null;
            }
            imageView3.setSelected(false);
            ImageView imageView4 = this.z;
            if (imageView4 == null) {
                j.t("coverSelectView");
                throw null;
            }
            imageView4.setSelected(true);
            z0();
        }
        ImageView imageView5 = this.x;
        if (imageView5 == null) {
            j.t("contentSelectView");
            throw null;
        }
        if (imageView5.isSelected()) {
            ImageView imageView6 = this.x;
            if (imageView6 == null) {
                j.t("contentSelectView");
                throw null;
            }
            imageView6.setImageResource(R.drawable.young_ic_select);
        } else {
            ImageView imageView7 = this.x;
            if (imageView7 == null) {
                j.t("contentSelectView");
                throw null;
            }
            imageView7.setImageResource(R.drawable.shape_circle_frame);
        }
        ImageView imageView8 = this.z;
        if (imageView8 == null) {
            j.t("coverSelectView");
            throw null;
        }
        if (imageView8.isSelected()) {
            ImageView imageView9 = this.z;
            if (imageView9 != null) {
                imageView9.setImageResource(R.drawable.young_ic_select);
                return;
            } else {
                j.t("coverSelectView");
                throw null;
            }
        }
        ImageView imageView10 = this.z;
        if (imageView10 != null) {
            imageView10.setImageResource(R.drawable.shape_circle_frame);
        } else {
            j.t("coverSelectView");
            throw null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "v");
        if (u1.g()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.report_song_content) {
            C0(1);
        } else if (id == R.id.report_song_cover) {
            C0(2);
        } else {
            if (id != R.id.tv_submit) {
                return;
            }
            B0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_song_report, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        i1.a(this.C);
        View view = this.v;
        if (view == null) {
            return;
        }
        view.removeCallbacks(this.D);
    }

    @Override // e.c.a.g.a.g.j.e.b
    public void onSelect(e.c.a.g.a.g.j.e.c cVar) {
        j.e(cVar, "selectView");
        for (e.c.a.g.a.g.j.e.c cVar2 : this.r) {
            if (j.a(cVar2, cVar)) {
                cVar2.f(true);
            } else {
                cVar2.f(false);
            }
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        ArrayList<e.c.a.g.a.g.j.e.c> arrayList = this.r;
        View viewFindViewById = view.findViewById(R.id.type_container_1);
        j.d(viewFindViewById, "view.findViewById(R.id.type_container_1)");
        arrayList.add(new e.c.a.g.a.g.j.e.c(viewFindViewById, this));
        ArrayList<e.c.a.g.a.g.j.e.c> arrayList2 = this.r;
        View viewFindViewById2 = view.findViewById(R.id.type_container_2);
        j.d(viewFindViewById2, "view.findViewById(R.id.type_container_2)");
        arrayList2.add(new e.c.a.g.a.g.j.e.c(viewFindViewById2, this));
        ArrayList<e.c.a.g.a.g.j.e.c> arrayList3 = this.r;
        View viewFindViewById3 = view.findViewById(R.id.type_container_3);
        j.d(viewFindViewById3, "view.findViewById(R.id.type_container_3)");
        arrayList3.add(new e.c.a.g.a.g.j.e.c(viewFindViewById3, this));
        ArrayList<e.c.a.g.a.g.j.e.c> arrayList4 = this.r;
        View viewFindViewById4 = view.findViewById(R.id.type_container_4);
        j.d(viewFindViewById4, "view.findViewById(R.id.type_container_4)");
        arrayList4.add(new e.c.a.g.a.g.j.e.c(viewFindViewById4, this));
        ArrayList<e.c.a.g.a.g.j.e.c> arrayList5 = this.r;
        View viewFindViewById5 = view.findViewById(R.id.type_container_5);
        j.d(viewFindViewById5, "view.findViewById(R.id.type_container_5)");
        arrayList5.add(new e.c.a.g.a.g.j.e.c(viewFindViewById5, this));
        ArrayList<e.c.a.g.a.g.j.e.c> arrayList6 = this.r;
        View viewFindViewById6 = view.findViewById(R.id.type_container_6);
        j.d(viewFindViewById6, "view.findViewById(R.id.type_container_6)");
        arrayList6.add(new e.c.a.g.a.g.j.e.c(viewFindViewById6, this));
        ArrayList<e.c.a.g.a.g.j.e.c> arrayList7 = this.r;
        View viewFindViewById7 = view.findViewById(R.id.type_container_7);
        j.d(viewFindViewById7, "view.findViewById(R.id.type_container_7)");
        arrayList7.add(new e.c.a.g.a.g.j.e.c(viewFindViewById7, this));
        ArrayList<e.c.a.g.a.g.j.e.c> arrayList8 = this.r;
        View viewFindViewById8 = view.findViewById(R.id.type_container_8);
        j.d(viewFindViewById8, "view.findViewById(R.id.type_container_8)");
        arrayList8.add(new e.c.a.g.a.g.j.e.c(viewFindViewById8, this));
        View viewFindViewById9 = view.findViewById(R.id.content_container);
        j.d(viewFindViewById9, "view.findViewById(R.id.content_container)");
        this.u = viewFindViewById9;
        this.v = view.findViewById(R.id.result_container);
        View viewFindViewById10 = view.findViewById(R.id.report_song_content);
        j.d(viewFindViewById10, "view.findViewById(R.id.report_song_content)");
        this.w = viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.report_song_content_select);
        j.d(viewFindViewById11, "view.findViewById(R.id.report_song_content_select)");
        this.x = (ImageView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.report_song_cover);
        j.d(viewFindViewById12, "view.findViewById(R.id.report_song_cover)");
        this.y = viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.report_song_cover_select);
        j.d(viewFindViewById13, "view.findViewById(R.id.report_song_cover_select)");
        this.z = (ImageView) viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.et_report_question);
        j.d(viewFindViewById14, "view.findViewById(R.id.et_report_question)");
        EditText editText = (EditText) viewFindViewById14;
        this.A = editText;
        b bVar = b.a;
        if (editText == null) {
            j.t("questionEt");
            throw null;
        }
        editText.setOnEditorActionListener(bVar);
        View[] viewArr = new View[3];
        View view2 = this.w;
        if (view2 == null) {
            j.t("contentReportView");
            throw null;
        }
        viewArr[0] = view2;
        View view3 = this.y;
        if (view3 == null) {
            j.t("coverReportView");
            throw null;
        }
        viewArr[1] = view3;
        viewArr[2] = j0(R.id.tv_submit);
        u1.b(this, viewArr);
        C0(1);
    }

    public final void v0(List<e.c.a.g.a.g.j.e.a> list) {
        Iterator<e.c.a.g.a.g.j.e.a> it = list.iterator();
        for (e.c.a.g.a.g.j.e.c cVar : this.r) {
            if (it.hasNext()) {
                cVar.g(it.next());
                cVar.h();
            } else {
                cVar.d();
            }
        }
    }

    public final i<Integer, String> w0(KGMusicWrapper kGMusicWrapper) {
        ImageView imageView = this.x;
        if (imageView == null) {
            j.t("contentSelectView");
            throw null;
        }
        if (imageView.isSelected()) {
            String strC = t.c(c0.b(o.a("mixsongid", Long.valueOf(kGMusicWrapper.getMixId()))));
            j.d(strC, "toJson(body)");
            return new i<>(89, strC);
        }
        ImageView imageView2 = this.z;
        if (imageView2 == null) {
            j.t("coverSelectView");
            throw null;
        }
        if (!imageView2.isSelected()) {
            return new i<>(89, "");
        }
        String strC2 = t.c(c0.b(o.a("album_id", Long.valueOf(kGMusicWrapper.getAlbumID() > 0 ? kGMusicWrapper.getAlbumID() : h1.v(kGMusicWrapper.getFeeAlbumID(), 0L)))));
        j.d(strC2, "toJson(body)");
        return new i<>(90, strC2);
    }

    public final void x0() {
        A0();
        View view = this.v;
        if (view == null) {
            return;
        }
        view.postDelayed(this.D, 1000L);
    }

    public final void y0() {
        v0(this.s);
    }

    public final void z0() {
        v0(this.t);
    }
}
