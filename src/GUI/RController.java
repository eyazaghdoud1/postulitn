/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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

/**
 * FXML Controller class
 *
 * @author Users
 */
public class RController implements Initializable {

    @FXML
    private Label Ltheme;
    @FXML
    private Label Ldescription;
    @FXML
    private Label Lduree;
    @FXML
    private Label LDatedebut;
    @FXML
    private Label LDateFin;
    @FXML
    private Label Lsecteur;
    @FXML
    private HBox Rhbox;

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
   LDatedebut.setText(p.getDateDebut()+"");
   LDateFin.setText(p.getDateFin()+"");
   Lsecteur.setText(p.getS().getDescription());
   
    }

    @FXML
    private void SupprimerProjet(ActionEvent event) {
    }

    @FXML
    private void GoToPageModifier(ActionEvent event) throws IOException {
        
      Parent Offreprojet = FXMLLoader.load(getClass().getResource("ModiferProjets.fxml"));
       Scene  OffreprojetScene = new Scene(Offreprojet);
       Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       appStage.setScene(OffreprojetScene); 
       appStage.show();
    }
    
}
