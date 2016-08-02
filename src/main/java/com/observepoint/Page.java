package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class Page {
    private String startedDateTime;
    private String id;
    private String title;
    private PageTimings pageTimings;
    private String comments;

    public String getStartedDateTime() {
        return startedDateTime;
    }

    public void setStartedDateTime(String startedDateTime) {
        this.startedDateTime = startedDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PageTimings getPageTimings() {
        return pageTimings;
    }

    public void setPageTimings(PageTimings pageTimings) {
        this.pageTimings = pageTimings;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
