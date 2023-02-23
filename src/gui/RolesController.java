/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Role;
import services.RoleService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class RolesController implements Initializable {

    RoleService rs = new RoleService();
    @FXML
    private VBox rlayout;
    @FXML
    private Button btnrole;
    @FXML
    private TextField roleajoute;
    
    public static Role r;
    @FXML
    private Button btnuser;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List <Role> roles = rs.fetchRoles();
        for (int i=0; i<roles.size();i++){
            r=roles.get(i);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../gui/r.fxml"));
             try {
                 HBox hBox = fxmlLoader.load();
                 RController rc = fxmlLoader.getController();
                 rc.setData(roles.get(i));
                 rlayout.getChildren().add(hBox);
             } catch (IOException ex) {
                 Logger.getLogger(Users2Controller.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
    }    
    
    

    @FXML
    private void AjoutRole(ActionEvent event) throws IOException {
        RoleService rs = new RoleService();
        Role r = new Role();
        r.setDescription(roleajoute.getText());
        rs.addRole(r);   
        Parent Login = FXMLLoader.load(getClass().getResource("../gui/Roles.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
    }

    @FXML
    private void goToUsers(ActionEvent event) {
        
        try {
            Parent Login = FXMLLoader.load(getClass().getResource("../gui/users2.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
   

