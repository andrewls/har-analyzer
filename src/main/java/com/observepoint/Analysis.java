package com.observepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by andrew on 8/2/16.
 */
public class Analysis {

    private final int NUM_REQUESTS_TO_SHOW = 5;

    private Integer pagesRequested;
    private Integer httpRequestsMade;
    private Double bytesSent;
    private Double bytesReceived;
    private Double millisecondsElapsed;
    private Double percentageOfTimeBlocked;
    private Double percentageOfTimeDns;
    private Double percentageOfTimeConnecting;
    private Double percentageOfTimeSending;
    private Double percentageOfTimeWaiting;
    private Double percentageOfTimeReceiving;
    private Double percentageOfTimeSsl;
    private Double averageBytesUploadedPerSecond;
    private Double averageBytesDownloadedPerSecond;
    private Entry[] slowestRequests = new Entry[NUM_REQUESTS_TO_SHOW];
    private Entry[] fastestRequests = new Entry[NUM_REQUESTS_TO_SHOW];

    public void addTimingData(Timing totals) {
        percentageOfTimeBlocked = totals.getPercentageBlocked();
        percentageOfTimeDns = totals.getPercentageDns();
        percentageOfTimeConnecting = totals.getPercentageConnect();
        percentageOfTimeSending = totals.getPercentageSend();
        percentageOfTimeWaiting = totals.getPercentageWait();
        percentageOfTimeReceiving = totals.getPercentageReceive();
        percentageOfTimeSsl = totals.getPercentageSsl();
        millisecondsElapsed = totals.getTotal();
    }

    public void addDataTransmissionInfo(double sent, double received, double millisecondsElapsed) {
        bytesSent = sent;
        bytesReceived = received;
        averageBytesUploadedPerSecond = sent / (millisecondsElapsed/1000);
        averageBytesDownloadedPerSecond = received / (millisecondsElapsed/1000);
    }

    public void addDataTransmissionInfo(double sent, double received) {
        if (this.millisecondsElapsed != null && this.millisecondsElapsed != 0.0) {
            addDataTransmissionInfo(sent, received, this.millisecondsElapsed);
            return;
        }
        bytesSent = sent;
        bytesReceived = received;
    }

    public void addFastestAndSlowestRequests(PriorityQueue<Entry> entries) {
        List<Entry> sortedEntries = new ArrayList<>();
        while (entries.size() > 0) {
            sortedEntries.add(entries.poll());
        }
        for (int i = 0; i < NUM_REQUESTS_TO_SHOW && i < sortedEntries.size(); i++) {
            fastestRequests[i] = sortedEntries.get(i);
            slowestRequests[i] = sortedEntries.get(sortedEntries.size() - i - 1);
        }
    }

    public Integer getPagesRequested() {
        return pagesRequested;
    }

    public void setPagesRequested(Integer pagesRequested) {
        this.pagesRequested = pagesRequested;
    }

    public Integer getHttpRequestsMade() {
        return httpRequestsMade;
    }

    public void setHttpRequestsMade(Integer httpRequestsMade) {
        this.httpRequestsMade = httpRequestsMade;
    }

    public Double getBytesSent() {
        return bytesSent;
    }

    public Double getBytesReceived() {
        return bytesReceived;
    }

    public Double getMillisecondsElapsed() {
        return millisecondsElapsed;
    }

    public Double getPercentageOfTimeBlocked() {
        return percentageOfTimeBlocked;
    }

    public Double getPercentageOfTimeDns() {
        return percentageOfTimeDns;
    }

    public Double getPercentageOfTimeConnecting() {
        return percentageOfTimeConnecting;
    }

    public Double getPercentageOfTimeSending() {
        return percentageOfTimeSending;
    }

    public Double getPercentageOfTimeWaiting() {
        return percentageOfTimeWaiting;
    }

    public Double getPercentageOfTimeReceiving() {
        return percentageOfTimeReceiving;
    }

