package kmd.tests;

import com.google.gson.Gson;
import kmd.BaseWebDriver;
import kmd.model.CoinModel;
import kmd.model.PeerModel;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URL;

public class Check extends BaseWebDriver {

    public static void main(String[] args) throws IOException {

//        checkAllPeers();
        getAllCoin();

    }


    public static void getAllCoin() throws IOException {


        Gson gson = new Gson();
        String peerJson = IOUtils.toString(new URL(START_URL + GET_PEERS));
        PeerModel[] peerArray = gson.fromJson(peerJson, PeerModel[].class);

        for (int i = 0; i < peerArray.length; i++) {
            System.out.println(i + ": " + peerArray[i]);

            peerJson = IOUtils.toString(new URL("http://" + peerArray[i].getIpaddr() + ":" + peerArray[i].getPort() + GET_COINS));
            CoinModel[] coinArray = gson.fromJson(peerJson, CoinModel[].class);
            for (int j = 0; j < coinArray.length; j++) {
                System.out.println(j + " " + coinArray[j]);
            }
        }
    }

    public static void checkAllPeers() throws IOException {
        PeerModel[] tempPeerArray;
        int counter = 0;

        String peerJson = IOUtils.toString(new URL(START_URL + GET_PEERS));
        Gson gson = new Gson();
        PeerModel[] peerArray = gson.fromJson(peerJson, PeerModel[].class);

        for (int i = 0; i < peerArray.length; i++) {
            System.out.println(i + ": " + peerArray[i]);
        }

        for (int i = 0; i < peerArray.length; i++) {
            System.out.print("Peer " + i + ". ");
            peerJson = IOUtils.toString(new URL("http://" + peerArray[i].getIpaddr() + ":" + peerArray[i].getPort() + GET_PEERS));
            tempPeerArray = gson.fromJson(peerJson, PeerModel[].class);

            for (int j = 0; j < tempPeerArray.length; j++) {
                if ((tempPeerArray[j].getIpaddr() + tempPeerArray[j].getPort()).equals
                        (peerArray[i].getIpaddr() + peerArray[i].getPort())) {
                    System.out.println("isEquals = " + tempPeerArray[j].equals(peerArray[i]) + " tempPeerArray[j] = " + tempPeerArray[j] + ", peerArray[i] = " + peerArray[i]);
                    counter++;
                }
            }
        }
        if (counter == 10) {
            System.out.println("All " + peerArray.length + "th peers is work and have each other in list getpeers");
        }
    }

}
