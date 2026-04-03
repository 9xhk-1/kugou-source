package e.c.a.g.a;

import com.kugou.android.audioidentify.AudioIdentifyFragment;
import com.kugou.android.watch.lite.base.main.MainFragmentContainer;
import com.kugou.android.watch.lite.component.MainActivity;
import com.kugou.android.watch.lite.component.MainFragment;
import com.kugou.android.watch.lite.component.download.DownloadListFragment;
import com.kugou.android.watch.lite.component.family.FamilyControlCodeActivity;
import com.kugou.android.watch.lite.component.feedback.FeedbackActivity;
import com.kugou.android.watch.lite.component.player.subview.PlayerMenuView;
import com.kugou.android.watch.lite.component.player.wdiget.PlayerMoreFragment;
import com.kugou.android.watch.lite.component.recentplaylist.RecentPlaySongsFragment;
import com.kugou.android.watch.lite.component.search.SearchFragment;
import com.kugou.android.watch.lite.component.vip.VipCenterFragment;
import com.kugou.android.watch.lite.setting.SettingFragment;
import com.kugou.android.watch.lite.user.login.UserLoginFragment;
import com.kugou.android.watch.lite.user.login.UserLoginIntegrationNewFragment;
import com.kugou.android.watch.lite.user.login.UserLoginIntegrationXtcFragment;
import com.kugou.common.event.FavSongStatusItemEvent;
import com.kugou.common.event.RingToneStatusItemEvent;
import com.kugou.common.event.ShareSongStatusItemEvent;
import e.c.a.g.a.d.x.j;
import e.c.a.g.a.g.n.d;
import e.c.a.g.a.p.l;
import e.c.a.g.a.r.d.c;
import e.c.a.g.a.r.e.k.f;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;

/* JADX INFO: loaded from: classes.dex */
public class a implements SubscriberInfoIndex {
    public static final Map<Class<?>, SubscriberInfo> a = new HashMap();

    static {
        ThreadMode threadMode = ThreadMode.MAIN;
        a(new SimpleSubscriberInfo(UserLoginIntegrationXtcFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.c.b.a.class, threadMode)}));
        a(new SimpleSubscriberInfo(UserLoginIntegrationNewFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.c.b.a.class, threadMode)}));
        a(new SimpleSubscriberInfo(MainFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.r.d.b.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.g.d.b.class, threadMode), new SubscriberMethodInfo("onEventMainThread", c.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.g.m.a.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.g.p.a.class, threadMode), new SubscriberMethodInfo("onEventMainThread", d.a.class, threadMode)}));
        a(new SimpleSubscriberInfo(f.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.r.e.j.a.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.n.a.class, threadMode)}));
        a(new SimpleSubscriberInfo(PlayerMoreFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", RingToneStatusItemEvent.class, threadMode), new SubscriberMethodInfo("onEventMainThread", ShareSongStatusItemEvent.class, threadMode), new SubscriberMethodInfo("onEventMainThread", FavSongStatusItemEvent.class, threadMode)}));
        a(new SimpleSubscriberInfo(MainFragmentContainer.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.t.d.class, threadMode)}));
        a(new SimpleSubscriberInfo(VipCenterFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.r.d.b.class, threadMode)}));
        a(new SimpleSubscriberInfo(RecentPlaySongsFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.g.m.a.class, threadMode)}));
        a(new SimpleSubscriberInfo(SearchFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.t.d.class, threadMode)}));
        a(new SimpleSubscriberInfo(SettingFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", c.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.r.d.b.class, threadMode), new SubscriberMethodInfo("onEventMainThread", l.class, threadMode)}));
        a(new SimpleSubscriberInfo(FamilyControlCodeActivity.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.g.e.g.a.class, threadMode)}));
        a(new SimpleSubscriberInfo(MainActivity.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("handleShowPlayerAfterFee", j.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.g.p.a.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.g.p.c.b.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.d.m.a.class, threadMode)}));
        a(new SimpleSubscriberInfo(DownloadListFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.g.d.b.class, threadMode)}));
        a(new SimpleSubscriberInfo(e.c.a.g.a.g.h.n.a.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", l.class, threadMode)}));
        a(new SimpleSubscriberInfo(PlayerMenuView.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.t.b.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.t.c.class, threadMode)}));
        a(new SimpleSubscriberInfo(AudioIdentifyFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.c.b.a.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.c.b.b.class, threadMode)}));
        a(new SimpleSubscriberInfo(FeedbackActivity.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.g.g.b.a.class, threadMode)}));
        a(new SimpleSubscriberInfo(UserLoginFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.r.e.j.a.class, threadMode), new SubscriberMethodInfo("onEventMainThread", e.c.a.g.a.n.a.class, threadMode)}));
        a(new SimpleSubscriberInfo(e.c.a.g.a.g.h.k.a.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEventMainThread", l.class, threadMode)}));
    }

    public static void a(SubscriberInfo subscriberInfo) {
        a.put(subscriberInfo.getSubscriberClass(), subscriberInfo);
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfoIndex
    public SubscriberInfo getSubscriberInfo(Class<?> cls) {
        SubscriberInfo subscriberInfo = a.get(cls);
        if (subscriberInfo != null) {
            return subscriberInfo;
        }
        return null;
    }
}
