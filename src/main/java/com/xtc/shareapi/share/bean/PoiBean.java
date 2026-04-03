package com.xtc.shareapi.share.bean;

import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;

/* JADX INFO: loaded from: classes2.dex */
public class PoiBean {
    private static final String TAG = "Share_PoiBean";
    private String address;
    private String addressDesc;
    private String city;
    private String goalPoi;
    private Location location;
    private int locationType;
    private String name;
    private String province;

    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        if (TextUtils.isEmpty(this.name)) {
            Log.d(TAG, "checkArgs fail , poi name is null or empty");
            response.setCode(6);
            response.setErrorDesc("checkArgs fail , poi name is null or empty");
            return response;
        }
        Location location = this.location;
        if (location != null) {
            return location.checkArgs();
        }
        Log.d(TAG, "checkArgs fail , poi location is null ");
        response.setCode(6);
        response.setErrorDesc("checkArgs fail , poi location is null ");
        return response;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAddressDesc() {
        return !TextUtils.isEmpty(this.addressDesc) ? this.addressDesc : this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String getGoalPoi() {
        return this.goalPoi;
    }

    public Location getLocation() {
        return this.location;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public String getName() {
        return this.name;
    }

    public String getProvince() {
        return this.province;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAddressDesc(String str) {
        this.addressDesc = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setGoalPoi(String str) {
        this.goalPoi = str;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocationType(int i2) {
        this.locationType = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String toString() {
        return "LocationInfo{name='" + this.name + "', province='" + this.province + "', city='" + this.city + "', address='" + this.address + "', location=" + this.location + ", locationType=" + this.locationType + ", addressDesc=" + this.addressDesc + ", goalPoi='" + this.goalPoi + "'}";
    }

    public static class Location {
        private static final String TAG = "Share_Location";
        private String lat;
        private String lng;

        public Location(String str, String str2) {
            this.lat = str;
            this.lng = str2;
        }

        public BaseResponse checkArgs() {
            ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
            if (TextUtils.isEmpty(this.lat)) {
                Log.e(TAG, "checkArgs fail , lat is null or empty");
                response.setCode(6);
                response.setErrorDesc("checkArgs fail , lat is null or empty");
            } else if (TextUtils.isEmpty(this.lng)) {
                Log.e(TAG, "checkArgs fail , lng is null or empty");
                response.setCode(6);
                response.setErrorDesc("checkArgs fail , lng is null or empty");
            } else {
                response.setCode(1);
            }
            return response;
        }

        public String getLat() {
            return this.lat;
        }

        public String getLng() {
            return this.lng;
        }

        public void setLat(String str) {
            this.lat = str;
        }

        public void setLng(String str) {
            this.lng = str;
        }

        public String toString() {
            return "Location{lat='" + this.lat + "', lng='" + this.lng + "'}";
        }

        public Location(Parcel parcel) {
            this.lat = parcel.readString();
            this.lng = parcel.readString();
        }
    }
}
