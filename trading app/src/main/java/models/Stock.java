/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dghai
 */
public class Stock {
    
    private String name;
    
    private double shareprice;

    private int quantity;

    public Stock(String name, double shareprice, int quantity) {
        this.name = name;
        this.shareprice = shareprice;
        this.quantity = quantity;
    }
    
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getShareprice() {
        return shareprice;
    }

    public void setShareprice(double shareprice) {
        this.shareprice = shareprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "\t" + shareprice + "\t" + quantity;
    }
    
}
