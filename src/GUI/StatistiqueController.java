/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import models.Typeoffre;
import services.OffreService;
import services.TypeoffreService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class StatistiqueController implements Initializable {

    @FXML
    private PieChart chartfor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        statsTypeOffre();
        // TODO  
    }    
    
    
     private void statsTypeOffre() {
         OffreService serv = new OffreService();
         TypeoffreService t = new TypeoffreService();
         List<Typeoffre> listTypes= t.getTypeDesc();
         ObservableList<PieChart.Data> PieChartData =FXCollections.observableArrayList( );
         for (Typeoffre type : listTypes) {
             PieChartData.add( new PieChart.Data(type.getDescription(), serv.typeByOffre(type.getId()) ));
         }

     chartfor.setData(PieChartData);
     
    }
    
}
