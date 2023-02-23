/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.ProjetFreelance;
import Models.Secteur;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class OffreprojetController implements Initializable {

    @FXML
    private VBox LayoutOffre;
    @FXML
    private Label LTheme;
    @FXML
    private Label LDescription;
    @FXML
    private Label LDuree;
    @FXML
    private Label LDateD;
    @FXML
    private Label LDateF;
    @FXML
    private Label LResponsable;
    @FXML
    private Button btnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
      public void setData(ProjetFreelance p){
  
   LTheme.setText(p.getTheme());  
   LDescription.setText(p.getDescription());
   LDuree.setText(p.getDuree()+"");
    
    }

    @FXML
    private void GoToListeProjet(ActionEvent event) throws IOException {
          Parent Offreprojet = FXMLLoader.load(getClass().getResource("ListeProjets.fxml"));
       Scene  OffreprojetScene = new Scene(Offreprojet);
       Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       appStage.setScene(OffreprojetScene); 
       appStage.show();
       
    }
    
}
