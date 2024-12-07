package main;

/**
 * This class handles the sound effects
 */

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundEffect {

    Clip clip;
    // TODO: Consider making clip private and providing getter/setter methods if needed

    public void setFile(URL name){
        // TODO: Add null check for 'name' parameter
        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
            // TODO: Consider closing the AudioInputStream after opening the clip
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO: Consider more specific error handling for different exception types
            throw new RuntimeException(e);
        }
    }

    public void play(URL name){
        // TODO: Add null check for 'clip'
        // TODO: Consider removing 'name' parameter as it's not used in this method
        clip.setFramePosition(0);
        clip.start();

        // Consider adding a stop() method to stop the sound effect
        // Consider adding a method to release resources (close the clip) when it's no longer needed
        // Consider adding volume control methods
        // Consider adding a method to check if the sound effect is currently playing
        // Consider implementing a sound effect pool to manage multiple sound effects efficiently
    }
}
