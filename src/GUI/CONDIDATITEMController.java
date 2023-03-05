/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.Offre;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class CONDIDATITEMController implements Initializable {

    @FXML
    private Label poste;
    @FXML
    private Label description;
    @FXML
    private Label idtype;
    @FXML
    private Label dateE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void postuler(ActionEvent event) {
    }
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
    
}
