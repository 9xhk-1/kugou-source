package com.xtc.shareapi.share.communication;

import com.xtc.shareapi.share.interfaces.IBundleSerialize;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseResponse implements IBundleSerialize {
    private int code;
    private String conversationId;
    private String conversationTitle;
    private String errorDesc;
    private String fromType;
    private String transaction;

    public interface Code {
        public static final int APP_NOT_PERMISSION = 18;
        public static final int ARGUMENT_ERROR = 6;
        public static final int AUTHOR_FAIL = 3;
        public static final int CANCEL = 2;
        public static final int CONVERSION_ERROR = 7;
        public static final int MOMENT_NOT_INSTALL = 14;
        public static final int MOMENT_NOT_SUPPORT_MULTI_IMAGE = 16;
        public static final int NETWORK_ERROR = 8;
        public static final int NON_SUPPORT = 5;
        public static final int NOT_CONTACT_PERMISSION = 19;
        public static final int NO_FRIEND = 11;
        public static final int NO_SHARE = -1;
        public static final int OK = 1;
        public static final int OTHER = 100;
        public static final int SCENE_FORBID = 10;
        public static final int SHARE_COUNT_TOO_MANY = 15;
        public static final int SKIP_CODE = 1000;
        public static final int TIMEMEMORY_NOT_PERMISSION = 17;
        public static final int TIMES_OVER = 4;
        public static final int TOKEN_ERROR = 9;
        public static final int VIDEO_IS_SENDING = 12;
        public static final int WEICHAT_NOT_INSTALL = 13;
    }

    public interface Desc {
        public static final String ARGUMENT_ERROR = "share_argument_error";
        public static final String AUTHOR_FAIL = "author_fail";
        public static final String CANCEL = "share_cancel";
        public static final String CONVERSION_ERROR = "share_conversation_error";
        public static final String MOMENT_NOT_SUPPORT_MULTI_IMAGE_ERROR = "moment_not_support_multi_image_error";
        public static final String NETWORK_ERROR = "share_network_error";
        public static final String NON_SUPPORT = "share_non_support";
        public static final String OK = "share_success";
        public static final String OTHER = "share_other_error";
        public static final String SHARE_COUNT_ERROR = "share_count_too_many_error";
        public static final String TIMES_OVER = "share_times_over";
        public static final String TOKEN_ERROR = "share_token_error";
        public static final String VERSION_ERROR = "share_version_error";
        public static final String VIDEO_IS_SENDING = "video_is_sending";
    }

    public BaseResponse() {
    }

    public int getCode() {
        return this.code;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public String getConversationTitle() {
        return this.conversationTitle;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public String getFromType() {
        return this.fromType;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public abstract int getType();

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }

    public void setConversationTitle(String str) {
        this.conversationTitle = str;
    }

    public void setErrorDesc(String str) {
        this.errorDesc = str;
    }

    public void setFromType(String str) {
        this.fromType = str;
    }

    public void setTransaction(String str) {
        this.transaction = str;
    }

    public String toString() {
        return "BaseResponse{code=" + this.code + ", errorDesc='" + this.errorDesc + "', transaction='" + this.transaction + "', conversationId='" + this.conversationId + "', conversationTitle='" + this.conversationTitle + "'}";
    }

    public BaseResponse(int i2, String str) {
        this.code = i2;
        this.errorDesc = str;
    }

    public BaseResponse(int i2, String str, String str2) {
        this.code = i2;
        this.errorDesc = str;
        this.transaction = str2;
    }
}
