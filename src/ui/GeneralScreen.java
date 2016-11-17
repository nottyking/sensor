package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import lib.ConfigurableOption;
import lib.IRenderableHolder;
import lib.IRenderableObject;

public abstract class GeneralScreen extends StackPane {
	
	private Canvas canvas;
	
	public GeneralScreen(/*logic*/) {
		super();
		this.canvas = new Canvas(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight);
		//logic
		this.getChildren().add(this.canvas);
		this.addListener();
	}
	
	int x = 50;
	int y = 50;
	
	public void paintComponent() {
		//logic
		
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		gc.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		gc.setFill(Color.BLACK);
		x++;
		y++;
		gc.fillRect(x, y, 50, 50);
		
		// render 
		for(IRenderableObject renderable: IRenderableHolder.getStartScreenInstance().getEntities()) {
			renderable.render(gc);
		}
	}
	
	public abstract void addListener();
}
