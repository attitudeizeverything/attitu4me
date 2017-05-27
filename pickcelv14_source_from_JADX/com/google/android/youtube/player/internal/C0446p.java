package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.C0064j.C0360a;

/* renamed from: com.google.android.youtube.player.internal.p */
public final class C0446p extends C0343a {
    private final Handler f150a;
    private C0344b f151b;
    private C0065k f152c;
    private boolean f153d;
    private boolean f154e;

    /* renamed from: com.google.android.youtube.player.internal.p.a */
    private final class C0445a extends C0360a {
        final /* synthetic */ C0446p f149a;

        /* renamed from: com.google.android.youtube.player.internal.p.a.1 */
        class C00691 implements Runnable {
            final /* synthetic */ boolean f30a;
            final /* synthetic */ boolean f31b;
            final /* synthetic */ Bitmap f32c;
            final /* synthetic */ String f33d;
            final /* synthetic */ C0445a f34e;

            C00691(C0445a c0445a, boolean z, boolean z2, Bitmap bitmap, String str) {
                this.f34e = c0445a;
                this.f30a = z;
                this.f31b = z2;
                this.f32c = bitmap;
                this.f33d = str;
            }

            public final void run() {
                this.f34e.f149a.f153d = this.f30a;
                this.f34e.f149a.f154e = this.f31b;
                this.f34e.f149a.m184a(this.f32c, this.f33d);
            }
        }

        /* renamed from: com.google.android.youtube.player.internal.p.a.2 */
        class C00702 implements Runnable {
            final /* synthetic */ boolean f35a;
            final /* synthetic */ boolean f36b;
            final /* synthetic */ String f37c;
            final /* synthetic */ C0445a f38d;

            C00702(C0445a c0445a, boolean z, boolean z2, String str) {
                this.f38d = c0445a;
                this.f35a = z;
                this.f36b = z2;
                this.f37c = str;
            }

            public final void run() {
                this.f38d.f149a.f153d = this.f35a;
                this.f38d.f149a.f154e = this.f36b;
                this.f38d.f149a.m189b(this.f37c);
            }
        }

        private C0445a(C0446p c0446p) {
            this.f149a = c0446p;
        }

        public final void m324a(Bitmap bitmap, String str, boolean z, boolean z2) {
            this.f149a.f150a.post(new C00691(this, z, z2, bitmap, str));
        }

        public final void m325a(String str, boolean z, boolean z2) {
            this.f149a.f150a.post(new C00702(this, z, z2, str));
        }
    }

    public C0446p(C0344b c0344b, YouTubeThumbnailView youTubeThumbnailView) {
        super(youTubeThumbnailView);
        this.f151b = (C0344b) ab.m26a((Object) c0344b, (Object) "connectionClient cannot be null");
        this.f152c = c0344b.m200a(new C0445a());
        this.f150a = new Handler(Looper.getMainLooper());
    }

    public final void m329a(String str) {
        try {
            this.f152c.m92a(str);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final void m330a(String str, int i) {
        try {
            this.f152c.m93a(str, i);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected final boolean m331a() {
        return super.m187a() && this.f152c != null;
    }

    public final void m332c() {
        try {
            this.f152c.m91a();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final void m333d() {
        try {
            this.f152c.m94b();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final void m334e() {
        try {
            this.f152c.m95c();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final boolean m335f() {
        return this.f154e;
    }

    public final boolean m336g() {
        return this.f153d;
    }

    public final void m337h() {
        try {
            this.f152c.m96d();
        } catch (RemoteException e) {
        }
        this.f151b.m109d();
        this.f152c = null;
        this.f151b = null;
    }
}
