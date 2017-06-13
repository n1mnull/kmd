package kmd.model;

import java.util.Objects;

public class CoinModel {

    private String coin;
    private String status;
    private String smartaddress;
    private String rpc;
    private int pubtype;
    private int p2shtype;
    private int wiftype;
    private int estimatedrate;
    private int txfee;

    public CoinModel() {
    }

    public CoinModel(String coin, String status, String smartaddress, String rpc,
                     int pubtype, int p2shtype, int wiftype, int estimatedrate, int txfee) {
        this.coin = coin;
        this.status = status;
        this.smartaddress = smartaddress;
        this.rpc = rpc;
        this.pubtype = pubtype;
        this.p2shtype = p2shtype;
        this.wiftype = wiftype;
        this.estimatedrate = estimatedrate;
        this.txfee = txfee;
    }

    public String getCoin() {
        return coin;
    }

    public String getStatus() {
        return status;
    }

    public String getSmartaddress() {
        return smartaddress;
    }

    public String getRpc() {
        return rpc;
    }

    public int getPubtype() {
        return pubtype;
    }

    public int getP2shtype() {
        return p2shtype;
    }

    public int getWiftype() {
        return wiftype;
    }

    public int getEstimatedrate() {
        return estimatedrate;
    }

    public int getTxfee() {
        return txfee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoinModel)) return false;

        CoinModel coinModel = (CoinModel) o;

        if (pubtype != coinModel.pubtype) return false;
        if (p2shtype != coinModel.p2shtype) return false;
        if (wiftype != coinModel.wiftype) return false;
        if (estimatedrate != coinModel.estimatedrate) return false;
        if (txfee != coinModel.txfee) return false;
        if (coin != null ? !coin.equals(coinModel.coin) : coinModel.coin != null) return false;
        if (status != null ? !status.equals(coinModel.status) : coinModel.status != null) return false;
        if (smartaddress != null ? !smartaddress.equals(coinModel.smartaddress) : coinModel.smartaddress != null)
            return false;
        return rpc != null ? rpc.equals(coinModel.rpc) : coinModel.rpc == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coin, status, smartaddress, rpc,
                pubtype, p2shtype, wiftype, estimatedrate, txfee);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coin{");
        sb.append("coin='").append(coin).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", smartaddress='").append(smartaddress).append('\'');
        sb.append(", rpc='").append(rpc).append('\'');
        sb.append(", pubtype='").append(pubtype).append('\'');
        sb.append(", p2shtype='").append(p2shtype).append('\'');
        sb.append(", wiftype='").append(wiftype).append('\'');
        sb.append(", estimatedrate='").append(estimatedrate).append('\'');
        sb.append(", txfee='").append(txfee).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
