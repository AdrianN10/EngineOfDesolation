package event;

import main.GameManager;

/**
 * Manages scenes and actions for Event04.
 */
public class Event04 {

    GameManager gm;

    /**
     * Sets up Event04 with the game manager.
     * 
     * @param gm the main game manager
     */
    public Event04(GameManager gm) {

        this.gm = gm;
    }

    /**
     * Shows the description of Denzel.
     */
    public void lookDenzel() {
        gm.ui.messageText.setText("This is Denzel. (He listens to Valorant music)");
    }

     /**
     * Lets Denzel give the player a pistol if they don't already have one.
     */
    public void talkDenzel() {
        if(gm.player.hasPistol == 0) {
            gm.player.hasPistol = 1;
            gm.ui.messageText.setText("My oh my I've been waiting for you heh. Here's a glock.\nI saw a monster running with an engine towards the casino!");

            gm.player.updatePlayerStatus();
            gm.playSE(gm.reload);
        }
        else{
            gm.ui.messageText.setText("(You already have a glock)");
            gm.playSE(gm.cannotSound);
        }
    }

     /**
     * Lets the player recover life with Denzel's help.
     */
    public void restDenzel() {
        if(gm.player.playerLife != gm.player.playerMaxLife) {
            gm.ui.messageText.setText("(Denzel has been lonely without his girlfriend)\n*Denzel runs up to you unexpectedly and gives you a hug*\n(Your life has been recovered)");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
            gm.playSE(gm.heal);
            gm.playSE(gm.awSound);
        }
        else {
            gm.ui.messageText.setText("(Your life is full)");
            gm.playSE(gm.cannotSound);
        }
    }

    // TODO: Check that the game manager (gm) is not null when the class is created.
    // TODO: Create a helper method for repeated life recovery code.
    // TODO: Make sure the pistol value (hasPistol) is either 0 or 1 only.
}
