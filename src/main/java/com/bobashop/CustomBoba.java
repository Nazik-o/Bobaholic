package com.bobashop;
import java.util.ArrayList;

public class CustomBoba extends DrinkBase {

    private String flavor;
    private String milkType;


    public CustomBoba(String name, String cupSize, String flavor, String milk, String teaType,
                      String sugarLevel, String iceLevel, ArrayList<String> toppings, String note, double price) {
        super(name, price);
        this.cupSize = cupSize;
        this.flavor = flavor;
        this.milkType = milk;
        this.teaType = teaType;
        this.sugarLevel = sugarLevel;
        this.iceLevel = iceLevel;
        this.toppings = toppings;
        this.note = note;
    }

    // Simple constructor used for interactive creation
    public CustomBoba(String name) {
        super(name, 0.0); // base price calculated later
        this.flavor = "";
        this.milkType = "";
    }


    // Price Calculation

    @Override
    public double calculatePrice() {
        double total = 0.0;

        // 🧋 Cup size pricing
        if (cupSize != null) {
            if (cupSize.equalsIgnoreCase("Medium")) total += 1.00;
            else if (cupSize.equalsIgnoreCase("Large")) total += 2.50;
        }

        // ☕ Base drink pricing
        switch (name.toLowerCase()) {
            case "fruit tea" -> total += 1.00;
            case "milk tea" -> total += 1.00;
            case "matcha" -> total += 3.00;
            case "coffee" -> total += 2.00;
            default -> total += 0.0; // fallback
        }


        if (iceLevel != null && iceLevel.equalsIgnoreCase("Hot")) {
            total += 1.00;
        }


        if (toppings != null) {
            for (String topping : toppings) {
                if (!topping.equalsIgnoreCase("none")) {
                    total += 0.75;
                }
            }
        }


        if (milkType != null && !milkType.equalsIgnoreCase("none") && !milkType.isEmpty()) {
            total += 1.00;
        }

        return total;
    }

//Getters/Setters:
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }

    public String getTeaType() {
        return teaType;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

//Summary:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Custom Drink Summary:");
        sb.append("\n------------------------------------");
        sb.append("\nDrink Type: ").append(name);
        sb.append("\nCup Size: ").append(cupSize == null ? "N/A" : cupSize);
        sb.append("\nFlavor: ").append(flavor == null || flavor.isEmpty() ? "N/A" : flavor);
        sb.append("\nMilk: ").append(milkType == null || milkType.isEmpty() ? "N/A" : milkType);
        sb.append("\nTea: ").append(teaType == null || teaType.isEmpty() ? "N/A" : teaType);
        sb.append("\nSugar Level: ").append(sugarLevel == null ? "N/A" : sugarLevel);
        sb.append("\nIce Level: ").append(iceLevel == null ? "N/A" : iceLevel);
        sb.append("\nToppings: ").append((toppings == null || toppings.isEmpty()) ? "None" : String.join(", ", toppings));
        if (note != null && !note.isEmpty()) sb.append("\nBarista Note: ").append(note);
        sb.append("\nTotal Price: $").append(String.format("%.2f", calculatePrice()));
        sb.append("\n------------------------------------");
        return sb.toString();
    }
}
