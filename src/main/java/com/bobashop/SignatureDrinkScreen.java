package com.bobashop;
import java.util.ArrayList;
import java.util.Scanner;

public class SignatureDrinkScreen extends DrinkBase {

    public SignatureDrinkScreen(String name, double price) {
        super(name, price);
    }
    public SignatureDrinkScreen() {
        super("Specialty Drink", 0.0);
    }

    public static SignatureDrinkScreen chooseSpecialtyDrink() {
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

        SignatureDrinkScreen drink;
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
    private static SignatureDrinkScreen createPassionFruitTea() {
        SignatureDrinkScreen drink = new SignatureDrinkScreen("Passion Fruit Tea", 6.75);
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
    private static SignatureDrinkScreen createBrownSugarMilkTea() {
        SignatureDrinkScreen drink = new SignatureDrinkScreen("Brown Sugar Milk Tea", 6.75);
        drink.cupSize = "Large";
        drink.milkType = "Whole Milk";
        drink.teaType = "Black Tea";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Boba");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        return drink;
    }
    private static SignatureDrinkScreen createCoffeeMilkTea() {
        SignatureDrinkScreen drink = new SignatureDrinkScreen("Coffee Milk Tea", 6.75);
        drink.cupSize = "Large";
        drink.teaType = "Black Tea";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Boba");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        return drink;
    }
    private static SignatureDrinkScreen createStrawberryMatcha() {
        SignatureDrinkScreen drink = new SignatureDrinkScreen("Strawberry Matcha", 6.75);
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

