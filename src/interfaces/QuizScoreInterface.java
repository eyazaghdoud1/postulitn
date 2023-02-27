/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Quiz;
import models.QuizScore;
import utilities.QuizReponse;

/**
 *
 * @author HP I5
 */
public interface QuizScoreInterface {
    
    public void addQuizScore(QuizScore score);
    public void calculerScore(QuizScore quizScore, QuizReponse reponses);
    public QuizScore getQuizScore(int idCandidat, Quiz quiz);
    public void updateQuizScore(int score, int idCandidat, Quiz quiz);
    
}
