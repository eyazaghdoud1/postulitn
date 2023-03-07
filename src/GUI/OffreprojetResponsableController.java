/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.ProjetFreelance;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ProjetServices; 

/**
 * FXML Controller class
 *
 * @author Users
 */
public class OffreprojetResponsableController implements Initializable {

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
    private Label Lduree;
    @FXML
    private Label Ltheme;
    @FXML
    private Label Ldescription;
    @FXML
    private Label Lsecteur;
    @FXML
    private Label LDateDebut;
    @FXML
    private Label LDateFin;
    @FXML
    private Label Lnom;
    
     static ProjetServices projetservice = new ProjetServices(); 
  static List<ProjetFreelance> commentaires = projetservice.fetchProjet();
    @FXML
    private ImageView userPhoto;
    
    TestmenubarController mbc = new TestmenubarController();

    /**
     * Initializes the controller class.
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
        // TODO
        
        Ltheme.setText(ListeProjetsResponsableController.selectedProjetResp.getTheme());
        LDateDebut.setText(ListeProjetsResponsableController.selectedProjetResp.getDateDebut() + "");
        LDateFin.setText(ListeProjetsResponsableController.selectedProjetResp.getDateFin() + "");
        Lduree.setText(ListeProjetsResponsableController.selectedProjetResp.getDuree()+ "");
        Ldescription.setText(ListeProjetsResponsableController.selectedProjetResp.getDescription());
        Lsecteur.setText(ListeProjetsResponsableController.selectedProjetResp.getS().getDescription()+"");
        Lnom.setText(ListeProjetsResponsableController.selectedProjetResp.getNom());
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

    private void GoToListeProjets(MouseEvent event) {
        try {
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("ListeProjetsResponsable.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffreprojetResponsableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteProjet(ActionEvent event) {
//        ps.deleteProjetById(ListeProjetsResponsableController.selectedProjetResp);
//         try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/ListeProjetsResponsable.fxml"));
//            Scene si = new Scene(Login);
//            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
//            st.setScene(si);
//            st.show();
//        } catch (IOException ex) {
//            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }  
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Etes-vous sures de vouloir supprimer cette offre ?");

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // User clicked "Yes"
                projetservice.deleteProjetById(ListeProjetsResponsableController.selectedProjetResp);
                 try {
                  Parent root = FXMLLoader.load(getClass().getResource("./ListeProjetsResponsable.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
                } else {
                 // User clicked "No" or closed the dialog
                 alert.close();
                }
    }

    @FXML
    private void GoToModifier(ActionEvent event) {
        try {
   
            Parent ModifierProjets = FXMLLoader.load(getClass().getResource("ModifierProjets.fxml"));
            Scene  ModifierProjetsScene = new Scene(ModifierProjets);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(ModifierProjetsScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoToCommentaire(ActionEvent event) {
        try {
   
            Parent ModifierProjets = FXMLLoader.load(getClass().getResource("FeedbackResp.fxml"));
            Scene  ModifierProjetsScene = new Scene(ModifierProjets);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(ModifierProjetsScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoBack(ActionEvent event) {
         try {
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("ListeProjetsResponsable.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffreprojetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
        mbc.goToQuiz(event);
    }
    }
    

