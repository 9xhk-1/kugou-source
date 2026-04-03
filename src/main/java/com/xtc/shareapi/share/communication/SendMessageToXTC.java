package com.xtc.shareapi.share.communication;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.Scene;
import com.xtc.shareapi.share.shareobject.XTCShareMessage;
import com.xtc.shareapi.share.sharescene.Chat;
import com.xtc.shareapi.share.sharescene.Moment;

/* JADX INFO: loaded from: classes2.dex */
public class SendMessageToXTC {

    public static class Request extends BaseRequest {
        private int flag;
        private XTCShareMessage message;
        private Scene scene;

        @Override // com.xtc.shareapi.share.communication.BaseRequest, com.xtc.shareapi.share.interfaces.IBundleSerialize
        public BaseResponse checkArgs() {
            XTCShareMessage xTCShareMessage = this.message;
            if (xTCShareMessage != null) {
                return xTCShareMessage.checkArgs();
            }
            Log.d(OpenApiConstant.TAG, "checkArgs fail ,message is null");
            ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
            response.setCode(6);
            response.setErrorDesc("XTCShareMessage is null");
            return response;
        }

        public int getFlag() {
            return this.flag;
        }

        public XTCShareMessage getMessage() {
            return this.message;
        }

        public Scene getScene() {
            return this.scene;
        }

        @Override // com.xtc.shareapi.share.communication.BaseRequest
        public int getType() {
            return 2;
        }

        public void setFlag(int i2) {
            this.flag = i2;
        }

        public void setMessage(XTCShareMessage xTCShareMessage) {
            this.message = xTCShareMessage;
        }

        public void setScene(Scene scene) {
            this.scene = scene;
        }

        @Override // com.xtc.shareapi.share.communication.BaseRequest, com.xtc.shareapi.share.interfaces.IBundleSerialize
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(XTCShareMessage.Builder.toBundle(this.message));
            Scene scene = this.scene;
            if (scene != null) {
                scene.toBundle(bundle);
            }
            bundle.putInt("_xtc_api_share_type", this.message.getType());
            bundle.putInt(OpenApiConstant.SendMessageFromXTCConstant.BUNDLE_MESSAGE_SHARE_JUMP_FLAG, this.flag);
        }

        @Override // com.xtc.shareapi.share.communication.BaseRequest, com.xtc.shareapi.share.interfaces.IBundleSerialize
        public Request fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            Log.d(OpenApiConstant.TAG, "come to fromBundle1");
            int i2 = bundle.getInt(OpenApiConstant.SceneConstant.BUNDLE_SCENE_SHARE_TYPE);
            Log.d(OpenApiConstant.TAG, "come to fromBundle2" + i2);
            if (i2 == 1) {
                Chat chat = (Chat) new Chat().fromBundle(bundle);
                Log.d(OpenApiConstant.TAG, "come to fromBundle" + chat.toString() + ",var1 = " + bundle.toString());
                setScene(chat);
            } else if (i2 == 2) {
                setScene((Moment) new Moment().fromBundle(bundle));
            }
            XTCShareMessage xTCShareMessageFromBundle = XTCShareMessage.Builder.fromBundle(bundle);
            this.message = xTCShareMessageFromBundle;
            xTCShareMessageFromBundle.setActionType(bundle.getInt("_xtc_api_share_type"));
            Log.d(OpenApiConstant.TAG, "come to fromBundle3 " + this.message);
            this.flag = bundle.getInt(OpenApiConstant.SendMessageFromXTCConstant.BUNDLE_MESSAGE_SHARE_JUMP_FLAG);
            return this;
        }
    }

    public static class Response extends BaseResponse {
        public Response() {
        }

        @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
        public BaseResponse checkArgs() {
            Response response = new Response();
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

        public Response(int i2, String str) {
            super(i2, str);
        }

        @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
        public Response fromBundle(Bundle bundle) {
            setCode(bundle.getInt(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_CODE));
            setErrorDesc(bundle.getString(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_DESC));
            setTransaction(bundle.getString(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_TRANSACTION));
            setConversationId(bundle.getString(OpenApiConstant.ResponseConstant.BUNDLE_CONVERSATION_ID));
            setConversationTitle(bundle.getString(OpenApiConstant.ResponseConstant.BUNDLE_CONVERSATION_TITLE));
            setFromType(bundle.getString(OpenApiConstant.ResponseConstant.BUNDLE_SCENE_FROM_TYPE));
            return this;
        }

        public Response(int i2, String str, String str2) {
            super(i2, str, str2);
        }
    }
}
