/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postulitnapp;

import interfaces.RoleInterface;
import java.sql.Date;
import java.util.HashMap;
import java.util.Scanner;
import javax.mail.MessagingException;
import models.FreelancersP;
import models.Role;
import models.Utilisateur;
import services.AuthenticationService;
import services.FreelancersPService;
import services.MailUtils;
import services.RoleService;
import services.UtilisateurService;

/**
 *
 * @author ezine
 */
public class PostulitnApp {

//    private static HashMap<String, String> users = new HashMap<String, String>();
       
    public static void main(String[] args) throws MessagingException {
        
        //instances 
        
        //service init     
        RoleService rs = new RoleService();       
        UtilisateurService us = new UtilisateurService();      
        FreelancersPService fps = new FreelancersPService();
        AuthenticationService as = new AuthenticationService();
        
        //Utilisateur init
        Utilisateur u = us.GetByIdUser(59);
        
        //Role init
        Role r = new Role();
        
        //FreelancersP init 
//        FreelancersP fp = new FreelancersP();
//        us.UpdateMdp(u, u.getEmail(), "zaghdoud");
//        System.out.println(u.getMdp());
//        
/*************************************  CRUD Role  *******************************************************/

        //add Role       
//        r.setDescription("Admin");
//        rs.addRole(r);

        //delete role         
//        r.setIdRole(21);
//        rs.deleteRole(r);

        // fetch roles       
//        System.out.println(rs.fetchRoles());

//        update role
//        r.setDescription("TestRecruteur");
//        rs.updateRole(r, 21);
//        

       

/*************************************  CRUD Utilisateur  ***********************************************/

        //add Utilisateur       
//        
//        u.setNom("Zaghdoud");
//        u.setPrenom("Eya");
//        u.setEmail("eya.zaghdoud@esprit.tn");
//        u.setTel("22222222");
//        u.setAdresse("Aouina");
//        u.setMdp("test");
//        u.setDateNaissance(Date.valueOf("2001-01-01"));
//        u.setRole(rs.GetByIdRole(20));
//        us.addUser(u);


        //delete Utilisateur 
//        u.setId(43);
//        us.deleteUser(u);
//        
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
//        u.setRole(rs.GetByIdRole(1));
//        us.updateUser(u, 44);
      
//

/*************************************  CRUD FreelancersP  *******************************************************/

      //add 
//         fp.setUtilisateur(us.GetByIdUser(44));
//         fp.setIdProjet(3);
//         fps.addAffectation(fp);

      //delete 
          
//           fp.setUtilisateur(us.GetByIdUser(44));
//           fp.setIdProjet(3);
//           fps.deleteAffectation(fp);

//         System.out.println(fps.fetchfreelancers(3));




/*************************************  GetById  *******************************************************/

        //getbyid role        
//        System.out.println(rs.GetByIdRole(19));

       //getbyid utilisateur
//        System.out.println(us.GetByIdUser(45));

        
/*************************************  Filtrage  ******************************************************/        
      
          //filtrerbyrole
//        System.out.println(us.filtrerByRole(19));
       
          //filterbyidProjet      
//        System.out.println(fps.fetchfreelancers(3));

         
/************************************ Authentification ************************************************/       

//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter email: ");
//        String username = scanner.nextLine();
//        System.out.println("Enter password: ");
//        String password = scanner.nextLine();
//
//        as.authentification(username, password);
//      }

//        MailUtils.SendMail("eya.zinelabidine@esprit.tn");

//         us.UpdateMdp(u, u.getEmail(), "test1");



    }
}
    

