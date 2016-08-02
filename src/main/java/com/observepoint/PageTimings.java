package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class PageTimings {
    private Double onContentLoad;
    private Double onLoad;
    private String comment;

    public double getOnContentLoad() {
        return onContentLoad;
    }

    public void setOnContentLoad(double onContentLoad) {
        this.onContentLoad = onContentLoad;
    }

    public double getOnLoad() {
        return onLoad;
    }

    public void setOnLoad(double onLoad) {
        this.onLoad = onLoad;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
