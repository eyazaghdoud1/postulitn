/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Users
 */
public class MaConnexion {
    

 //DB PARAM
    static final String URL ="jdbc:mysql://localhost:3306/postulidb";
    static final String USER ="root";
    static final String PASSWORD ="";
    
  
   //var
    private Connection cnx;
    //1
    static MaConnexion instance;
    
    //const
    //2
    private MaConnexion(){
        try {
            cnx = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    
      public Connection getCnx() {
        return cnx;
    }

    //3
    public static MaConnexion getInstance() {
        if(instance == null)
            instance = new MaConnexion();
        
        return instance;
    }
        
    }  
    
    
    
    
    
    
    
    
    
    
    
