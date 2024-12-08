package event;

import javafx.scene.image.ImageView;
import main.GameManager;

public class Event06 {
    GameManager gm;
    private ImageView denzel;

    public Event06(GameManager gm) {
        this.gm = gm;
    }

    // TODO: Hey, this is where we're gonna set up our message and play a sound. It's like a smooth move!
    private void setMessageAndPlaySound(String message, String sound) {
        gm.ui.messageText.setText(message); // TODO: Set the message text like a smooth thriller move.
        gm.playSE(sound); // TODO: Play the sound! Make it beat like Billie Jean.
    }

    // TODO: We need to control if denzel is visible or not. It's just a little magic.
    private void manageDenzelVisibility(boolean isVisible) {
        // TODO: If denzel is not here, let's create him.
        if (denzel == null) {
            denzel = gm.ui.createObjectAndReturn(6, 450, 110, 200, 250, "denzel.png",
                    "Look", "Talk", "Play", "lookDenzel2", "talkDenzel2", "playDenzel");
        }
        // TODO: Set his visibility. Make him show up or hide like he's doing the moonwalk!
        denzel.setVisible(isVisible);
    }

    public void reset() {
        // TODO: If denzel exists, hide him. Let's reset like a smooth criminal.
        if (denzel != null) {
            denzel.setVisible(false);
        }
    }

    public void lookDenzel() {
        // TODO: Denzel is in the place! Let's give the message and make the sound play.
        setMessageAndPlaySound("Denzel shows up", null); // No sound needed here, just message.
    }

    public void talkDenzel() {
        // TODO: Denzel talks to you. Gotta set the message right, and no sound needed this time.
        setMessageAndPlaySound("I got worried for you so I ran after you", null); // Simple talk, no sound.
    }

    public void playDenzel() {
        // TODO: Check if you got the AK-47. If not, you're about to get it, yeah!
        if (gm.player.hasAk47 == 0) {
            gm.player.hasAk47 = 1; // Give the player the AK-47!
            // TODO: Set the message, tell them how they got the AK-47, and play the reload sound!
            setMessageAndPlaySound(
                "*You cheer Denzel up by playing Valorant music*\nYou really know how to cheer me up!\n *Denzel gives you an ak47*",
                gm.reload
            );
            gm.player.updatePlayerStatus(); // Update the player's status after getting the AK-47.
        } else {
            // TODO: They already have the AK-47. Tell them they're good, no need for more!
            setMessageAndPlaySound("(You already have an ak47)", gm.cannotSound);
        }
    }

    public void lookBrandon() {
        // TODO: Now we look at Brandon. Set the message for the fit check.
        setMessageAndPlaySound("This is Brandon. He seems to be doing a fit check", null);
    }

    public void talkBrandon() {
        // TODO: Brandon warns you about the monster. Let’s set that message.
        setMessageAndPlaySound("Yo I wouldn't go in there if I were you! A monster is on the loose!", null);
    }

    public void restBrandon() {
        // TODO: If you’re hurt, Brandon's got your back! Let's heal you up.
        if (gm.player.playerLife != gm.player.playerMaxLife) {
            setMessageAndPlaySound(
                "You look injured... Come here\n*Brandon gives you a warm hug*\n(You gain life)",
                gm.heal
            );
            gm.player.playerLife++; // Increase player’s life.
            gm.player.updatePlayerStatus(); // Update player status after healing.
            gm.playSE(gm.awSound); // Play the sound for healing.
        } else {
            // TODO: If you're not hurt, we gotta tell you your life is full.
            setMessageAndPlaySound("(Your life is full)", gm.cannotSound);
            // TODO: If Denzel is not visible, show him! If he's already visible, hide him. Simple as that.
            manageDenzelVisibility(denzel == null); // Show or hide Denzel based on current state.
        }
    }
}
