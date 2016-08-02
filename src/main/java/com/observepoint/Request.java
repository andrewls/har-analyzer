package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class Request {
    private String method;
    private String url;
    private String httpVersion;
    private Cookie[] cookies;
    private Header[] headers;
    private QueryParam[] queryString;
    private PostData postData;
    private Double headerSize;
    private Double bodySize;
    private String comment;

    public double totalSize() {
        return (this.headerSize == null ? 0.0 : this.headerSize) + (this.bodySize == null ? 0.0 : this.bodySize);
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

    public QueryParam[] getQueryString() {
        return queryString;
    }

    public void setQueryString(QueryParam[] queryString) {
        this.queryString = queryString;
    }

    public PostData getPostData() {
        return postData;
    }

    public void setPostData(PostData postData) {
        this.postData = postData;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
