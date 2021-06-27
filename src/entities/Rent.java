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
public class Rent {
    private int idv;
    private int idu;
    private String marque;
    private String model;
    private float prix_per_hour;
    private String date_disponibility;
    private int phone;

    public Rent(int idu, String marque, String model, float prix_per_hour, String date_disponibility, int phone) {
        this.idu = idu;
        this.marque = marque;
        this.model = model;
        this.prix_per_hour = prix_per_hour;
        this.date_disponibility = date_disponibility;
        this.phone = phone;
    }

    public int getIdv() {
        return idv;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrix_per_hour() {
        return prix_per_hour;
    }

    public void setPrix_per_hour(float prix_per_hour) {
        this.prix_per_hour = prix_per_hour;
    }

    public String getDate_disponibility() {
        return date_disponibility;
    }

    public void setDate_disponibility(String date_disponibility) {
        this.date_disponibility = date_disponibility;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Rent{" + "idv=" + idv + ", idu=" + idu + ", marque=" + marque + ", model=" + model + ", prix_per_hour=" + prix_per_hour + ", date_disponibility=" + date_disponibility + ", phone=" + phone + '}';
    }

    public Rent() {
    }

   
}
