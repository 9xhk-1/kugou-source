package h.a.b;

import android.content.Context;
import android.util.Log;
import h.a.b.c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static final String a = "e";

    public static boolean a(Context context, List<e> list) {
        int identifier = context.getResources().getIdentifier("CronetProviderClassName", "string", context.getPackageName());
        if (identifier == 0) {
            return false;
        }
        String string = context.getResources().getString(identifier);
        if (b(context, string, list, true)) {
            return true;
        }
        throw new RuntimeException("Unable to instantiate Cronet implementation class " + string + " that is listed as in the app string resource file under CronetProviderClassName key");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(Context context, String str, List<e> list, boolean z) {
        try {
            list.add(context.getClassLoader().loadClass(str).asSubclass(e.class).getConstructor(Context.class).newInstance(context));
            return true;
        } catch (ClassNotFoundException e2) {
            h(str, z, e2);
            return false;
        } catch (IllegalAccessException e3) {
            h(str, z, e3);
            return false;
        } catch (InstantiationException e4) {
            h(str, z, e4);
            return false;
        } catch (NoSuchMethodException e5) {
            h(str, z, e5);
            return false;
        } catch (InvocationTargetException e6) {
            h(str, z, e6);
            return false;
        }
    }

    public static List<e> d(Context context) {
        ArrayList arrayList = new ArrayList();
        a(context, arrayList);
        b(context, "org.chromium.net.impl.NativeCronetProvider", arrayList, false);
        b(context, "org.chromium.net.impl.JavaCronetProvider", arrayList, false);
        return arrayList;
    }

    public static void h(String str, boolean z, Exception exc) {
        if (z) {
            Log.e(a, "Unable to load provider class: " + str, exc);
            return;
        }
        Log.d(a, "Tried to load " + str + " provider class but it wasn't included in the app classpath");
    }

    public abstract c.a c();

    public abstract String e();

    public abstract String f();

    public abstract boolean g();

    public String toString() {
        return "[class=" + e.class.getName() + ", name=" + e() + ", version=" + f() + ", enabled=" + g() + "]";
    }
}
