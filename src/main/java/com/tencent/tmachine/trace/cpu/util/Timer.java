package com.tencent.tmachine.trace.cpu.util;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class Timer implements Parcelable {
    public static final Parcelable.Creator<Timer> CREATOR = new Parcelable.Creator<Timer>() { // from class: com.tencent.tmachine.trace.cpu.util.Timer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timer createFromParcel(Parcel parcel) {
            return new Timer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timer[] newArray(int i2) {
            return new Timer[i2];
        }
    };
    private long highResTime;
    private long timeInMicros;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCurrentTimestampMicros() {
        return this.timeInMicros + getDurationMicros();
    }

    public long getDurationMicros() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.highResTime);
    }

    public long getMicros() {
        return this.timeInMicros;
    }

    public long getMill() {
        return this.timeInMicros / 1000;
    }

    public void reset() {
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timeInMicros);
        parcel.writeLong(this.highResTime);
    }

    public Timer() {
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    public long getDurationMicros(@NonNull Timer timer) {
        return TimeUnit.NANOSECONDS.toMicros(timer.highResTime - this.highResTime);
    }

    public Timer(long j) {
        this.timeInMicros = j;
        this.highResTime = TimeUnit.MICROSECONDS.toNanos(j);
    }

    public Timer(long j, long j2) {
        this.timeInMicros = j;
        this.highResTime = j2;
    }

    private Timer(Parcel parcel) {
        this.timeInMicros = parcel.readLong();
        this.highResTime = parcel.readLong();
    }
}
