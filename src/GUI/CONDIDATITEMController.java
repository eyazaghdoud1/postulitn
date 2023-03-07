/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
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
        
          try {Parent Liste = FXMLLoader.load(getClass().getResource("../Gui/NewPostulerInterface.fxml"));
        
            Scene si = new Scene(Liste);
            si.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
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
