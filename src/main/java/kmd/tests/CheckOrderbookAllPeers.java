package kmd.tests;

import com.google.gson.JsonSyntaxException;
import kmd.BaseData;
import kmd.model.Coin;
import kmd.model.Error;
import kmd.model.Orderbook;
import kmd.model.Peer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;

public class CheckOrderbookAllPeers extends BaseData {

    public static void main(String[] args) throws IOException {
        System.out.println("Connect to " + START_PEER);
        checkOrderbookAllPeers(START_PEER);
    }

    private static void checkOrderbookAllPeers(Peer peer) throws IOException {
        Peer[] peerArray = getPeersArray(peer);
        if (peerArray != null) {
            for (int i = 0; i < peerArray.length; i++)
                System.out.println(i + ": " + peerArray[i]);


            for (int k = 0; k < peerArray.length; k++) {
                System.out.println("Connect to " + peerArray[k]);
                for (int i = 0; i < NAME_COIN.length; i++) {
                    for (int j = 0; j < NAME_COIN.length; j++) {
                        connectionAttempt = 0;
                        Orderbook orderbook = null;
                        try {
                            orderbook = getOrderbookBaseToRel(peerArray[k], NAME_COIN[i], NAME_COIN[j]);
                        } catch (JsonSyntaxException e) {
                            Error error = getError(peerArray[k], NAME_COIN[i], NAME_COIN[j]);
                            System.out.println(k + "." + i + "." + j + " : from " + NAME_COIN[i] + " ->" + NAME_COIN[j] + ", Error found! Server respond information: " + error.getErrorMsg());
                        }
                        if (orderbook != null) {
                            if (orderbook.getTimestamp() != 0)
                                System.out.println(k + "." + i + "." + j + " : from " + NAME_COIN[i] + " ->" + NAME_COIN[j] + ", " + orderbook);

                            if (orderbook.getNumasks() != 0 || orderbook.getNumbids() != 0)
                                System.out.println("!_!_!_!_!_!_!_!" + k + "." + i + "." + j + " : from " + NAME_COIN[i] + " ->" + NAME_COIN[j] + ", " + orderbook);
                        }
                    }
                }
            }
        }
    }

    protected static Error getError(Peer peer, String base, String rel) {
        String peerJson = null;
        try {
            peerJson = IOUtils.toString(new URL("http://" + peer.getIpaddr() + ":" + peer.getPort() +
                    GET_ORDERBOOK + "?base=" + base + "&rel=" + rel));
        } catch (ConnectException e) {
            connectionAttempt++;
            if (connectionAttempt <= 3) {
                System.out.println("Can`t connect to " + peer + ". Try to connect to peer " + connectionAttempt + " attempt");
                getError(peer, base, rel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(peerJson, Error.class);
    }

    private static Orderbook getOrderbookBaseToRel(Peer peer, String base, String rel) {
        String peerJson = null;
        try {
            peerJson = IOUtils.toString(new URL("http://" + peer.getIpaddr() + ":" + peer.getPort() +
                    GET_ORDERBOOK + "?base=" + base + "&rel=" + rel));
        } catch (ConnectException e) {
            connectionAttempt++;
            if (connectionAttempt <= 3) {
                System.out.println("Can`t connect to " + peer + ". Try to connect to peer " + connectionAttempt + " attempt");
                getOrderbookBaseToRel(peer, base, rel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(peerJson, Orderbook.class);
    }

    private static boolean isEqualsPeerArray(Peer[] peer1, Peer[] peer2) {
        if (peer1 == peer2) return true;
        if (peer1.length != peer2.length) return false;

        int count = 0;
        for (int i = 0; i < peer1.length; i++) {
            for (int j = 0; j < peer2.length; j++) {
                if (peer1[i].equals(peer2[j]))
                    count++;
            }
        }
        return count == 10;
    }

}
