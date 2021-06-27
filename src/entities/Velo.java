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
    private String mark;
    private String model;
    private String description;
    private float price;

    public Velo(String mark, String model, String description, float price) {
        this.mark = mark;
        this.model = model;
        this.description = description;
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

    public String getDescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "velo{" + "id=" + id + ", mark=" + mark + ", model=" + model + ", description=" + description + ", price=" + price + '}';
    }

}
