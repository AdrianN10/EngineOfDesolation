package main;
/**
 * This the main class that handles the game logic
 */

import event.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import monsters.EngineStealerMonster;
import monsters.Hondaur;
import monsters.Theodoor;
import monsters.Wheeler;

import java.net.URL;
import java.util.List;

public class GameManager extends Application {
    // TODO: Add Javadoc to explain the purpose of this class and its main responsibilities
    // TODO: Handles exceptions gracefully in all methods, such as file-related operations or invalid inputs
    // TODO: Add proper shutdown handling when the application exists

    ActionHandler aHandler = new ActionHandler(this);
    public UI ui = new UI(this);
    public Player player = new Player(this);
    public SceneChanger sChanger = new SceneChanger(this);

    private long startTime;
    public AnimationTimer gameTimer;
    public long elapsedTime;
    private TimeManager timeManager;

    public Event01 ev1 = new Event01(this);
    public Event02 ev2 = new Event02(this);
    public Event03 ev3 = new Event03(this);
    public Event04 ev4 = new Event04(this);
    public Event05 ev5 = new Event05(this);
    public Event06 ev6 = new Event06(this);
    public Event07 ev7 = new Event07(this);
    public Hondaur hondaur = new Hondaur(this);
    public EngineStealerMonster engineStealerMonster = new EngineStealerMonster(this);
    public Theodoor theodoor = new Theodoor(this);
    public Wheeler wheeler = new Wheeler(this);
    Music music = new Music();
    SoundEffect se = new SoundEffect();

    //SOUND
     public URL mainTheme = getClass().getClassLoader().getResource("mainTheme.wav");
    public URL monsterTheme = getClass().getClassLoader().getResource("monsterTheme.wav");
    public URL casinoMusic = getClass().getClassLoader().getResource("casinoMusic.wav");
    public URL slotWin = getClass().getClassLoader().getResource("slotWin.wav");
    public URL monsterHit = getClass().getClassLoader().getResource("monsterHit.wav");
    public URL monsterRoar = getClass().getClassLoader().getResource("monsterRoar.wav");
    public URL ak47shots = getClass().getClassLoader().getResource("ak47shots.wav");
    public URL pistolShot = getClass().getClassLoader().getResource("pistolShot.wav");
    public URL reload = getClass().getClassLoader().getResource("reload.wav");
    public URL flashlightSwitch = getClass().getClassLoader().getResource("flashlightSwitch.wav");
    public URL heal = getClass().getClassLoader().getResource("heal.wav");
    public URL awSound = getClass().getClassLoader().getResource("awSound.wav");
    public URL gameOverSound = getClass().getClassLoader().getResource("gameOverSound.wav");
    public URL gameOverVoice = getClass().getClassLoader().getResource("gameOverVoice.wav");
    public URL cannotSound = getClass().getClassLoader().getResource("cannotSound.wav");
    public URL engineNoise = getClass().getClassLoader().getResource("engineNoise.wav");
    public URL currentMusic;

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // TODO: Add a try-catch block to catch expressions during UI initialization
        // TODO: Ensure all JavaFX components are initialized before use

        currentMusic = mainTheme;
        playMusic(currentMusic);

        ui.createTitleScreen(primaryStage);
        timeManager = new TimeManager();

    }

    public void playSE(URL url) {
        // TODO: Add null checks for 'url' before using it

        se.setFile(url);
        se.play(url);
    }
    public void playMusic(URL url){

        music.setFile(url);
        music.play(url);
        music.loop(url);
    }
    public void stopMusic(URL url){

        music.stop(url);
    }


    public void startGameTimer() {
        // TODO: Ensure the timer stops properly if already running before starting a new one
        startTime = System.nanoTime();
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                elapsedTime = (now - startTime) / 1_000_000; // Convert to milliseconds
                updateTimerUI();
            }
        };
        gameTimer.start();
    }
    
    /**
     * Stops the game timer and updates the leaderboard if the monster is defeated.
     */

    public void stopGameTimer() {
        if (gameTimer != null) {
            gameTimer.stop();
        }
        // Check if the monster is defeated and save the time
        if (engineStealerMonster.currentLife == 0) {
            timeManager.addTime(elapsedTime);
            ui.messageText.setText("Your time: " + TimeManager.TimeUtils.formatTime(elapsedTime));
        }
    }

/**
     * Updates the game's timer display on the UI.
     */
    
    public void updateTimerUI() {
        // Format the time as minutes and seconds
        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        seconds %= 60;

        // Display the timer on the UI
        ui.timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

    /**
     * Displays the Leaderboard with the fastest times.
     */
    
    public void showLeaderboard() {
        List<String> leaderboard = timeManager.getFormattedFastestTimes();
        ui.displayLeaderboard(leaderboard); // Add a method in UI to display the leaderboard
    }
}
