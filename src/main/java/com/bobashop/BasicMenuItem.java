package com.bobashop;

public class BasicMenuItem extends MenuItem {


    public BasicMenuItem(String name, double price) {
        super(name, price);
    }


    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", calculatePrice());
    }
}

