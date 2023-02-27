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
            System.out.println("type Offre ajoute avec succes!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addType2(Typeoffre t) {
          List <Typeoffre> typeoffers = this.fetchOffres();
    
        boolean existe= true;
        for (int i=0; i<typeoffers.size(); i++){
            if (t.getDescription().equalsIgnoreCase(typeoffers.get(i).getDescription())){
                existe=false;    
            }
        }
        if (existe == true){
          
       
         try {
            
            String req = "INSERT INTO `typeoffre`(`description`) VALUES (?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getDescription());
           
            ps.executeUpdate();
            System.out.println("type Offre ajoute avec succes!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
    }
          else {
            System.out.println("Le description existe déjà ! ");
        }
    }
    @Override
    public List<Typeoffre> fetchOffres() {
        List<Typeoffre> typeoffres = new ArrayList<>();
        try {
            
            String req = "SELECT  * FROM typeoffre";
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
    @Override
    public List<Typeoffre> getTypeDesc() {
        List<Typeoffre> typeoffres = new ArrayList<>();
        try {
            
            String req = "SELECT typeoffre.idtype,typeoffre.description  FROM typeoffre join offre on offre.idtype=typeoffre.idtype";
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
        public void updatetypeoffre(Typeoffre t,int  idType){
            String req ="UPDATE typeoffre SET `description`=? WHERE idtype = ? ";
       try {
           PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1,t.getDescription());
            st.setInt(2,idType);
            st.executeUpdate();
            System.out.println("type Offre modifie avec succes!");
    
        } catch (SQLException ex){
         
            ex.printStackTrace();
        }

    
        }
//        public void updateOffre(Offre o, int idOffre) {
//   String req = "UPDATE offre SET `poste`=?  WHERE idoffre = ? ";
//         try {
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setString(1,o.getPoste());
//            ps.setString(2,o.getDescription());
//            ps.setString(3,o.getLieu());
//            ps.setString(4,o.getEntreprise());
//            ps.setString(5,o.getSpecialite());
//            ps.setDate(6,o.getDateExpiration());
//            ps.setInt(7, o.getIdRecruteur());
//            ps.setInt(8,o.getType().getId());
//            ps.setInt(9,idOffre);
//            ps.executeUpdate();
//            System.out.println("offre modifiée avec succès.");
//            
//         } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//         }
        
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
    @Override
    public Typeoffre getelementbydescription(String description) {
        
     Typeoffre t = new Typeoffre();

         try {
             String req = "SELECT * FROM typeoffre where description = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1,description);
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



