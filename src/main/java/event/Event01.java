package event;

import main.GameManager;

/**
 * This class handles events related to specific scenes and buttons.
 */
public class Event01 {

    private GameManager gm;

    public Event01(GameManager gm) {
        this.gm = gm;
    }

    // TODO: "Hee-hee! Let's make a helper method for setting message and playing sound."
    // This helps to avoid repeating the same code in different parts. Don't stop 'til you get enough!
    private void setMessageAndPlaySE(String message, String soundEffect) {
        gm.ui.messageText.setText(message); // Set the message text
        if (soundEffect != null) {
            gm.playSE(soundEffect); // Play the sound effect if there is one
        }
    }

    // TODO: "Shamon! You look at Jeramiah, baby!"
    // Here we update the message when you look at Jeramiah.
    public void lookJeramiah() {
        setMessageAndPlaySE("This is your tall handsome roommate Jeramiah. (He works on cars. Specifically Hondas)", null);
    }

    // TODO: "Hee-hee! Jeramiah talks and makes a sound."
    // Talking to Jeramiah and playing a sound.
    public void talkJeramiah() {
        setMessageAndPlaySE("Did you hear that noise outside son?", gm.engineNoise);
    }

    // TODO: "Hee-hee! Rest with Jeramiah, baby!"
    // Checking if player needs healing and rest with Jeramiah.
    public void restJeramiah() {
        if (gm.player.playerLife == gm.player.playerMaxLife) {
            // TODO: "You got full life, baby! No need to rest."
            setMessageAndPlaySE("(Your life is full)", gm.cannotSound);
            return; // Early exit since life is full, no need to continue.
        }

        // TODO: "Get healed up, baby! Jeramiah's got you!"
        gm.player.playerLife++; // Heal the player by 1 point
        gm.player.updatePlayerStatus(); // Update player status
        setMessageAndPlaySE("Come here my baka! \n*You lay in Jeramiah's strong arms*\n(Your life has been recovered)", gm.heal);
        gm.playSE(gm.awSound); // Play a sound when healing happens
    }

    // TODO: "You look at the flashlight, baby!"
    // Look at the flashlight. Simple message.
    public void lookFlashlight() {
        setMessageAndPlaySE("This is a flashlight", null);
    }

    // TODO: "Shamon! Grab that flashlight, baby!"
    // Grab the flashlight, but only if you don't already have one.
    public void grabFlashlight() {
        if (gm.player.hasFlashlight == 1) {
            // TODO: "You already got the flashlight, don't need to grab it again!"
            setMessageAndPlaySE("(You already have a flashlight)", gm.cannotSound);
            return; // Early exit because the player already has the flashlight.
        }

        // TODO: "You got the flashlight, baby! Time to shine!"
        gm.player.hasFlashlight = 1; // Mark that the player has the flashlight
        gm.player.updatePlayerStatus(); // Update player status
        setMessageAndPlaySE("(You obtained a flashlight)", gm.flashlightSwitch); // Play sound when obtaining
    }

    // TODO: "Rest the flashlight, baby. It's time to put it down."
    // Resting the flashlight. You put it back on the bed.
    public void restFlashlight() {
        if (gm.player.hasFlashlight == 0) {
            // TODO: "You don't have the flashlight, baby. Can't rest it!"
            setMessageAndPlaySE("(You don't have a flashlight)", gm.cannotSound);
            return; // Early exit because the player doesn't have the flashlight
        }

        // TODO: "Put the flashlight back on the bed, baby."
        gm.player.hasFlashlight = 0; // Mark that the player no longer has the flashlight
        gm.player.updatePlayerStatus(); // Update player status
        setMessageAndPlaySE("*You rest the flashlight back on the bed*", null); // No sound, just message
    }
}
