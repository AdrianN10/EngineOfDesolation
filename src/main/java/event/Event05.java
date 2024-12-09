package event;

import main.GameManager;

/**
 * Manages scenes and actions for Event05.
 */
public class Event05 {

    GameManager gm;

    /**
     * Sets up Event05 with the game manager.
     * 
     * @param gm the main game manager
     */
    public Event05(GameManager gm) {

        this.gm = gm;
    }

    /**
     * Shows that Brian is in the Honda trunk.
     */
    public void lookHondaTrunk() {
        if(gm.player.hasPistol == 1){
            gm.ui.messageText.setText("IS THAT BRIAN FROM MARAUDER CODED!");
        }
        else{
            gm.ui.messageText.setText("(You see Brian's dead body)");
        }
    }

    /**
     * Talks to the Honda trunk.
     */
    public void talkHondaTrunk() {
        if(gm.theodoor.currentLife==0 && gm.wheeler.currentLife==0) {
            if(gm.player.hasPistol == 1){
                gm.ui.messageText.setText("Eughh Please... save... Julien and please end my misery");
            }
            else{
                gm.ui.messageText.setText("(Brian is already dead!)");
            }
        }
        else{
            gm.ui.messageText.setText("You must defeat the monsters first!");
            gm.playSE(gm.cannotSound);
        }
    }

    /**
     * Ends Brian's misery in the Honda trunk.
     */
    public void killHondaTrunk() {

        if(gm.theodoor.currentLife == 0 && gm.wheeler.currentLife == 0) {
            if(gm.player.hasPistol == 1){
                gm.playSE(gm.pistolShot);
                gm.ui.messageText.setText("(You ended Brian's misery)");
            }
            else{
                gm.ui.messageText.setText("(You already ended his misery!)");
            }
            gm.player.hasPistol = 0;
            gm.player.updatePlayerStatus();
        }
        else{
            gm.ui.messageText.setText("You must defeat the monsters first!");
            gm.playSE(gm.cannotSound);
        }

    }

     // TODO: Add checks to ensure game objects like gm and player are valid.
    // TODO: Restructure repeated conditions like checking currentLife into a helper method to make sure there's no code duplication and so readbility could be better since it makes sure the purpose of the condition is clear.
    // TODO: Add a log to track when the pistol state (hasPistol) changes
}
