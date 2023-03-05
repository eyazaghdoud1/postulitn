/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Compte;
import services.CompteServices;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class Modifiercompte2Controller implements Initializable {
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
    private DatePicker datediplomedp;
    @FXML
    private TextField diplometf;
    @FXML
    private TextField phototf;
    @FXML
    private TextField cvtf;
    
    // visible si user est recruteur
    @FXML
    private TextField entreprisetf;

    @FXML
    private TextField experiencetf;

    Date sqlDate;
    @FXML
    private TextField domainetf;
    @FXML
    private TextField postetf;
    @FXML
    private ImageView eetaswira;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        datediplomedp.setOnAction(e -> {
            LocalDate selectedDate = datediplomedp.getValue();
           sqlDate = Date.valueOf(selectedDate); 
        });
        
        datediplomedp.setValue(Compte2Controller.compteUser.getDateDiplome().toLocalDate());
        
        diplometf.setText(Compte2Controller.compteUser.getDiplome());
//        cvtf.setText(Compte2Controller.compteUser.getCv());
        entreprisetf.setText(Compte2Controller.compteUser.getEntreprise());
        experiencetf.setText(Compte2Controller.compteUser.getExperience());
        domainetf.setText(Compte2Controller.compteUser.getDomaine()); 
        postetf.setText(Compte2Controller.compteUser.getPoste()); 
        
        
        try {
            /* File file = new File("C:\\Users\\dell\\Pictures\\COPY_anarci-1623243208.jpeg");
            URI uri = file.toURI();
            Image image = new Image(uri.toString());
            eetaswira.setImage(image);*/
            
            URL u = new URL("http://localhost/postulitn/images/"+Compte2Controller.compteUser.getPhoto());
            Image image = new Image(u.toString());
            eetaswira.setImage(image);
           
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Modifiercompte2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    

    @FXML
    private void goToCompte(MouseEvent event) {
         try {
        Parent compteParent = FXMLLoader.load(getClass().getResource("compte2.fxml"));
        Scene compteScene = new Scene(compteParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compteScene);
        window.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
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
           try {
        Parent root = FXMLLoader.load(getClass().getResource("Listeguide.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
    }

    File imgFile;
    @FXML
    private void boutnmodifiercompte(ActionEvent event) throws IOException {
        
         CompteServices cservice = new CompteServices();
        //date to a string if needed
        LocalDate selectedDate = datediplomedp.getValue();
        String dateString = selectedDate.toString();
        Compte c = Compte2Controller.compteUser;
        //c.setExperience(experiencetf.getText());
        
        
        Path sourceimg=imgFile.toPath();
        Path destinationimg=Paths.get("C:\\xampp\\htdocs\\postulitn\\images\\" +imgFile.getName());
        Files.copy(sourceimg, destinationimg, StandardCopyOption.REPLACE_EXISTING);
        c.setDiplome(diplometf.getText());
        c.setPhoto(imgFile.getName());
      //  c.setCv(cvtf.getText());
        c.setEntreprise(entreprisetf.getText());
        c.setDomaine(domainetf.getText());
        c.setPoste(postetf.getText());
        c.setDateDiplome(Date.valueOf(datediplomedp.getValue())); 
       cservice.updateCompte(Compte2Controller.compteUser.getIdCompte(),c); 
        
                 try {
        Parent root = FXMLLoader.load(getClass().getResource("compte2.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) eetaswira.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
        
//        try {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/compte2.fxml"));
//        Parent root = loader.load();
//        ListeguideController controller = loader.getController();
//        Scene scene = new Scene(root);
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    } catch (IOException ex) {
//        System.out.println(ex.getMessage());
//    }
//    
             
         Compte c1 = new Compte();
        
    }

    @FXML
    private void zidtaswira(ActionEvent event) {
        
            // Create a FileChooser dialog
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");

        // Set the file filters
      /*  fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "."));*/

        // Show the dialog and wait for the user to select a file
        //fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "Images"));
        imgFile = fileChooser.showOpenDialog(eetaswira.getScene().getWindow());
        
        phototf.setText(imgFile.getAbsolutePath());
        // If a file was selected, load it into the ImageView
//        if (file != null) {
//            Image image = new Image(file.toURI().toString());
//            eetaswira.setImage(image);
//        }
        
    }
    
}
