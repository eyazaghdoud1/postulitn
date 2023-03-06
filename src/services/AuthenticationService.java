/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.AuthInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdk.nashorn.internal.ir.CatchNode;
import models.Compte;
import models.Role;
import models.Utilisateur;
import utilities.MaConnexion;

/**
 *
 * @author ezine
 */
public class AuthenticationService implements AuthInterface{
    
    //var   
    Connection cnx = MaConnexion.getInstance().getCnx();
    CompteServices compteService = new CompteServices();
    RoleService rs = new RoleService();
    public static Utilisateur userconnecte;
    public static Compte compteconnecte;
    public static Role roleconnecte;
    @Override
    
    public boolean authentification(String email, String password){
       int i=0 ;
       boolean test;
       UtilisateurService us = new UtilisateurService();
        try {
            String req ="SELECT * FROM utilisateur";
            PreparedStatement ps= cnx.prepareStatement(req);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if (email.equals(rs.getString("email"))== false){
                    i= -1;  
                }
               
                else if (Passwordutils.verifyUserPassword(password,rs.getString("mdp"),rs.getString("salt"))== false){
                    i= 0;
                    break;
                }
                else{
                    i=1;
                    break;
                }
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
          if (i==-1){
                    System.out.print("L'utilisateur n'existe pas \n");
                    test=false;
                }
                else if (i==0){
                    System.out.print("Le mot de passe est incorrect \n");
                    test=false;
                }
                else{
                    i=1;
                     System.out.print("L'utilisateur est authentifié avec succès \n");
                     test=true;
                     //sauvegarder user connecté
                     userconnecte=us.GetByEmail(email);
                     compteconnecte=compteService.getByIdUser(userconnecte.getId());
                     roleconnecte= rs.GetByIdRole(userconnecte.getRole().getIdRole());
                     
                     
                }     
           return test;
           
           
   }

    
    
         
}
  
    

