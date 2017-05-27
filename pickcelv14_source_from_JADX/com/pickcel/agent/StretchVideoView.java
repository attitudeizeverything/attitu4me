package com.pickcel.agent;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class StretchVideoView extends VideoView {
    private int mVideoHeight;
    private int mVideoWidth;

    public StretchVideoView(Context context) {
        this(context, null);
    }

    public StretchVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StretchVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setWidth(int width) {
        this.mVideoWidth = width;
    }

    public void setHeight(int height) {
        this.mVideoHeight = height;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(this.mVideoWidth, this.mVideoHeight);
    }
}
