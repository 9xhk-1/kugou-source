package com.kugou.common.network;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class IPUtil {
    public static boolean isIpV4Address(InetAddress inetAddress) {
        return inetAddress instanceof Inet4Address;
    }

    public static boolean isIpV6Address(InetAddress inetAddress) {
        return inetAddress instanceof Inet6Address;
    }

    public static List<InetAddress> sortAddress(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        try {
            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                if (isIpV4Address(inetAddress)) {
                    linkedBlockingQueue.add(inetAddress);
                } else if (isIpV6Address(inetAddress)) {
                    arrayList2.add(inetAddress);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add((InetAddress) it.next());
                InetAddress inetAddress2 = (InetAddress) linkedBlockingQueue.poll();
                if (inetAddress2 != null) {
                    arrayList.add(inetAddress2);
                }
            }
            if (linkedBlockingQueue.size() > 0) {
                ArrayList arrayList3 = new ArrayList();
                linkedBlockingQueue.drainTo(arrayList3);
                arrayList.addAll(arrayList3);
            }
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}
