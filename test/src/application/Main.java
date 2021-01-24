package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
			Scene scene = new Scene(root,640,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Anminal Crossing in schlecht");
			primaryStage.setScene(scene);
			primaryStage.show();
			root.requestFocus();
			primaryStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void startMenu(Stage menuStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
			Scene scene = new Scene(root,640,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			menuStage.setTitle("Anminal Crossing in schlecht");
			menuStage.setScene(scene);
			menuStage.show();
			root.requestFocus();
			menuStage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		EventController e = new EventController();
		e.start();
		launch(args);

	}

	
}
