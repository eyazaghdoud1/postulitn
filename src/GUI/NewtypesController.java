/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.NewoffresController.selectedoffre;
import interfaces.TypeoffreInterface;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private ListView<HBox> listetypes;
    public static int selectedtype;

     TypeoffreService tos = new TypeoffreService();
      String typeSelectionne;
    @FXML
    private VBox TypeOffreVB;
    @FXML
    private VBox usersVB;
    @FXML
    private VBox rolesVB;
    @FXML
    private VBox secteurVB;
    /**
     * Initializes the controller class.
     */
    MenuBarAdminController mbac = new MenuBarAdminController();
    @FXML
    private TextField descriptiontf;
    
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
    private void handletype(MouseEvent event) {
        selectedtype=listetypes.getSelectionModel().getSelectedIndex();
    }

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

    @FXML
    private void goToTypeOffre(MouseEvent event) {
        mbac.goToTypeOffre(event);
    }

    @FXML
    private void goToListUsers(MouseEvent event) {
        mbac.goToListUsers(event);
    }

    @FXML
    private void goToListRoles(MouseEvent event) {
        mbac.goToListRoles(event);
    }

    @FXML
    private void goToListSecteurs(MouseEvent event) {
//        mbac.goToListSecteurs(event);
    }

  @FXML
    private void addtype(ActionEvent event) {
 TypeoffreService ts = new TypeoffreService();
 Typeoffre t = new Typeoffre();
 
// if(controleTextFieldNomEtPrenom(descriptiontf)  )     {         
//    if (descriptiontf.getText().isEmpty())
//         {
//                        erreurdescription.setText("description non valide !");
//                        erreurdescription.setVisible(true);
//                        
//                        return;
//                    }

   Typeoffre to = new Typeoffre();
      t.setDescription(descriptiontf.getText());
      TypeoffreService pt = new TypeoffreService();
      pt.addType2(t);
   
       
    
    
   }

    @FXML
    private void dist(ActionEvent event) {
        
            try {Parent Liste = FXMLLoader.load(getClass().getResource("../GUI/statistique.fxml"));
        
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
