package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.C0078t.C0076a;
import com.google.android.youtube.player.internal.C0078t.C0077b;
import com.google.android.youtube.player.internal.C0366r.C0447d;

/* renamed from: com.google.android.youtube.player.internal.o */
public final class C0444o extends C0366r<C0066l> implements C0344b {
    private final String f145b;
    private final String f146c;
    private final String f147d;
    private boolean f148e;

    public C0444o(Context context, String str, String str2, String str3, C0076a c0076a, C0077b c0077b) {
        super(context, c0076a, c0077b);
        this.f145b = (String) ab.m25a((Object) str);
        this.f146c = ab.m27a(str2, (Object) "callingPackage cannot be null or empty");
        this.f147d = ab.m27a(str3, (Object) "callingAppVersion cannot be null or empty");
    }

    private final void m315k() {
        m298i();
        if (this.f148e) {
            throw new IllegalStateException("Connection client has been released");
        }
    }

    public final IBinder m316a() {
        m315k();
        try {
            return ((C0066l) m299j()).m97a();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final C0065k m318a(C0064j c0064j) {
        m315k();
        try {
            return ((C0066l) m299j()).m98a(c0064j);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected final void m319a(C0063i c0063i, C0447d c0447d) throws RemoteException {
        c0063i.m88a(c0447d, 1201, this.f146c, this.f147d, this.f145b, null);
    }

    public final void m320a(boolean z) {
        if (m295f()) {
            try {
                ((C0066l) m299j()).m99a(z);
            } catch (RemoteException e) {
            }
            this.f148e = true;
        }
    }

    protected final String m321b() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    protected final String m322c() {
        return "com.google.android.youtube.api.service.START";
    }

    public final void m323d() {
        if (!this.f148e) {
            m320a(true);
        }
        super.m293d();
    }
}
