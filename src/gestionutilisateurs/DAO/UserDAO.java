/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionutilisateurs.DAO;

import gestionutilisateurs.BO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class UserDAO {
    private DbManager manager;
    private Connection con ;
    private PreparedStatement req;
    private Statement stmt;
    
    public UserDAO(){
        manager = new DbManager();
        con = manager.con;
    }
    
    public void AddUser(User user){
        try {
            req = con.prepareStatement("INSERT INTO USERS(nom, prenom) VALUES(?,?)");
            req.setString(1, user.nom);
            req.setString(2, user.prenom);
            if (req.execute()== false){
                System.out.println("Insertion Complete");
            }else{
                System.out.println("Insertion Failled");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void UpdateUser(User user){
          try {
            req = con.prepareStatement("UPDATE USERS SET nom=?, prenom = ? WHERE id = ?");
            req.setString(1, user.nom);
            req.setString(2, user.prenom);
            req.setInt(3, user.id);
            if (req.execute()== false){
                System.out.println("Update Complete");
            }else{
                System.out.println("Update Failled");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteUser(int id){
          try {
            req = con.prepareStatement("DELETE FROM USERS WHERE id = ?");
            req.setInt(1, id);
             if (req.execute()== false){
                System.out.println("Delete Complete");
            }else{
                System.out.println("Delete Failled");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List listUser(){
        
        List u = new ArrayList();
        try {
            List users = new ArrayList() ;
            stmt = con.createStatement();
            ResultSet  rs =  stmt.executeQuery("SELECT * FROM users");
            while (rs.next()){
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                int id = rs.getInt("id");
                users.add(new User(id, nom,prenom));
            }
            u = users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return u;
    }
}
