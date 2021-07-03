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
public class Velo {

    private int id;
    private int idu;
    private String mark;
    private String model;
    private float price;

    public Velo(String mark, String model, float price) {
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public Velo(int idu, String mark, String model, float price) {
        this.idu = idu;
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public Velo() {
    }

    public int getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Velo{" + "id=" + id + ", idu=" + idu + ", mark=" + mark + ", model=" + model + ", price=" + price + '}';
    }
}
