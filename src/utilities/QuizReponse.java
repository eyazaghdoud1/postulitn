/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP I5
 */
public class QuizReponse {
    private List<String> reponses;

    public QuizReponse() {
    }

    
    public QuizReponse(List<String> reponses) {
        this.reponses = reponses;
    }


    public List<String> getReponses() {
        return reponses;
    }

    public void setReponses(List<String> reponses) {
        this.reponses = reponses;
    }

    @Override
    public String toString() {
        return "QuizReponse{" + "reponses=" + reponses + '}';
    }
    
    
}
