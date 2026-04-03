package e.c.a.g.a.d.x.r;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public c(Context context) {
        super(context);
    }

    @Override // e.c.a.g.a.d.x.r.a
    public void a(Intent intent) {
        f(intent);
    }

    @Override // e.c.a.g.a.d.x.r.a
    public void b(Intent intent) {
        f(intent);
    }

    @Override // e.c.a.g.a.d.x.r.a
    public void c(Intent intent) {
        f(intent);
    }

    @Override // e.c.a.g.a.d.x.r.a
    public void d(Intent intent) {
        f(intent);
    }

    @Override // e.c.a.g.a.d.x.r.a
    public void e(Intent intent) {
        f(intent);
    }

    public final void f(Intent intent) {
        String stringExtra = intent.getStringExtra("command");
        int intExtra = intent.getIntExtra("keycode", -999);
        if (TextUtils.isEmpty(stringExtra)) {
        }
        if (g0.a) {
            g0.b("KGMediaButtonIntentHandler", "doForIntent: PlaybackServiceUtil.isPlaying() = " + f.q() + ", intent.getStringExtra(HeadSetCommond.CMDNAME) = " + stringExtra + ", intent.getStringExtra(HeadSetCommond.KEYCODE) = " + intExtra);
        }
        stringExtra.hashCode();
        switch (stringExtra) {
            case "previous":
                e.c.a.g.a.f.d.a.e(new Intent().setAction("young_action_notification_previous"), true);
                break;
            case "togglepause":
            case "play":
            case "stop":
            case "pause":
                e.c.a.g.a.f.d.a.e(new Intent().setAction("young_action_notification_play"), true);
                break;
            case "next":
                e.c.a.g.a.f.d.a.e(new Intent().setAction("young_action_notification_next"), true);
                break;
        }
    }
}
