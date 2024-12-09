package event;

import javafx.scene.image.ImageView;
import main.GameManager;

/**
 * Handles scenes and actions for Event06.
 */
public class Event06 {
    GameManager gm;
    private ImageView denzel;

    /**
     * Sets up Event06 with the game manager.
     * 
     * @param gm the main game manager
     */
    public Event06(GameManager gm) {

        this.gm = gm;
    }

    /**
     * Resets Denzel's visibility.
     */
    public void reset(){
        if (denzel != null) {
            denzel.setVisible(false);
        }
    }
    
    /**
     * Shows Denzel.
     */
    public void lookDenzel(){
        gm.ui.messageText.setText("Denzel shows up");
    }

    /**
     * Talks to Denzel.
     */
    public void talkDenzel(){
        gm.ui.messageText.setText("I got worried for you so I ran after you");
    }

    /**
     * Plays Valorant music to cheer up Denzel.
     */
    public void playDenzel(){

        if(gm.player.hasAk47 == 0) {
            gm.player.hasAk47 = 1;
            gm.ui.messageText.setText("*You cheer Denzel up by playing Valorant music*\nYou realy know how to cheer me up!\n *Denzel gives you an ak47*");

            gm.player.updatePlayerStatus();
            gm.playSE(gm.reload);
        }
        else{
            gm.ui.messageText.setText("(You already have an ak47)");
            gm.playSE(gm.cannotSound);
        }

    }

    /**
     * Shows Brandon.
     */
    public void lookBrandon() {
        gm.ui.messageText.setText("This is Brandon. He seems to be doing a fit check");
    }

    /**
     * Talks to Brandon.
     */
    public void talkBrandon() {
        gm.ui.messageText.setText("Yo I wouldn't go in there if I were you! A monster is on the loose!");
    }

    /**
     * Lets the player rest and recover life with Brandon's help.
     */
    public void restBrandon() {
        if(gm.player.playerLife != gm.player.playerMaxLife) {
            gm.ui.messageText.setText("You look injured... Come here\n*Brandon gives you a warm hug*\n(You gain life)");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
            gm.playSE(gm.heal);
            gm.playSE(gm.awSound);
        }
        else {
            gm.ui.messageText.setText("(Your life is full)");
            gm.playSE(gm.cannotSound);
            if (denzel == null){
                denzel = gm.ui.createObjectAndReturn(6, 450, 110, 200, 250, "denzel.png",
                        "Look", "Talk", "Play", "lookDenzel2", "talkDenzel2", "playDenzel");
                denzel.setVisible(true);
            }
            else {
                denzel.setVisible(false);
            }


        }

    }

// TODO: Check if gm and Denzel are not null before using them.
// TODO: Create a method to play sounds instead of repeating the code.
// TODO: Make sure hasAk47 is valid before using it.
}
