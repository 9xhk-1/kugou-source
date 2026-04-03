package com.xtc.shareapi.share.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface OpenApiConstant {
    public static final boolean MULTI_LIVE_PHOTO_SUPPORT = false;
    public static final boolean MULTI_VIDEO_SUPPORT = false;
    public static final int PATH_LENGTH_LIMIT = 512;
    public static final int SHARE_COUNT_LIMIT = 9;
    public static final String TAG = "Share_";

    /* JADX INFO: loaded from: classes2.dex */
    public interface App {
        public static final String CHAT_PACKAGE_NAME = "com.xtc.weichat";
        public static final String LAUNCHER = "com.xtc.i3launcher";
        public static final String LAUNCHER_CHAT_ACTIVITY = "com.xtc.open.share.chat.activity";
        public static final String LAUNCHER_MOMENT_ACTIVITY = "com.xtc.open.share.moment.activity";
        public static final String META_DATA_VERSION = "com.xtc.open.share.version";
        public static final String META_DATA_XTCSERVICE_VERSION = "com.xtc.xws.apkCertificate.version";
        public static final String MOMENT_MATA_LBS_ACTIVITY = "com.xtc.moment.jump.pushPictureActivity";
        public static final String MOMENT_PACKAGE_NAME = "com.xtc.moment";
        public static final String PACKAGE_TIME_MEMORY = "com.xtc.timememory";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface BaseRequestConstant {
        public static final String BASE_REQUEST_TRANSACTION = "xtc_share_base_request_transaction";
        public static final String BASE_REQUEST_TYPE = "xtc_share_base_request_type";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface BuilderConstant {
        public static final String BUILDER_WEB_BUNDLE_MAP = "builder_web_bundle_map";
        public static final String KEY_IDENTIFIER = "_wxobject_identifier_";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface BundleExtra {
        public static final int LIVE_PHOTO = 2;
        public static final int MAX_LENGTH_40 = 40;
        public static final int PHOTO = 0;
        public static final String PHOTO_TYPE = "com.xtc.camera.EXTRA_PHOTO_TYPE";
        public static final String SELECT_PHOTO_LIST = "com.xtc.camera.SELECT_PHOTO_LIST";
        public static final int VIDEO = 1;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface BundleMap {
        public static final String BUNDLE_MAP = "_xtc_api_serializable_map";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface DialogBitmapArgsConstant {
        public static final String DEBRIS_CROP_HEIGHT = "_xtc_api_dialog_debris_crop_height";
        public static final String DEBRIS_CROP_WIDTH = "_xtc_api_dialog_debris_crop_width";
        public static final String DEBRIS_CUT_START = "_xtc_api_dialog_debris_cut_start";
        public static final String DEBRIS_CUT_TOP = "_xtc_api_dialog_debris_cut_top";
        public static final String DEBRIS_HEIGHT = "_xtc_api_dialog_debris_height";
        public static final String DEBRIS_TYPE = "_xtc_api_dialog_debris_type";
        public static final String DEBRIS_WIDTH = "_xtc_api_dialog_debris_width";
        public static final int DIALOG_HEIGHT_1 = 214;
        public static final int DIALOG_HEIGHT_2 = 190;
        public static final int DIALOG_HEIGHT_3 = 220;
        public static final int DIALOG_HEIGHT_4 = 220;
        public static final int DIALOG_WIDTH_1 = 190;
        public static final int DIALOG_WIDTH_2 = 304;
        public static final int DIALOG_WIDTH_3 = 240;
        public static final int DIALOG_WIDTH_4 = 196;
        public static final int TYPE_CUSTOM = 5;
        public static final int TYPE_DOUBLE_PK = 4;
        public static final int TYPE_FACE_SCORE = 3;
        public static final int TYPE_INTELLIGENT = 2;
        public static final int TYPE_NORMAL = 1;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface FunSwitchStatue {
        public static final int FUN_SWITCH_CLOSE = 1;
        public static final int FUN_SWITCH_OPEN = 0;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface IntentConstant {
        public static final String INTENT_APP_ICON = "_xtc_api_app_icon";
        public static final String INTENT_APP_JUMP_FLAG = "_xtc_api_app_jump_flag";
        public static final String INTENT_APP_KEY = "_xtc_api_app_key";
        public static final String INTENT_APP_NAME = "_xtc_api_app_name";
        public static final String INTENT_APP_TOKEN = "_xtc_api_app_token";
        public static final String INTENT_CHAT_SERVICE = "com.xtc.share.chat.service";
        public static final String INTENT_CLASSNAME = "_xtc_api_class_name";
        public static final String INTENT_PACKAGE = "_xtc_api_package";
        public static final String INTENT_VERSION = "_xtc_api_version";
        public static final String SERVICE_TIME_MEMORY = "com.xtc.share.timememory.service";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface MessageBitmapArgsConstant {
        public static final String DEBRIS_HEIGHT = "_xtc_api_message_debris_height";
        public static final String DEBRIS_TYPE = "_xtc_api_message_debris_type";
        public static final String DEBRIS_WIDTH = "_xtc_api_message_debris_width";
        public static final int MESSAGE_HEIGHT_1 = 180;
        public static final int MESSAGE_HEIGHT_2 = 156;
        public static final int MESSAGE_HEIGHT_3 = 154;
        public static final int MESSAGE_HEIGHT_4 = 160;
        public static final int MESSAGE_WIDTH_1 = 160;
        public static final int MESSAGE_WIDTH_2 = 250;
        public static final int MESSAGE_WIDTH_3 = 168;
        public static final int MESSAGE_WIDTH_4 = 142;
        public static final int TYPE_DOUBLE_PK = 4;
        public static final int TYPE_FACE_SCORE = 3;
        public static final int TYPE_INTELLIGENT = 2;
        public static final int TYPE_NORMAL = 1;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface ModuleSwitch {
        public static final int MODULE_SWITCH_MOMENT = 47;
        public static final int MODULE_TIME_MEMORY = 2459;
        public static final String SHARE_APP_MODULE = "content://com.xtc.share/switch";
        public static final String XTC_MODULE_SWITCH_OPEN = "moduleSwitch";
        public static final String XTC_MODULE_SWITCH_TIP = "moduleSwitchTip";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface MomentIntentConstant {
        public static final String IS_FROM_ALBUM = "isFromAlbum";
        public static final String IS_FROM_OUTSIDE_JUMP = "is_from_outside_jump";
        public static final String LBS_ADDRESS_POI_BEAN = "lbs_address_city_poi_bean";
        public static final String LBS_FROM_LAUNCHER_ADDRESS_ID = "lbs_from_launcher_address_id";
        public static final String LBS_TEXT = "lbs_text";
        public static final String PHOTO_PATH = "photo_path";
        public static final String PiCURE_PHOTO_PATH = "picture_photo_path";
        public static final String SHARE_FROM_EXTRA = "share_from_extra";
        public static final String VIDEO_PATH = "video_path";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface ResponseConstant {
        public static final String BUNDLE_CONVERSATION_ID = "_xtc_api_conversation_id";
        public static final String BUNDLE_CONVERSATION_TITLE = "_xtc_api_conversation_title";
        public static final String BUNDLE_ERROR_CODE = "_xtc_api_response_code";
        public static final String BUNDLE_ERROR_DESC = "_xtc_api_response_desc";
        public static final String BUNDLE_ERROR_TRANSACTION = "_xtc_api_response_transation";
        public static final String BUNDLE_SCENE_FROM_MOMENT = "_xtc_api_from_moment";
        public static final String BUNDLE_SCENE_FROM_TYPE = "_xtc_api_from_type";
        public static final String BUNDLE_SCENE_FROM_WEICHAT = "_xtc_api_from_weichat";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface SceneConstant {
        public static final String BUNDLE_CHAT_CONVERSATION_LIST = "_xtc_api_conversationId_list";
        public static final String BUNDLE_CHAT_FILTER_TIP = "_xtc_api_chat_filter_tip";
        public static final String BUNDLE_CHAT_FRIEND_TYPE = "_xtc_api_chat_firend_type";
        public static final String BUNDLE_CHAT_MODE_LIST = "_xtc_api_conversationMode_list";
        public static final String BUNDLE_CHAT_OPENID_LIST = "_xtc_api_chat_openId_list";
        public static final String BUNDLE_CHAT_SELECTION_MODE = "_xtc_api_chat_select_actionMode";
        public static final String BUNDLE_SCENE_SHARE_TYPE = "_xtc_api_chat_share_type";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface SceneInstall {
        public static final int MOMENT_NOT_INSTALL = 2;
        public static final int SCENE_INSTALL = 0;
        public static final int WEI_CHAT_NOT_INSTALL = 1;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface SdkVersionCode {
        public static final int CHAT_VERSION_CODE = 1;
        public static final int MOMENT_VERAION_CODE_SUPPORT_JUMP = 4;
        public static final int MOMENT_VERSION_CODE = 1;
        public static final String SDK_VERSION_CODE = "1";
    }

    public @interface SelfStart {
        public static final String EXTRA_SELF_START = "EXTRA_SELF_START";
        public static final String LAUNCHER_SELF_START_URI = "content://com.xtc.launcher.self.start";
        public static final String METHOD_GET_PACKAGE_SELF_START = "METHOD_GET_PACKAGE_SELF_START";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface SendMessageFromXTCConstant {
        public static final String BUNDLE_MESSAGE_SHARE_ICON = "_xtc_api_share_icon";
        public static final String BUNDLE_MESSAGE_SHARE_JUMP_FLAG = "_xtc_api_share_jump_flag";
        public static final String BUNDLE_MESSAGE_SHARE_NAME = "_xtc_api_share_name";
        public static final String BUNDLE_MESSAGE_SHARE_SENCE = "_xtc_api_share_scene";
        public static final String BUNDLE_MESSAGE_SHARE_TYPE = "_xtc_api_share_type";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface ShareCloudFileConstant {
        public static final String BUNDLE_FILE_DOWNLOAD_URL = "_xtc_api_share_cloud_file_download_url";
        public static final String BUNDLE_FILE_HEIGHT = "_xtc_api_share_cloud_file_height";
        public static final String BUNDLE_FILE_KEY = "_xtc_api_share_cloud_file_key";
        public static final String BUNDLE_FILE_URL_DEADLINE = "_xtc_api_share_cloud_file_url_deadline";
        public static final String BUNDLE_FILE_WIDTH = "_xtc_api_share_cloud_file_width";
    }

    public @interface ShareSupport {
        public static final int RESULT_NON_EXIST = 2;
        public static final int RESULT_NOT_VERIFIED = 3;
        public static final int RESULT_SUCCESS = 1;
        public static final int RESULT_UN_INIT = 0;
        public static final String URI_QUERY_ALL_APK_INFO = "content://com.xtc.share.support.provider.ShareSupportContentProvider/queryAllApkInfo";
        public static final String URI_UPDATE_APK_INFO = "content://com.xtc.share.support.provider.ShareSupportContentProvider/updateApkInfo";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface ShowMessageFromXTCConstant {
        public static final String BUNDLE_MESSAGE_EXTEND = "_xtc_api_share_type";
        public static final String BUNDLE_MESSAGE_SHARE_ICON = "_xtc_api_share_icon";
        public static final String BUNDLE_MESSAGE_SHARE_NAME = "_xtc_api_share_name";
        public static final String BUNDLE_MESSAGE_SHARE_SENCE = "_xtc_api_share_scene";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface TokenConstant {
        public static final String QUERY_SELECTION = "xtc_share_package = ?";
        public static final String SHARE_APP_ALLOW = "xtc_share_allow";
        public static final String SHARE_APP_PACKAGE = "xtc_share_package";
        public static final String SHARE_APP_TOKEN = "xtc_share_token";
        public static final String SHARE_APP_URI = "content://com.xtc.share/app";
        public static final String SHARE_CHAT_URI = "content://com.xtc.share.chat/app";
        public static final String SHARE_MOMENT_URI = "content://com.xtc.share.moment/app";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCAppExtendConstant {
        public static final String BUNDLE_EXTEND_INFO = "_xtc_api_share_app_content";
        public static final String BUNDLE_START_ACTIVITY = "_xtc_api_share_app_start";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCImageConstant {
        public static final String BUNDLE_IMAGE_DATA = "_xtc_api_share_image_data";
        public static final String BUNDLE_IMAGE_DIALOG_BITMAP_ARGS = "_xtc_api_share_image_dialog_bitmap_args";
        public static final String BUNDLE_IMAGE_MESSAGE_BITMAP_ARGS = "_xtc_api_share_image_message_bitmap_args";
        public static final String BUNDLE_IMAGE_PATH = "_xtc_api_share_image_path";
        public static final String BUNDLE_IMAGE_TEXT_MESSAGE = "_xtc_api_share_image_text_message";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCLivePhotoConstant {
        public static final String BUNDLE_PHOTO_PATH = "_xtc_api_photo_path";
        public static final String BUNDLE_VIDEO_PATH = "_xtc_api_video_path";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCMultiImageConstant {
        public static final String BUNDLE_IMAGE_PATH_LIST = "_xtc_api_image_path_list";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCMultiLivePhotoConstant {
        public static final String BUNDLE_LIVE_PHOTO_LIST = "_xtc_api_live_photo_list";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCMultiVideoConstant {
        public static final String BUNDLE_VIDEO_LIST = "_xtc_api_video_list";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCMusicConstant {
        public static final String BUNDLE_MUSIC_AUTHOR = "_xtc_api_share_music_author";
        public static final String BUNDLE_MUSIC_DEFAULT_URL = "_xtc_api_share_music_url";
        public static final String BUNDLE_MUSIC_DURATION = "_xtc_api_share_music_duration";
        public static final String BUNDLE_MUSIC_EXTEND = "_xtc_api_share_music_ext_info";
        public static final String BUNDLE_MUSIC_HIGH_URL = "_xtc_api_share_music_highUrl";
        public static final String BUNDLE_MUSIC_LOW_URL = "_xtc_api_share_music_lowUrl";
        public static final String BUNDLE_MUSIC_NAME = "_xtc_api_share_music_name";
        public static final String BUNDLE_MUSIC_START_ACTIVITY = "_xtc_api_share_start_activity";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCShareAppName {
        public static final String XTC_CHAT_APP_NAME = "微聊";
        public static final String XTC_MOMENT_APP_NAME = "好友圈";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCShareMessageConstant {
        public static final String BUNDLE_MESSAGE_ACTION = "_xtc_api_share_action";
        public static final String BUNDLE_MESSAGE_ACTION_TYPE = "_xtc_api_share_actionType";
        public static final String BUNDLE_MESSAGE_DESC = "_xtc_api_share_desc";
        public static final String BUNDLE_MESSAGE_EXT = "_xtc_api_share_ext";
        public static final String BUNDLE_MESSAGE_THUMB = "_xtc_api_share_thumb";
        public static final String BUNDLE_MESSAGE_TITLE = "_xtc_api_share_title";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCShareSocialVideoType {
        public static final String FACEBOOK = "1";
        public static final String INSTAGRAM = "2";
        public static final String STR_FACEBOOK = "Facebook";
        public static final String STR_INS = "Instagram";
        public static final String STR_YOUTUBE = "YouTube";
        public static final String YOUTUBE = "0";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCShareType {
        public static final int APP = 3;
        public static final int IMAGE = 2;
        public static final int LIVE_PHOTO = 7;
        public static final int MULTI_IMAGE = 9;
        public static final int MULTI_LIVE_PHOTO = 10;
        public static final int MULTI_VIDEO = 11;
        public static final int MUSIC = 5;
        public static final int SOCIAL_VIDEO = 8;
        public static final int TEXT = 1;
        public static final int VIDEO = 4;
        public static final int WEB = 6;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCTextConstant {
        public static final String BUNDLE_TEXT = "_xtc_api_share_text_content";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCVideoConstant {
        public static final String BUNDLE_VIDEO_CUSTOM_PARAM_MAP = "_xtc_api_share_video_customParamMap";
        public static final String BUNDLE_VIDEO_DURATION = "_xtc_api_share_video_duration";
        public static final String BUNDLE_VIDEO_EXTINFO = "_xtc_api_share_video_ext_info";
        public static final String BUNDLE_VIDEO_ORIGIN_VIDEO_PATH = "_xtc_api_share_video_originVideoPath";
        public static final String BUNDLE_VIDEO_SOURCE_DEADLINE = "_xtc_api_share_video_sourceDeadline";
        public static final String BUNDLE_VIDEO_SOURCE_DOWNLOAD_URL = "_xtc_api_share_video_sourceDownloadUrl";
        public static final String BUNDLE_VIDEO_SOURCE_KEY = "_xtc_api_share_video_sourceKey";
        public static final String BUNDLE_VIDEO_START_ACTIVITY = "_xtc_api_video_start_activity";
        public static final String BUNDLE_VIDEO_THUMBNAIL_DEADLINE = "_xtc_api_share_video_thumbnailDeadline";
        public static final String BUNDLE_VIDEO_THUMBNAIL_DOWNLOAD_URL = "_xtc_api_share_video_thumbnailDownloadUrl";
        public static final String BUNDLE_VIDEO_THUMBNAIL_KEY = "_xtc_api_share_video_thumbnailKey";
        public static final String BUNDLE_VIDEO_THUMBNAIL_PATH = "_xtc_api_share_video_thumbnailPath";
        public static final String BUNDLE_VIDEO_TYPE = "_xtc_api_share_video_type";
        public static final String BUNDLE_VIDEO_VIDEO_DEADLINE = "_xtc_api_share_video_videoDeadline";
        public static final String BUNDLE_VIDEO_VIDEO_DOWNLOAD_URL = "_xtc_api_share_video_videoDownloadUrl";
        public static final String BUNDLE_VIDEO_VIDEO_KEY = "_xtc_api_share_video_videoKey";
        public static final String BUNDLE_VIDEO_VIDEO_PATH = "_xtc_api_share_video_videoPath";
        public static final String BUNDLE_VIDEO_WANGSU_URL = "_xtc_api_share_video_wangSuUrl";
        public static final String BUNDLE_VIDEO_ZONE = "_xtc_api_share_video_zone";
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface XTCWebConstant {
        public static final String BUILDER_WEB_MAP = "_xtc_api_share_web_map";
        public static final String BUILDER_WEB_RTOS_SUPPORT = "_xtc_api_share_web_rtos_support";
        public static final String BUNDLE_WEB_ARGS = "_xtc_api_share_web_args";
        public static final String BUNDLE_WEB_EXTEND_INFO = "_xtc_api_share_web_content";
        public static final String BUNDLE_WEB_URL = "_xtc_api_share_web_url";
    }
}
