/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.QuizInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Quiz;
import models.QuizQuestion;
import utilities.MaConnexion;

/**
 *
 * @author HP I5
 */
public class QuizService implements QuizInterface{

    Connection cnx = MaConnexion.getInstance().getCnx();
    QuizQuestionService qqs = new QuizQuestionService();
    
    @Override
    public void addQuiz(Quiz quiz) {
        /* le controle ne fonctionne pas */
        if ( this.getQuizBySpecialite(quiz.getSpecialite()) == null) {
        String req = "INSERT INTO `quiz` (`secteur`, `specialite`) VALUES (?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, quiz.getSecteur());
            ps.setString(2, quiz.getSpecialite());
           for (QuizQuestion qq: quiz.getQuestions()) {
              qqs.addQuizQuestion(qq);
            }
            ps.executeUpdate();
            System.out.println("Quiz ajouté avec succès.");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        }else {
            System.out.println("Un quiz pour la specialité " + quiz.getSpecialite() + "existe déjà.");
        }
    }

    @Override
    public Quiz getQuizById(int idQuiz) {
        String req = "select * from quiz where id = ?";
        Quiz quiz = null; 
       try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idQuiz);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                quiz = new Quiz(rs.getInt(1),rs.getString(2), rs.getString(3));
                quiz.setQuestions(qqs.fetchByQuiz(idQuiz));
              
            } else {
                System.out.println("Pas de quiz avec l'id {" + idQuiz + "}.");
             }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return quiz;
    }

    @Override
    public void updateQuiz(int idQuiz, Quiz quiz) {
        Quiz q = this.getQuizById(idQuiz);
        if (q != null) {
         String req = "UPDATE `quiz` SET `secteur`=? ,`specialite`=? WHERE id = ? ";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, quiz.getSecteur());
            ps.setString(2, quiz.getSpecialite());
            ps.setInt(3, idQuiz);
            for (QuizQuestion qq: quiz.getQuestions()) {
              qqs.updateQuizQuestion(qq.getId(), qq);
            }
            
            ps.executeUpdate();
            System.out.println("Quiz modifié avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
        } else {
           System.out.println("Pas de quiz avec l'id {" + idQuiz + "}.");
        }

    }

    @Override
    public Quiz getQuizBySpecialite(String specialite) {
        String req = "select * from quiz where specialite = ?";
        Quiz quiz = null; 
       try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, specialite);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                quiz = new Quiz(rs.getInt(1),rs.getString(2), rs.getString(3));
                quiz.setQuestions(qqs.fetchByQuiz(rs.getInt(1)));
              
            } else {
                System.out.println("Pas de quiz pour la specialité {" + specialite + "}.");
             }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return quiz;

    }

    @Override
    public List<Quiz> fetchQuiz() {
        List<Quiz> qz = new ArrayList<>() ;
         String req = "SELECT * FROM quiz";
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                
                Quiz q = new Quiz(rs.getInt(1), rs.getString(2), rs.getString(3));
                q.setQuestions(qqs.fetchByQuiz(rs.getInt(1)));
                 
                qz.add(q);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return qz;
    }

    @Override
    public List<Quiz> filterQuizBySecteur(String secteur) {
        String req = "select * from quiz where secteur = ?";
        List<Quiz> q = new ArrayList<>(); 
       try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, secteur);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
               Quiz quiz = new Quiz(rs.getInt(1),rs.getString(2), rs.getString(3));
               quiz.setQuestions(qqs.fetchByQuiz(rs.getInt(1)));
               q.add(quiz);
              
            } else {
                System.out.println("Pas de quiz pour le secteur {" + secteur + "}.");
             }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return q;

    }

    @Override
    public void deleteQuiz(int quizId) 
    {
        
        Quiz quiz = this.getQuizById(quizId); 
        if (quiz != null) {
        String req = "Delete from quiz where id = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, quizId);
            ps.executeUpdate();
            System.out.println("Quiz supprimé avec succès." );
             
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        } else {
            System.out.println("Pas de quiz avec l'id {" + quizId + "}.");
        }
        
    }
    
}
