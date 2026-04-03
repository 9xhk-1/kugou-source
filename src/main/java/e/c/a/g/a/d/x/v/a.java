package e.c.a.g.a.d.x.v;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.LimitUseActivity;
import com.kugou.android.watch.lite.component.SplashActivity;
import com.kugou.android.watch.lite.component.vip.XTCPayActivity;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.permission.KGPermission;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.s0;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public final e a = e.f628d.a();
    public e.c.a.g.a.d.x.h b;
    public Subscription c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BroadcastReceiver f619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BroadcastReceiver f621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f623h;

    /* JADX INFO: renamed from: e.c.a.g.a.d.x.v.a$a, reason: collision with other inner class name */
    public class C0095a implements Action1<Long> {
        public long a = 0;
        public int b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f624d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f625f;

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.v.a$a$a, reason: collision with other inner class name */
        public class RunnableC0096a implements Runnable {
            public RunnableC0096a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.c.a.g.a.d.x.f.t();
                if (!(e.c.a.g.a.d.j.a.e().c() instanceof XTCPayActivity)) {
                    if (e.c.a.g.a.d.l.a.e()) {
                        LimitUseActivity.b.a(KGApplication.getContext());
                    } else {
                        Intent intentA = s0.a.a(a.this.b.x(), SplashActivity.class);
                        intentA.setAction("action_show_hint");
                        a.this.b.x().startActivity(intentA);
                    }
                }
                e.c.a.g.a.d.x.e.d(1);
            }
        }

        public C0095a(int i2, int i3) {
            this.f624d = i2;
            this.f625f = i3;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            if (this.a > this.f624d) {
                this.a = 0L;
                this.b = 0;
                j0.g(new RunnableC0096a());
            } else {
                if (a.this.b.isPlaying()) {
                    this.a++;
                    return;
                }
                int i2 = this.b + 1;
                this.b = i2;
                if (i2 > this.f625f) {
                    this.a = 0L;
                    this.b = 0;
                }
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.PHONE_STATE".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(ApmDataKey.STATE);
                if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra)) {
                    if (a.this.b.isPlaying()) {
                        a.this.b.pause();
                        e.c.a.g.a.d.x.e.d(4);
                        a.this.f620e = true;
                        return;
                    }
                    return;
                }
                if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra) && a.this.f620e) {
                    a.this.b.play();
                    a.this.f620e = false;
                }
            }
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r8, android.content.Intent r9) {
            /*
                Method dump skipped, instruction units count: 342
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.d.x.v.a.c.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    public class d implements BluetoothProfile.ServiceListener {
        public final /* synthetic */ BluetoothAdapter a;

        public d(a aVar, BluetoothAdapter bluetoothAdapter) {
            this.a = bluetoothAdapter;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i2, BluetoothProfile bluetoothProfile) {
            BluetoothDevice bluetoothDevice;
            BluetoothClass bluetoothClass;
            if (i2 == 2) {
                BluetoothA2dp bluetoothA2dp = (BluetoothA2dp) bluetoothProfile;
                try {
                    if (!a.e()) {
                        return;
                    }
                    List<BluetoothDevice> connectedDevices = bluetoothA2dp.getConnectedDevices();
                    if (connectedDevices != null && !connectedDevices.isEmpty() && (bluetoothDevice = connectedDevices.get(0)) != null && (bluetoothClass = bluetoothDevice.getBluetoothClass()) != null && (bluetoothClass.getMajorDeviceClass() == 1024 || bluetoothClass.getMajorDeviceClass() == 7936)) {
                        String name = bluetoothDevice.getName();
                        String address = bluetoothDevice.getAddress();
                        e.c.a.g.a.f.n.a.b().i(10205, name);
                        e.c.a.g.a.f.n.a.b().i(10206, address);
                    }
                } catch (SecurityException e2) {
                    g0.k(e2);
                }
                this.a.closeProfileProxy(2, bluetoothProfile);
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i2) {
        }
    }

    public a() {
        this.f623h = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.m4, 1) == 1;
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        return KGPermission.uCantAskMePermissionState(e.c.c.o.f.a(), "android.permission.BLUETOOTH_CONNECT");
    }

    @NonNull
    public static a f() {
        return l1.m0() ? new p() : l1.V() ? new g() : l1.g0() ? new m() : l1.f0() ? new k() : l1.U() ? new g() : l1.n0() ? new r() : (l1.X() || l1.b0()) ? new h() : l1.N() ? new e.c.a.g.a.d.x.v.d() : new p();
    }

    public void g() {
        i1.a(this.c);
        this.c = null;
        BroadcastReceiver broadcastReceiver = this.f619d;
        if (broadcastReceiver != null) {
            e.c.a.g.a.f.d.a.h(broadcastReceiver);
            this.f619d = null;
        }
        BroadcastReceiver broadcastReceiver2 = this.f621f;
        if (broadcastReceiver2 != null) {
            e.c.a.g.a.f.d.a.h(broadcastReceiver2);
            this.f621f = null;
        }
    }

    public void h(e.c.a.g.a.d.x.h hVar) {
        this.b = hVar;
        if (this.f623h) {
            this.f622g = e.c.a.g.a.s.m.j();
        } else {
            this.f622g = e.c.a.g.a.s.m.k();
        }
        Log.d("AbstractCtrlStrategy", "isBluetoothConnected = " + this.f622g + ", isEnable = " + this.f623h + ",DeviceUtils.isBluetoothConnectedOld() = " + e.c.a.g.a.s.m.k());
    }

    public void i() {
        b bVar = new b();
        this.f619d = bVar;
        e.c.a.g.a.f.d.a.c(bVar, new IntentFilter("android.intent.action.PHONE_STATE"));
    }

    public void j() {
        this.f621f = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        e.c.a.g.a.f.d.a.c(this.f621f, intentFilter);
        l();
    }

    public void k() {
        int iB = this.a.b();
        int iC = this.a.c();
        if (iB > 0 && iC > 0) {
            this.c = Observable.interval(0L, 1L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new C0095a(iB, iC), i1.b);
        } else if (g0.a) {
            g0.b("young-hqd", "不限制播放时长");
        }
    }

    public final void l() {
        BluetoothAdapter defaultAdapter;
        AudioManager audioManager = (AudioManager) KGApplication.getContext().getSystemService("audio");
        if ((audioManager.isBluetoothA2dpOn() || audioManager.isWiredHeadsetOn()) && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null) {
            try {
                defaultAdapter.getProfileProxy(KGApplication.getContext(), new d(this, defaultAdapter), 2);
            } catch (SecurityException e2) {
                g0.k(e2);
            }
        }
    }
}
