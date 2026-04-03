package com.kugou.common.network;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.ackutils.StringResponsePackage;
import com.kugou.common.network.networkutils.SecureSignUtil;
import e.c.a.g.a.f.g.a;
import e.c.a.g.a.f.k.k.e;
import e.c.a.g.a.r.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p;
import e.c.c.o.f;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkUploadProtocol {
    public static final int ERROR_DEFAULT = 0;
    public static final int ERROR_FEEDBACK = 6;
    public static final int TYPE_FORCE_UPLOAD_FILE = 3;
    public static final int TYPE_NETWORK_DETECT = 1;
    public static final int TYPE_RETRY_STATICS = 2;
    private static final String apikey = "and01";
    private static final String secretkey = "gP>Mr38JN4&#";
    private int errorType;
    private e mClient;
    private boolean mStopped;
    private int mUploadType;

    public static class NetworkUploadEntity {
        public int errcode;
        public int status;

        public boolean isSuccess() {
            return this.status == 1;
        }
    }

    public static class NetworkUploadResponsePackage extends StringResponsePackage<NetworkUploadEntity> {
        private NetworkUploadResponsePackage() {
        }

        @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
        public void getResponseData(NetworkUploadEntity networkUploadEntity) {
            if (networkUploadEntity == null || TextUtils.isEmpty(this.mJsonString)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.mJsonString);
                networkUploadEntity.status = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                networkUploadEntity.errcode = jSONObject.getInt("errcode");
            } catch (JSONException e2) {
                g0.k(e2);
            }
        }
    }

    public NetworkUploadProtocol(int i2) {
        this(0, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] readBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a(str);
        if (!aVar.exists() || aVar.isDirectory()) {
            return null;
        }
        try {
            return p.m(new FileInputStream(aVar));
        } catch (FileNotFoundException e2) {
            g0.k(e2);
            return null;
        } catch (Exception e3) {
            g0.k(e3);
            return null;
        }
    }

    public NetworkUploadEntity upload(String str) {
        String strJ = h1.j(l1.l(f.a()));
        String strValueOf = String.valueOf(b.o());
        int iG = l1.G();
        Hashtable hashtable = new Hashtable();
        hashtable.put("imei", strJ);
        hashtable.put("userid", strValueOf);
        hashtable.put("platform_id", "1");
        hashtable.put("error", Integer.valueOf(this.errorType));
        hashtable.put("ver", Integer.valueOf(iG));
        NetworkUploadRequestPackage networkUploadRequestPackage = new NetworkUploadRequestPackage(str);
        NetworkUploadResponsePackage networkUploadResponsePackage = new NetworkUploadResponsePackage();
        Hashtable<String, Object> hashtableSign = SecureSignUtil.sign(hashtable, apikey, secretkey, System.currentTimeMillis() / 1000, null, false);
        hashtableSign.put("type", Integer.valueOf(this.mUploadType));
        networkUploadRequestPackage.setParams(hashtableSign);
        NetworkUploadEntity networkUploadEntity = new NetworkUploadEntity();
        if (!this.mStopped) {
            e eVarA = e.a();
            this.mClient = eVarA;
            try {
                eVarA.request(networkUploadRequestPackage, networkUploadResponsePackage);
                networkUploadResponsePackage.getResponseData(networkUploadEntity);
            } catch (Exception e2) {
                if (g0.a) {
                    g0.c("BLUE", "got exception " + e2);
                }
                g0.k(e2);
            }
        }
        return networkUploadEntity;
    }

    public static class NetworkUploadRequestPackage extends e.c.a.g.a.f.k.a {
        private String mFilePath;
        private byte[] mPostBytes;

        public NetworkUploadRequestPackage(byte[] bArr) {
            this.mPostBytes = bArr;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            byte[] bytes;
            byte[] bArr = this.mPostBytes;
            if (bArr != null) {
                return new ByteArrayEntity(bArr);
            }
            if (TextUtils.isEmpty(this.mFilePath) || (bytes = NetworkUploadProtocol.readBytes(this.mFilePath)) == null) {
                return null;
            }
            return new ByteArrayEntity(bytes);
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "NetworkUploadProtocol";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // e.c.a.g.a.f.k.a
        public ConfigKey getUrlConfigKey() {
            return e.c.a.g.a.f.e.b.x;
        }

        public NetworkUploadRequestPackage(String str) {
            this.mFilePath = str;
        }
    }

    public NetworkUploadProtocol(int i2, int i3) {
        this.mStopped = false;
        this.mUploadType = i3;
        this.errorType = i2;
    }
}
