package e.c.a.g.a.g.f;

import android.os.Bundle;
import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.s.u1;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e.c.a.g.a.d.h.b.e implements View.OnClickListener {
    public final DelegateFragment a;
    public final KGMusicWrapper b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f762d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f763f;

    /* JADX INFO: renamed from: e.c.a.g.a.g.f.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0119a implements View.OnClickListener {
        public ViewOnClickListenerC0119a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.e.b.b(new YoungBITask(20482, "click").setType("4").setMixsongid(String.valueOf(a.this.a().getMixId())));
            a.this.dismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DelegateFragment delegateFragment, KGMusicWrapper kGMusicWrapper) {
        super(delegateFragment.requireContext(), R.style.PopDialogTheme);
        j.e(delegateFragment, "fragment");
        j.e(kGMusicWrapper, "curSong");
        this.a = delegateFragment;
        this.b = kGMusicWrapper;
    }

    public final KGMusicWrapper a() {
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer numValueOf = view == null ? null : Integer.valueOf(view.getId());
        if (numValueOf != null && numValueOf.intValue() == R.id.tv_delete) {
            g.k().h(2, this.a.m(), this.b.getKgmusic(), "", this.a.l());
            dismiss();
            e.c.a.g.a.e.b.b(new YoungBITask(20482, "click").setType("3").setMixsongid(String.valueOf(this.b.getMixId())));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_delete_item);
        e.c.a.g.a.f.o.e.a(findViewById(R.id.root_view));
        this.f762d = findViewById(R.id.tv_delete);
        this.f763f = findViewById(R.id.tv_cancel);
        View view = this.f762d;
        if (view != null) {
            view.setOnClickListener(this);
        }
        View view2 = this.f763f;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        u1.b(this, this.f762d, findViewById(R.id.hook_click_layer));
        u1.b(new ViewOnClickListenerC0119a(), this.f763f, findViewById(R.id.root_view));
    }
}
