package com.kugou.common.datacollect.senter;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.common.utils.SecretAccess;
import e.c.a.g.a.f.d.a;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;

/* JADX INFO: loaded from: classes2.dex */
public class SmallDeviceFingerModel {
    public static final String TAG = "SmallDeviceFingerModel";
    private static volatile SmallDeviceFingerModel instance;
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() { // from class: com.kugou.common.datacollect.senter.SmallDeviceFingerModel.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                SmallDeviceFingerModel.this.mDeviceFingerBean.batteryLevel = intent.getIntExtra("level", 0);
                SmallDeviceFingerModel.this.mDeviceFingerBean.batteryStatus = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                a.h(this);
            }
        }
    };
    private SmallDeviceFingerBean mDeviceFingerBean;

    public static class SmallDeviceFingerBean extends SensorInfo implements INoGuard {
        public long availableRamSize;
        public int availableRomSize;
        public String basebandVer;
        public int batteryLevel;
        public int batteryStatus;
        public String brand;
        public String buildSerial;
        public String device;
        public String imei;
        public String imsi;
        public String mac;
        public String manufacturer;
        public String simSerialNumber;
        public String uuid;

        public String toString() {
            return "SmallDeviceFingerBean{uuid='" + this.uuid + "', brand='" + this.brand + "', imei='" + this.imei + "', imsi='" + this.imsi + "', mac='" + this.mac + "', accelerometer=" + this.accelerometer + ", accelerometerValue=" + this.accelerometerValue + ", temperature=" + this.temperature + ", temperatureValue=" + this.temperatureValue + ", gravity=" + this.gravity + ", gravityValue=" + this.gravityValue + ", gyroscope=" + this.gyroscope + ", gyroscopeValue=" + this.gyroscopeValue + ", light=" + this.light + ", lightValue=" + this.lightValue + ", magnetic=" + this.magnetic + ", magneticValue=" + this.magneticValue + ", pressure=" + this.pressure + ", pressureValue=" + this.pressureValue + ", orientation=" + this.orientation + ", orientationValue=" + this.orientationValue + ", step_counter=" + this.step_counter + ", step_counterValue=" + this.step_counterValue + ", manufacturer='" + this.manufacturer + "', device='" + this.device + "', availableRamSize=" + this.availableRamSize + ", availableRomSize=" + this.availableRomSize + ", simSerialNumber='" + this.simSerialNumber + "', batteryLevel=" + this.batteryLevel + ", batteryStatus=" + this.batteryStatus + ", buildSerial='" + this.buildSerial + "', basebandVer='" + this.basebandVer + "'}";
        }
    }

    private SmallDeviceFingerModel() {
    }

    private static String getBasebandVer() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Exception unused) {
            return "";
        }
    }

    private void getBatteryInfo() {
        a.c(this.mBatInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    private void getBluetoothInfo() {
    }

    private void getRAMInfo() {
        ActivityManager activityManager = (ActivityManager) KGApplication.getContext().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            try {
                activityManager.getMemoryInfo(memoryInfo);
                this.mDeviceFingerBean.availableRamSize = memoryInfo.availMem;
            } catch (Exception e2) {
                if (g0.a) {
                    g0.c(TAG, e2.toString());
                }
            }
        }
    }

    private void getROMInfo() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        this.mDeviceFingerBean.availableRomSize = statFs.getAvailableBlocks();
    }

    private void getSDInfo() {
    }

    private void getWifiInfo() {
    }

    public static SmallDeviceFingerModel init() {
        if (instance == null) {
            synchronized (SmallDeviceFingerModel.class) {
                if (instance == null) {
                    instance = new SmallDeviceFingerModel();
                }
            }
        }
        return instance;
    }

    public SmallDeviceFingerBean getDeviceFingerBean() {
        SmallDeviceFingerBean smallDeviceFingerBean = this.mDeviceFingerBean;
        if (smallDeviceFingerBean != null) {
            return smallDeviceFingerBean;
        }
        SmallDeviceFingerBean smallDeviceFingerBean2 = new SmallDeviceFingerBean();
        this.mDeviceFingerBean = smallDeviceFingerBean2;
        smallDeviceFingerBean2.uuid = m.i(false);
        this.mDeviceFingerBean.imei = l1.t(true).a;
        this.mDeviceFingerBean.basebandVer = getBasebandVer();
        SmallDeviceFingerBean smallDeviceFingerBean3 = this.mDeviceFingerBean;
        smallDeviceFingerBean3.buildSerial = Build.SERIAL;
        smallDeviceFingerBean3.brand = Build.BRAND;
        smallDeviceFingerBean3.device = Build.DEVICE;
        smallDeviceFingerBean3.manufacturer = Build.MANUFACTURER;
        smallDeviceFingerBean3.mac = SecretAccess.DEFAULT_MAC_ADDRESS;
        getBluetoothInfo();
        getWifiInfo();
        getRAMInfo();
        getROMInfo();
        getSDInfo();
        getBatteryInfo();
        return this.mDeviceFingerBean;
    }
}
