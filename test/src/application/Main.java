package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application {
	
	static Stage window;
	static Scene sceneMenu, sceneGame;
	static Parent rootMenu;
	static Parent rootGame;
	
	static MenuController comMenu;
	static GameController comGame;
	
	static Main main = new Main();
	
	public static void main(String[] args) {
		GameController.player = new User();
		comMenu = new MenuController();
		comGame = new GameController();
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		window = stage;
		openMenu();
		window.show();
		window.setResizable(false);
	}
	
	public void openMenu() {
		GameController.player.loadFile();
		try {
			rootMenu = FXMLLoader.load(getClass().getResource("menu.fxml"));
			sceneMenu = new Scene(rootMenu,800,500);
			sceneMenu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			rootMenu.requestFocus();
		} catch (IOException e1) {
			e1.printStackTrace();
			error(1);
		}
		window.setScene(sceneMenu);
		window.setTitle("Menu");
		rootMenu.requestFocus();
	}
	
	public void openGame() {
		try {
			rootGame = FXMLLoader.load(getClass().getResource("game.fxml"));
			sceneGame = new Scene(rootGame,1200,800);
			sceneGame.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch (IOException e1) {
			e1.printStackTrace();
			error(2);
		}
		window.setScene(sceneGame);
		window.setTitle("Game");
		//window.set
		rootGame.requestFocus();
	}
	
	static void error(int reason)	{		//handles all error windows
	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		
		switch(reason) {
			case 1:
				alert.setTitle("Error 1");
				alert.setContentText("Error loading Menu!");
				break;
			case 2:
				alert.setTitle("Error 2");
				alert.setContentText("Error loading Game!");
				break;
			case 3:
				alert.setTitle("Error Name");
				alert.setContentText("Please enter a Name!");
				break;
			case 4:
				alert.setTitle("Error Materials");
				alert.setContentText("Not enough Materials!");
				break;
			case 5:
				alert.setTitle("Error Money");
				alert.setContentText("Not enough Money!");
				break;
			default:
				alert.setTitle("Error");
				alert.setContentText("Unknown error occured!");
				break;
		}
		alert.showAndWait();
	}
}