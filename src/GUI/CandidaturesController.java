/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.CandidaturesRecruteurController.index;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Candidature;
import services.CandidatureService;
import java.util.List;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class CandidaturesController implements Initializable {


    CandidatureService cs = new CandidatureService();
    @FXML
    private Label candidat;
    @FXML
    private VBox parentVB;
    
    static Candidature selectedCandidature ;
    @FXML
    private ListView<HBox> listViewCand;
    
    public static int candIndex;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      candidat.setText("Nom Candidat connecté");
      // listeCand.setItems(data);
       List<Candidature> data = cs.fetchCandidatures();
       
        for (Candidature cand : data) {
            
                 try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./CandidatureItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-border-color:white;");
                CandidatureItemController cic = fxmlLoader.getController();
                //System.out.println(e);
                cic.setData(cand);
                listViewCand.getItems().add(hbox);
                //selectedCandidature = cand;
                 } catch (IOException ex) {
               ex.printStackTrace();
            }
                
   
        }
    }    
    @FXML
    private void handleMouseClick(MouseEvent event) {
        
            candIndex = listViewCand.getSelectionModel().getSelectedIndex();
            System.out.println(candIndex);
       
    }

    
}
