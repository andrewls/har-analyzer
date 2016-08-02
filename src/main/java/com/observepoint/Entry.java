package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class Entry implements Comparable<Entry> {
    private String pageref;
    private String startedDateTime;
    private Double time;
    private Request request;
    private Response response;
    private Cache cache;
    private Timing[] timings;
    private String serverIPAddress;
    private String connection;
    private String comment;

    public String getPageref() {
        return pageref;
    }

    public void setPageref(String pageref) {
        this.pageref = pageref;
    }

    public String getStartedDateTime() {
        return startedDateTime;
    }

    public void setStartedDateTime(String startedDateTime) {
        this.startedDateTime = startedDateTime;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public Timing[] getTimings() {
        return timings;
    }

    public void setTimings(Timing[] timings) {
        this.timings = timings;
    }

    public String getServerIPAddress() {
        return serverIPAddress;
    }

    public void setServerIPAddress(String serverIPAddress) {
        this.serverIPAddress = serverIPAddress;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timing getTimingTotals() {
        return Timing.merge(timings);
    }

    public double getBytesSent() {
        if (request != null) {
            return request.totalSize();
        }
        return 0;
    }

    public double getBytesReceived() {
        if (response != null) {
            return response.totalSize();
        }
        return 0;
    }

    @Override
    /**
     * This method is used for comparison, and in this case that means determining the order of the priority queue for fastest/slowest requests
     */
    public int compareTo(Entry other) {
        double totalTime = time == null ? (timings == null ? 0.0 : Timing.merge(timings).getTotal()) : time;
        double otherTime = other.time == null ? (other.timings == null ? 0.0 : Timing.merge(other.timings).getTotal()) : other.time;
        double difference = totalTime - otherTime;
        if (difference < 0) return -1;
        if (difference > 0) return 1;
        return 0;
    }
}