    public Double getPercentageOfTimeSsl() {
        return percentageOfTimeSsl;
    }

    public Double getAverageBytesUploadedPerSecond() {
        return averageBytesUploadedPerSecond;
    }

    public Double getAverageBytesDownloadedPerSecond() {
        return averageBytesDownloadedPerSecond;
    }

    public Entry[] getSlowestRequests() {
        return slowestRequests;
    }

    public Entry[] getFastestRequests() {
        return fastestRequests;
    }

    public void setBytesSent(Double bytesSent) {
        this.bytesSent = bytesSent;
    }

    public void setBytesReceived(Double bytesReceived) {
        this.bytesReceived = bytesReceived;
    }

    public void setMillisecondsElapsed(Double millisecondsElapsed) {
        this.millisecondsElapsed = millisecondsElapsed;
    }

    public void setPercentageOfTimeBlocked(Double percentageOfTimeBlocked) {
        this.percentageOfTimeBlocked = percentageOfTimeBlocked;
    }

    public void setPercentageOfTimeDns(Double percentageOfTimeDns) {
        this.percentageOfTimeDns = percentageOfTimeDns;
    }

    public void setPercentageOfTimeConnecting(Double percentageOfTimeConnecting) {
        this.percentageOfTimeConnecting = percentageOfTimeConnecting;
    }

    public void setPercentageOfTimeSending(Double percentageOfTimeSending) {
        this.percentageOfTimeSending = percentageOfTimeSending;
    }

    public void setPercentageOfTimeWaiting(Double percentageOfTimeWaiting) {
        this.percentageOfTimeWaiting = percentageOfTimeWaiting;
    }

    public void setPercentageOfTimeReceiving(Double percentageOfTimeReceiving) {
        this.percentageOfTimeReceiving = percentageOfTimeReceiving;
    }

    public void setPercentageOfTimeSsl(Double percentageOfTimeSsl) {
        this.percentageOfTimeSsl = percentageOfTimeSsl;
    }

    public void setAverageBytesUploadedPerSecond(Double averageBytesUploadedPerSecond) {
        this.averageBytesUploadedPerSecond = averageBytesUploadedPerSecond;
    }

    public void setAverageBytesDownloadedPerSecond(Double averageBytesDownloadedPerSecond) {
        this.averageBytesDownloadedPerSecond = averageBytesDownloadedPerSecond;
    }

    public void setSlowestRequests(Entry[] slowestRequests) {
        this.slowestRequests = slowestRequests;
    }

    public void setFastestRequests(Entry[] fastestRequests) {
        this.fastestRequests = fastestRequests;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "NUM_REQUESTS_TO_SHOW=" + NUM_REQUESTS_TO_SHOW +
                ", pagesRequested=" + pagesRequested +
                ", httpRequestsMade=" + httpRequestsMade +
                ", bytesSent=" + bytesSent +
                ", bytesReceived=" + bytesReceived +
                ", millisecondsElapsed=" + millisecondsElapsed +
                ", percentageOfTimeBlocked=" + percentageOfTimeBlocked +
                ", percentageOfTimeDns=" + percentageOfTimeDns +
                ", percentageOfTimeConnecting=" + percentageOfTimeConnecting +
                ", percentageOfTimeSending=" + percentageOfTimeSending +
                ", percentageOfTimeWaiting=" + percentageOfTimeWaiting +
                ", percentageOfTimeReceiving=" + percentageOfTimeReceiving +
                ", percentageOfTimeSsl=" + percentageOfTimeSsl +
                ", averageBytesUploadedPerSecond=" + averageBytesUploadedPerSecond +
                ", averageBytesDownloadedPerSecond=" + averageBytesDownloadedPerSecond +
                ", slowestRequests=" + Arrays.toString(slowestRequests) +
                ", fastestRequests=" + Arrays.toString(fastestRequests) +
                '}';
    }
}
