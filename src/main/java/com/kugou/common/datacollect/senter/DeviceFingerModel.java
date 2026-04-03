package com.kugou.common.datacollect.senter;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.common.utils.SecretAccess;
import e.c.a.g.a.f.d.a;
import e.c.a.g.a.f.m.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceFingerModel {
    public static final String TAG = "DeviceFingerModel";
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() { // from class: com.kugou.common.datacollect.senter.DeviceFingerModel.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                DeviceFingerModel.this.mDeviceFingerBean.batteryLevel = intent.getIntExtra("level", 0);
                DeviceFingerModel.this.mDeviceFingerBean.batteryStatus = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                a.h(this);
            }
        }
    };
    private DeviceFingerBean mDeviceFingerBean;
    private int prevScheme;

    public static class DeviceFingerBean extends SensorInfo implements INoGuard {
        public long availableRamSize;
        public int availableRomSize;
        public int availableSDSize;
        public String basebandVer;
        public int batteryLevel;
        public int batteryStatus;
        public String bluetoothAddress;
        public String bluetoothName;
        public String board;
        public String bootloader;
        public String brand;
        public String buildHost;
        public String buildId;
        public String buildModel;
        public String buildSerial;
        public String buildTags;
        public long buildTime;
        public String buildType;
        public String buildUser;
        public String channelID;
        public String cpuInfo;
        public String cpu_abi;
        public String cpu_abi2;
        public float density;
        public String device;
        public String deviceSoftwareVersion;
        public String display;
        public long elapsedRealTime;
        public boolean emulator;
        public String fingerPrint;
        public String hardware;
        public String imei;
        public String imsi;
        public String incremental;
        public String innerVer;
        public String inputMethodList;
        public String ipAddress;
        public String language;
        public String linuxCoreVer;
        public String mac;
        public String manufacturer;
        public int netWorkType;
        public String networkOperator;
        public String networkOperatorName;
        public int phoneType;
        public String product;
        public String radioVersion;
        public String release;
        public float scaledDensity;
        public int screenHeight;
        public int screenWidth;
        public int sdkInt;
        public String settingsSerial;
        public String simCountryIso;
        public String simOperator;
        public String simOperatorName;
        public String simSerialNumber;
        public int simState;
        public long totalRamSize;
        public int totalRomSize;
        public int totalSDSize;
        public String uuid;
        public float xdpi;
        public float ydpi;

        public String toString() {
            return "DeviceFingerBean{uuid='" + this.uuid + "', channelID='" + this.channelID + "', release='" + this.release + "', sdkInt=" + this.sdkInt + ", brand='" + this.brand + "', product='" + this.product + "', buildId='" + this.buildId + "', display='" + this.display + "', fingerPrint='" + this.fingerPrint + "', screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + ", xdpi=" + this.xdpi + ", ydpi=" + this.ydpi + ", density=" + this.density + ", scaledDensity=" + this.scaledDensity + ", imei='" + this.imei + "', imsi='" + this.imsi + "', networkOperator='" + this.networkOperator + "', simOperator='" + this.simOperator + "', phoneType=" + this.phoneType + ", simCountryIso='" + this.simCountryIso + "', simState=" + this.simState + ", netWorkType=" + this.netWorkType + ", mac='" + this.mac + "', accelerometer=" + this.accelerometer + ", accelerometerValue=" + this.accelerometerValue + ", temperature=" + this.temperature + ", temperatureValue=" + this.temperatureValue + ", gravity=" + this.gravity + ", gravityValue=" + this.gravityValue + ", gyroscope=" + this.gyroscope + ", gyroscopeValue=" + this.gyroscopeValue + ", light=" + this.light + ", lightValue=" + this.lightValue + ", magnetic=" + this.magnetic + ", magneticValue=" + this.magneticValue + ", pressure=" + this.pressure + ", pressureValue=" + this.pressureValue + ", orientation=" + this.orientation + ", orientationValue=" + this.orientationValue + ", step_counter=" + this.step_counter + ", step_counterValue=" + this.step_counterValue + ", buildModel='" + this.buildModel + "', manufacturer='" + this.manufacturer + "', device='" + this.device + "', hardware='" + this.hardware + "', buildType='" + this.buildType + "', buildTags='" + this.buildTags + "', buildHost='" + this.buildHost + "', buildUser='" + this.buildUser + "', incremental='" + this.incremental + "', board='" + this.board + "', bootloader='" + this.bootloader + "', buildTime=" + this.buildTime + ", cpu_abi='" + this.cpu_abi + "', cpu_abi2='" + this.cpu_abi2 + "', networkOperatorName='" + this.networkOperatorName + "', simOperatorName='" + this.simOperatorName + "', ipAddress=" + this.ipAddress + ", bluetoothName='" + this.bluetoothName + "', bluetoothAddress='" + this.bluetoothAddress + "', cpuInfo='" + this.cpuInfo + "', emulator=" + this.emulator + ", radioVersion='" + this.radioVersion + "', availableRamSize=" + this.availableRamSize + ", totalRamSize=" + this.totalRamSize + ", availableRomSize=" + this.availableRomSize + ", totalRomSize=" + this.totalRomSize + ", totalSDSize=" + this.totalSDSize + ", simSerialNumber='" + this.simSerialNumber + "', deviceSoftwareVersion='" + this.deviceSoftwareVersion + "', batteryLevel=" + this.batteryLevel + ", batteryStatus=" + this.batteryStatus + ", buildSerial='" + this.buildSerial + "', settingsSerial='" + this.settingsSerial + "', elapsedRealTime=" + this.elapsedRealTime + ", basebandVer='" + this.basebandVer + "', linuxCoreVer='" + this.linuxCoreVer + "', innerVer='" + this.innerVer + "', inputMethodList='" + this.inputMethodList + "', language='" + this.language + "'}";
        }
    }

    public static void buildBaseDeviceInfo() {
        try {
            if (TextUtils.isEmpty(b.m().g())) {
                Display defaultDisplay = ((WindowManager) KGApplication.getContext().getSystemService("window")).getDefaultDisplay();
                defaultDisplay.getRealSize(new Point());
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                float fSqrt = (float) Math.sqrt(Math.pow(r1.x / displayMetrics.xdpi, 2.0d) + Math.pow(r1.y / displayMetrics.ydpi, 2.0d));
                int i2 = displayMetrics.widthPixels;
                int i3 = displayMetrics.heightPixels;
                String str = supportARM64() ? "64" : "32";
                if (fSqrt <= 0.0f || i2 <= 0 || i3 <= 0 || TextUtils.isEmpty(str)) {
                    return;
                }
                b.m().M("size:" + i2 + "x" + i3 + ",physicsInches:" + String.format(Locale.getDefault(), "%.2f", Float.valueOf(fSqrt)) + ",cupArch:" + str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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

    @SuppressLint({"HardwareIds"})
    private void getBluetoothInfo() {
    }

    private void getDisplayMetricsInfo() {
        DisplayMetrics displayMetrics = KGApplication.getContext().getResources().getDisplayMetrics();
        DeviceFingerBean deviceFingerBean = this.mDeviceFingerBean;
        deviceFingerBean.density = displayMetrics.density;
        deviceFingerBean.scaledDensity = displayMetrics.scaledDensity;
        deviceFingerBean.screenWidth = displayMetrics.widthPixels;
        deviceFingerBean.screenHeight = displayMetrics.heightPixels;
        deviceFingerBean.xdpi = displayMetrics.xdpi;
        deviceFingerBean.ydpi = displayMetrics.ydpi;
    }

    private long getElapsedRealTime() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    private static String getInnerVer() {
        String str = Build.DISPLAY;
        return str.contains(Build.VERSION.INCREMENTAL) ? str : Build.VERSION.INCREMENTAL;
    }

    public static String getLauncherTag(Context context) {
        String str;
        try {
            str = context.getPackageManager().getApplicationInfo("com.jxw.launcher", 0).sourceDir;
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        return "Package: com.jxw.launcher, APK Path: " + str;
    }

    private static String getLinuxCoreVer() {
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec("cat /proc/version");
        } catch (IOException unused) {
            processExec = null;
        }
        if (processExec == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 8192);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                }
            } catch (IOException unused2) {
            }
            try {
                break;
            } catch (IndexOutOfBoundsException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        if (sb.toString().equals("")) {
            return "";
        }
        String strSubstring = sb.substring(sb.indexOf("version ") + 8);
        return strSubstring.substring(0, strSubstring.indexOf(" "));
    }

    private void getRAMInfo() {
        ActivityManager activityManager = (ActivityManager) KGApplication.getContext().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            try {
                activityManager.getMemoryInfo(memoryInfo);
                DeviceFingerBean deviceFingerBean = this.mDeviceFingerBean;
                deviceFingerBean.availableRamSize = memoryInfo.availMem;
                if (Build.VERSION.SDK_INT >= 16) {
                    deviceFingerBean.totalRamSize = memoryInfo.totalMem;
                }
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
        this.mDeviceFingerBean.totalRomSize = statFs.getBlockCount();
    }

    private void getSDInfo() {
    }

    private void getWifiInfo() {
        WifiInfo wifiConnectionInfo;
        try {
            wifiConnectionInfo = SecretAccess.getWifiConnectionInfo();
        } catch (Exception e2) {
            if (g0.a) {
                g0.c(TAG, e2.toString());
            }
            wifiConnectionInfo = null;
        }
        if (wifiConnectionInfo != null) {
            this.mDeviceFingerBean.ipAddress = Formatter.formatIpAddress(wifiConnectionInfo.getIpAddress());
        }
    }

    private int isEmulator() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.toLowerCase().contains("vbox") && !str.toLowerCase().contains("test-keys")) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !Build.SERIAL.equalsIgnoreCase("android") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT))) {
                return 0;
            }
        }
        return 1;
    }

    public static boolean supportARM64() {
        String[] strArr = Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        if (strArr == null) {
            strArr = new String[0];
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                String lowerCase = str.toLowerCase(Locale.ROOT);
                if ("arm64-v8a".equals(lowerCase) || "mips64".equals(lowerCase) || "x86_64".equals(lowerCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    private String[] supportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        String str = Build.CPU_ABI2;
        return !TextUtils.isEmpty(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    public void addParamsForDfid(HashMap<String, Object> map) {
        map.put("dfid", b.m().f());
        map.put("plat", 1);
    }

    public DeviceFingerBean getDeviceFingerBean(int i2) {
        DeviceFingerBean deviceFingerBean = this.mDeviceFingerBean;
        if (deviceFingerBean != null && this.prevScheme == i2) {
            return deviceFingerBean;
        }
        this.prevScheme = i2;
        DeviceFingerBean deviceFingerBean2 = new DeviceFingerBean();
        this.mDeviceFingerBean = deviceFingerBean2;
        deviceFingerBean2.uuid = m.i(false);
        this.mDeviceFingerBean.channelID = l1.j();
        DeviceFingerBean deviceFingerBean3 = this.mDeviceFingerBean;
        deviceFingerBean3.release = Build.VERSION.RELEASE;
        deviceFingerBean3.sdkInt = Build.VERSION.SDK_INT;
        deviceFingerBean3.brand = Build.BRAND;
        deviceFingerBean3.product = Build.PRODUCT;
        deviceFingerBean3.buildId = Build.ID;
        deviceFingerBean3.display = Build.DISPLAY;
        deviceFingerBean3.fingerPrint = Build.FINGERPRINT;
        deviceFingerBean3.buildModel = Build.MODEL;
        deviceFingerBean3.manufacturer = Build.MANUFACTURER;
        deviceFingerBean3.device = Build.DEVICE;
        deviceFingerBean3.hardware = Build.HARDWARE;
        deviceFingerBean3.buildType = Build.TYPE;
        deviceFingerBean3.buildTags = Build.TAGS;
        deviceFingerBean3.buildHost = Build.HOST;
        deviceFingerBean3.buildUser = Build.USER;
        deviceFingerBean3.buildSerial = Build.SERIAL;
        deviceFingerBean3.incremental = Build.VERSION.INCREMENTAL;
        deviceFingerBean3.board = Build.BOARD;
        deviceFingerBean3.bootloader = Build.BOOTLOADER;
        deviceFingerBean3.buildTime = Build.TIME;
        deviceFingerBean3.cpu_abi = Build.CPU_ABI;
        deviceFingerBean3.cpu_abi2 = Build.CPU_ABI2;
        deviceFingerBean3.cpuInfo = supportedAbis()[0];
        this.mDeviceFingerBean.radioVersion = Build.getRadioVersion();
        this.mDeviceFingerBean.imei = l1.l(KGApplication.getContext());
        this.mDeviceFingerBean.netWorkType = e.c.c.o.m.m(KGApplication.getContext());
        TelephonyManager telephonyManager = (TelephonyManager) KGApplication.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            this.mDeviceFingerBean.networkOperator = telephonyManager.getNetworkOperator();
            this.mDeviceFingerBean.networkOperatorName = telephonyManager.getNetworkOperatorName();
            this.mDeviceFingerBean.simOperator = telephonyManager.getSimOperator();
            this.mDeviceFingerBean.simOperatorName = telephonyManager.getSimOperatorName();
            this.mDeviceFingerBean.phoneType = telephonyManager.getPhoneType();
            this.mDeviceFingerBean.simCountryIso = telephonyManager.getSimCountryIso();
            this.mDeviceFingerBean.simState = telephonyManager.getSimState();
        }
        this.mDeviceFingerBean.emulator = isEmulator() > 0;
        this.mDeviceFingerBean.elapsedRealTime = getElapsedRealTime();
        this.mDeviceFingerBean.basebandVer = getBasebandVer();
        this.mDeviceFingerBean.linuxCoreVer = getLinuxCoreVer();
        this.mDeviceFingerBean.innerVer = getInnerVer();
        this.mDeviceFingerBean.inputMethodList = getInputMethodList();
        this.mDeviceFingerBean.language = Locale.getDefault().getLanguage();
        getBluetoothInfo();
        getDisplayMetricsInfo();
        getRAMInfo();
        getROMInfo();
        getSDInfo();
        getBatteryInfo();
        getWifiInfo();
        return this.mDeviceFingerBean;
    }

    public String getInputMethodList() {
        InputMethodManager inputMethodManager = (InputMethodManager) KGApplication.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            return "";
        }
        try {
            List<InputMethodInfo> inputMethodList = inputMethodManager.getInputMethodList();
            if (inputMethodList.size() <= 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<InputMethodInfo> it = inputMethodList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().loadLabel(KGApplication.getContext().getPackageManager()).toString());
            }
            return jSONArray.toString();
        } catch (Exception e2) {
            if (!g0.a) {
                return "";
            }
            g0.c(TAG, e2.toString());
            return "";
        }
    }
}
