/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author muhamed
 */
public class post {

    private int idp;
    private int idu;
    private String description;
    private int idl;
    private String comment;
    private String postedby;

    public int getIdl() {
        return idl;
    }

    public void setIdl(int idl) {
        this.idl = idl;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }


    public int getIdp() {
        return idp;
    }

    public int getIdu() {
        return idu;
    }

    public String getDescription() {
        return description;
    }

    public int getidl() {
        return idl;
    }

    public String getComment() {
        return comment;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setidl(int Likes) {
        this.idl = idl;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "post{" + "idp=" + idp + ", idu=" + idu + ", description=" + description + ", idl=" + idl + ", comment=" + comment + '}';
    }

    public post() {
    }

    public post(int idp, int idu, String description) {
        this.idp = idp;
        this.idu = idu;
        this.description = description;
    }

    public post(int idp, int idu) {
        this.idp = idp;
        this.idu = idu;
    }

    public post(String description) {
        this.description = description;
    }

    public post(int idp, int idu, String description, int idl) {
        this.idp = idp;
        this.idu = idu;
        this.description = description;
        this.idl = idl;
    }



}
