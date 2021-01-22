package application;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class EventController {
	Zeitgeber derTimer;
	
	void start() {
		derTimer = new Zeitgeber(this, 10);
		derTimer.starte();
	}

	@FXML
	void keyPressed(KeyEvent event) {
		switch (event.getCode()) {
		case UP:
			
			break;
		case DOWN:
			break;
		case LEFT:
			break;
		case RIGHT:
			break;
		default:
			break;
		}
	}

	public void initialize() {
		derTimer = new Zeitgeber(this, 100);

	}

	public void tickTimer() {

	}

	void stop() {
		System.out.println("Game Over");
		derTimer.stoppe();

	}

	static int random(int value) {
		return (int) (Math.random() * value + 5);
	}

}
