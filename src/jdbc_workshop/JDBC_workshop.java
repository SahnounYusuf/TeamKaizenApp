/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_workshop;

import java.sql.Connection;
import utils.MaConnection;

/**
 *
 * @author Sahnoun Yusuf
 */
public class JDBC_workshop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MaConnection m1 = MaConnection.getInstance();
        Connection c1 = m1.getCnx();
        
        System.out.println(c1);
    }
    
}
