package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    @RequiresApi(16)
    public static final class Api16Impl {
        private Api16Impl() {
        }

        public static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i2) {
            if ((i2 & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence charSequenceCoerceToText = item.coerceToText(context);
            return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
        }
    }

    public static final class ApiImpl {
        private ApiImpl() {
        }

        public static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i2) {
            CharSequence charSequenceCoerceToText = item.coerceToText(context);
            return ((i2 & 1) == 0 || !(charSequenceCoerceToText instanceof Spanned)) ? charSequenceCoerceToText : charSequenceCoerceToText.toString();
        }
    }

    @NonNull
    private static CharSequence coerceToText(@NonNull ClipData clipData, @NonNull Context context, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
            CharSequence charSequenceCoerceToText = coerceToText(context, clipData.getItemAt(i3), i2);
            if (charSequenceCoerceToText != null) {
                spannableStringBuilder.append(charSequenceCoerceToText);
            }
        }
        return spannableStringBuilder;
    }

    private static void onReceiveForDragAndDrop(@NonNull TextView textView, @NonNull ContentInfoCompat contentInfoCompat) {
        replaceSelection((Editable) textView.getText(), coerceToText(contentInfoCompat.getClip(), textView.getContext(), contentInfoCompat.getFlags()));
    }

    private static void replaceSelection(@NonNull Editable editable, @NonNull CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, charSequence);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(LOG_TAG, 3)) {
            Log.d(LOG_TAG, "onReceive: " + contentInfoCompat);
        }
        int source = contentInfoCompat.getSource();
        if (source == 2) {
            return contentInfoCompat;
        }
        if (source == 3) {
            onReceiveForDragAndDrop((TextView) view, contentInfoCompat);
            return null;
        }
        ClipData clip = contentInfoCompat.getClip();
        int flags = contentInfoCompat.getFlags();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i2 = 0; i2 < clip.getItemCount(); i2++) {
            CharSequence charSequenceCoerceToText = coerceToText(context, clip.getItemAt(i2), flags);
            if (charSequenceCoerceToText != null) {
                if (z) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceCoerceToText);
                } else {
                    replaceSelection(editable, charSequenceCoerceToText);
                    z = true;
                }
            }
        }
        return null;
    }

    private static CharSequence coerceToText(@NonNull Context context, @NonNull ClipData.Item item, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.coerce(context, item, i2);
        }
        return ApiImpl.coerce(context, item, i2);
    }
}
