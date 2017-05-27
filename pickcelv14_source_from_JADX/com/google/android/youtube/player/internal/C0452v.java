package com.google.android.youtube.player.internal;

import android.os.IBinder;
import com.google.android.youtube.player.internal.C0079u.C0369a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.youtube.player.internal.v */
public final class C0452v<T> extends C0369a {
    private final T f164a;

    private C0452v(T t) {
        this.f164a = t;
    }

    public static <T> C0079u m354a(T t) {
        return new C0452v(t);
    }

    public static <T> T m355a(C0079u c0079u) {
        if (c0079u instanceof C0452v) {
            return ((C0452v) c0079u).f164a;
        }
        IBinder asBinder = c0079u.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
