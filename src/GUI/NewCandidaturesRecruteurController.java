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
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Candidature;
import models.Entretien;
import services.CandidatureService;
import utilities.EtatCandidature;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewCandidaturesRecruteurController implements Initializable {

    @FXML
    private Label userConnecte;
    @FXML
    private ImageView userPhoto;
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
    private HBox headerHB;
    @FXML
    private SplitMenuButton filtresOffre;
    @FXML
    private SplitMenuButton filtreTypeOffre;
    @FXML
    private VBox mainVB;
    @FXML
    private ListView<HBox> listViewCand;
    
    public static CandidatureService csr = new CandidatureService();
    @FXML
    private Button resetBtn;
    @FXML
    private SplitMenuButton filtresEtat;
    
    public static String recSelectedEtatFiltre;
    public static String recSelectedTypeOffreFiltre;
    public static String recSelectedOffreFiltre;
    public static Candidature recSelectedCand;
    public static List<Candidature> dataCand = csr.fetchCandidatures();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        //List<Candidature> dataV = cs.filterListeByEtat(data, EtatCandidature.EtatsCandidature.Validée);
                for (Candidature cand : dataCand) {
            
                 try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewCandidatureRecruteurItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: #939AB0; -fx-border-radius: 10;"); 
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                listViewCand.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");
                NewCandidatureRecruteurItemController cic = fxmlLoader.getController();
                cic.setData(cand);
                listViewCand.getItems().add(hbox);
                 } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
                
        filtresEtat.getItems().clear();
        if (recSelectedEtatFiltre == null) {
          filtresEtat.setText("Etats");
        } else {
          filtresEtat.setText(recSelectedEtatFiltre);
        }
                
        for (EtatCandidature.EtatsCandidature e: EtatCandidature.EtatsCandidature.values()) {
            MenuItem option = new MenuItem(e.toString());
            filtresEtat.getItems().add(option);
            option.setOnAction(event -> {
            System.out.println(option.getText());
            recSelectedEtatFiltre = option.getText();
            this.filterEtat();
            this.reload();

          });
        }
        
        
        // type d'offre filtre 
        filtreTypeOffre.getItems().clear();
        if (recSelectedTypeOffreFiltre == null) {
          filtreTypeOffre.setText("Types d'offres");
        } else {
          filtreTypeOffre.setText(recSelectedTypeOffreFiltre);
        }
        MenuItem type1 = new MenuItem("Stage");
        MenuItem type2 = new MenuItem("Mi-temps");
        MenuItem type3 = new MenuItem("Embauche");
        
        filtreTypeOffre.getItems().addAll(type1, type2, type3);
        
        //offre filtre 
        filtresOffre.getItems().clear();
        if (recSelectedOffreFiltre == null) {
          filtresOffre.setText("Offres");
        } else {
          filtresOffre.setText(recSelectedOffreFiltre);
        }
        
        
        

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
    private void goToQuiz(MouseEvent event) {
    }


    @FXML
    private void filterByOffre(ActionEvent event) {
    }

    @FXML
    private void filterByTypeOffre(ActionEvent event) {
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        System.out.println(listViewCand.getSelectionModel().getSelectedIndex());
        recSelectedCand = dataCand.get( listViewCand.getSelectionModel().getSelectedIndex());
        try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidatureEntretienInterface.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }


    @FXML
    private void filterByEtat(ActionEvent event) {
    }

    @FXML
    private void reset(ActionEvent event) {
         dataCand = csr.fetchCandidatures();
         recSelectedEtatFiltre = null;
         recSelectedOffreFiltre = null;
         recSelectedTypeOffreFiltre = null; 
         reload();
    }
    
    private void filterEtat() {
       
      dataCand =  csr.filterListeByEtat(dataCand, EtatCandidature.EtatsCandidature.valueOf(recSelectedEtatFiltre) );

    }
    
     private void reload() {
     try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidaturesRecruteur.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) mainVB.getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }

    
}
