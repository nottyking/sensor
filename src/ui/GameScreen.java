package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import lib.ConfigurableOption;
import lib.IRenderableHolder;
import lib.IRenderableObject;

public class GameScreen extends StackPane {
	
	private Canvas canvas;
	
	public GameScreen(/*logic*/) {
		super();
		this.canvas = new Canvas(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight);
		//logic
		this.getChildren().add(this.canvas);
		this.addListener();
	}
	
	public void paintComponent() {
		//logic
		
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		gc.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());

		// render 
		for(IRenderableObject renderable: IRenderableHolder.getInstance().getEntities()) {
			renderable.render(gc);
		}
	}
	
	public void addListener() {
		
	}
}
