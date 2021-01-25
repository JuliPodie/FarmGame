package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class Main extends Application {
	

	public static void main(String[] args) {
		GameController.player = new User();
		MenuController conMenu = new MenuController();
		GameController conGame = new GameController();
		//e.start();
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		try {
			startMenu(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startMenu(Stage menuStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(root,800,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			menuStage.setTitle("BRUH");
			menuStage.setScene(scene);
			menuStage.show();
			root.requestFocus();
			menuStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
			error(1);
		}
	}
	
	/*public void startGame(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
			Scene scene = new Scene(root,640,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Anminal Crossing in schlecht");
			primaryStage.setScene(scene);
			primaryStage.show();
			root.requestFocus();
			primaryStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
			error(2);
		}
	}*/
	
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
				alert.setTitle("Error 3");
				alert.setContentText("!");
				break;
			default:
				alert.setTitle("Error");
				alert.setContentText("Unknown error occured!");
				break;
		}
		alert.showAndWait();
	}
}