/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.Offre;
import services.OffreService;
import services.TypeoffreService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class OFFREITEMController implements Initializable {

    @FXML
    private Label poste;
    @FXML
    private Label description;
    @FXML
    private Label lieu;
    @FXML
    private Label entreprise;
    @FXML
    private Label specialite;
    @FXML
    private Label dateE;
    @FXML
    private Label idR;
    @FXML
    private Label idtype;

    /**
     * Initializes the controller class.
     */
    
     public void setData (Offre o){
        
         
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateExpirationString = dateFormat.format(o.getDateExpiration());
        
            poste.setText(o.getPoste());
            description.setText(o.getDescription());
            lieu.setText(o.getLieu());
            entreprise.setText(o.getEntreprise());
            specialite.setText(o.getSpecialite());
            dateE.setText(dateExpirationString);
            idR.setText(Integer.toString(o.getIdRecruteur()));
            idtype.setText(o.getType().getDescription());
        

       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Deleteoffre(ActionEvent event) {
           OffreService ps = new OffreService();
        TypeoffreService ts = new TypeoffreService();
        
     
//         Offre o = new Offre();
// ps.deleteOffre(32);
//         o = LesoffresController.o;
//            s.setDescription(DescriSecteur.getText());
//            ss.deleteSecteurById(s);
//       try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/ListeSecteurFXML.fxml"));
//            Scene si = new Scene(Login);
//            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
//            st.setScene(si);
//            st.show();
//        } catch (IOException ex) {
//            Logger.getLogger(SController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
       
    
    
 
}
}