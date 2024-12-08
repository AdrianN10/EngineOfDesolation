package event;

import main.GameManager;

public class Event03 {

    // TODO: Hee-hee! This is where we declare the GameManager! So we can call it later. Yaa! 
    private GameManager gm;

    // TODO: Shamone! This is the constructor! It makes the Event03 class ready to use by getting the GameManager.
    public Event03(GameManager gm) {
        this.gm = gm; // TODO: Hoo! We're saving the GameManager for later use! It's like putting your gloves in your pocket, huh!
    }

    // TODO: Hee-hee! This is the method where we can talk to the Hondaur, look at the Hondaur, or attack it. Just tell it what to do!
    public void interactWithHondaur(String action) {
        // TODO: Shamone! We’re checking what action you want to do, it’s like picking a dance move! Hoo!
        switch (action.toLowerCase()) { // TODO: Shamone! We want to make sure the action is in the right form (lowercase), so we can do it!
            case "look": // TODO: Hee-hee! Looking at the Hondaur, that's the first move, baby! 
                gm.ui.messageText.setText("It's a Hondaur"); // TODO: Hee-hee! Displaying message when you look at the Hondaur. That's the message!
                break;
            case "talk": // TODO: Shamone! When you talk to the Hondaur, you hear a growl. It's like a smooth sound from the King of Pop!
                gm.ui.messageText.setText("The Hondaur growls at you and revs its engine"); // TODO: Hoo! It's revving its engine – that's like music to your ears!
                break;
            case "attack": // TODO: Hoo! When you attack, the beat drops! You start punching!
                gm.ui.messageText.setText("*You start beating the shit out of the poor Hondaur*"); // TODO: Hee-hee! You hit it hard – like a thriller night!
                break;
            default: // TODO: Shamone! What if the action isn't recognized? We’ve got to tell 'em what's up!
                gm.ui.messageText.setText("Unknown action"); // TODO: Hee-hee! If they don’t know what to do, we let them know!
        }
    }
}
