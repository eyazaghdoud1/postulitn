/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
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
import models.Typeoffre;
import services.OffreService;
import services.TypeoffreService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class TYPEITEMController implements Initializable {

    @FXML
    private Label description;

    /**
     * Initializes the controller class.
     * 
     * 
     * 
     */
    TypeoffreService tos = new TypeoffreService();
    List<Typeoffre> to = tos.fetchOffres();

     //Typeoffre t = to.get(NewoffresController.selectedoffre);
    /**
     * Initializes the controller class.
     */
    
     public void setData (Typeoffre t){
           
            description.setText(t.getDescription());
            
        

       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void delete(ActionEvent event) {
        OffreService ps = new OffreService();
        TypeoffreService ts = new TypeoffreService();
        
         ts.deletetypeoffre(to.get(NewtypesController.selectedtype).getId());
             
       try {Parent Login = FXMLLoader.load(getClass().getResource("./newtypes.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
                         Logger.getLogger(OFFREITEMController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}}
