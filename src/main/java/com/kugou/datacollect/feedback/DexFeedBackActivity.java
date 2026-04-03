package com.kugou.datacollect.feedback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.http.Headers;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.c.n.a;
import e.c.c.o.o;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DexFeedBackActivity extends Activity {
    public static final String q;
    public static final String r;
    public static final String s;
    public EditText a;
    public EditText b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f254d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ProgressDialog f255f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i f256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f257i = -1;
    public Handler j = new a();
    public boolean k = false;
    public boolean l = false;
    public boolean m = true;
    public l n = new b();
    public HandlerThread o;
    public long p;

    public class a extends Handler {

        /* JADX INFO: renamed from: com.kugou.datacollect.feedback.DexFeedBackActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0023a implements Runnable {
            public RunnableC0023a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DexFeedBackActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                DexFeedBackActivity.this.f255f.dismiss();
                DexFeedBackActivity.this.w("反馈提交失败!");
                return;
            }
            DexFeedBackActivity.this.f255f.dismiss();
            DexFeedBackActivity.this.w("提交成功,感谢您的反馈!");
            DexFeedBackActivity.this.q();
            new Handler().postDelayed(new RunnableC0023a(), 500L);
        }
    }

    public class b implements l {
        public b() {
        }

        @Override // com.kugou.datacollect.feedback.DexFeedBackActivity.l
        public void onBackClick(View view) {
            DexFeedBackActivity.this.u();
        }
    }

    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                DexFeedBackActivity.this.b.setHint("");
            } else {
                DexFeedBackActivity.this.b.setHint(DexFeedBackActivity.this.getResources().getString(e.c.c.i.new_hint_feedback_contact));
            }
        }
    }

    public class d implements TextView.OnEditorActionListener {
        public d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            DexFeedBackActivity.this.l();
            return true;
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DexFeedBackActivity.this.r(1000L)) {
                return;
            }
            DexFeedBackActivity.this.l();
        }
    }

    public class f implements View.OnFocusChangeListener {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                DexFeedBackActivity.this.a.setHint("");
            } else {
                DexFeedBackActivity.this.a.setHint(this.a);
            }
        }
    }

    public class g implements a.InterfaceC0209a {
        public g() {
        }

        @Override // e.c.c.n.a.InterfaceC0209a
        public void onNegativeClick() {
            DexFeedBackActivity.this.q();
            DexFeedBackActivity.this.finish();
        }

        @Override // e.c.c.n.a.InterfaceC0209a
        public void onPositiveClick() {
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ String a;

        public h(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Toast.makeText(DexFeedBackActivity.this.getApplicationContext(), this.a, 0).show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class i extends Handler {
        public i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            super.handleMessage(message);
            Log.e("b65536", "FeedbackHandler.handleMessage()");
            TreeMap treeMap = new TreeMap();
            String string = DexFeedBackActivity.this.a.getText().toString();
            DexFeedBackActivity dexFeedBackActivity = DexFeedBackActivity.this;
            String str = dexFeedBackActivity.m ? "" : "容量不足";
            if (dexFeedBackActivity.m() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("#DexFail#\n" + string);
                sb.append(str);
                sb.append(" 是否由弹窗跳转:");
                sb.append(DexFeedBackActivity.this.k ? "是" : "否");
                sb.append(" 是否lib=0:");
                sb.append(DexFeedBackActivity.this.l ? "是" : "否");
                string = sb.toString();
            } else if (DexFeedBackActivity.this.m() == 1) {
                string = "#Crash#\n" + string;
            }
            long j = Long.parseLong(e.c.c.b.b);
            int iX = e.c.c.o.m.x(DexFeedBackActivity.this);
            treeMap.put("appid", String.valueOf(j));
            treeMap.put("clientver", String.valueOf(iX));
            treeMap.put("clienttime", (System.currentTimeMillis() / 1000) + "");
            treeMap.put("mid", e.c.c.o.m.l(DexFeedBackActivity.this));
            treeMap.put("iscrash", "1");
            treeMap.put("content", string);
            treeMap.put("plat", "0");
            treeMap.put("contact", DexFeedBackActivity.this.b.getText().toString());
            treeMap.put("mode", Build.MODEL);
            treeMap.put(ClientCookie.VERSION_ATTR, String.valueOf(e.c.c.o.m.x(DexFeedBackActivity.this)));
            treeMap.put("imsikey", e.c.c.o.m.k());
            treeMap.put("nettype", e.c.c.o.m.n(DexFeedBackActivity.this));
            treeMap.put(NotificationCompat.CATEGORY_SYSTEM, e.c.c.o.m.t());
            treeMap.put("preversion", String.valueOf(e.c.c.o.m.h(DexFeedBackActivity.this)));
            treeMap.put("user_id", "0");
            treeMap.put("deviceid", e.c.c.o.m.v());
            treeMap.put("ctype", String.valueOf(DexFeedBackActivity.this.f257i + 1));
            treeMap.put("isjailbreak", String.valueOf(0));
            StringBuffer stringBuffer = new StringBuffer();
            treeMap.put("feedbacktype", String.valueOf(2));
            treeMap.put("soversion", stringBuffer.toString());
            String strK = DexFeedBackActivity.this.k("http://tools.mobile.kugou.com/api/v1/suggestion/add", treeMap);
            try {
                DexFeedBackActivity dexFeedBackActivity2 = DexFeedBackActivity.this;
                dexFeedBackActivity2.getClass();
                String strN = DexFeedBackActivity.this.n(new k(dexFeedBackActivity2).a(strK, treeMap));
                Log.e("b65536", "上传反馈成功！result = " + strN);
                if (strN != null && DexFeedBackActivity.this.t()) {
                    j jVarO = DexFeedBackActivity.this.o(strN);
                    Log.e("b65536", "response = " + jVarO);
                    if (jVarO != null && !TextUtils.isEmpty(jVarO.a())) {
                        DexFeedBackActivity.this.x(jVarO.a());
                    }
                }
                DexFeedBackActivity.this.j.removeMessages(1);
                DexFeedBackActivity.this.j.sendEmptyMessage(1);
            } catch (Exception e2) {
                e2.printStackTrace();
                DexFeedBackActivity.this.j.removeMessages(2);
                DexFeedBackActivity.this.j.sendEmptyMessage(2);
            }
        }
    }

    public static class j {
        public String a;

        public String a() {
            return this.a;
        }

        public void b(String str) {
            this.a = str;
        }
    }

    public class k {
        public k(DexFeedBackActivity dexFeedBackActivity) {
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00bc A[Catch: IOException -> 0x00b8, TRY_LEAVE, TryCatch #1 {IOException -> 0x00b8, blocks: (B:41:0x00b4, B:45:0x00bc), top: B:51:0x00b4 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String a(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) throws java.lang.Exception {
            /*
                r7 = this;
                java.lang.StringBuffer r0 = new java.lang.StringBuffer
                r0.<init>()
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
                r2.<init>(r8)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
                java.net.URLConnection r8 = r2.openConnection()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
                java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
                java.lang.String r2 = "Content-Type"
                java.lang.String r3 = "application/json"
                r8.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                java.lang.String r2 = "Charset"
                java.lang.String r3 = "UTF-8"
                r8.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                r2 = 0
                r8.setUseCaches(r2)     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                r2 = 1
                r8.setDoOutput(r2)     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                java.lang.String r2 = "POST"
                r8.setRequestMethod(r2)     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                r2.<init>()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                java.util.Set r3 = r9.keySet()     // Catch: org.json.JSONException -> L4d java.lang.Throwable -> La1 java.io.IOException -> La3
                java.util.Iterator r3 = r3.iterator()     // Catch: org.json.JSONException -> L4d java.lang.Throwable -> La1 java.io.IOException -> La3
            L39:
                boolean r4 = r3.hasNext()     // Catch: org.json.JSONException -> L4d java.lang.Throwable -> La1 java.io.IOException -> La3
                if (r4 == 0) goto L51
                java.lang.Object r4 = r3.next()     // Catch: org.json.JSONException -> L4d java.lang.Throwable -> La1 java.io.IOException -> La3
                java.lang.String r4 = (java.lang.String) r4     // Catch: org.json.JSONException -> L4d java.lang.Throwable -> La1 java.io.IOException -> La3
                java.lang.Object r5 = r9.get(r4)     // Catch: org.json.JSONException -> L4d java.lang.Throwable -> La1 java.io.IOException -> La3
                r2.put(r4, r5)     // Catch: org.json.JSONException -> L4d java.lang.Throwable -> La1 java.io.IOException -> La3
                goto L39
            L4d:
                r9 = move-exception
                r9.printStackTrace()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
            L51:
                java.lang.String r9 = r2.toString()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                java.io.OutputStream r2 = r8.getOutputStream()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                byte[] r9 = r9.getBytes()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                r2.write(r9)     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                java.io.OutputStream r9 = r8.getOutputStream()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                r9.flush()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                java.io.OutputStream r9 = r8.getOutputStream()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                r9.close()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                java.io.InputStream r3 = r8.getInputStream()     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                r2.<init>(r3)     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
                r9.<init>(r2)     // Catch: java.lang.Throwable -> La1 java.io.IOException -> La3
            L7c:
                java.lang.String r1 = r9.readLine()     // Catch: java.lang.Throwable -> L98 java.io.IOException -> L9c
                if (r1 != 0) goto L94
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L98 java.io.IOException -> L9c
                r9.close()     // Catch: java.io.IOException -> L8f
                if (r8 == 0) goto L93
                r8.disconnect()     // Catch: java.io.IOException -> L8f
                goto L93
            L8f:
                r8 = move-exception
                r8.printStackTrace()
            L93:
                return r0
            L94:
                r0.append(r1)     // Catch: java.lang.Throwable -> L98 java.io.IOException -> L9c
                goto L7c
            L98:
                r0 = move-exception
                r1 = r9
                r9 = r0
                goto Lb2
            L9c:
                r0 = move-exception
                r1 = r8
                r8 = r9
                r9 = r0
                goto Lad
            La1:
                r9 = move-exception
                goto Lb2
            La3:
                r9 = move-exception
                r6 = r1
                r1 = r8
                r8 = r6
                goto Lad
            La8:
                r9 = move-exception
                r8 = r1
                goto Lb2
            Lab:
                r9 = move-exception
                r8 = r1
            Lad:
                throw r9     // Catch: java.lang.Throwable -> Lae
            Lae:
                r9 = move-exception
                r6 = r1
                r1 = r8
                r8 = r6
            Lb2:
                if (r1 == 0) goto Lba
                r1.close()     // Catch: java.io.IOException -> Lb8
                goto Lba
            Lb8:
                r8 = move-exception
                goto Lc0
            Lba:
                if (r8 == 0) goto Lc3
                r8.disconnect()     // Catch: java.io.IOException -> Lb8
                goto Lc3
            Lc0:
                r8.printStackTrace()
            Lc3:
                goto Lc5
            Lc4:
                throw r9
            Lc5:
                goto Lc4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kugou.datacollect.feedback.DexFeedBackActivity.k.a(java.lang.String, java.util.Map):java.lang.String");
        }

        public String b(String str, Map<String, String> map, Map<String, File> map2) throws Throwable {
            String string;
            HttpURLConnection httpURLConnection;
            StringBuilder sb;
            DataOutputStream dataOutputStream;
            DataOutputStream dataOutputStream2 = null;
            try {
                string = UUID.randomUUID().toString();
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(BaseConnection.CONNECT_TIMEOUT);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty("Charsert", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", BaseConnection.HTTP_REQ_VALUE_CONTENT_TYPE_FORM + ";boundary=" + string);
                sb = new StringBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append(BaseConnection.HTTP_REQ_ENTITY_PREFIX);
                    sb.append(string);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Content-Type: text/plain; charset=");
                    sb2.append("UTF-8");
                    sb2.append("\r\n");
                    sb.append(sb2.toString());
                    sb.append("Content-Transfer-Encoding: 8bit\r\n");
                    sb.append("\r\n");
                    sb.append(entry.getValue());
                    sb.append("\r\n");
                }
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.write(sb.toString().getBytes());
                if (map2 != null) {
                    for (Map.Entry<String, File> entry2 : map2.entrySet()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(BaseConnection.HTTP_REQ_ENTITY_PREFIX);
                        sb3.append(string);
                        sb3.append("\r\n");
                        sb3.append("Content-Disposition: form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + entry2.getValue().getName() + "\"\r\n");
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Content-Type: application/octet-stream; charset=");
                        sb4.append("UTF-8");
                        sb4.append("\r\n");
                        sb3.append(sb4.toString());
                        sb3.append("\r\n");
                        dataOutputStream.write(sb3.toString().getBytes());
                        FileInputStream fileInputStream = new FileInputStream(entry2.getValue());
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i2 = fileInputStream.read(bArr);
                                if (i2 != -1) {
                                    dataOutputStream.write(bArr, 0, i2);
                                }
                            }
                            e.c.c.o.e.a(fileInputStream);
                            dataOutputStream.write("\r\n".getBytes());
                        } catch (Throwable th2) {
                            e.c.c.o.e.a(fileInputStream);
                            throw th2;
                        }
                    }
                }
                dataOutputStream.write((BaseConnection.HTTP_REQ_ENTITY_PREFIX + string + BaseConnection.HTTP_REQ_ENTITY_PREFIX + "\r\n").getBytes());
                dataOutputStream.flush();
                int responseCode = httpURLConnection.getResponseCode();
                InputStream inputStream = httpURLConnection.getInputStream();
                if (responseCode == 200) {
                    StringBuilder sb5 = new StringBuilder();
                    while (true) {
                        int i3 = inputStream.read();
                        if (i3 == -1) {
                            break;
                        }
                        sb5.append((char) i3);
                    }
                }
                httpURLConnection.disconnect();
                String string2 = inputStream.toString();
                e.c.c.o.e.a(dataOutputStream);
                return string2;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream2 = dataOutputStream;
                e.c.c.o.e.a(dataOutputStream2);
                throw th;
            }
        }
    }

    public interface l {
        void onBackClick(View view);
    }

    public static class m {
        public m(DexFeedBackActivity dexFeedBackActivity) {
            b();
        }

        public void a() {
        }

        public void b() {
            a();
        }

        public void c(String str) {
        }

        public void d(l lVar) {
        }
    }

    static {
        String string = Environment.getExternalStorageDirectory().toString();
        q = string;
        r = string + "/kugou/.feedback/.attachment/";
        s = string + "/kugou/.feedback/attachment.zip";
    }

    public final String k(String str, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            long j2 = Long.parseLong(e.c.c.b.b);
            int iX = e.c.c.o.m.x(this);
            sb.append(str);
            sb.append("?");
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            sb.append("appid");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(j2);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            sb.append("clienttime");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(System.currentTimeMillis() / 1000);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            sb.append("clientver");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(iX);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            sb.append("mid");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(e.c.c.o.m.l(this));
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            String str3 = "OIlwieks28dk2k092lksi2UIkp" + new String(sb.toString()).replace(str, "").replace(BaseConnection.HTTP_REQ_ENTITY_JOIN, "").replace("?", "") + jSONObject.toString() + "OIlwieks28dk2k092lksi2UIkp";
            if (e.c.c.o.g.d()) {
                e.c.c.o.g.a("jamylog", str3);
            }
            String lowerCase = new e.c.c.o.i().f(str3, "UTF-8").toLowerCase(Locale.US);
            sb.append("signature");
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(lowerCase);
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final void l() {
        if (TextUtils.isEmpty(this.a.getText().toString().trim())) {
            w("请输入您需要反馈的信息");
            return;
        }
        if (TextUtils.isEmpty(this.b.getText().toString().trim())) {
            this.b.requestFocus();
            showSoftInput(this.b);
            w("联系方式为空");
        } else {
            this.f255f.show();
            this.f256h.removeMessages(0);
            this.f256h.sendEmptyMessage(0);
        }
    }

    public int m() {
        return 0;
    }

    public final String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!(str.contains("{") && str.contains("}"))) {
            return "";
        }
        int iIndexOf = str.indexOf("{");
        int iLastIndexOf = str.lastIndexOf("}");
        return (iIndexOf < 0 || iLastIndexOf < 0 || iIndexOf >= iLastIndexOf) ? "" : str.substring(iIndexOf, iLastIndexOf + 1);
    }

    public final j o(String str) {
        j jVar = new j();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("0".equals(jSONObject.getString(NotificationCompat.CATEGORY_STATUS))) {
                return null;
            }
            jVar.b(jSONObject.getString("fid"));
            return jVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.e("", "DexFeedBackActivity-oncreate start");
        m mVar = new m(this);
        mVar.c("意见反馈");
        mVar.d(this.n);
        this.k = getIntent().getBooleanExtra("ISFROMCRASHDIALOG", false);
        this.l = getIntent().getBooleanExtra("ISINSTALLFAIL", false);
        this.b.setOnFocusChangeListener(new c());
        this.b.setOnEditorActionListener(new d());
        this.f254d.setBackgroundDrawable(getResources().getDrawable(e.c.c.h.skin_common_widget_solid_corner_gradient));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f254d.getLayoutParams();
        layoutParams.height = e.c.c.o.m.b(36.0f);
        layoutParams.leftMargin = e.c.c.o.m.b(40.0f);
        layoutParams.rightMargin = e.c.c.o.m.b(40.0f);
        this.f254d.setLayoutParams(layoutParams);
        this.f254d.setOnClickListener(new e());
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f255f = progressDialog;
        progressDialog.setMessage("加载中，请稍候");
        this.f256h = new i(p());
        String str = m() == 0 ? "应用初始化失败，无法运行，请提交反馈建议给技术修复。" : "运行中出了点问题...反馈一下啰";
        this.a.setHint(str);
        this.a.setOnFocusChangeListener(new f(str));
        e.c.c.o.g.b("", "DexFeedBackActivity-oncreate end");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.j.removeCallbacksAndMessages(null);
        i iVar = this.f256h;
        if (iVar != null) {
            iVar.removeCallbacksAndMessages(null);
        }
        s();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 82) {
            return true;
        }
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        u();
        return true;
    }

    public final Looper p() {
        if (this.o == null) {
            HandlerThread handlerThread = new HandlerThread(DexFeedBackActivity.class.getSimpleName(), 10);
            this.o = handlerThread;
            handlerThread.start();
        }
        return this.o.getLooper();
    }

    public void q() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (getCurrentFocus() == null || inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }

    public final boolean r(long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.p < j2) {
            return true;
        }
        this.p = jCurrentTimeMillis;
        return false;
    }

    public void s() {
        Log.i("CrashLog", "killSelfProcess true");
        Process.killProcess(Process.myPid());
    }

    public void showSoftInput(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null || !inputMethodManager.isActive(view)) {
            return;
        }
        inputMethodManager.showSoftInput(view, 0);
    }

    public boolean t() {
        return false;
    }

    public void u() {
        if (!"".equals(this.a.getText().toString())) {
            v();
        } else {
            finish();
            q();
        }
    }

    public final void v() {
        e.c.c.n.a aVar = new e.c.c.n.a(this);
        aVar.f(false);
        aVar.c("放弃本次意见反馈？");
        aVar.e("继续编写");
        aVar.d("放弃");
        aVar.b(true);
        aVar.a(new g());
        aVar.show();
    }

    public void w(String str) {
        runOnUiThread(new h(str));
    }

    public void x(String str) throws Throwable {
        try {
            Log.e("b65536", "上传反馈附件");
            String str2 = r;
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str3 = s;
            File file2 = new File(str3);
            if (file2.exists()) {
                e.c.c.o.m.a(file2.getAbsolutePath());
            }
            o.d(str2, str3);
            File file3 = new File(str3);
            if (!file3.exists()) {
                Log.i("b65536", "附件文件不存在，上传用户反馈附件失败");
                return;
            }
            if (e.c.c.o.m.z(this) && !"wifi".equals(e.c.c.o.m.n(this)) && file3.length() > 2097152) {
                Log.i("b65536", "在运营商网络下，附件文件超过2M，不会自动上传");
                return;
            }
            if (file3.length() > 2097152) {
                Log.i("b65536", "附件>2M，不能上传");
                return;
            }
            Log.e("b65536", "附件zip准备完成，开始上传");
            HashMap map = new HashMap();
            map.put("fid", str);
            map.put("key", new e.c.c.o.i().f(str + "mobileservice", "UTF-8"));
            HashMap map2 = new HashMap();
            map2.put("attachment", file3);
            try {
                new k(this).b("http://tools.mobile.kugou.com/api/v1/suggestion/add?cmd=517", map, map2);
                Log.e("b65536", "附件zip上传成功");
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("b65536", "附件zip上传失败");
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            Log.e("b65536", "附件zip上传失败");
        }
    }
}
