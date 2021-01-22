package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;


public class EventController {
	Zeitgeber derTimer;
	
	void start() {
		//derTimer = new Zeitgeber(this, 10);
		//derTimer.starte();
	}
	
	
	ObservableList<String> list = FXCollections.observableArrayList();
	
	String[] itemName = {("Wood:\t" + 3), ("Metal:\t" + 0), ("Hay:\t\t" + 20)};

	@FXML
	ImageView imgV1;
	@FXML
	ImageView imgV2;
	@FXML
	ImageView imgV3;
	@FXML
	ImageView imgV4;
	@FXML
	ImageView imgV5;
	@FXML 
	ListView<String> lw;
	
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
		startGame();

	}
	
	private void startGame() {
		Image img = new Image("srewdriver.png");
		
		imgV1.setImage(img);
		imgV2.setImage(img);
		imgV3.setImage(img);
		imgV4.setImage(img);
		imgV5.setImage(new Image("Quack.png"));
		
		list.removeAll(list);
		list.addAll(itemName[0], itemName[1], itemName[2]);
		lw.getItems().addAll(list);
		
	}
	
	public void tickTimer() {

	}

	void stop() {
		System.out.println("Game Over");
		derTimer.stoppe();

	}

}
