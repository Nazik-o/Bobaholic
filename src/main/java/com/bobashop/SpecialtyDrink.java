package com.bobashop;
import java.util.ArrayList;
import java.util.Scanner;
public class SpecialtyDrink extends DrinkBase {
    public SpecialtyDrink(String name, double price) {
        super(name, price);
    }

    public static SpecialtyDrink chooseSpecialtyDrink() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n 🌟Specialty Drinks Menu🌟");
        System.out.println("---------------------------------------");
        System.out.println("1) Passion Fruit Tea ............ $6.75");
        System.out.println("2) Brown Sugar Milk Tea ......... $6.75");
        System.out.println("3) Coffee Milk Tea .............. $6.75");
        System.out.println("4) Strawberry Matcha ............ $6.75");
        System.out.println("---------------------------------------");
        System.out.print("Choose your specialty drink (1–4): ");

        String choice = scanner.nextLine().trim();

        SpecialtyDrink drink;
        switch (choice) {
            case "1" -> drink = createPassionFruitTea();
            case "2" -> drink = createBrownSugarMilkTea();
            case "3" -> drink = createCoffeeMilkTea();
            case "4" -> drink = createStrawberryMatcha();
            default -> {
                System.out.println("❌ Invalid choice. Returning to main menu...");
                return null;
            }
        }
        System.out.println("\nYou selected: " + drink.getName());
        System.out.println(drink);
        System.out.print("\nDo you confirm this drink? (Y/N): ");
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("Y") || confirm.equals("YES")) {
            System.out.println("Drink confirmed!");
            return drink;
        } else {
            System.out.println("Selection canceled. Returning to menu...");
            return null;
        }
    }
    private static SpecialtyDrink createPassionFruitTea() {
        SpecialtyDrink drink = new SpecialtyDrink("Passion Fruit Tea", 6.75);
        drink.cupSize = "Large";
        drink.flavor = "Passion Fruit";
        drink.teaType = "Green Tea";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Boba");
        drink.toppings.add("Lychee Jelly");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        return drink;
    }
    private static SpecialtyDrink createBrownSugarMilkTea() {
        SpecialtyDrink drink = new SpecialtyDrink("Brown Sugar Milk Tea", 6.75);
        drink.cupSize = "Large";
        drink.milkType = "Whole Milk";
        drink.teaType = "Black Tea";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Boba");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        return drink;
    }
    private static SpecialtyDrink createCoffeeMilkTea() {
        SpecialtyDrink drink = new SpecialtyDrink("Coffee Milk Tea", 6.75);
        drink.cupSize = "Large";
        drink.teaType = "Black Tea";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Boba");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        return drink;
    }
    private static SpecialtyDrink createStrawberryMatcha() {
        SpecialtyDrink drink = new SpecialtyDrink("Strawberry Matcha", 6.75);
        drink.cupSize = "Medium";
        drink.flavor = "Strawberry";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Strawberry Topping");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        return drink;
    }

    @Override
    public double calculatePrice() {
        return this.price;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------------------------------------");
        sb.append("\nDrink: ").append(name);
        sb.append("\nCup Size: ").append(cupSize);
        if (flavor != null && !flavor.isEmpty()) sb.append("\nFlavor: ").append(flavor);
        if (milkType != null && !milkType.isEmpty()) sb.append("\nMilk: ").append(milkType);
        sb.append("\nTea Type: ").append(teaType);
        sb.append("\nToppings: ").append(String.join(", ", toppings));
        sb.append("\nSugar: ").append(sugarLevel);
        sb.append("\nIce: ").append(iceLevel);
        sb.append("\nPrice: $").append(String.format("%.2f", price));
        sb.append("\n------------------------------------");
        return sb.toString();
    }

}

