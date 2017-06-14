package kmd.model;

import java.util.Objects;

public class BidsAsks {
    protected float price;
    protected float volume;
    protected String txid;
    protected int vout;

    public BidsAsks() {
    }

    public BidsAsks(float price, float volume, String txid, int vout) {
        this.price = price;
        this.volume = volume;
        this.txid = txid;
        this.vout = vout;
    }

    public float getPrice() {
        return price;
    }

    public float getVolume() {
        return volume;
    }

    public String getTxid() {
        return txid;
    }

    public int getVout() {
        return vout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BidsAsks)) return false;

        BidsAsks bidsAsks = (BidsAsks) o;

        if (Float.compare(bidsAsks.price, price) != 0) return false;
        if (Float.compare(bidsAsks.volume, volume) != 0) return false;
        if (vout != bidsAsks.vout) return false;
        return txid != null ? txid.equals(bidsAsks.txid) : bidsAsks.txid == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, volume, txid, vout);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BidsAsks{");
        sb.append("price='").append(price).append('\'');
        sb.append(", volume='").append(volume).append('\'');
        sb.append(", txid='").append(txid).append('\'');
        sb.append(", vout='").append(vout).append('\'');
        sb.append('}');
        return sb.toString();
    }
}