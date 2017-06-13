package kmd.model;

import java.util.Objects;

public class Peer {

    private String ipaddr;
    private int port;
    private double profit;

    public Peer() {
    }

    public Peer(String ipaddr, int port) {
        this.ipaddr = ipaddr;
        this.port = port;
    }

    public Peer(String ipaddr, int port, double profit) {
        this.ipaddr = ipaddr;
        this.port = port;
        this.profit = profit;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public int getPort() {
        return port;
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peer peer = (Peer) o;

        if (port != peer.port) return false;
//        if (Double.compare(peer.profit, profit) != 0) return false;
        return ipaddr != null ? ipaddr.equals(peer.ipaddr) : peer.ipaddr == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipaddr, port, profit);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Peer{");
        sb.append("ipaddr='").append(ipaddr).append('\'');
        sb.append(", port='").append(port).append('\'');
        sb.append(", profit='").append(profit).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
