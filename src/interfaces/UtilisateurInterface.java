/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Utilisateur;

/**
 *
 * @author ezine
 */
public interface UtilisateurInterface {
     //add
    public void addUser(Utilisateur u);
    
    //list : select
    public List<Utilisateur> fetchUsers();
    
    //delete
    public void deleteUser (Utilisateur u);
    
    //update 
    public void updateUser(Utilisateur u, int id);
    
    //filtrage
    public List<Utilisateur> filtrerByRole (int idR);
    
    //geById
    public Utilisateur GetByIdUser (int id);
    
    //MDPOublié
    public void UpdateMdp (Utilisateur u, String nouveaumdp);
  
    //getByEmail
    public Utilisateur GetByEmail(String mail);
    
}
