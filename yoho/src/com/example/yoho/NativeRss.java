package com.example.yoho;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;

public class NativeRss extends TextView {
    private boolean mPaused;
    private Scroller mSlr;
    private int speedOfRss;
    private int startPositionOfRss;

    public NativeRss(Context context) {
        this(context, null);
        setSingleLine();
        setEllipsize(null);
        setVisibility(4);
    }

    public NativeRss(Context context, AttributeSet attrs) {
        this(context, attrs, 16842884);
        setSingleLine();
        setEllipsize(null);
        setVisibility(4);
    }

    public NativeRss(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mPaused = true;
        setSingleLine();
        setEllipsize(null);
        setVisibility(4);
    }

    public void setSpeed(int speed) {
        this.speedOfRss = speed;
    }

    public void setStartPosition(int startPosition) {
        this.startPositionOfRss = startPosition;
    }

    public void startScroll() {
        this.mPaused = true;
        resumeScroll();
    }

    public void resumeScroll() {
        if (this.mPaused) {
            setHorizontallyScrolling(true);
            this.mSlr = new Scroller(getContext(), new LinearInterpolator());
            setScroller(this.mSlr);
            int distance = calculateScrollingLen() - (getWidth() + this.startPositionOfRss);
            setVisibility(0);
            this.mSlr.startScroll(this.startPositionOfRss, 0, distance, 0, this.speedOfRss);
            invalidate();
            this.mPaused = false;
        }
    }

    private int calculateScrollingLen() {
        TextPaint tp = getPaint();
        Rect rect = new Rect();
        String strTxt = getText().toString();
        tp.getTextBounds(strTxt, 0, strTxt.length(), rect);
        return rect.width() + getWidth();
    }

    public void pauseScroll() {
        if (this.mSlr != null && !this.mPaused) {
            this.mPaused = true;
            this.startPositionOfRss = this.mSlr.getCurrX();
            this.mSlr.abortAnimation();
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.mSlr != null && this.mSlr.isFinished() && !this.mPaused) {
            startScroll();
        }
    }

    public int getRndDuration() {
        return this.startPositionOfRss;
    }

    public void setRndDuration(int duration) {
        this.startPositionOfRss = duration;
    }

    public boolean isPaused() {
        return this.mPaused;
    }
}
