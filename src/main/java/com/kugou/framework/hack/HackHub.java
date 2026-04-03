package com.kugou.framework.hack;

import android.database.Cursor;
import android.net.wifi.WifiInfo;
import android.support.annotation.Nullable;
import android.util.Log;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HackHub {
    private static final String TAG = "Hack.Hub";

    public static class ActivityManager extends WhatNameGood<Callback, Object> {

        public interface Callback {
            void onStartActivity(Object[] objArr);
        }

        public ActivityManager() {
            super();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void care(Callback callback) {
            super.care(callback);
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ Object getDecision() {
            return super.getDecision();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void ignore(Callback callback) {
            super.ignore(callback);
        }

        public final void notifyStartActivity(Object[] objArr) {
            Log.e(HackHub.TAG, "am.startActivity, args = " + Arrays.deepToString(objArr));
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks == null || objArr == null) {
                return;
            }
            for (Object obj : objArrCollectCallbacks) {
                ((Callback) obj).onStartActivity(objArr);
            }
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void setDecision(Object obj) {
            super.setDecision(obj);
        }
    }

    public static class ActivityManagerHolder {
        public static final ActivityManager activityManager = new ActivityManager();

        private ActivityManagerHolder() {
        }
    }

    public static class Camera extends WhatNameGood<Provider.Callback, Object> {

        public interface Callback {
            void onAudio();

            void onCamera();
        }

        public Camera() {
            super();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void care(Provider.Callback callback) {
            super.care(callback);
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ Object getDecision() {
            return super.getDecision();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void ignore(Provider.Callback callback) {
            super.ignore(callback);
        }

        public final void notifyAudio() {
            Log.e(HackHub.TAG, "camera.notifyAudio");
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onAudio();
                }
            }
        }

        public final void notifyCamera() {
            Log.e(HackHub.TAG, "camera.notifyCamera");
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onCamera();
                }
            }
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void setDecision(Object obj) {
            super.setDecision(obj);
        }
    }

    public static class CameraHolder {
        public static final Camera camera = new Camera();

        private CameraHolder() {
        }
    }

    public static class File extends WhatNameGood<Callback, Object> {

        public interface Callback {
            void onFileCreate(String str);

            void onFileDelete(String str);
        }

        public File() {
            super();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void care(Callback callback) {
            super.care(callback);
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ Object getDecision() {
            return super.getDecision();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void ignore(Callback callback) {
            super.ignore(callback);
        }

        public final void notifyCreate(String str) {
            Log.e(HackHub.TAG, "file.create, name = " + str);
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onFileCreate(str);
                }
            }
        }

        public final void notifyDelete(String str) {
            Log.e(HackHub.TAG, "file.remove, name = " + str);
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onFileDelete(str);
                }
            }
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void setDecision(Object obj) {
            super.setDecision(obj);
        }
    }

    public static class FileHolder {
        public static final File file = new File();

        private FileHolder() {
        }
    }

    public static class Location extends WhatNameGood<Callback, Object> {

        public interface Callback {
            void onOperateLocation();
        }

        public Location() {
            super();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void care(Callback callback) {
            super.care(callback);
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ Object getDecision() {
            return super.getDecision();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void ignore(Callback callback) {
            super.ignore(callback);
        }

        public final void notifyOperateLocation() {
            Log.e(HackHub.TAG, "location.operate");
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onOperateLocation();
                }
            }
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void setDecision(Object obj) {
            super.setDecision(obj);
        }
    }

    public static class LocationHolder {
        public static final Location location = new Location();

        private LocationHolder() {
        }
    }

    public static class Net extends WhatNameGood<Callback, Object> {

        public interface Callback {
            void onNetConnect(@Nullable InetAddress inetAddress);
        }

        public Net() {
            super();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void care(Callback callback) {
            super.care(callback);
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ Object getDecision() {
            return super.getDecision();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void ignore(Callback callback) {
            super.ignore(callback);
        }

        public final void notifyConnect(@Nullable InetAddress inetAddress) {
            Log.e(HackHub.TAG, "net.connect = I'm afraid to call its toString()");
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onNetConnect(inetAddress);
                }
            }
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void setDecision(Object obj) {
            super.setDecision(obj);
        }
    }

    public static class NetHolder {
        public static final Net net = new Net();

        private NetHolder() {
        }
    }

    public static class Package extends WhatNameGood<Callback, Decision> {

        public interface Callback {
            void onGetInstalledApplications(boolean z);

            void onGetInstalledPackages(boolean z);
        }

        public interface Decision {
            Reply<?> getInstalledApplications();

            Reply<?> getInstalledPackages();
        }

        public Package() {
            super();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void care(Callback callback) {
            super.care(callback);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.kugou.framework.hack.HackHub$Package$Decision, java.lang.Object] */
        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ Decision getDecision() {
            return super.getDecision();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void ignore(Callback callback) {
            super.ignore(callback);
        }

        public final Reply<?> notifyGetInstalledApplications() {
            Log.e(HackHub.TAG, "pm.getInstalledApplications");
            Decision decision = (Decision) getDecision();
            Reply<?> installedApplications = decision != null ? decision.getInstalledApplications() : null;
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onGetInstalledApplications(installedApplications != null && installedApplications.handled);
                }
            }
            return installedApplications;
        }

        public final Reply<?> notifyGetInstalledPackages() {
            Log.e(HackHub.TAG, "pm.getInstalledPackages");
            Decision decision = (Decision) getDecision();
            Reply<?> installedPackages = decision != null ? decision.getInstalledPackages() : null;
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onGetInstalledPackages(installedPackages != null && installedPackages.handled);
                }
            }
            return installedPackages;
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void setDecision(Decision decision) {
            super.setDecision(decision);
        }
    }

    public static class PackageHolder {
        public static final Package pkg = new Package();

        private PackageHolder() {
        }
    }

    public static class PhoneHolder {
        public static final Phone phone = new Phone();

        private PhoneHolder() {
        }
    }

    public static class Provider extends WhatNameGood<Callback, Decision> {

        public interface Callback {
            void onQuery(String str, boolean z);
        }

        public interface Decision {
            Reply<Cursor> query(String str, Object[] objArr);
        }

        public Provider() {
            super();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void care(Callback callback) {
            super.care(callback);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.kugou.framework.hack.HackHub$Provider$Decision, java.lang.Object] */
        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ Decision getDecision() {
            return super.getDecision();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void ignore(Callback callback) {
            super.ignore(callback);
        }

        public final Reply<Cursor> notifyQuery(String str, Object[] objArr) {
            Log.e(HackHub.TAG, "provider.query, name = " + str);
            Decision decision = (Decision) getDecision();
            Reply<Cursor> replyQuery = decision != null ? decision.query(str, objArr) : null;
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onQuery(str, replyQuery != null && replyQuery.handled);
                }
            }
            return replyQuery;
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void setDecision(Decision decision) {
            super.setDecision(decision);
        }
    }

    public static class ProviderHolder {
        public static final Provider provider = new Provider();

        private ProviderHolder() {
        }
    }

    public static class Reply<T> {
        public final boolean handled;
        public final T result;

        public Reply(boolean z, T t) {
            this.handled = z;
            this.result = t;
        }
    }

    public static class UnionDecision implements Phone.Decision, Package.Decision, Provider.Decision, Wifi.Decision {
        @Override // com.kugou.framework.hack.HackHub.Phone.Decision
        public Reply<String> getDeviceId() {
            return null;
        }

        @Override // com.kugou.framework.hack.HackHub.Phone.Decision
        public Reply<String> getDeviceId(int i2) {
            return null;
        }

        @Override // com.kugou.framework.hack.HackHub.Phone.Decision
        public Reply<String> getImei(int i2) {
            return null;
        }

        @Override // com.kugou.framework.hack.HackHub.Package.Decision
        public Reply<?> getInstalledApplications() {
            return null;
        }

        @Override // com.kugou.framework.hack.HackHub.Package.Decision
        public Reply<?> getInstalledPackages() {
            return null;
        }

        @Override // com.kugou.framework.hack.HackHub.Phone.Decision
        public Reply<String> getMeid(int i2) {
            return null;
        }

        @Override // com.kugou.framework.hack.HackHub.Wifi.Decision
        public Reply<WifiInfo> getWifiInfo() {
            return null;
        }

        @Override // com.kugou.framework.hack.HackHub.Provider.Decision
        public Reply<Cursor> query(String str, Object[] objArr) {
            return null;
        }
    }

    public static class UnionMonitor implements File.Callback, Net.Callback, Package.Callback, Phone.Callback, ActivityManager.Callback, Provider.Callback, Camera.Callback, Location.Callback, Wifi.Callback {
        @Override // com.kugou.framework.hack.HackHub.Camera.Callback
        public void onAudio() {
        }

        @Override // com.kugou.framework.hack.HackHub.Camera.Callback
        public void onCamera() {
        }

        @Override // com.kugou.framework.hack.HackHub.File.Callback
        public void onFileCreate(String str) {
        }

        @Override // com.kugou.framework.hack.HackHub.File.Callback
        public void onFileDelete(String str) {
        }

        @Override // com.kugou.framework.hack.HackHub.Phone.Callback
        public void onGetDeviceId0(boolean z) {
        }

        @Override // com.kugou.framework.hack.HackHub.Phone.Callback
        public void onGetDeviceId1(boolean z) {
        }

        @Override // com.kugou.framework.hack.HackHub.Phone.Callback
        public void onGetImei(boolean z) {
        }

        @Override // com.kugou.framework.hack.HackHub.Package.Callback
        public void onGetInstalledApplications(boolean z) {
        }

        @Override // com.kugou.framework.hack.HackHub.Package.Callback
        public void onGetInstalledPackages(boolean z) {
        }

        @Override // com.kugou.framework.hack.HackHub.Phone.Callback
        public void onGetMeid(boolean z) {
        }

        @Override // com.kugou.framework.hack.HackHub.Wifi.Callback
        public void onGetWifiInfo(boolean z) {
        }

        @Override // com.kugou.framework.hack.HackHub.Net.Callback
        public void onNetConnect(@Nullable InetAddress inetAddress) {
        }

        @Override // com.kugou.framework.hack.HackHub.Location.Callback
        public void onOperateLocation() {
        }

        @Override // com.kugou.framework.hack.HackHub.Provider.Callback
        public void onQuery(String str, boolean z) {
        }

        @Override // com.kugou.framework.hack.HackHub.ActivityManager.Callback
        public void onStartActivity(Object[] objArr) {
        }
    }

    public static abstract class WhatNameGood<T, D> {
        private volatile D decision;
        public final List<T> listeners;

        private WhatNameGood() {
            this.listeners = new ArrayList();
        }

        public void care(T t) {
            synchronized (this.listeners) {
                if (!this.listeners.contains(t)) {
                    this.listeners.add(t);
                }
            }
        }

        public Object[] collectCallbacks() {
            Object[] array;
            synchronized (this.listeners) {
                array = this.listeners.size() > 0 ? this.listeners.toArray() : null;
            }
            return array;
        }

        public D getDecision() {
            return this.decision;
        }

        public void ignore(T t) {
            synchronized (this.listeners) {
                if (this.listeners.contains(t)) {
                    this.listeners.remove(t);
                }
            }
        }

        public void setDecision(D d2) {
            this.decision = d2;
        }
    }

    public static class Wifi extends WhatNameGood<Callback, Decision> {

        public interface Callback {
            void onGetWifiInfo(boolean z);
        }

        public interface Decision {
            Reply<WifiInfo> getWifiInfo();
        }

        public Wifi() {
            super();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void care(Callback callback) {
            super.care(callback);
        }

        public final Reply<WifiInfo> execGetConnectionInfo() {
            Log.e(HackHub.TAG, "wifi.getConnectionInfo");
            Decision decision = (Decision) getDecision();
            Reply<WifiInfo> wifiInfo = decision != null ? decision.getWifiInfo() : null;
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onGetWifiInfo(wifiInfo != null && wifiInfo.handled);
                }
            }
            return wifiInfo;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.kugou.framework.hack.HackHub$Wifi$Decision, java.lang.Object] */
        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ Decision getDecision() {
            return super.getDecision();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void ignore(Callback callback) {
            super.ignore(callback);
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void setDecision(Decision decision) {
            super.setDecision(decision);
        }
    }

    public static class WifiHolder {
        public static final Wifi wifi = new Wifi();

        private WifiHolder() {
        }
    }

    public static ActivityManager am() {
        return ActivityManagerHolder.activityManager;
    }

    public static Camera camera() {
        return CameraHolder.camera;
    }

    public static File file() {
        return FileHolder.file;
    }

    public static Location location() {
        return LocationHolder.location;
    }

    public static Net net() {
        return NetHolder.net;
    }

    public static Phone phone() {
        return PhoneHolder.phone;
    }

    public static Package pkg() {
        return PackageHolder.pkg;
    }

    public static Provider provider() {
        return ProviderHolder.provider;
    }

    public static Wifi wifi() {
        return WifiHolder.wifi;
    }

    public static class Phone extends WhatNameGood<Callback, Decision> {

        public interface Callback {
            void onGetDeviceId0(boolean z);

            void onGetDeviceId1(boolean z);

            void onGetImei(boolean z);

            void onGetMeid(boolean z);
        }

        public interface Decision {
            Reply<String> getDeviceId();

            Reply<String> getDeviceId(int i2);

            Reply<String> getImei(int i2);

            Reply<String> getMeid(int i2);
        }

        public Phone() {
            super();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void care(Callback callback) {
            super.care(callback);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.kugou.framework.hack.HackHub$Phone$Decision, java.lang.Object] */
        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ Decision getDecision() {
            return super.getDecision();
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void ignore(Callback callback) {
            super.ignore(callback);
        }

        public final Reply<String> notifyGetDeviceId() {
            Decision decision = (Decision) getDecision();
            Reply<String> deviceId = decision != null ? decision.getDeviceId() : null;
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onGetDeviceId0(deviceId != null && deviceId.handled);
                }
            }
            return deviceId;
        }

        public final Reply<String> notifyGetImei(int i2) {
            Decision decision = (Decision) getDecision();
            Reply<String> imei = decision != null ? decision.getImei(i2) : null;
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onGetImei(imei != null && imei.handled);
                }
            }
            return imei;
        }

        public final Reply<String> notifyGetMeid(int i2) {
            Decision decision = (Decision) getDecision();
            Reply<String> meid = decision != null ? decision.getMeid(i2) : null;
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onGetMeid(meid != null && meid.handled);
                }
            }
            return meid;
        }

        @Override // com.kugou.framework.hack.HackHub.WhatNameGood
        public /* bridge */ /* synthetic */ void setDecision(Decision decision) {
            super.setDecision(decision);
        }

        public final Reply<String> notifyGetDeviceId(int i2) {
            Decision decision = (Decision) getDecision();
            Reply<String> deviceId = decision != null ? decision.getDeviceId(i2) : null;
            Object[] objArrCollectCallbacks = collectCallbacks();
            if (objArrCollectCallbacks != null) {
                for (Object obj : objArrCollectCallbacks) {
                    ((Callback) obj).onGetDeviceId1(deviceId != null && deviceId.handled);
                }
            }
            return deviceId;
        }
    }
}
