package kmd.model;

import java.util.Objects;

public class PeerModel {

    private String ipaddr;
    private int port;
    private double profit;

    public PeerModel() {
    }

    public PeerModel(String ipaddr, int port, double profit) {
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

        PeerModel peerModel = (PeerModel) o;

        if (port != peerModel.port) return false;
        if (Double.compare(peerModel.profit, profit) != 0) return false;
        return ipaddr != null ? ipaddr.equals(peerModel.ipaddr) : peerModel.ipaddr == null;
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

//    @Override
//    public String toString() {
//        return "PeerModel{" +
//                "ipaddr='" + ipaddr + '\'' +
//                ", port=" + port +
//                ", profit=" + profit +
//                '}';
//    }
}
