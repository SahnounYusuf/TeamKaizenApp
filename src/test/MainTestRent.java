/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Rent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.RentService;

/**
 *
 * @author Toshiba
 */
public class MainTestRent {

    public static void main(String[] args) {
        try {
            
            
            RentService rs = new RentService();
            
            // rent declaration 
            Rent r = new Rent(1, "btwin", "vtt", 22.5f, "01/01/2022", 56200452);
            Rent r1 = new Rent(1, "vtt", "btwin", 15.5f, "01/01/2000", 56200452);
            
            // rent added 
//            rs.ajouterRent(r);
//            rs.ajouterRent(r1);

            // rent delete
//            rs.supprimerRent(1);

            // rent modify 
            rs.modifierRent(2, r);
            
            // rent display
            for (Rent r2: rs.afficherRent())
            {
                System.out.println(r2);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
