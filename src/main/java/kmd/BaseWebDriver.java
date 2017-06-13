package kmd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseWebDriver {

    protected final static String START_URL = "http://5.9.253.196:7779";
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
}
