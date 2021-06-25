/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Velo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServicesVelo;

/**
 *
 * @author Mohamed
 */
public class MainTestVelo {
     public static void main(String[] args) {
        try {

            ServicesVelo sv = new ServicesVelo();

            Velo p1 = new Velo( "vtt", "2020", "velo tout terrain", 900f);
            Velo p2 = new Velo( "btwin", "2021", "velo de course", 800f);

            // to add users to database
            sv.ajouterVelo(p1);
            sv.ajouterVelo(p2);
            // to delete velo from database
//            sv.supprimerVelo(1);
            // to modify a velo
//            sv.modifierVelo(2, p1);

            // to display all the user in the database
            for (Velo p : sv.afficherVelo()) {
                System.out.println(p);
            }
            
            // to display a specified velo
//            System.out.println(sv.afficherVeloById(1));

            
        } catch (SQLException ex) {
            Logger.getLogger(MainTestUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
