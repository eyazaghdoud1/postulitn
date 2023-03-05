/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.ProjetFreelance;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class ProjetItemController implements Initializable {

    @FXML
    private Label Lduree;
    @FXML
    private Label Lsecteur;
    @FXML
    private Label Ltheme;
    @FXML
    private Label Ldescription;
    @FXML
    private HBox phbox;
    @FXML
    private Label Lnom;
    @FXML
    private Rating tf_note;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
    
    
        public void setData(ProjetFreelance p){
  
   Ltheme.setText(p.getTheme());  
   Ldescription.setText(p.getDescription());
   Lduree.setText(p.getDuree()+""); 
   Lsecteur.setText(p.getS().getDescription());
    Lnom.setText(p.getNom());
    tf_note.setRating(p.getNote()); 

    }

    @FXML
    private void GoToOffer(ActionEvent event) throws IOException {
           
       Parent Offreprojet = FXMLLoader.load(getClass().getResource("Offreprojet.fxml"));
       Scene  OffreprojetScene = new Scene(Offreprojet);
       Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       appStage.setScene(OffreprojetScene); 
       appStage.show();
    }

    
        
        
}
