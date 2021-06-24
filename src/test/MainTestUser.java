/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.UserServices;
import utils.MaConnection;

/**
 *
 * @author Sahnoun Yusuf
 */
public class MainTestUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            UserServices us = new UserServices();

            User u1 = new User(12345678, "Mourad", "Kassass", "mourad.elkassas@esprit.tn", 52103482, "mqsdkljfmlqsjfd");
            User u2 = new User(12233344, "Yassin", "Nattat", "yassin.nattat@esprit.tn", 97651005, "qsdfaaaaa");

            // to add users to database
//            us.addUser(u1);
//            us.addUser(u2);

            // to display all the user in the database
            for (User u : us.retriveAllUsers()) {
                System.out.println(u);
            }
            
            // to display a specified user
            System.out.println(us.retriveUserById(1));
            
        } catch (SQLException ex) {
            Logger.getLogger(MainTestUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
