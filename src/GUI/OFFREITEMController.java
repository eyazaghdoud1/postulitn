/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Offre;
import services.OffreService;
import services.TypeoffreService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class OFFREITEMController implements Initializable {

    @FXML
    private Label poste;
    @FXML
    private Label description;
    private Label lieu;
    private Label entreprise;
    private Label specialite;
    @FXML
    private Label dateE;
    private Label idR;
    @FXML
    private Label idtype;
TypeoffreService tos = new TypeoffreService();
      OffreService os = new OffreService();
    List<Offre> lo = os.fetchOffres();


    /**
     * Initializes the controller class.
     */
    
     public void setData (Offre o){
        
         
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateExpirationString = dateFormat.format(o.getDateExpiration());
        
            poste.setText(o.getPoste());
            description.setText(o.getDescription());
            //lieu.setText(o.getLieu());
            //entreprise.setText(o.getEntreprise());
           // specialite.setText(o.getSpecialite());
            dateE.setText(dateExpirationString);
            //idR.setText(Integer.toString(o.getIdRecruteur()));
            idtype.setText(o.getType().getDescription());
        

       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}