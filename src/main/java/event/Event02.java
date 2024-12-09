package event;

import main.GameManager;

/**
* This class manages the scenes and actions for Event02
*/

public class Event02 {

    GameManager gm;

    /**
    * Sets up Event02 with the game manager.
    *
    * @param gm the main game manager
    */
    public Event02(GameManager gm) {

        this.gm = gm;
    }

    /**
     * Checks the first spot on the Honda.
     */
    public void search1Honda() {
        gm.ui.messageText.setText("Nothing sus here");
    }
    
    /**
     * Checks the second spot on the Honda.
     */
    public void search2Honda() {
        gm.ui.messageText.setText("OH MY GYAT MY ENGINE IS MISSING");
    }

    /**
     * Lets the player rest on the Honda and heal life.
     */
    public void restHonda() {
        if(gm.player.playerLife != gm.player.playerMaxLife) {
            gm.ui.messageText.setText("*You rest on the hood of your car*\n(Your life has been recovered)");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
            gm.playSE(gm.heal);
        }
        else{
            gm.ui.messageText.setText("(Your life is full)");
            gm.playSE(gm.cannotSound);

        }
    }
    // TODO: Make sure the game manager (gm) is not null in the constructor.
    // TODO: Combine repeated actions like updating player status into a helper method.
    // TODO: Check that player life values are not negative to avoid errors.
}
