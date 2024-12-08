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

        currentMusic = mainTheme;
        playMusic(currentMusic);

        ui.createTitleScreen(primaryStage);
        timeManager = new TimeManager();

    }
//Graceful Shutdown of the Application to handle potential exceptions during application shutdown
    @Override
    public void stop() {
        try {
            if (gameTimer != null) {
                gameTimer.stop();
            }
            music.stop(currentMusic);
        } catch (Exception e) {
            System.err.println("Error during application shutdown: " + e.getMessage());
        } finally {
            System.out.println("Application stopped gracefully.");
        }
    }

    //Add try-catch blocks with meaningful error messages to handle potential issues.
    public void playSE(URL url) {
        try {
            if (url == null) {
                throw new IllegalArgumentException("Sound effect URL is null");
            }
            se.setFile(url);
            se.play(url);
        } catch (Exception e) {
            System.err.println("Error playing sound effect: " + e.getMessage());
        }
    }
//Add try-catch blocks with meaningful error messages to handle potential issues.
    public void playMusic(URL url) {
        try {
            music.setFile(url);
            music.play(url);
            music.loop(url);
        } catch (Exception e) {
            System.err.println("Error playing music: " + e.getMessage());
        }
    }
    public void stopMusic(URL url){

        music.stop(url);
    }

// Add try-catch blocks if there is an issue with starting the timer, handle it to avoid affecting game flow.
    public void startGameTimer() {
        try {
            startTime = System.nanoTime();
            gameTimer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    elapsedTime = (now - startTime) / 1_000_000; // Convert to milliseconds
                    updateTimerUI();
                }
            };
            gameTimer.start();
        } catch (Exception e) {
            System.err.println("Error starting the game timer: " + e.getMessage());
        }
    }



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

    //Add try-catch blocks with meaningful error messages to handle potential issues.
    public void updateTimerUI() {
        try {
            if (ui.timerLabel == null) {
                throw new NullPointerException("Timer label is not initialized in the UI");
            }

            long seconds = elapsedTime / 1000;
            long minutes = seconds / 60;
            seconds %= 60;

            // Update the timer label
            ui.timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
        } catch (Exception e) {
            System.err.println("Error updating timer UI: " + e.getMessage());
        }
    }

    public void showLeaderboard() {
        List<String> leaderboard = timeManager.getFormattedFastestTimes();
        ui.displayLeaderboard(leaderboard); // Add a method in UI to display the leaderboard
    }



}
