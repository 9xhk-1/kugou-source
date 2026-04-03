package com.kugou.common.permission.particular;

import com.kugou.common.permission.Options;
import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public class LRequestFactory implements Options.ParticularRequestFactory {
    @Override // com.kugou.common.permission.Options.ParticularRequestFactory
    public ParticularRequest create(Source source) {
        return new LRequest(source);
    }
}
