package com.kugou.android.watch.lite.base.player.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import e.c.a.g.a.d.x.r.b;
import e.c.a.g.a.s.g0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMediaButtonIntentReceiver extends BroadcastReceiver {
    public static long b;
    public static int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f78d = new byte[0];
    public final Handler a = new a(this);

    public static class a extends Handler {
        public WeakReference<AbstractMediaButtonIntentReceiver> a;

        public a(AbstractMediaButtonIntentReceiver abstractMediaButtonIntentReceiver) {
            this.a = new WeakReference<>(abstractMediaButtonIntentReceiver);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AbstractMediaButtonIntentReceiver abstractMediaButtonIntentReceiver = this.a.get();
            if (this.a.get() == null) {
                return;
            }
            synchronized (AbstractMediaButtonIntentReceiver.f78d) {
                int i2 = AbstractMediaButtonIntentReceiver.c;
                int i3 = message.arg2;
                long jLongValue = ((Long) message.obj).longValue();
                long j = AbstractMediaButtonIntentReceiver.b - jLongValue;
                if (g0.a) {
                    g0.e("xiankong", "time :" + j);
                }
                int i4 = message.arg1;
                if (!abstractMediaButtonIntentReceiver.d(message.what)) {
                    abstractMediaButtonIntentReceiver.e();
                    return;
                }
                if (g0.a) {
                    g0.b("xiankong", "what: " + message.what + ", currentClickCount: " + i2 + ", clickCount: " + i3 + ", clickTime: " + jLongValue + ", gapTime: " + j + ", keyCode: " + i4);
                }
                int i5 = message.what;
                if (i5 != 0) {
                    String str = null;
                    if (i5 == 1) {
                        if (g0.a) {
                            g0.e("xiankong", "普通播放暂停操作消息 : " + i3 + "/" + AbstractMediaButtonIntentReceiver.c);
                        }
                        if (i3 != i2) {
                            if (g0.a) {
                                g0.e("xiankong", "普通播放暂停操作取消");
                            }
                            return;
                        }
                        if (i2 == 1 && j == 0) {
                            if (g0.a) {
                                g0.e("xiankong", "普通播放暂停操作");
                            }
                            if (i4 == 79 || i4 == 85) {
                                str = "togglepause";
                            }
                            Intent intent = new Intent();
                            intent.putExtra("command", str);
                            intent.putExtra("keycode", i4);
                            b.f().b(intent);
                            abstractMediaButtonIntentReceiver.e();
                        } else if (g0.a) {
                            g0.e("xiankong", "普通播放暂停操作取消");
                        }
                    } else if (i5 == 2) {
                        if (g0.a) {
                            g0.e("xiankong", "长按消息 : " + i3 + "/" + AbstractMediaButtonIntentReceiver.c);
                        }
                        if (i3 != i2) {
                            if (g0.a) {
                                g0.e("xiankong", "长按操作取消");
                            }
                        } else if (i2 == 1 && j == 0) {
                            if (g0.a) {
                                g0.e("xiankong", "长按");
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("command", "previous");
                            intent2.putExtra("keycode", i4);
                            b.f().d(intent2);
                            abstractMediaButtonIntentReceiver.e();
                        } else if (g0.a) {
                            g0.e("xiankong", "长按操作取消");
                        }
                    } else if (i5 == 3) {
                        if (g0.a) {
                            g0.e("xiankong", "普通操作切换歌曲或停止播放");
                        }
                        if (i4 == 126) {
                            str = "play";
                        } else if (i4 != 127) {
                            switch (i4) {
                                case 86:
                                    str = "stop";
                                    break;
                                case 87:
                                    str = "next";
                                    break;
                                case 88:
                                    str = "previous";
                                    break;
                            }
                        } else {
                            str = "pause";
                        }
                        Intent intent3 = new Intent();
                        intent3.putExtra("command", str);
                        intent3.putExtra("keycode", i4);
                        b.f().a(intent3);
                        abstractMediaButtonIntentReceiver.e();
                    }
                } else {
                    if (g0.a) {
                        g0.e("xiankong", "多次点击消息 : " + i3 + "/" + AbstractMediaButtonIntentReceiver.c);
                    }
                    if (g0.a) {
                        g0.e("xiankong", "keyCode : " + i4);
                    }
                    if (i3 != i2) {
                        return;
                    }
                    Intent intent4 = new Intent();
                    if (i2 > 2) {
                        if (g0.a) {
                            g0.e("xiankong", "三击");
                        }
                        Intent intent5 = new Intent();
                        intent5.putExtra("command", "previous");
                        intent5.putExtra("keycode", i4);
                        b.f().e(intent5);
                        abstractMediaButtonIntentReceiver.e();
                    } else if (i2 == 2) {
                        if (g0.a) {
                            g0.e("xiankong", "双击");
                        }
                        intent4.putExtra("command", "next");
                        intent4.putExtra("keycode", i4);
                        b.f().c(intent4);
                        abstractMediaButtonIntentReceiver.e();
                    }
                }
            }
        }
    }

    public abstract boolean d(int i2);

    public void e() {
        c = 0;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        KeyEvent keyEvent;
        TelephonyManager telephonyManager;
        KeyEvent keyEvent2 = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent2 == null) {
            return;
        }
        keyEvent2.getKeyCode();
        boolean booleanExtra = intent.getBooleanExtra("FromMediaSession", false);
        if (booleanExtra) {
            KeyEvent keyEvent3 = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (keyEvent3 == null) {
                return;
            }
            if (g0.a) {
                g0.b("zlx_miui", "canUseSystemLockScreen receive " + keyEvent3.getAction() + "  " + keyEvent3.getKeyCode());
            }
            int keyCode = keyEvent3.getKeyCode();
            if (keyCode == 85 || keyCode == 87 || keyCode == 88) {
                if (keyEvent3.getAction() == 1 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && telephonyManager.getCallState() == 0) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_media", keyCode);
                    intent2.setAction("media.button.keyevent");
                    e.c.a.g.a.f.d.a.d(intent2);
                    return;
                }
                return;
            }
        }
        TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager2 == null || telephonyManager2.getCallState() != 0 || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getRepeatCount() > 0) {
            return;
        }
        int keyCode2 = keyEvent.getKeyCode();
        int action = keyEvent.getAction();
        if (g0.a) {
            g0.b("xiankong", "keyCode: " + keyCode2 + ", action :" + action + ", fromMediaSession: " + booleanExtra);
        }
        if (action == 0) {
            c++;
            b = keyEvent.getEventTime();
            if (g0.a) {
                g0.e("xiankong", "DOWN : " + b);
            }
            if (g0.a) {
                g0.e("xiankong", "keyCode : " + keyCode2);
            }
            if (keyCode2 != 79 && keyCode2 != 85) {
                Message messageObtainMessage = this.a.obtainMessage(3);
                messageObtainMessage.what = 3;
                messageObtainMessage.arg1 = keyCode2;
                messageObtainMessage.arg2 = c;
                messageObtainMessage.obj = Long.valueOf(b);
                this.a.sendMessage(messageObtainMessage);
            } else if (c == 1) {
                Message messageObtainMessage2 = this.a.obtainMessage(2);
                messageObtainMessage2.what = 2;
                messageObtainMessage2.arg1 = keyCode2;
                messageObtainMessage2.arg2 = c;
                messageObtainMessage2.obj = Long.valueOf(b);
                this.a.sendMessageDelayed(messageObtainMessage2, 1000L);
            } else {
                Message messageObtainMessage3 = this.a.obtainMessage(0);
                messageObtainMessage3.what = 0;
                messageObtainMessage3.arg1 = keyCode2;
                messageObtainMessage3.arg2 = c;
                messageObtainMessage3.obj = Long.valueOf(b);
                this.a.sendMessageDelayed(messageObtainMessage3, 500L);
            }
        } else if (action == 1) {
            if ((keyCode2 == 79 || keyCode2 == 85) && c == 1) {
                Message messageObtainMessage4 = this.a.obtainMessage(1);
                messageObtainMessage4.what = 1;
                messageObtainMessage4.arg1 = keyCode2;
                messageObtainMessage4.arg2 = c;
                messageObtainMessage4.obj = Long.valueOf(b);
                this.a.removeMessages(2);
                this.a.sendMessageDelayed(messageObtainMessage4, 500L);
            }
            if (keyCode2 == 90) {
                context.sendBroadcast(new Intent("headset_double_click_action"));
            }
            if (g0.a) {
                g0.e("xiankong", "UP : " + keyEvent.getEventTime() + " keyCode : " + keyCode2);
            }
        }
        if (isOrderedBroadcast()) {
            abortBroadcast();
        }
    }
}
