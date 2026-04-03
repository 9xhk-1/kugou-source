package com.xtc.payapi.contact;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xtc.payapi.a.a;
import com.xtc.payapi.constants.PayConstant;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class SendPayMesToXTC {

    public static class Request extends BaseRequest {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "pay_sdkmesToXTC.Request";
        public String appId;
        public String checkCode;
        public String describeTitle;
        public String ext;
        public boolean isUseSdkOpenid;

        @Deprecated
        public String openId;
        public String orderId;
        public int payType;
        public String productInfos;
        public byte[] thumbData;
        public BigDecimal totalPrice;

        @Override // com.xtc.payapi.contact.BaseRequest
        public boolean checkArgs() {
            String str;
            if (TextUtils.isEmpty(this.checkCode)) {
                str = "checkArgs fail, checkCode is null";
            } else {
                String str2 = this.appId;
                if (str2 == null || str2.length() == 0 || this.appId.length() > 1024) {
                    str = "checkArgs fail, appId is invalid";
                } else {
                    if (this.totalPrice.compareTo(BigDecimal.ZERO) != -1) {
                        return true;
                    }
                    str = "checkArgs fail, totalPrice is invalid";
                }
            }
            Log.e(TAG, str);
            return false;
        }

        @Override // com.xtc.payapi.contact.BaseRequest
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.appId = a.b(bundle, PayConstant.PayMesConstant.BUNDLE_MESSAGE_APP_ID);
            this.checkCode = a.b(bundle, PayConstant.PayMesConstant.BUNDLE_MESSAGE_CHECK_CODE);
            this.totalPrice = new BigDecimal(a.b(bundle, PayConstant.PayMesConstant.BUNDLE_MESSAGE_PRICE));
            this.describeTitle = a.b(bundle, PayConstant.PayMesConstant.BUNDLE_MESSAGE_TITLE);
            this.openId = a.b(bundle, PayConstant.PayMesConstant.BUNDLE_MESSAGE_OPENID);
            this.orderId = a.b(bundle, PayConstant.PayMesConstant.BUNDLE_MESSAGE_ORDER_ID);
            this.productInfos = a.b(bundle, PayConstant.PayMesConstant.BUNDLE_MESSAGE_PRODUCT_INFO);
            this.thumbData = a.d(bundle, PayConstant.PayMesConstant.BUNDLE_MESSAGE_THUMB);
            this.isUseSdkOpenid = a.e(bundle, PayConstant.PayMesConstant.BUNDLE_MESSAGE_ISUSESDKOPENID);
        }

        @Override // com.xtc.payapi.contact.BaseRequest
        public int getType() {
            return 2;
        }

        public final void setThumbImage(Bitmap bitmap) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.thumbData = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                Log.e(TAG, "bitmapToByteArray exception:" + e2.getMessage());
            }
        }

        @Override // com.xtc.payapi.contact.BaseRequest
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(PayConstant.PayMesConstant.BUNDLE_MESSAGE_APP_ID, this.appId);
            bundle.putString(PayConstant.PayMesConstant.BUNDLE_MESSAGE_CHECK_CODE, this.checkCode);
            bundle.putString(PayConstant.PayMesConstant.BUNDLE_MESSAGE_PRICE, this.totalPrice.toString());
            bundle.putString(PayConstant.PayMesConstant.BUNDLE_MESSAGE_TITLE, this.describeTitle);
            bundle.putString(PayConstant.PayMesConstant.BUNDLE_MESSAGE_OPENID, this.openId);
            bundle.putString(PayConstant.PayMesConstant.BUNDLE_MESSAGE_ORDER_ID, this.orderId);
            bundle.putString(PayConstant.PayMesConstant.BUNDLE_MESSAGE_PRODUCT_INFO, this.productInfos);
            bundle.putByteArray(PayConstant.PayMesConstant.BUNDLE_MESSAGE_THUMB, this.thumbData);
            bundle.putBoolean(PayConstant.PayMesConstant.BUNDLE_MESSAGE_ISUSESDKOPENID, this.isUseSdkOpenid);
            bundle.putInt(PayConstant.PayMesConstant.BUNDLE_MESSAGE_PAY_TYPE, this.payType);
        }

        public String toString() {
            return "Request{appId='" + this.appId + "', checkCode='" + this.checkCode + "', orderId='" + this.orderId + "', openId='" + this.openId + "', isUseSdkOpenid=" + this.isUseSdkOpenid + ", totalPrice=" + this.totalPrice + ", describeTitle='" + this.describeTitle + "', productInfos='" + this.productInfos + "', ext='" + this.ext + "', payType=" + this.payType + '}';
        }
    }

    public static class Response extends BaseResponse {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "pay_sdkResponse";
        public String code;
        public String openid;

        public Response() {
        }

        public Response(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.xtc.payapi.contact.BaseResponse
        public boolean checkArgs() {
            return true;
        }

        @Override // com.xtc.payapi.contact.BaseResponse
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.code = a.b(bundle, PayConstant.ResponseConstant.PAY_RESPONSE_CODE);
            this.openid = a.b(bundle, PayConstant.ResponseConstant.PAY_RESPONSE_OPENID);
        }

        @Override // com.xtc.payapi.contact.BaseResponse
        public int getType() {
            return 2;
        }

        @Override // com.xtc.payapi.contact.BaseResponse
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(PayConstant.ResponseConstant.PAY_RESPONSE_CODE, this.code);
            bundle.putString(PayConstant.ResponseConstant.PAY_RESPONSE_OPENID, this.openid);
        }

        public String toString() {
            return "Response{code='" + this.code + "', openid='" + this.openid + "', errorCode='" + this.errorCode + "', errorDesc='" + this.errorDesc + "', transaction='" + this.transaction + "'}";
        }
    }
}
