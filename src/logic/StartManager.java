package logic;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import lib.ConfigurableOption;
import lib.DefaultManager;
import lib.IRenderableHolder;
import model.GameText;

public class StartManager extends DefaultManager {
	
	private Font font = new Font("Tahoma", 100);
	
	private GameText gameText;
	
	private int counter;
	private int shakeDelay;
	
	public StartManager() {
		gameText = new GameText("NONAME", ConfigurableOption.screenWidth / 2, 100, 3, font, Color.ORANGE, Color.BLACK);
		gameText.setZ(1);
		shakeDelay = 3;
		counter = 0;
		IRenderableHolder.getInstance().add(gameText);
	}
	
	@Override
	public void update() {
		if(counter%shakeDelay == 0) shakeGameName();
		counter++;
	}
	
	private void shakeGameName() {
		Random rand = new Random();
		int x = gameText.getDefaultX();
		int y = gameText.getDefaultY();
		gameText.setX(x + rand.nextInt(10) - 5);
		gameText.setY(y + rand.nextInt(10) - 5);
		
	}
}
