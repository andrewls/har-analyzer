package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class Request {
    private String method;
    private String url;
    private Double headerSize;
    private Double bodySize;

    public Request() {
        headerSize = 0.0;
        bodySize = 0.0;
    }

    public double totalSize() {
        return (this.headerSize == -1 ? 0.0 : this.headerSize) + (this.bodySize == -1 ? 0.0 : this.bodySize);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(double headerSize) {
        this.headerSize = headerSize;
    }

    public double getBodySize() {
        return bodySize;
    }

    public void setBodySize(double bodySize) {
        this.bodySize = bodySize;
    }
}