package com.observepoint;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by andrew on 7/24/16.
 */
public class HttpLog {
    private String version;
    private HttpLogCreator creator;
    private Browser browser;
    private Page[] pages;
    private Entry[] entries;
    private String[] comments;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public HttpLogCreator getCreator() {
        return creator;
    }

    public void setCreator(HttpLogCreator creator) {
        this.creator = creator;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public Page[] getPages() {
        return pages;
    }

    public void setPages(Page[] pages) {
        this.pages = pages;
    }

    public Entry[] getEntries() {
        return entries;
    }

    public void setEntries(Entry[] entries) {
        this.entries = entries;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public Analysis analyze() {
        Analysis analysis = new Analysis();

        // get the simple request totals first
//        analysis.setPagesRequested(pages != null ? pages.length : 0);
//        analysis.setHttpRequestsMade(entries != null ? entries.length : 0);
//
//        // add timing data and amount of data transmitted
//        double sent = 0.0, received = 0.0;
//        PriorityQueue<Entry> requests = new PriorityQueue<>();
//        Timing timingTotals = new Timing(); // for keeping track of total times in each stage
//        if (entries != null) {
//            for (Entry entry: entries) {
//                timingTotals = Timing.merge(timingTotals, entry.getTimingTotals());
//                sent += entry.getBytesSent();
//                received += entry.getBytesReceived();
//                requests.add(entry);
//            }
//            if (timingTotals != null) {
//                analysis.addTimingData(timingTotals);
//            }
//        }
//        analysis.addDataTransmissionInfo(sent, received);
//        analysis.addFastestAndSlowestRequests(requests);
        return analysis;
    }

}
