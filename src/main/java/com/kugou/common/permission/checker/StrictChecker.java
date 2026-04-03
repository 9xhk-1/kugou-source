package com.kugou.common.permission.checker;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.kugou.common.permission.Permission;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class StrictChecker implements PermissionChecker {
    private static boolean checkAddVoicemail(Context context) throws Throwable {
        checkLog();
        return false;
    }

    private static boolean checkCamera(Context context) throws Throwable {
        return new CameraTest(context).test();
    }

    private static boolean checkCoarseLocation(Context context) throws Throwable {
        return new LocationCoarseTest(context).test();
    }

    private static boolean checkFineLocation(Context context) throws Throwable {
        return new LocationFineTest(context).test();
    }

    private static void checkLog() {
        Log.e("kg_permission", "请检查权限库");
    }

    private static boolean checkReadCalendar(Context context) throws Throwable {
        checkLog();
        return true;
    }

    private static boolean checkReadCallLog(Context context) throws Throwable {
        checkLog();
        return false;
    }

    private static boolean checkReadContacts(Context context) throws Throwable {
        return new ContactsReadTest(context).test();
    }

    private static boolean checkReadPhoneState(Context context) throws Throwable {
        return false;
    }

    private static boolean checkReadSms(Context context) throws Throwable {
        checkLog();
        return false;
    }

    private static boolean checkReadStorage() throws Throwable {
        return new StorageReadTest().test();
    }

    private static boolean checkRecordAudio(Context context) throws Throwable {
        return new RecordAudioTest(context).test();
    }

    private static boolean checkSensors(Context context) throws Throwable {
        checkLog();
        return false;
    }

    private static boolean checkSip(Context context) throws Throwable {
        checkLog();
        return false;
    }

    private static boolean checkWriteCalendar(Context context) throws Throwable {
        checkLog();
        return true;
    }

    private static boolean checkWriteCallLog(Context context) throws Throwable {
        checkLog();
        return false;
    }

    private static boolean checkWriteContacts(Context context) throws Throwable {
        checkLog();
        return false;
    }

    private static boolean checkWriteStorage() throws Throwable {
        return new StorageWriteTest().test();
    }

    @Override // com.kugou.common.permission.checker.PermissionChecker
    public boolean hasPermission(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String str : strArr) {
            if (!hasPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.kugou.common.permission.checker.PermissionChecker
    public boolean hasPermission(Context context, List<String> list) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!hasPermission(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private boolean hasPermission(Context context, String str) {
        byte b = -1;
        try {
            switch (str.hashCode()) {
                case -2062386608:
                    if (str.equals(Permission.READ_SMS)) {
                        b = 19;
                    }
                    break;
                case -1928411001:
                    if (str.equals(Permission.READ_CALENDAR)) {
                        b = 0;
                    }
                    break;
                case -1921431796:
                    if (str.equals(Permission.READ_CALL_LOG)) {
                        b = 11;
                    }
                    break;
                case -1888586689:
                    if (str.equals(Permission.ACCESS_FINE_LOCATION)) {
                        b = 7;
                    }
                    break;
                case -1479758289:
                    if (str.equals(Permission.RECEIVE_WAP_PUSH)) {
                        b = 20;
                    }
                    break;
                case -1238066820:
                    if (str.equals(Permission.BODY_SENSORS)) {
                        b = 16;
                    }
                    break;
                case -895679497:
                    if (str.equals(Permission.RECEIVE_MMS)) {
                        b = 18;
                    }
                    break;
                case -895673731:
                    if (str.equals(Permission.RECEIVE_SMS)) {
                        b = 21;
                    }
                    break;
                case -406040016:
                    if (str.equals(Permission.READ_EXTERNAL_STORAGE)) {
                        b = 22;
                    }
                    break;
                case -63024214:
                    if (str.equals(Permission.ACCESS_COARSE_LOCATION)) {
                        b = 6;
                    }
                    break;
                case -5573545:
                    if (str.equals(Permission.READ_PHONE_STATE)) {
                        b = 9;
                    }
                    break;
                case 52602690:
                    if (str.equals(Permission.SEND_SMS)) {
                        b = 17;
                    }
                    break;
                case 112197485:
                    if (str.equals(Permission.CALL_PHONE)) {
                        b = 10;
                    }
                    break;
                case 214526995:
                    if (str.equals(Permission.WRITE_CONTACTS)) {
                        b = 4;
                    }
                    break;
                case 463403621:
                    if (str.equals(Permission.CAMERA)) {
                        b = 2;
                    }
                    break;
                case 603653886:
                    if (str.equals(Permission.WRITE_CALENDAR)) {
                        b = 1;
                    }
                    break;
                case 610633091:
                    if (str.equals(Permission.WRITE_CALL_LOG)) {
                        b = 12;
                    }
                    break;
                case 784519842:
                    if (str.equals(Permission.USE_SIP)) {
                        b = 14;
                    }
                    break;
                case 952819282:
                    if (str.equals(Permission.PROCESS_OUTGOING_CALLS)) {
                        b = 15;
                    }
                    break;
                case 1271781903:
                    if (str.equals(Permission.GET_ACCOUNTS)) {
                        b = 5;
                    }
                    break;
                case 1365911975:
                    if (str.equals(Permission.WRITE_EXTERNAL_STORAGE)) {
                        b = 23;
                    }
                    break;
                case 1831139720:
                    if (str.equals(Permission.RECORD_AUDIO)) {
                        b = 8;
                    }
                    break;
                case 1977429404:
                    if (str.equals(Permission.READ_CONTACTS)) {
                        b = 3;
                    }
                    break;
                case 2133799037:
                    if (str.equals(Permission.ADD_VOICEMAIL)) {
                        b = 13;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    return checkReadCalendar(context);
                case 1:
                    return checkWriteCalendar(context);
                case 2:
                    return checkCamera(context);
                case 3:
                    return checkReadContacts(context);
                case 4:
                    return checkWriteContacts(context);
                case 5:
                case 10:
                case 15:
                case 17:
                case 18:
                case 20:
                case 21:
                default:
                    return true;
                case 6:
                    return checkCoarseLocation(context);
                case 7:
                    return checkFineLocation(context);
                case 8:
                    return checkRecordAudio(context);
                case 9:
                    return checkReadPhoneState(context);
                case 11:
                    return checkReadCallLog(context);
                case 12:
                    return checkWriteCallLog(context);
                case 13:
                    return checkAddVoicemail(context);
                case 14:
                    return checkSip(context);
                case 16:
                    return checkSensors(context);
                case 19:
                    return checkReadSms(context);
                case 22:
                    return checkReadStorage();
                case 23:
                    return checkWriteStorage();
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
