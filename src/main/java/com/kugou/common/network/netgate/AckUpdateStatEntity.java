package com.kugou.common.network.netgate;

import android.os.Parcel;
import android.os.Parcelable;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import com.kugou.common.network.netgate.AckServiceConfigEntity;
import com.kugou.common.network.networkutils.NetLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AckUpdateStatEntity implements Parcelable {
    public static final String ALIAS_MAP = "alias_map";
    public static final Parcelable.Creator<AckUpdateStatEntity> CREATOR = new Parcelable.Creator<AckUpdateStatEntity>() { // from class: com.kugou.common.network.netgate.AckUpdateStatEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AckUpdateStatEntity createFromParcel(Parcel parcel) {
            return new AckUpdateStatEntity(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), (NetgateUpdateStatEntity) parcel.readParcelable(AnonymousClass1.class.getClassLoader()), (AckDnsUpdateStatEntity) parcel.readParcelable(AnonymousClass1.class.getClassLoader()), (DynDomainUpdateStatEntity) parcel.readParcelable(AnonymousClass1.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AckUpdateStatEntity[] newArray(int i2) {
            return new AckUpdateStatEntity[i2];
        }
    };
    public static final String DOMAIN_FIRST_IP = "domain_first_ip";
    public static final String DOMAIN_LIST = "domain_list";
    public static final String ELAPSED_TIME = "elapsed_time";
    public static final String FIRST_IP = "first_ip";
    public static final String HOST_KEY = "host_key";
    public static final String NEW_AREA = "new_area";
    public static final String NEW_ISP = "new_isp";
    public static final String NEW_VERSION = "new_version";
    public static final String OLD_AREA = "old_area";
    public static final String OLD_ISP = "old_isp";
    public static final String OLD_VERSION = "old_version";
    public AckDnsUpdateStatEntity ackDnsEntity;
    public DynDomainUpdateStatEntity dynEntity;
    public long elapsedTime;
    public NetgateUpdateStatEntity netgateEntity;
    public int newArea;
    public int newIsp;
    public int oldArea;
    public int oldIsp;

    public AckUpdateStatEntity() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void record(AckHostConfigEntity ackHostConfigEntity, AckHostConfigEntity ackHostConfigEntity2) {
        if (this.dynEntity == null) {
            this.dynEntity = new DynDomainUpdateStatEntity();
        }
        this.dynEntity.items.add(new DynDomainUpdateStatEntity.Item(ackHostConfigEntity, ackHostConfigEntity2));
    }

    public void recordHost(List<AckHostConfigEntity> list) {
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                record(list.get(i2), (AckHostConfigEntity) null);
            }
        }
    }

    public void recordService(List<AckServiceConfigEntity> list) {
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                record(list.get(i2), (AckServiceConfigEntity) null);
            }
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(OLD_ISP, this.oldIsp);
            jSONObject.put(OLD_AREA, this.oldArea);
            jSONObject.put(NEW_ISP, this.newIsp);
            jSONObject.put(NEW_AREA, this.newArea);
            jSONObject.put(ELAPSED_TIME, this.elapsedTime);
            NetgateUpdateStatEntity netgateUpdateStatEntity = this.netgateEntity;
            if (netgateUpdateStatEntity != null) {
                jSONObject.put(NetgateUpdateStatEntity.NETGATE, netgateUpdateStatEntity.toJsonO());
            }
            AckDnsUpdateStatEntity ackDnsUpdateStatEntity = this.ackDnsEntity;
            if (ackDnsUpdateStatEntity != null) {
                jSONObject.put(AckDnsUpdateStatEntity.ACKDNS, ackDnsUpdateStatEntity.toJsonO());
            }
            DynDomainUpdateStatEntity dynDomainUpdateStatEntity = this.dynEntity;
            if (dynDomainUpdateStatEntity != null) {
                jSONObject.put(DynDomainUpdateStatEntity.DYNDOMAIN, dynDomainUpdateStatEntity.toJsonO());
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            NetLog.uploadException(e2);
            return "";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.oldIsp);
        parcel.writeInt(this.oldArea);
        parcel.writeInt(this.newIsp);
        parcel.writeInt(this.newArea);
        parcel.writeLong(this.elapsedTime);
        parcel.writeParcelable(this.netgateEntity, i2);
        parcel.writeParcelable(this.ackDnsEntity, i2);
        parcel.writeParcelable(this.dynEntity, i2);
    }

    public static class DynDomainUpdateStatEntity implements Parcelable {
        public static final Parcelable.Creator<DynDomainUpdateStatEntity> CREATOR = new Parcelable.Creator<DynDomainUpdateStatEntity>() { // from class: com.kugou.common.network.netgate.AckUpdateStatEntity.DynDomainUpdateStatEntity.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DynDomainUpdateStatEntity createFromParcel(Parcel parcel) {
                ArrayList arrayList = new ArrayList();
                parcel.readTypedList(arrayList, Item.CREATOR);
                return new DynDomainUpdateStatEntity(arrayList);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DynDomainUpdateStatEntity[] newArray(int i2) {
                return new DynDomainUpdateStatEntity[i2];
            }
        };
        public static final String DYNDOMAIN = "dyndomain";
        public List<Item> items;

        public static class Item implements Parcelable {
            public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() { // from class: com.kugou.common.network.netgate.AckUpdateStatEntity.DynDomainUpdateStatEntity.Item.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Item createFromParcel(Parcel parcel) {
                    return new Item(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Item[] newArray(int i2) {
                    return new Item[i2];
                }
            };
            public List<AckHostConfigEntity.UrlHostEntity> domainList;
            public String hostKey;
            public int newVersion;
            public int oldVersion;

            public Item() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toJson() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AckUpdateStatEntity.HOST_KEY, this.hostKey);
                    jSONObject.put(AckUpdateStatEntity.OLD_VERSION, this.oldVersion);
                    jSONObject.put(AckUpdateStatEntity.NEW_VERSION, this.newVersion);
                    jSONObject.put(AckUpdateStatEntity.DOMAIN_LIST, this.domainList);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    NetLog.uploadException(e2);
                    return "";
                }
            }

            public JSONObject toJsonO() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AckUpdateStatEntity.HOST_KEY, this.hostKey);
                    jSONObject.put(AckUpdateStatEntity.OLD_VERSION, this.oldVersion);
                    jSONObject.put(AckUpdateStatEntity.NEW_VERSION, this.newVersion);
                    jSONObject.put(AckUpdateStatEntity.DOMAIN_LIST, this.domainList);
                    return jSONObject;
                } catch (JSONException e2) {
                    NetLog.uploadException(e2);
                    return null;
                }
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeString(this.hostKey);
                parcel.writeInt(this.oldVersion);
                parcel.writeInt(this.newVersion);
                parcel.writeTypedList(this.domainList);
            }

            public Item(AckHostConfigEntity ackHostConfigEntity, AckHostConfigEntity ackHostConfigEntity2) {
                if (ackHostConfigEntity2 != null) {
                    this.hostKey = ackHostConfigEntity2.hostKey;
                    this.newVersion = ackHostConfigEntity2.version;
                    this.domainList = ackHostConfigEntity2.urlHosts;
                }
                if (ackHostConfigEntity != null) {
                    this.oldVersion = ackHostConfigEntity.version;
                    if (ackHostConfigEntity2 == null) {
                        this.hostKey = ackHostConfigEntity.hostKey;
                        this.domainList = ackHostConfigEntity.urlHosts;
                    }
                }
            }

            public Item(String str, int i2, int i3, List<AckHostConfigEntity.UrlHostEntity> list) {
                this.hostKey = str;
                this.oldVersion = i2;
                this.newVersion = i3;
                this.domainList = list;
            }

            public Item(Parcel parcel) {
                this.hostKey = parcel.readString();
                this.oldVersion = parcel.readInt();
                this.newVersion = parcel.readInt();
                this.domainList = parcel.createTypedArrayList(AckHostConfigEntity.UrlHostEntity.CREATOR);
            }
        }

        public DynDomainUpdateStatEntity() {
            this.items = new ArrayList();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toJson() {
            if (this.items.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.items.size(); i2++) {
                jSONArray.put(this.items.get(i2).toJson());
            }
            return jSONArray.toString();
        }

        public JSONArray toJsonO() {
            if (this.items.size() == 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.items.size(); i2++) {
                jSONArray.put(this.items.get(i2).toJsonO());
            }
            return jSONArray;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeTypedList(this.items);
        }

        public DynDomainUpdateStatEntity(List<Item> list) {
            this.items = new ArrayList();
            this.items = list;
        }
    }

    public static class NetgateUpdateStatEntity implements Parcelable {
        public static final Parcelable.Creator<NetgateUpdateStatEntity> CREATOR = new Parcelable.Creator<NetgateUpdateStatEntity>() { // from class: com.kugou.common.network.netgate.AckUpdateStatEntity.NetgateUpdateStatEntity.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NetgateUpdateStatEntity createFromParcel(Parcel parcel) {
                return new NetgateUpdateStatEntity(parcel.readInt(), parcel.readInt(), parcel.readHashMap(AnonymousClass1.class.getClassLoader()), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NetgateUpdateStatEntity[] newArray(int i2) {
                return new NetgateUpdateStatEntity[i2];
            }
        };
        public static final String NETGATE = "netgate";
        public Map<String, String> aliasMap;
        public String firstIp;
        public int newVersion;
        public int oldVersion;

        public NetgateUpdateStatEntity() {
            this.aliasMap = new HashMap();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AckUpdateStatEntity.OLD_VERSION, this.oldVersion);
                jSONObject.put(AckUpdateStatEntity.NEW_VERSION, this.newVersion);
                jSONObject.put(AckUpdateStatEntity.ALIAS_MAP, this.aliasMap);
                jSONObject.put(AckUpdateStatEntity.FIRST_IP, this.firstIp);
                return jSONObject.toString();
            } catch (JSONException e2) {
                NetLog.uploadException(e2);
                return "";
            }
        }

        public JSONObject toJsonO() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AckUpdateStatEntity.OLD_VERSION, this.oldVersion);
                jSONObject.put(AckUpdateStatEntity.NEW_VERSION, this.newVersion);
                jSONObject.put(AckUpdateStatEntity.ALIAS_MAP, this.aliasMap);
                jSONObject.put(AckUpdateStatEntity.FIRST_IP, this.firstIp);
                return jSONObject;
            } catch (JSONException e2) {
                NetLog.uploadException(e2);
                return null;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.oldVersion);
            parcel.writeInt(this.newVersion);
            parcel.writeMap(this.aliasMap);
            parcel.writeString(this.firstIp);
        }

        public NetgateUpdateStatEntity(AckServiceConfigEntity ackServiceConfigEntity, AckServiceConfigEntity ackServiceConfigEntity2) {
            this.aliasMap = new HashMap();
            if (ackServiceConfigEntity2 != null) {
                this.newVersion = ackServiceConfigEntity2.version;
                for (int i2 = 0; i2 < ackServiceConfigEntity2.domains.size(); i2++) {
                    AckServiceConfigEntity.AckDomainItem ackDomainItem = ackServiceConfigEntity2.domains.get(i2);
                    this.aliasMap.put(ackDomainItem.oriHost, ackDomainItem.aliasHost);
                }
                List<AckServiceConfigEntity.AckListItem> list = ackServiceConfigEntity2.list;
                if (list.size() > 0) {
                    List<AckServiceConfigEntity.AckAddressItem> list2 = list.get(0).address;
                    if (list2.size() > 0) {
                        this.firstIp = list2.get(0).toString();
                    }
                }
            }
            if (ackServiceConfigEntity != null) {
                this.oldVersion = ackServiceConfigEntity.version;
                if (ackServiceConfigEntity2 == null) {
                    for (int i3 = 0; i3 < ackServiceConfigEntity.domains.size(); i3++) {
                        AckServiceConfigEntity.AckDomainItem ackDomainItem2 = ackServiceConfigEntity.domains.get(i3);
                        this.aliasMap.put(ackDomainItem2.oriHost, ackDomainItem2.aliasHost);
                    }
                    List<AckServiceConfigEntity.AckListItem> list3 = ackServiceConfigEntity.list;
                    if (list3.size() > 0) {
                        List<AckServiceConfigEntity.AckAddressItem> list4 = list3.get(0).address;
                        if (list4.size() > 0) {
                            this.firstIp = list4.get(0).toString();
                        }
                    }
                }
            }
        }

        public NetgateUpdateStatEntity(int i2, int i3, Map<String, String> map, String str) {
            this.aliasMap = new HashMap();
            this.oldVersion = i2;
            this.newVersion = i3;
            this.aliasMap = map;
            this.firstIp = str;
        }
    }

    public AckUpdateStatEntity(int i2, int i3, int i4, int i5, long j, NetgateUpdateStatEntity netgateUpdateStatEntity, AckDnsUpdateStatEntity ackDnsUpdateStatEntity, DynDomainUpdateStatEntity dynDomainUpdateStatEntity) {
        this.oldIsp = i2;
        this.oldArea = i3;
        this.newIsp = i4;
        this.newArea = i5;
        this.elapsedTime = j;
        this.netgateEntity = netgateUpdateStatEntity;
        this.ackDnsEntity = ackDnsUpdateStatEntity;
        this.dynEntity = dynDomainUpdateStatEntity;
    }

    public void record(AckServiceConfigEntity ackServiceConfigEntity, AckServiceConfigEntity ackServiceConfigEntity2) {
        int i2;
        if (ackServiceConfigEntity != null) {
            i2 = ackServiceConfigEntity.serviceId;
        } else {
            i2 = ackServiceConfigEntity2 != null ? ackServiceConfigEntity2.serviceId : 0;
        }
        if (i2 == 108) {
            this.netgateEntity = new NetgateUpdateStatEntity(ackServiceConfigEntity, ackServiceConfigEntity2);
        } else {
            if (i2 != 10001) {
                return;
            }
            this.ackDnsEntity = new AckDnsUpdateStatEntity(ackServiceConfigEntity, ackServiceConfigEntity2);
        }
    }

    public static class AckDnsUpdateStatEntity implements Parcelable {
        public static final String ACKDNS = "ackdns";
        public static final Parcelable.Creator<AckDnsUpdateStatEntity> CREATOR = new Parcelable.Creator<AckDnsUpdateStatEntity>() { // from class: com.kugou.common.network.netgate.AckUpdateStatEntity.AckDnsUpdateStatEntity.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AckDnsUpdateStatEntity createFromParcel(Parcel parcel) {
                return new AckDnsUpdateStatEntity(parcel.readInt(), parcel.readInt(), parcel.readHashMap(AnonymousClass1.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AckDnsUpdateStatEntity[] newArray(int i2) {
                return new AckDnsUpdateStatEntity[i2];
            }
        };
        public Map<String, String> domainFirstIp;
        public int newVersion;
        public int oldVersion;

        public AckDnsUpdateStatEntity(AckServiceConfigEntity ackServiceConfigEntity, AckServiceConfigEntity ackServiceConfigEntity2) {
            this.domainFirstIp = new HashMap();
            if (ackServiceConfigEntity2 != null) {
                this.newVersion = ackServiceConfigEntity2.version;
                for (int i2 = 0; i2 < ackServiceConfigEntity2.list.size(); i2++) {
                    AckServiceConfigEntity.AckListItem ackListItem = ackServiceConfigEntity2.list.get(i2);
                    this.domainFirstIp.put(ackListItem.domain, ackListItem.address.get(0).toString());
                }
            }
            if (ackServiceConfigEntity != null) {
                this.oldVersion = ackServiceConfigEntity.version;
                if (ackServiceConfigEntity2 == null) {
                    for (int i3 = 0; i3 < ackServiceConfigEntity.list.size(); i3++) {
                        AckServiceConfigEntity.AckListItem ackListItem2 = ackServiceConfigEntity.list.get(i3);
                        this.domainFirstIp.put(ackListItem2.domain, ackListItem2.address.get(0).toString());
                    }
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AckUpdateStatEntity.OLD_VERSION, this.oldVersion);
                jSONObject.put(AckUpdateStatEntity.NEW_VERSION, this.newVersion);
                Map<String, String> map = this.domainFirstIp;
                if (map != null) {
                    jSONObject.put(AckUpdateStatEntity.DOMAIN_FIRST_IP, map.toString());
                }
                return jSONObject.toString();
            } catch (JSONException e2) {
                NetLog.uploadException(e2);
                return "";
            }
        }

        public JSONObject toJsonO() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AckUpdateStatEntity.OLD_VERSION, this.oldVersion);
                jSONObject.put(AckUpdateStatEntity.NEW_VERSION, this.newVersion);
                Map<String, String> map = this.domainFirstIp;
                if (map != null) {
                    jSONObject.put(AckUpdateStatEntity.DOMAIN_FIRST_IP, map.toString());
                }
                return jSONObject;
            } catch (JSONException e2) {
                NetLog.uploadException(e2);
                return null;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.oldVersion);
            parcel.writeInt(this.newVersion);
            parcel.writeMap(this.domainFirstIp);
        }

        public AckDnsUpdateStatEntity(int i2, int i3, Map<String, String> map) {
            this.domainFirstIp = new HashMap();
            this.oldVersion = i2;
            this.newVersion = i3;
            this.domainFirstIp = map;
        }
    }
}
