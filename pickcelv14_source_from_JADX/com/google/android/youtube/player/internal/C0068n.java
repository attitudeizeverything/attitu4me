package com.google.android.youtube.player.internal;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;

/* renamed from: com.google.android.youtube.player.internal.n */
public final class C0068n extends FrameLayout {
    private final ProgressBar f28a;
    private final TextView f29b;

    public C0068n(Context context) {
        super(context, null, C0084z.m126c(context));
        C0067m c0067m = new C0067m(context);
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f28a = new ProgressBar(context);
        this.f28a.setVisibility(8);
        addView(this.f28a, new LayoutParams(-2, -2, 17));
        int i = (int) ((10.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
        this.f29b = new TextView(context);
        this.f29b.setTextAppearance(context, 16973894);
        this.f29b.setTextColor(-1);
        this.f29b.setVisibility(8);
        this.f29b.setPadding(i, i, i, i);
        this.f29b.setGravity(17);
        this.f29b.setText(c0067m.f18a);
        addView(this.f29b, new LayoutParams(-2, -2, 17));
    }

    public final void m100a() {
        this.f28a.setVisibility(8);
        this.f29b.setVisibility(8);
    }

    public final void m101b() {
        this.f28a.setVisibility(0);
        this.f29b.setVisibility(8);
    }

    public final void m102c() {
        this.f28a.setVisibility(8);
        this.f29b.setVisibility(0);
    }

    protected final void onMeasure(int i, int i2) {
        int i3 = 0;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == SmbConstants.GENERIC_WRITE && mode2 == SmbConstants.GENERIC_WRITE) {
            i3 = size;
        } else if (mode == SmbConstants.GENERIC_WRITE || (mode == ExploreByTouchHelper.INVALID_ID && mode2 == 0)) {
            size2 = (int) (((float) size) / 1.777f);
            i3 = size;
        } else if (mode2 == SmbConstants.GENERIC_WRITE || (mode2 == ExploreByTouchHelper.INVALID_ID && mode == 0)) {
            i3 = (int) (((float) size2) * 1.777f);
        } else if (mode != ExploreByTouchHelper.INVALID_ID || mode2 != ExploreByTouchHelper.INVALID_ID) {
            size2 = 0;
        } else if (((float) size2) < ((float) size) / 1.777f) {
            i3 = (int) (((float) size2) * 1.777f);
        } else {
            size2 = (int) (((float) size) / 1.777f);
            i3 = size;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(C0068n.resolveSize(i3, i), SmbConstants.GENERIC_WRITE), MeasureSpec.makeMeasureSpec(C0068n.resolveSize(size2, i2), SmbConstants.GENERIC_WRITE));
    }
}
