package main;

/**
 * this class handles the player logic
 */
public class Player {
    // TODO: Add Javadoc to explain the purpose of this class and its fields
    // TODO: Make fields private and provide getter and setter methods as needed
    // TODO: Add input validation in setter methods like prevent negative health

    GameManager gm;

    public int playerMaxLife;
    public int playerLife;

    public int hasFlashlight;
    public int hasPistol;
    public int hasAk47;


    public Player(GameManager gm) {

        this.gm = gm;
    }

    public void setPlayerDefaultStatus() {
        // TODO: Use constants for default value instead of magic numbers like 'PLAYER_MAX_LIFE = 5' and so on

        playerMaxLife = 5;
        playerLife = 2;
        hasFlashlight = 0;
        hasPistol = 0;
        hasAk47 = 0;

        updatePlayerStatus();
    }
    public void updatePlayerStatus() {
        // TODO: Add comments to explain each step of updating the player status

        int i = 0;
        while (i < 5) {
            gm.ui.lifeLabels[i].setVisible(false);
            i++;
        }

        // Set visible only the icons corresponding to playerLife
        // TODO: Ensure array bounds are checked when updating UI Labels
        int lifeCount = playerLife;
        i = 0; // Reset i to 0 to use for setting life icons
        while (lifeCount > 0 && i < gm.ui.lifeLabels.length) {
            gm.ui.lifeLabels[i].setVisible(true);
            lifeCount--;
            i++;
        }

        // CHECK PLAYER ITEMS
        gm.ui.flashlightLabel.setVisible(hasFlashlight == 1);
        gm.ui.pistolLabel.setVisible(hasPistol == 1);
        gm.ui.ak47Label.setVisible(hasAk47 == 1);
        }
    }

