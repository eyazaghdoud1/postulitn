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
import models.FreelancersP;
import models.Role;
import models.Utilisateur;
import services.AuthenticationService;
import services.FreelancersPService;
import services.RoleService;
import services.UtilisateurService;

/**
 *
 * @author ezine
 */
public class PostulitnApp {

//    private static HashMap<String, String> users = new HashMap<String, String>();
       
    public static void main(String[] args) {
        
        //instances 
        
        //service init     
        RoleService rs = new RoleService();       
        UtilisateurService us = new UtilisateurService();      
        FreelancersPService fps = new FreelancersPService();
        AuthenticationService as = new AuthenticationService();
        
        //Utilisateur init
        Utilisateur u = new Utilisateur();
        
        //Role init
        Role r = new Role();
        
        //FreelancersP init 
        FreelancersP fp = new FreelancersP();
       
        
        
        
/*************************************  CRUD Role  *******************************************************/

        //add Role       
//        r.setDescription("Candidat");
//        rs.addRole(r);

        //delete role         
//        r.setIdRole(9);
//        rs.deleteRole(r);

        // fetch roles       
//        System.out.println(rs.fetchRoles());

        //update role
//        r.setDescription("Recruteur");
//        rs.updateRole(r,12);
        

       

/*************************************  CRUD Utilisateur  ***********************************************/

        //add Utilisateur       
//        u.setNom("Ben Guirat");
//        u.setPrenom("Aziz");
//        u.setEmail("aziz.benguirat@esprit.tn");
//        u.setMdp("test1");
//        u.setDateNaissance(Date.valueOf("2001-02-02"));
//        u.setAdresse("Ariana");
//        u.setTel("11111111234");
//        u.setRole(rs.GetByIdRole(13));
//        us.addUser(u);
//      

//        u.setNom("Zinelabidine");
//        u.setPrenom("Eya");
//        u.setEmail("eya.zinelabidine@esprit.tn");
//        u.setTel("2222222");
//        u.setAdresse("Ennasr");
//        u.setMdp("test");
//        u.setDateNaissance(Date.valueOf("2001-01-01"));
//        u.setRole(rs.GetByIdRole(1));
//        us.addUser(u);


        //delete Utilisateur 
//        u.setId(38);
//        us.deleteUser(u);
//        
        //fetch utilisateurs        
//        System.out.println(us.fetchUsers());
         
       //update utilisateur
//        u.setNom("Zaghdoud");
//        u.setPrenom("Eya");
//        u.setEmail("eya.zaghdoud@esprit.tn");
//        u.setTel("2222222");
//        u.setAdresse("Aouinaaaaaaaaaa");
//        u.setMdp("test");
//        u.setDateNaissance(Date.valueOf("2001-01-01"));
//        u.setRole(rs.GetByIdRole(12));
//        us.updateUser(u, 3);
      
//

/*************************************  CRUD FreelancersP  *******************************************************/

      //add 
//         fp.setUtilisateur(us.GetByIdUser(38));
//         fp.setIdProjet(3);
//         fps.addAffectation(fp);

//      //delete 
          
//           fp.setUtilisateur(us.GetByIdUser(38));
//           fp.setIdProjet(3);
//           fps.deleteAffectation(fp);

//         System.out.println(fps.fetchfreelancers(3));




/*************************************  GetById  *******************************************************/

        //getbyid role        
//        System.out.println(rs.GetByIdRole(12));

       //getbyid utilisateur
//        System.out.println(us.GetByIdUser(38));

        
/*************************************  Filtrage  ******************************************************/        
      
          //filtrerbyrole
//        System.out.println(us.filtrerByRole(12));
       
          //filterbyidProjet      
//        System.out.println(fps.fetchfreelancers(3));

         
       

//        users.put("eya", "password123");
//        users.put("aziz", "letmein");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

//        if(as.authentification(username, password))
//        {
//            System.out.println("Authentication successful.");
//        } else {
//            System.out.println("Authentication failed.");
//        }

          
          as.authentification(username, password);
    }







    }
    

