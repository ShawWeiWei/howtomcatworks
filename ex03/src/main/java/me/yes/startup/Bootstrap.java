package me.yes.startup;

/**
 * Created by yes on 31/12/15.
 */
public class Bootstrap {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
