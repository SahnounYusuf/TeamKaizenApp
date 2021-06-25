/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.User;

/**
 *
 * @author fakhreddine
 */
public class Statics {
 
    public static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Statics.currentUser = currentUser;
    }
    
    
}
