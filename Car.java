/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author USER
 */



public class Car {
    protected int car_id;
    protected String brand;
    protected String model;
    protected int cylinder;
    protected double price;

    public Car() {}

    public Car(String brand, String model, int cylinder, double price) {
        this.brand = brand;
        this.model = model;
        this.cylinder = cylinder;
        this.price = price;
    }

    public Car(int car_id, String brand, String model, int cylinder, double price) {
        this.car_id = car_id;
        this.brand = brand;
        this.model = model;
        this.cylinder = cylinder;
        this.price = price;
    }

    public int getCar_id() { return car_id; }
    public void setCar_id(int car_id) { this.car_id = car_id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getCylinder() { return cylinder; }
    public void setCylinder(int cylinder) { this.cylinder = cylinder; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}