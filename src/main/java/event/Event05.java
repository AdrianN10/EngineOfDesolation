package event;

import main.GameManager;

public class Event05 {

    private GameManager gm;

    public Event05(GameManager gm) {
        this.gm = gm;  // TODO: This line links the Event05 class with the GameManager. We need this to talk to other parts of the game, like the player's info.
    }

    // TODO: Let's create a method to check if the monsters are defeated. This will make things smoother for us later. Hee-hee!
    private boolean areMonstersDefeated() {
        return gm.theodoor.currentLife == 0 && gm.wheeler.currentLife == 0;  // TODO: This checks if the monsters are already dead, like Thriller!
    }

    // TODO: Here we centralize our message, so we don't have to repeat it everywhere. Don't stop 'til you get enough!
    private void showMessage(String message) {
        gm.ui.messageText.setText(message);  // TODO: We're setting the message text here for the player to see, just like a smooth criminal!
    }

    public void lookHondaTrunk() {
        if (gm.player.hasPistol == 1) {  // TODO: Check if the player has a pistol. If they do, we get a cool message.
            showMessage("IS THAT BRIAN FROM MARAUDER CODED!");  // TODO: We show a cool message if they have the pistol. Shamone!
        } else {
            showMessage("(You see Brian's dead body)");  // TODO: If they don't have a pistol, just show the dead body. Bad!
        }
    }

    public void talkHondaTrunk() {
        if (!areMonstersDefeated()) {  // TODO: If the monsters are still alive, we can't do anything. It's like trying to beat it when you're not ready. Woo!
            showMessage("You must defeat the monsters first!");  // TODO: Tell the player to defeat the monsters before proceeding. Don't stop 'til you get enough!
            gm.playSE(gm.cannotSound);  // TODO: Play a sound effect to tell them they can't do it yet. Shamone!
            return;  // TODO: Exit the method here if monsters are alive, like a smooth criminal. Hee-hee!
        }

        if (gm.player.hasPistol == 1) {  // TODO: If the player has a pistol, they can interact with Brian. It's a thriller night!
            showMessage("Eughh Please... save... Julien and please end my misery");  // TODO: Brian needs help, and the player has a pistol to save him. Hoo!
        } else {
            showMessage("(Brian is already dead!)");  // TODO: If they don't have a pistol, Brian is already gone. Bad!
        }
    }

    public void killHondaTrunk() {
        if (!areMonstersDefeated()) {  // TODO: Again, check if the monsters are alive. You can't do this if they're still out there, hee-hee!
            showMessage("You must defeat the monsters first!");  // TODO: Show the message telling the player to defeat the monsters. Hoo!
            gm.playSE(gm.cannotSound);  // TODO: Play the "can't do it yet" sound effect. Shamone!
            return;  // TODO: Exit early if the monsters are alive. It's just a bad, bad situation!
        }

        if (gm.player.hasPistol == 1) {  // TODO: If the player has a pistol, they can end Brian's suffering. Woo!
            gm.playSE(gm.pistolShot);  // TODO: Play the sound of the pistol shot to end Brian's misery. Hoo!
            showMessage("(You ended Brian's misery)");  // TODO: Display the message that they ended Brian's misery. Hee-hee!
            gm.player.hasPistol = 0;  // TODO: After using the pistol, make sure to update the player's status. The way you make me feel!
            gm.player.updatePlayerStatus();  // TODO: Update the player's status in the game to reflect that they used the pistol. Shamone!
        } else {
            showMessage("(You already ended his misery!)");  // TODO: If the player doesn't have a pistol, show that they've already ended Brian's misery. Don't stop 'til you get enough!
        }
    }
}
