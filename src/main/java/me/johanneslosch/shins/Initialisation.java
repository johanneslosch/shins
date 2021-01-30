package me.johanneslosch.shins;

import io.github.zeroone3010.yahueapi.Hue;
import io.github.zeroone3010.yahueapi.HueBridge;
import io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService;
import me.johanneslosch.shins.data.files.config.ConfigReader;
import me.johanneslosch.shins.data.files.config.ConfigWriter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Initialisation {
    public static void getHubIP(){
        Future<List<HueBridge>> bridgesFuture = new HueBridgeDiscoveryService()
                .discoverBridges(bridge -> System.out.println("Bridge found: " + bridge));
        final List<HueBridge> bridges;
        try {
            bridges = bridgesFuture.get();
            if( !bridges.isEmpty() ) {
                final String bridgeIp = bridges.get(0).getIp();
                System.out.println("Bridge found at " + bridgeIp);
                ConfigWriter.writePropertiesFile("data", "credentials", "BRIDGE_URL", bridges.get(0).getIp());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static void getBridgeToken() throws ExecutionException, InterruptedException {
        final String bridgeIp = ConfigReader.read("data", "credentials", "BRIDGE_URL"); // Fill in the IP address of your Bridge
        final String appName = "shins"; // Fill in the name of your application
        final CompletableFuture<String> apiKey = Hue.hueBridgeConnectionBuilder(bridgeIp).initializeApiConnection(appName);
        final String key = apiKey.get();
        final Hue hue = new Hue(bridgeIp, key);
        ConfigWriter.writePropertiesFile("data", "credentials", "BRIDGE_TOKEN", key);
    }
    public static Hue getHue(){

        return new Hue(ConfigReader.read("data", "credentials", "BRIDGE_URL"),
                ConfigReader.read("data", "credentials", "BRIDGE_TOKEN"));
    }
}
