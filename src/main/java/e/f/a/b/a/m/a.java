package e.f.a.b.a.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a(Context context) {
        TelephonyManager telephonyManager;
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() != 1) {
                if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    int networkType = telephonyManager.getNetworkType();
                    switch (networkType) {
                        case 1:
                            str = "GPRS";
                            break;
                        case 2:
                            str = "EDGE";
                            break;
                        case 3:
                            str = "UMTS";
                            break;
                        case 4:
                            str = "CDMA";
                            break;
                        case 5:
                            str = "EVDO_0";
                            break;
                        case 6:
                            str = "EVDO_A";
                            break;
                        case 7:
                            str = "1xRTT";
                            break;
                        case 8:
                            str = "HSDPA";
                            break;
                        case 9:
                            str = "HSUPA";
                            break;
                        case 10:
                            str = "HSPA";
                            break;
                        case 11:
                            str = "iDen";
                            break;
                        case 12:
                            str = "EVDO_B";
                            break;
                        case 13:
                            str = "LTE";
                            break;
                        case 14:
                            str = "eHRPD";
                            break;
                        case 15:
                            str = "HSPA+";
                            break;
                        default:
                            str = "MOBILE(" + networkType + ")";
                            break;
                    }
                } else {
                    return "unknown";
                }
            } else {
                str = "WIFI";
            }
            return str;
        } catch (Exception e2) {
            e.f.a.b.a.c.b("DeviceInfo", "[getBrand] err=", e2);
            return "unknown";
        }
    }
}
