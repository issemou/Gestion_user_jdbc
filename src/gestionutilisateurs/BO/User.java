/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionutilisateurs.BO;

/**
 *
 * @author USER
 */
public class User {
    public int id;
    public String nom;
    public String prenom;
    
    public User(int id, String nom, String prenom){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public User(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public User(){
        
    }
    
    @Override
    public boolean equals(Object obj){
        return obj.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        return hash;
    }
}
