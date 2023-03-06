/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.AuthenticationService;
import services.RoleService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class MenuBarAdminController implements Initializable {

    @FXML
    private Label userConnecte;
    @FXML
    private VBox offresVB;
   
    @FXML
    private VBox TypeOffreVB;
    @FXML
    private VBox usersVB;
    @FXML
    private VBox rolesVB;
    
     RoleService rs = new RoleService();

    /**
     * Initializes the controller class.
     */
    @FXML
    private VBox secteurVB;
           
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    


    @FXML
    public void goToOffres(MouseEvent event) {
//         try {
//            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/newoffres.fxml"));
//            Scene si = new Scene(Login);
//            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
//            st.setScene(si);
//            st.show();
//               
//        } catch (IOException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }


    @FXML
    public void goToTypeOffre(MouseEvent event) {
         //         try {
//            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/newTypeoffres.fxml"));
//            Scene si = new Scene(Login);
//            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
//            st.setScene(si);
//            st.show();
//               
//        } catch (IOException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    public void goToListUsers(MouseEvent event) {
            try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/UsersList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void goToListRoles(MouseEvent event) {
            try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/RolesList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void goToListSecteurs(MouseEvent event) {
//         try {
//            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/newListSecteurs.fxml"));
//            Scene si = new Scene(Login);
//            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
//            st.setScene(si);
//            st.show();
//               
//        } catch (IOException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }



    


    
}
