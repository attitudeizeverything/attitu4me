package com.mstar.android.dlna;

public class ShareObject {
    private String id;
    private String metadata;
    private String parent_id;
    private String title;

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getParentID() {
        return this.parent_id;
    }

    public void setParentID(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetadata() {
        return this.metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String toString() {
        return "ShareObject [id=" + this.id + ", parent_id=" + this.parent_id + ", title=" + this.title + "]";
    }
}
