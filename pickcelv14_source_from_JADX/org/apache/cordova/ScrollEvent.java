package org.apache.cordova;

import android.view.View;

public class ScrollEvent {
    public int f75l;
    public int nl;
    public int nt;
    public int f76t;
    private View targetView;

    ScrollEvent(int nx, int ny, int x, int y, View view) {
        this.f75l = x;
        y = this.f76t;
        this.nl = nx;
        this.nt = ny;
        this.targetView = view;
    }

    public int dl() {
        return this.nl - this.f75l;
    }

    public int dt() {
        return this.nt - this.f76t;
    }

    public View getTargetView() {
        return this.targetView;
    }
}
