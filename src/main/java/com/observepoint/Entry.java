package com.observepoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 7/24/16.
 */
public class Entry implements Comparable<Entry> {
    private Double time;
    private Request request;
    private Response response;
    private Timing[] timings;

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

    public Timing[] getTimings() {
        return timings;
    }

    public void setTimings(Timing[] timings) {
        this.timings = timings;
    }

    public Timing getTimingTotals() {
        List<Timing> timingsList = new ArrayList<>(timings.length + 1);
        timingsList.add(new Timing());
        for (Timing timing: timings) {
            timingsList.add(timing);
        }
        Timing[] timingsArray = new Timing[timingsList.size()];
        return Timing.merge(timingsList.toArray(timingsArray));
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
