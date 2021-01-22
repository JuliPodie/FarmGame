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
	Boolean newGame = true;
	void start() {
		//derTimer = new Zeitgeber(this, 10);
		//derTimer.starte();
	}
	
	
	ObservableList<String> list = FXCollections.observableArrayList();
	
	User player;

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
	ImageView imgEeg;
	
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
		derTimer = new Zeitgeber(this, 1000);
		derTimer.starte();
		player = new User(newGame);
		String[]itemName = {("Wood:\t" + player.getWood()), ("Metal:\t" + player.getMetal()), ("Hay:\t\t" + player.getHay()), ("Eegs:\t" + player.getEegs())};
		startGame(itemName);

	}
	
	private void startGame(String[] itemName) {
		Image img = new Image("/icons/srewdriver.png");
		
		imgV1.setImage(img);
		imgV2.setImage(img);
		imgV3.setImage(img);
		imgV4.setImage(img);
		imgV5.setImage(new Image("/icons/Quack.png"));
		imgEeg.setImage(new Image("/icons/eeg.png"));
		imgEeg.setVisible(false);
		list.removeAll(list);
		list.addAll(itemName[0], itemName[1], itemName[2],itemName[3]);
		lw.getItems().addAll(list);
		
	}
	
	public void tickTimer() {
		imgEeg.setVisible(true);
		derTimer.stoppe();
	}

	public void collectEgg() {
		if (imgEeg.isVisible()) {
		int eggmultiplayer = player.getEegs() + 1 * player.getAmtChicken() * player.getLvlChicken();
		player.setEegs(eggmultiplayer);
		imgEeg.setVisible(false);
		derTimer.starte();
		lw.getItems().set(3, ("Eegs:\t" + player.getEegs()));
		}
	}
	
	public void buildSheep() {
		
	}


}
