package com.kugou.framework.lyricanim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncBounceResLoader {

    public static final class BounceResEntity {
        public final WeakReference<IBounceView> bounceViewRefs;
        public final int[] resArray;

        public BounceResEntity(int[] iArr, IBounceView iBounceView) {
            this.resArray = iArr;
            this.bounceViewRefs = new WeakReference<>(iBounceView);
        }
    }

    public static void asyncLoadBounceRes(int[] iArr, final IBounceView iBounceView) {
        AsyncTaskCompat.executeParallel(new AsyncTask<BounceResEntity, Void, List<Bitmap>>() { // from class: com.kugou.framework.lyricanim.AsyncBounceResLoader.1
            @Override // android.os.AsyncTask
            public List<Bitmap> doInBackground(BounceResEntity... bounceResEntityArr) {
                if (bounceResEntityArr != null && bounceResEntityArr.length == 1) {
                    BounceResEntity bounceResEntity = bounceResEntityArr[0];
                    if (bounceResEntity == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    IBounceView iBounceView2 = bounceResEntity.bounceViewRefs.get();
                    if (iBounceView2 != null) {
                        for (int i2 = 0; i2 < bounceResEntity.resArray.length; i2++) {
                            arrayList.add(BitmapFactory.decodeResource(iBounceView2.getContext().getResources(), bounceResEntity.resArray[i2]));
                        }
                        return arrayList;
                    }
                }
                return null;
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(List<Bitmap> list) {
                super.onPostExecute(list);
                iBounceView.setBounceBitmaps(list);
            }
        }, new BounceResEntity[]{new BounceResEntity(iArr, iBounceView)});
    }
}
