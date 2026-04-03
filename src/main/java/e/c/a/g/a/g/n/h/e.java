package e.c.a.g.a.g.n.h;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean a(Context context, Uri uri, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = uri == null ? "" : uri.toString();
        try {
            String str2 = Build.BRAND;
            if (str2.equalsIgnoreCase("OPPO")) {
                Settings.System.putString(contentResolver, "oppo_sms_notification_sound", string);
                Settings.System.putString(contentResolver, "notification_sim2", string);
                return true;
            }
            if (str2.equalsIgnoreCase("Xiaomi")) {
                try {
                    Settings.System.putString(contentResolver, "sms_received_sound", string);
                    return true;
                } catch (Exception unused) {
                    Settings.System.putString(contentResolver, "mms_sound", string);
                    Settings.System.putString(contentResolver, "mms_sound_file_path", str);
                }
            }
            String str3 = Build.BRAND;
            if (str3.equalsIgnoreCase("Meizu")) {
                Settings.System.putString(contentResolver, "mms_sound", string);
                Settings.System.putString(contentResolver, "mms_sound_file_path", str);
            }
            if (str3.equalsIgnoreCase("nubia")) {
                Settings.System.putString(contentResolver, "card_one_message_sound", string);
            }
            if (str3.equalsIgnoreCase("samsung")) {
                Settings.System.putString(contentResolver, "notification_sound_2", string);
            }
            if (!str3.equalsIgnoreCase("vivo")) {
                return true;
            }
            Settings.System.putString(contentResolver, "message_sound", string);
            Settings.System.putString(contentResolver, "message_sound_sim2", string);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
