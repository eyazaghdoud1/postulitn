
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ezine
 */
public class Maconnexion {
    //DB PARAM
    static final String URL ="jdbc:mysql://localhost:3306/postulidb";
    static final String USER ="root";
    static final String PASSWORD ="";
    
    //var
    private Connection cnx;
    //1
    static Maconnexion instance;
    
    //const
    //2
    private Maconnexion(){
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
    public static Maconnexion getInstance() {
        if(instance == null)
            instance = new Maconnexion();
        
        return instance;
    }
    
}
