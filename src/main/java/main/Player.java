package main;

/**
 * this class handles the player logic
 */
public class Player {

    GameManager gm;

    public int playerMaxLife;
    public int playerLife;

    //TODO: since the game only uses one of each of these items, use a boolean to check if player has these items
    public boolean hasFlashlight;
    public boolean hasPistol;
    public boolean hasAk47;


    public Player(GameManager gm) {

        this.gm = gm;
    }

    public void setPlayerDefaultStatus() {

        playerMaxLife = 5;
        playerLife = 2;
        hasFlashlight = false;
        hasPistol = false;
        hasAk47 = false;

        updatePlayerStatus();
    }
    public void updatePlayerStatus() {

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
        gm.ui.flashlightLabel.setVisible(hasFlashlight);
        gm.ui.pistolLabel.setVisible(hasPistol);
        gm.ui.ak47Label.setVisible(hasAk47);
        }
    }

