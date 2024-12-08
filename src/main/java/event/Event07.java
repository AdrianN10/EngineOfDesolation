package event;

import main.GameManager;

public class Event07 {

    GameManager gm;
    public int julianLife = 2;

    public Event07(GameManager gm) {
        this.gm = gm;
    }

    // TODO: "Wanna make things simple? Let's make a method to show messages, yeah!"
    // This helper function sets the message text in the UI. It's like calling out your message on stage.
    private void setMessage(String message) {
        gm.ui.messageText.setText(message);
    }

    // TODO: "You gotta keep it cool, check Julian's life, and set the message, you know?"
    // This method handles what happens when Julian is dead. Gotta tell the truth, yeah!
    private void handleJulianDeath() {
        if (julianLife <= 0) {  // When Julian is dead, we gotta show the right message.
            setMessage("Julien is already dead");
            gm.playSE(gm.cannotSound);  // Play sound to emphasize the sadness.
        }
    }

    // TODO: "Make sure Julian ain't dead before we say anything, alright?"
    public void lookJulian() {
        if (julianLife > 0) {
            setMessage("Julian is in serious condition"); // Show Julian is in trouble, but he's still with us.
        } else {
            setMessage("You see Julien's lifeless body"); // Julian's gone. This one's heavy.
        }
    }

    // TODO: "I know it’s tough, but if Julian’s still alive, let's talk to him. Let’s keep it alive!"
    public void talkJulian() {
        if (julianLife > 0) {
            setMessage("*Julian cries when he sees you* I don't want to die..."); // Julian’s feeling the pain, man.
        } else {
            handleJulianDeath(); // If he's dead, just handle it.
        }
    }

    // TODO: "Hold on to Julian, but make sure he's still alive, okay?"
    public void holdJulian() {
        if (julianLife > 0) {
            setMessage("*You hold Julian's hand and tell him it'll be okay*\nJulian says his last words: Can you spin it one last time for me?");
            // Decrease Julian's life after the moment, he's getting closer to passing, yeah.
            julianLife = (julianLife == 2) ? 1 : 0; 
        } else {
            handleJulianDeath();  // Can't hold a dead man, buddy.
        }
    }

    // TODO: "Let's take a look at the slot machine, but don’t forget, you gotta win big!"
    public void lookSlotMachine() {
        setMessage("You see the slot machine that the Marauder Coded gang made");  // Check out the machine. It's something!
    }

    // TODO: "Alright, it’s time to talk to the slot machine. What’s your aura saying?"
    public void talkSlotMachine() {
        setMessage("(The slot machine displays your aura: 10,000,000)");  // Oh yeah, you got that aura.
    }

    // TODO: "Spin it! But make sure you’ve held Julian first! Don’t forget the order!"
    public void spinSlotMachine() {
        if (julianLife == 1) {
            setMessage("*You spin*\n YOU WIN 6 MILLION DOLLARS!!!\n *Julien sighs and passes away*"); // Spin and win, but Julian's time is up.
            julianLife = 0;  // Julian's done after this.
            gm.playSE(gm.slotWin);  // Play that sweet win sound, but it's bittersweet.
        } else if (julianLife == 2) {
            setMessage("You must hold Julian first!");  // Can’t spin without holding him, remember that!
            gm.playSE(gm.cannotSound);  // That sound says "Nope, try again!"
        } else {
            setMessage("*You have no more spins left*");  // No more spins, buddy.
            gm.playSE(gm.cannotSound);  // It’s a "no-go" sound.
        }
    }

    // TODO: "Look at Adrian, the big boss, but be gentle with your words."
    public void lookAdrian() {
        setMessage("You see Adrian, the leader of the Honda Boyz");  // Here comes Adrian, check him out.
    }

    // TODO: "Talk to Adrian, feel the pain. It’s all about peace... but now it's sad."
    public void talkAdrian() {
        setMessage("It was supposed to be an era of peace between the Honda Boyz and Marauder Coded\n *Adrian cries*\n I tried to save him I really did");
    }

    // TODO: "Thank Adrian for trying his best. A little gratitude goes a long way."
    public void thankAdrian() {
        setMessage("*You thank Adrian for his great efforts*\n (Adrian will give you 10% of his profits if you avenge Julian)");
    }
}
