/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.io.IOException;
import java.util.List;
import models.Compte;
import models.GuideEntretien;

/**
 *
 * @author dell
 */
public interface CompteInterface {
     //add
    public void addCompte(Compte c);    
    //list : select
    public List<Compte> fetchComptes();
    
    //modif
    public void updateCompte(int idCompte, Compte c);
    
    //delete
    public void deleteCompte(Compte c);
     
    //read cv 
     public String readCV(String filePath) throws IOException;
}
