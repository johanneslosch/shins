package me.johanneslosch.shins;

import io.github.zeroone3010.yahueapi.State;
import me.johanneslosch.shins.util.Setup;

import java.awt.*;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        Setup.setup();
        //[Light{id='9', name='Wohnzimmer 2', type=EXTENDED_COLOR}
        // Light{id='8', name='Wohnzimmer 1', type=EXTENDED_COLOR}]
        if(Initialisation.getHue().getRoomByName("Wohnzimmer").isPresent()) {
            Initialisation.getHue().getRoomByName("Wohnzimmer").get().setBrightness(100);
            Initialisation.getHue().getRoomByName("Wohnzimmer").get()
                    .setState(State.builder().color(io.github.zeroone3010.yahueapi.Color.of(Color.green)).on());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Initialisation.getHue().getRoomByName("Wohnzimmer").get()
                    .setState(State.builder().color(io.github.zeroone3010.yahueapi.Color.of(Color.WHITE)).off());

        }


    }



}
