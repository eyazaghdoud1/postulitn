/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Entretien;
import services.AuthenticationService;
import services.EntretienService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewEntretiensCandidatController implements Initializable {

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
    private VBox mainVB;
    @FXML
    private ListView<HBox> listViewEnt;
    
    public static EntretienService esCandidat = new EntretienService();
    public static int candidatSelectedEntretien;
    public static List<Entretien> dataEntCandidat = esCandidat.filterByCandidature(6);
    @FXML
    private DatePicker dateDP;
    public static Date candSelectedEntDateFilter;

    MenuBarController mbc = new MenuBarController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       // mbc.setConnectedUser();
       
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
        for (Entretien e : dataEntCandidat) {
           
          if (e.getDate() != null) {
            try {
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewEntretienCandidatItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: #939AB0; -fx-border-radius: 10;");
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                listViewEnt.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");
                NewEntretienCandidatItemController eic = fxmlLoader.getController();
                System.out.println(e);
                eic.setData(e);
                //entretiensVB.getChildren().add(hbox);
                listViewEnt.getItems().add(hbox);
            } catch (IOException ex) {
               ex.printStackTrace();
            }
          }
        }
        
          if (candSelectedEntDateFilter != null) {
           dateDP.setValue(candSelectedEntDateFilter.toLocalDate());
        } 
         //1 - date picker for filter
           dateDP.setOnAction(e -> {
            LocalDate selectedDate = dateDP.getValue();
            Date sqlDate = Date.valueOf(selectedDate);
            candSelectedEntDateFilter = sqlDate;
            dataEntCandidat = esCandidat.filterListeByDate(dataEntCandidat, candSelectedEntDateFilter);
            System.out.println("test on action; " + selectedDate);
            //this.filterDate();
            reload();

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
    private void goToQuiz(MouseEvent event) {
        mbc.goToQuiz(event);
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        candidatSelectedEntretien = listViewEnt.getSelectionModel().getSelectedIndex();
            System.out.println(candidatSelectedEntretien);
       
    }

    @FXML
    private void reset(ActionEvent event) {
        dataEntCandidat = esCandidat.filterByCandidature(6);
        candSelectedEntDateFilter = null;
        reload();
    }
    
     private void reload() {
     try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewEntretiensCandidat.fxml"));
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
