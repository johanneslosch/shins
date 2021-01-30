package me.johanneslosch.shins;

import me.johanneslosch.shins.data.files.config.ConfigReader;
import me.johanneslosch.shins.util.Setup;
import me.johanneslosch.shins.util.WSServer;

import java.net.InetSocketAddress;


public class Main {
    public static void main(String[] args) {
        Setup.setup();
        WSServer server = new WSServer(new InetSocketAddress(
                ConfigReader.read("data", "settings", "WEBSOCKET_IP"),
                Integer.parseInt(ConfigReader.read("data", "settings", "WEBSOCKET_PORT"))));
        server.run();
    }

}
