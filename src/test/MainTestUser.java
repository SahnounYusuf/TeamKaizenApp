/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.User;
import entities.UserLog;
import services.LogService;
import services.SmsService;

/**
 *
 * @author Sahnoun Yusuf
 */
public class MainTestUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//            UserServices us = new UserServices();
//            EvtService es = new EvtService();
        LogService ls = new LogService();

//            User u1 = new User(12345679, "Mourad", "Kassass", "mourad.elkassas@esprit.tn", 52103402, "aaaaaaa");
//            User u2 = new User(12233345, "Yassin", "Nattat", "yassin.nattat@esprit.tn", 97651105, "aa");
       
        // to add users to database
//            us.addUser(u1);
//            us.addUser(u2);

//            Event e1 = new Event( "Si aymen neji", "01/01/2021", "tunis", "someone");
//            Event e2 = new Event( "aymen neji", "01/01/2022", "tunis", "someone oneafo");
        // to add events to database 
//            es.addEvent(e1);
//            es.addEvent(e2);
//        ls.addUserLog(u2);

        // to display all the user in the database
//            for (User u : us.retriveAllUsers()) {
//                System.out.println(u);
//            }
        // to display a specified user
//            System.out.println(us.retriveUserById(1));

        SmsService ss = new SmsService("56207034");
    
    }
}
