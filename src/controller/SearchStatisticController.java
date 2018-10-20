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
	    		double a= 0;
	    		double b= 0;
	    		double c = 0;
	    		
	    		if(comboStatistic.getValue().equalsIgnoreCase("Partidos")) {
	    			
	    			if(comboInterval.getValue().equalsIgnoreCase("Iguales")) {
	    				a=System.currentTimeMillis();
	    				main.getF().searchMatchesBBS(spinnerVal.getValue());
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchMatchesAVL(spinnerVal.getValue());
	    				c=System.currentTimeMillis();
	    			}else if(comboInterval.getValue().equalsIgnoreCase("Mayores")) {
	    				a=System.currentTimeMillis();
	    				main.getF().searchMoreMatchesBBS(spinnerVal.getValue());
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchMoreMatchesAVL(spinnerVal.getValue());
	    				c=System.currentTimeMillis();
	    			}
	    			else {
	    				a=System.currentTimeMillis();
	    				main.getF().searchLessMatchesBBS(spinnerVal.getValue());
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchLessMatchesAVL(spinnerVal.getValue());
	    				c=System.currentTimeMillis();
	    			} 
	    			
	    			Alert i = new Alert(AlertType.INFORMATION);
			        i.setContentText("Tiempo de busqueda con arbol AVL = " +c +" Con Binario de busqueda = "+b);
			        i.setTitle("FIBA");
					i.show();
	    			
	    		}else if(comboStatistic.getValue().equalsIgnoreCase("Puntos")) {
	    			
	    			if(comboInterval.getValue().equalsIgnoreCase("Iguales")) {
	    				a=System.currentTimeMillis();
	    				main.getF().searchPointsBST(spinnerVal.getValue());
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchPointsRBT(spinnerVal.getValue());
	    				c=System.currentTimeMillis();	    			}
	    			else if(comboInterval.getValue().equalsIgnoreCase("Mayores")) {
	    				a=System.currentTimeMillis();
	    				main.getF().searchMorePointsBST(spinnerVal.getValue());
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchMorePointsRBT(spinnerVal.getValue());
	    				c=System.currentTimeMillis();	
	    			}else {
	    				a=System.currentTimeMillis();
	    				main.getF().searchLessPointsBST(spinnerVal.getValue());
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchLessPointsRBT(spinnerVal.getValue());
	    				c=System.currentTimeMillis();	
	    			}	
	    			
	    			Alert i = new Alert(AlertType.INFORMATION);
			        i.setContentText("Tiempo de busqueda con arbol RBT = " +c +" Con Binario de busqueda = "+b);
			        i.setTitle("FIBA");
					i.show();
	    		}
	    		else if(comboStatistic.getValue().equalsIgnoreCase("Rebotes")) {
	    			
	    			if(comboInterval.getValue().equalsIgnoreCase("Iguales")) {
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchReboundsAVL(spinnerVal.getValue());
	    				c=System.currentTimeMillis();
	    				}
	    			else if(comboInterval.getValue().equalsIgnoreCase("Mayores")) {
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchMoreReboundsAVL(spinnerVal.getValue());
	    				c=System.currentTimeMillis();
	    				}else {
	    					b=System.currentTimeMillis()-a;
		    				indices = main.getF().searchLessReboundsAVL(spinnerVal.getValue());
		    				c=System.currentTimeMillis();
	    			}
	    			
	    			Alert i = new Alert(AlertType.INFORMATION);
			        i.setContentText("Tiempo de busqueda con arbol AVL " +c);
			        i.setTitle("FIBA");
					i.show();
	    		}
	    		else {
	    			if(comboInterval.getValue().equalsIgnoreCase("Iguales")) {
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchStealsRBT(spinnerVal.getValue());
	    				c=System.currentTimeMillis();
	    			}else if(comboInterval.getValue().equalsIgnoreCase("Mayores")) {
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchMoreStealsRBT(spinnerVal.getValue());
	    				c=System.currentTimeMillis();
	    			}else {
	    				b=System.currentTimeMillis()-a;
	    				indices = main.getF().searchLessStealsRBT(spinnerVal.getValue());
	    				c=System.currentTimeMillis();
	    			}
	    			
	    			Alert i = new Alert(AlertType.INFORMATION);
			        i.setContentText("Tiempo de busqueda con arbol RBT" +c);
			        i.setTitle("FIBA");
					i.show();
	    		}
	    		
	    		
	    		for (int i = 0; i < indices.size(); i++) {
					BufferedReader b1 = new BufferedReader(new FileReader(new File("archivo/"+indices.get(i)+".txt")));
					data.add(b1.readLine());
					b1.close();
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
