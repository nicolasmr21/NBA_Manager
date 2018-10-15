package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;

public class SearchPlayerController implements Initializable {
	
	private MainController main;
	
	@FXML
    private Circle c4;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtInfo;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter your name:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
//		    String player = main.getF().searchID(result.get());
//		    
//		    if(!player.equals("")) {
//		    txtID.setText(result.get());
//		    txtInfo.setText(player);
//		    }else {
//		    	
//		    	main.removeCenter();
//		    	
//		    	Alert a = new Alert(AlertType.INFORMATION);
//		        a.setContentText("No existe un jugador con tal id");
//		        a.setTitle("FIBA");
//				a.show();
////				
//				
//		    }
		    
		    
		}
		
		
	}
	
	 public void init(MainController m) {
			main = m;
		}

}
