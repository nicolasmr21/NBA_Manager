package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class AddPlayerController implements Initializable{

	
	private MainController main;


    @FXML
    private Circle c4;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtTeam;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMP;

    @FXML
    private TextField txtPPM;

    @FXML
    private TextField txtTRB;

    @FXML
    private TextField txtSTL;

    @FXML
    private TextField txtBLK;

    @FXML
    void addPlayer(ActionEvent event) {
    	if(!txtName.getText().equals("")&&!txtAge.getText().equals("")&&!txtTeam.getText().equals("")
    			&&!txtId.getText().equals("")&&!txtMP.getText().equals("")&&!txtPPM.getText().equals("")
    			&&!txtTRB.getText().equals("")&&!txtSTL.getText().equals("")&&!txtBLK.getText().equals("")) {
    		try {
    			
    			String name = txtName.getText();
    			String age = txtAge.getText();
    			String team = txtTeam.getText();
    			String id = txtId.getText();
    			int mp = Integer.parseInt(txtMP.getText());
    			double ppm = Double.parseDouble(txtPPM.getText());
    			double trb = Double.parseDouble(txtTRB.getText());
    			double stl = Double.parseDouble(txtSTL.getText());
    			double blk = Double.parseDouble(txtBLK.getText());
    			
    			main.getF().addPlayer(name, age, team, id, mp, ppm, trb, stl, blk);
    			
				
			} catch (Exception e) {
				Alert a = new Alert(AlertType.INFORMATION);
		        a.setContentText("Diligencie todos los datos correctamente");
		        a.setTitle("FIBA");
				a.show();
			}
    	}else {
    		Alert a = new Alert(AlertType.INFORMATION);
	        a.setContentText("Diligencie todos los datos");
	        a.setTitle("FIBA");
			a.show();
    	}

    }
    
    public void init(MainController m) {
		main = m;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setRotate(c4, true, 360, 10);
	}
	
	public void setRotate(Circle c, boolean reverse, int angle, int d) {
		
		RotateTransition r = new RotateTransition(Duration.seconds(d), c);
		
		r.setAutoReverse(reverse);
		r.setByAngle(angle);
		r.setDelay(Duration.seconds(0));
		r.setRate(5);
		r.setCycleCount(18);
		r.play();
		
	}

}
