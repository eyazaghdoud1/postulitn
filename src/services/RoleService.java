/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.RoleInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import models.Role;
import models.Utilisateur;
import utilities.MaConnexion;

/**
 *
 * @author ezine
 */
public class RoleService implements RoleInterface {
    
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public void addRole(Role r) {
        List <Role> roles = this.fetchRoles();
        boolean existe= true;
        for (int i=0; i<roles.size(); i++){
            if (r.getDescription().equalsIgnoreCase(roles.get(i).getDescription())){
                existe=false;    
            }
        }
        if (existe == true){
          
       try {
            String req = "INSERT INTO `role`(`description`) VALUES (?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, r.getDescription());
            ps.executeUpdate();
            System.out.println("Role ajouté avec succès !");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } }
        else {
            System.out.println("Le Role existe déjà ! ");
        }
    }

    @Override
    public List<Role> fetchRoles() {
        List<Role> roles = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM role";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Role r = new Role();
                r.setIdRole(rs.getInt(1));
                r.setDescription(rs.getString(2));
                roles.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return roles;
    }

    @Override
    public void updateRole(Role r, int id) {
    String req = "UPDATE role SET `description`=? WHERE idRole=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, r.getDescription());
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Role modifié avec succès !");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    @Override
    public void deleteRole(Role r) {
        try {
            String req = "DELETE from role WHERE idRole = ?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, r.getIdRole());
            st.executeUpdate();
            System.out.println("Role supprimé avec succès !");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }

  
    @Override
    public Role GetByIdRole (int id) {
      Role r = new Role();

         try {
             String req = "SELECT * FROM role where idRole = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1,id);
             ResultSet rs = ps.executeQuery();
             if (rs.next()){
             r.setIdRole(rs.getInt(1));
             r.setDescription(rs.getString(2));
             }   
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         return r;
}
 @Override
    public Role GetByDescription(String desc) {
      Role r = new Role();

         try {
             String req = "SELECT * FROM role where description = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1,desc);
             ResultSet rs = ps.executeQuery();
             if (rs.next()){
             r.setIdRole(rs.getInt(1));
             r.setDescription(rs.getString(2));
             }   
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         return r;
}
    
}
