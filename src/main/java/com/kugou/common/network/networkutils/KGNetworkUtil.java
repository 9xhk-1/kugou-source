package com.kugou.common.network.networkutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.kugou.common.permission.KGPermission;
import com.kugou.common.permission.Permission;
import java.io.Closeable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class KGNetworkUtil {
    private static final int MAX_STACK_FRAME_COUNT = 10;
    public static String tHashSuffix;

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static <T> T[] concat(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static String cutHTML(String str) {
        return cutHTML(str, 75);
    }

    public static String dataToHTML(byte[] bArr) {
        String str;
        try {
            try {
                str = new String(bArr, "UTF-8");
            } catch (Exception unused) {
                str = new String(bArr, "GBK");
            }
        } catch (Exception unused2) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? removeLines(str) : str;
    }

    public static String genStackHash(int i2) {
        String hexString = Integer.toHexString(Math.abs(generateStackFeature(new Exception(), i2).hashCode()));
        String strSubstring = hexString.substring(0, Math.min(hexString.length(), 7));
        return !TextUtils.isEmpty(tHashSuffix) ? strSubstring.concat("-").concat(tHashSuffix) : strSubstring;
    }

    private static String generateStackFeature(Throwable th, int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (th != null && i3 < 10) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            for (int i4 = 0; i4 < stackTrace.length; i4++) {
                if (i4 >= i2) {
                    StackTraceElement stackTraceElement = stackTrace[i4];
                    String className = stackTraceElement.getClassName();
                    if (!isSysStackFrame(className)) {
                        sb.append(className);
                        sb.append(stackTraceElement.getMethodName());
                        i3++;
                        if (i3 >= 10) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            th = th.getCause();
        }
        return sb.toString();
    }

    public static String getCurrentMobileNetworkType(Context context) {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(0)) == null || !networkInfo.isConnected()) ? "" : networkInfo.getExtraInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getCurrentNet2GType(Context context) {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(0)) == null || !networkInfo.isConnected()) ? "cmnet" : "cmwap".equalsIgnoreCase(networkInfo.getExtraInfo()) ? "cmwap" : "cmnet";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "cmnet";
        }
    }

    public static String getCurrentNetworkIdentifier(Context context) {
        String str;
        String networkType = getNetworkType(context);
        if ("wifi".equals(networkType)) {
            return "wifi";
        }
        if ("unknown".equals(networkType)) {
            return "";
        }
        String currentMobileNetworkType = getCurrentMobileNetworkType(context);
        try {
            int networkType2 = getNetworkType(context, (TelephonyManager) context.getSystemService("phone"));
            if (networkType2 == 0) {
                return currentMobileNetworkType;
            }
            if (TextUtils.isEmpty(currentMobileNetworkType)) {
                str = "Mobile" + networkType2;
            } else {
                str = currentMobileNetworkType + "(" + networkType2 + ")";
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return currentMobileNetworkType;
        }
    }

    public static String getFirstIP(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iIndexOf = str.indexOf(44);
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
    }

    public static String getHostFromServer(String str) {
        if (isEmpty(str)) {
            return "";
        }
        int iIndexOf = str.indexOf(58);
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
    }

    public static String getHostIP(String str) {
        try {
            InetAddress[] allByName = InetAddress.getAllByName(getHostOfUrl(str));
            return (allByName == null || allByName.length <= 0) ? "" : allByName[0].getHostAddress();
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String getHostOfUrl(String str) {
        return TextUtils.isEmpty(str) ? "" : getHostFromServer(getServerOfUrl(str));
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        return inetAddressNextElement.getHostAddress().toString();
                    }
                }
            }
            return "";
        } catch (SocketException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getMobileNetworkStandard(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null) {
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception e2) {
                e2.printStackTrace();
                connectivityManager = null;
            }
        } else {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return "unknown";
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
                return "wifi";
            }
            int networkType = getNetworkType(context, (TelephonyManager) context.getSystemService("phone"));
            switch (networkType) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                default:
                    break;
                case 17:
                    break;
            }
            return "unknown";
        }
    }

    public static String getMobileNetworkType(Context context) {
        return getNetworkType(context).equals("wifi") ? "" : getCurrentMobileNetworkType(context);
    }

    public static int getNetWorkType(Context context) {
        String networkType = getNetworkType(context);
        if (networkType.equals("wifi")) {
            return 2;
        }
        if (networkType.equals("2G")) {
            return 4;
        }
        return (networkType.equals("3G") || networkType.equals("4G")) ? 3 : 0;
    }

    public static int getNetWorkType4G(Context context) {
        String networkType = getNetworkType(context);
        if (networkType.equals("wifi")) {
            return 2;
        }
        if (networkType.equals("2G")) {
            return 4;
        }
        if (networkType.equals("3G")) {
            return 3;
        }
        return networkType.equals("4G") ? 1 : 0;
    }

    public static String getNetwork2gType(Context context) {
        return getNetworkType(context).equals("2G") ? getCurrentNet2GType(context) : "cmnet";
    }

    public static String getNetworkType(Context context) {
        return getNetworkType4G(context);
    }

    private static String getNetworkType4G(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null) {
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception e2) {
                e2.printStackTrace();
                connectivityManager = null;
            }
        } else {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return "unknown";
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
                return "wifi";
            }
            int networkType = getNetworkType(context, (TelephonyManager) context.getSystemService("phone"));
            return (networkType == 1 || networkType == 2 || networkType == 4 || networkType == 7 || networkType == 11) ? "2G" : (networkType == 13 || networkType == 18) ? "4G" : networkType != 20 ? "3G" : "5G";
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public static String getNetworkTypeForStatistics(Context context) {
        String networkType = getNetworkType(context);
        return "2G".equals(networkType) ? "1" : "wifi".equals(networkType) ? "2" : "3G".equals(networkType) ? "3" : "4G".equals(networkType) ? "4" : "5";
    }

    public static String getServerOfUrl(String str) {
        try {
            URI uri = new URI(str);
            int port = uri.getPort();
            if (port < 0) {
                return uri.getHost();
            }
            return uri.getHost() + ":" + port;
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static boolean isAvalidNetSetting(Context context) {
        return !"unknown".endsWith(getNetworkType(context));
    }

    public static boolean isCmwap(Context context) {
        return "cmwap".equals(getNetwork2gType(context));
    }

    private static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNetworkConected(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    private static boolean isSysStackFrame(String str) {
        return str.startsWith("java") || str.startsWith("android") || str.startsWith("org") || str.startsWith("dalvik") || str.startsWith("com.android");
    }

    public static boolean isWap(Context context) {
        return TextUtils.isEmpty(getMobileNetworkType(context)) ? APNManager.isWap(context) : !r0.toLowerCase(Locale.US).endsWith("net");
    }

    public static boolean isWifi(Context context) {
        return "wifi".equals(getNetworkType(context));
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        return (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }

    public static String removeLines(String str) {
        return str.replace("\r", "").replace("\n", "");
    }

    public static void settHashSuffix(String str) {
        tHashSuffix = str;
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.kugou.common.network.networkutils.KGNetworkUtil.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static long timeInUNIX(long j) {
        return new Date(j).getTime() / 1000;
    }

    public static String timeString(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.US).format(new Date(j));
    }

    public static String cutHTML(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strRemoveLines = removeLines(str);
        if (strRemoveLines.length() < i2) {
            return str;
        }
        return strRemoveLines.substring(0, i2) + "...";
    }

    public static int getNetworkType(Context context, TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return telephonyManager.getNetworkType();
            }
            if (KGPermission.uCantAskMePermissionState(context, Permission.READ_PHONE_STATE)) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
