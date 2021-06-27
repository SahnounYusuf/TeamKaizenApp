/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Toshiba
 */
public class Piece {
    
    private int idp;
    private int idu;
    private String type;
    private String nom;
    private String description;
    private String prix;

    public Piece(int idp, int idu, String type, String nom, String description, String prix) {
        this.idp = idp;
        this.idu = idu;
        this.type = type;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Piece(int idu, String type, String nom, String description, String prix) {
        this.idu = idu;
        this.type = type;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }
    
    

    public Piece(String type, String nom, String description, String prix) {
        this.type = type;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Piece() {    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    
    
    
}
