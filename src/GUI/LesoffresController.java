/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Offre;
import services.OffreService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class LesoffresController implements Initializable {

    @FXML
    private VBox offresvb;
    @FXML
    private TextField txtsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        OffreService os = new OffreService();
       List<Offre> offres = os.fetchOffres();
        for(int i=0; i<offres.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../GUI/OFFREITEM.fxml"));
            
            try{
                HBox hBox = fxmlLoader.load();
                OFFREITEMController cic = fxmlLoader.getController();
                cic.setData(offres.get(i));
                offresvb.getChildren().add(hBox);
                 
            } catch (IOException ex)
            {
                Logger.getLogger(LesoffresController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void Delete(ActionEvent event) {
        int id_event = Integer.parseInt(txtsupprimer.getText());


OffreService os = new OffreService();

    os.deleteOffre(id_event);
    }
    
}
