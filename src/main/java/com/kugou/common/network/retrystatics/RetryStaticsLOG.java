package com.kugou.common.network.retrystatics;

import android.content.Context;
import com.kugou.common.network.ExceptionParse;
import com.kugou.common.network.networkutils.AckUtil;
import com.kugou.common.network.networkutils.UrlEncoderUtil;
import com.kugou.common.network.protocol.RequestPackage;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RetryStaticsLOG {
    public static final String MARK_END = ";";
    public static final String MARK_SEPERATE = "|";
    public static final int VER = 3;
    public RequestDetail mCurRequestDetail;
    public String mNetworkName;
    public List<RequestDetail> mRequestDetails = new LinkedList();
    public long mTimeStamp;
    public String mUrl;

    /* JADX INFO: loaded from: classes2.dex */
    public static class RequestDetail {
        public String mExceptionCode;
        public String mHost;
        public int mHttpCode;
        public String mHttpMethod;
        public long mRequestRespondTimeCost;
        public long mRequestStartTime;
        public long mRequestTimeCost;
        public int mRequestType;
        public String mUrl;

        public String toString() {
            return this.mRequestType + RetryStaticsLOG.MARK_SEPERATE + this.mUrl + RetryStaticsLOG.MARK_SEPERATE + this.mHost + RetryStaticsLOG.MARK_SEPERATE + this.mExceptionCode + RetryStaticsLOG.MARK_SEPERATE + this.mHttpCode + RetryStaticsLOG.MARK_SEPERATE + this.mRequestStartTime + RetryStaticsLOG.MARK_SEPERATE + this.mRequestRespondTimeCost + RetryStaticsLOG.MARK_SEPERATE + this.mRequestTimeCost + RetryStaticsLOG.MARK_SEPERATE + this.mHttpMethod + RetryStaticsLOG.MARK_END;
        }
    }

    public RetryStaticsLOG(Context context) {
        this.mNetworkName = AckUtil.getCurrentNetworkName(context);
    }

    private void setRequestExceptionCode(Exception exc) {
        this.mCurRequestDetail.mExceptionCode = exc != null ? ExceptionParse.parseResultCode(exc) : "";
    }

    public void init(RequestPackage requestPackage) {
        this.mTimeStamp = System.currentTimeMillis();
        this.mUrl = requestPackage != null ? UrlEncoderUtil.encode(requestPackage.getUrl()) : null;
    }

    public void markRequestEnd(Exception exc) {
        setRequestExceptionCode(exc);
        RequestDetail requestDetail = this.mCurRequestDetail;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.mTimeStamp;
        RequestDetail requestDetail2 = this.mCurRequestDetail;
        requestDetail.mRequestTimeCost = jCurrentTimeMillis - requestDetail2.mRequestStartTime;
        this.mRequestDetails.add(requestDetail2);
        this.mCurRequestDetail = null;
    }

    public void markRequestGotResponse(int i2) {
        RequestDetail requestDetail = this.mCurRequestDetail;
        if (requestDetail != null) {
            requestDetail.mHttpCode = i2;
            requestDetail.mRequestRespondTimeCost = (System.currentTimeMillis() - this.mTimeStamp) - this.mCurRequestDetail.mRequestStartTime;
        }
    }

    public void markRequestStart(String str) {
        RequestDetail requestDetail = new RequestDetail();
        this.mCurRequestDetail = requestDetail;
        requestDetail.mRequestStartTime = System.currentTimeMillis() - this.mTimeStamp;
        this.mCurRequestDetail.mHttpMethod = str;
    }

    public void setRequestType(int i2, String str, String str2) {
        RequestDetail requestDetail = this.mCurRequestDetail;
        if (requestDetail != null) {
            requestDetail.mRequestType = i2;
            requestDetail.mHost = UrlEncoderUtil.encode(str2);
            this.mCurRequestDetail.mUrl = UrlEncoderUtil.encode(str);
        }
    }
}
