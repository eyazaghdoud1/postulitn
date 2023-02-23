/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.GuideEntretienInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.GuideEntretien;
import models.Compte;
import utilities.MyConnection;

/**
 *
 * @author dell
 */
public class GuideEntretienService implements GuideEntretienInterface {
    
//var
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addGuideEntretien(GuideEntretien ge) {
        
        try {
            
            String req = "INSERT INTO `guidesentretiens`(`domaine`, `specialite`, `support`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, ge.getDomaine());
            ps.setString(2, ge.getSpecialite());
            ps.setString(3, ge.getSupport());
            ps.executeUpdate();
            System.out.println("Guide Entretien Ajouté avec succes!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }
    
    
    
//    public void addGuideEntretien(GuideEntretien ge) {
//    try {
//        // Check if the guide entretien already exists
//        String selectQuery = "SELECT * FROM `guidesentretiens` WHERE `domaine`=? AND `specialite`=? AND `support`=?";
//        PreparedStatement selectStmt = cnx.prepareStatement(selectQuery);
//        selectStmt.setString(1, ge.getDomaine());
//        selectStmt.setString(2, ge.getSpecialite());
//        selectStmt.setString(3, ge.getSupport());
//        ResultSet rs = selectStmt.executeQuery();
//        if (rs.next()) {
//            System.out.println("Guide Entretien existe déjà!");
//            return; // Exit the method without adding the new guide entretien
//        }
//        
//        // If the guide entretien doesn't exist, add it to the database
//        String insertQuery = "INSERT INTO `guidesentretiens`(`domaine`, `specialite`, `support`) VALUES (?,?,?)";
//        PreparedStatement insertStmt = cnx.prepareStatement(insertQuery);
//        insertStmt.setString(1, ge.getDomaine());
//        insertStmt.setString(2, ge.getSpecialite());
//        insertStmt.setString(3, ge.getSupport());
//        insertStmt.executeUpdate();
//        System.out.println("Guide Entretien Ajouté avec succes!");
//        
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
//}



    
    
    
    
    

     @Override
    public List<GuideEntretien> fetchGuideEntretien() {
        List<GuideEntretien> GuideEntretiens = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM guidesentretiens";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                GuideEntretien p = new GuideEntretien();
                p.setIdguide(rs.getInt(1));
                p.setDomaine(rs.getString(2));
                p.setSpecialite(rs.getString(3));
                p.setSupport(rs.getString(4));
                
                GuideEntretiens.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return GuideEntretiens;
        }

    @Override
    public void updateGuideEntretien(int idGuide, GuideEntretien ge) {
        String req = "UPDATE `guidesentretiens` SET `domaine`=?,`specialite`=?,`support`=? WHERE idGuide=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, ge.getDomaine());
            ps.setString(2, ge.getSpecialite());
            ps.setString(3, ge.getSupport());
            ps.setInt(4, idGuide);
            ps.executeUpdate();
            System.out.println("Guide entretien modifié avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
        
        
    }
    
    //delete 
    @Override
    public void deleteGuideEntretien(GuideEntretien ge) {
        try {
            String req = "DELETE FROM guidesentretiens WHERE idguide = ?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, ge.getIdguide());
            st.executeUpdate();
            System.out.println("GuideEntretien supprimé avec succes!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
//   public List<GuideEntretien> GetByIdGuideEntretiens() {
//        List<GuideEntretien> GuideEntretiens = new ArrayList<>();
//      int idguide = 1;
//      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
//         String sql = "SELECT * FROM GuideEntretiens WHERE idGuide = ?";
//         try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, idguide);
//            try (ResultSet rs = stmt.executeQuery()) {
//               if (rs.next()) {
//                  String domaine = rs.getString("domaine");
//                  String specialite = rs.getString("specialite");
//                   String support = rs.getString("support");
//                  System.out.println("IDguide: " + idguide);
//                  System.out.println("domaine: " + domaine);
//                  System.out.println("specialite: " + specialite);
//                  System.out.println("support: " + support);
//               } else {
//                  System.out.println("No record found with IDguide: " + idguide);
//               }
//            }
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//   }
//    
//   
//   public List<GuideEntretien> FilterGuideEntretiens() {
//        List<GuideEntretien> GuideEntretiens = new ArrayList<>();
//    String domaineFilter = "Info";
//      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
//         String sql = "SELECT * FROM guideentretiens WHERE domaine LIKE ?";
//         try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, "%" + domaineFilter + "%");
//            try (ResultSet rs = stmt.executeQuery()) {
//               while (rs.next()) {
//                  int idguide = rs.getInt("idguide");
//                  String domaine = rs.getString("domaine");
//                  String specialite = rs.getString("specialite");
//                  String support = rs.getString("support");
//                  System.out.println("IDguide: " + idguide);
//                  System.out.println("domaine: " + domaine);
//                  System.out.println("specialite: " + specialite);
//                  System.out.println("support: " + support);
//                  System.out.println();
//               }
//            }
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//        return GuideEntretiens;
//   
//   }
    

    @Override
   public GuideEntretien GetByIdGuideEntretiens(int id) {
      GuideEntretien ge = new GuideEntretien();

         try {
             String req = "SELECT * FROM guidesentretiens where idguide = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1,id);
             ResultSet rs = ps.executeQuery();
             if (rs.next()){
             ge.setIdguide(rs.getInt(1));
             ge.setDomaine(rs.getString(2));
             ge.setSpecialite(rs.getString(3));
             ge.setSupport(rs.getString(4));
             }
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         return ge;
}
   
   
    @Override
   public List<GuideEntretien> filterBydomaine(String domaine) {
        List<GuideEntretien> GuideFiltres = new ArrayList<>() ;
        String req = "select * from guidesentretiens where domaine=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, domaine);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             GuideEntretien ge = new GuideEntretien();
            ge.setIdguide(rs.getInt(1));
                 ge.setDomaine(rs.getString(2));
                 ge.setSpecialite(rs.getString(3));
                 ge.setSupport(rs.getString(4));
               
                GuideFiltres.add(ge);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return GuideFiltres;
    }

   
 /*  public List<GuideEntretien> filterBydomaine(String domaine) {
    List<GuideEntretien> GuideFiltrees = new ArrayList<>();
    String req = "SELECT * FROM guideentretien WHERE domaine=?";
    try (PreparedStatement ps = cnx.prepareStatement(req)) {
        ps.setString(1, domaine);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                GuideEntretien ge = new GuideEntretien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                GuideFiltrees.add(ge);
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error while filtering guides by domain: " + ex.getMessage());
    }
    return GuideFiltrees;
}
*/
   
   @Override
    public List<GuideEntretien> filterByspecialite(String specialite) {
        List<GuideEntretien> GuideFiltres = new ArrayList<>() ;
        String req = "select * from guidesentretiens where specialite=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, specialite);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             GuideEntretien ge = new GuideEntretien();
            ge.setIdguide(rs.getInt(1));
                 ge.setDomaine(rs.getString(2));
                 ge.setSpecialite(rs.getString(3));
                 ge.setSupport(rs.getString(4));
               
                GuideFiltres.add(ge);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return GuideFiltres;
    }
   
}

