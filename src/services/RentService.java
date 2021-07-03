/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Rent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnection;

/**
 *
 * @author Toshiba
 */
public class RentService {
    private Connection cnx;

    public RentService() {
        cnx = MaConnection.getInstance().getCnx();
    }

    public void ajouterRent(Rent p) throws SQLException {

        String req = "INSERT INTO louer (idv ,idu,marque ,model ,prix_per_hour ,date_disponibility ,phone) VALUES "
                + "('" + p.getIdv() + "', '" + p.getIdu() + "', '" + p.getMarque() + "', '" + p.getModel() + "', '" + p.getPrix_per_hour() + "', '" + p.getDate_disponibility() + "', '" + p.getPhone() + "');";

        Statement ste = cnx.createStatement();

        ste.executeUpdate(req);

    }


    public void modifierRent(int idv,Rent p) throws SQLException {
        
        PreparedStatement pst = cnx.prepareStatement("UPDATE louer SET  idv=?, idu=?, marque=?, model=?, "
                + "prix_per_hour=?, date_disponibility=?, phone=? WHERE idv= "+idv);
       
        pst.setInt(1, p.getIdv());
        pst.setInt(2, p.getIdu());
        pst.setString(3, p.getMarque());
        pst.setString(4, p.getModel());
        pst.setFloat(5, p.getPrix_per_hour());
        pst.setString(6, p.getDate_disponibility());
        pst.setInt(7, p.getPhone());
        pst.executeUpdate();
        System.out.println("Rent modified!");

    }

    public boolean supprimerRent(int idv) throws SQLException {

        String sql = "DELETE FROM louer WHERE idv = " + idv;

        Statement ste = cnx.createStatement();

        if (ste.executeUpdate(sql) == 1) {
            return true;
        }

        return false;
    }

    public List<Rent> afficherRent() throws SQLException {
        List<Rent> Rents = new ArrayList<>();

        String sql = "SELECT * FROM louer";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Rent p = new Rent();

            p.setIdv(rs.getInt("idv"));
            p.setIdu(rs.getInt("idu"));
            p.setMarque(rs.getString("marque"));
            p.setModel(rs.getString("model"));
            p.setPrix_per_hour(rs.getFloat("prix_per_hour"));
            p.setDate_disponibility(rs.getString("date_disponibility"));
            p.setPhone(rs.getInt("Phone"));

            Rents.add(p);

        }

        return Rents;
    }
    


    public Rent afficherRentByIdv(int idv) throws SQLException {
        Rent rent = null;

        String sql = "SELECT * FROM louer WHERE idv = " + idv;

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            rent = new Rent();

            rent.setIdv(rs.getInt("idv"));
            rent.setIdu(rs.getInt("idu"));
            rent.setMarque(rs.getString("marque"));
            rent.setModel(rs.getString("model"));
            rent.setPrix_per_hour(rs.getFloat("prix_per_hour"));
            rent.setDate_disponibility(rs.getString("date_disponibility"));
            rent.setPhone(rs.getInt("Phone"));

        }

        return rent;
    }
    
    public ObservableList<Rent> retrieveAllRentFroFX() throws SQLException {
        ObservableList rents = FXCollections.observableArrayList();

        String sql = "SELECT * FROM louer";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Rent r = new Rent();

            r.setIdv(rs.getInt("idv"));
            r.setIdu(rs.getInt("idu"));
            r.setMarque(rs.getString("marque"));
            r.setModel(rs.getString("model"));
            r.setPrix_per_hour(rs.getFloat("prix_per_hour"));
            r.setDate_disponibility(rs.getString("date_disponibility"));
            r.setPhone(rs.getInt("Phone"));
            rents.add(r);

        }

        return rents;
    }
    
}
