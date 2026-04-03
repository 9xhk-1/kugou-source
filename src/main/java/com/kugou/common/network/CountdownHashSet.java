package com.kugou.common.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CountdownHashSet<E> implements Set<E> {
    private Set<E> mCore = Collections.synchronizedSet(new HashSet());
    private Handler mUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.kugou.common.network.CountdownHashSet.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CountdownHashSet.this.remove(message.obj);
        }
    };

    public boolean add(E e2, int i2) {
        this.mUIHandler.removeMessages(e2.hashCode());
        this.mUIHandler.sendMessageDelayed(this.mUIHandler.obtainMessage(e2.hashCode(), e2), i2);
        return add(e2);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return this.mCore.addAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.mCore.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.mCore.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.mCore.containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        return this.mCore.equals(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.mCore.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.mCore.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.mCore.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.mCore.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.mCore.retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.mCore.retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.mCore.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.mCore.toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.mCore.toArray(tArr);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E e2) {
        return this.mCore.add(e2);
    }
}
