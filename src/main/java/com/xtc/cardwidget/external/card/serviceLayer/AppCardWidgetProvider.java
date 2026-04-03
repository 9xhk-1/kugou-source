package com.xtc.cardwidget.external.card.serviceLayer;

import android.content.Context;
import android.os.Build;
import android.support.annotation.CallSuper;
import d.a.a.a$b.b.a;
import d.a.a.a$b.b.c;
import d.a.a.a$b.b.d;
import d.a.a.a$b.b.e;
import d.a.a.a$b.b.f;
import d.a.a.a$b.d.i;
import e.g.b.b;
import f.s;
import f.z.c.l;
import f.z.d.j;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppCardWidgetProvider extends BaseInterfaceLayerProvider implements e.g.a.b.a.b.d.a {
    public final String k;

    public static final class a extends k implements l<AppCardWidgetProvider, s> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final void a(AppCardWidgetProvider appCardWidgetProvider) {
            j.e(appCardWidgetProvider, "it");
            d.a.a.a$b.c.b.d.a aVar = new d.a.a.a$b.c.b.d.a();
            j.e(appCardWidgetProvider, "iCardState");
            b.a.a("State.CardStateProcessor", j.l("listener state callback: ", appCardWidgetProvider));
            aVar.a.add(appCardWidgetProvider);
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(AppCardWidgetProvider appCardWidgetProvider) {
            a(appCardWidgetProvider);
            return s.a;
        }
    }

    public AppCardWidgetProvider() {
        String simpleName = AppCardWidgetProvider.class.getSimpleName();
        j.d(simpleName, "javaClass.simpleName");
        this.k = simpleName;
    }

    @CallSuper
    public final void o() {
        b bVar = b.a;
        bVar.a(this.k, "onCardWidgetInitial...");
        Context context = getContext();
        if (context != null) {
            e.g.a.b.b.a.g.b.a.b(context);
            d.a.a.a$b.b.a aVar = d.a.a.a$b.b.a.a;
            if (!d.a.a.a$b.b.a.b) {
                d.a.a.a$b.b.a.b = true;
                bVar.d("GlobalDIConfig", "initial...");
                aVar.a(f.z.d.s.a(d.a.a.a$b.d.j.class), new a.C0032a(d.a.a.a$b.b.b.a));
                aVar.a(f.z.d.s.a(d.a.a.a$b.c.d.a.b.class), new a.C0032a(c.a));
                aVar.a(f.z.d.s.a(i.class), new a.C0032a(d.a));
                aVar.a(f.z.d.s.a(d.a.a.a$b.a.c.b.class), new a.C0032a(e.a));
                aVar.a(f.z.d.s.a(d.a.a.a$b.a.c.a.class), new a.C0032a(f.a));
            }
        }
        m(this, a.a);
        l();
    }

    @Override // e.g.a.b.a.b.d.a
    @CallSuper
    public void onCardCreate(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        b.a.a(this.k, j.l("onCardCreate() -> widgetCode is ", str));
        e.g.a.b.a.b.a.a.a.d(str, getCardLayoutName(str));
    }

    @Override // com.xtc.cardwidget.external.card.serviceLayer.BaseCardStrategyProvider, com.xtc.cardwidget.external.channel.client.provider.ChannelClientProvider, android.content.ContentProvider
    @CallSuper
    public boolean onCreate() {
        b bVar = b.a;
        bVar.a(this.k, "onCreate()");
        if (Build.VERSION.SDK_INT < 25) {
            bVar.a(this.k, "设备版本过低，快屏不可用");
            return false;
        }
        o();
        return super.onCreate();
    }

    @CallSuper
    public void onDestroy(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        b.a.a(this.k, "onDestroy()");
    }

    @CallSuper
    public void onPause(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        b.a.a(this.k, "onPause()");
    }

    @Override // e.g.a.b.a.b.d.a
    public void onRenderFail(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        b.a.a(this.k, j.l("onRenderFail() -> widgetCode: ", str));
    }

    public void subscribed(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        b.a.a(this.k, j.l("subscribed() -> widgetCode: ", str));
    }

    public void unSubscribed(Context context, String str) {
        j.e(context, "context");
        j.e(str, "widgetCode");
        b.a.a(this.k, j.l("unSubscribed() -> widgetCode: ", str));
    }
}
