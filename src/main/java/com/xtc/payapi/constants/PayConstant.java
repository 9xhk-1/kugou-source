package com.xtc.payapi.constants;

/* JADX INFO: loaded from: classes2.dex */
public interface PayConstant {
    public static final String SDK_VERSION_CODE = "1";
    public static final String TAG = "pay_sdk";

    public interface BaseRequestConstant {
        public static final String BASE_REQUEST_TRANSACTION = "xtc_pay_base_request_transaction";
        public static final String BASE_REQUEST_TYPE = "xtc_pay_base_request_type";
    }

    public interface BaseRequestType {
        public static final int REQUEST_TYPE = 2;
    }

    public interface BaseResponseConstant {
        public static final String BASE_RESPONSE_ERROR_CODE = "xtc_pay_base_response_error_code";
        public static final String BASE_RESPONSE_ERROR_DESC = "xtc_pay_base_response_error_desc";
        public static final String BASE_RESPONSE_TRANSACTION = "xtc_pay_base_response_transaction";
        public static final String BASE_RESPONSE_TYPE = "xtc_pay_base_response_type";
    }

    public interface HostAppInfo {
        public static final String HOST_PACKAGE_NAME = "com.xtc.setting";
        public static final String META_DATA_HOST_CLASS_NAME_KEY = "com.xtc.pay.activity";
        public static final String META_DATA_VERSION_KEY = "com.xtc.pay.version";
    }

    public interface PayMesConstant {
        public static final String BUNDLE_MESSAGE_APP_ID = "xtc_pay_request_app_id";
        public static final String BUNDLE_MESSAGE_CHECK_CODE = "xtc_pay_request_check_code";
        public static final String BUNDLE_MESSAGE_ISUSESDKOPENID = "xtc_pay_request_isusesdkopenid";
        public static final String BUNDLE_MESSAGE_OPENID = "xtc_pay_request_openid";
        public static final String BUNDLE_MESSAGE_ORDER_ID = "xtc_pay_request_order_id";
        public static final String BUNDLE_MESSAGE_PAY_TYPE = "xtc_pay_type";
        public static final String BUNDLE_MESSAGE_PRICE = "xtc_pay_request_price";
        public static final String BUNDLE_MESSAGE_PRODUCT_INFO = "xtc_pay_request_product_info";
        public static final String BUNDLE_MESSAGE_THUMB = "xtc_pay_request_thumb";
        public static final String BUNDLE_MESSAGE_TITLE = "xtc_pay_request_title";
    }

    public interface ResponseConstant {
        public static final String PAY_RESPONSE_CODE = "xtc_pay_response_code";
        public static final String PAY_RESPONSE_OPENID = "xtc_pay_response_openid";
    }

    public interface SourceAppInfo {
        public static final String SOURCE_CLASS_NAME_KEY = "_xtc_pay_api_class_name";
        public static final String SOURCE_PACKAGE_NAME_KEY = "_xtc_pay_api_package_name";
        public static final String SOURCE_PAY_VERSION_KEY = "_xtc_pay_api_version";
    }
}
