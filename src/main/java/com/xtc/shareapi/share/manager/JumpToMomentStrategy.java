package com.xtc.shareapi.share.manager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.xtc.shareapi.R;
import com.xtc.shareapi.share.bean.JumpToMomentRequest;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IJumpToMomentObject;
import com.xtc.shareapi.share.jumpmoment.JumpToMomentBase;
import com.xtc.shareapi.share.jumpmoment.JumpToMomentFromAddress;
import com.xtc.shareapi.share.jumpmoment.JumpToMomentFromAlbum;
import com.xtc.shareapi.share.jumpmoment.JumpToMomentFromCamara;
import com.xtc.shareapi.share.utils.ShareUtil;
import com.xtc.system.account.WatchAccountBase;
import com.xtc.utils.system.WatchModelUtil;

/* JADX INFO: loaded from: classes2.dex */
public class JumpToMomentStrategy {
    private static final String TAG = "JumpToMomentStrategy";
    private Context context;

    public JumpToMomentStrategy(Context context) {
        this.context = context;
    }

    private void dealIntentFromAddress(Intent intent, JumpToMomentFromAddress jumpToMomentFromAddress) {
        intent.putExtra(OpenApiConstant.MomentIntentConstant.SHARE_FROM_EXTRA, jumpToMomentFromAddress.type());
        intent.putExtra(OpenApiConstant.MomentIntentConstant.LBS_FROM_LAUNCHER_ADDRESS_ID, jumpToMomentFromAddress.getAddressId());
        if (jumpToMomentFromAddress.getBase() != null) {
            dealIntentFromBase(intent, jumpToMomentFromAddress.getBase());
        }
    }

    private void dealIntentFromAlbum(Intent intent, JumpToMomentFromAlbum jumpToMomentFromAlbum) {
        Bundle albumBundle = jumpToMomentFromAlbum.getAlbumBundle();
        int i2 = albumBundle.getInt(OpenApiConstant.BundleExtra.PHOTO_TYPE);
        intent.putExtra(OpenApiConstant.MomentIntentConstant.SHARE_FROM_EXTRA, jumpToMomentFromAlbum.type());
        if (i2 == 1) {
            intent.putExtra(OpenApiConstant.MomentIntentConstant.VIDEO_PATH, albumBundle);
        } else if (i2 == 0) {
            intent.putExtra(OpenApiConstant.MomentIntentConstant.PHOTO_PATH, albumBundle);
        }
        intent.putExtra(OpenApiConstant.MomentIntentConstant.IS_FROM_ALBUM, jumpToMomentFromAlbum.isFromAlbum());
        if (jumpToMomentFromAlbum.getJumpToMomentBase() != null) {
            dealIntentFromBase(intent, jumpToMomentFromAlbum.getJumpToMomentBase());
        }
    }

    private void dealIntentFromBase(Intent intent, JumpToMomentBase jumpToMomentBase) {
        intent.putExtra(OpenApiConstant.MomentIntentConstant.SHARE_FROM_EXTRA, jumpToMomentBase.type());
        intent.putExtra(OpenApiConstant.MomentIntentConstant.LBS_ADDRESS_POI_BEAN, JSON.toJSONString(jumpToMomentBase.getPoiBean()));
        intent.putExtra(OpenApiConstant.MomentIntentConstant.LBS_TEXT, jumpToMomentBase.getText());
    }

    private void dealIntentFromCamara(Intent intent, JumpToMomentFromCamara jumpToMomentFromCamara) {
        intent.putExtra(OpenApiConstant.MomentIntentConstant.PiCURE_PHOTO_PATH, jumpToMomentFromCamara.getCamaraBundle());
        intent.putExtra(OpenApiConstant.MomentIntentConstant.SHARE_FROM_EXTRA, jumpToMomentFromCamara.type());
        if (jumpToMomentFromCamara.getJumpToMomentBase() != null) {
            dealIntentFromBase(intent, jumpToMomentFromCamara.getJumpToMomentBase());
        }
    }

    private Intent getShareIntent(JumpToMomentRequest jumpToMomentRequest) {
        Intent intent = new Intent();
        IJumpToMomentObject jumpToMomentObject = jumpToMomentRequest.getJumpToMomentObject();
        if (jumpToMomentObject instanceof JumpToMomentFromCamara) {
            dealIntentFromCamara(intent, (JumpToMomentFromCamara) jumpToMomentObject);
        } else if (jumpToMomentObject instanceof JumpToMomentFromAlbum) {
            dealIntentFromAlbum(intent, (JumpToMomentFromAlbum) jumpToMomentObject);
        } else if (jumpToMomentObject instanceof JumpToMomentBase) {
            dealIntentFromBase(intent, (JumpToMomentBase) jumpToMomentObject);
        } else if (jumpToMomentObject instanceof JumpToMomentFromAddress) {
            dealIntentFromAddress(intent, (JumpToMomentFromAddress) jumpToMomentObject);
        }
        intent.putExtra(OpenApiConstant.MomentIntentConstant.IS_FROM_OUTSIDE_JUMP, true);
        intent.setAction(OpenApiConstant.App.MOMENT_MATA_LBS_ACTIVITY);
        return intent;
    }

    private boolean isFunSwitchOpen() {
        return WatchAccountBase.queryFunSwitchByPackageName(this.context, OpenApiConstant.App.MOMENT_PACKAGE_NAME, true).getSwitchStatus().intValue() == 0;
    }

    private boolean isModuleSwitchOpen() {
        return WatchAccountBase.queryModuleSwitchByBoolean(this.context, 47, !WatchModelUtil.isInternationalWatch());
    }

    private boolean isMomentChecked() {
        return ShareUtil.isInstallScene(this.context, OpenApiConstant.App.MOMENT_PACKAGE_NAME);
    }

    public void share(JumpToMomentRequest jumpToMomentRequest) {
        if (!isMomentChecked()) {
            ShareHandlerUtil.runOnUIThread(new Runnable() { // from class: com.xtc.shareapi.share.manager.JumpToMomentStrategy.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(JumpToMomentStrategy.this.context, JumpToMomentStrategy.this.context.getString(R.string.please_install_moment), 0).show();
                }
            });
            return;
        }
        if (ShareUtil.getHostSdkVersion(this.context, OpenApiConstant.App.MOMENT_PACKAGE_NAME) < 4) {
            Log.d(TAG, "check moment meta fail,moment is not new version");
            Context context = this.context;
            Toast.makeText(context, context.getString(R.string.please_update_moment), 0).show();
        } else {
            if (!isModuleSwitchOpen()) {
                Log.d(TAG, "current moduleSwitch is not open !");
                return;
            }
            if (!isFunSwitchOpen()) {
                Log.d(TAG, "current funSwitch is not open !");
                Context context2 = this.context;
                Toast.makeText(context2, context2.getString(R.string.moment_forbid), 0).show();
            } else {
                Intent shareIntent = getShareIntent(jumpToMomentRequest);
                if (shareIntent == null) {
                    Log.d(TAG, "get share intent error!");
                } else {
                    this.context.startActivity(shareIntent);
                }
            }
        }
    }
}
