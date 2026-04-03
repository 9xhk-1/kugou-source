package com.kugou.framework.bilib.statistics.cscc.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.bilib.statistics.cscc.CryptManager;
import com.kugou.framework.bilib.statistics.cscc.DataWrapper;
import com.kugou.framework.libcommon.NetworkUtils;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CsccEntity implements Parcelable {
    public static final Parcelable.Creator<CsccEntity> CREATOR = new Parcelable.Creator<CsccEntity>() { // from class: com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CsccEntity createFromParcel(Parcel parcel) {
            CsccEntity csccEntity = new CsccEntity();
            csccEntity.mDataType = parcel.readInt();
            csccEntity.mConfigId = parcel.readInt();
            csccEntity.mRawMillies = parcel.readLong();
            csccEntity.mNetworkType = parcel.readInt();
            csccEntity.mUserId = parcel.readLong();
            csccEntity.mVipType = parcel.readInt();
            csccEntity.mProxyType = parcel.readInt();
            csccEntity.mDomainType = parcel.readInt();
            csccEntity.mHttpMethod = parcel.readString();
            csccEntity.mQueryString = parcel.readString();
            int i2 = parcel.readInt();
            if (i2 >= 0) {
                csccEntity.mPostBody = new byte[i2];
                parcel.readByteArray(csccEntity.mPostBody);
            }
            int i3 = parcel.readInt();
            if (i3 >= 0) {
                csccEntity.mData = new byte[i3];
                parcel.readByteArray(csccEntity.mData);
            }
            csccEntity.mIgnoreNetmode = parcel.readInt() == 1;
            csccEntity.mCanSend = parcel.readInt() == 1;
            csccEntity.mParams = (Map) parcel.readBundle(LibConfig.getContext().getClassLoader()).getSerializable("param");
            return csccEntity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CsccEntity[] newArray(int i2) {
            return new CsccEntity[i2];
        }
    };
    public static final int DATA_TYPE_HTTP_ENCODE = 4;
    public static final int DATA_TYPE_JSON = 3;
    public static final int DATA_TYPE_NO_ENCODE = 0;
    public static final int DATA_TYPE_STRING_ARRAY = 1;
    public static final int DATA_TYPE_URL_ENCODE = 2;
    public static final int DOMAIN_APM_CHANNEL = 1;
    public static final int DOMAIN_DCOM_CHANNEL = 0;
    public static final int DOMAIN_ERM_CHANNEL = 2;
    public static final int DOMAIN_FX_BI_CHANNEL = 3;
    public static final int NETWORK_TYPE_2G = 2;
    public static final int NETWORK_TYPE_3G = 3;
    public static final int NETWORK_TYPE_4G = 4;
    public static final int NETWORK_TYPE_5G = 5;
    public static final int NETWORK_TYPE_OTHERS = 0;
    public static final int NETWORK_TYPE_WIFI = 1;
    public static final int PROXY_TYPE_KING_CARD = 4;
    public static final int PROXY_TYPE_MOBILE = 2;
    public static final int PROXY_TYPE_NONE = 0;
    public static final int PROXY_TYPE_TELECOM = 3;
    public static final int PROXY_TYPE_UNICOM = 1;
    private ICsccCallback mCallback;
    private boolean mCanSend;
    private int mConfigId;
    private byte[] mData;
    public int mDataType;
    private int mDomainType;
    private String mHttpMethod;
    private boolean mIgnoreNetmode;
    private int mNetworkType;
    private Map<String, Object> mParams;
    private byte[] mPostBody;
    private int mProxyType;
    private String mQueryString;
    private long mRawMillies;
    private long mUserId;
    private int mVipType;

    private String buildHeader(int i2) {
        return i2 + DataWrapper.MARK_SEPERATE + this.mConfigId + DataWrapper.MARK_SEPERATE + this.mDataType + DataWrapper.MARK_SEPERATE + CryptManager.getInstance().getAdjustedTime(this.mRawMillies) + DataWrapper.MARK_SEPERATE + this.mNetworkType + DataWrapper.MARK_SEPERATE + this.mUserId + DataWrapper.MARK_SEPERATE + this.mVipType + DataWrapper.MARK_SEPERATE + this.mProxyType + "\r\n";
    }

    public static String getParamJson(CsccEntity csccEntity) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : csccEntity.getParams().entrySet()) {
            String key = entry.getKey();
            if (key instanceof String) {
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    try {
                        jSONObject.put(entry.getKey(), value);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return jSONObject.toString();
    }

    public static String makeQueryString(Map<String, Object> map) {
        if (map == null || map.size() < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(map.get(str));
            sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private byte[] toDataLineHttpEncode() {
        byte[] bytes;
        StringBuilder sb = new StringBuilder();
        String str = this.mHttpMethod;
        if (str != null) {
            sb.append(str);
        }
        sb.append(DataWrapper.MARK_SEPERATE);
        String str2 = this.mQueryString;
        if (str2 != null) {
            sb.append(str2);
        }
        sb.append(DataWrapper.MARK_SEPERATE);
        byte[] bytes2 = null;
        try {
            bytes = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bytes = null;
        }
        byte[] bArr = this.mPostBody;
        if (bArr != null) {
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            byte[] bArr3 = this.mPostBody;
            System.arraycopy(bArr3, 0, bArr2, bytes.length, bArr3.length);
            bytes = bArr2;
        }
        String strBuildHeader = buildHeader(bytes.length);
        try {
            bytes2 = strBuildHeader.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        byte[] bArr4 = new byte[bytes.length + bytes2.length];
        System.arraycopy(bytes2, 0, bArr4, 0, bytes2.length);
        System.arraycopy(bytes, 0, bArr4, strBuildHeader.length(), bytes.length);
        return bArr4;
    }

    private byte[] toDataLineJson() {
        JSONObject jSONObject = new JSONObject();
        Map<String, Object> map = this.mParams;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key instanceof String) {
                    Object value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null) {
                        try {
                            jSONObject.put(entry.getKey(), value);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
        byte[] bytes = new byte[0];
        try {
            bytes = jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        String strBuildHeader = buildHeader(bytes.length);
        byte[] bytes2 = new byte[0];
        try {
            bytes2 = strBuildHeader.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
        byte[] bArr = new byte[bytes.length + bytes2.length];
        System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
        System.arraycopy(bytes, 0, bArr, strBuildHeader.length(), bytes.length);
        return bArr;
    }

    private byte[] toDataLineNoEncodeData() {
        byte[] bArr = this.mData;
        if (bArr == null) {
            return null;
        }
        String strBuildHeader = buildHeader(bArr.length);
        byte[] bytes = new byte[0];
        try {
            bytes = strBuildHeader.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        byte[] bArr2 = new byte[bArr.length + bytes.length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, strBuildHeader.length(), bArr.length);
        return bArr2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ICsccCallback getCallback() {
        return this.mCallback;
    }

    public boolean getCanSend() {
        return this.mCanSend;
    }

    public int getConfigId() {
        return this.mConfigId;
    }

    public int getDomainType() {
        return this.mDomainType;
    }

    public boolean getIgnoreNetmode() {
        return this.mIgnoreNetmode;
    }

    public Map<String, Object> getParams() {
        return this.mParams;
    }

    public void notifyFailed(String str) {
        ICsccCallback iCsccCallback = this.mCallback;
        if (iCsccCallback != null) {
            try {
                iCsccCallback.onFailed(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setCallBack(ICsccCallback iCsccCallback) {
        this.mCallback = iCsccCallback;
    }

    public byte[] toDataLine() {
        int i2 = this.mDataType;
        if (i2 == 0) {
            return toDataLineNoEncodeData();
        }
        if (i2 == 3) {
            return toDataLineJson();
        }
        if (i2 != 4) {
            return null;
        }
        return toDataLineHttpEncode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mDataType);
        parcel.writeInt(this.mConfigId);
        parcel.writeLong(this.mRawMillies);
        parcel.writeInt(this.mNetworkType);
        parcel.writeLong(this.mUserId);
        parcel.writeInt(this.mVipType);
        parcel.writeInt(this.mProxyType);
        parcel.writeInt(this.mDomainType);
        parcel.writeString(this.mHttpMethod);
        parcel.writeString(this.mQueryString);
        byte[] bArr = this.mPostBody;
        if (bArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(this.mPostBody);
        }
        byte[] bArr2 = this.mData;
        if (bArr2 == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(bArr2.length);
            parcel.writeByteArray(this.mData);
        }
        parcel.writeInt(this.mIgnoreNetmode ? 1 : 0);
        parcel.writeInt(this.mCanSend ? 1 : 0);
        Bundle bundle = new Bundle();
        Map<String, Object> map = this.mParams;
        if (map instanceof Serializable) {
            bundle.putSerializable("param", (Serializable) map);
        }
        parcel.writeBundle(bundle);
    }

    public CsccEntity(int i2, ICsccCallback iCsccCallback, String str, String str2, byte[] bArr, boolean z, boolean z2) {
        this(iCsccCallback);
        this.mDataType = 4;
        this.mConfigId = i2;
        this.mHttpMethod = str;
        this.mQueryString = str2;
        this.mPostBody = bArr;
        this.mIgnoreNetmode = z;
        this.mCanSend = z2;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;:Ljava/io/Serializable;>(ILcom/kugou/framework/bilib/statistics/cscc/entity/ICsccCallback;TT;Z)V */
    public CsccEntity(int i2, ICsccCallback iCsccCallback, Map map, boolean z) {
        this(i2, iCsccCallback, map, z, 0);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;:Ljava/io/Serializable;>(ILcom/kugou/framework/bilib/statistics/cscc/entity/ICsccCallback;TT;ZI)V */
    public CsccEntity(int i2, ICsccCallback iCsccCallback, Map map, boolean z, int i3) {
        this(iCsccCallback);
        this.mDataType = 3;
        this.mConfigId = i2;
        this.mParams = map;
        this.mIgnoreNetmode = z;
        this.mDomainType = i3;
    }

    public CsccEntity(int i2, ICsccCallback iCsccCallback, byte[] bArr, boolean z, int i3) {
        this(iCsccCallback);
        this.mDataType = 0;
        this.mConfigId = i2;
        this.mData = bArr;
        this.mIgnoreNetmode = z;
        this.mDomainType = i3;
    }

    private CsccEntity(ICsccCallback iCsccCallback) {
        this.mDataType = 4;
        this.mDomainType = 1;
        this.mCallback = iCsccCallback;
        this.mCanSend = true;
        this.mRawMillies = System.currentTimeMillis();
        String networkType = NetworkUtils.getNetworkType(LibConfig.getContext());
        if ("wifi".equals(networkType)) {
            this.mNetworkType = 1;
        } else if ("4G".equals(networkType)) {
            this.mNetworkType = 4;
        } else if ("3G".equals(networkType)) {
            this.mNetworkType = 3;
        } else if ("2G".equals(networkType)) {
            this.mNetworkType = 2;
        } else {
            this.mNetworkType = 0;
        }
        this.mUserId = Long.valueOf(LibConfig.getInstance().getUserID()).longValue();
        this.mVipType = LibConfig.getInstance().getViptype();
        this.mProxyType = LibConfig.getInstance().getMoonType();
    }

    private CsccEntity() {
        this.mDataType = 4;
        this.mDomainType = 1;
    }
}
