/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author HP I5
 */
public class QuizScore {
    private int id, score; 
    private int idCandidat;
    private Quiz quiz;
    
    // constructeurs

    public QuizScore() {
    }

    public QuizScore(int id, int idCandidat, Quiz quiz) {
        this.id = id;
        this.score = 0;
        this.idCandidat = idCandidat;
        this.quiz = quiz;
    }

    public QuizScore(int id, int score, int idCandidat, Quiz quiz) {
        this.id=id;
        this.score = score;
        this.idCandidat = idCandidat;
        this.quiz = quiz;
    }
    
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    // toString method 

    @Override
    public String toString() {
        return "QuizScore{" + "id=" + id + ", score=" + score + ", idCandidat=" + idCandidat + ", quiz=" + quiz + '}';
    }
    
    
    
}
