/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.AjouterSecteursController.selectedSecteur;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ProjetServices; 
import services.SecteurServices;


/**
 * FXML Controller class
 *
 * @author Users
 */
public class ListeProjetsFreelanceController implements Initializable {
    
    ProjetServices ps = new ProjetServices(); 
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
    private ListView<HBox> ProjetsFreelanceListView;
    public static ProjetFreelance selectedProjet;
   public static List<ProjetFreelance> projets;
   public static Secteur selectedSecteur;
   SecteurServices ss = new SecteurServices();
   
    @FXML
    private ComboBox<String> secteurCB;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          
          
     if (selectedSecteur ==null){
        projets = ps.fetchProjet();
        } else {
            projets = ps.filterBySecteur(selectedSecteur.getIdSecteur());
        }
  
       for (int i=0; i<projets.size();i++) {
       
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("./ProjetItem.fxml"));
           try {
               HBox hb = loader.load();
               ProjetItemController pc = loader.getController();
               pc.setData(projets.get(i));
             
               ProjetsFreelanceListView.getItems().add(hb);
           } catch (IOException ex) {
               Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
         for (int i=0; i<ss.fetchSecteur().size(); i++){
            secteurCB.getItems().add(ss.fetchSecteur().get(i).getDescription());
        }
         
         secteurCB.setOnAction(e -> {
            selectedSecteur= ss.getsecteurbydescription(secteurCB.getValue());
             projets = ps.filterBySecteur(selectedSecteur.getIdSecteur());
            System.out.println(selectedSecteur);
            try {Parent Login = FXMLLoader.load(getClass().getResource("../GUI/ListeProjetsFreelance.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)secteurCB.getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        });
       
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
    private void handleProjet(MouseEvent event) {
selectedProjet = projets.get( ProjetsFreelanceListView.getSelectionModel().getSelectedIndex());
        try {
   
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("Offreprojet.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
    }

    @FXML
    private void ResetBtn(ActionEvent event) {
        selectedSecteur = null;
     projets=ps.fetchProjet();
     try {Parent Login = FXMLLoader.load(getClass().getResource("../GUI/ListeProjetsFreelance.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
