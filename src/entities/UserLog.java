/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Sahnoun Yusuf
 */
public class UserLog extends User {

    private int idl;
    private int idu;
    private String dateLogged;

    public UserLog() {
    }

    public UserLog(int idu) {
        this.idu = idu;
    }

    public UserLog(int idl, int idu) {
        this.idl = idl;
        this.idu = idu;
    }

    public int getIdl() {
        return idl;
    }

    public void setId(int id) {
        this.idl = id;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(String dateLogged) {
        this.dateLogged = dateLogged;
    }

}
