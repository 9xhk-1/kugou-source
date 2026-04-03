package com.kugou.common.player.kgplayer;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.framework.bilib.statistics.cscc.protocol.CsccPostProtocol;
import com.kugou.framework.service.entity.PlayErrorInfo;
import com.kugou.uilib.widget.recyclerview.pulltorefresh.RotateLoadingLayout;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ErrorCodeConvert {
    private static int[][] errorCodeConvertTable;
    private static List<Integer> sourceerrorcode;

    public enum EMode {
        E1(ResponseHandlerForApm.E1, "网络组件错误"),
        E2(ResponseHandlerForApm.E2, "服务端程序错误"),
        E3(ResponseHandlerForApm.E3, "HTTP错误码"),
        E4(ResponseHandlerForApm.E4, "客户端异常"),
        E5(ResponseHandlerForApm.E5, "业务错误"),
        E6(ResponseHandlerForApm.E6, "用户操作异常");

        private String descr;
        private String mode;

        EMode(String str, String str2) {
            this.mode = str;
            this.descr = str2;
        }

        public String getMode() {
            return this.mode;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ErrorCode_1000' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class ErrorCode {
        private static final /* synthetic */ ErrorCode[] $VALUES;
        public static final ErrorCode ErrorCode_1000;
        public static final ErrorCode ErrorCode_1001;
        public static final ErrorCode ErrorCode_1002;
        public static final ErrorCode ErrorCode_1003;
        public static final ErrorCode ErrorCode_1004;
        public static final ErrorCode ErrorCode_1005;
        public static final ErrorCode ErrorCode_1006;
        public static final ErrorCode ErrorCode_1007;
        public static final ErrorCode ErrorCode_1008;
        public static final ErrorCode ErrorCode_1009;
        public static final ErrorCode ErrorCode_1010;
        public static final ErrorCode ErrorCode_1011;
        public static final ErrorCode ErrorCode_1012;
        public static final ErrorCode ErrorCode_1013;
        public static final ErrorCode ErrorCode_1014;
        public static final ErrorCode ErrorCode_1015;
        public static final ErrorCode ErrorCode_1016;
        public static final ErrorCode ErrorCode_1017;
        public static final ErrorCode ErrorCode_1018;
        public static final ErrorCode ErrorCode_1019;
        public static final ErrorCode ErrorCode_1020;
        public static final ErrorCode ErrorCode_1021;
        public static final ErrorCode ErrorCode_1022;
        public static final ErrorCode ErrorCode_1023;
        public static final ErrorCode ErrorCode_1024;
        public static final ErrorCode ErrorCode_1025;
        public static final ErrorCode ErrorCode_1026;
        public static final ErrorCode ErrorCode_1027;
        public static final ErrorCode ErrorCode_1028;
        public static final ErrorCode ErrorCode_1029;
        public static final ErrorCode ErrorCode_1030;
        public static final ErrorCode ErrorCode_1031;
        public static final ErrorCode ErrorCode_1032;
        public static final ErrorCode ErrorCode_1033;
        public static final ErrorCode ErrorCode_1034;
        public static final ErrorCode ErrorCode_1035;
        public static final ErrorCode ErrorCode_1036;
        public static final ErrorCode ErrorCode_1037;
        public static final ErrorCode ErrorCode_1038;
        public static final ErrorCode ErrorCode_1039;
        public static final ErrorCode ErrorCode_1040;
        public static final ErrorCode ErrorCode_1041;
        public static final ErrorCode ErrorCode_1051;
        public static final ErrorCode ErrorCode_1052;
        public static final ErrorCode ErrorCode_1053;
        public static final ErrorCode ErrorCode_1054;
        public static final ErrorCode ErrorCode_1055;
        public static final ErrorCode ErrorCode_1056;
        public static final ErrorCode ErrorCode_1057;
        public static final ErrorCode ErrorCode_1058;
        public static final ErrorCode ErrorCode_1059;
        public static final ErrorCode ErrorCode_1060;
        public static final ErrorCode ErrorCode_1061;
        public static final ErrorCode ErrorCode_1062;
        public static final ErrorCode ErrorCode_1063;
        public static final ErrorCode ErrorCode_1064;
        public static final ErrorCode ErrorCode_1065;
        public static final ErrorCode ErrorCode_1066;
        public static final ErrorCode ErrorCode_1067;
        public static final ErrorCode ErrorCode_1068;
        public static final ErrorCode ErrorCode_1200;
        public static final ErrorCode ErrorCode_1201;
        public static final ErrorCode ErrorCode_1202;
        public static final ErrorCode ErrorCode_1203;
        public static final ErrorCode ErrorCode_1301;
        public static final ErrorCode ErrorCode_1302;
        public static final ErrorCode ErrorCode_1303;
        public static final ErrorCode ErrorCode_1304;
        public static final ErrorCode ErrorCode_1305;
        public static final ErrorCode ErrorCode_1306;
        public static final ErrorCode ErrorCode_1307;
        public static final ErrorCode ErrorCode_1308;
        public static final ErrorCode ErrorCode_3000;
        public static final ErrorCode ErrorCode_3001;
        public static final ErrorCode ErrorCode_3008;
        public static final ErrorCode ErrorCode_3009;
        public static final ErrorCode ErrorCode_3010;
        public static final ErrorCode ErrorCode_3011;
        public static final ErrorCode ErrorCode_3012;
        public static final ErrorCode ErrorCode_3013;
        public static final ErrorCode ErrorCode_3021;
        public static final ErrorCode ErrorCode_3022;
        public static final ErrorCode ErrorCode_3023;
        public static final ErrorCode ErrorCode_3024;
        public static final ErrorCode ErrorCode_3025;
        public static final ErrorCode ErrorCode_3026;
        public static final ErrorCode ErrorCode_3027;
        public static final ErrorCode ErrorCode_3028;
        public static final ErrorCode ErrorCode_3029;
        public static final ErrorCode ErrorCode_3030;
        public static final ErrorCode ErrorCode_3031;
        public static final ErrorCode ErrorCode_3032;
        public static final ErrorCode ErrorCode_3033;
        public static final ErrorCode ErrorCode_3034;
        public static final ErrorCode ErrorCode_4000;
        private String desc;
        private EMode emode;
        private int errorcode;

        static {
            EMode eMode = EMode.E4;
            ErrorCode_1000 = new ErrorCode("ErrorCode_1000", 0, 1000, eMode, "初始化环境未准备好（录制的，听没有这个状态）");
            ErrorCode_1001 = new ErrorCode("ErrorCode_1001", 1, 1001, eMode, "文件不存在");
            ErrorCode_1002 = new ErrorCode("ErrorCode_1002", 2, 1002, eMode, "文件损坏: 内核报出");
            ErrorCode_1003 = new ErrorCode("ErrorCode_1003", 3, 1003, eMode, "没有音频流");
            ErrorCode_1004 = new ErrorCode("ErrorCode_1004", 4, 1004, eMode, "datasource出错");
            EMode eMode2 = EMode.E1;
            ErrorCode_1005 = new ErrorCode("ErrorCode_1005", 5, 1005, eMode2, "网络连接失败");
            ErrorCode_1006 = new ErrorCode("ErrorCode_1006", 6, 1006, eMode, "没有流信息");
            ErrorCode_1007 = new ErrorCode("ErrorCode_1007", 7, 1007, eMode, "未知错误");
            EMode eMode3 = EMode.E5;
            ErrorCode_1008 = new ErrorCode("ErrorCode_1008", 8, 1008, eMode3, "文件损坏: 小于25ms的播放完成");
            ErrorCode_1009 = new ErrorCode("ErrorCode_1009", 9, PointerIconCompat.TYPE_VERTICAL_TEXT, eMode, "创建AudioTrack失败");
            ErrorCode_1010 = new ErrorCode("ErrorCode_1010", 10, PointerIconCompat.TYPE_ALIAS, eMode3, "剩余空间不足下载");
            ErrorCode_1011 = new ErrorCode("ErrorCode_1011", 11, PointerIconCompat.TYPE_COPY, eMode3, "版权限制，境外不允许下载试听歌曲");
            ErrorCode_1012 = new ErrorCode("ErrorCode_1012", 12, PointerIconCompat.TYPE_NO_DROP, eMode3, "鉴权失败 //18,120,122");
            ErrorCode_1013 = new ErrorCode("ErrorCode_1013", 13, PointerIconCompat.TYPE_ALL_SCROLL, eMode3, "流量保护 //118");
            ErrorCode_1014 = new ErrorCode("ErrorCode_1014", 14, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, eMode, "查找不到文件记录，或者文件实体不存在");
            ErrorCode_1015 = new ErrorCode("ErrorCode_1015", 15, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, eMode2, "与tracker服务器的通信失败");
            EMode eMode4 = EMode.E2;
            ErrorCode_1016 = new ErrorCode("ErrorCode_1016", 16, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, eMode4, "云存储上没有该文件");
            ErrorCode_1017 = new ErrorCode("ErrorCode_1017", 17, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, eMode3, "资源未发布或被禁止，不能提供给客户端 //19,121,123");
            ErrorCode_1018 = new ErrorCode("ErrorCode_1018", 18, PointerIconCompat.TYPE_ZOOM_IN, eMode, "无法打开本地文件，流失败");
            ErrorCode_1019 = new ErrorCode("ErrorCode_1019", 19, PointerIconCompat.TYPE_ZOOM_OUT, eMode4, "云存储上没有该流畅版(m4a)的文件");
            ErrorCode_1020 = new ErrorCode("ErrorCode_1020", 20, PointerIconCompat.TYPE_GRAB, eMode2, "下载引擎返回超时: 缓冲时，遇到下载失败");
            ErrorCode_1021 = new ErrorCode("ErrorCode_1021", 21, PointerIconCompat.TYPE_GRABBING, eMode, "添加下载时参数错误");
            ErrorCode_1022 = new ErrorCode("ErrorCode_1022", 22, 1022, eMode2, "FMEC_ENGINE_NO_NETWORK 客户端网络断开导致的下载失败");
            ErrorCode_1023 = new ErrorCode("ErrorCode_1023", 23, AudioAttributesCompat.FLAG_ALL, eMode, "FMEC_ENGINE_CLOSE_STREAM_BY_DELETE 流因为停止下载被关闭。流专用状态码，非下载失败错误。");
            ErrorCode_1024 = new ErrorCode("ErrorCode_1024", 24, 1024, eMode3, "FMEC_ENGINE_CLOSE_STREAM_BY_WIFI_ONLY 因仅WiFi联网功能，停止下载");
            ErrorCode_1025 = new ErrorCode("ErrorCode_1025", 25, InputDeviceCompat.SOURCE_GAMEPAD, eMode2, "鉴权过程中网络出错");
            ErrorCode_1026 = new ErrorCode("ErrorCode_1026", 26, 1026, eMode2, "下载引擎返回超时: 下载失败(流没有完成),防止2G3G4G网络比较慢时仍然认为是正常的播放完成");
            ErrorCode_1027 = new ErrorCode("ErrorCode_1027", 27, 1027, eMode2, "下载引擎返回超时: 下载URL无法访问或无效资源,下载URL访问超时或P2P下载超时");
            ErrorCode_1028 = new ErrorCode("ErrorCode_1028", 28, 1028, eMode2, "下载引擎返回超时: 流因为停止下载被关闭。流专用状态码，非下载失败错误");
            ErrorCode_1029 = new ErrorCode("ErrorCode_1029", 29, PlayState.KPLAYER_ErrorCode_1029, eMode3, "会员专属歌曲不能免费试听，付费后畅享");
            ErrorCode_1030 = new ErrorCode("ErrorCode_1030", 30, PlayState.KPLAYER_ErrorCode_1030, eMode3, "该歌曲需单独购买后畅享");
            ErrorCode_1031 = new ErrorCode("ErrorCode_1031", 31, PlayState.KPLAYER_ErrorCode_1031, eMode3, "付费3.0音乐电台切歌失败");
            ErrorCode_1032 = new ErrorCode("ErrorCode_1032", 32, 1032, eMode3, "该歌曲暂不支持离线播放");
            ErrorCode_1033 = new ErrorCode("ErrorCode_1033", 33, 1033, eMode3, "该歌曲需单独购买后畅享");
            ErrorCode_1034 = new ErrorCode("ErrorCode_1034", 34, 1034, eMode3, "AI歌曲播放失败");
            ErrorCode_1035 = new ErrorCode("ErrorCode_1035", 35, 1035, eMode3, "设备不支持杜比");
            ErrorCode_1036 = new ErrorCode("ErrorCode_1036", 36, 1036, eMode, "无缝播放失败");
            ErrorCode_1037 = new ErrorCode("ErrorCode_1037", 37, 1037, eMode, "杜比软解so加载失败");
            ErrorCode_1038 = new ErrorCode("ErrorCode_1038", 38, 1038, eMode, "杜比文件解码失败");
            ErrorCode_1039 = new ErrorCode("ErrorCode_1039", 39, 1039, eMode2, "播放器首次缓存超时");
            ErrorCode_1040 = new ErrorCode("ErrorCode_1040", 40, 1040, eMode2, "播放器二次缓存超时");
            ErrorCode_1041 = new ErrorCode("ErrorCode_1041", 41, 1041, eMode3, "AI歌单无音源/红歌/长音频");
            ErrorCode_1051 = new ErrorCode("ErrorCode_1051", 42, 1051, eMode, "0x1000: 无法使用内核播放器，使用系统MediaPlayer播放URL网络歌曲出现异常");
            ErrorCode_1052 = new ErrorCode("ErrorCode_1052", 43, 1052, eMode, "0x1001: 下载引擎获取到一个无效流");
            ErrorCode_1053 = new ErrorCode("ErrorCode_1053", 44, 1053, eMode3, "存储IO错误: 无法读临时文件");
            ErrorCode_1054 = new ErrorCode("ErrorCode_1054", 45, 1054, eMode3, "存储IO错误: 因无法打开文件，流失败。此错误目前用于本地流");
            EMode eMode5 = EMode.E6;
            ErrorCode_1055 = new ErrorCode("ErrorCode_1055", 46, 1055, eMode5, "客户端网络断开导致的下载失败: 环境错误，非网络错误");
            ErrorCode_1056 = new ErrorCode("ErrorCode_1056", 47, 1056, eMode5, "流因为删除下载被关闭。流专用状态码，非下载失败错误");
            ErrorCode_1057 = new ErrorCode("ErrorCode_1057", 48, 1057, eMode5, "访问Tracker无效，返回status为0，错误码HashNotFound或者FileNotFound");
            ErrorCode_1058 = new ErrorCode("ErrorCode_1058", 49, 1058, eMode5, "访问Tracker无效，返回status为0，除TRACKER_NO_HASH以外的错误");
            ErrorCode_1059 = new ErrorCode("ErrorCode_1059", 50, 1059, eMode4, "访问Tracker无效，返回status为1，但是url字段内容为空");
            ErrorCode_1060 = new ErrorCode("ErrorCode_1060", 51, 1060, eMode3, "因不在中国境内，无法下载");
            ErrorCode_1061 = new ErrorCode("ErrorCode_1061", 52, 1061, eMode3, "存储IO错误: 无法写临时文件");
            ErrorCode_1062 = new ErrorCode("ErrorCode_1062", 53, 1062, eMode4, "访问Tracker返回Bad Key，原因可能是校验密钥过期或校验key无效");
            ErrorCode_1063 = new ErrorCode("ErrorCode_1063", 54, 1063, eMode3, "音乐云盘，服务器内部错误");
            ErrorCode_1064 = new ErrorCode("ErrorCode_1064", 55, 1064, eMode3, "灰名单歌曲，禁止播放");
            EMode eMode6 = EMode.E5;
            ErrorCode_1065 = new ErrorCode("ErrorCode_1065", 56, 1065, eMode6, "非曲库歌曲访问Tracker无效，返回status为0");
            ErrorCode_1066 = new ErrorCode("ErrorCode_1066", 57, 1066, eMode6, "第三方歌曲无文件");
            ErrorCode_1067 = new ErrorCode("ErrorCode_1067", 58, 1067, eMode6, "音质降级播放失败情况");
            ErrorCode_1068 = new ErrorCode("ErrorCode_1068", 59, 1068, eMode6, "AIK歌曲无法播放");
            EMode eMode7 = EMode.E4;
            ErrorCode_1200 = new ErrorCode("ErrorCode_1200", 60, RotateLoadingLayout.ROTATION_ANIMATION_DURATION, eMode7, "DLNA文件不支持 Android专用");
            EMode eMode8 = EMode.E1;
            ErrorCode_1201 = new ErrorCode("ErrorCode_1201", 61, CsccPostProtocol.CsccPostEntity.ERROR_CODE_TIMESTAMP_WRONG, eMode8, "DLNA网络错误 Android专用");
            ErrorCode_1202 = new ErrorCode("ErrorCode_1202", 62, CsccPostProtocol.CsccPostEntity.ERROR_CODE_COOKIE_EXPIRED, eMode7, "超出播放内核错误码之外的错误码，用此表示 Android专用");
            ErrorCode_1203 = new ErrorCode("ErrorCode_1203", 63, CsccPostProtocol.CsccPostEntity.ERROR_CODE_TOO_FREQUENT, eMode7, "超出FileErrorCode错误码之外的错误码，用此表示 Android专用");
            EMode eMode9 = EMode.E3;
            ErrorCode_1301 = new ErrorCode("ErrorCode_1301", 64, 1301, eMode9, "使用试听券,获取不到url");
            ErrorCode_1302 = new ErrorCode("ErrorCode_1302", 65, 1302, eMode9, "TRACK验证失败");
            ErrorCode_1303 = new ErrorCode("ErrorCode_1303", 66, 1303, eMode9, "账号登录过期");
            ErrorCode_1304 = new ErrorCode("ErrorCode_1304", 67, 1304, eMode7, "mgg解密协议升级解密失败");
            ErrorCode_1305 = new ErrorCode("ErrorCode_1305", 68, 1305, eMode7, "mgg文件解密失败");
            ErrorCode_1306 = new ErrorCode("ErrorCode_1306", 69, 1306, eMode7, "mixId和hash为空歌曲信息异常");
            ErrorCode_1307 = new ErrorCode("ErrorCode_1307", 70, 1307, eMode6, "会员歌曲播放设备数超过单日限制");
            ErrorCode_1308 = new ErrorCode("ErrorCode_1308", 71, 1308, eMode6, "歌曲付费状态有变更需升级新版");
            ErrorCode_4000 = new ErrorCode("ErrorCode_4000", 72, 4000, eMode7, "MV播放失败, SVPlayerView相关");
            ErrorCode_3000 = new ErrorCode("ErrorCode_3000", 73, 3000, eMode6, "MV播放成功");
            ErrorCode_3001 = new ErrorCode("ErrorCode_3001", 74, 3001, eMode6, "MV代理真实可用");
            ErrorCode_3008 = new ErrorCode("ErrorCode_3008", 75, 3008, eMode5, "MV播放时无网络: 开启仅WIFI联网，并且不是wifi");
            ErrorCode_3009 = new ErrorCode("ErrorCode_3009", 76, 3009, eMode8, "MV播放时无网络: 无网络");
            ErrorCode_3010 = new ErrorCode("ErrorCode_3010", 77, 3010, eMode7, "设置MV数据源过程中异常");
            ErrorCode_3011 = new ErrorCode("ErrorCode_3011", 78, 3011, eMode7, "MV播放地址获取失败: 获取本地地址失败");
            ErrorCode_3012 = new ErrorCode("ErrorCode_3012", 79, 3012, EMode.E2, "MV播放地址获取失败: 获取网络地址失败");
            ErrorCode_3013 = new ErrorCode("ErrorCode_3013", 80, 3013, eMode6, "MV下架");
            ErrorCode_3021 = new ErrorCode("ErrorCode_3021", 81, 3021, eMode7, "MV代理播放失败: 下载引擎代理没有运行");
            ErrorCode_3022 = new ErrorCode("ErrorCode_3022", 82, 3022, eMode6, "MV代理播放失败: 代理运行,开联通包月,且有网络但不是wifi");
            ErrorCode_3023 = new ErrorCode("ErrorCode_3023", 83, 3023, eMode7, "MV播放失败,非重试,硬解已确认错误码: 未知错误");
            ErrorCode_3024 = new ErrorCode("ErrorCode_3024", 84, 3024, eMode5, "MV播放失败,非重试,硬解已确认错误码: 本地文件损坏");
            ErrorCode_3025 = new ErrorCode("ErrorCode_3025", 85, 3025, eMode8, "MV播放失败,非重试,硬解已确认错误码: 网络链接错误");
            ErrorCode_3026 = new ErrorCode("ErrorCode_3026", 86, 3026, eMode7, "MV播放失败,非重试,硬解已确认错误码: 解码失败");
            ErrorCode_3027 = new ErrorCode("ErrorCode_3027", 87, 3027, eMode7, "MV播放失败,非重试,mediaplayer、softdecode未确认错误码: 未知错误");
            ErrorCode_3028 = new ErrorCode("ErrorCode_3028", 88, 3028, eMode7, "MV播放失败,无知错误码: 未知错误");
            ErrorCode_3029 = new ErrorCode("ErrorCode_3029", 89, 3029, eMode6, "MV代理播放失败,重试: 计算失败率时，需将此项去除");
            ErrorCode_3030 = new ErrorCode("ErrorCode_3030", 90, 3030, eMode7, "MV播放失败,硬解已确认错误码: 初始化失败");
            ErrorCode_3031 = new ErrorCode("ErrorCode_3031", 91, 3031, eMode7, "MV播放失败,非重试,硬解已确认错误码: 其他异常");
            ErrorCode_3032 = new ErrorCode("ErrorCode_3032", 92, 3032, eMode7, "MV播放失败,非重试,硬解已确认错误码: 解码初始化失败");
            ErrorCode_3033 = new ErrorCode("ErrorCode_3033", 93, 3033, eMode7, "MV播放失败,非重试,硬解已确认错误码: surface设置超时");
            ErrorCode_3034 = new ErrorCode("ErrorCode_3034", 94, 3034, eMode7, "MV播放失败,非重试,硬解已确认错误码: 代理失败");
            $VALUES = new ErrorCode[]{ErrorCode_1000, ErrorCode_1001, ErrorCode_1002, ErrorCode_1003, ErrorCode_1004, ErrorCode_1005, ErrorCode_1006, ErrorCode_1007, ErrorCode_1008, ErrorCode_1009, ErrorCode_1010, ErrorCode_1011, ErrorCode_1012, ErrorCode_1013, ErrorCode_1014, ErrorCode_1015, ErrorCode_1016, ErrorCode_1017, ErrorCode_1018, ErrorCode_1019, ErrorCode_1020, ErrorCode_1021, ErrorCode_1022, ErrorCode_1023, ErrorCode_1024, ErrorCode_1025, ErrorCode_1026, ErrorCode_1027, ErrorCode_1028, ErrorCode_1029, ErrorCode_1030, ErrorCode_1031, ErrorCode_1032, ErrorCode_1033, ErrorCode_1034, ErrorCode_1035, ErrorCode_1036, ErrorCode_1037, ErrorCode_1038, ErrorCode_1039, ErrorCode_1040, ErrorCode_1041, ErrorCode_1051, ErrorCode_1052, ErrorCode_1053, ErrorCode_1054, ErrorCode_1055, ErrorCode_1056, ErrorCode_1057, ErrorCode_1058, ErrorCode_1059, ErrorCode_1060, ErrorCode_1061, ErrorCode_1062, ErrorCode_1063, ErrorCode_1064, ErrorCode_1065, ErrorCode_1066, ErrorCode_1067, ErrorCode_1068, ErrorCode_1200, ErrorCode_1201, ErrorCode_1202, ErrorCode_1203, ErrorCode_1301, ErrorCode_1302, ErrorCode_1303, ErrorCode_1304, ErrorCode_1305, ErrorCode_1306, ErrorCode_1307, ErrorCode_1308, ErrorCode_4000, ErrorCode_3000, ErrorCode_3001, ErrorCode_3008, ErrorCode_3009, ErrorCode_3010, ErrorCode_3011, ErrorCode_3012, ErrorCode_3013, ErrorCode_3021, ErrorCode_3022, ErrorCode_3023, ErrorCode_3024, ErrorCode_3025, ErrorCode_3026, ErrorCode_3027, ErrorCode_3028, ErrorCode_3029, ErrorCode_3030, ErrorCode_3031, ErrorCode_3032, ErrorCode_3033, ErrorCode_3034};
        }

        private ErrorCode(String str, int i2, int i3, EMode eMode, String str2) {
            this.errorcode = i3;
            this.emode = eMode;
            this.desc = str2;
        }

        public static ErrorCode valueOf(String str) {
            return (ErrorCode) Enum.valueOf(ErrorCode.class, str);
        }

        public static ErrorCode[] values() {
            return (ErrorCode[]) $VALUES.clone();
        }

        public String getDesc() {
            return this.desc;
        }

        public EMode getEMode() {
            return this.emode;
        }

        public int getErrorcode() {
            return this.errorcode;
        }

        public void setErrorcode(int i2) {
            this.errorcode = i2;
        }
    }

    static {
        List<Integer> listAsList = Arrays.asList(Integer.valueOf(PlayErrorInfo.ERROR_TYPE_LOCAL_SONG_FILE_NO_EXIT), 4, 2, 7, 100, Integer.valueOf(PlayErrorInfo.ERROR_TYPE_PLAY_ERROR_DEFAULT), 24);
        sourceerrorcode = listAsList;
        int[] iArr = {listAsList.get(0).intValue(), ErrorCode.ErrorCode_1001.getErrorcode()};
        int[] iArr2 = {sourceerrorcode.get(1).intValue(), ErrorCode.ErrorCode_1004.getErrorcode()};
        int[] iArr3 = {sourceerrorcode.get(2).intValue(), ErrorCode.ErrorCode_1002.getErrorcode()};
        ErrorCode errorCode = ErrorCode.ErrorCode_1007;
        errorCodeConvertTable = new int[][]{iArr, iArr2, iArr3, new int[]{sourceerrorcode.get(3).intValue(), errorCode.getErrorcode()}, new int[]{sourceerrorcode.get(4).intValue(), errorCode.getErrorcode()}, new int[]{sourceerrorcode.get(5).intValue(), ErrorCode.ErrorCode_1202.getErrorcode()}, new int[]{sourceerrorcode.get(6).intValue(), ErrorCode.ErrorCode_1009.getErrorcode()}};
    }

    public static ErrorCode getErrorCodeEnum(int i2) {
        if (sourceerrorcode.contains(Integer.valueOf(i2))) {
            int[][] iArr = errorCodeConvertTable;
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int[] iArr2 = iArr[i3];
                if (i2 == iArr2[0]) {
                    i2 = iArr2[1];
                    break;
                }
                i3++;
            }
        }
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (i2 == errorCode.getErrorcode()) {
                return errorCode;
            }
        }
        return null;
    }
}
