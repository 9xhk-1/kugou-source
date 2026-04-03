package e.c.a.g.a.g.d;

import android.os.Bundle;
import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.h.b.e;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u1;
import f.z.d.j;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e implements View.OnClickListener {
    public final KGMusicWrapper a;
    public final int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f741d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f742f;

    /* JADX INFO: renamed from: e.c.a.g.a.g.d.a$a, reason: collision with other inner class name */
    public static final class RunnableC0110a implements Runnable {
        public RunnableC0110a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.c.a.g.a.g.m.b bVar = e.c.a.g.a.g.m.b.a;
            KGMusic kgmusic = a.this.a().getKgmusic();
            j.d(kgmusic, "curSong.kgmusic");
            bVar.b(kgmusic);
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (a.this.b() == 1) {
                e.c.a.g.a.e.b.b(new YoungBITask(20483, "click").setType("4").setMixsongid(String.valueOf(a.this.a().getMixId())));
            } else if (a.this.b() == 2) {
                e.c.a.g.a.e.b.b(new YoungBITask(20484, "click").setType("4").setMixsongid(String.valueOf(a.this.a().getMixId())));
            }
            a.this.dismiss();
            a.this.dismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DelegateFragment delegateFragment, KGMusicWrapper kGMusicWrapper, int i2) {
        super(delegateFragment.requireContext(), R.style.PopDialogTheme);
        j.e(delegateFragment, "fragment");
        j.e(kGMusicWrapper, "curSong");
        this.a = kGMusicWrapper;
        this.b = i2;
    }

    public final KGMusicWrapper a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer numValueOf = view == null ? null : Integer.valueOf(view.getId());
        if (numValueOf != null && numValueOf.intValue() == R.id.tv_delete) {
            int i2 = this.b;
            if (i2 == 1) {
                e.c.a.g.a.d.i.d.b(this.a.getKgmusic().extUniqueId, this.a.getHashValue(), this.a.getMixId());
                e.c.a.g.a.e.b.b(new YoungBITask(20483, "click").setType("3").setMixsongid(String.valueOf(this.a.getMixId())));
                e.c.a.g.a.d.d0.a.b("DeleteDownloadDialog", "tv_delete, curSong = " + this.a + ", type = " + this.b);
            } else if (i2 == 2) {
                j0.b().a(new RunnableC0110a());
                EventBus.getDefault().post(new e.c.a.g.a.g.m.a(this.a, false, 2, null));
                e.c.a.g.a.e.b.b(new YoungBITask(20484, "click").setType("3").setMixsongid(String.valueOf(this.a.getMixId())));
                p1.h(KGApplication.getContext(), "删除成功");
                e.c.a.g.a.d.d0.a.b("DeleteDownloadDialog", "tv_delete, curSong = " + this.a + ", type = " + this.b);
            }
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_delete_item);
        e.c.a.g.a.f.o.e.a(findViewById(R.id.root_view));
        this.f741d = findViewById(R.id.tv_delete);
        this.f742f = findViewById(R.id.tv_cancel);
        u1.b(this, this.f741d, findViewById(R.id.hook_click_layer));
        e.c.a.g.a.d.d0.a.b("DeleteDownloadDialog", "onCreate, curSong = " + this.a + ", type = " + this.b);
        u1.b(new b(), this.f742f, findViewById(R.id.root_view));
        int i2 = this.b;
        if (i2 == 1) {
            e.c.a.g.a.e.b.b(new YoungBITask(20483, "click").setType("2").setMixsongid(String.valueOf(this.a.getMixId())));
        } else if (i2 == 2) {
            e.c.a.g.a.e.b.b(new YoungBITask(20484, "click").setType("2").setMixsongid(String.valueOf(this.a.getMixId())));
        }
    }
}
