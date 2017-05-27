package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailLoader.ErrorReason;
import com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener;
import com.google.android.youtube.player.YouTubeThumbnailView;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.youtube.player.internal.a */
public abstract class C0343a implements YouTubeThumbnailLoader {
    private final WeakReference<YouTubeThumbnailView> f109a;
    private OnThumbnailLoadedListener f110b;
    private boolean f111c;
    private boolean f112d;

    public C0343a(YouTubeThumbnailView youTubeThumbnailView) {
        this.f109a = new WeakReference(ab.m25a((Object) youTubeThumbnailView));
    }

    private void m183i() {
        if (!m187a()) {
            throw new IllegalStateException("This YouTubeThumbnailLoader has been released");
        }
    }

    public final void m184a(Bitmap bitmap, String str) {
        YouTubeThumbnailView youTubeThumbnailView = (YouTubeThumbnailView) this.f109a.get();
        if (m187a() && youTubeThumbnailView != null) {
            youTubeThumbnailView.setImageBitmap(bitmap);
            if (this.f110b != null) {
                this.f110b.onThumbnailLoaded(youTubeThumbnailView, str);
            }
        }
    }

    public abstract void m185a(String str);

    public abstract void m186a(String str, int i);

    protected boolean m187a() {
        return !this.f112d;
    }

    public final void m188b() {
        if (m187a()) {
            C0083y.m117a("The finalize() method for a YouTubeThumbnailLoader has work to do. You should have called release().", new Object[0]);
            release();
        }
    }

    public final void m189b(String str) {
        YouTubeThumbnailView youTubeThumbnailView = (YouTubeThumbnailView) this.f109a.get();
        if (m187a() && this.f110b != null && youTubeThumbnailView != null) {
            ErrorReason valueOf;
            try {
                valueOf = ErrorReason.valueOf(str);
            } catch (IllegalArgumentException e) {
                valueOf = ErrorReason.UNKNOWN;
            } catch (NullPointerException e2) {
                valueOf = ErrorReason.UNKNOWN;
            }
            this.f110b.onThumbnailError(youTubeThumbnailView, valueOf);
        }
    }

    public abstract void m190c();

    public abstract void m191d();

    public abstract void m192e();

    public abstract boolean m193f();

    public final void first() {
        m183i();
        if (this.f111c) {
            m192e();
            return;
        }
        throw new IllegalStateException("Must call setPlaylist first");
    }

    public abstract boolean m194g();

    public abstract void m195h();

    public final boolean hasNext() {
        m183i();
        return m193f();
    }

    public final boolean hasPrevious() {
        m183i();
        return m194g();
    }

    public final void next() {
        m183i();
        if (!this.f111c) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (m193f()) {
            m190c();
        } else {
            throw new NoSuchElementException("Called next at end of playlist");
        }
    }

    public final void previous() {
        m183i();
        if (!this.f111c) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (m194g()) {
            m191d();
        } else {
            throw new NoSuchElementException("Called previous at start of playlist");
        }
    }

    public final void release() {
        if (m187a()) {
            this.f112d = true;
            this.f110b = null;
            m195h();
        }
    }

    public final void setOnThumbnailLoadedListener(OnThumbnailLoadedListener onThumbnailLoadedListener) {
        m183i();
        this.f110b = onThumbnailLoadedListener;
    }

    public final void setPlaylist(String str) {
        setPlaylist(str, 0);
    }

    public final void setPlaylist(String str, int i) {
        m183i();
        this.f111c = true;
        m186a(str, i);
    }

    public final void setVideo(String str) {
        m183i();
        this.f111c = false;
        m185a(str);
    }
}
