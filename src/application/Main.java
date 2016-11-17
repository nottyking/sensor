package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;

import ui.GameScreen;
import ui.GeneralScreen;
import ui.StartScreen;
import ui.TutorialScreen;


public class Main extends Application {
	
	public static Main instance;
	private Stage primaryStage;
	private Scene startScene;
	private Scene gameScene;
	private Scene tutorialScene;
	private StartScreen startScreen;
	private GameScreen gameScreen;
	private TutorialScreen tutorialScreen;
	private GeneralScreen currentScreen;
	
	@Override
	public void start(Stage primaryStage) {
		instance = this;
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("NONAME");
		this.primaryStage.setResizable(false);
		this.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});
		
		// create start scene
		this.startScreen = new StartScreen();
		this.startScene = new Scene(this.startScreen);
		
		// create game scene
		this.gameScreen = new GameScreen();
		this.gameScene = new Scene(this.gameScreen);
		
		// create tutorial scene
		this.tutorialScreen = new TutorialScreen();
		this.tutorialScene = new Scene(this.tutorialScreen);
		
		this.currentScreen = this.startScreen;
		
		new AnimationTimer() {
            @Override
            public void handle(long now) {
            	currentScreen.paintComponent();
            }
        }.start();
        
		this.primaryStage.setScene(this.startScene);
		this.primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public synchronized void changeScene(String sceneName) {
		if(sceneName == "start") {
			this.primaryStage.setScene(startScene);
			this.currentScreen = this.startScreen;
		}
		else if(sceneName == "game") {
			this.primaryStage.setScene(gameScene);
			this.currentScreen = this.gameScreen;
		}
		else {
			this.primaryStage.setScene(tutorialScene);
			this.currentScreen = this.tutorialScreen;
		}
	}
	
	public void drawGameScreen(){
		this.currentScreen.paintComponent();
	}
}
