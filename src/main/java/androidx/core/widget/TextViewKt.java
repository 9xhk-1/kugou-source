package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import f.s;
import f.z.c.l;
import f.z.c.r;
import f.z.d.j;
import f.z.d.k;

/* JADX INFO: loaded from: classes.dex */
public final class TextViewKt {

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements r<CharSequence, Integer, Integer, Integer, s> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(4);
        }

        @Override // f.z.c.r
        public /* bridge */ /* synthetic */ s invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return s.a;
        }

        public final void invoke(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends k implements r<CharSequence, Integer, Integer, Integer, s> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(4);
        }

        @Override // f.z.c.r
        public /* bridge */ /* synthetic */ s invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return s.a;
        }

        public final void invoke(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$3, reason: invalid class name */
    public static final class AnonymousClass3 extends k implements l<Editable, s> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(Editable editable) {
            invoke2(editable);
            return s.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
        }
    }

    public static final TextWatcher addTextChangedListener(TextView textView, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, s> rVar, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, s> rVar2, l<? super Editable, s> lVar) {
        j.f(textView, "$this$addTextChangedListener");
        j.f(rVar, "beforeTextChanged");
        j.f(rVar2, "onTextChanged");
        j.f(lVar, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(lVar, rVar, rVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, r rVar, r rVar2, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            rVar = AnonymousClass1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            rVar2 = AnonymousClass2.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            lVar = AnonymousClass3.INSTANCE;
        }
        j.f(textView, "$this$addTextChangedListener");
        j.f(rVar, "beforeTextChanged");
        j.f(rVar2, "onTextChanged");
        j.f(lVar, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(lVar, rVar, rVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static final TextWatcher doAfterTextChanged(TextView textView, final l<? super Editable, s> lVar) {
        j.f(textView, "$this$doAfterTextChanged");
        j.f(lVar, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                lVar.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher doBeforeTextChanged(TextView textView, final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, s> rVar) {
        j.f(textView, "$this$doBeforeTextChanged");
        j.f(rVar, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                rVar.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher doOnTextChanged(TextView textView, final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, s> rVar) {
        j.f(textView, "$this$doOnTextChanged");
        j.f(rVar, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                rVar.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
