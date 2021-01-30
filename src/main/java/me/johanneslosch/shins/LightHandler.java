package me.johanneslosch.shins;

import io.github.zeroone3010.yahueapi.Color;
import io.github.zeroone3010.yahueapi.Room;
import io.github.zeroone3010.yahueapi.State;
import me.johanneslosch.shins.data.Logger;

import java.text.MessageFormat;

public class LightHandler {
    static Room getRoom(String roomName){
        if(Initialisation.getHue().getRoomByName(roomName).isPresent())
            return Initialisation.getHue().getRoomByName(roomName).get();
        return null;
    }


    public static void changeRoomColor(String roomName, java.awt.Color color, Integer brightness){
        Room room = getRoom(roomName);
        if(room != null){
            if(brightness >=1){
                room.setState(State.builder().color(Color.of(color)).on());
                room.setBrightness(brightness);
                Logger.msg(MessageFormat.format("changed lights in room {0} to color {1} and brightness {2}%", roomName, color, brightness));
            }
        }
    }
    public static void changeRoomColor(String roomName, Integer red, Integer green, Integer blue, Integer brightness){
        Room room = getRoom(roomName);
        if(room != null){
            if(brightness >=1){
                java.awt.Color color = new java.awt.Color(red, green, blue);
                room.setState(State.builder().color(Color.of(color)).on());
                room.setBrightness(brightness);
                Logger.msg(MessageFormat.format("changed lights in room {0} to color {1} and brightness {2}%", roomName, color, brightness));
            }
        }
    }
}
