package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import NBAUtil.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;


public class SearchStatisticController implements Initializable {
	
		private MainController main;
	
		private ObservableList<String> data;
	 
		@FXML
	    private TableView<String> tablePlayers;

	    @FXML
	    private TableColumn<String, String> colName;

	  
	    @FXML
	    private Button btnSearch;
	    
	    @FXML
	    private Spinner<Integer> spinnerVal;

	    @FXML
	    private ComboBox<String> comboStatistic;

	    @FXML
	    private ComboBox<String> comboInterval;

	    @FXML
	    void findPlayers(ActionEvent event) throws IndexOutOfBoundsException, IOException {
	    	
	    	data.removeAll(data);
	    	List indices = new List<String>();
	    	
	    	if(comboStatistic.getValue()!=null&&comboInterval.getValue()!=null){
	    		
	    		if(comboStatistic.getValue().equalsIgnoreCase("Partidos")) {
	    			
	    			if(comboInterval.getValue().equalsIgnoreCase("Iguales")) {
	    				indices = main.getF().searchMatchesAVL(spinnerVal.getValue());
	    			}else if(comboInterval.getValue().equalsIgnoreCase("Mayores")) {
	    				indices = main.getF().searchMoreMatchesAVL(spinnerVal.getValue());
	    			}else {
	    				indices = main.getF().searchLessMatchesAVL(spinnerVal.getValue());
	    			} 
	    			
	    		}else if(comboStatistic.getValue().equalsIgnoreCase("Puntos")) {
	    			
	    			if(comboInterval.getValue().equalsIgnoreCase("Iguales")) {
	    				indices = main.getF().searchPointsRBT(spinnerVal.getValue());
	    			}else if(comboInterval.getValue().equalsIgnoreCase("Mayores")) {
	    				indices = main.getF().searchMorePointsRBT(spinnerVal.getValue());
	    			}else {
	    				indices = main.getF().searchLessPointsRBT(spinnerVal.getValue());
	    			}	
	    		}
	    		else if(comboStatistic.getValue().equalsIgnoreCase("Rebotes")) {
	    			
	    			if(comboInterval.getValue().equalsIgnoreCase("Iguales")) {
	    				indices = main.getF().searchReboundsAVL(spinnerVal.getValue());
	    			}else if(comboInterval.getValue().equalsIgnoreCase("Mayores")) {
	    				indices = main.getF().searchMoreReboundsAVL(spinnerVal.getValue());
	    			}else {
	    				indices = main.getF().searchLessReboundsAVL(spinnerVal.getValue());
	    			}	
	    		}
	    		else {
	    			if(comboInterval.getValue().equalsIgnoreCase("Iguales")) {
	    				indices = main.getF().searchStealsRBT(spinnerVal.getValue());
	    			}else if(comboInterval.getValue().equalsIgnoreCase("Mayores")) {
	    				indices = main.getF().searchMoreStealsRBT(spinnerVal.getValue());
	    			}else {
	    				indices = main.getF().searchLessStealsRBT(spinnerVal.getValue());
	    			}
	    		}
	    		
	    		
	    		for (int i = 0; i < indices.size(); i++) {
					BufferedReader b = new BufferedReader(new FileReader(new File("archivo/"+indices.get(i)+".txt")));
					data.add(b.readLine());
					b.close();
				}
	    		
	    	}else {
	    		Alert a = new Alert(AlertType.INFORMATION);
		        a.setContentText("Elija restricciones coherentes");
		        a.setTitle("FIBA");
				a.show();
	    	}

	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> options1 = 
    		    FXCollections.observableArrayList(
    		        "Partidos",
    		        "Puntos",
    		        "Rebotes",
    		        "Robos"    		        
    		    );
    	comboStatistic.setItems(options1);
    	
    	ObservableList<String> options2 = 
    		    FXCollections.observableArrayList(
    		        "Mayores",
    		        "Menores",
    		        "Iguales"    		        
    		    );
    	comboInterval.setItems(options2);
    	
    	
    	data = FXCollections.observableArrayList(		  
				);
    	
    	
    	colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
    
  
			tablePlayers.setItems(data);
			
			SpinnerValueFactory<Integer> valueFactory = 
					new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
	 
	        spinnerVal.setValueFactory(valueFactory);
			
	}
	
	 public void init(MainController m) {
			main = m;
		}

}
