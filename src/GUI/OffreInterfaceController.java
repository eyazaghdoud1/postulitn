/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Offre;
import models.Utilisateur;
import services.AuthenticationService;
import services.OffreService;
import services.TypeoffreService;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class OffreInterfaceController implements Initializable {

    @FXML
    private Label userConnecte;
    @FXML
    private VBox offresVB;
    @FXML
    private Label poste;
    @FXML
    private Label description;
    @FXML
    private Label lieu;
    @FXML
    private Label specialite;
    @FXML
    private Label entreprise;
    @FXML
    private Label dateE;
    @FXML
    private Label idR;
    @FXML
    private Label type;
    private VBox suggestedContainer;

    MenuBarController mbc = new MenuBarController();
    /**
     * Initializes the controller class.
     */
    
    UtilisateurService us = new UtilisateurService();
    @FXML
    private ImageView userPhoto;
    @FXML
    private VBox candidaturesVB;
    @FXML
    private VBox entretiensVB;
    @FXML
    private VBox guidesVB;
    @FXML
    private VBox quizVB;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        OffreService os = new OffreService();
        List<Offre> suggestedOffres = os.suggestedOffres(NewoffresController.selectedoffre.getType().getId(),NewoffresController.selectedoffre.getId());
       
         /****************************************************************************************/
        URL u;
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
        
        
        /****************************************************************************************************/
        
        // Loop through the card list and create a custom card component for each one
      /*  int numCards = suggestedOffres.size();
        if (numCards != 0) {
            int cardsPerRow = 2;

            for (int i = 0; i < numCards; i += cardsPerRow) {
                HBox hbox = new HBox();
                hbox.setSpacing(70);
                hbox.setPadding(new Insets(30));
                hbox.getStyleClass().add("card-row");

                int endIndex = Math.min(i + cardsPerRow, numCards);
                List<Offre> rowCards = suggestedOffres.subList(i, endIndex);

                for (Offre o : rowCards) {
                    BorderPane cardPane = new BorderPane();
                    cardPane.getStyleClass().add("card-pane");

                    VBox vb = new VBox();
                    VBox vbempty = new VBox();
                    vbempty.setPrefHeight(20);
                    vb.setSpacing(10);
                    vb.getStyleClass().add("card-container");
                    Label titleLabel = new Label(o.getPoste());
                    titleLabel.getStyleClass().add("card-title");
                    Label categorieLabel = new Label(o.getEntreprise());
                    categorieLabel.getStyleClass().add("card-categorie");

                    Label descText = new Label(o.getDescription());
                    descText.getStyleClass().add("card-desc");
                    descText.setWrapText(true);
                    descText.setMaxWidth(280);
                    vb.getChildren().addAll(titleLabel, categorieLabel, descText);
                    vb.prefWidthProperty().bind(hbox.widthProperty().divide(cardsPerRow).subtract(70));
                    cardPane.setTop(vb);
                    hbox.getChildren().add(cardPane);
                }

                suggestedContainer.getChildren().add(hbox);
            }
        }
        else {
            Label errorText = new Label("Pas de suggestion");
            errorText.getStyleClass().add("card-title-error");
            suggestedContainer.getChildren().add(errorText);
        }*/

        poste.setText(NewoffresController.selectedoffre.getPoste());
        description.setText(NewoffresController.selectedoffre.getDescription());
        dateE.setText(NewoffresController.selectedoffre.getDateExpiration() + "");
        lieu.setText(NewoffresController.selectedoffre.getLieu());
        specialite.setText(NewoffresController.selectedoffre.getSpecialite());
        Utilisateur user = us.GetByIdUser(NewoffresController.selectedoffre.getIdRecruteur());
        idR.setText(user.getNom()+" "+user.getPrenom());
        type.setText(NewoffresController.selectedoffre.getType().getDescription());

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
    private void goToQuiz(MouseEvent event) {
        mbc.goToQuiz(event);
    }
    
    @FXML
    private void delete(ActionEvent event) { 
        TypeoffreService tos = new TypeoffreService();
      OffreService os = new OffreService();
         List<Offre> lo = os.fetchOffres();
        OffreService ps = new OffreService();
        TypeoffreService ts = new TypeoffreService();
        
         ps.deleteOffre(NewoffresController.selectedoffre.getId());
         try {Parent Liste = FXMLLoader.load(getClass().getResource("newoffres.fxml"));
        
            Scene si = new Scene(Liste);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }
             
//       try {Parent Login = FXMLLoader.load(getClass().getResource("./newoffres.fxml"));
//            Scene si = new Scene(Login);
//            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
//            st.setScene(si);
//            st.show();
//        } catch (IOException ex) {
//                         Logger.getLogger(OFFREITEMController.class.getName()).log(Level.SEVERE, null, ex);

          
       
//        

    @FXML
    private void modifier(ActionEvent event) {
          try {Parent Liste = FXMLLoader.load(getClass().getResource("modifieroffre.fxml"));
        
            Scene si = new Scene(Liste);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }

    @FXML
    private void goback(MouseEvent event) {
         try {Parent Liste = FXMLLoader.load(getClass().getResource("../Gui/newoffres.fxml"));
        
            Scene si = new Scene(Liste);
            si.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }

    
    }


