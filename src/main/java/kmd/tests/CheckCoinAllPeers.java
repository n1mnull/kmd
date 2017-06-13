package kmd.tests;

import kmd.BaseData;
import kmd.model.Coin;
import kmd.model.Peer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;

public class CheckCoinAllPeers extends BaseData {

    public static void main(String[] args) throws IOException {
        System.out.println("Connect to " + START_PEER);
        getAllCoin(START_PEER);
    }

    private static void getAllCoin(Peer peer) {
        Peer[] peerArray = getPeersArray(peer);
        if (peerArray != null) {
            for (int i = 0; i < peerArray.length; i++) {
                connectionAttempt = 0;
                System.out.println(i + ": " + peerArray[i]);
                Coin[] coinArray = getCoinsArrayFromPeer(peerArray[i]);
                if (coinArray != null) {
                    for (int j = 0; j < coinArray.length; j++)
                        System.out.println(j + " " + coinArray[j]);
                }
            }
        }
    }

    private static Coin[] getCoinsArrayFromPeer(Peer peer) {
        String peerJson = null;
        try {
            peerJson = IOUtils.toString(new URL("http://" + peer.getIpaddr() + ":" + peer.getPort() + GET_COINS));
        } catch (ConnectException e) {
            connectionAttempt++;
            if (connectionAttempt <= 3) {
                System.out.println("Can`t connect to " + peer + ". Try to connect to peer " + connectionAttempt + " attempt");
                getCoinsArrayFromPeer(peer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(peerJson, Coin[].class);
    }
}
