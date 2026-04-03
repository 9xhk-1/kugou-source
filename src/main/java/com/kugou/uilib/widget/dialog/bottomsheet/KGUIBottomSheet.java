package com.kugou.uilib.widget.dialog.bottomsheet;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.kugou.uilib.R;
import com.kugou.uilib.utils.KGUISystemUtil;
import com.kugou.uilib.widget.baseDelegate.commImpl.CornerDelegate;
import com.kugou.uilib.widget.dialog.KGBaseDialog;
import com.kugou.uilib.widget.dialog.bottomsheet.adapter.CommonBottomListAdapter;
import com.kugou.uilib.widget.dialog.bottomsheet.delegate.InterBottomSheetDelegate;
import com.kugou.uilib.widget.imageview.round.roundedimageview.Corner;
import com.kugou.uilib.widget.layout.linearlayout.KGUILinearLayout;
import com.kugou.uilib.widget.recyclerview.KGUIRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIBottomSheet extends KGBaseDialog {
    private final int DEFAULT_BOTTOM_SHEET_HEIGHT;
    private RecyclerView.Adapter adapter;
    private KGUILinearLayout bottomSheet;
    private LinearLayout llContain;
    private KGUIBottomSheetBehavior<NestedScrollView> mBehavior;
    private KGUIRecyclerView rv_list;
    private TextView tv_cancel;
    private TextView tv_title;

    public static class KGUIBottomSheetCustomBuilder extends KGUIBottomSheetBaseBuilder<KGUIBottomSheetCustomBuilder> {
        private List<InterBottomSheetDelegate> delegates;

        public KGUIBottomSheetCustomBuilder(Context context) {
            super(context);
            this.delegates = new ArrayList();
        }

        private void resetDialogHeight(final KGUIBottomSheet kGUIBottomSheet) {
            kGUIBottomSheet.llContain.post(new Runnable() { // from class: com.kugou.uilib.widget.dialog.bottomsheet.KGUIBottomSheet.KGUIBottomSheetCustomBuilder.1
                @Override // java.lang.Runnable
                public void run() {
                    int height = kGUIBottomSheet.tv_title.getVisibility() == 0 ? kGUIBottomSheet.tv_title.getHeight() : 0;
                    int height2 = kGUIBottomSheet.tv_cancel.getVisibility() == 0 ? kGUIBottomSheet.tv_cancel.getHeight() : 0;
                    KGUIBottomSheet kGUIBottomSheet2 = kGUIBottomSheet;
                    kGUIBottomSheet2.setBottomSheetMeasureHeight(height + kGUIBottomSheet2.llContain.getHeight() + height2);
                }
            });
        }

        public KGUIBottomSheetCustomBuilder addBottomSheetDelegate(InterBottomSheetDelegate interBottomSheetDelegate) {
            List<InterBottomSheetDelegate> list = this.delegates;
            if (list != null) {
                list.add(interBottomSheetDelegate);
            }
            return this;
        }

        @Override // com.kugou.uilib.widget.dialog.bottomsheet.KGUIBottomSheetBaseBuilder
        public void setMore(KGUIBottomSheet kGUIBottomSheet) {
            if (this.delegates.size() > 0) {
                for (int i2 = 0; i2 < this.delegates.size(); i2++) {
                    kGUIBottomSheet.addCustomView(this.delegates.get(i2).getContainView());
                    this.delegates.get(i2).setBottomSheet(kGUIBottomSheet);
                }
                resetDialogHeight(kGUIBottomSheet);
            }
        }
    }

    public static class KGUIBottomSheetListBuilder extends KGUIBottomSheetBaseBuilder<KGUIBottomSheetListBuilder> {
        private CommonBottomListAdapter adapter;
        private RecyclerView.LayoutManager layoutManager;
        private ArrayList<RecyclerView.ItemDecoration> mItemDecorations;

        public KGUIBottomSheetListBuilder(Context context) {
            super(context);
        }

        public KGUIBottomSheetListBuilder addBottomItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
            if (this.mItemDecorations == null) {
                this.mItemDecorations = new ArrayList<>();
            }
            this.mItemDecorations.add(itemDecoration);
            return this;
        }

        public KGUIBottomSheetListBuilder setBottomLayoutManager(RecyclerView.LayoutManager layoutManager) {
            this.layoutManager = layoutManager;
            return this;
        }

        public KGUIBottomSheetListBuilder setBottomListAdapter(CommonBottomListAdapter commonBottomListAdapter) {
            this.adapter = commonBottomListAdapter;
            return this;
        }

        @Override // com.kugou.uilib.widget.dialog.bottomsheet.KGUIBottomSheetBaseBuilder
        public void setMore(KGUIBottomSheet kGUIBottomSheet) {
            RecyclerView.LayoutManager layoutManager = this.layoutManager;
            if (layoutManager != null) {
                kGUIBottomSheet.setBottomLayoutManager(layoutManager);
            }
            ArrayList<RecyclerView.ItemDecoration> arrayList = this.mItemDecorations;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<RecyclerView.ItemDecoration> it = this.mItemDecorations.iterator();
                while (it.hasNext()) {
                    kGUIBottomSheet.addBottomItemDecoration(it.next());
                }
            }
            kGUIBottomSheet.setBottomListAdapter(this.adapter);
        }

        public KGUIBottomSheetListBuilder setOnItemClickListener(CommonBottomListAdapter.OnItemClickListener onItemClickListener) {
            CommonBottomListAdapter commonBottomListAdapter = this.adapter;
            if (commonBottomListAdapter != null) {
                commonBottomListAdapter.setOnItemClickListener(onItemClickListener);
            }
            return this;
        }
    }

    public KGUIBottomSheet(@NonNull Context context) {
        this(context, R.style.MyDialog);
    }

    public void addBottomItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.rv_list.addItemDecoration(itemDecoration);
    }

    public void addCustomView(View view) {
        if (this.llContain.getVisibility() == 8) {
            this.llContain.setVisibility(0);
            this.rv_list.setVisibility(8);
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.bottomSheet.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
            this.bottomSheet.setLayoutParams(layoutParams);
        }
        this.llContain.addView(view);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
    }

    public KGUIBottomSheetBehavior<NestedScrollView> getBehavior() {
        return this.mBehavior;
    }

    public void hasTitle(boolean z) {
        this.tv_title.setVisibility(z ? 0 : 8);
    }

    public void hideDialog() {
        this.mBehavior.setState(5);
    }

    public void init() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.windowAnimations = R.style.BottomInAndOutStyle;
            attributes.gravity = 80;
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    public void setAddCancelBtn(boolean z) {
        this.tv_cancel.setVisibility(z ? 0 : 8);
    }

    public void setBottomLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.rv_list.setLayoutManager(layoutManager);
    }

    public void setBottomListAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
        if (adapter != null) {
            MyDividerItemDecoration myDividerItemDecoration = new MyDividerItemDecoration(getContext(), 1, false);
            myDividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider_horizontal));
            this.rv_list.addItemDecoration(myDividerItemDecoration);
            this.rv_list.setAdapter(adapter);
        }
    }

    public void setBottomSheetBackgroundColor(@ColorInt int i2) {
        this.bottomSheet.setBackgroundColor(i2);
    }

    public void setBottomSheetBackgroundDrawableResource(@DrawableRes int i2) {
        this.bottomSheet.setBackgroundResource(i2);
    }

    public void setBottomSheetHeight(int i2) {
        KGUILinearLayout kGUILinearLayout = this.bottomSheet;
        if (kGUILinearLayout != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) kGUILinearLayout.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).height = KGUISystemUtil.dp2px(i2);
            this.bottomSheet.setLayoutParams(layoutParams);
        }
    }

    public void setBottomSheetMeasureHeight(int i2) {
        KGUILinearLayout kGUILinearLayout = this.bottomSheet;
        if (kGUILinearLayout != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) kGUILinearLayout.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).height = i2;
            this.bottomSheet.setLayoutParams(layoutParams);
        }
    }

    public void setCancelClickListener(View.OnClickListener onClickListener) {
        this.tv_cancel.setOnClickListener(onClickListener);
    }

    public void setCancelText(String str) {
        this.tv_cancel.setText(str);
    }

    public void setCommonTitle(String str) {
        this.tv_title.setText(str);
    }

    public void setCornerRadius(float f2, @Corner int... iArr) {
        if (this.bottomSheet.getCommonDelegate(CornerDelegate.class) != null) {
            ((CornerDelegate) this.bottomSheet.getCommonDelegate(CornerDelegate.class)).setCornerRadius(f2, iArr);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.mBehavior.getState() == 3) {
            this.mBehavior.setState(5);
        } else {
            this.mBehavior.setState(3);
        }
    }

    public KGUIBottomSheet(@NonNull Context context, int i2) {
        super(context, i2);
        this.DEFAULT_BOTTOM_SHEET_HEIGHT = HttpStatus.SC_BAD_REQUEST;
        init();
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.kgui_bottom_sheet_dialog, (ViewGroup) null);
        this.bottomSheet = (KGUILinearLayout) viewGroup.findViewById(R.id.bottom_sheet);
        setBottomSheetHeight(HttpStatus.SC_BAD_REQUEST);
        KGUIRecyclerView kGUIRecyclerView = (KGUIRecyclerView) viewGroup.findViewById(R.id.rv_list);
        this.rv_list = kGUIRecyclerView;
        kGUIRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.llContain = (LinearLayout) viewGroup.findViewById(R.id.ll_contain);
        this.tv_title = (TextView) viewGroup.findViewById(R.id.tv_title);
        this.tv_cancel = (TextView) viewGroup.findViewById(R.id.tv_cancel);
        viewGroup.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.kugou.uilib.widget.dialog.bottomsheet.KGUIBottomSheet.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KGUIBottomSheet.this.mBehavior.setState(5);
            }
        });
        KGUIBottomSheetBehavior<NestedScrollView> kGUIBottomSheetBehavior = new KGUIBottomSheetBehavior<>();
        this.mBehavior = kGUIBottomSheetBehavior;
        kGUIBottomSheetBehavior.setHideable(true);
        this.mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.kugou.uilib.widget.dialog.bottomsheet.KGUIBottomSheet.2
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NonNull View view, float f2) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NonNull View view, int i3) {
                if (i3 == 1) {
                    Log.e("Bottom Sheet Behaviour", "STATE_DRAGGING");
                    return;
                }
                if (i3 == 2) {
                    Log.e("Bottom Sheet Behaviour", "STATE_SETTLING");
                    return;
                }
                if (i3 == 3) {
                    Log.e("Bottom Sheet Behaviour", "STATE_EXPANDED");
                    return;
                }
                if (i3 == 4) {
                    KGUIBottomSheet.this.cancel();
                    Log.e("Bottom Sheet Behaviour", "STATE_COLLAPSED");
                } else {
                    if (i3 != 5) {
                        return;
                    }
                    KGUIBottomSheet.this.cancel();
                    Log.e("Bottom Sheet Behaviour", "STATE_HIDDEN");
                }
            }
        });
        ((CoordinatorLayout.LayoutParams) this.bottomSheet.getLayoutParams()).setBehavior(this.mBehavior);
        setContentView(viewGroup, new ViewGroup.LayoutParams(-1, -1));
    }
}
