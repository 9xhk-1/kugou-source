package com.kugou.common.permission.overlay;

import com.kugou.common.permission.Options;
import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public class MRequestFactory implements Options.OverlayRequestFactory {
    @Override // com.kugou.common.permission.Options.OverlayRequestFactory
    public OverlayRequest create(Source source) {
        return new MRequest(source);
    }
}
