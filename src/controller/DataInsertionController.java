package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DataInsertionController implements Initializable {
	 
		private MainController main;

	
		@FXML
	    private TextField txtUrl;

	    @FXML
	    void uploadFile(ActionEvent event) {
	    	
	        FileChooser fileChooser = new FileChooser();
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        File file = fileChooser.showOpenDialog(window);
            if (file != null) {
            }
	    }
	    
	    public void init(MainController m) {
			main = m;
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
}
