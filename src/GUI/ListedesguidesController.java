/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.GuideEntretien;
import services.GuideEntretienService;
import services.VisiteGuideService;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ListedesguidesController implements Initializable {
    GuideEntretienService ges = new GuideEntretienService();
    @FXML
    private TableColumn<GuideEntretien, Integer> colidguide;
    @FXML
    private TableColumn<GuideEntretien, String> coldomaine;
    @FXML
    private TableColumn<GuideEntretien, String> colspecialite;
    @FXML
    private TableColumn<GuideEntretien, String> colsupport;
    @FXML
    private TableView<GuideEntretien> tableguides;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.sql.SQLException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        // TODO
        
        colidguide.setCellValueFactory(new PropertyValueFactory<GuideEntretien,Integer>("idguide"));
        coldomaine.setCellValueFactory(new PropertyValueFactory<GuideEntretien,String>("domaine"));
        colspecialite.setCellValueFactory(new PropertyValueFactory<GuideEntretien,String>("specialite"));
        colsupport.setCellValueFactory(new PropertyValueFactory<GuideEntretien,String>("support"));
        ObservableList<GuideEntretien> listU = FXCollections.observableArrayList();
GuideEntretienService ps=new GuideEntretienService();
ps.fetchGuideEntretien().forEach((ge)->{listU.add(ge);});

        tableguides.setItems(listU);

        
      
    }
            
  
    @FXML
    private void modifierguide(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("modifierguide.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }

    @FXML
    private void supprimerguide(ActionEvent event) {
         
    GuideEntretien guideASupprimer = tableguides.getSelectionModel().getSelectedItem();
    GuideEntretienService guideEntretienService = new GuideEntretienService();
    guideEntretienService.deleteGuideEntretien(guideASupprimer);
    tableguides.getItems().remove(guideASupprimer);
    }

    
}
