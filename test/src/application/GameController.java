package application;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

public class GameController implements ActionListener{
	
	Timer EierUhr = new Timer(1000, this);
	Timer sheepTimer = new Timer(5000, this);
	Timer cowTimer = new Timer(7500, this);;
	
	Boolean newGame = true;

	ObservableList<String> list = FXCollections.observableArrayList();

	static User player;
	
	public Pane paneMain, paneTop, paneHome, paneOpt, paneHelp, paneSheep, paneCow, paneChicken, paneDog, paneHorse;
	
	public Label lblTopName, lblTopLvl, lblGameSheep, lblGameCow, lblGameChicken, lblGameDog, lblGameHorse, lblGameMoney, lblGameWood, lblGameMetal, lblGameHay, lblGameEgg, lblGameWool, lblGameMilk;
	
	public Button btnGameHome, btnGameOpt, btnGameHelp, btnOptOpt, btnOptSave, btnOptExit, btnHomeShop;
	
	public ImageView imgGameSheep, imgGameSheepProd, imgGameCow, imgGameCowProd, imgGameChicken, imgGameChickenProd, imgGameDog, imgGameHorse, 
						imgGameMoney, imgGameWood, imgGameMetal, imgGameHay, imgGameEgg, imgGameWool, imgGameMilk;
	
	public ProgressBar prgTopLvl, prgGameSheep, prgGameCow, prgGameChicken, prgGameDog, prgGameHorse;
	
	public Image imgScrew, imgSheep, imgCow, imgChicken, imgMoney, imgWood, imgMetal, imgHay, imgEgg, imgWool, imgMilk;
	
	public Text t;
	
	public ListView<String> lw;

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
		System.out.println("s");
		
		imgScrew = new Image("/icons/srewdriver.png");
		imgSheep = new Image("/icons/sheep.png");
		imgCow = new Image("/icons/cow.png");
		imgChicken = new Image("/icons/chicken.png");
		imgMoney = new Image("/icons/money.png");
		imgWood = new Image("/icons/wood.png");
		imgMetal = new Image("/icons/metal.png");
		imgHay = new Image("/icons/hay.png");
		imgEgg = new Image("/icons/egg.png");
		imgWool = new Image("/icons/wool.png");
		imgMilk = new Image("/icons/milk.png");
		
		
		imgGameChicken.setImage(imgScrew);
		imgGameChicken.setVisible(true);
		imgGameChickenProd.setImage(imgEgg);
		imgGameChickenProd.setVisible(false);
		
		imgGameSheep.setImage(imgScrew);
		imgGameSheep.setVisible(true);
		imgGameSheepProd.setImage(imgWool);
		imgGameSheepProd.setVisible(false);

		imgGameCow.setImage(imgScrew);
		imgGameCow.setVisible(true);
		imgGameCowProd.setImage(imgMilk);
		imgGameCowProd.setVisible(false);
		
		imgGameDog.setImage(imgScrew);
		imgGameDog.setVisible(true);
		
		imgGameHorse.setImage(imgScrew);
		imgGameHorse.setVisible(true);
		
		//--------------------------
		
		lblGameSheep.setText("Sheep");
		lblGameCow.setText("Cow");
		lblGameChicken.setText("Chicken");
		lblGameDog.setText("Dog");
		lblGameHorse.setText("Horse");
		
		prgGameSheep.setVisible(false);
		prgGameCow.setVisible(false);
		prgGameChicken.setVisible(false);
		prgGameDog.setVisible(false);
		prgGameHorse.setVisible(false);
		
		lblTopName.setText(player.getName());
		lblTopLvl.setText(player.getLvlS());
		
		lblGameMoney.setText(player.getMoneyS());
		lblGameWood.setText(player.getWoodS());
		lblGameMetal.setText(player.getMetalS());
		lblGameHay.setText(player.getHayS());
		lblGameEgg.setText(player.getEggS());
		lblGameWool.setText(player.getWoolS());
		lblGameMilk.setText(player.getMilkS());
		
