/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Models.Commentaire;
import java.util.List;

/**
 *
 * @author Users
 */
public interface CommentaireInterface {
    
    public void addCommentaire(Commentaire c); 
    public List<Commentaire> fetchCommentaire();
    public Commentaire getById(int idCommentaire);
    public void UpdateCommentaire(int id, Commentaire c);
    public List<Commentaire> filterByContenu(String Contenu); 
    public Commentaire getcommentairebyidUser(int idUser);
      
    
}
