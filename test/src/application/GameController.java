package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class GameController {
	Zeitgeber EierUhr;
	Zeitgeber sheepTimer;
	Boolean newGame = true;

	void start() {
		// derTimer = new Zeitgeber(this, 10);
		// derTimer.starte();
	}

	ObservableList<String> list = FXCollections.observableArrayList();

	static User player;
	

	@FXML
	Button btnSale;
	@FXML
	Button btnBuy;

	@FXML
	Text woodSheep;
	@FXML
	Text sheepR;
	@FXML
	Text moneyLabel;
	@FXML
	Text woodCow;
	@FXML
	Text metalCow;
	@FXML
	ImageView sheep;
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
		EierUhr = new Zeitgeber(this, 1000);
		EierUhr.starte();
		sheepTimer = new Zeitgeber(this, 5000);
		
		String[] itemName = { ("Wood:\t" + player.getWood()), ("Hay:\t\t" + player.getHay()),
				("Eegs:\t" + player.getEggs()) };
		startGame(itemName);

	}

	private void startGame(String[] itemName) {
		Image img = new Image("/icons/srewdriver.png");

		moneyLabel.setText(player.getMoney() + "€");

		btnSale.setDisable(true);
		btnBuy.setDisable(true);
		woodCow.setVisible(false);
		metalCow.setVisible(false);

		sheep.setImage(new Image("/icons/Mah.png"));
		sheep.setVisible(false);

		imgV1.setImage(img);
		imgV2.setImage(img);
		imgV3.setImage(img);
		imgV4.setImage(img);
		imgV5.setImage(new Image("/icons/Quack.png"));
		imgEeg.setImage(new Image("/icons/eeg.png"));
		imgEeg.setVisible(false);
		list.removeAll(list);
		list.addAll(itemName[0], itemName[1], itemName[2]);
		lw.getItems().addAll(list);

	}

	public void tickTimer() {
		imgEeg.setVisible(true);
		EierUhr.stoppe();
	}

	public void collectEgg() {
		if (imgEeg.isVisible()) {
			int eggmultiplayer = player.getEggs() + 1 * player.getAmtChicken() * player.getLvlChicken();
			player.setEggs(eggmultiplayer);
			imgEeg.setVisible(false);
			EierUhr.starte();
			lw.getItems().set(2, ("Eegs:\t" + player.getEggs()));
		}
	}

	public void collectWoll() {
		if (imgEeg.isVisible()) {
			int eggmultiplayer = player.getEggs() + 1 * player.getAmtChicken() * player.getLvlChicken();
			player.setEggs(eggmultiplayer);
			imgEeg.setVisible(false);
			EierUhr.starte();
			lw.getItems().set(2, ("Eegs:\t" + player.getEggs()));
		}
	}
	
	
	public void buildSheep() {
		if (player.getWood() >= 3) {
			woodCow.setVisible(true);
			metalCow.setVisible(true);
			imgV2.setVisible(false);
			sheep.setVisible(true);
			sheepR.setVisible(false);
			woodSheep.setVisible(false);

			player.setWood(player.getWood() - 3);
			lw.getItems().set(0, ("Wood:\t" + player.getWood()));
			
			//sheepTimer.starte();
		}
	}

	public void saleHandler() {
		String temp = item.substring(0, 1);

		switch (temp) {
		case "E":
			if (player.getEggs() >= 1) {
				player.setEggs(player.getEggs() - 1);
				player.setMoney(player.getMoney() + 10);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(2, ("Eegs:\t" + player.getEggs()));
			}
			break;

		case "H":
			if (player.getHay() >= 1) {
				player.setHay(player.getHay() - 1);
				player.setMoney(player.getMoney() + 5);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(1, ("Hay:\t\t" + player.getHay()));
			}
			break;
		case "W":
			if (player.getWood() >= 1) {
				player.setWood(player.getWood() - 1);
				player.setMoney(player.getMoney() + 50);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(0, ("Wood:\t" + player.getWood()));
			}
			break;
		}

	}

	public void buyHandler() {
		String temp = item.substring(0, 1);
		switch (temp) {
		case "E":
			if (player.getMoney() >= 15) {
				player.setEggs(player.getEggs() + 1);
				player.setMoney(player.getMoney() - 15);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(2, ("Eegs:\t" + player.getEggs()));
			}
			break;

		case "H":
			if (player.getMoney() >= 10) {
				player.setHay(player.getHay() + 1);
				player.setMoney(player.getMoney() - 10);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(1, ("Hay:\t\t" + player.getHay()));
				}
			break;
		case "W":
			if (player.getMoney() >= 100) {
				player.setWood(player.getWood() + 1);
				player.setMoney(player.getMoney() - 100);

				moneyLabel.setText(player.getMoney() + "€");
				
				lw.getItems().set(0, ("Wood:\t" + player.getWood()));
			}
			break;
		}
	}

	private String item;

	public void listHandler() {
		item = lw.getSelectionModel().getSelectedItem();
		if (item == null || item.isEmpty()) {
			return;
		} else {

			btnSale.setDisable(false);
			btnBuy.setDisable(false);

		}

	}

}
