/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionutilisateurs.BLL;

import gestionutilisateurs.BO.User;
import gestionutilisateurs.DAO.UserDAO;
import java.util.List;

/**
 *
 * @author USER
 */
public class UserBLL {
    
   private UserDAO manager;
    
    public UserBLL(){
        manager = new UserDAO();
    }
    
    public void ajouterutilisateur(User user){
        manager.AddUser(user);
    }
    
    public void supprimerutilisateur(int id){
        manager.DeleteUser(id);
    }
    
    public void editerutilisateur(User user){
        manager.UpdateUser(user);
    }
    
    public List affichertoututilisateur(){
        var res = manager.listUser();
        return res;
    }
}
