package e.c.a.g.a.d.b0;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewBase;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewHome;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewNormal;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewNormalAnimationFirst;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public LinkedHashSet<b> a;

    public interface b {
        FragmentViewBase create(@NonNull AbsFrameworkActivity absFrameworkActivity, @NonNull e.c.a.g.a.d.b0.a aVar, @NonNull Class<? extends Fragment> cls, @NonNull Bundle bundle);
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.b0.c$c, reason: collision with other inner class name */
    public static class C0043c {
        public static final c a = new c();
    }

    public static c c() {
        return C0043c.a;
    }

    @NonNull
    public FragmentViewBase a(AbsFrameworkActivity absFrameworkActivity, Class<? extends Fragment> cls, Bundle bundle) {
        FragmentViewBase fragmentViewNormal;
        e.c.a.g.a.d.b0.a aVar = (e.c.a.g.a.d.b0.a) cls.getAnnotation(e.c.a.g.a.d.b0.a.class);
        if (aVar != null) {
            FragmentViewBase fragmentViewBaseB = b(absFrameworkActivity, cls, aVar, bundle);
            if (fragmentViewBaseB != null) {
                return fragmentViewBaseB;
            }
            int iViewType = aVar.viewType();
            fragmentViewNormal = iViewType != 1 ? iViewType != 2 ? new FragmentViewNormal(absFrameworkActivity) : new FragmentViewHome(absFrameworkActivity) : new FragmentViewNormalAnimationFirst(absFrameworkActivity, aVar);
        } else {
            fragmentViewNormal = null;
        }
        if (fragmentViewNormal == null) {
            fragmentViewNormal = new FragmentViewNormal(absFrameworkActivity);
        }
        if (e.c.a.g.a.f.a.q()) {
            if (fragmentViewNormal instanceof FragmentViewHome) {
                fragmentViewNormal.setShowCircle(true);
                fragmentViewNormal.setBackgroundColor(-16777216);
            }
            fragmentViewNormal.setEnableAlphaAnim(false);
        }
        return fragmentViewNormal;
    }

    public final FragmentViewBase b(AbsFrameworkActivity absFrameworkActivity, Class<? extends Fragment> cls, e.c.a.g.a.d.b0.a aVar, Bundle bundle) {
        LinkedHashSet<b> linkedHashSet = this.a;
        if (linkedHashSet == null) {
            return null;
        }
        Iterator<b> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            FragmentViewBase fragmentViewBaseCreate = it.next().create(absFrameworkActivity, aVar, cls, bundle);
            if (fragmentViewBaseCreate != null) {
                return fragmentViewBaseCreate;
            }
        }
        return null;
    }

    public c() {
    }
}
