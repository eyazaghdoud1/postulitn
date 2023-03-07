/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.Candidature;
import models.Entretien;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import services.AuthenticationService;
import services.EntretienService;
import utilities.EtatCandidature;
import utilities.TypeEntretien;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewCandidatureInterfaceController implements Initializable {

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
    private ImageView cvImageView;
    @FXML
    private ImageView lettreImageView;
    
    byte[] pdfDataCV;
    byte[] pdfDataLettre;
    @FXML
    private HBox candidatureHB;
    @FXML
    private HBox entTelVideHB;
    @FXML
    private Label dateEntTel;
    @FXML
    private Label heureEntTel;
    @FXML
    private HBox entPresVideHB;
    @FXML
    private VBox entPresVb;
    @FXML
    private Label dateEntPres;
    @FXML
    private Label heureEntPres;
    @FXML
    private Label lieuEntPres;
    @FXML
    private Button browseCvBtn;
    @FXML
    private Button browseLettreBtn;
    @FXML
    private Label dateCand;

    EntretienService es = new EntretienService();
    @FXML
    private Button backBtn;
    @FXML
    private Label posteOffre;
    @FXML
    private Label entrepriseOffre;
    @FXML
    private Label typeOffre;
    @FXML
    private Label etatCand;
    @FXML
    private Button updateBtn;
    @FXML
    private TextField cvTF;
    @FXML
    private TextField lettreTF;
    
    File cvFile, lettreFile;
    
    TestmenubarController mbc = new TestmenubarController();
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //mbc.setConnectedUser();
        
           /****************************************************************************************/
     /*   URL u;
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
       
        userConnecte.setText(AuthenticationService.userconnecte.getNom());*/
        
        
        /****************************************************************************************************/
        updateBtn.setDisable(true);
         /*cvTF.textProperty().addListener((observable, oldValue, newValue) -> {
           updateBtn.setDisable( (newValue.trim().isEmpty() || lettreTF.getText().trim().isEmpty()) 
                );
        });


        
        updateBtn.setDisable(true);
        System.out.println(NewCandidaturesController.selectedCandidature);
        
        // si la candidature est passé de l'état enregistré à un autre état; pas de modifications
/*        if (! NewCandidaturesController.selectedCandidature.getEtat().equals(EtatCandidature.EtatsCandidature.Enregistrée))
        {
           browseCvBtn.setDisable(true);
           browseLettreBtn.setDisable(true);
        }*/
        cvTF.setText(NewCandidaturesController.selectedCandidature.getCv());
        lettreTF.setText(NewCandidaturesController.selectedCandidature.getLettre());
        dateCand.setText(dateCand.getText() + NewCandidaturesController.selectedCandidature.getDate());
        etatCand.setText(etatCand.getText() + NewCandidaturesController.selectedCandidature.getEtat());
        try {
            // TODO
            System.out.println("Initializing");
            //Path filePath = Paths.get("D:\\pfe\\projet\\cv\\CV_ZAGHDOUD_Eya.pdf");
           // Path filePath = Paths.get(NewCandidaturesController.selectedCandidature.getCv());
            
            //URL u = new URL(NewCandidaturesController.selectedCandidature.getCv());
//           URI uri = ClassLoader.getSystemResource("http://localhost").toURI();
    //       String mainPath = Paths.get(uri).toString();
      //     Path filePath = Paths.get(mainPath + NewCandidaturesController.selectedCandidature.getCv());
            //Path filePath = Paths.get("C:\\xampp\\htdocs\\postulitn\\cv\\" + NewCandidaturesController.selectedCandidature.getCv());
          //  Path filePath = new Path("");
          //  URL u = filePath.toUri().toURL();
          URL uc = new URL("http://localhost/postulitn/cv/"+ NewCandidaturesController.selectedCandidature.getCv());
            System.out.println(uc);
            try (InputStream inputStream = uc.openStream()) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
                }
                pdfDataCV = outputStream.toByteArray();



// Load the PDF document from the byte array using PDFBox
try (PDDocument document = Loader.loadPDF(new ByteArrayInputStream(pdfDataCV))) {
    // Create a PDF renderer and set the rendering options
    PDFRenderer renderer = new PDFRenderer(document);
    // Set the resolution of the generated image (in dots per inch)
    final float dpi = 96;
    // Set the page index (0-based) to be rendered
    final int pageIndex = 0;
    // Render the PDF page as a BufferedImage
    BufferedImage image = renderer.renderImageWithDPI(pageIndex, dpi);
    // Convert the BufferedImage to a JavaFX Image
    Image fxImage = SwingFXUtils.toFXImage(image, null);

    cvImageView.setImage(fxImage);

    cvImageView.prefWidth(50);
    cvImageView.prefHeight(70);

              
}
catch (IOException ex) {
    // Handle any errors that occur while reading or rendering the PDF
}

            }
                
                catch (IOException ex) {
                         ex.getStackTrace();
            }           
    // Process the PDF data here...

        } catch (MalformedURLException e) {
            Logger.getLogger(NewCandidatureInterfaceController.class.getName()).log(Level.SEVERE, null, e);
        }

                try {
            // TODO
            System.out.println("Initializing");
            //Path filePath2 = Paths.get("D:\\pfe\\projet\\lettre de motivation.pdf");
            //Path filePath2 = Paths.get(NewCandidaturesController.selectedCandidature.getLettre());
            //Path filePath2 = Paths.get("C:\\xampp\\htdocs\\postulitn\\cv\\" + NewCandidaturesController.selectedCandidature.getLettre());
            //URI uri = ClassLoader.getSystemResource("C:\\xampp\\htdocs\\postulitn\\lettres\\").toURI();
           // String mainPath = Paths.get("C:\\xampp\\htdocs\\postulitn\\lettres\\").toString();
           //Path filePath2 = Paths.get(mainPath + NewCandidaturesController.selectedCandidature.getLettre());
            //URL u2 = filePath2.toUri().toURL();
            URL u2 = new URL("http://localhost/postulitn/lettres/"+ NewCandidaturesController.selectedCandidature.getLettre());
            System.out.println(u2);
            try (InputStream inputStream = u2.openStream()) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer2 = new byte[4096];
                int length;
                while ((length = inputStream.read(buffer2)) != -1) {
                outputStream.write(buffer2, 0, length);
                }
                pdfDataLettre = outputStream.toByteArray();



// Load the PDF document from the byte array using PDFBox
try (PDDocument document2 = Loader.loadPDF(new ByteArrayInputStream(pdfDataLettre))) {
    // Create a PDF renderer and set the rendering options
    PDFRenderer renderer2 = new PDFRenderer(document2);
    // Set the resolution of the generated image (in dots per inch)
    final float dpi = 96;
    // Set the page index (0-based) to be rendered
    final int pageIndex = 0;
    // Render the PDF page as a BufferedImage
    BufferedImage image2 = renderer2.renderImageWithDPI(pageIndex, dpi);
    // Convert the BufferedImage to a JavaFX Image
    Image fxImage2 = SwingFXUtils.toFXImage(image2, null);

    lettreImageView.setImage(fxImage2);

    lettreImageView.prefWidth(50);
    lettreImageView.prefHeight(70);

              
}
catch (IOException ex) {
    // Handle any errors that occur while reading or rendering the PDF
}

            }
                
                catch (IOException ex) {
                         ex.getStackTrace();
            }           
    // Process the PDF data here...

        } catch (MalformedURLException e) {
            Logger.getLogger(NewCandidatureInterfaceController.class.getName()).log(Level.SEVERE, null, e);
        }
        
                
        // initializing entretiens
        List<Entretien> e = es.filterByCandidature(NewCandidaturesController.selectedCandidature.getId());
        switch (e.size()) {
            case 2:

                for (Entretien ent: e) {
                    if(ent.getType().equals("Téléphone")) {
                        
                        dateEntTel.setText(dateEntTel.getText() + " " + ent.getDate()  );
                        heureEntTel.setText(heureEntTel.getText() + " " + ent.getHeure());
                        
                    }
                    else if(ent.getType().equals("Présentiel")) {
                        
                        dateEntPres.setText(dateEntPres.getText() + " " + ent.getDate() );
                        heureEntPres.setText(heureEntPres.getText() + " " + ent.getHeure() );
                        lieuEntPres.setText(lieuEntPres.getText() + " " + ent.getLieu());
                        
                    }
                }    break;
            case 1:
                if (e.get(0).getType().equals(TypeEntretien.TypeE.Présentiel.toString())) {
                    dateEntTel.setVisible(false);
                    heureEntTel.setVisible(false);
                    Label l1 = new Label("Aucun entretien par téléphone n'est programmé.");
                    l1.setStyle("-fx-text-fill: white;");
                    entTelVideHB.getChildren().add(l1);
                    dateEntPres.setText(dateEntPres.getText() + " " + e.get(0).getDate() );
                    heureEntPres.setText(heureEntPres.getText() + " " + e.get(0).getHeure() );
                    lieuEntPres.setText(lieuEntPres.getText() + " " + e.get(0).getLieu());
                   
                    
                }  if (e.get(0).getType().equals(TypeEntretien.TypeE.Téléphone.toString())) {
                    dateEntPres.setVisible(false);
                    heureEntPres.setVisible(false);
                    lieuEntPres.setVisible(false);
                    Label l2 = new Label("Aucun entretien en présentiel n'est programmé.");
                    l2.setStyle("-fx-text-fill: white;");
                    entPresVideHB.getChildren().add(l2);
                    dateEntTel.setText(dateEntTel.getText() + " " + e.get(0).getDate()  );
                    heureEntTel.setText(heureEntTel.getText() + " " + e.get(0).getHeure());
                    
                    
                }  break;
            default:
                    dateEntTel.setVisible(false);
                    heureEntTel.setVisible(false);
                    Label l1 = new Label("Aucun entretien par téléphone n'est programmé.");
                    l1.setStyle("-fx-text-fill: white;");
                    entTelVideHB.getChildren().add(l1);
                    
                    dateEntPres.setVisible(false);
                    heureEntPres.setVisible(false);
                    lieuEntPres.setVisible(false);
                    Label l2 = new Label("Aucun entretien en présentiel n'est programmé.");
                    l2.setStyle("-fx-text-fill: white;");
                    entPresVideHB.getChildren().add(l2);
                System.out.println("pas d'entretiens");
                break;
        }
        System.out.println(e);
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
    private void goToGuides(MouseEvent event) {
        mbc.goToGuides(event);
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
        mbc.goToQuiz(event);
    }

    @FXML
    private void getBiggerCv(MouseEvent event) {
        //vbox.getParent().setDisable(true);
      try (PDDocument document = Loader.loadPDF(new ByteArrayInputStream(pdfDataCV))) {
    // Create a PDF renderer and set the rendering options
    PDFRenderer renderer = new PDFRenderer(document);
    // Set the resolution of the generated image (in dots per inch)
    final float dpi = 100;
    // Set the page index (0-based) to be rendered
    final int pageIndex = 0;
    // Render the PDF page as a BufferedImage
    BufferedImage image = renderer.renderImageWithDPI(pageIndex, dpi);
    // Convert the BufferedImage to a JavaFX Image
    Image fxImage = SwingFXUtils.toFXImage(image, null);
     ImageView imageView1 = new ImageView(fxImage);
            VBox vbox1 = new VBox();
            Popup p = new Popup();
           
           
            
            //btn.setStyle("-fx-margin:10;");
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e -> {
                p.hide();
           // vbox.getParent().setDisable(false);
            }
            );
            
            // Create a HBox to hold the Label and the Close Button
            HBox hbox = new HBox(closeButton);
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            vbox1.setAlignment(Pos.CENTER);
            
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            imageView1.setFitWidth(500);
            imageView1.setFitHeight(650);
            
            vbox1.getChildren().addAll(imageView1, hbox);
            double initialScale = 1.0;
imageView1.setScaleX(initialScale);
imageView1.setScaleY(initialScale);
            imageView1.setOnScroll(e -> {
    double delta = e.getDeltaY();
    double currentScale = cvImageView.getScaleX();
    double newScale = currentScale + delta / 100.0;
    imageView1.setScaleX(newScale);
    imageView1.setScaleY(newScale);
});
            p.getContent().add(vbox1);
            
            
            
            // p.getContent().add(imageView);
            Stage stage = (Stage) candidatureHB.getScene().getWindow();
            p.show(stage);
        } catch (IOException ex) {
            Logger.getLogger(NewCandidatureInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void getBiggerLettre(MouseEvent event) {
          //vbox.getParent().setDisable(true);
      try (PDDocument document = Loader.loadPDF(new ByteArrayInputStream(pdfDataLettre))) {
    // Create a PDF renderer and set the rendering options
    PDFRenderer renderer = new PDFRenderer(document);
    // Set the resolution of the generated image (in dots per inch)
    final float dpi = 100;
    // Set the page index (0-based) to be rendered
    final int pageIndex = 0;
    // Render the PDF page as a BufferedImage
    BufferedImage image = renderer.renderImageWithDPI(pageIndex, dpi);
    // Convert the BufferedImage to a JavaFX Image
    Image fxImage = SwingFXUtils.toFXImage(image, null);
     ImageView imageView1 = new ImageView(fxImage);
            VBox vbox1 = new VBox();
            Popup p = new Popup();
           
           
            
            //btn.setStyle("-fx-margin:10;");
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e -> {
                p.hide();
           // vbox.getParent().setDisable(false);
            }
            );
            
            // Create a HBox to hold the Label and the Close Button
            HBox hbox = new HBox(closeButton);
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            vbox1.setAlignment(Pos.CENTER);
            
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            imageView1.setFitWidth(500);
            imageView1.setFitHeight(650);
            
            vbox1.getChildren().addAll(imageView1, hbox);
            double initialScale = 1.0;
imageView1.setScaleX(initialScale);
imageView1.setScaleY(initialScale);
            imageView1.setOnScroll(e -> {
    double delta = e.getDeltaY();
    double currentScale = cvImageView.getScaleX();
    double newScale = currentScale + delta / 100.0;
    imageView1.setScaleX(newScale);
    imageView1.setScaleY(newScale);
});
            p.getContent().add(vbox1);
            
            
            
            // p.getContent().add(imageView);
            Stage stage = (Stage) candidatureHB.getScene().getWindow();
            p.show(stage);
        } catch (IOException ex) {
            Logger.getLogger(NewCandidatureInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void browseCv(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        Stage stage = (Stage) browseCvBtn.getScene().getWindow();
        cvFile = fc.showOpenDialog(stage);
        cvTF.setText(cvFile.getAbsolutePath());
         updateBtn.setDisable(false);
        //NewCandidaturesController.selectedCandidature.setCv(file.getAbsolutePath());
        /*NewCandidaturesController.cs.updateCandidature(NewCandidaturesController.selectedCandidature.getId(),
                NewCandidaturesController.selectedCandidature);*/
       //refresh the page
    }

    @FXML
    private void browseLettre(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        Stage stage = (Stage) browseCvBtn.getScene().getWindow();
        lettreFile = fc.showOpenDialog(stage);
        lettreTF.setText(lettreFile.getAbsolutePath());
        updateBtn.setDisable(false);
        /*NewCandidaturesController.selectedCandidature.setLettre(lettreFile.getName());
        NewCandidaturesController.cs.updateCandidature(NewCandidaturesController.selectedCandidature.getId(),
                NewCandidaturesController.selectedCandidature);*/
         //refresh the page
    
    }

    @FXML
    private void goBack(ActionEvent event) {
         try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidatures.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }

    @FXML
    private void updateCandidature(ActionEvent event) {
        try {
            //NewCandidaturesController.selectedCandidature.setLettre(lettreTF.getText());
            Candidature newc = NewCandidaturesController.selectedCandidature;
            if (cvFile != null ) {
            newc.setCv(cvFile.getName()); 
             Path sourceCv = cvFile.toPath() ;
            Path destinationCv = Paths.get("C:\\xampp\\htdocs\\postulitn\\cv\\" + cvFile.getName());
            Files.copy(sourceCv, destinationCv, StandardCopyOption.REPLACE_EXISTING);
            }
            if (lettreFile != null ) {
            newc.setLettre(lettreFile.getName());
            
            Path sourceLettre = lettreFile.toPath() ;
            Path destinationLettre = Paths.get("C:\\xampp\\htdocs\\postulitn\\lettres\\" + lettreFile.getName());
            Files.copy(sourceLettre, destinationLettre, StandardCopyOption.REPLACE_EXISTING);
            }
            
            
            NewCandidaturesController.cs.updateCandidature(NewCandidaturesController.selectedCandidature.getId(),
                    newc);
            System.out.println("updated successfully");
            this.reload();
        } catch (IOException ex) {
            Logger.getLogger(NewCandidatureInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void reload() {
       try {
               
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidatureInterface.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) candidatureHB.getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }

    @FXML
    private void delete(ActionEvent event) {
        
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Etes-vous sures de vouloir supprimer ce quiz?");

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // clic sur le bouton oui
                 NewCandidaturesController.cs.deleteCandidature(NewCandidaturesController.selectedCandidature.getId());
                 System.out.println("candidature supprimée " );
                 try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidatures.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
                 
                } else {
                 // clic sur le bouton non
                 alert.close();
                }
                

    }
    
}
