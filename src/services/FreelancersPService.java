
package services;

import interfaces.FreelancersPInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.FreelancersP;
import models.Role;
import models.Utilisateur;
import utilities.Maconnexion;

/**
 *
 * @author ezine
 */
public class FreelancersPService implements FreelancersPInterface{
    
    //var
    Connection cnx = Maconnexion.getInstance().getCnx();
    
    @Override
    public void addAffectation(FreelancersP fp) {
 
          
       try {
            String req = "INSERT INTO `freelancersp` (`id`, `idProjet`, `idUtilisateur`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, fp.getId());
            ps.setInt(2, fp.getIdProjet());
            ps.setInt(3, fp.getUtilisateur().getId());
            ps.executeUpdate();
            System.out.println("L'utilisateur " + fp.getUtilisateur().getId() + " a été ajouté au projet " + fp.getIdProjet() + " avec succès !");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } }

 

    @Override
    public void deleteAffectation(FreelancersP fp) {
        try {
            String req = "DELETE FROM freelancersp WHERE id= ?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, fp.getId());
            st.executeUpdate();
            System.out.println("L'utilisateur " + fp.getUtilisateur().getId() + " a été supprimé du projet " + fp.getIdProjet() +  " avec succès !");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Utilisateur> fetchfreelancers(int idProjet) {
        List<Utilisateur> users = new ArrayList<>();
        Utilisateur u = new Utilisateur();
       String req = "SELECT idUtilisateur FROM freelancersp WHERE idProjet = ? ";
        try {             
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,idProjet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String req2 = "SELECT * FROM utilisateur WHERE id = ? ";
                PreparedStatement ps1 = cnx.prepareStatement(req2);
                ps1.setInt(1,rs.getInt(1));
                ResultSet rs1 = ps1.executeQuery();  
                rs1.next();
                u.setId(rs1.getInt(1));
                u.setNom(rs1.getString(2));
                u.setPrenom(rs1.getString(3));
                u.setEmail(rs1.getString(4));
                u.setTel(rs1.getString(5));
                u.setAdresse(rs1.getString(6));
                u.setMdp(rs1.getString(7));
                u.setDateNaissance(rs1.getDate(8));
                String rq = "SELECT * FROM role WHERE idRole = ? ";
                PreparedStatement ps2 = cnx.prepareStatement(rq);
                ps2.setInt(1, rs1.getInt(9));
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
               Role r= new Role();
               r.setIdRole(rs2.getInt(1));
               r.setDescription(rs2.getString(2)); 
               u.setRole(r);
               users.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

 
    
    
}
