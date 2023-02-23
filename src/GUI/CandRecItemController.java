/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.text.View;
import models.Candidature;
import services.CandidatureService;
import utilities.EtatCandidature;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class CandRecItemController implements Initializable {

    @FXML
    private Label candidatLabel;
    @FXML
    private Label offreLabel;
    @FXML
    private Label typeOffreLabel;
    @FXML
    private Button validerBtn;
    @FXML
    private Button consulterBtn;
    

    private CandidatureService cs= new CandidatureService(); 
    /**
     * Initializes the controller class.
     * @param c
     */
    
         public void setData(Candidature c) {
           candidatLabel.setText("Nom candidat ");
           offreLabel.setText("Offre" + c.getIdOffre());
           typeOffreLabel.setText("Type");  

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
/*validerBtn.setOnAction((ActionEvent event) -> {
    Node hbox = (Node) event.getSource();
    //Node hb = hbox.getParent();
    Node listItem = hbox.getParent();
    
    ListView<?> listView = (ListView<?>) listItem.getScene().lookup("#listViewId");*/
/*CandidaturesRecruteurController crc = new CandidaturesRecruteurController();
   int position = crc.getListView().getSelectionModel().getSelectedIndex();
    System.out.println(position);*/
    // do something with the position
//});
    }    
    


    @FXML
    private void valider(ActionEvent event) {
        //System.out.println("test id:" +CandidaturesRecruteurController.recCand.getId());
         List<Candidature> l = cs.fetchCandidatures();
         List<Candidature> data = cs.filterListeByEtat(l, EtatCandidature.EtatsCandidature.Enregistrée);
       
        
      
        //CandidaturesRecruteurController crc = new CandidaturesRecruteurController();
       // int position = CandidaturesRecruteurController.index;
        System.out.println("test" +CandidaturesRecruteurController.index);
         cs.valider(data.get(CandidaturesRecruteurController.index).getId(), true);
          System.out.println(data.get(CandidaturesRecruteurController.index));
        
          
          try {
                  Parent root = FXMLLoader.load(getClass().getResource("./CandidaturesRecruteur.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
                  // System.out.println(position);
                  //System.out.println(data.get(position));
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
        
    }
    

    @FXML
    private void consulter(ActionEvent event) {
    }
    
    @FXML
    private void valider2(ActionEvent event) {
       /* cs.valider(CandidaturesRecruteurController.recCand.getId(), true);
          try {
                  Parent root = FXMLLoader.load(getClass().getResource("./CandidaturesRecruteur.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
                  System.out.println(CandidaturesRecruteurController.recCand);
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }*/
       
        List<Candidature> data = cs.fetchCandidatures();
        CandidaturesRecruteurController crc = new CandidaturesRecruteurController();
        int position = crc.index;
        System.out.println(position);
        cs.valider(data.get(position).getId(), true);
          try {
                  Parent root = FXMLLoader.load(getClass().getResource("./CandidaturesRecruteur.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
                  System.out.println(CandidaturesRecruteurController.recCand);
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
    }
    
    
    


    
    
}
