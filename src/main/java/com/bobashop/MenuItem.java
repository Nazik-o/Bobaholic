package com.bobashop;

public abstract class MenuItem {
    protected String name;
    protected double price;

    public MenuItem(String name,double price){
        this.name = name;
        this.price = price;
    }
    public abstract double calculatePrice();

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", price);
    }
}
