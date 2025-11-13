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
    sb.append("\n------------------------------");
    sb.append("\nDrink: ").append(name);
    sb.append("\nCup Size: ").append(cupSize);
    sb.append("\nFlavor: ").append(flavor.isEmpty() ? "N/A" : flavor);
    sb.append("\nMilk: ").append(milkType.isEmpty() ? "N/A" : milkType);
    sb.append("\nTea: ").append(teaType.isEmpty() ? "N/A" : teaType);
    sb.append("\nSugar Level: ").append(sugarLevel);
    sb.append("\nIce Level: ").append(iceLevel);
    sb.append("\nToppings: ").append(toppings == null ? "None" : String.join(", ", toppings));
    if (note != null && !note.isEmpty()) sb.append("\nNote: ").append(note);


    //breakdown of costs
    double base = 0.0;
    if (name.equalsIgnoreCase("Fruit Tea")) base += 1.00;
    else if (name.equalsIgnoreCase("Milk Tea")) base += 1.00;
    else if (name.equalsIgnoreCase("Matcha")) base += 3.00;
    else if (name.equalsIgnoreCase("Coffee")) base += 2.00;

    double sizeCost = 0.0;
    if (cupSize.equalsIgnoreCase("Medium")) sizeCost += 1.00;
    else if (cupSize.equalsIgnoreCase("Large")) sizeCost += 2.50;

    double toppingCost = 0.0;
    if (toppings != null) {
        for (String t : toppings) {
            if (!t.equalsIgnoreCase("none")) toppingCost += 0.75;
        }
    }

    double hotCost = 0.0;
    if (iceLevel.equalsIgnoreCase("Hot")) hotCost += 1.00;

    double milkCost = 0.0;
    if (milkType != null && !milkType.equalsIgnoreCase("none") && !milkType.isEmpty()){
        milkCost += 1.00;
    }

    double total = calculatePrice();

    sb.append("\n------------------------------");
    sb.append(String.format("\nBase: $%.2f", base));
    sb.append(String.format("\nSize Add-on: $%.2f", sizeCost));
    if (milkCost > 0) sb.append(String.format("\nMilk: $%.2f", milkCost));
    sb.append(String.format("\nToppings: $%.2f", toppingCost));
    if (hotCost > 0) sb.append(String.format("\nHot Option: $%.2f", hotCost));
    sb.append(String.format("\n➡ Drink Total: $%.2f", total));
    sb.append("\n------------------------------");
    return sb.toString();

    }

}
