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
import javafx.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

public class GameController implements ActionListener{
	
	Timer EierUhr = new Timer(1000, this);
	Timer sheepTimer = new Timer(5000, this);
	Timer cowTimer = new Timer(7500, this);;
	
	Boolean newGame = true;
	Boolean paneWinOpen = false;

	ObservableList<String> list = FXCollections.observableArrayList();

	static User player;
	
	public Pane paneMain, paneWin, paneTop, paneHome, paneOpt, paneHelp, paneSheep, paneCow, paneChicken, paneDog, paneHorse, paneWinOpt, paneWinExit, paneWinShop, paneWinUp, paneWinHelp;
	
	public Label lblTopName, lblTopLvl, lblGameSheep, lblGameCow, lblGameChicken, lblGameDog, lblGameHorse, lblGameMoney, lblGameWood, lblGameMetal, lblGameHay, lblGameEgg, lblGameWool, lblGameMilk, 
					lblUpLvlSheep, lblUpLvlCow, lblUpLvlChicken, lblUpLvlDog, lblUpLvlHorse;
	
	public Button btnGameHome, btnGameEsc, btnGameHelp, btnEscOpt, btnEscSave, btnEscExit, btnHomeShop, btnHomeUp, btnUpSheep, btnUpCow, btnUpChicken, btnUpDog, btnUpHorse, 
					btnShopBuyWood, btnShopBuyMetal, btnShopBuyHay, btnShopSellWood, btnShopSellMetal, btnShopSellHay;
	
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
		
		paneWinOpen = false;
		
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
		
		imgGameMoney.setImage(imgMoney);
		imgGameWood.setImage(imgWood);
		imgGameMetal.setImage(imgMetal);
		imgGameHay.setImage(imgHay);
		imgGameEgg.setImage(imgEgg);
		imgGameWool.setImage(imgWool);
		imgGameMilk.setImage(imgMilk);
		
		//--------------------------

		update();
		
		//--------------------------
		
