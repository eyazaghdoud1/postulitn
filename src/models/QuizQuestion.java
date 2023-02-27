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
public class QuizQuestion {
    private int id;
    private String question, option1, option2, option3, reponse;
    private int idQuiz;
    
    // constructeurs

    public QuizQuestion() {
    }

    public QuizQuestion(int id, String question, String option1, String option2, String option3, String reponse, int idQuiz) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.reponse = reponse;
        this.idQuiz = idQuiz;
    }

    public QuizQuestion(String question, String option1, String option2, String option3, String reponse, int idQuiz) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.reponse = reponse;
        this.idQuiz = idQuiz;
    }
    
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    // toString method

    @Override
    public String toString() {
        return "QuizQuestion{" + "id=" + id + ", question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", reponse=" + reponse + ", idQuiz=" + idQuiz + '}';
    }
    
    
    
    
    
}
