/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.ListeProjetsFreelanceController.selectedProjet;
import Models.ProjetFreelance;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ProjetServices;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class ListeProjetsResponsableController implements Initializable {
    
    public static ProjetFreelance selectedProjetResp;
    ProjetServices ps = new ProjetServices();
    List<ProjetFreelance> projets = ps.filterByIdResponsable(0);
    @FXML
    private Label userConnecte;
    @FXML
    private VBox offresVB;
    @FXML
    private VBox candidaturesVB;
    @FXML
    private VBox entretiensVB;
    @FXML
    private VBox guidesVB;
    @FXML
    private VBox quizVB;
    @FXML
    private ListView<HBox> ProjetsResponsableListView;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       // les projets doivent apparternir a un seul responsable => fitrés par id responsable
        
              
                      
    List<ProjetFreelance> projets = ps.filterByIdResponsable(0);
       for (ProjetFreelance pf : projets) {
       
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("./Responsable.fxml"));
           try {
               HBox hb = loader.load();
               ResponsableController rc = loader.getController();
               rc.setData(pf);
               ProjetsResponsableListView.getItems().add(hb);
           } catch (IOException ex) {
               Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        /*  
         List<ProjetFreelance> projets = ps.fetchProjet();
       for (ProjetFreelance pf : projets) {
       
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("./p.fxml"));
           try {
               HBox hb = loader.load();
               PController pc = loader.getController();
               pc.setData(pf);
             
               ProjetsFreelanceListView.getItems().add(hb);
           } catch (IOException ex) {
               Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
           }*/
       }
       @FXML
    private void goToCompte(MouseEvent event) {
    }

    @FXML
    private void goToOffres(MouseEvent event) {
    }

    @FXML
    private void goToCandidatures(MouseEvent event) {
    }

    @FXML
    private void goToEntretiens(MouseEvent event) {
    }

    @FXML
    private void goToGuides(MouseEvent event) {
    }

    @FXML
    private void handleSecteur(MouseEvent event) {
        selectedProjetResp = projets.get( ProjetsResponsableListView.getSelectionModel().getSelectedIndex());
        try {
   
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("OffreprojetResponsable.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
    }
    }

 
      

/* List<ProjetFreelance> lp=  ps.fetchProjet();
         for (int i=0; i<lp.size(); i++){
             
             FXMLLoader fxmlloader = new FXMLLoader();
             fxmlloader.setLocation(getClass().getResource("../Gui/R.fxml"));
          try { 
              VBox vbox = fxmlloader.load();
              PController pc = fxmlloader.getController();
              pc.setData(lp.get(i));
              ListeProjetsResponsableVB.getChildren().add(vbox); 
          } catch (IOException ex) {
              Logger.getLogger(ListeProjetsController.class.getName()).log(Level.SEVERE, null, ex);
          }  
             
         }*/
    
 
