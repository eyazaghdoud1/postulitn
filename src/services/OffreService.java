/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import interfaces.OffreInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Offre;
import models.Typeoffre;
import util.MyConnection;

/**
 *
 * @author Aziz Ben Guirat
 */
public class OffreService implements OffreInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
//
//    @Override
//    public void addOffre(Offre o) {
//        try {
//            String req = "INSERT INTO `offre`(`poste`, `description`, `lieu`,`entreprise`,`specialite`,`dateExpiration` ) VALUES ('"+ o.getPoste()+"','"+o.getDescription()+"','"+o.getLieu()+"','"+o.getEntreprise()+"','"+o.getSpecialite()+"','"+o.getDateExpiration()+"')";
//            Statement st = cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("Offre Added successfully!");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

    @Override
    public void addOffre(Offre o) {
       
         List <Offre> typeoffers = this.fetchOffres();
    
        boolean existe= true;
        for (int i=0; i<typeoffers.size(); i++){
            if (o.getDescription().equalsIgnoreCase(typeoffers.get(i).getDescription() )){
                existe=false;    
            }
        }
        if (existe == true){
        try {
        
            String req = "INSERT INTO offre(`poste`, `description`, `lieu`,`entreprise`,`specialite`,`dateExpiration`,`idrecruteur`,`idtype` ) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, o.getPoste());
            ps.setString(2, o.getDescription());
            ps.setString(3, o.getLieu());
            ps.setString(4, o.getEntreprise());
            ps.setString(5, o.getSpecialite());
            ps.setDate(6, o.getDateExpiration());
            ps.setInt(7, o.getIdRecruteur());
            ps.setInt(8, o.getType().getId());

            ps.executeUpdate();
            System.out.println("Offre ajoute avec succes!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

    }
    }
    @Override
    public List<Offre> fetchOffres() {
        List<Offre> offres = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM offre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Offre o = new Offre();
                o.setId(rs.getInt(1));
                o.setPoste(rs.getString(2));
                o.setDescription(rs.getString(3));
                o.setLieu(rs.getString(4));
                o.setEntreprise(rs.getString(5));
                o.setSpecialite(rs.getString(6));
                o.setDateExpiration(rs.getDate(7));
                o.setIdRecruteur(rs.getInt(8));
                String r = "SELECT * FROM typeoffre where idtype = ? ";
                PreparedStatement ps = cnx.prepareStatement(r);
                ps.setInt(1, rs.getInt(9));
                ResultSet rs1 = ps.executeQuery();
                                rs1.next();
                Typeoffre to = new Typeoffre();
                to.setId(rs1.getInt(1));
                to.setDescription(rs1.getString(2));
                o.setType(to);
                
                
                
                offres.add(o);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return offres;
    }
    
    @Override
    public void updateOffre(Offre o, int idOffre) {
   String req = "UPDATE offre SET `poste`=? ,`description`=?,`lieu`=?, `entreprise`=?,`specialite`=?,`dateExpiration`=?,`idrecruteur`=?,`idtype`=? WHERE idoffre = ? ";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,o.getPoste());
            ps.setString(2,o.getDescription());
            ps.setString(3,o.getLieu());
            ps.setString(4,o.getEntreprise());
            ps.setString(5,o.getSpecialite());
            ps.setDate(6,o.getDateExpiration());
            ps.setInt(7, o.getIdRecruteur());
            ps.setInt(8,o.getType().getId());
            ps.setInt(9,idOffre);
            ps.executeUpdate();
            System.out.println("offre modifiée avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
}
    @Override
     public void deleteOffre(int idOffre){
         
         String req = "DELETE FROM offre WHERE idOffre= '"+idOffre+"'";
        
           try {
           Statement st = cnx.createStatement();
           st.executeUpdate(req);
           System.out.println("Offre supprime avec succes!!");
               
        } catch (SQLException ex) {
           ex.printStackTrace();
        }  }

    @Override
    public Offre getelementbyid(int idOffre) {
      
       Offre o = new Offre();
       

         try {
             String req = "SELECT * FROM offre where idOffre = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             
             ps.setInt(1,idOffre);
             ResultSet rs = ps.executeQuery();
             
                rs.next() ;
                o.setId(rs.getInt(1));
                o.setPoste(rs.getString(2));
                o.setDescription(rs.getString(3));
                o.setLieu(rs.getString(4));
                o.setEntreprise(rs.getString(5));
                o.setSpecialite(rs.getString(6));
                o.setDateExpiration(rs.getDate(7));
                o.setIdRecruteur(rs.getInt(8));
                String r = "SELECT * FROM typeoffre where idtype = ? ";
                PreparedStatement ps1 = cnx.prepareStatement(r);
                ps1.setInt(1, rs.getInt(9));
                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
                Typeoffre to = new Typeoffre();
                to.setId(rs1.getInt(1));
                to.setDescription(rs1.getString(2));
                o.setType(to);
         
             
             
         } catch (SQLException ex) {
              ex.printStackTrace();
             
         }
         return o;
    }
    

    @Override
    public List<Offre> filterByEntreprise(String entreprise) {
         List<Offre> OffreFiltrees = new ArrayList<>() ;
          Offre o = new Offre();
        String req = "SELECT * from offre WHERE entreprise= ? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, entreprise);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                o.setId(rs.getInt(1));
                o.setPoste(rs.getString(2));
                o.setDescription(rs.getString(3));
                o.setLieu(rs.getString(4));
                o.setEntreprise(rs.getString(5));
                o.setSpecialite(rs.getString(6));
                o.setDateExpiration(rs.getDate(7));
                o.setIdRecruteur(rs.getInt(8));
                String r = "SELECT * FROM typeoffre WHERE idtype = ? ";
                PreparedStatement ps1 = cnx.prepareStatement(r);
                ps1.setInt(1, rs.getInt(9));
                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
                Typeoffre to = new Typeoffre();
                to.setId(rs1.getInt(1));
                to.setDescription(rs1.getString(2));
                o.setType(to);
                OffreFiltrees.add(o);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return OffreFiltrees;
    }
    
    @Override
    public List<Offre> filterByDate(Date date) {
         List<Offre> entFiltres = new ArrayList<>() ;
         OffreService os = new OffreService();
         String req = "select * from offre where dateexpiration=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Offre o = new Offre();
                o.setId(rs.getInt(1));
                o.setPoste(rs.getString(2));
                o.setDescription(rs.getString(3));
                o.setLieu(rs.getString(4));
                o.setEntreprise(rs.getString(5));
                o.setSpecialite(rs.getString(6));
                o.setDateExpiration(rs.getDate(7));
                 o.setIdRecruteur(rs.getInt(8));
                String r = "SELECT * FROM typeoffre WHERE idtype = ? ";
                PreparedStatement ps1 = cnx.prepareStatement(r);
                ps1.setInt(1, rs.getInt(9));
                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
                Typeoffre to = new Typeoffre();
                to.setId(rs1.getInt(1));
                to.setDescription(rs1.getString(2));
                o.setType(to);
                entFiltres.add(o);
                
               
               
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return entFiltres;

    }

    @Override
    public Offre getelementbyDescription(String Description) {
        
         Offre o = new Offre();
       

         try {
             String req = "SELECT * FROM offre where description = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             
             ps.setString(1,Description);
             ResultSet rs = ps.executeQuery();
             
                rs.next() ;
                o.setId(rs.getInt(1));
                o.setPoste(rs.getString(2));
                o.setDescription(rs.getString(3));
                o.setLieu(rs.getString(4));
                o.setEntreprise(rs.getString(5));
                o.setSpecialite(rs.getString(6));
                o.setDateExpiration(rs.getDate(7));
                o.setIdRecruteur(rs.getInt(8));
                String r = "SELECT * FROM typeoffre where idtype = ? ";
                PreparedStatement ps1 = cnx.prepareStatement(r);
                ps1.setInt(1, rs.getInt(9));
                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
                Typeoffre to = new Typeoffre();
                to.setId(rs1.getInt(1));
                to.setDescription(rs1.getString(2));
                o.setType(to);
         
             
             
         } catch (SQLException ex) {
              ex.printStackTrace();
             
         }
         return o;
        
        
        
        
        
        
    }

    @Override
    public void deletebydes(String description) {
        String req = "DELETE FROM offre WHERE description= '"+description+"'";
        
           try {
           Statement st = cnx.createStatement();
           st.executeUpdate(req);
           System.out.println("Offre supprime avec succes!!");
               
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
       
    }
    

    @Override
    public int typeByOffre(int idtype) {
        String sql = "selEct coUnt(*) from offre where idtype ="+idtype;
   
  
      try {
              
             PreparedStatement ps = cnx.prepareStatement(sql);
             
            
             ResultSet rs = ps.executeQuery();
            int num = 0;
            while(rs.next()){
                num = (rs.getInt(1));
                return num;
 
            }
        } catch (SQLException ex) {
            
        }
        return 0 ;
    }

    @Override
    public void updateOffrebydes(Offre o, String Description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
        
        
        
        
       
        
        
