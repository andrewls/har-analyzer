package com.observepoint;

/**
 * Created by andrew on 7/24/16.
 */
public class Timing {
    private Double blocked;
    private Double dns;
    private Double connect;
    private Double send;
    private Double wait;
    private Double receive;
    private Double ssl;
    private String comment;
    private Double total;

    public Timing() {
        blocked = 0.0;
        dns = 0.0;
        connect = 0.0;
        send = 0.0;
        wait = 0.0;
        receive = 0.0;
        ssl = 0.0;
        total = 0.0;
    }
    public static Timing merge(Timing... timings) {
        if (timings == null) return null;
        Timing toReturn = new Timing();
        for (Timing timing: timings) {
            toReturn.blocked += timing.blocked;
            toReturn.dns += timing.dns;
            toReturn.connect += timing.connect;
            toReturn.send += timing.send;
            toReturn.wait += timing.wait;
            toReturn.receive += timing.receive;
            toReturn.ssl += timing.ssl;
        }
        toReturn.getTotal(); // update the total time once at the end instead of at each iteration
        return toReturn;
    }

    public Double getPercentageBlocked() {
        return blocked == -1 ? null : blocked / getTotal();
    }

    public Double getPercentageDns() {
        return dns == -1 ? null :  dns / getTotal();
    }

    public Double getPercentageConnect() {
        return connect == -1 ? null : connect / getTotal();
    }

    public Double getPercentageSend() {
        return send == -1 ? null : send / getTotal();
    }

    public Double getPercentageWait() {
        return wait == -1 ? null : wait / getTotal();
    }

    public Double getPercentageReceive() {
        return receive == -1 ? null : receive / getTotal();
    }

    public Double getPercentageSsl() {
        return ssl == -1 ? null : ssl / getTotal();
    }

    public Double getTotal() {
        if (total == null) {
            total = 0.0;
            if (blocked >= 0) total += blocked;
            if (dns >= 0) total += dns;
            if (connect >= 0) total += connect;
            if (send >= 0) total += send;
            if (wait >= 0) total += wait;
            if (receive >= 0) total += receive;
            if (ssl >= 0) total += ssl;
        }
        return total;
    }

    public Double getBlocked() {
        return blocked;
    }

    public void setBlocked(Double blocked) {
        this.blocked = blocked;
    }

    public Double getDns() {
        return dns;
    }

    public void setDns(Double dns) {
        this.dns = dns;
    }

    public Double getConnect() {
        return connect;
    }

    public void setConnect(Double connect) {
        this.connect = connect;
    }

    public Double getSend() {
        return send;
    }

    public void setSend(Double send) {
        this.send = send;
    }

    public Double getWait() {
        return wait;
    }

    public void setWait(Double wait) {
        this.wait = wait;
    }

    public Double getReceive() {
        return receive;
    }

    public void setReceive(Double receive) {
        this.receive = receive;
    }

    public Double getSsl() {
        return ssl;
    }

    public void setSsl(Double ssl) {
        this.ssl = ssl;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
