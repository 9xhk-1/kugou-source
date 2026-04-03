package e.c.a.g.a.d.o.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {
    void addService(String str, IBinder iBinder, boolean z) throws RemoteException;

    void attachRemote(IBinder iBinder, boolean z) throws RemoteException;

    IBinder getService(String str, boolean z) throws RemoteException;

    IBinder getTwin(String str, boolean z) throws RemoteException;

    boolean isRemoteValidate() throws IllegalAccessException;

    void notifyServiceManuallyAdded(String[] strArr, boolean z) throws RemoteException;

    IBinder pickService(String str, boolean z) throws RemoteException;

    void setManuallyAddCallback(d dVar) throws IllegalAccessException;

    void setRemoteAttachStateCallback(e eVar) throws IllegalAccessException;
}
