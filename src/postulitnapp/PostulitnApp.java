/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postulitnapp;

import interfaces.RoleInterface;
import java.sql.Date;
import models.FreelancersP;
import models.Role;
import models.Utilisateur;
import services.FreelancersPService;
import services.RoleService;
import services.UtilisateurService;

/**
 *
 * @author ezine
 */
public class PostulitnApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //instances 
        
        //service init     
        RoleService rs = new RoleService();       
        UtilisateurService us = new UtilisateurService();      
        FreelancersPService fps = new FreelancersPService();
        
        //Utilisateur init
        Utilisateur u = new Utilisateur();
        
        //Role init
        Role r = new Role();
        
        //FreelancersP init 
        FreelancersP fp = new FreelancersP();
       
        
        
/*************************************  CRUD Role  *******************************************************/

        //add Role       
//        r.setDescription("Admin");
//        rs.addRole(r);

        //delete role         
//        r.setIdRole(10);
//        rs.deleteRole(r);

        // fetch roles       
//        System.out.println(rs.fetchRoles());

        //update role
//        r.setDescription("Recruteur");
//        rs.updateRole(r, 11);
        

       

/*************************************  CRUD Utilisateur  ***********************************************/

        //add Utilisateur       
//        u.setNom("Zinelabidine");
//        u.setPrenom("Eya");
//        u.setEmail("eya.zinelabidine@esprit.tn");
//        u.setMdp("test");
//        u.setDateNaissance(Date.valueOf("2001-02-07"));
//        u.setAdresse("Ennasr 1");
//        u.setTel("11111111");
//        u.setRole(rs.GetByIdRole(11));
//        us.addUser(u);
      
        //delete Utilisateur 
//        u.setId(37);
//        us.deleteUser(u);
        
        //fetch utilisateurs        
//        System.out.println(us.fetchUsers());
         
       //update utilisateur
//        u.setNom("Zaghdoud");
//        u.setPrenom("Eya");
//        u.setEmail("eya.zaghdoud@esprit.tn");
//        u.setTel("2222222");
//        u.setAdresse("Aouina");
//        u.setMdp("test");
//        u.setDateNaissance(Date.valueOf("2001-01-01"));
//        u.setRole(rs.GetByIdRole(9));
//        us.updateUser(u, 3);
      

/*************************************  CRUD FreelancersP  *******************************************************/

      //add 
//         fp.setUtilisateur(us.GetByIdUser(3));
//         fp.setIdProjet(3);
//         fps.addAffectation(fp);

      //delete 
//           fp.setUtilisateur(us.GetByIdUser(3));
//           fp.setIdProjet(3);
//           fps.deleteAffectation(fp);




/*************************************  GetById  *******************************************************/

        //getbyid role        
//        System.out.println(rs.GetByIdRole(9));

       //getbyid utilisateur
//        System.out.println(us.GetByIdUser(38));

        
/*************************************  Filtrage  ******************************************************/        
      
          //filtrerbyrole
//        System.out.println(us.filtrerByRole(11));
       
          //filterbyidProjet      
//        System.out.println(fps.fetchfreelancers(0));

         
    }
    
}
