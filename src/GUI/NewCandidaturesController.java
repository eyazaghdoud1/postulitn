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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Candidature;
import models.Offre;
import services.AuthenticationService;
import services.CandidatureService;
import services.OffreService;
import utilities.EtatCandidature;

/**
 * FXML Controller class
 *
 * @author HP I5
 */


public class NewCandidaturesController implements Initializable {

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
    private ListView<HBox> listViewCand;
    
    @FXML
    private VBox mainVB;
    @FXML
    private HBox headerHB;
    @FXML
    private SplitMenuButton filtresEtat;
    private SplitMenuButton filtreTypeOffre;
    
    // static var to retrieve the selected index
    public static int candIndex;
    // static var to retrieve the selected candidature
    public static Candidature selectedCandidature;
    
    public static CandidatureService cs = new CandidatureService();
    
    // liste des candidatures de l'utilisateur connecté
    public static List<Candidature> data = cs.fetchCandidatures();
    
    public static String selectedEtatFiltre;
    public static String selectedTypeOffreFiltre;
    @FXML
    private Button resetBtn;

    TestmenubarController mbc = new TestmenubarController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
        
        //mbc.setConnectedUser();
        // TODO
       /* mainVB.setStyle("-fx-border-color: white");
        mainVB.setEffect(new DropShadow(2d, 0d, +2d, Color.BLACK));*/
       headerHB.setEffect(new DropShadow(2d, 0d, +2d, Color.GREY));
       // data = cs.filterByCandidat(userconnecte.getId)
        Offre o ; 
        OffreService os = new OffreService();
        for (Candidature cand : data) {
                o=os.getelementbyid(cand.getIdOffre());
                 try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewCandidatureItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: #939AB0; -fx-border-radius: 10;"); 
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                listViewCand.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");
                NewCandidatureItemController cic = fxmlLoader.getController();
                cic.setData(cand, o);
                /*if (cand.getEtat().equals(EtatCandidature.EtatsCandidature.Validée.toString())) {
                
                Image check = new Image("C:\\Users\\HP I5\\Documents\\NetBeansProjects\\postulitnApp\\src\\GUI");
                ImageView iv = new ImageView(check);
                hbox.getChildren().add(iv);
                    System.out.println("checked");
                }*/
                listViewCand.getItems().add(hbox);
                 } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
        
        // initializing the filter options
        
        // 1 - etat candidature filter options
        filtresEtat.getItems().clear();
        if (selectedEtatFiltre == null) {
          filtresEtat.setText("Etats");
        } else {
          filtresEtat.setText(selectedEtatFiltre);
        }

        
        for (EtatCandidature.EtatsCandidature e: EtatCandidature.EtatsCandidature.values()) {
            MenuItem option = new MenuItem(e.toString());
            filtresEtat.getItems().add(option);
            option.setOnAction(event -> {
            System.out.println(option.getText());
            selectedEtatFiltre = option.getText();
            this.filterEtat();
            this.reload();

          });
        }
       /* MenuItem option1 = new MenuItem(EtatCandidature.EtatsCandidature.Enregistrée.toString());
        MenuItem option2 = new MenuItem(EtatCandidature.EtatsCandidature.Validée.toString());
        MenuItem option3 = new MenuItem(EtatCandidature.EtatsCandidature.EntretienTel.toString());
        MenuItem option4 = new MenuItem(EtatCandidature.EtatsCandidature.EntretienPres.toString());
        filtresEtat.getItems().addAll(option1, option2, option3, option4);
        
        
        option1.setOnAction(e -> {
            System.out.println(option1.getText());
            selectedEtatFiltre = option1.getText();
            this.filterEtat();
            this.reload();

          });
        option2.setOnAction(e -> {
            System.out.println(option2.getText());
            filtresEtat.setText(option2.getText());
            selectedEtatFiltre = option2.getText();
            this.filterEtat();
            this.reload();
            
          });
        option3.setOnAction(e -> {
            System.out.println(option3.getText());
            filtresEtat.setText(option3.getText());
            selectedEtatFiltre = option3.getText();
            this.filterEtat();
            this.reload();
            
          });
        option4.setOnAction(e -> {
            System.out.println(option4.getText());
            filtresEtat.setText(option4.getText());
            selectedEtatFiltre = option4.getText();
            this.filterEtat();
            this.reload();
          });*/
        
        // 2 - type Offre filter options 
       /* filtreTypeOffre.getItems().clear();
        if (selectedTypeOffreFiltre == null) {
          filtreTypeOffre.setText("Types d'offres");
        } else {
          filtreTypeOffre.setText(selectedTypeOffreFiltre);
        }
        MenuItem type1 = new MenuItem("Stage");
        MenuItem type2 = new MenuItem("Mi-temps");
        MenuItem type3 = new MenuItem("Embauche");
        
        filtreTypeOffre.getItems().addAll(type1, type2, type3);*/ 
      
    }    

    @FXML
    private void handleMouseClick(MouseEvent event) {
        
            candIndex = listViewCand.getSelectionModel().getSelectedIndex();
            selectedCandidature =  data.get(candIndex);
            // redirection vers la page de la candidature
            
            System.out.println(candIndex);
            System.out.println(selectedCandidature);
            try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidatureInterface.fxml"));
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
    private void filterByEtat(ActionEvent event) {
      
    

    }
   /* private List<Candidature> filterEtat(EtatCandidature.EtatsCandidature etat) {
       
      return cs.filterListeByEtat(data, etat);

    }*/
    private void filterEtat() {
       
      data =  cs.filterListeByEtat(data, EtatCandidature.EtatsCandidature.valueOf(selectedEtatFiltre) );

    }
    
    private void reload() {
     try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidatures.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) mainVB.getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }


    @FXML
    private void reset(ActionEvent event) {
        data = cs.fetchCandidatures();
        selectedEtatFiltre = null;
        selectedTypeOffreFiltre = null;
        reload();
        
    }

  
    
}
