/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Models.ProjetFreelance;
import Models.Secteur;
import java.util.List;

/**
 *
 * @author Users
 */
public interface SecteurInterface {
    
       
    //add
    public void addSecteur(Secteur s); 
   
   
    
    //select 
      public List<Secteur> fetchSecteur(); 
  
   
   //delete
   public void deleteSecteurById(Secteur s);
   
   //getbyid
 public Secteur getById(int idSecteur);
 
    //update

 public void UpdateSecteur(int id, Secteur s);
 //filtrer par description
  public List<Secteur> filterByDescription(String Des);
  
}
