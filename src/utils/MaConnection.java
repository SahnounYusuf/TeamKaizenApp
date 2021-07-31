/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sahnoun Yusuf
 */
public class MaConnection {

//    final String URL = "jdbc:mysql://51.89.167.87:4002/test";
//    final String LOGIN = "elife";
//    final String PASSWORD = "elife";
    final String URL = "jdbc:mysql://193.70.2.35:41063/pidev";
    final String LOGIN = "yassine";
    final String PASSWORD = "yassine";
    private Connection cnx;
    private static MaConnection instance; //to return a single connection per app

    private MaConnection() {
        try {
            cnx = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Connection établie avec succès");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static MaConnection getInstance() {
        if (instance == null) {
            instance = new MaConnection();
        }
        return instance;
    }

}