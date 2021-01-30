package me.johanneslosch.shins;

import me.johanneslosch.shins.util.Setup;

import java.awt.*;


public class Main {
    public static void main(String[] args) {
        Setup.setup();
        LightHandler.changeRoomColor("Wohnzimmer", Color.WHITE, 100);
    }

}
