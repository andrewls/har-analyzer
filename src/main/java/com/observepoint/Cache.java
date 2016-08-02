package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class Cache {
    private CacheState beforeRequest;
    private CacheState afterRequest;
    private String comment;

    public CacheState getBeforeRequest() {
        return beforeRequest;
    }

    public void setBeforeRequest(CacheState beforeRequest) {
        this.beforeRequest = beforeRequest;
    }

    public CacheState getAfterRequest() {
        return afterRequest;
    }

    public void setAfterRequest(CacheState afterRequest) {
        this.afterRequest = afterRequest;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
