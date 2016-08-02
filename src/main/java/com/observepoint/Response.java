package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class Response {
    private Integer status;
    private String statusText;
    private String httpVersion;
    private Cookie[] cookies;
    private Header[] headers;
    private Content content;
    private String redirectionUrl;
    private Double headerSize;
    private Double bodySize;
    private String comment;

    public Double totalSize() {
        return (headerSize == null ? 0.0 : headerSize) + (bodySize == null ? 0.0 : bodySize);
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

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public Cookie[] getCookies() {
        return cookies;
    }

    public void setCookies(Cookie[] cookies) {
        this.cookies = cookies;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getRedirectionUrl() {
        return redirectionUrl;
    }

    public void setRedirectionUrl(String redirectionUrl) {
        this.redirectionUrl = redirectionUrl;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
