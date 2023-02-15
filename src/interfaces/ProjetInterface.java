/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import Models.ProjetFreelance;
import Models.Secteur;
/**
/**
 *
 * @author Users
 */
public interface ProjetInterface {
    
   //add 
    public void addProjet(ProjetFreelance p); 
    //public void addProjet2(ProjetFreelance p);
    
    
   //list: select 
   public List<ProjetFreelance> fetchProjet(); 
   
   
   //update
   public void UpdateProjet(int id, ProjetFreelance p); 
   
   
   //Delete
   public void deleteProjetById(ProjetFreelance p);
   
   public ProjetFreelance getById(int idProjet);
   
   
   //filtrer par secteur
   public List<ProjetFreelance> filterBySecteur(int idS);
   //filtrer par theme 
 public List<ProjetFreelance> filterByTheme(String theme);
 //filtrer par duree
public List<ProjetFreelance> filterByDuree(int Duree);
  
}
