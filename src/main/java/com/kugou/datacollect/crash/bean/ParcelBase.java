package com.kugou.datacollect.crash.bean;

import android.content.ContentValues;
import android.os.Parcel;
import e.c.c.o.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ParcelBase {
    public <T> T getDefaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parcel(Object obj, String str, T t, boolean z) {
        if (obj instanceof Parcel) {
            Parcel parcel = (Parcel) obj;
            if (t instanceof String) {
                if (z) {
                    return (T) parcel.readString();
                }
                parcel.writeString((String) t);
            } else if (t instanceof Long) {
                if (z) {
                    return (T) Long.valueOf(parcel.readLong());
                }
                parcel.writeLong(((Long) t).longValue());
            } else if (t instanceof Integer) {
                if (z) {
                    return (T) Integer.valueOf(parcel.readInt());
                }
                parcel.writeInt(((Integer) t).intValue());
            } else if (t instanceof Boolean) {
                if (z) {
                    return (T) Boolean.valueOf(parcel.readByte() != 0);
                }
                parcel.writeByte(((Boolean) t).booleanValue() ? (byte) 1 : (byte) 0);
            } else if (t instanceof Double) {
                if (z) {
                    return (T) Double.valueOf(parcel.readDouble());
                }
                parcel.writeDouble(((Double) t).doubleValue());
            }
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            try {
                if (t instanceof String) {
                    if (z) {
                        return (T) jSONObject.optString(str);
                    }
                    jSONObject.put(str, (String) t);
                } else if (t instanceof Long) {
                    if (z) {
                        return (T) Long.valueOf(jSONObject.optLong(str));
                    }
                    jSONObject.put(str, ((Long) t).longValue());
                } else if (t instanceof Integer) {
                    if (z) {
                        return (T) Integer.valueOf(jSONObject.optInt(str));
                    }
                    jSONObject.put(str, ((Integer) t).intValue());
                } else if (t instanceof Boolean) {
                    if (z) {
                        return (T) Boolean.valueOf(jSONObject.optBoolean(str));
                    }
                    jSONObject.put(str, ((Boolean) t).booleanValue());
                } else if (t instanceof Double) {
                    if (z) {
                        return (T) Double.valueOf(jSONObject.optDouble(str));
                    }
                    jSONObject.put(str, ((Double) t).doubleValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (obj instanceof ContentValues) {
            ContentValues contentValues = (ContentValues) obj;
            if (t instanceof String) {
                if (z) {
                    return (T) getDefaultIfNull(contentValues.getAsString(str), "");
                }
                contentValues.put(str, (String) t);
            } else if (t instanceof Long) {
                if (z) {
                    return (T) getDefaultIfNull(contentValues.getAsLong(str), 0L);
                }
                contentValues.put(str, (Long) t);
            } else if (t instanceof Integer) {
                if (z) {
                    return (T) getDefaultIfNull(contentValues.getAsInteger(str), 0);
                }
                contentValues.put(str, (Integer) t);
            } else if (t instanceof Boolean) {
                if (z) {
                    return (T) getDefaultIfNull(contentValues.getAsBoolean(str), Boolean.FALSE);
                }
                contentValues.put(str, (Boolean) t);
            } else if (t instanceof Double) {
                if (z) {
                    return (T) getDefaultIfNull(contentValues.getAsDouble(str), Double.valueOf(0.0d));
                }
                contentValues.put(str, (Double) t);
            }
        }
        if (z) {
            g.b("", "container is null, parcel error with key:" + str);
        }
        return t;
    }

    public abstract void parcel(Object obj, boolean z);
}
