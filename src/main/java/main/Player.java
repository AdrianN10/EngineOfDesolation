package main;

/**
 * this class handles the player logic
 * TODO: Consider adding more detailed class description
 */
public class Player {

    GameManager gm;
    // TODO: Consider making gm private and providing a getter method if needed

    public int playerMaxLife;
    public int playerLife;
    // TODO: Consider making these variables private and providing getter/setter methods

    public int hasFlashlight;
    public int hasPistol;
    public int hasAk47;
    // TODO: Consider using boolean instead of int for these item flags
    // TODO: Consider using an enum or a more flexible data structure for inventory management


    public Player(GameManager gm) {

        this.gm = gm;
        // TODO: Consider calling setPlayerDefaultStatus() here to initialize player status
    }

    public void setPlayerDefaultStatus() {

        playerMaxLife = 5;
        playerLife = 2;
        hasFlashlight = 0;
        hasPistol = 0;
        hasAk47 = 0;

        updatePlayerStatus();
        // TODO: Consider adding a method to reset player status to full health
    }
    public void updatePlayerStatus() {
        // TODO: Consider extracting the life icon update logic to a separate method
        int i = 0;
        while (i < 5) {
            gm.ui.lifeLabels[i].setVisible(false);
            i++;
        }

        // Set visible only the icons corresponding to playerLife
        int lifeCount = playerLife;
        i = 0; // Reset i to 0 to use for setting life icons
        while (lifeCount > 0 && i < gm.ui.lifeLabels.length) {
            gm.ui.lifeLabels[i].setVisible(true);
            lifeCount--;
            i++;
        }

        // CHECK PLAYER ITEMS
        // TODO: Consider extracting the item visibility update logic to a separate method

        gm.ui.flashlightLabel.setVisible(hasFlashlight == 1);
        gm.ui.pistolLabel.setVisible(hasPistol == 1);
        gm.ui.ak47Label.setVisible(hasAk47 == 1);
        }

    // Consider adding methods for player actions (e.g., takeDamage, heal, pickUpItem)
    // Consider adding a method to check if the player is alive
    // Consider adding methods to manage inventory (e.g., addItem, removeItem)
    }

