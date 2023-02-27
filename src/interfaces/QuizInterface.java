/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Quiz;
import models.QuizQuestion;

/**
 *
 * @author HP I5
 */
public interface QuizInterface {
    
    public void addQuiz(Quiz quiz);
    public Quiz getQuizById(int idQuiz);
    public void updateQuiz(int idQuiz, Quiz quiz);
    public void deleteQuiz(int quizId);
    public Quiz getQuizBySpecialite(String specialite);
    public List<Quiz> fetchQuiz();
    
    public List<Quiz> filterQuizBySecteur(String secteur);
    
    
}