		imgGameMoney.setImage(imgMoney);
		imgGameWood.setImage(imgWood);
		imgGameMetal.setImage(imgMetal);
		imgGameHay.setImage(imgHay);
		imgGameEgg.setImage(imgEgg);
		imgGameWool.setImage(imgWool);
		imgGameMilk.setImage(imgMilk);
		
	}
	
	public void startGame() {
				
		
	}
	public void loadPanes(ActionEvent e) throws IOException {
		String id = ((Node) e.getSource()).getId();
		
		switch(id) {
			case "btnGameHome":
				if(paneHome.isVisible()) {
					paneHome.setVisible(false);
				}else paneHome.setVisible(true);
				break;
				
			case "btnGameOpt":
				if(paneOpt.isVisible()) {
					paneOpt.setVisible(false);
				}else paneOpt.setVisible(true);
				break;
				
			case "btnGameHelp": 
				if(paneHelp.isVisible()) {
					paneHelp.setVisible(false);
				}else paneHelp.setVisible(true);
				break;
		}
	} 

	public void collectEgg() {
		
		/*
		if (imgGameChickenProd.isVisible()) {
			int eggmultiplayer = player.getEggs() + 1 * player.getAmtChicken() * player.getLvlChicken();
			player.setEggs(eggmultiplayer);
			imgGameChickenProd.setVisible(false);
			EierUhr.start();
			lw.getItems().set(2, ("Eggs:\t" + player.getEggs()));
			player.setColEggs(player.getColEggs() + 1);

			if (player.getColEggs() >= 50) {
				player.setLvl(player.getLvl() + 1);
				player.setColEggs(0);
			}
		} */
	}

	public void collectWoll() {
		
		/*
		if (imgGameSheepProd.isVisible()) {
			int woolMultiplayer = player.getWool() + 1 * player.getAmtSheep() * player.getLvlSheep();
			player.setWool(woolMultiplayer);
			imgGameSheepProd.setVisible(false);

			lw.getItems().set(3, ("Wool:\t" + player.getWool()));
			sheepTimer.start();
			player.setColWool(player.getColWool() + 1);

			if (player.getColWool() >= 10) {
				player.setLvl(player.getLvl() + 1);
				player.setColWool(0);
			}
		} */
	}

	public void collectMilk() {
		/*
		if (imgGameCowProd.isVisible()) {
			int milkMultiplayer = player.getMilk() + 1 * player.getAmtCow() * player.getLvlCow();
			player.setMilk(milkMultiplayer);
			imgGameCowProd.setVisible(false);

			lw.getItems().set(5, ("Milk:\t\t" + player.getMilk()));
			cowTimer.start();
			player.setColMilk(player.getColMilk() + 1);

			if (player.getColMilk() >= 8) {
				player.setLvl(player.getLvl() + 1);
				player.setColMilk(0);
			}
			System.out.println(player.getMilk());
		} */
	}

	public void buildSheep() {
		/*
		if (player.getWood() >= 3) {
			//woodCow.setVisible(true);
			//metalCow.setVisible(true);
			//imgV2.setVisible(false);
			imgGameSheep.setVisible(true);
			//sheepR.setVisible(false);
			//woodSheep.setVisible(false);

			player.setWood(player.getWood() - 3);
			lw.getItems().set(0, ("Wood:\t" + player.getWood()));

			player.setAmtSheep(player.getAmtSheep() + 1);

			lw.getItems().add("Wool:\t" + player.getWool());
			lw.getItems().add("Metal:\t" + player.getMetal());

			sheepTimer.start();
		} */
	}

	public void buildCow() {
		/*
		if (player.getWood() >= 3 && player.getMetal() >= 3) {

//			woodCow.setVisible(false);
//			metalCow.setVisible(false);
//			imgV4.setVisible(false);
			imgGameCow.setVisible(true);
//			txtCow.setVisible(false);

			player.setWood(player.getWood() - 3);
			lw.getItems().set(0, ("Wood:\t" + player.getWood()));

			player.setMetal(player.getMetal() - 3);
			lw.getItems().set(4, ("Metal:\t" + player.getMetal()));

			player.setAmtCow(player.getAmtCow() + 1);

			lw.getItems().add("Milk:\t\t" + player.getMilk());

			cowTimer.start();
		} */
	}

	public void saleHandler() {
		
		/*
		String temp = item.substring(0, 4);

		switch (temp) {
		case "Eggs":
			if (player.getEggs() >= 1) {
				player.setEggs(player.getEggs() - 1);
				player.setMoney(player.getMoney() + 10);

				//lblGameMoney.setText(player.getMoney());
				lw.getItems().set(2, ("Eggs:\t" + player.getEggs()));
			}
			break;

		case "Hay:":
			if (player.getHay() >= 1) {
				player.setHay(player.getHay() - 1);
				player.setMoney(player.getMoney() + 5);

				//lblGameMoney.setText(player.getMoney() + "€");
				lw.getItems().set(1, ("Hay:\t\t" + player.getHay()));
			}
			break;
		case "Wood":
			if (player.getWood() >= 1) {
				player.setWood(player.getWood() - 1);
				player.setMoney(player.getMoney() + 50);

				//moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(0, ("Wood:\t" + player.getWood()));
			}
			break;
		case "Wool":
			if (player.getWool() >= 1) {
				player.setWool(player.getWool() - 1);
				player.setMoney(player.getMoney() + 75);

				//moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(3, ("Wool:\t" + player.getWool()));
			}
			break;
		}
		*/
	}

	public void buyHandler() {
		
		/*
		String temp = item.substring(0, 1);
		switch (temp) {
		case "E":
			if (player.getMoney() >= 15) {
				player.setEggs(player.getEggs() + 1);
				player.setMoney(player.getMoney() - 15);

				//moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(2, ("Eegs:\t" + player.getEggs()));
			}
			break;

		case "H":
			if (player.getMoney() >= 10) {
				player.setHay(player.getHay() + 1);
				player.setMoney(player.getMoney() - 10);

				//moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(1, ("Hay:\t\t" + player.getHay()));
			}
			break;
		case "W":
			if (player.getMoney() >= 100) {
				player.setWood(player.getWood() + 1);
				player.setMoney(player.getMoney() - 100);

				//moneyLabel.setText(player.getMoney() + "€");

				lw.getItems().set(0, ("Wood:\t" + player.getWood()));
			}
			break;
		case "Wool":
			if (player.getMoney() >= 150) {
				player.setWool(player.getWool() + 1);
				player.setMoney(player.getMoney() - 150);

				//moneyLabel.setText(player.getMoney() + "€");
				lw.getItems().set(3, ("Wool:\t" + player.getWool()));
			}
			break;
		} */
	}

	private String item;

	public void listHandler() {
		
		/*
		item = lw.getSelectionModel().getSelectedItem();
		if (item == null || item.isEmpty()) {
			return;
		} else {

			//btnSale.setDisable(false);
			//btnBuy.setDisable(false);

		}
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sheepTimer) {
			imgGameSheepProd.setVisible(true);
			sheepTimer.stop();
		} else if (e.getSource() == cowTimer) {
			imgGameCowProd.setVisible(true);
			EierUhr.stop();
		} else if (e.getSource() == EierUhr) {
			imgGameChickenProd.setVisible(true);
			cowTimer.stop();
		}
	}

}
