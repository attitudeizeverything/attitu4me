package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.internal.C0057c.C0346a;
import com.google.android.youtube.player.internal.C0063i.C0358a;
import com.google.android.youtube.player.internal.C0078t.C0076a;
import com.google.android.youtube.player.internal.C0078t.C0077b;
import java.util.ArrayList;
import jcifs.netbios.NbtException;
import jcifs.smb.SmbNamedPipe;

/* renamed from: com.google.android.youtube.player.internal.r */
public abstract class C0366r<T extends IInterface> implements C0078t {
    final Handler f126a;
    private final Context f127b;
    private T f128c;
    private ArrayList<C0076a> f129d;
    private final ArrayList<C0076a> f130e;
    private boolean f131f;
    private ArrayList<C0077b> f132g;
    private boolean f133h;
    private final ArrayList<C0074b<?>> f134i;
    private ServiceConnection f135j;
    private boolean f136k;

    /* renamed from: com.google.android.youtube.player.internal.r.1 */
    static /* synthetic */ class C00721 {
        static final /* synthetic */ int[] f39a;

        static {
            f39a = new int[YouTubeInitializationResult.values().length];
            try {
                f39a[YouTubeInitializationResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.a */
    final class C0073a extends Handler {
        final /* synthetic */ C0366r f40a;

        C0073a(C0366r c0366r) {
            this.f40a = c0366r;
        }

        public final void handleMessage(Message message) {
            if (message.what == 3) {
                this.f40a.m288a((YouTubeInitializationResult) message.obj);
            } else if (message.what == 4) {
                synchronized (this.f40a.f129d) {
                    if (this.f40a.f136k && this.f40a.m295f() && this.f40a.f129d.contains(message.obj)) {
                        ((C0076a) message.obj).m106a();
                    }
                }
            } else if (message.what == 2 && !this.f40a.m295f()) {
            } else {
                if (message.what == 2 || message.what == 1) {
                    ((C0074b) message.obj).m103a();
                }
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.b */
    protected abstract class C0074b<TListener> {
        final /* synthetic */ C0366r f41a;
        private TListener f42b;

        public C0074b(C0366r c0366r, TListener tListener) {
            this.f41a = c0366r;
            this.f42b = tListener;
            synchronized (c0366r.f134i) {
                c0366r.f134i.add(this);
            }
        }

        public final void m103a() {
            Object obj;
            synchronized (this) {
                obj = this.f42b;
            }
            m104a(obj);
        }

        protected abstract void m104a(TListener tListener);

        public final void m105b() {
            synchronized (this) {
                this.f42b = null;
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.e */
    final class C0075e implements ServiceConnection {
        final /* synthetic */ C0366r f43a;

        C0075e(C0366r c0366r) {
            this.f43a = c0366r;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f43a.m291b(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.f43a.f128c = null;
            this.f43a.m297h();
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.c */
    protected final class C0365c extends C0074b<Boolean> {
        public final YouTubeInitializationResult f123b;
        public final IBinder f124c;
        final /* synthetic */ C0366r f125d;

        public C0365c(C0366r c0366r, String str, IBinder iBinder) {
            this.f125d = c0366r;
            super(c0366r, Boolean.valueOf(true));
            this.f123b = C0366r.m282b(str);
            this.f124c = iBinder;
        }

        protected final /* synthetic */ void m277a(Object obj) {
            if (((Boolean) obj) != null) {
                switch (C00721.f39a[this.f123b.ordinal()]) {
                    case SmbNamedPipe.PIPE_TYPE_RDONLY /*1*/:
                        try {
                            if (this.f125d.m290b().equals(this.f124c.getInterfaceDescriptor())) {
                                this.f125d.f128c = this.f125d.m287a(this.f124c);
                                if (this.f125d.f128c != null) {
                                    this.f125d.m296g();
                                    return;
                                }
                            }
                        } catch (RemoteException e) {
                        }
                        this.f125d.m281a();
                        this.f125d.m288a(YouTubeInitializationResult.INTERNAL_ERROR);
                    default:
                        this.f125d.m288a(this.f123b);
                }
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.d */
    protected final class C0447d extends C0346a {
        final /* synthetic */ C0366r f155a;

        protected C0447d(C0366r c0366r) {
            this.f155a = c0366r;
        }

        public final void m338a(String str, IBinder iBinder) {
            this.f155a.f126a.sendMessage(this.f155a.f126a.obtainMessage(1, new C0365c(this.f155a, str, iBinder)));
        }
    }

    protected C0366r(Context context, C0076a c0076a, C0077b c0077b) {
        this.f130e = new ArrayList();
        this.f131f = false;
        this.f133h = false;
        this.f134i = new ArrayList();
        this.f136k = false;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        }
        this.f127b = (Context) ab.m25a((Object) context);
        this.f129d = new ArrayList();
        this.f129d.add(ab.m25a((Object) c0076a));
        this.f132g = new ArrayList();
        this.f132g.add(ab.m25a((Object) c0077b));
        this.f126a = new C0073a(this);
    }

    private void m281a() {
        if (this.f135j != null) {
            try {
                this.f127b.unbindService(this.f135j);
            } catch (Throwable e) {
                Log.w("YouTubeClient", "Unexpected error from unbindService()", e);
            }
        }
        this.f128c = null;
        this.f135j = null;
    }

    private static YouTubeInitializationResult m282b(String str) {
        try {
            return YouTubeInitializationResult.valueOf(str);
        } catch (IllegalArgumentException e) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        } catch (NullPointerException e2) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }

    protected abstract T m287a(IBinder iBinder);

    protected final void m288a(YouTubeInitializationResult youTubeInitializationResult) {
        this.f126a.removeMessages(4);
        synchronized (this.f132g) {
            this.f133h = true;
            ArrayList arrayList = this.f132g;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (this.f136k) {
                    if (this.f132g.contains(arrayList.get(i))) {
                        ((C0077b) arrayList.get(i)).m108a(youTubeInitializationResult);
                    }
                    i++;
                } else {
                    return;
                }
            }
            this.f133h = false;
        }
    }

    protected abstract void m289a(C0063i c0063i, C0447d c0447d) throws RemoteException;

    protected abstract String m290b();

    protected final void m291b(IBinder iBinder) {
        try {
            m289a(C0358a.m263a(iBinder), new C0447d(this));
        } catch (RemoteException e) {
            Log.w("YouTubeClient", "service died");
        }
    }

    protected abstract String m292c();

    public void m293d() {
        m297h();
        this.f136k = false;
        synchronized (this.f134i) {
            int size = this.f134i.size();
            for (int i = 0; i < size; i++) {
                ((C0074b) this.f134i.get(i)).m105b();
            }
            this.f134i.clear();
        }
        m281a();
    }

    public final void m294e() {
        this.f136k = true;
        YouTubeInitializationResult isYouTubeApiServiceAvailable = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this.f127b);
        if (isYouTubeApiServiceAvailable != YouTubeInitializationResult.SUCCESS) {
            this.f126a.sendMessage(this.f126a.obtainMessage(3, isYouTubeApiServiceAvailable));
            return;
        }
        Intent intent = new Intent(m292c()).setPackage(C0084z.m120a(this.f127b));
        if (this.f135j != null) {
            Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
            m281a();
        }
        this.f135j = new C0075e(this);
        if (!this.f127b.bindService(intent, this.f135j, NbtException.NOT_LISTENING_CALLING)) {
            this.f126a.sendMessage(this.f126a.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
        }
    }

    public final boolean m295f() {
        return this.f128c != null;
    }

    protected final void m296g() {
        boolean z = true;
        synchronized (this.f129d) {
            ab.m28a(!this.f131f);
            this.f126a.removeMessages(4);
            this.f131f = true;
            if (this.f130e.size() != 0) {
                z = false;
            }
            ab.m28a(z);
            ArrayList arrayList = this.f129d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.f136k && m295f(); i++) {
                if (!this.f130e.contains(arrayList.get(i))) {
                    ((C0076a) arrayList.get(i)).m106a();
                }
            }
            this.f130e.clear();
            this.f131f = false;
        }
    }

    protected final void m297h() {
        this.f126a.removeMessages(4);
        synchronized (this.f129d) {
            this.f131f = true;
            ArrayList arrayList = this.f129d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.f136k; i++) {
                if (this.f129d.contains(arrayList.get(i))) {
                    ((C0076a) arrayList.get(i)).m107b();
                }
            }
            this.f131f = false;
        }
    }

    protected final void m298i() {
        if (!m295f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected final T m299j() {
        m298i();
        return this.f128c;
    }
}
