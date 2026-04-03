package com.kugou.framework.libcommon;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.kugou.framework.bilib.common.LibConfig;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkUtils {
    private NetworkUtils() {
    }

    private static ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) LibConfig.getContext().getSystemService("connectivity");
    }

    public static String getNetworkType(Context context) {
        return getNetworkType4G(context);
    }

    public static String getNetworkType4G(Context context) {
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
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                int networkType = 0;
                try {
                    networkType = telephonyManager.getNetworkType();
                } catch (Exception unused) {
                }
                if (networkType != 17) {
                    if (networkType == 20) {
                        return "5G";
                    }
                    switch (networkType) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            break;
                        case 13:
                            break;
                        default:
                            Log.d("kugou", "getNetworkType returns a unknown value:" + networkType);
                            break;
                    }
                    return "unknown";
                }
            }
            return "3G";
        }
    }

    public static boolean isAvalidNetSetting(Context context) {
        return isNetworkConected(context);
    }

    public static boolean isNetworkConected(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
