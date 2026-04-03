package com.kugou.android.watch.lite.user;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.android.watch.lite.user.login.AccountSimpleEntity;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public class AccountSelectFragment extends DelegateFragment {

    public class a extends RecyclerView.ItemDecoration {
        public final int a = l1.c(5.0f);

        public a(AccountSelectFragment accountSelectFragment) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.bottom = this.a;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountSimpleEntity accountSimpleEntity = (AccountSimpleEntity) view.getTag();
            if (accountSimpleEntity == null) {
                p1.h(view.getContext(), "数据异常");
            } else {
                EventBus.getDefault().post(new e.c.a.g.a.r.e.j.a(accountSimpleEntity));
                AccountSelectFragment.this.e();
            }
        }
    }

    public static final class c extends e.c.a.g.a.f.o.h.a<AccountSimpleEntity> {
        public final View.OnClickListener c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AccountSelectFragment f219d;

        public /* synthetic */ c(AccountSelectFragment accountSelectFragment, View.OnClickListener onClickListener, a aVar) {
            this(accountSelectFragment, onClickListener);
        }

        @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
        public void b(KGRecyclerView.e eVar, int i2) {
            AccountSimpleEntity item = getItem(i2);
            eVar.itemView.setTag(item);
            Glide.with(this.f219d).load(item.b()).into((ImageView) eVar.itemView.findViewById(R.id.account_select_cover));
            ((TextView) eVar.itemView.findViewById(R.id.account_select_name)).setText(item.a());
        }

        @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
        public KGRecyclerView.e d(ViewGroup viewGroup, int i2) {
            e.c.a.g.a.f.l.b bVar = new e.c.a.g.a.f.l.b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_account_select, viewGroup, false));
            bVar.itemView.setOnClickListener(this.c);
            return bVar;
        }

        public c(AccountSelectFragment accountSelectFragment, View.OnClickListener onClickListener) {
            this.f219d = accountSelectFragment;
            this.c = onClickListener;
        }
    }

    public static void u0(ArrayList<AccountSimpleEntity> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("key_data_accounts", arrayList);
        e.c.a.g.a.d.v.c.e(AccountSelectFragment.class, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_account_select, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() == null) {
            e();
            return;
        }
        ArrayList parcelableArrayList = getArguments().getParcelableArrayList("key_data_accounts");
        if (l0.g(parcelableArrayList)) {
            e();
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.account_select_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new a(this));
        c cVar = new c(this, new b(), null);
        recyclerView.setAdapter(cVar);
        cVar.l(parcelableArrayList);
        cVar.notifyDataSetChanged();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "账号选择页";
    }
}
