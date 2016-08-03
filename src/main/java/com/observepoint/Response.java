package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class Response {
    private Integer status;
    private String statusText;
    private Double headerSize;
    private Double bodySize;

    public Response() {
        headerSize = 0.0;
        bodySize = 0.0;
    }

    public Double totalSize() {
        return (headerSize == -1 ? 0.0 : headerSize) + (bodySize == -1 ? 0.0 : bodySize);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Double getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(Double headerSize) {
        this.headerSize = headerSize;
    }

    public Double getBodySize() {
        return bodySize;
    }

    public void setBodySize(Double bodySize) {
        this.bodySize = bodySize;
    }
}
