package e.c.a.g.a.g.o;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.s.l1;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public final Gson a = new Gson();
    public ArrayDeque<String> b;

    public class a extends TypeToken<ArrayDeque<String>> {
        public a(d dVar) {
        }
    }

    public TextView a(Context context, String str) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, l1.d(context, 40.0f)));
        textView.setPadding(l1.d(context, 4.0f), 0, 0, 0);
        textView.setTextSize(1, 15.5f);
        textView.setTextColor(ContextCompat.getColor(context, R.color.white_80));
        textView.setGravity(16);
        textView.setText(str);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        return textView;
    }

    public void b() {
        e.c.a.g.a.f.m.c.a.i("key_history_list", "");
        ArrayDeque<String> arrayDeque = this.b;
        if (arrayDeque != null) {
            arrayDeque.clear();
        }
    }

    public Deque<String> c() {
        ArrayDeque arrayDeque;
        if (this.b == null) {
            this.b = new ArrayDeque<>(5);
            String strD = e.c.a.g.a.f.m.c.a.d("key_history_list", "");
            if (!TextUtils.isEmpty(strD) && (arrayDeque = (ArrayDeque) this.a.fromJson(strD, new a(this).getType())) != null) {
                this.b.addAll(arrayDeque);
            }
        }
        return this.b;
    }

    public boolean d(@NonNull String str) {
        Deque<String> dequeC = c();
        if (!dequeC.isEmpty() && str.equals(dequeC.getFirst())) {
            return false;
        }
        dequeC.remove(str);
        dequeC.addFirst(str);
        e.c.a.g.a.f.m.c.a.i("key_history_list", this.a.toJson(this.b));
        return true;
    }
}
