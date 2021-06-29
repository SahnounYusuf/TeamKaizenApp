/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Piece;
import entities.User;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class PieceService {

    private Connection cnx;

    public PieceService() {
        cnx = MaConnection.getInstance().getCnx();
    }

    public void ajouterPiece(Piece p) throws SQLException {

        String req = "INSERT INTO piece (idu, type, nom, description, prix) VALUES "
                + "('" + p.getIdu() + "', '" + p.getType() + "', '"
                + p.getNom() + "', '" + p.getDescription() + "', '" + p.getPrix() + "');";

        Statement ste = cnx.createStatement();

        ste.executeUpdate(req);
    }

    public void modifierPiece(int idp, Piece p) throws SQLException {

        PreparedStatement pst = cnx.prepareStatement("UPDATE velo SET type=?, nom=?, description=?, prix=? WHERE idp= "+idp);
       
        pst.setString(1, p.getType());
        pst.setString(2, p.getNom());
        pst.setString(3, p.getDescription());
        pst.setString(4, p.getPrix());
        pst.executeUpdate();
        System.out.println("Piece modified!");


    }

    public boolean supprimerPiece(int id) throws SQLException {

        String sql = "DELETE FROM piece WHERE idp = " + id;

        Statement ste = cnx.createStatement();

        if (ste.executeUpdate(sql) == 1) {
            return true;
        }

        return false;
    }

    public List<Piece> afficherPiece() throws SQLException {
        List<Piece> pieces = new ArrayList<>();

        String sql = "SELECT * FROM piece";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Piece p = new Piece();

            p.setIdu(rs.getInt("idp"));
            p.setIdp(rs.getInt(2));
            p.setType(rs.getString("type"));
            p.setNom(rs.getString("nom"));
            p.setDescription(rs.getString("description"));
            p.setPrix(rs.getString("prix"));

            pieces.add(p);

        }

        return pieces;
    }

    public Piece afficherPieceById(int id) throws SQLException {
        Piece piece = null;

        String sql = "SELECT * FROM piece WHERE idp = " + id;

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            piece = new Piece();

            piece.setIdu(rs.getInt("idu"));
            piece.setType(rs.getString(2));
            piece.setNom(rs.getString("nom"));
            piece.setDescription(rs.getString("description"));
            piece.setPrix(rs.getString(5));

        }

        return piece;
    }
    
    public ObservableList<Piece> retriveAllPiecesFroFX() throws SQLException {
        ObservableList pieces = FXCollections.observableArrayList();

        String sql = "SELECT * FROM piece";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Piece u = new Piece();

            u.setIdp(rs.getInt("idp"));
            u.setNom(rs.getString("nom"));
            u.setType(rs.getString("type"));
            u.setDescription(rs.getString("description"));
            u.setPrix(rs.getString("prix"));

            pieces.add(u);
        }
        return pieces;
    }
}
