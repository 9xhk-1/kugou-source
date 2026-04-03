package com.kugou.common.datacollect.senter;

import com.kugou.android.watch.lite.common.INoGuard;

/* JADX INFO: loaded from: classes2.dex */
public class SensorInfo implements INoGuard {
    private static String[][] PREFIX = {new String[]{"ix", "iy", "iz"}, new String[]{"ax", "ay", "az"}};
    public boolean accelerometer;
    public String accelerometerValue;
    public boolean gravity;
    public String gravityValue;
    public boolean gyroscope;
    public String gyroscopeValue;
    public boolean light;
    public String lightValue;
    public boolean magnetic;
    public String magneticValue;
    public boolean orientation;
    public String orientationValue;
    public boolean pressure;
    public String pressureValue;
    public boolean step_counter;
    public String step_counterValue;
    public boolean temperature;
    public String temperatureValue;

    public String convertString(float[][] fArr) {
        if (fArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 < PREFIX.length) {
                for (int i3 = 0; i3 < fArr[i2].length; i3++) {
                    if (i3 < PREFIX[i2].length) {
                        sb.append("\"");
                        sb.append(PREFIX[i2][i3]);
                        sb.append("\"");
                        sb.append(":");
                        sb.append(fArr[i2][i3]);
                        sb.append(",");
                    }
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
