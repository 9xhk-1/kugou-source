package com.xtc.shareapi.share.interfaces;

import android.os.Bundle;
import com.xtc.shareapi.share.communication.BaseResponse;

/* JADX INFO: loaded from: classes2.dex */
public interface IBundleSerialize {
    BaseResponse checkArgs();

    IBundleSerialize fromBundle(Bundle bundle);

    void toBundle(Bundle bundle);
}
