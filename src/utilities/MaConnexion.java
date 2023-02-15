/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author HP I5
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* singleton */
public class MaConnexion {
    /* database credentials */
    final String URL = "jdbc:mysql://localhost:3306/postulidb"; 
    final String USERNAME= "root";
    final String PASSWORD= "";
    /* la connexion avec la bdd */
    private Connection cnx;
    /* instance static */
    static MaConnexion instance;

    /* privatisation du constructeur */ 
    private MaConnexion() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connexion établie avec succès.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }
    
    /* static getter */
    public static MaConnexion getInstance() {
     if (instance == null) {
      instance = new MaConnexion();
     }
     return instance;
    }
    
    /* getter de l'attribut cnx */
    public Connection getCnx() {
     return cnx;
    }
    
    
}

