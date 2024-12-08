package event;

import main.GameManager;

public class Event02 {

    private final GameManager gm;

    // TODO: Hee-hee! The constructor is setting up the game manager. All good here.
    public Event02(GameManager gm) {
        this.gm = gm;
    }

    // TODO: Shamone! A helper method to set the message text. Makes it easier later, so we don't repeat ourselves.
    private void setMessage(String message) {
        gm.ui.messageText.setText(message);
    }

    // TODO: Hee-hee! This is where we search Honda 1. Let the player know that nothing sus is going on.
    public void search1Honda() {
        setMessage("Nothing sus here");
    }

    // TODO: Shamone! This is Honda search 2. OH MY GYAT the engine is missing. The player should be shocked.
    public void search2Honda() {
        setMessage("OH MY GYAT MY ENGINE IS MISSING");
    }

    // TODO: Hoo! Time to rest on the car's hood. If the player’s life isn’t full, they should heal up.
    public void restHonda() {
        // TODO: Hee-hee! Check if the player’s life is less than the max. If so, let them rest and recover.
        if (gm.player.playerLife < gm.player.playerMaxLife) {
            setMessage("*You rest on the hood of your car*\n(Your life has been recovered)");
            gm.player.playerLife++; // Hoo! Increase the player’s life by one.
            gm.player.updatePlayerStatus(); // Hoo! Update the player’s stats after the rest.
            gm.playSE(gm.heal); // Shamone! Play a sound effect for healing.
        } else {
            // TODO: Hee-hee! If the player’s life is already full, just let them know.
            setMessage("(Your life is full)");
            gm.playSE(gm.cannotSound); // Hoo! Play a sound effect when the player can't heal.
        }
    }
}
