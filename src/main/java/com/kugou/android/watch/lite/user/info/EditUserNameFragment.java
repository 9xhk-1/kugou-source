package com.kugou.android.watch.lite.user.info;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.r.d.d.c;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import f.e0.o;
import f.z.d.j;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class EditUserNameFragment extends DelegateFragment {
    public EditText r;
    public Subscription s;
    public int t = 14;
    public String[] u = E0(e.c.a.g.a.f.e.c.a.a().b(e.c.a.g.a.f.e.b.y1, "34437"));
    public final String v = "修改昵称";
    public final int w = 11;
    public final e.c.a.g.a.k.d.a x = new e.c.a.g.a.k.d.a(ApmDataTypeID.NICK_NAME);

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.j.a.c().f("edit_name", EditUserNameFragment.this.getActivity());
        }
    }

    public static final class b<T> implements e.c.a.g.a.s.y1.a {
        public final /* synthetic */ EditText a;

        public b(EditText editText) {
            this.a = editText;
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onCall(String str) {
            this.a.setText(str);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ EditText b;

        public c(EditText editText) {
            this.b = editText;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l1.J(EditUserNameFragment.this.getContext(), EditUserNameFragment.this.r);
            if (u0.m(EditUserNameFragment.this.k0())) {
                String string = this.b.getText().toString();
                if (j.a(string, e.c.a.g.a.r.b.r())) {
                    p1.h(EditUserNameFragment.this.getContext(), "请先修改昵称~");
                    return;
                }
                if (!TextUtils.isEmpty(string)) {
                    int length = string.length() - 1;
                    int i2 = 0;
                    boolean z = false;
                    while (i2 <= length) {
                        boolean z2 = j.g(string.charAt(!z ? i2 : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            } else {
                                length--;
                            }
                        } else if (z2) {
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    if (!TextUtils.isEmpty(string.subSequence(i2, length + 1).toString())) {
                        if (EditUserNameFragment.this.z0(string)) {
                            p1.h(EditUserNameFragment.this.getContext(), EditUserNameFragment.this.getString(R.string.v8_kg_user_nick_name_error_3));
                            return;
                        }
                        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
                        char[] charArray = string.toCharArray();
                        j.d(charArray, "(this as java.lang.String).toCharArray()");
                        int i3 = 0;
                        for (char c : charArray) {
                            i3 = c < 128 ? i3 + 1 : i3 + 2;
                        }
                        if (i3 > EditUserNameFragment.this.t) {
                            p1.h(EditUserNameFragment.this.getContext(), EditUserNameFragment.this.getString(R.string.v8_kg_user_nick_name_error_4));
                            return;
                        }
                        EditUserNameFragment editUserNameFragment = EditUserNameFragment.this;
                        int length2 = string.length() - 1;
                        int i4 = 0;
                        boolean z3 = false;
                        while (i4 <= length2) {
                            boolean z4 = j.g(string.charAt(!z3 ? i4 : length2), 32) <= 0;
                            if (z3) {
                                if (!z4) {
                                    break;
                                } else {
                                    length2--;
                                }
                            } else if (z4) {
                                i4++;
                            } else {
                                z3 = true;
                            }
                        }
                        editUserNameFragment.F0(string.subSequence(i4, length2 + 1).toString());
                        return;
                    }
                }
                p1.h(EditUserNameFragment.this.getContext(), EditUserNameFragment.this.getString(R.string.v8_kg_user_nick_name_error_empty));
            }
        }
    }

    public static final class d<T, R> implements Func1 {
        public static final d<T, R> a = new d<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c.b call(String str) {
            return new e.c.a.g.a.r.d.d.c().g(str);
        }
    }

    public static final class e<T> implements Action1 {
        public final /* synthetic */ String b;

        public e(String str) {
            this.b = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(c.b bVar) {
            EditUserNameFragment.this.i0();
            if (bVar.a == 1) {
                p1.h(EditUserNameFragment.this.getContext(), "修改昵称成功");
                e.c.a.g.a.r.b.b0(this.b);
                EventBus.getDefault().post(new e.c.a.g.a.r.d.b(2, this.b));
                e.c.a.g.a.e.b.b(new YoungBITask(20487, "statistics"));
                EditUserNameFragment.this.e();
            } else {
                String strC = e.c.a.g.a.r.a.c(bVar.b, bVar.c);
                j.d(strC, "getErrorMsg(it.error_code, it.data)");
                if (TextUtils.isEmpty(strC)) {
                    p1.h(EditUserNameFragment.this.getContext(), "修改昵称失败");
                } else {
                    p1.h(EditUserNameFragment.this.getContext(), strC);
                }
                Log.e("mhs_watch", j.l("needFinishFragment, error_code = ", Integer.valueOf(bVar.b)));
                if (EditUserNameFragment.this.A0(j.l("", Integer.valueOf(bVar.b)))) {
                    Log.e("mhs_watch", "needFinishFragment, yes");
                    EditUserNameFragment.this.e();
                }
            }
            EditUserNameFragment.this.D0(bVar);
        }
    }

    public static final class f<T> implements Action1 {
        public f() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            p1.h(EditUserNameFragment.this.getContext(), "请求出错，修改昵称失败");
            EditUserNameFragment.this.B0(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L38
            java.lang.String[] r0 = r4.u
            if (r0 == 0) goto L38
            r2 = 1
            if (r0 == 0) goto L19
            int r3 = r0.length
            if (r3 != 0) goto L13
            r3 = 1
            goto L14
        L13:
            r3 = 0
        L14:
            if (r3 == 0) goto L17
            goto L19
        L17:
            r3 = 0
            goto L1a
        L19:
            r3 = 1
        L1a:
            if (r3 == 0) goto L1d
            goto L38
        L1d:
            if (r0 != 0) goto L21
            r5 = 0
            goto L29
        L21:
            int r5 = f.u.i.k(r0, r5)     // Catch: java.lang.Exception -> L34
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L34
        L29:
            f.z.d.j.c(r5)     // Catch: java.lang.Exception -> L34
            int r5 = r5.intValue()     // Catch: java.lang.Exception -> L34
            if (r5 < 0) goto L33
            r1 = 1
        L33:
            return r1
        L34:
            r5 = move-exception
            r5.printStackTrace()
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.user.info.EditUserNameFragment.A0(java.lang.String):boolean");
    }

    public final void B0(Throwable th) {
        e.c.a.g.a.k.d.a.c(this.x, th, this.w, this.v, null, 8, null);
    }

    public final void C0() {
        this.x.g();
    }

    public final void D0(c.b bVar) {
        if (bVar == null) {
            B0(null);
        } else if (!bVar.a()) {
            B0(new e.c.a.b.a.a.a.a(bVar.b));
        } else {
            this.x.e();
            this.x.i(true);
        }
    }

    public final String[] E0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            j.c(str);
            Object[] array = o.S(str, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void F0(String str) {
        C0();
        p0();
        i1.a(this.s);
        this.s = Observable.just(str).subscribeOn(Schedulers.io()).map(d.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(str), new f());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return getLayoutInflater().inflate(R.layout.fragment_edit_user_name, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        i1.a(this.s);
        l1.J(getContext(), this.r);
        e.c.a.g.a.j.a.c().e("edit_name");
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        EditText editText = (EditText) view.findViewById(R.id.et_user_name);
        editText.setText(e.c.a.g.a.r.b.r());
        if (e.c.a.g.a.j.a.c().b()) {
            editText.setFocusable(false);
            editText.setFocusableInTouchMode(false);
            editText.setOnClickListener(new a());
            e.c.a.g.a.j.a.c().a("edit_name", new b(editText));
        }
        this.r = editText;
        view.findViewById(R.id.tv_confirm).setOnClickListener(new c(editText));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "修改昵称";
    }

    public final boolean z0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = j.g(str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        if (TextUtils.isEmpty(str.subSequence(i2, length + 1).toString())) {
            return false;
        }
        int length2 = str.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length2) {
            boolean z4 = j.g(str.charAt(!z3 ? i3 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                }
                length2--;
            } else if (z4) {
                i3++;
            } else {
                z3 = true;
            }
        }
        return !new f.e0.e("^[\\u4E00-\\u9FA5a-zA-Z0-9\\-_]+$").a(str.subSequence(i3, length2 + 1).toString());
    }
}
