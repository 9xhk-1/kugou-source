package com.kugou.framework.bilib.statistics.cscc;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.kugou.framework.bilib.LibLog;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.bilib.statis.cscc.ICsccManagerService;
import com.kugou.framework.bilib.statistics.StatisManager;
import com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity;
import com.kugou.framework.bilib.statistics.cscc.protocol.CsccPostProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class CsccManager extends ICsccManagerService.Stub {
    private static long EXECUTE_DELAY_MILLIES = 60000;
    private static final int MAX_COUNT = 50;
    private static final int MSG_APMCHANNEL_EXECUTE = 1004;
    private static final int MSG_DCHANNEL_EXECUTE = 1003;
    private static final int MSG_EXECUTE = 1001;
    private static final int MSG_REGEN = 1002;
    private static final long REGEN_DELAY_MILLIES = 13200000;
    private static volatile CsccManager sCsccManager;
    private CryptManager mCryptManager;
    private WorkHandler mWorkHandler;
    private long mFirstPostTime = 0;
    private long mLastPostDone = 0;
    private Queue<CsccEntity> mCsccQueue = new ConcurrentLinkedQueue();
    private Queue<CsccEntity> mAPMQueue = new ConcurrentLinkedQueue();
    private Queue<CsccEntity> mAPMNetQualityQueue = new ConcurrentLinkedQueue();
    private Queue<CsccEntity> mAPMNetMonitorQueue = new ConcurrentLinkedQueue();

    public static class WorkHandler extends Handler {
        public WorkHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    CsccManager unused = CsccManager.sCsccManager;
                    break;
                case 1002:
                    removeMessages(1002);
                    sendEmptyMessageDelayed(1002, CsccManager.REGEN_DELAY_MILLIES);
                    if (CsccManager.sCsccManager != null && CsccManager.sCsccManager.mCryptManager != null) {
                        CsccManager.sCsccManager.mCryptManager.updateDynamicKey();
                        break;
                    }
                    break;
                case 1003:
                case 1004:
                    if (CsccManager.sCsccManager != null) {
                        CsccManager.sCsccManager.execute(message.arg1);
                    }
                    break;
            }
        }
    }

    private CsccManager() {
        HandlerThread handlerThread = new HandlerThread("CsccManager");
        handlerThread.start();
        this.mWorkHandler = new WorkHandler(handlerThread.getLooper());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity> dequeue(int r4) {
        /*
            r3 = this;
            java.util.Queue<com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity> r0 = r3.mCsccQueue
            monitor-enter(r0)
            if (r4 == 0) goto L38
            r1 = 1
            if (r4 == r1) goto L9
            goto L55
        L9:
            java.util.Queue<com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity> r4 = r3.mAPMQueue     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L55
            int r1 = r4.size()     // Catch: java.lang.Throwable -> L58
            if (r1 <= 0) goto L55
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L58
            r1.<init>()     // Catch: java.lang.Throwable -> L58
        L18:
            int r2 = r4.size()     // Catch: java.lang.Throwable -> L58
            if (r2 <= 0) goto L26
            java.lang.Object r2 = r4.poll()     // Catch: java.lang.Throwable -> L58
            r1.add(r2)     // Catch: java.lang.Throwable -> L58
            goto L18
        L26:
            java.util.Queue<com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity> r4 = r3.mAPMNetQualityQueue     // Catch: java.lang.Throwable -> L58
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L58
            if (r4 <= 0) goto L56
            java.util.Queue<com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity> r4 = r3.mAPMNetQualityQueue     // Catch: java.lang.Throwable -> L58
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L58
            r1.add(r4)     // Catch: java.lang.Throwable -> L58
            goto L26
        L38:
            java.util.Queue<com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity> r4 = r3.mCsccQueue     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L55
            int r1 = r4.size()     // Catch: java.lang.Throwable -> L58
            if (r1 <= 0) goto L55
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L58
            r1.<init>()     // Catch: java.lang.Throwable -> L58
        L47:
            int r2 = r4.size()     // Catch: java.lang.Throwable -> L58
            if (r2 <= 0) goto L56
            java.lang.Object r2 = r4.poll()     // Catch: java.lang.Throwable -> L58
            r1.add(r2)     // Catch: java.lang.Throwable -> L58
            goto L47
        L55:
            r1 = 0
        L56:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L58
            return r1
        L58:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L58
            goto L5c
        L5b:
            throw r4
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.bilib.statistics.cscc.CsccManager.dequeue(int):java.util.List");
    }

    private List<CsccEntity> dequeueNetMonitor() {
        ArrayList arrayList = new ArrayList();
        while (this.mAPMNetMonitorQueue.size() > 0) {
            arrayList.add(this.mAPMNetMonitorQueue.poll());
        }
        if (LibLog.DEBUG) {
            LibLog.i("NetMonitor", "dequeSize: " + arrayList.size());
        }
        return arrayList;
    }

    private CsccPostProtocol.CsccPostEntity doPost(byte[] bArr, CsccPostProtocol.CsccPostEntity csccPostEntity, int i2, boolean z, boolean z2, boolean z3) {
        long j;
        boolean zUpdateDynamicKey;
        long j2 = csccPostEntity == null ? 0L : this.mFirstPostTime;
        if (csccPostEntity != null && csccPostEntity.errCode == 1203) {
            j2 = 0;
        }
        if (csccPostEntity == null || !csccPostEntity.shouldReGen()) {
            j = j2;
            zUpdateDynamicKey = true;
        } else {
            zUpdateDynamicKey = this.mCryptManager.updateDynamicKey();
            this.mWorkHandler.sendEmptyMessageDelayed(1002, REGEN_DELAY_MILLIES);
            j = 0;
        }
        if (!zUpdateDynamicKey) {
            if (LibLog.DEBUG) {
                LibLog.e("BLUE", "regen failed");
            }
            return null;
        }
        long jMaySendTime = maySendTime(this.mCryptManager.getAdjustedTime(), this.mLastPostDone, !z2);
        CsccPostProtocol.CsccPostEntity csccPostEntityPostData = new CsccPostProtocol().postData(bArr, true, jMaySendTime, j, i2, z, z3);
        if (j == 0) {
            this.mFirstPostTime = jMaySendTime;
        }
        this.mLastPostDone = jMaySendTime;
        return csccPostEntityPostData;
    }

    private void enqueue(CsccEntity csccEntity) {
        synchronized (this.mCsccQueue) {
            if (csccEntity != null) {
                if (csccEntity.getDomainType() != 1) {
                    this.mCsccQueue.add(csccEntity);
                    if (LibLog.DEBUG) {
                        LibLog.e("BLUE", "enqueue +1 , current size is " + this.mCsccQueue.size());
                    }
                } else if (csccEntity.getConfigId() == 14) {
                    this.mAPMNetQualityQueue.add(csccEntity);
                } else if (csccEntity.getConfigId() == 26) {
                    this.mAPMNetMonitorQueue.add(csccEntity);
                } else {
                    this.mAPMQueue.add(csccEntity);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean execute(int i2) {
        boolean zStartExecute;
        synchronized (this) {
            Message messageObtain = Message.obtain();
            messageObtain.arg1 = i2;
            if (i2 == 1) {
                messageObtain.what = 1004;
            } else if (i2 == 0) {
                messageObtain.what = 1003;
            }
            this.mWorkHandler.removeMessages(messageObtain.what);
            this.mWorkHandler.sendMessageDelayed(messageObtain, EXECUTE_DELAY_MILLIES);
            zStartExecute = startExecute(dequeue(i2), false, true);
            if (i2 == 1) {
                startExecute(dequeueNetMonitor(), false, true, true);
            }
        }
        return zStartExecute;
    }

    public static CsccManager getInstance() {
        if (sCsccManager == null) {
            synchronized (CsccManager.class) {
                if (sCsccManager == null) {
                    EXECUTE_DELAY_MILLIES = LibLog.DEBUG ? 500L : 60000L;
                    sCsccManager = new CsccManager();
                }
            }
        }
        return sCsccManager;
    }

    private long maySendTime(long j, long j2, boolean z) {
        if (j - j2 > 1) {
            return j;
        }
        if (!z) {
            return j2 + 1;
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return j + 1;
    }

    private void notifyAllFailed(List<CsccEntity> list, String str) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<CsccEntity> it = list.iterator();
        while (it.hasNext()) {
            it.next().notifyFailed(str);
        }
    }

    private synchronized void notifyAllSave(List<CsccEntity> list) {
        Iterator<CsccEntity> it = list.iterator();
        while (it.hasNext()) {
            try {
                StatisManager.getInstance().save(CsccEntity.getParamJson(it.next()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void reEnqueue(List<CsccEntity> list) {
        synchronized (this.mCsccQueue) {
            if (list != null) {
                List<CsccEntity> listDequeue = dequeue(0);
                this.mCsccQueue.addAll(list);
                if (listDequeue != null) {
                    this.mCsccQueue.addAll(listDequeue);
                }
            }
        }
    }

    private boolean startExecute(List<CsccEntity> list, boolean z, boolean z2) {
        return startExecute(list, z, z2, false);
    }

    public void sendAllInstantWithCscc(CsccEntity csccEntity, boolean z, boolean z2, boolean z3) {
        enqueue(csccEntity);
        synchronized (CsccManager.class) {
            if (z) {
                startExecute(dequeue(1), z2, z3);
                startExecute(dequeue(0), z2, z3);
            } else {
                startExecute(dequeue(0), z2, z3);
                startExecute(dequeue(1), z2, z3);
            }
        }
    }

    @Override // com.kugou.framework.bilib.statis.cscc.ICsccManagerService
    public boolean sendWithCscc(CsccEntity csccEntity, boolean z) {
        enqueue(csccEntity);
        Message messageObtain = Message.obtain();
        int domainType = csccEntity.getDomainType();
        messageObtain.arg1 = domainType;
        if (z) {
            return execute(domainType);
        }
        int domainType2 = csccEntity.getDomainType();
        if (domainType2 == 0) {
            messageObtain.what = 1003;
            this.mWorkHandler.sendMessageDelayed(messageObtain, LibConfig.getInstance().getMsgDelay());
        } else if (domainType2 == 1) {
            messageObtain.what = 1004;
            if (this.mAPMQueue.size() >= 10) {
                this.mWorkHandler.sendMessage(messageObtain);
            } else {
                this.mWorkHandler.sendMessageDelayed(messageObtain, LibConfig.getInstance().getMsgDelay());
            }
        }
        return true;
    }

    @Override // com.kugou.framework.bilib.statis.cscc.ICsccManagerService
    public boolean sendWithCsccsWithoutQueue(List<CsccEntity> list) {
        return startExecute(list, true, false, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0127, code lost:
    
        r20 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean startExecute(java.util.List<com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity> r22, boolean r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.bilib.statistics.cscc.CsccManager.startExecute(java.util.List, boolean, boolean, boolean):boolean");
    }
}
