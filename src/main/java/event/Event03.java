package event;

import main.GameManager;

/**
 * Handles scenes and actions for Event03.
 */
public class Event03 {

    GameManager gm;

    /**
     * Sets up Event03 with the game manager.
     * 
     * @param gm the main game manager
     */
    public Event03(GameManager gm) {

        this.gm = gm;
    }

    /**
     * Shows the description of the Hondaur.
     */
    public void lookHondaur() {
        gm.ui.messageText.setText("Its a Hondaur");
    }

    /**
     * Describes the interaction with the Hondaur.
     */
    public void talkHondaur() {
        gm.ui.messageText.setText("The Hondaur growls at you and revs his engine ");
    }

     /**
     * Explains the player's attack on the Hondaur.
     */
    public void attackHondaur() {
        gm.ui.messageText.setText("*You start beating the shit out of the poor Hondaur*");

    }

     // TODO: Check that the game manager (gm) is not null when this class is created.
    // TODO: Add error handling for sounds in case they are missing or invalid.
}
