/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import interfaces.TypeoffreInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Typeoffre;
import util.MyConnection;

/**
 *
 * @author Aziz Ben Guirat
 */
public class TypeoffreService implements TypeoffreInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addType(Typeoffre t) {
        try {
            String req = "INSERT INTO `typeoffre`(`description` ) VALUES ('"+ t.getDescription()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Offre ajoute avec succes!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addType2(Typeoffre t) {
         try {
            
            String req = "INSERT INTO `typeoffre`(`description`) VALUES (?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getDescription());
           
            ps.executeUpdate();
            System.out.println("Offre ajoute avec succes!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Typeoffre> fetchOffres() {
        List<Typeoffre> typeoffres = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM typeoffre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Typeoffre t = new Typeoffre();
                t.setId(rs.getInt(1));
                t.setDescription(rs.getString(2));
               
                
                
                
                
                typeoffres.add(t);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return typeoffres;
    }
        public void updatetypeoffre(Typeoffre t,String  s){
            String req="UPDATE typeoffre SET description = '"+t.getDescription()+"' where description='" + s + "' ";
       try {
           Statement st = cnx.createStatement();
            st.executeUpdate(req);
             System.out.println("typzOffre modifie avec succes!");
    
        } catch (SQLException ex){
         
            ex.printStackTrace();
        }

    
        }
        
    @Override
        public void deletetypeoffre(int idType){
            
            String req = "DELETE FROM typeoffre WHERE idType= '"+idType+"'";
        
           try {
           Statement st = cnx.createStatement();
           st.executeUpdate(req);
           System.out.println("typeOffre supprime avec succes!");
               
        } catch (SQLException ex) {
           ex.printStackTrace();
        }  }

    @Override
    public Typeoffre getelementbyid(int idType) {
        
     Typeoffre t = new Typeoffre();

         try {
             String req = "SELECT * FROM typeoffre where idtype = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1,idType);
             ResultSet rs = ps.executeQuery();
             if (rs.next()){
             
              t.setId(rs.getInt(1));
              t.setDescription(rs.getString(2));}
             
         } catch (SQLException ex) {
              ex.printStackTrace();
            
         
    }
         return t;
    }
      
       
}



