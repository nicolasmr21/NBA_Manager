package controller;

import java.awt.Paint;
import java.io.IOException;
import java.net.URL;
import java.rmi.server.LoaderHandler;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.FIBA;

public class MainController implements Initializable {
	
		private FIBA f;
		
		@FXML
		private ManagePlayerController manage;
		
		@FXML
		private DataInsertionController insertion;
		
		@FXML
		private SearchPlayerController search;

		@FXML
		private SearchStatisticController statistic;

	
		@FXML
	    private Button btnInsertData;

	    @FXML
	    private Button btnAddPlayer;

	    @FXML
	    private Button btnSearchPlayer;

	    @FXML
	    private Button btnSearchStatistic;

	    @FXML
	    private Button btnBack;

	    @FXML
	    private Circle c1;

	    @FXML
	    private Circle c3;

	    @FXML
	    private Circle c2;
	   
	    @FXML
	    private BorderPane borderPane;
	   
	    
	    @FXML
	    void addPlayer(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/application/ManagePlayerView.fxml"));
	        Parent p = loader.load();
	        //access the controller and call a method
	        manage = loader.getController();
	        manage.init(this);
	    	borderPane.setCenter(p);
	    
	    }

	    @FXML
	    void goBack(ActionEvent event) {
	    	System.exit(0);
	    }

	    @FXML
	    void insertData(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/application/DataInsertionView.fxml"));
	        Parent p = loader.load();
	        //access the controller and call a method
	        insertion = loader.getController();
	        insertion.init(this);
	    	borderPane.setCenter(p);
	    }

	    @FXML
	    void searchPlayer(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/application/SearchPlayerView.fxml"));
	        Parent p = loader.load();
	        //access the controller and call a method
	        search = loader.getController();
	        search.init(this);
	    	borderPane.setCenter(p);
	    	
	    }

	    @FXML
	    void searchStatistic(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/application/SearchStatisticView.fxml"));
	        Parent p = loader.load();
	        //access the controller and call a method
	        statistic = loader.getController();
	        statistic.init(this);
	    	borderPane.setCenter(p);
	    	
	    }

	    @FXML
	    void pushImage(MouseEvent event) throws IOException {
//	    	FXMLLoader loader = new FXMLLoader();
//	        loader.setLocation(getClass().getResource("/application/MainView.fxml"));
//	        Parent p = loader.load();
//	        Scene scene = new Scene(p);
//	        //access the controller and call a method
//	        
//	        //This line gets the Stage information
//	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//	        
//	        window.setScene(scene);
//	        window.show();
	    	
	    	borderPane.setCenter(null);
	    }
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			setRotate(c1, true, 360, 10);
			setRotate(c2, true, 180, 8);
			setRotate(c3, true, 145, 15);
			
			btnAddPlayer.setFocusTraversable(false);
			btnBack.setFocusTraversable(false);
			btnInsertData.setFocusTraversable(false);
			btnSearchPlayer.setFocusTraversable(false);
			btnSearchStatistic.setFocusTraversable(false);
			
			f = new FIBA();
			
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

		public FIBA getF() {
			return f;
		}
		
		public void removeCenter() {
			borderPane.setCenter(null);
		}
		

}
