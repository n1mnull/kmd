package kmd.model;


import java.sql.Time;
import java.util.Objects;

public class Orderbook {

    private BidsAsks[] bids;
    private int numbids;
    private BidsAsks[] asks;
    private int numasks;
    private String base;
    private String rel;
    private long timestamp;

    public Orderbook() {
    }

    public Orderbook(BidsAsks[] bids, int numbids, BidsAsks[] asks, int numasks, String base, String rel, long timestamp) {
        this.bids = bids;
        this.numbids = numbids;
        this.asks = asks;
        this.numasks = numasks;
        this.base = base;
        this.rel = rel;
        this.timestamp = timestamp;
    }

    public BidsAsks[] getBids() {
        return bids;
    }

    public int getNumbids() {
        return numbids;
    }

    public BidsAsks[] getAsks() {
        return asks;
    }

    public int getNumasks() {
        return numasks;
    }

    public String getBase() {
        return base;
    }

    public String getRel() {
        return rel;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orderbook)) return false;

        Orderbook orderbook = (Orderbook) o;

        if (numasks != orderbook.numasks) return false;
        if (timestamp != orderbook.timestamp) return false;
        if (bids != null ? !bids.equals(orderbook.bids) : orderbook.bids != null) return false;
        if (numbids != orderbook.numbids) return false;
        if (asks != null ? !asks.equals(orderbook.asks) : orderbook.asks != null) return false;
        if (base != null ? !base.equals(orderbook.base) : orderbook.base != null) return false;
        return rel != null ? rel.equals(orderbook.rel) : orderbook.rel == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bids, numbids, asks, numasks, base, rel, timestamp);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Orderbook{");
        sb.append("bids='").append(bids).append('\'');
        sb.append(", numbids='").append(numbids).append('\'');
        sb.append(", asks='").append(asks).append('\'');
        sb.append(", numasks='").append(numasks).append('\'');
        sb.append(", base='").append(base).append('\'');
        sb.append(", rel='").append(rel).append('\'');
        sb.append(", timestamp='").append(new Time(timestamp)).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
