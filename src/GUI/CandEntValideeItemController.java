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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Candidature;
import models.Entretien;
import services.CandidatureService;
import services.EntretienService;
import utilities.EtatCandidature;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class CandEntValideeItemController implements Initializable {

    @FXML
    private Label candidatLabel;
    @FXML
    private Label offreLabel;
    @FXML
    private Label typeOffreLabel;
    @FXML
    private Button consulterBtn;
    
    EntretienService es = new EntretienService();
    CandidatureService cs = new CandidatureService();
    //int position = CandidaturesRecruteurController.indexValidee;
    public static List<Entretien> e;
    public static Candidature c;
    
    /**
     * Initializes the controller class.
     */
     public void setData(Candidature c) {
           candidatLabel.setText("Nom candidat");
           offreLabel.setText("Offre" + c.getIdOffre());
           typeOffreLabel.setText("Type");

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void entretienAction(ActionEvent event) {
        List<Candidature> dataV = cs.filterListeByEtat(cs.fetchCandidatures(), EtatCandidature.EtatsCandidature.Validée);
        e = es.filterByCandidature(dataV.get(CandidaturesRecruteurController.indexValidee).getId());
        c = dataV.get(CandidaturesRecruteurController.indexValidee);
        System.out.println("on click entretien: " + CandidaturesRecruteurController.indexValidee );
        //System.out.println("ind valide: " + CandidaturesRecruteurController.indexValidee); 
          try {
              
                  Parent root = FXMLLoader.load(getClass().getResource("./AjoutEntretien.fxml"));
                  
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
    }

    @FXML
    private void consulterCandidature(ActionEvent event) {
    }
    
}
