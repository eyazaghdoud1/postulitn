/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.NewoffresController.selectedoffre;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Offre;
import models.Typeoffre;
import services.OffreService;
import services.TypeoffreService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */

public class NewtypesController implements Initializable {
    
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
    private ListView<HBox> listetypes;
    public static int selectedtype;

     TypeoffreService tos = new TypeoffreService();
      String typeSelectionne;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         List<Typeoffre> to = tos.fetchOffres();
       
        
       List<Typeoffre> types = tos.fetchOffres();
       
        for(int i=0; i<types.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../GUI/TYPEITEM.fxml"));
            
            try{
                HBox hBox = fxmlLoader.load();
                TYPEITEMController cic = fxmlLoader.getController();
                cic.setData(types.get(i));
                listetypes.getItems().add(hBox);
                 
            } catch (IOException ex)
            {
                Logger.getLogger(LesoffresController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO
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
    private void handletype(MouseEvent event) {
        selectedtype=listetypes.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void back(MouseEvent event) {
         try {Parent Liste = FXMLLoader.load(getClass().getResource("../Gui/ajoutertype.fxml"));
        
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
