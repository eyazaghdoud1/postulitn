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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Typeoffre;
import services.OffreService;
import services.TypeoffreService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class StatistiqueController implements Initializable {

    @FXML
    private PieChart chartfor;
    @FXML
    private Label userConnecte;
    @FXML
    private VBox TypeOffreVB;
    @FXML
    private VBox usersVB;
    @FXML
    private VBox rolesVB;
    @FXML
    private VBox secteurVB;

    MenuBarAdminController mbac = new MenuBarAdminController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        statsTypeOffre();
        // TODO  
    }    
    
     
     private void statsTypeOffre() {
         OffreService serv = new OffreService();
          TypeoffreService t = new TypeoffreService();
         ObservableList<Typeoffre> listTypes= t.getTypeDesc();
          ObservableList<PieChart.Data> PieChartData =FXCollections.observableArrayList();
         for (Typeoffre type : listTypes){
              PieChartData.add(new PieChart.Data(type.getDescription(),serv.typeByOffre(type.getId())));
         }
    chartfor.setData(PieChartData);
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
        mbac.goToListSecteurs(event);
    }

    @FXML
    private void goback(MouseEvent event) {
        
         try {Parent Liste = FXMLLoader.load(getClass().getResource("../GUI/newtypes.fxml"));
        
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
