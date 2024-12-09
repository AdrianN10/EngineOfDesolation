package main;
/**
 * this class handles music
 */

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Music {


    Clip clip;

    public void setFile(URL name){

        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //TODO: Log the error or notify the user via the UI
            throw new RuntimeException(e); // TODO: Replace with more user-friendly error handling
        }
    }

    public void play(URL name){
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop(URL name){

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(URL name){
        clip.stop();
    }
}
