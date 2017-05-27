package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.internal.C0068n;
import com.google.android.youtube.player.internal.C0078t.C0076a;
import com.google.android.youtube.player.internal.C0078t.C0077b;
import com.google.android.youtube.player.internal.C0083y;
import com.google.android.youtube.player.internal.C0344b;
import com.google.android.youtube.player.internal.C0367s;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class YouTubePlayerView extends ViewGroup implements Provider {
    private final C0055a f95a;
    private final Set<View> f96b;
    private final C0056b f97c;
    private C0344b f98d;
    private C0367s f99e;
    private View f100f;
    private C0068n f101g;
    private Provider f102h;
    private Bundle f103i;
    private OnInitializedListener f104j;
    private boolean f105k;
    private boolean f106l;

    /* renamed from: com.google.android.youtube.player.YouTubePlayerView.a */
    private final class C0055a implements OnGlobalFocusChangeListener {
        final /* synthetic */ YouTubePlayerView f13a;

        private C0055a(YouTubePlayerView youTubePlayerView) {
            this.f13a = youTubePlayerView;
        }

        public final void onGlobalFocusChanged(View view, View view2) {
            if (this.f13a.f99e != null && this.f13a.f96b.contains(view2) && !this.f13a.f96b.contains(view)) {
                this.f13a.f99e.m312g();
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.YouTubePlayerView.b */
    interface C0056b {
        void m13a(YouTubePlayerView youTubePlayerView);

        void m14a(YouTubePlayerView youTubePlayerView, String str, OnInitializedListener onInitializedListener);
    }

    /* renamed from: com.google.android.youtube.player.YouTubePlayerView.1 */
    class C03401 implements C0076a {
        final /* synthetic */ Activity f92a;
        final /* synthetic */ YouTubePlayerView f93b;

        C03401(YouTubePlayerView youTubePlayerView, Activity activity) {
            this.f93b = youTubePlayerView;
            this.f92a = activity;
        }

        public final void m154a() {
            if (this.f93b.f98d != null) {
                YouTubePlayerView.m160a(this.f93b, this.f92a);
            }
            this.f93b.f98d = null;
        }

        public final void m155b() {
            if (!(this.f93b.f106l || this.f93b.f99e == null)) {
                this.f93b.f99e.m311f();
            }
            this.f93b.f101g.m100a();
            if (this.f93b.indexOfChild(this.f93b.f101g) < 0) {
                this.f93b.addView(this.f93b.f101g);
                this.f93b.removeView(this.f93b.f100f);
            }
            this.f93b.f100f = null;
            this.f93b.f99e = null;
            this.f93b.f98d = null;
        }
    }

    /* renamed from: com.google.android.youtube.player.YouTubePlayerView.2 */
    class C03412 implements C0077b {
        final /* synthetic */ YouTubePlayerView f94a;

        C03412(YouTubePlayerView youTubePlayerView) {
            this.f94a = youTubePlayerView;
        }

        public final void m156a(YouTubeInitializationResult youTubeInitializationResult) {
            this.f94a.m159a(youTubeInitializationResult);
            this.f94a.f98d = null;
        }
    }

    public YouTubePlayerView(Context context) {
        this(context, null);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        if (context instanceof YouTubeBaseActivity) {
            this(context, attributeSet, i, ((YouTubeBaseActivity) context).m6a());
            return;
        }
        throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity  which extends YouTubeBaseActivity as its context.");
    }

    YouTubePlayerView(Context context, AttributeSet attributeSet, int i, C0056b c0056b) {
        super((Context) ab.m26a((Object) context, (Object) "context cannot be null"), attributeSet, i);
        this.f97c = (C0056b) ab.m26a((Object) c0056b, (Object) "listener cannot be null");
        if (getBackground() == null) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        setClipToPadding(false);
        this.f101g = new C0068n(context);
        requestTransparentRegion(this.f101g);
        addView(this.f101g);
        this.f96b = new HashSet();
        this.f95a = new C0055a();
    }

    private void m158a(View view) {
        Object obj = (view == this.f101g || (this.f99e != null && view == this.f100f)) ? 1 : null;
        if (obj == null) {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        }
    }

    private void m159a(YouTubeInitializationResult youTubeInitializationResult) {
        this.f99e = null;
        this.f101g.m102c();
        if (this.f104j != null) {
            this.f104j.onInitializationFailure(this.f102h, youTubeInitializationResult);
            this.f104j = null;
        }
    }

    static /* synthetic */ void m160a(YouTubePlayerView youTubePlayerView, Activity activity) {
        try {
            youTubePlayerView.f99e = new C0367s(youTubePlayerView.f98d, aa.m20a().m24a(activity, youTubePlayerView.f98d, youTubePlayerView.f105k));
            youTubePlayerView.f100f = youTubePlayerView.f99e.m300a();
            youTubePlayerView.addView(youTubePlayerView.f100f);
            youTubePlayerView.removeView(youTubePlayerView.f101g);
            youTubePlayerView.f97c.m13a(youTubePlayerView);
            if (youTubePlayerView.f104j != null) {
                boolean z = false;
                if (youTubePlayerView.f103i != null) {
                    z = youTubePlayerView.f99e.m304a(youTubePlayerView.f103i);
                    youTubePlayerView.f103i = null;
                }
                youTubePlayerView.f104j.onInitializationSuccess(youTubePlayerView.f102h, youTubePlayerView.f99e, z);
                youTubePlayerView.f104j = null;
            }
        } catch (Throwable e) {
            C0083y.m116a("Error creating YouTubePlayerView", e);
            youTubePlayerView.m159a(YouTubeInitializationResult.INTERNAL_ERROR);
        }
    }

    final void m170a() {
        if (this.f99e != null) {
            this.f99e.m305b();
        }
    }

    final void m171a(Activity activity, Provider provider, String str, OnInitializedListener onInitializedListener, Bundle bundle) {
        if (this.f99e == null && this.f104j == null) {
            ab.m26a((Object) activity, (Object) "activity cannot be null");
            this.f102h = (Provider) ab.m26a((Object) provider, (Object) "provider cannot be null");
            this.f104j = (OnInitializedListener) ab.m26a((Object) onInitializedListener, (Object) "listener cannot be null");
            this.f103i = bundle;
            this.f101g.m101b();
            this.f98d = aa.m20a().m23a(getContext(), str, new C03401(this, activity), new C03412(this));
            this.f98d.m110e();
        }
    }

    final void m172a(boolean z) {
        if (!z || VERSION.SDK_INT >= 14) {
            this.f105k = z;
            return;
        }
        C0083y.m117a("Could not enable TextureView because API level is lower than 14", new Object[0]);
        this.f105k = false;
    }

    public final void addFocusables(ArrayList<View> arrayList, int i) {
        Collection arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i);
        arrayList.addAll(arrayList2);
        this.f96b.clear();
        this.f96b.addAll(arrayList2);
    }

    public final void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        Collection arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i, i2);
        arrayList.addAll(arrayList2);
        this.f96b.clear();
        this.f96b.addAll(arrayList2);
    }

    public final void addView(View view) {
        m158a(view);
        super.addView(view);
    }

    public final void addView(View view, int i) {
        m158a(view);
        super.addView(view, i);
    }

    public final void addView(View view, int i, int i2) {
        m158a(view);
        super.addView(view, i, i2);
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        m158a(view);
        super.addView(view, i, layoutParams);
    }

    public final void addView(View view, LayoutParams layoutParams) {
        m158a(view);
        super.addView(view, layoutParams);
    }

    final void m173b() {
        if (this.f99e != null) {
            this.f99e.m308c();
        }
    }

    final void m174b(boolean z) {
        if (this.f99e != null) {
            this.f99e.m306b(z);
            m176c(z);
        }
    }

    final void m175c() {
        if (this.f99e != null) {
            this.f99e.m309d();
        }
    }

    final void m176c(boolean z) {
        this.f106l = true;
        if (this.f99e != null) {
            this.f99e.m302a(z);
        }
    }

    public final void clearChildFocus(View view) {
        if (hasFocusable()) {
            requestFocus();
        } else {
            super.clearChildFocus(view);
        }
    }

    final void m177d() {
        if (this.f99e != null) {
            this.f99e.m310e();
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f99e != null) {
            if (keyEvent.getAction() == 0) {
                return this.f99e.m303a(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            } else {
                if (keyEvent.getAction() == 1) {
                    return this.f99e.m307b(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    final Bundle m178e() {
        return this.f99e == null ? this.f103i : this.f99e.m313h();
    }

    public final void focusableViewAvailable(View view) {
        super.focusableViewAvailable(view);
        this.f96b.add(view);
    }

    public final void initialize(String str, OnInitializedListener onInitializedListener) {
        ab.m27a(str, (Object) "Developer key cannot be null or empty");
        this.f97c.m14a(this, str, onInitializedListener);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.f95a);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f99e != null) {
            this.f99e.m301a(configuration);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.f95a);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, i3 - i, i4 - i2);
        }
    }

    protected final void onMeasure(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.measure(i, i2);
            setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.f96b.add(view2);
    }

    public final void setClipToPadding(boolean z) {
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
    }
}
