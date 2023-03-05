/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.QuizQuestionInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.QuizQuestion;
import utilities.MaConnexion;

/**
 *
 * @author HP I5
 */
public class QuizQuestionService implements QuizQuestionInterface{

    Connection cnx = MaConnexion.getInstance().getCnx();
    @Override
    public void addQuizQuestion(QuizQuestion question) {

        List<QuizQuestion> qst = this.fetchByQuiz(question.getIdQuiz());
        boolean existe=false;
        for (QuizQuestion q: qst) {
         if (q.getQuestion().equalsIgnoreCase(question.getQuestion()))
         {
             existe = true;
             break;
         }
         }
       if (existe == false) {  
        if (qst.size() < 5 ) {
        
        String req = "INSERT INTO `quizquestions`(`question`, `option1`, `option2`, `option3`, `reponse`, `idquiz`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getOption1());
            ps.setString(3, question.getOption2());
            ps.setString(4, question.getOption3());
            ps.setString(5, question.getReponse());
            ps.setInt(6, question.getIdQuiz());
            ps.executeUpdate();
            System.out.println("Question ajoutée avec succès au quiz: {" + question.getIdQuiz() + "}");
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        } else {
         System.out.println("Le nombre max de question pour ce quiz est atteint.");
       }
       } else {
         System.out.println("Cete question appartient déjà au quiz.");
       }
    }
      
    @Override
    public QuizQuestion getQuizQuestionById(int idQuizQuestion) {
        String req = "select * from quizquestions where id = ?";
        QuizQuestion qq = null; 
       try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idQuizQuestion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                
                qq = new QuizQuestion(idQuizQuestion, rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getInt(7));
                              
            } else {
                System.out.println("Pas de question avec l'id {" + idQuizQuestion + "}.");
             }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return qq;
    }
    @Override
    public void deleteQuizQuestion(int idQuestion) {
        
     QuizQuestion qq = this.getQuizQuestionById(idQuestion);
        if (qq != null) {
         String req = "DELETE FROM `quizquestions` WHERE id = ?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idQuestion);
            ps.executeUpdate();
            System.out.println("Question surpprimée avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
        } else {
           System.out.println("Pas de question avec l'id {" + idQuestion + "}.");
        }
    }

    @Override
    public void updateQuizQuestion(int idQuestion, QuizQuestion question) {
        QuizQuestion qq = this.getQuizQuestionById(idQuestion);
        if (qq != null) {
         String req = "UPDATE `quizquestions` SET `question`=? ,`option1`=?, `option2`=?, `option3`=?, `reponse`=?"
                 + " WHERE id = ? ";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getOption1());
            ps.setString(3, question.getOption2());
            ps.setString(4, question.getOption3());
            ps.setString(5, question.getReponse());
            ps.setInt(6, idQuestion);
            ps.executeUpdate();
            System.out.println("Quiz question modifiée avec succès.");
             System.out.println(question);
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
        } else {
           System.out.println("Pas de question avec l'id {" + idQuestion + "}.");
        }

    }

    @Override
    public List<QuizQuestion> fetchByQuiz(int idQuiz) {
         List<QuizQuestion> questions = new ArrayList<>() ;
         String req = "select * from quizquestions where idQuiz=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idQuiz);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QuizQuestion q = new QuizQuestion();
                q.setId(rs.getInt(1));
                q.setQuestion(rs.getString(2));
                q.setOption1(rs.getString(3));
                q.setOption2(rs.getString(4));
                q.setOption3(rs.getString(5));
                q.setReponse(rs.getString(6));
                q.setQuiz(rs.getInt(7));
              
                questions.add(q);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return questions;
    }
    
}
