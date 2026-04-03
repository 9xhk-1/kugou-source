package com.kugou.common.network;

import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public class TrafficControl {
    private static final String KG_FRONT_MARK = "11259375";
    private CountdownHashSet<String> mForbidHost = new CountdownHashSet<>();

    public static class TrafficControlHolder {
        private static final TrafficControl INSTANCE = new TrafficControl();

        private TrafficControlHolder() {
        }
    }

    public static TrafficControl getInstance() {
        return TrafficControlHolder.INSTANCE;
    }

    public void addToBlacklist(String str, int i2) {
        this.mForbidHost.add(str, i2 * 1000);
    }

    public int getCoolDownTime(HttpResponse httpResponse) {
        Header[] headers = httpResponse.getHeaders("KG-NT");
        if (headers == null) {
            return 60;
        }
        int length = headers.length;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                return Math.max(Integer.parseInt(headers[i2].getValue()), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 60;
    }

    public boolean inBlacklist(String str) {
        return this.mForbidHost.contains(str);
    }

    public boolean isReturnByKGGateway(HttpResponse httpResponse) {
        Header[] headers = httpResponse.getHeaders("KG-FP");
        if (headers != null) {
            for (Header header : headers) {
                if (KG_FRONT_MARK.equals(header.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isReturnByKGGateway(Response response) {
        if (response == null) {
            return false;
        }
        return KG_FRONT_MARK.equals(response.header("KG-FP", ""));
    }

    public int getCoolDownTime(Response response) {
        try {
            return Math.max(Integer.parseInt(response.header("KG-NT", "60")), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 60;
        }
    }
}
