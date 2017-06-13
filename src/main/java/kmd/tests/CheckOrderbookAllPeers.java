package kmd.tests;

import kmd.BaseData;
import kmd.model.Peer;

import java.io.IOException;

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

            for (int i = 0; i < peerArray.length; i++) {
                connectionAttempt = 0;
                System.out.print("Peer " + i + ". ");
            }
        }
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
