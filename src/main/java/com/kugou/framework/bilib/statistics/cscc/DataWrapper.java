package com.kugou.framework.bilib.statistics.cscc;

import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.bilib.common.SystemUtils;
import com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DataWrapper {
    public static final String MARK_END = "\r\n";
    public static final String MARK_SEPERATE = "\t";
    private static final int PROTOCOL_VERSION = 4;

    private static String getHeader(int i2) {
        StringBuilder sb = new StringBuilder();
        String uuid = CryptManager.getInstance().getUUID();
        String appId = LibConfig.getInstance().getAppId();
        boolean zIsGrayPackage = LibConfig.getInstance().isGrayPackage();
        String versionCode = LibConfig.getInstance().getVersionCode();
        String channelID = LibConfig.getInstance().getChannelID();
        String systemSDK = SystemUtils.getSystemSDK();
        String sysModel = SystemUtils.getSysModel();
        String mid = SystemUtils.getMid(LibConfig.getContext());
        String mid2 = SystemUtils.getMid(LibConfig.getContext());
        String usePatchCode = LibConfig.getInstance().getUsePatchCode();
        String allPluginDescription = LibConfig.getInstance().getAllPluginDescription();
        sb.append(4);
        sb.append(MARK_SEPERATE);
        sb.append(i2);
        sb.append(MARK_SEPERATE);
        sb.append(uuid);
        sb.append(MARK_SEPERATE);
        sb.append(zIsGrayPackage ? 1 : 0);
        sb.append(MARK_SEPERATE);
        sb.append(appId);
        sb.append(MARK_SEPERATE);
        sb.append(versionCode);
        sb.append(MARK_SEPERATE);
        sb.append(channelID);
        sb.append(MARK_SEPERATE);
        sb.append(systemSDK);
        sb.append(MARK_SEPERATE);
        sb.append(sysModel);
        sb.append(MARK_SEPERATE);
        sb.append(mid);
        sb.append(MARK_SEPERATE);
        sb.append(mid2);
        sb.append(MARK_SEPERATE);
        sb.append(usePatchCode);
        sb.append(MARK_SEPERATE);
        sb.append(allPluginDescription);
        sb.append("\r\n");
        return sb.toString();
    }

    public static byte[] wrapData(List<CsccEntity> list) {
        byte[] bytes = null;
        if (list == null) {
            return null;
        }
        try {
            bytes = getHeader(list.size()).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bytes);
            for (int i2 = 0; i2 < list.size(); i2++) {
                byte[] dataLine = list.get(i2).toDataLine();
                if (dataLine != null) {
                    byteArrayOutputStream.write(dataLine);
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
