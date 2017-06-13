package kmd;

import com.google.gson.Gson;
import kmd.model.Peer;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;

public class BaseData {

    public static Gson gson = new Gson();
    public static int connectionAttempt = 0;

    protected final static String START_ADDRES = "5.9.253.196:7779";
    protected final static Peer START_PEER = new Peer("5.9.253.196",7779);
    protected final static Peer RESERV_PEER = new Peer("5.9.253.197",7779);
    protected final static String GET_PEERS = "/api/stats/getpeers";
    protected final static String GET_COINS = "/api/stats/getcoins";
    protected final static String[] NAME_COIN = {"BTC", "KMD", "REVS", "JUMBLR", "LTC", "SUPERNET", "WLC",
            "PANGEA", "DEX", "BET", "CRYPTO", "HODL", "SHARK", "BOTS", "MGW", "MVP", "KV", "CEAL", "MESH"};

    /**
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver() {
        String property = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", property);
        return new ChromeDriver();
    }

    protected static Peer[] getPeersArray(Peer peer) {
        String peerJson = null;
        try {
            peerJson = IOUtils.toString(new URL("http://" + peer.getIpaddr() + ":" + peer.getPort() + GET_PEERS));
        } catch (ConnectException e) {
            connectionAttempt++;
            if (connectionAttempt <= 3) {
                System.out.println("Can`t connect to " + peer + ". Try to connect to peer " + connectionAttempt + " attempt");
                getPeersArray(peer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(peerJson, Peer[].class);
    }
}
