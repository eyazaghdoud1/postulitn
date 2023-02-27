/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.CandidaturesController.candIndex;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Candidature;
import models.Entretien;
import services.EntretienService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class EntretiensRecruteurController implements Initializable {

    @FXML
    private VBox entretiensVB;
    
    private EntretienService es = new EntretienService();
    private SplitMenuButton filtresMB;
    private String selectedFiltre;
    public static Entretien selectedEnt;
    @FXML
    private ListView<HBox> listViewEnt;
    public static int entRecIndex;
    private HBox modifVB;
    @FXML
    private HBox modifHB;

    public static boolean modifOn;
    @FXML
    private DatePicker dateDP;
    @FXML
    private Spinner<?> hourSpinner;
    @FXML
    private Spinner<?> minuteSpinner;
    @FXML
    private TextField lieuTF;
    @FXML
    private Button enregistrerBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        modifOn = true;
         modifHB.setDisable(modifOn);
        // modifHB.setDisable(true);
       
       
        
        
        /* liste des entretiens */ 
        List<Entretien> data = es.fetchEntretiens();
        
        for (Entretien e : data) {
           //selectedEnt=e;
          if (e.getDate() != null) {
            try {
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./EntretienItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-border-color:white;");
                EntretienItemController eic = fxmlLoader.getController();
                System.out.println(e);
                eic.setData(e);
                //entretiensVB.getChildren().add(hbox);
                listViewEnt.getItems().add(hbox);
            } catch (IOException ex) {
               ex.printStackTrace();
            }}
            
            
          
        }
           
            
           
    }    

    @FXML
    private void handleMouseClick(MouseEvent event) {
         entRecIndex = listViewEnt.getSelectionModel().getSelectedIndex();
            System.out.println(entRecIndex);
    }

    @FXML
    private void modifierEnt(ActionEvent event) {
    }

    @FXML
    private void goToCandidatures(MouseEvent event) {
              try {
              
                  Parent root = FXMLLoader.load(getClass().getResource("./CandidaturesRecruteur.fxml"));
                  
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
    }


}
