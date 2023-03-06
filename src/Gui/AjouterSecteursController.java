/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Secteur;
import interfaces.ProjetInterface;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
public class AjouterSecteursController implements Initializable {

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
    private ListView<HBox> secteurListView;
    SecteurServices secteurservice = new SecteurServices();
    public static int selectedSecteur;
    @FXML
    private TextField secteurTF;
    
      private String SecteurSelectionne; 
      
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       
        ProjetInterface projetservice = new ProjetServices();
    @FXML
    private Label erreurSecteur;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
       List<Secteur> secteurs = secteurservice.fetchSecteur();
       for (Secteur s: secteurs) {
       
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("./s.fxml"));
           try {
               HBox hb = loader.load();
               SController sc = loader.getController();
               sc.setData(s);
               secteurListView.getItems().add(hb);
           } catch (IOException ex) {
               Logger.getLogger(AjouterSecteursController.class.getName()).log(Level.SEVERE, null, ex);
           }
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
    private void handleSecteur(MouseEvent event) {
        selectedSecteur = secteurListView.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void addSecteur(ActionEvent event) {
     SecteurServices ss = new SecteurServices();
         Secteur s= new Secteur(); 
          if (controleTextFieldNonNumerique(secteurTF))
          {return ; 
          }
          
          if(secteurTF.getText().isEmpty())
                     {
        erreurSecteur.setText("veuillez saisir un secteur !");
        erreurSecteur.setVisible(true);
        return;
        }
              
 
        s.setDescription(secteurTF.getText());
        secteurservice.addSecteur(s);
     try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/AjouterSecteurs.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
        public boolean controleTextFieldNonNumerique(TextField textField) {
        if (textField.getText().matches(".*[0-9].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez n'insérer que des caractères !");
            alert.showAndWait();
            return true;
        }
             return false;}

    }
    
