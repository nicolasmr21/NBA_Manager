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
import javafx.scene.control.Labeled;
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
		
		    
		}
		
		
	
	
	 public void init(MainController m) {
			main = m;
		}




	public TextField getTxtID() {
		return txtID;
	}




	public TextField getTxtInfo() {
		return txtInfo;
	}




	
	 
	 

}
