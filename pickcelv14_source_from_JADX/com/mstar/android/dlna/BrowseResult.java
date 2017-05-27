package com.mstar.android.dlna;

import java.util.ArrayList;

public class BrowseResult {
    private ArrayList<ShareObject> share_objects;
    private int total_matches;

    public BrowseResult(ArrayList<ShareObject> share_objects, int total_matches) {
        this.share_objects = share_objects;
        this.total_matches = total_matches;
    }

    public ArrayList<ShareObject> getShareObjects() {
        return this.share_objects;
    }

    public void setShareObjects(ArrayList<ShareObject> share_objects) {
        this.share_objects = share_objects;
    }

    public int getTotalMatches() {
        return this.total_matches;
    }

    public void setTotalMatches(int total_matches) {
        this.total_matches = total_matches;
    }
}
