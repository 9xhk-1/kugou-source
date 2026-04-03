package com.xtc.shareapi.share.communication;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.SendMessageToXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.Scene;
import com.xtc.shareapi.share.sharescene.Chat;
import com.xtc.shareapi.share.sharescene.Moment;

/* JADX INFO: loaded from: classes2.dex */
public class ShowMessageFromXTC {

    public static class Request extends BaseRequest {
        private String extInfo;
        private int resultCode;
        private Scene scene;

        @Override // com.xtc.shareapi.share.communication.BaseRequest, com.xtc.shareapi.share.interfaces.IBundleSerialize
        public BaseResponse checkArgs() {
            SendMessageToXTC.Response response = new SendMessageToXTC.Response();
            response.setCode(1);
            return response;
        }

        public String getExtInfo() {
            return this.extInfo;
        }

        public int getResultCode() {
            return this.resultCode;
        }

        public Scene getScene() {
            return this.scene;
        }

        @Override // com.xtc.shareapi.share.communication.BaseRequest
        public int getType() {
            return 2;
        }

        public void setExtInfo(String str) {
            this.extInfo = str;
        }

        public void setResultCode(int i2) {
            this.resultCode = i2;
        }

        public void setScene(Scene scene) {
            this.scene = scene;
        }

        @Override // com.xtc.shareapi.share.communication.BaseRequest, com.xtc.shareapi.share.interfaces.IBundleSerialize
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            Scene scene = this.scene;
            if (scene != null) {
                scene.toBundle(bundle);
            }
            bundle.putString("_xtc_api_share_type", this.extInfo);
            bundle.putInt(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_CODE, this.resultCode);
        }

        @Override // com.xtc.shareapi.share.communication.BaseRequest, com.xtc.shareapi.share.interfaces.IBundleSerialize
        public Request fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            int i2 = bundle.getInt(OpenApiConstant.SceneConstant.BUNDLE_SCENE_SHARE_TYPE);
            Log.d(OpenApiConstant.TAG, "come to fromBundle" + i2);
            if (i2 == 1) {
                Chat chat = (Chat) new Chat().fromBundle(bundle);
                Log.d(OpenApiConstant.TAG, "come to fromBundle" + chat.toString() + ",var1 = " + bundle.toString());
                setScene(chat);
            } else if (i2 == 2) {
                setScene((Moment) new Moment().fromBundle(bundle));
            }
            setExtInfo(bundle.getString("_xtc_api_share_type"));
            setResultCode(bundle.getInt(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_CODE));
            return this;
        }
    }

    public static class Response extends BaseResponse {
        @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
        public BaseResponse checkArgs() {
            SendMessageToXTC.Response response = new SendMessageToXTC.Response();
            response.setCode(1);
            return response;
        }

        @Override // com.xtc.shareapi.share.communication.BaseResponse
        public int getType() {
            return 2;
        }

        @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
        public void toBundle(Bundle bundle) {
            bundle.putInt(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_CODE, getCode());
            bundle.putString(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_DESC, getErrorDesc());
            bundle.putString(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_TRANSACTION, getTransaction());
            bundle.putString(OpenApiConstant.ResponseConstant.BUNDLE_CONVERSATION_ID, getConversationId());
            bundle.putString(OpenApiConstant.ResponseConstant.BUNDLE_CONVERSATION_TITLE, getConversationTitle());
        }

        @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
        public Response fromBundle(Bundle bundle) {
            setCode(bundle.getInt(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_CODE));
            setErrorDesc(bundle.getString(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_DESC));
            setTransaction(bundle.getString(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_TRANSACTION));
            setConversationId(bundle.getString(OpenApiConstant.ResponseConstant.BUNDLE_CONVERSATION_ID));
            setConversationTitle(bundle.getString(OpenApiConstant.ResponseConstant.BUNDLE_CONVERSATION_TITLE));
            return this;
        }
    }
}
