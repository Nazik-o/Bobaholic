package com.bobashop;

public class Toppings {
    private String name;
    private double price;
    private boolean isPremium;

    public Toppings(String name, double price, boolean isPremium) {
        this.name = name;
        this.price = price;
        this.isPremium = isPremium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", isPremium=" + isPremium +
                '}';
    }
    public static double calculateTotalPrice(Topping[] toppings) {
        double total = 0;
        for (Topping t : toppings) {
            total += t.getPrice();
        }
        return total;
    }
}
