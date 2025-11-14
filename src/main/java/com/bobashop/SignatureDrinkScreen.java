package com.bobashop;
import java.util.ArrayList;
import java.util.Scanner;

import static com.bobashop.TextStyle.PURPLE;
import static com.bobashop.TextStyle.RESET;

public class SignatureDrinkScreen extends DrinkBase {

    public SignatureDrinkScreen(String name, double price) {
        super(name, price);
    }
    public SignatureDrinkScreen() {
        super("Specialty Drink", 0.0);
    }

    public static SignatureDrinkScreen chooseSpecialtyDrink() {
        Scanner scanner = new Scanner(System.in);

        final String PURPLE = "\u001B[38;2;186;85;211m";
        final String ORANGE = "\u001B[38;2;255;165;0m";
        final String BOLD   = "\u001B[1m";
        final String RESET  = "\u001B[0m";



        System.out.println(PURPLE + "╔══════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(PURPLE + "║                   " + BOLD + "🌟 SPECIALTY DRINKS 🌟" + RESET + PURPLE + "                  ║" + RESET);
        System.out.println(PURPLE + "╚══════════════════════════════════════════════════════════════╝" + RESET);

// MENU OPTIONS
        System.out.println(ORANGE + BOLD + "1)" + RESET + " Passion Fruit Tea ............ $6.75");
        System.out.println(ORANGE + BOLD + "2)" + RESET + " Brown Sugar Milk Tea ......... $6.75");
        System.out.println(ORANGE + BOLD + "3)" + RESET + " Coffee Milk Tea .............. $6.75");
        System.out.println(ORANGE + BOLD + "4)" + RESET + " Strawberry Matcha ............ $6.75");

        System.out.print(PURPLE + BOLD + "\nChoose your specialty drink (1–4): " + RESET);

        String choice = scanner.nextLine().trim();
        ConsoleEffect.loadingBar();


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
        System.out.println(PURPLE + "──────────────────────────────────────────────────────────────" + RESET);
        SignatureDrinkScreen drink = new SignatureDrinkScreen("Passion Fruit Tea", 6.75);
        drink.cupSize = "Large";
        drink.flavor = "Passion Fruit";
        drink.teaType = "Green Tea";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Boba");
        drink.toppings.add("Lychee Jelly");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        System.out.println(PURPLE + "──────────────────────────────────────────────────────────────" + RESET);
        return drink;
    }
    private static SignatureDrinkScreen createBrownSugarMilkTea() {
        System.out.println(PURPLE + "──────────────────────────────────────────────────────────────" + RESET);
        SignatureDrinkScreen drink = new SignatureDrinkScreen("Brown Sugar Milk Tea", 6.75);

        drink.cupSize = "Large";
        drink.milkType = "Whole Milk";
        drink.teaType = "Black Tea";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Boba");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        System.out.println(PURPLE + "──────────────────────────────────────────────────────────────" + RESET);
        return drink;
    }
    private static SignatureDrinkScreen createCoffeeMilkTea() {
        System.out.println(PURPLE + "──────────────────────────────────────────────────────────────" + RESET);
        SignatureDrinkScreen drink = new SignatureDrinkScreen("Coffee Milk Tea", 6.75);
        drink.cupSize = "Large";
        drink.teaType = "Black Tea";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Boba");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        System.out.println(PURPLE + "──────────────────────────────────────────────────────────────" + RESET);
        return drink;
    }
    private static SignatureDrinkScreen createStrawberryMatcha() {
        SignatureDrinkScreen drink = new SignatureDrinkScreen("Strawberry Matcha", 6.75);
        System.out.println(PURPLE + "──────────────────────────────────────────────────────────────" + RESET);
        drink.cupSize = "Medium";
        drink.flavor = "Strawberry";
        drink.toppings = new ArrayList<>();
        drink.toppings.add("Strawberry Topping");
        drink.sugarLevel = "100%";
        drink.iceLevel = "Regular";
        System.out.println(PURPLE + "──────────────────────────────────────────────────────────────" + RESET);
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

