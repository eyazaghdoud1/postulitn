/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.ProjetFreelance;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.ProjetServices;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class ResponsableController implements Initializable {

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
    
     public static ProjetFreelance selectedProjetResp;
     private ProjetServices ps = new ProjetServices(); 
     List<ProjetFreelance> projets = ps.fetchProjet(); 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   /* @FXML
    private void GoToModifier(ActionEvent event) {
    }*/

    
   public void setData(ProjetFreelance p){
  
   Ltheme.setText(p.getTheme());  
   Ldescription.setText(p.getDescription());
   Lduree.setText(p.getDuree()+""); 
   Lsecteur.setText(p.getS().getDescription());
   Lnom.setText(p.getNom());
   
    }
    
    
    
    @FXML
    private void DeleteProjet(ActionEvent event) {
          /* Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression projet ");
                alert.setHeaderText("Etes-vous sures de vouloir supprimer ce projet ?");

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 //  "Yes"
                 ps.deleteProjetById(selectedProjetResp.getIdProjet());
                 try {
                  Parent root = FXMLLoader.load(getClass().getResource("./ListeProjetsFreelance.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
                } else {
                 // "No"
                 alert.close();
    }*/
    }

    @FXML
    private void GoToModifier(ActionEvent event) throws IOException {
        Parent Offreprojet = FXMLLoader.load(getClass().getResource("ModifierProjets.fxml"));
       Scene  OffreprojetScene = new Scene(Offreprojet);
       Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       appStage.setScene(OffreprojetScene); 
       appStage.show();
        
    }
    
}
