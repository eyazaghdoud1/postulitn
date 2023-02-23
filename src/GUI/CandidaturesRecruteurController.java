/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.CandidaturesController.selectedCandidature;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Candidature;
import models.Entretien;
import services.CandidatureService;
import services.EntretienService;
import utilities.EtatCandidature;
import utilities.TypeEntretien;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class CandidaturesRecruteurController implements Initializable {

    private Spinner<Integer> hourSpinner;
    private Spinner<Integer> minuteSpinner;
    private ComboBox<String> typeEntretienCB;
    private TextField lieuTF;
    
    private Date sqlDate;
    private String selectedType;
    private CandidatureService cs = new CandidatureService();
    private EntretienService es = new EntretienService();
    @FXML
    private VBox allCandidaturesVB;
    @FXML
    private VBox candValideesVB;
    private Label candId;
    public static int index;
    public static int indexValidee;
   
    

    public static Candidature recCandvalidee;
    public static Candidature recCand;
    @FXML
    private ListView<HBox> listView;
    @FXML
    private ListView<HBox> listViewValidees;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        /* les listes des candidatures */
        
        List<Candidature> data = cs.fetchCandidatures();
        List<Candidature> dataV = cs.filterListeByEtat(data, EtatCandidature.EtatsCandidature.Validée);
        for (Candidature candV : dataV) {
               // recCandvalidee = candV;
            
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./CandEntValideeItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-border-color:white;");
                CandEntValideeItemController cic = fxmlLoader.getController();
                //System.out.println(e);
                cic.setData(candV);
                listViewValidees.getItems().add(hbox);
                
                
                
                 } catch (IOException ex) {
               ex.printStackTrace();
            }
             
                    
        }
        List<Candidature> dataE = cs.filterListeByEtat(data, EtatCandidature.EtatsCandidature.Enregistrée);
        for (Candidature cand : dataE) {
            
             
             // recCand = cand;
            
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./CandRecItem.fxml"));
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-border-color:white;");
                CandRecItemController cic = fxmlLoader.getController();
                //System.out.println(e);
                cic.setData(cand);
                
               // allCandidaturesVB.getChildren().add(hbox); 
                listView.getItems().add(hbox);
                
                
                 } catch (IOException ex) {
               ex.printStackTrace();
            }
            
          
        }    
          
        
    }    

  


    @FXML
    private void handleMouseClick(MouseEvent event) {
        
            index = listView.getSelectionModel().getSelectedIndex();
            System.out.println(index);
       
    }

 

    @FXML
    private void handleListViewValidees(MouseEvent event) {
        indexValidee = listViewValidees.getSelectionModel().getSelectedIndex();
            System.out.println(indexValidee);
    }
         
    
        
    


    
    
}
