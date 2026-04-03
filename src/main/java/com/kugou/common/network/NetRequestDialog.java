package com.kugou.common.network;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.d.h.b.e;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.m.c;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class NetRequestDialog extends e {
    private final String desc;
    private final boolean needHide;
    private int sizeConfig;

    public /* synthetic */ NetRequestDialog(Context context, String str, boolean z, int i2, g gVar) {
        this(context, str, (i2 & 4) != 0 ? false : z);
    }

    public final boolean getNeedHide() {
        return this.needHide;
    }

    public final int getSizeConfig() {
        return this.sizeConfig;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_net_request);
        TextView textView = (TextView) findViewById(R.id.tv_content);
        if (textView != null) {
            textView.setText(this.desc);
        }
        View viewFindViewById = findViewById(R.id.tv_disagree);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kugou.common.network.NetRequestDialog.onCreate.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NetRequestDialog.this.dismiss();
                }
            });
        }
        View viewFindViewById2 = findViewById(R.id.tv_agree);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.kugou.common.network.NetRequestDialog.onCreate.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.a.j("once_request_mobile_net", true);
                    NetRequestDialog.this.dismiss();
                }
            });
        }
        if (this.needHide) {
            TextView textView2 = (TextView) findViewById(R.id.tv_title);
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            Log.e("mhs_watch", "NetRequestDialog needHide");
            float f2 = this.sizeConfig;
            TextView textView3 = (TextView) findViewById(R.id.tv_content);
            if (textView3 == null) {
                return;
            }
            textView3.setTextSize(1, f2);
        }
    }

    public final void setSizeConfig(int i2) {
        this.sizeConfig = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetRequestDialog(Context context, String str, boolean z) {
        super(context, R.style.PopDialogTheme);
        j.e(context, "context");
        j.e(str, "desc");
        this.desc = str;
        this.needHide = z;
        this.sizeConfig = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(b.O, 13);
    }
}