		btnGameHome.setDisable(false);
		btnGameEsc.setDisable(false);
		btnGameHelp.setDisable(false);
		
		
	}
	
	public void startGame() {
				
		
	}
	
	public void loadPaneGame(ActionEvent aG) throws IOException {
		String idG = ((Node) aG.getSource()).getId();
		
		switch(idG) {
			case "btnGameHome":
				if(paneHome.isVisible()) {
					paneHome.setVisible(false);
				}else {
					paneHome.setVisible(true);
				}
				if(paneWinShop.isVisible()) {
					paneWinShop.setVisible(false);
				}
				else if(paneWinUp.isVisible()) {
					paneWinUp.setVisible(false);
				}
				break;
				
			case "btnGameEsc":
				if(paneOpt.isVisible()) {
					paneOpt.setVisible(false);
				}else {
					paneOpt.setVisible(true);
				}
				if(paneWinOpt.isVisible()) {
					paneWinOpt.setVisible(false);
				}
				break;
		}
	}
	
	public void loadPaneWin(ActionEvent aW) throws IOException {
		String idW = ((Node) aW.getSource()).getId();
		
		if(paneWinOpt.isVisible() && !idW.equals("btnEscOpt")) {
			paneWinOpt.setVisible(false);
		}
		else if(paneWinShop.isVisible() && !idW.equals("btnHomeShop")) {
			paneWinShop.setVisible(false);
		}
		else if(paneWinUp.isVisible() && !idW.equals("btnHomeUp")) {
			paneWinUp.setVisible(false);
		}
		else if(paneWinHelp.isVisible() && !idW.equals("btnGameHelp")) {
			paneWinHelp.setVisible(false);
		}
		
		switch(idW) {
		
		case "btnEscOpt":
			if(paneWinOpt.isVisible()) {
				paneWinOpt.setVisible(false);
			}else {
				paneWinOpt.setVisible(true);
			}
			break;
			
		case "btnEscSave":
			player.saveFile();
			break;
			
		case "btnEscExit":
			player.saveFile();
			Main.main.openMenu();
			break;
			
		case "btnHomeShop":
			if(paneWinShop.isVisible()) {
				paneWinShop.setVisible(false);
			}else {
				paneWinShop.setVisible(true);
			}
			break;
		
		case "btnHomeUp":
			if(paneWinUp.isVisible()) {
				paneWinUp.setVisible(false);
			}else {
				paneWinUp.setVisible(true);
			}
			break;

		case "btnGameHelp":
			if(paneWinHelp.isVisible()) {
				paneWinHelp.setVisible(false);
			}else {
				paneWinHelp.setVisible(true);
			}
			break;
		} 
	}
	
	public void upgradePet(ActionEvent aU) throws IOException {
		String idU = ((Node) aU.getSource()).getId();
		
		switch(idU) {
			case "btnUpSheep":
				if(player.getWood() >= 3 && player.getMetal() >=1 && player.getHay() >= 2) {
					player.setWood(player.getWood()-3);
					player.setHay(player.getHay()-2);
					player.setLvlSheep(player.getLvlSheep()+1);
				}else {
					Main.error(4);
				}
				break;
				
			case "btnUpCow":
				if(player.getWood() >= 2 && player.getMetal() >=3 && player.getHay() >= 4) {
					player.setWood(player.getWood()-2);
					player.setMetal(player.getMetal()-3);
					player.setHay(player.getHay()-4);
					player.setLvlCow(player.getLvlCow()+1);
				}else {
					Main.error(4);
				}
				break;
				
			case "btnUpChicken":
				if(player.getWood() >= 2 && player.getHay() >= 1) {
					player.setWood(player.getWood()-2);
					player.setHay(player.getHay()-1);
					player.setLvlChicken(player.getLvlChicken()+1);
				}else {
					Main.error(4);
				}
				break;
				
			case "btnUpDog":
				if(player.getWood() >= 3 && player.getMetal() >=5) {
					player.setWood(player.getWood()-3);
					player.setMetal(player.getMetal()-5);
					player.setLvlDog(player.getLvlDog()+1);
				}else {
					Main.error(4);
				}
				break;
				
			case "btnUpHorse":
				if(player.getWood() >= 5 && player.getMetal() >=3 && player.getHay() >= 8) {
					player.setWood(player.getWood()-5);
					player.setMetal(player.getMetal()-3);
					player.setHay(player.getHay()-8);
					player.setLvlHorse(player.getLvlHorse()+1);
				}else {
					Main.error(4);
				}
				break;
		}
		
		update();
	}
	
	public void shop(ActionEvent aS) throws IOException {
		String idS = ((Node) aS.getSource()).getId();
		
		switch(idS) {
			case "btnShopBuyWood":
				if(player.getMoney() >= 10) {
					player.setMoney(player.getMoney()-10);
					player.setWood(player.getWood()+1);
				}else {
					Main.error(5);
				}
				break;
			case "btnShopBuyMetal":
				if(player.getMoney() >= 25) {
					player.setMoney(player.getMoney()-25);
					player.setMetal(player.getMetal()+1);
				}else {
					Main.error(5);
				}
				break;
			case "btnShopBuyHay":
				if(player.getMoney() >= 20) {
					player.setMoney(player.getMoney()-20);
					player.setHay(player.getHay()+1);
				}else {
					Main.error(5);
				}
				break;
				
			case "btnShopSellWood":
				if(player.getWood() >= 1) {
					player.setWood(player.getWood()-1);
					player.setMoney(player.getMoney()+7);
				}else {
					Main.error(4);
				}
				break;
			case "btnShopSellMetal":
				if(player.getMoney() >= 1) {
					player.setMetal(player.getMetal()-1);
					player.setMoney(player.getMoney()+18);
				}else {
					Main.error(4);
				}
				break;
			case "btnShopSellHay":
				if(player.getMoney() >= 1) {
					player.setHay(player.getHay()-1);
					player.setMoney(player.getMoney()+14);
				}else {
					Main.error(4);
				}
				break;
		}
		update();
	}
	
	public void update() {
		
		lblTopLvl.setText(player.getLvlS());
		
		prgTopLvl.setProgress(player.getLvlXpD());
		
		lblGameMoney.setText(player.getMoneyS());
		lblGameWood.setText(player.getWoodS());
		lblGameMetal.setText(player.getMetalS());
		lblGameHay.setText(player.getHayS());
		lblGameEgg.setText(player.getEggS());
		lblGameWool.setText(player.getWoolS());
		lblGameMilk.setText(player.getMilkS());
		
		lblUpLvlSheep.setText(player.getLvlSheepS());
		lblUpLvlCow.setText(player.getLvlCowS());
		lblUpLvlChicken.setText(player.getLvlChickenS());
		lblUpLvlDog.setText(player.getLvlDogS());
		lblUpLvlHorse.setText(player.getLvlHorseS());
		
		if(player.getLvlSheep() == 1) {
			imgGameSheep.setImage(imgSheep);
			prgGameSheep.setVisible(true);
		}
		if(player.getLvlCow() == 1) {
			imgGameCow.setImage(imgCow);
			prgGameCow.setVisible(true);
		}
		if(player.getLvlChicken() == 1) {
			imgGameChicken.setImage(imgChicken);
			prgGameChicken.setVisible(true);
		}
		if(player.getLvlDog() == 1) {
			//imgGameDog.setImage(imgDog);
		}
		if(player.getLvlHorse() == 1) {
			//imgGameHorse.setImage(imgHorse);
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

	//private String item;

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
	public void actionPerformed(java.awt.event.ActionEvent e) {
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
