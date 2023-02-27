/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Compte;
import services.CompteServices;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class CompteController implements Initializable {
    @FXML
    private Label exppers;
    @FXML
    private Label diplomepers;
    @FXML
    private Label ddippers;
    @FXML
    private Label cvpers;
    @FXML
    private Label entrpers;
    
    public static Compte compteUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         CompteServices cs = new CompteServices();
         Compte c =cs.GetByIdCompte(7);
         compteUser= c; 

         exppers.setText(c.getExperience()); 
         diplomepers.setText(c.getDiplome());
         ddippers.setText("" + c.getDateDiplome());
         cvpers.setText(c.getCv());
         entrpers.setText(c.getEntreprise()); 
         
    }    
    

    @FXML
    private void bouutnmodifiercompte(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("modifiercompte.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
//    private void modifiercomptee(ActionEvent event) {
//    }


    
}
