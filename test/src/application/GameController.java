package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GameController implements ActionListener {
	Timer EierUhr;
	Timer sheepTimer;
	Timer cowTimer;
	Boolean newGame = true;

	ObservableList<String> list = FXCollections.observableArrayList();

	static User player;

	@FXML
	Button btnSale;
	@FXML
	Button btnBuy;

	public Text txtName, txtCow;
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

	public ImageView imgWolle, cow, imgMilk;

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
		EierUhr = new Timer(1000, this);
		EierUhr.start();
		sheepTimer = new Timer(5000, this);
		cowTimer = new Timer(7500, this);

		String[] itemName = { ("Wood:\t" + player.getWood()), ("Hay:\t\t" + player.getHay()),
				("Eggs:\t" + player.getEggs()) };
		startGame(itemName);

	}

	private void startGame(String[] itemName) {
		Image img = new Image("/icons/srewdriver.png");

		moneyLabel.setText(player.getMoney() + "€");
		txtName.setText(player.getName());

		btnSale.setDisable(true);
		btnBuy.setDisable(true);
		woodCow.setVisible(false);
		metalCow.setVisible(false);

		sheep.setImage(new Image("/icons/Mah.png"));
		sheep.setVisible(false);
		imgWolle.setImage(new Image("/icons/Weiße_Wolle.png"));
		imgWolle.setVisible(false);

		cow.setImage(new Image("/icons/Muh.png"));
		cow.setVisible(false);
		imgMilk.setImage(new Image("/icons/Milcheimer.png"));
		imgMilk.setVisible(false);

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

	public void collectEgg() {
		if (imgEeg.isVisible()) {
			int eggmultiplayer = player.getEggs() + 1 * player.getAmtChicken() * player.getLvlChicken();
			player.setEggs(eggmultiplayer);
			imgEeg.setVisible(false);
			EierUhr.start();
			lw.getItems().set(2, ("Eggs:\t" + player.getEggs()));
			player.setColEggs(player.getColEggs() + 1);

			if (player.getColEggs() >= 50) {
				player.setLvl(player.getLvl() + 1);
				player.setColEggs(0);
			}
		}
	}

	public void collectWoll() {
		if (imgWolle.isVisible()) {
			int woolMultiplayer = player.getWool() + 1 * player.getAmtSheep() * player.getLvlSheep();
			player.setWool(woolMultiplayer);
			imgWolle.setVisible(false);

			lw.getItems().set(3, ("Wool:\t" + player.getWool()));
			sheepTimer.start();
			player.setColWool(player.getColWool() + 1);

			if (player.getColWool() >= 10) {
				player.setLvl(player.getLvl() + 1);
				player.setColWool(0);
			}
		}
	}

	public void collectMilk() {
		if (imgMilk.isVisible()) {
			int milkMultiplayer = player.getMilk() + 1 * player.getAmtCow() * player.getLvlCow();
			player.setMilk(milkMultiplayer);
			imgMilk.setVisible(false);

			lw.getItems().set(5, ("Milk:\t\t" + player.getMilk()));
			cowTimer.start();
			player.setColMilk(player.getColMilk() + 1);

			if (player.getColMilk() >= 8) {
				player.setLvl(player.getLvl() + 1);
				player.setColMilk(0);
			}
			System.out.println(player.getMilk());
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

			player.setAmtSheep(player.getAmtSheep() + 1);

			lw.getItems().add("Wool:\t" + player.getWool());
			lw.getItems().add("Metal:\t" + player.getMetal());

			sheepTimer.start();
		}
	}

	public void buildCow() {
		if (player.getWood() >= 3 && player.getMetal() >= 3) {

			woodCow.setVisible(false);
			metalCow.setVisible(false);
			imgV4.setVisible(false);
			cow.setVisible(true);
			txtCow.setVisible(false);

			player.setWood(player.getWood() - 3);
			lw.getItems().set(0, ("Wood:\t" + player.getWood()));

			player.setMetal(player.getMetal() - 3);
			lw.getItems().set(4, ("Metal:\t" + player.getMetal()));

			player.setAmtCow(player.getAmtCow() + 1);

			lw.getItems().add("Milk:\t\t" + player.getMilk());

			cowTimer.start();
		}
	}

	public void saleHandler() {
		String temp = item.substring(0, 4);

		switch (temp) {
		case "Eggs":
			if (player.getEggs() >= 1) {
				player.setEggs(player.getEggs() - 1);
				player.setMoney(player.getMoney() + 10);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(2, ("Eggs:\t" + player.getEggs()));
			}
			break;

		case "Hay:":
			if (player.getHay() >= 1) {
				player.setHay(player.getHay() - 1);
				player.setMoney(player.getMoney() + 5);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(1, ("Hay:\t\t" + player.getHay()));
			}
			break;
		case "Wood":
			if (player.getWood() >= 1) {
				player.setWood(player.getWood() - 1);
				player.setMoney(player.getMoney() + 50);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(0, ("Wood:\t" + player.getWood()));
			}
			break;
		case "Wool":
			if (player.getWool() >= 1) {
				player.setWool(player.getWool() - 1);
				player.setMoney(player.getMoney() + 75);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(3, ("Wool:\t" + player.getWool()));
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
		case "Wool":
			if (player.getMoney() >= 150) {
				player.setWool(player.getWool() + 1);
				player.setMoney(player.getMoney() - 150);

				moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(3, ("Wool:\t" + player.getWool()));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sheepTimer) {
			imgWolle.setVisible(true);
			sheepTimer.stop();
		} else if (e.getSource() == EierUhr) {
			System.out.println("spawnegg");
			imgEeg.setVisible(true);
			EierUhr.stop();
		} else if (e.getSource() == cowTimer) {
			imgMilk.setVisible(true);
			cowTimer.stop();
		}
	}

}
