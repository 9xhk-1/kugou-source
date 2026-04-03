package com.kugou.common.network;

import android.content.Context;
import java.util.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class NetModeControler extends Observable {
    public static String CMWAP_PROXY = "10.0.0.172";
    public static final int NETMODE_OFFLINE = 1;
    public static final int NETMODE_ONLINE = 0;
    public static final int NOTIFY_NETMODE_CHANGED = 2;
    private static NetModeControler mNetModeControler;
    private int netMode;

    public interface OfflineMode {
        boolean isOfflineMode(Context context);
    }

    public class StateObject {
        private Object data;
        private int notifyType;

        public StateObject() {
        }

        public Object getData() {
            return this.data;
        }

        public int getNotifyType() {
            return this.notifyType;
        }

        public void setData(Object obj) {
            this.data = obj;
        }

        public void setNotifyType(int i2) {
            this.notifyType = i2;
        }
    }

    private NetModeControler() {
    }

    public static synchronized NetModeControler getInstance() {
        if (mNetModeControler == null) {
            mNetModeControler = new NetModeControler();
        }
        return mNetModeControler;
    }

    private void setNetMode(int i2) {
        if (this.netMode != i2) {
            this.netMode = i2;
            setChanged();
            StateObject stateObject = new StateObject();
            stateObject.setNotifyType(2);
            stateObject.setData(Integer.valueOf(i2));
            notifyObservers(stateObject);
        }
    }

    public boolean isOnLine() {
        return this.netMode == 0;
    }

    public void refreshNetMode(boolean z) {
        setNetMode(z ? 1 : 0);
    }
}
