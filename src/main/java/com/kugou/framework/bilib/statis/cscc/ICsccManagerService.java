package com.kugou.framework.bilib.statis.cscc;

import android.os.Binder;
import android.os.RemoteException;
import com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ICsccManagerService {

    public static abstract class Stub extends Binder implements ICsccManagerService {
    }

    boolean sendWithCscc(CsccEntity csccEntity, boolean z) throws RemoteException;

    boolean sendWithCsccsWithoutQueue(List<CsccEntity> list) throws RemoteException;
}
