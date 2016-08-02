package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class HttpArchive {
    private HttpLog log;

    public HttpLog getLog() {
        return log;
    }

    public void setLog(HttpLog log) {
        this.log = log;
    }

    public Analysis analyze() {
        return log.analyze();
    }
}
