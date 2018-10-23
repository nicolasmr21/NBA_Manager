package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class ManagePlayerController implements Initializable{
	
	MainController main;
	
	@FXML
	private AddPlayerController add;
	
    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;
    
    @FXML
    private Circle c4;

    
    @FXML
    private Button btnPlayer;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnRemove;
    
    @FXML
    private BorderPane borderPane;

    @FXML
    void ModifyPlayer(ActionEvent event) {

    }

    @FXML
    void RemovePlayer(ActionEvent event) {

    }

    @FXML
    void addPlayer(ActionEvent event) throws IOException {
		
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/application/AddPlayerView.fxml"));
        Parent p = loader.load();
        //access the controller and call a method
        add = loader.getController();
        add.init(main);
    	borderPane.setCenter(p);
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setRotate(c1, true, 360, 10);
		setRotate(c2, true, 180, 8);
		setRotate(c3, true, 145, 15);
		
		
//		btnModify.setFocusTraversable(false);
//		btnPlayer.setFocusTraversable(false);
//		btnRemove.setFocusTraversable(false);
		
	}
	
	public void init(MainController m) {
		main = m;
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
