package event;

import main.GameManager;

public class Event04 {

    private final GameManager gm; // TODO: You got it! Declare gm as a final variable to prevent changes.

    // TODO: The constructor sets up the GameManager (gm). It’s like a smooth criminal, handling things!
    public Event04(GameManager gm) {
        this.gm = gm; // TODO: You rock! We're setting the gm from the outside. Let's keep it strong, no changes allowed!
    }

    // TODO: This method shows a message on screen, like a popstar showing up on stage! And it plays a sound.
    private void showMessage(String message, String sound) {
        gm.ui.messageText.setText(message); // TODO: Get the message to the player. They need to know what’s going down!
        if (sound != null) {
            gm.playSE(sound); // TODO: If there's a sound, let's play it! Don’t leave them hanging.
        }
    }

    // TODO: When you look at Denzel, you're seeing the man, the myth, the legend. Let's show it!
    public void lookDenzel() {
        showMessage("This is Denzel. (He listens to Valorant music)", null); // TODO: Just a message, no sound needed. We’re chill.
    }

    // TODO: When talking to Denzel, if you don’t have a pistol, he’s got your back like a true friend.
    public void talkDenzel() {
        if (gm.player.hasPistol == 0) { // TODO: Uh oh! You don’t have a pistol. Time to change that!
            gm.player.hasPistol = 1; // TODO: Here comes the glock! Denzel’s making sure you’re ready for the ride.
            showMessage("My oh my I've been waiting for you heh. Here's a glock.\nI saw a monster running with an engine towards the casino!", gm.reload); // TODO: Give ‘em the glock and a message with the reload sound, baby!
            gm.player.updatePlayerStatus(); // TODO: Update the player’s status like you just beat it!
        } else { // TODO: You already got a pistol, don’t need no more. 
            showMessage("(You already have a glock)", gm.cannotSound); // TODO: Play the "nope" sound. You don’t get another one, buddy.
        }
    }

    // TODO: When you rest, Denzel gives you a hug! You’ll be feeling fine, like you just can’t stop!
    public void restDenzel() {
        if (gm.player.playerLife < gm.player.playerMaxLife) { // TODO: If your life is low, Denzel’s here to help.
            gm.player.playerLife++; // TODO: Let’s heal you up, like a smooth dance move. One more life for you!
            gm.player.updatePlayerStatus(); // TODO: Update your status after getting healed. We’re good to go!
            showMessage("(Denzel has been lonely without his girlfriend)\n*Denzel runs up to you unexpectedly and gives you a hug*\n(Your life has been recovered)", gm.heal); // TODO: Give the hug and play the healing sound! It’s all love, baby!
            gm.playSE(gm.awSound); // TODO: And the "aww" sound because who doesn’t love a hug from Denzel?
        } else { // TODO: If you’re already at full life, we can’t heal you no more.
            showMessage("(Your life is full)", gm.cannotSound); // TODO: Play the sound of "no healing" – too good to heal, you’re shining.
        }
    }
}
