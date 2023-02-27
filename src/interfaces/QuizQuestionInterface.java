/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.QuizQuestion;

/**
 *
 * @author HP I5
 */
public interface QuizQuestionInterface {
    
    public void addQuizQuestion(QuizQuestion question);
    public void deleteQuizQuestion(int idQuestion);
    public void updateQuizQuestion(int idQuestion, QuizQuestion question);
    public List<QuizQuestion> fetchByQuiz(int idQuiz);
    public QuizQuestion getQuizQuestionById(int idQuizQuestion);
    
}
