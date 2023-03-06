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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.GuideEntretien;
import models.VisiteGuide;
import services.AuthenticationService;
import services.CompteServices;
import services.GuideEntretienService;
import services.VisiteGuideService;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ListeguideController implements Initializable {
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
    private ListView<HBox> guidelist;
    
    GuideEntretienService ges= new GuideEntretienService();
    GuideEntretien ge= new GuideEntretien();
    public static GuideEntretien selectedGuide;
    List<GuideEntretien> guides;
    MenuBarController mbc = new MenuBarController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      guides =  ges.fetchGuideEntretien();
//       System.out.println(NewCompteController.compteUser.getPhoto()+"test");
//        URL u;
//        //NewCompteController.compteUser.getPhoto()
//        try {
//            u = new URL("http://localhost/postulitn/images/"+NewCompteController.compteUser.getPhoto());
//           
//             Image image = new Image(u.toString());
//              userPhoto.setImage(image);
//             
//         
//           
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
//        }

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
        for (int i=0; i<guides.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../gui/guideitem.fxml"));
             try {
                 HBox hBox = fxmlLoader.load();
                 GUI.GuideitemController gic = fxmlLoader.getController();
                 gic.setData(guides.get(i));
                 System.out.println(guides.get(i));
                 guidelist.getItems().add(hBox);
             } catch (IOException ex) {
               ex.printStackTrace();
             }
            
        }
        
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
    private void goToGuides(MouseEvent event) throws IOException {
        
        
         mbc.goToGuides(event);
        
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
        mbc.goToQuiz(event);
    }

    @FXML
    private void handleguidelist(MouseEvent event) {
         selectedGuide = guides.get( guidelist.getSelectionModel().getSelectedIndex() );
        try {
           
            Parent root = FXMLLoader.load(getClass().getResource("guideentretien2.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
            
            LocalDate currentDate = LocalDate.now();
            VisiteGuide v = new VisiteGuide();
            VisiteGuideService vgs = new VisiteGuideService();
            CompteServices cservice = new CompteServices();
       v.setDate_consultation(Date.valueOf(currentDate));
        v.setGuideentretien(selectedGuide);
        v.setCompte(NewCompteController.compteUser);
        vgs.addVisiteGuide(v);
            
        } catch (IOException ex) {
            Logger.getLogger(ListeguideController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void allerajouter(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ajoutguide2.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }


}
