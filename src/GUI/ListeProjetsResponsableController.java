/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ListeProjetsFreelanceController.selectedProjet;
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
import javafx.scene.image.ImageView;
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
    @FXML
    private ComboBox<String> secteurCB;
     SecteurServices ss = new SecteurServices();
      public static Secteur selectedSecteur;
    @FXML
    private ImageView userPhoto;

    TestmenubarController mbc = new TestmenubarController();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*    URL u;
       if (AuthenticationService.compteconnecte.getPhoto() == null) {
             try {
                 u = new URL("http://localhost/postulitn/images/defaultuser.png");
                Image image = new Image(u.toString());
                userPhoto.setImage(image);
             } catch (MalformedURLException ex) {
                 Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
             }
       } 
       else {
    try {
        u = new URL("http://localhost/postulitn/images/"+ AuthenticationService.compteconnecte.getPhoto());
         Image image = new Image(u.toString());
         userPhoto.setImage(image);
        
    } catch (MalformedURLException ex) {
        Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
    }

       }    
       
        userConnecte.setText(AuthenticationService.userconnecte.getNom());
        */
        
        /****************************************************************************************************/
 if (selectedSecteur ==null){
        projets = ps.fetchProjet();
        } else {
            projets = ps.filterBySecteur(selectedSecteur.getIdSecteur());
        }
  
       for (int i=0; i<projets.size();i++) {
       
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("./ProjetRespItem.fxml"));
           try {
               HBox hb = loader.load();
               ProjetRespItemController pc = loader.getController();
               pc.setData(projets.get(i));
             
               ProjetsResponsableListView.getItems().add(hb);
           } catch (IOException ex) {
               Logger.getLogger(ListeProjetsResponsableController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
         for (int i=0; i<ss.fetchSecteur().size(); i++){
            secteurCB.getItems().add(ss.fetchSecteur().get(i).getDescription());
        }
         
         secteurCB.setOnAction(e -> {
            selectedSecteur= ss.getsecteurbydescription(secteurCB.getValue());
             projets = ps.filterBySecteur(selectedSecteur.getIdSecteur());
            System.out.println(selectedSecteur);
            try {Parent Login = FXMLLoader.load(getClass().getResource("../GUI/ListeProjetsResponsable.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)secteurCB.getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
         Logger.getLogger(ListeProjetsResponsableController.class.getName()).log(Level.SEVERE, null, ex);
     }
            
        });
       
       }
       @FXML
    private void goToCompte(MouseEvent event) {
        mbc.goToCompte(event);
    }

    @FXML
    private void goToOffres(MouseEvent event) {
        mbc.goToOffres(event);
    }

    @FXML
    private void goToCandidatures(MouseEvent event) {
        mbc.goToCandidatures(event);
    }

    @FXML
    private void goToEntretiens(MouseEvent event) {
        mbc.goToEntretiens(event);
    }

    @FXML
    private void goToGuides(MouseEvent event) {
        mbc.goToGuides(event);
    }

    @FXML
    private void GoToAjouterProjet(ActionEvent event) {
         try {
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("AjouterProjetRes.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @FXML
    private void handleProjetResp(MouseEvent event) {
         selectedProjetResp = projets.get(ProjetsResponsableListView.getSelectionModel().getSelectedIndex());
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

    @FXML
    private void Reset(ActionEvent event) {
          selectedSecteur = null;
     projets=ps.fetchProjet();
     try {Parent Login = FXMLLoader.load(getClass().getResource("../GUI/ListeProjetsResponsable.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeProjetsResponsableController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
        mbc.goToQuiz(event);
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
    
 
