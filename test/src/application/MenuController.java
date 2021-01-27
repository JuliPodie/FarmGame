package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MenuController {
	
	public Pane paneMain, paneGame, paneNew, paneOpt;
	
	public Label lblMain, lblGame, lblGameName, lblNew, lblOpt;
	
	public Button btnMainPlay, btnMainOpt, btnGameContinue, btnGameNew, btnGameBack, btnNewStart, btnNewBack, btnOptBack;
	
	public TextField txtNewName;
	
	public void initialize() {
		
		paneOpt.setVisible(false);
		paneNew.setVisible(false);
		paneGame.setVisible(false);
		paneMain.setVisible(true);
		
	}
	
	public void loadMenu(ActionEvent eM) throws IOException {
		String idM = ((Node) eM.getSource()).getId();
		
		switch(idM) {
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
			case "btnGameContinue": 
				Main.main.openGame();
				break;
			case "btnGameNew": 
				if(GameController.player.newGame) {
					paneGame.setVisible(false);
					txtNewName.setText("");
					paneNew.setVisible(true);
				}else {
					//sure??
					GameController.player.reset();
					paneGame.setVisible(false);
					paneMain.setVisible(true);
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
			case "btnNewStart":
				if(txtNewName.getText().equals("")) {
					Main.error(3);
				} else {
					GameController.player.setName(txtNewName.getText());
					GameController.player.newGame = false;
					Main.main.openGame();
				}
				break;
		}
	}
}
