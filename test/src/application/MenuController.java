package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MenuController {
	
	private Parent root;
	private Stage stage;
	private Scene scene;
	
		
	public Pane paneMain;
	public Pane paneGame;
	public Pane paneNew;
	public Pane paneOpt;
	
	public Label lblMain;
	public Button btnMainPlay;
	public Button btnMainOpt;
	
	public Label lblGame;
	public Label lblGameName;
	public Button btnGameContinue;
	public Button btnGameNew;
	public Button btnGameBack;
	
	public Label lblNew;
	public TextField txtNewName;
	public Button btnNewContinue;
	public Button btnNewBack;
	
	public Label lblOpt;
	public Button btnOptBack;
	
	public void initialize() {
		
		paneOpt.setVisible(false);
		paneNew.setVisible(false);
		paneGame.setVisible(false);
		paneMain.setVisible(true);
		
	}
	
	public void loadMenu(ActionEvent e) throws IOException {
		String id = ((Node) e.getSource()).getId();
		
		switch(id) {
			case "btnMainPlay": 
				if(GameController.player.newGame) {
					btnGameContinue.setDisable(true);
					lblGameName.setText("");
					btnGameNew.setText("NEW GAME");
				} else {
					btnGameContinue.setDisable(false);
					lblGameName.setText(GameController.player.getName());
					btnGameNew.setText("DELETE GAME");
				}
				paneMain.setVisible(false);
				paneGame.setVisible(true);
				break;
			case "btnMainOpt": 
				paneMain.setVisible(false);
				paneOpt.setVisible(true);
				break;
			case "btnGameBack": 
				paneGame.setVisible(false);
				paneMain.setVisible(true);
				break;
			case "btnGameNew": 
				if(GameController.player.newGame) {
					paneGame.setVisible(false);
					txtNewName.setText("");
					paneNew.setVisible(true);
				}else {
					
				}
				break;
			case "btnNewBack": 
				paneNew.setVisible(false);
				paneGame.setVisible(true);
				break;
			case "btnOptBack": 
				paneOpt.setVisible(false);
				paneMain.setVisible(true);
				break;
			case "btnNewContinue":
				GameController.player.setName(txtNewName.getText());
		        root = FXMLLoader.load(getClass().getResource("game.fxml"));
		        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		        scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
				break;
		}
	}


}
