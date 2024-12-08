package main;

/**
 * This class handles the transition of scenes
 *  * It manages the visibility of background panes, updates game messages,
 *  * and controls the background music for each scene.
 */
public class SceneChanger {

    // Reference to the GameManager instance
    GameManager gm;

    /**
     * Constructor for the SceneChanger class.
     * @param gm the GameManager instance that handles game operations.
     */
    public SceneChanger(GameManager gm) {

        this.gm = gm;
    }

    /**
     * Displays Scene 1: The player's room.
     * Updates the background, message text, and music for the scene.
     */
    public void showScene1(){

        gm.ui.bgPane[1].setVisible(true);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.bgPane[5].setVisible(false);
        gm.ui.bgPane[6].setVisible(false);
        gm.ui.messageText.setText("You are inside your room and you hear a sus sound outside");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.mainTheme;
        gm.playMusic(gm.currentMusic);
    }

    /**
     * Displays Scene 2: Outside the player's house.
     * Updates the background and message text.
     */
    public void showScene2(){

        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(true);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.bgPane[5].setVisible(false);
        gm.ui.bgPane[6].setVisible(false);
        gm.ui.messageText.setText("You are outside your house");
    }

    /**
     * Displays Scene 3: The woods.
     * Updates the background, message text, and plays the monster theme music.
     */
    public void showScene3(){
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(true);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.bgPane[5].setVisible(false);
        gm.ui.bgPane[6].setVisible(false);
        gm.ui.messageText.setText("The Engine Monster Stealer gets away and you find yourself lost in the woods");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.monsterTheme;
        gm.playMusic(gm.currentMusic);
    }

    /**
     * Displays Scene 4: Encounter with a mysterious character.
     * Updates the background, message text, and music for the scene.
     */
    public void showScene4() {
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(true);
        gm.ui.bgPane[5].setVisible(false);
        gm.ui.bgPane[6].setVisible(false);
        gm.ui.messageText.setText("You find a tall, dark, and handsome man");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.mainTheme;
        gm.playMusic(gm.currentMusic);
    }

    /**
     * Displays Scene 5: Near the casino, with monsters blocking the way.
     * Updates the background, message text, and plays the monster theme music.
     */
    public void showScene5() {
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.bgPane[5].setVisible(true);
        gm.ui.bgPane[6].setVisible(false);
        gm.ui.messageText.setText("The Casino is up ahead but 2 monsters block your way!");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.monsterTheme;
        gm.playMusic(gm.currentMusic);
    }

    /**
     * Displays Scene 6: Approaching the casino.
     * Updates the background, message text, and music for the scene.
     */
    public void showScene6() {
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.bgPane[5].setVisible(false);
        gm.ui.bgPane[6].setVisible(true);
        gm.ui.messageText.setText("You followed the sound of havoc and made your way to the Casino");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.mainTheme;
        gm.playMusic(gm.currentMusic);
    }

    /**
     * Displays Scene 7: Entering the casino.
     * Updates the background, message text, and plays casino music.
     */
    public void showScene7() {
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.bgPane[5].setVisible(false);
        gm.ui.bgPane[6].setVisible(false);
        gm.ui.bgPane[7].setVisible(true);
        gm.ui.messageText.setText("You enter the Casino but its too late");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.casinoMusic;
        gm.playMusic(gm.currentMusic);
    }

    /**
     * Displays Scene 8: Confronting the monster.
     * Updates the background, message text, and plays monster theme music.
     */
    public void showScene8() {
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.bgPane[5].setVisible(false);
        gm.ui.bgPane[6].setVisible(false);
        gm.ui.bgPane[7].setVisible(false);
        gm.ui.bgPane[8].setVisible(true);
        gm.ui.messageText.setText("You catch up to the monster");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.monsterTheme;
        gm.playMusic(gm.currentMusic);
    }

    /**
     * Displays the leaderboard screen.
     * Updates the background, message text, and shows leaderboard information.
     */
    public void viewLeaderboard() {
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.bgPane[5].setVisible(false);
        gm.ui.bgPane[6].setVisible(false);
        gm.ui.bgPane[7].setVisible(false);
        gm.ui.bgPane[8].setVisible(false);
        gm.ui.bgPane[9].setVisible(true);

        gm.showLeaderboard();
        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.mainTheme;
        gm.playMusic(gm.currentMusic);
        gm.ui.messageText.setText("Congrats! You won!");

    }
    public void showGameOverScreen(int currentBgNum){

            gm.ui.bgPane[currentBgNum].setVisible(false);
            gm.ui.titleLabel.setVisible(true);
            gm.ui.titleLabel.setText("YOU DIED");
            gm.ui.restartButton.setVisible(true);
            gm.ui.restartButton.setText("Click Here To Restart");
            gm.stopGameTimer();

            gm.stopMusic(gm.currentMusic);

            gm.playSE(gm.gameOverSound);
            gm.playSE(gm.gameOverVoice);
        }

    /**
     * Displays the Game Over screen.
     * currentBgNum The current background number to hide before showing the Game Over screen.
     */
    public void exitGameOverScreen(){

        gm.ui.titleLabel.setVisible(false);
        gm.ui.restartButton.setVisible(false);
        gm.hondaur.reset();
        gm.theodoor.reset();
        gm.wheeler.reset();
        gm.ev6.reset();
        gm.engineStealerMonster.reset();
        gm.player.setPlayerDefaultStatus();
    }

}
