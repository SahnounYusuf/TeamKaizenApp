/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Mohamed
 */
public class DescriptionVelo extends Velo{
    private int idesc;
    private String description;
    private int idv;

    public DescriptionVelo() {
    }

    public DescriptionVelo( String description, int idv) {
        this.description = description;
        this.idv = idv;
    }

    public int getIdesc() {
        return idesc;
    }

    public String getDescription() {
        return description;
    }

    public int getIdv() {
        return idv;
    }

    public void setIdesc(int idesc) {
        this.idesc = idesc;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }
    
    

   
    
    
}
