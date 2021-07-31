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

    public Velo(String brand, String model, String type, String size, float wheelSize, String brakingType, int numberOfSpeed, int quantity, String color, float weight, float price, String description) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.size = size;
        this.wheelSize = wheelSize;
        this.brakingType = brakingType;
        this.numberOfSpeed = numberOfSpeed;
        this.quantity = quantity;
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }
    private String brand;
    private String model;
    private String type;
    private String size;
    private float wheelSize;
    private String brakingType;
    private int numberOfSpeed;
    private int quantity;
    private String color;
    private float weight;
    private float price;
    private String description;

    public Velo() {
    }

    public Velo(int id, int idu, String brand, String model, String type, String size, float wheelsize, String brakingtype, int numberofspeed, int quantity, String color, float weight, float price, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Velo(int idu, String text, String text0, String text1, float wheelsize, String text2, int numberofspeed, int quantity, String text3, float weight, float price, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public int getIdu() {
        return idu;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public float getWheelSize() {
        return wheelSize;
    }

    public String getBrakingType() {
        return brakingType;
    }

    public int getNumberOfSpeed() {
        return numberOfSpeed;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public float getWeight() {
        return weight;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWheelSize(float wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setBrakingType(String brakingType) {
        this.brakingType = brakingType;
    }

    public void setNumberOfSpeed(int numberOfSpeed) {
        this.numberOfSpeed = numberOfSpeed;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Velo(int idu, String brand, String model, String type, String size, float wheelSize, String brakingType, int numberOfSpeed, int quantity, String color, float weight, float price, String description) {
        this.idu = idu;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.size = size;
        this.wheelSize = wheelSize;
        this.brakingType = brakingType;
        this.numberOfSpeed = numberOfSpeed;
        this.quantity = quantity;
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Velo{" + "id=" + id + ", idu=" + idu + ", brand=" + brand + ", model=" + model + ", type=" + type + ", size=" + size + ", wheelSize=" + wheelSize + ", brakingType=" + brakingType + ", numberOfSpeed=" + numberOfSpeed + ", quantity=" + quantity + ", color=" + color + ", weight=" + weight + ", price=" + price + ", description=" + description + '}';
    }

}
