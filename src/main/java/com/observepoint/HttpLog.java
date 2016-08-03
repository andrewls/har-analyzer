package com.observepoint;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by andrew on 7/24/16.
 */
public class HttpLog {
    private Page[] pages;
    private Entry[] entries;

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

    public Analysis analyze() {
        Analysis analysis = new Analysis();

        // get the simple request totals first
        analysis.setPagesRequested(pages != null ? pages.length : 0);
        analysis.setHttpRequestsMade(entries != null ? entries.length : 0);

        // add timing data and amount of data transmitted
        double sent = 0.0, received = 0.0;
        PriorityQueue<Entry> requests = new PriorityQueue<>();
        Timing timingTotals = new Timing(); // for keeping track of total times in each stage
        if (entries != null) {
            System.out.println("Found " + entries.length + " entries");
            for (Entry entry: entries) {
                timingTotals = Timing.merge(timingTotals, entry.getTimingTotals());
                sent += entry.getBytesSent();
                received += entry.getBytesReceived();
                requests.add(entry);
            }
            if (timingTotals != null) {
                System.out.println("Timing totals were non-null!\n\t" + timingTotals.toString());
                analysis.addTimingData(timingTotals);
            }
        }
        analysis.addDataTransmissionInfo(sent, received);
        analysis.addFastestAndSlowestRequests(requests);
        System.out.println("Analysis: " + analysis.toString());
        return analysis;
    }

}
