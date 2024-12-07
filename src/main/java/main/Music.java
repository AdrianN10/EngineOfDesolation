package main;
/**
 * this class handles music
 */

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Music {


    Clip clip;

    // TODO: Consider making clip private and providing getter/setter methods if needed

    public void setFile(URL name){
        // TODO: Add null check for 'name' parameter

        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
            // TODO: Add null check for 'name' parameter
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            // TODO: Consider more specific error handling for different exception types
            throw new RuntimeException(e);
        }
    }

    public void play(URL name){
        // TODO: Add null check for 'clip'
        // TODO: Consider removing 'name' parameter as it's not used in this method
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop(URL name){
        // TODO: Add null check for 'clip'
        // TODO: Consider removing 'name' parameter as it's not used in this method
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(URL name) {
        // TODO: Add null check for 'clip'
        // TODO: Consider removing 'name' parameter as it's not used in this method
        clip.stop();
    }
    // TODO: Consider adding a method to release resources (close the clip) when it's no longer needed
    // TODO: Consider adding volume control methods
    // TODO: Consider adding a method to check if the clip is currently playing
}
