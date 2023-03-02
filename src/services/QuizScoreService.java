/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.QuizScoreInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Quiz;
import models.QuizQuestion;
import models.QuizScore;
import utilities.MaConnexion;
import utilities.QuizReponse;

/**
 *
 * @author HP I5
 */
public class QuizScoreService implements QuizScoreInterface{

    Connection cnx = MaConnexion.getInstance().getCnx();
    @Override
    public void addQuizScore(QuizScore score) {
        String req = "insert into quizscores (`score`, `idCandidat`, `idQuiz`) valued (?,?,?)";
        
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, score.getScore());
            ps.setInt(2, score.getIdCandidat());
            ps.setInt(3, score.getQuiz().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }

    }

    @Override
    public void calculerScore(QuizScore quizScore, QuizReponse reponses) {
       int score = 0; 
       List<String> correctResp = new ArrayList();
       for (QuizQuestion qq: quizScore.getQuiz().getQuestions()) {
          correctResp.add(qq.getReponse());
        }
       
       for(int i=0; i< quizScore.getQuiz().getQuestions().size(); i++) {
           System.out.println("start: " + score);  
        
           if (reponses.getReponses().get(i).equals(correctResp.get(i))) { 
               
               score ++;
           }
         
       }
        System.out.println("end: " +score);
       quizScore.setScore(score);
       
    }

    @Override
    public QuizScore getQuizScore(int idCandidat, Quiz quiz) {

        String req = "select * from quizscores where idCanidat = ? and idQuiz = ?";
        QuizScore qs = null; 
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idCandidat);
            ps.setInt(1, quiz.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){               
                qs = new QuizScore(rs.getInt(1), rs.getInt(2), idCandidat, quiz);
                              
            } else {
                System.out.println("Ce quiz n'a pas été passé par ce candidat.");
             }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return qs;
    }

    @Override
    public void updateQuizScore(int score, int idCandidat, Quiz quiz) {
        QuizScore qs = this.getQuizScore(idCandidat, quiz);
        if (qs != null) {
         String req = "UPDATE `quizscore` SET `score`=? WHERE idCandidat = ? and idQuiz = ?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, score);
            ps.setInt(2, idCandidat);
            ps.setInt(3, quiz.getId());
            ps.executeUpdate();
            System.out.println("Quiz score question modifié avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
        } else {
           System.out.println("Le candidat n'a pas une ancienne réponse au quiz.");
        }

    }
    
}
