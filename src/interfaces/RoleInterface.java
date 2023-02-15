/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Role;
import models.Utilisateur;

/**
 *
 * @author ezine
 */
public interface RoleInterface {
    
    //add
    public void addRole(Role r);
    
    //list : select
    public List<Role> fetchRoles();
    
    //update
    public void updateRole(Role r, int id);
    
    //delete
    public void deleteRole (Role r);
    
    //getbyid
    public Role GetByIdRole (int id);
    
}
