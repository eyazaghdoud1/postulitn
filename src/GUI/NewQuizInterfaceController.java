/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Quiz;
import models.QuizQuestion;
import models.QuizScore;
import services.QuizScoreService;
import services.QuizService;
import utilities.QuizReponse;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewQuizInterfaceController implements Initializable {

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
    private Label quiname;
    @FXML
    private Text q1;
    @FXML
    private Text q2;
    @FXML
    private RadioButton A1;
    @FXML
    private RadioButton B1;
    @FXML
    private RadioButton C1;
    @FXML
    private Text q3;
    @FXML
    private RadioButton A2;
    @FXML
    private RadioButton B2;
    @FXML
    private RadioButton C2;
    @FXML
    private Text q4;
    @FXML
    private RadioButton A3;
    @FXML
    private RadioButton B3;
    @FXML
    private RadioButton C3;
    @FXML
    private Text q5;
    @FXML
    private RadioButton A4;
    @FXML
    private RadioButton B4;
    @FXML
    private RadioButton C4;
    @FXML
    private RadioButton A5;
    @FXML
    private RadioButton B5;
    @FXML
    private RadioButton C5;
    
    
    
    //la liste des réponses de l'utilisateur 
    QuizReponse reponse = new QuizReponse();
    
    QuizService qs = new QuizService();
    Quiz quiz = NewQuizListController.selectedQuiz;
    private final List<QuizQuestion> listeQ = quiz.getQuestions();
    
    QuizScore score = new QuizScore(1, quiz);    
    QuizScoreService scoreService = new QuizScoreService();
    
    String r1,r2,r3,r4,r5;
    @FXML
    private Button submitBtn;
    @FXML
    private Label scoreLabel;
    @FXML
    private HBox scoreHB;
    @FXML
    private Button backBtn;
    @FXML
    private VBox q1VB;
    @FXML
    private VBox q2VB;
    @FXML
    private VBox q3VB;
    @FXML
    private VBox q4VB;
    @FXML
    private VBox q5VB;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        quiname.setText(quiname.getText() + " " + quiz.getSpecialite());
        scoreHB.setVisible(false);
        setQuestion1();
        setQuestion2();
        setQuestion3();
        setQuestion4();
        setQuestion5();
        
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
    
    
    public void setQuestion1() {
        QuizQuestion q = listeQ.get(0);
        q1.setText(q.getQuestion());
        A1.setText("A : " + q.getOption1());
        B1.setText("B : " + q.getOption2());
        C1.setText("C : " + q.getOption3());
        
    }
    public void setQuestion2() {
        QuizQuestion q = listeQ.get(1);
        q2.setText(q.getQuestion());
        A2.setText("A : " + q.getOption1());
        B2.setText("B : " + q.getOption2());
        C2.setText("C : " + q.getOption3());
    }
    public void setQuestion3() {
        QuizQuestion q = listeQ.get(2);
        q3.setText(q.getQuestion());
        A3.setText("A : " + q.getOption1());
        B3.setText("B : " + q.getOption2());
        C3.setText("C : " + q.getOption3());
    }
    public void setQuestion4() {
        QuizQuestion q = listeQ.get(3);
        q4.setText(q.getQuestion());
        A4.setText("A : " + q.getOption1());
        B4.setText("B : " + q.getOption2());
        C4.setText("C : " + q.getOption3());
    }
    public void setQuestion5() {
        QuizQuestion q = listeQ.get(4);
        q5.setText(q.getQuestion());
        A5.setText("A : " + q.getOption1());
        B5.setText("B : " + q.getOption2());
        C5.setText("C : " + q.getOption3());
        
    }

    @FXML
    private void handleA1(ActionEvent event) {
        if (A1.isSelected()) {
        // do something with the selected option
        r1="A";
        System.out.println("q1: A");
        B1.setSelected(false);
        C1.setSelected(false);
    }
    }

    @FXML
    private void handleB1(ActionEvent event) {
        if (B1.isSelected()) {
        r1="B";
        System.out.println("q1: B");
        A1.setSelected(false);
        C1.setSelected(false);
        }
    }

    @FXML
    private void handleC1(ActionEvent event) {
        if (C1.isSelected()) {
        r1="C";
        System.out.println("q1: C");
        A1.setSelected(false);
        B1.setSelected(false);
        }
    }

    @FXML
    private void handleA2(ActionEvent event) {
        if (A2.isSelected()) {
        r2="A";
        System.out.println("q2: A");
        B2.setSelected(false);
        C2.setSelected(false);
        }
    }

    @FXML
    private void handleB2(ActionEvent event) {
        if (B2.isSelected()) {
        r2="B";
        System.out.println("q2: B");
        A2.setSelected(false);
        C2.setSelected(false);
        }
    }

    @FXML
    private void handleC2(ActionEvent event) {
        if (C2.isSelected()) {
        r2="C";
        System.out.println("q2: C");
        A2.setSelected(false);
        B2.setSelected(false);
        }
    }

    @FXML
    private void handleA3(ActionEvent event) {
        if (A3.isSelected()) {
        r3="A";
        System.out.println("q3: A");
        B3.setSelected(false);
        C3.setSelected(false);
        }
    }

    @FXML
    private void handleB3(ActionEvent event) {
        if (B3.isSelected()) {
        r3="B";
        System.out.println("q3: B");
        A3.setSelected(false);
        C3.setSelected(false);
        }
    }

    @FXML
    private void handleC3(ActionEvent event) {
        if (C3.isSelected()) {
        r3="C";
        System.out.println("q3: C");
        A3.setSelected(false);
        B3.setSelected(false);
        }
    }

    @FXML
    private void handleA4(ActionEvent event) {
        if (A4.isSelected()) {
        r4="A";
        System.out.println("q4: A");
        B4.setSelected(false);
        C4.setSelected(false);
        
        }
    }

    @FXML
    private void handleB4(ActionEvent event) {
        if (B4.isSelected()) {
        r4="B";
        System.out.println("q4: B");
        A4.setSelected(false);
        C4.setSelected(false);
        }
    }

    @FXML
    private void handleC4(ActionEvent event) {
        if (C4.isSelected()) {
        r4="C";
        System.out.println("q4: C");
        A4.setSelected(false);
        B4.setSelected(false);
        }
    }

    @FXML
    private void handleA5(ActionEvent event) {
        if (A5.isSelected()) {
        r5="A";
        System.out.println("q5: A");
        B5.setSelected(false);
        C5.setSelected(false);
        }
    }

    @FXML
    private void handleB5(ActionEvent event) {
        if (B5.isSelected()) {
        r5="B";
        System.out.println("q5: B");
        A5.setSelected(false);
        C5.setSelected(false);
        }
    }

    @FXML
    private void handleC5(ActionEvent event) {
        if (C5.isSelected()) {
        r5="C";
        System.out.println("q5: C");
        A5.setSelected(false);
        B5.setSelected(false);
        }
    }

    @FXML
    private void submit(ActionEvent event) {
        List<String> resps = new ArrayList<>();
        
        resps.add(r1);
        resps.add(r2);
        resps.add(r3);
        resps.add(r4);
        resps.add(r5);
        reponse.setReponses(resps);
        scoreService.calculerScore(score, reponse);
        scoreLabel.setText( score.getScore() + " / 5");
        scoreHB.setVisible(true);
        //scoreService.addQuizScore(score);
        submitBtn.setDisable(true);
        
        List<String> correctResp = new ArrayList();
        for (QuizQuestion qq: listeQ) {
          correctResp.add(qq.getReponse());
        }
       
        List<VBox> vbs = new ArrayList<>();
        vbs.add(q1VB);
        vbs.add(q2VB);
        vbs.add(q3VB);
        vbs.add(q4VB);
        vbs.add(q5VB);
        
        for (int i=0; i<correctResp.size(); i++) {
          if (resps.get(i).equals(correctResp.get(i))) {
             vbs.get(i).setStyle("-fx-background-color: green; -fx-border-radius:40;");
          } else {
             vbs.get(i).setStyle("-fx-background-color: red; -fx-border-radius:40;");
             Label answer = new Label("La réponse correcte est: " + correctResp.get(i)); 
             answer.setStyle("-fx-text-fill: white;");
             vbs.get(i).getChildren().add(answer);
          }
        }
       
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewQuizList.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }
    
    
}
