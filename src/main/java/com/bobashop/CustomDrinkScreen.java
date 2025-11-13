package com.bobashop;
import java.util.Scanner;

public class CustomDrinkScreen {
    private final Scanner scanner = new Scanner(System.in);

    public CustomBoba createCustomDrink() {

        System.out.println("\n🧋 Create Your Custom Drink!🧋");
        System.out.println("-----------------------------");
        System.out.println("1) Fruit Tea");
        System.out.println("2) Milk Tea");
        System.out.println("3) Coffee");
        System.out.println("4) Matcha");
        System.out.print("Choose a drink type: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
        } else {
            System.out.println(" Invalid choice. Please enter 1, 2, 3, or 4.\n");
        }
        return switch (choice) {
            case "1" -> buildFruitTea();
            case "2" -> buildMilkTea();
            case "3" -> buildCoffeeTea();
            case "4" -> buildMatchaTea();
            default ->{
                System.out.println("Invalid choice. Please enter 1–4.\n");
                yield null;
            }


            };

    }



// Fruit Tea
// -------------------------------------------------------
private CustomBoba buildFruitTea() {
    CustomBoba drink = new CustomBoba("Fruit Tea");
    System.out.println("\n Building your Fruit Tea...");


    String flavor = "";
    System.out.println("Available Flavors: Passion fruit, Mango, Orange, Strawberry, Watermelon");
    while (true) {
        System.out.println("\nChoose your flavor:");
        System.out.println("- Press P for Passion fruit");
        System.out.println("- Press M for Mango");
        System.out.println("- Press O for Orange");
        System.out.println("- Press S for Strawberry");
        System.out.println("- Press W for Watermelon");
        System.out.print("Enter choice: ");
        String input = scanner.nextLine().trim().toUpperCase();
        switch (input) {
            case "P" -> flavor = "Passion fruit";
            case "M" -> flavor = "Mango";
            case "O" -> flavor = "Orange";
            case "S" -> flavor = "Strawberry";
            case "W" -> flavor = "Watermelon";
            default -> {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
        }
        break;
    }
    drink.setCupSize(drink.askCupSize(scanner));
    drink.setTeaType(drink.askTeaType(scanner));
    drink.setToppings(drink.askToppings(scanner));
    drink.setSugarLevel(drink.askSugarLevel(scanner));
    drink.setIceLevel(drink.askIceLevel(scanner));
    drink.setNote(drink.askPreference(scanner));

    return drink;


}


// Milk Tea
// -------------------------------------------------------
private CustomBoba buildMilkTea() {
    CustomBoba drink = new CustomBoba("Milk tea");
    System.out.println("\n🥛 Building your Milk Tea...");
    System.out.println("Milk options ($1.00 each): Whole, Almond, Soy, Lactose-Free");
    System.out.println("- Press W : for Whole milk");
    System.out.println("- Press A : for Almond milk");
    System.out.println("- Press S : for Soy milk");
    System.out.println("- Press L : for Lactose-Free milk");
    System.out.print("Choose milk type: ");
    String milk = scanner.nextLine().trim();

    if (milk.isEmpty()) milk = "Whole";// default

    drink.setMilkType(milk);
    drink.setCupSize(drink.askCupSize(scanner));
    drink.setTeaType(drink.askTeaType(scanner));
    drink.setToppings(drink.askToppings(scanner));
    drink.setSugarLevel(drink.askSugarLevel(scanner));
    drink.setIceLevel(drink.askIceLevel(scanner));
    drink.setNote(drink.askPreference(scanner));

    return drink;


}


//Coffee
// -------------------------------------------------------
private CustomBoba buildCoffeeTea() {
    CustomBoba drink = new CustomBoba("CoffeTea");

    System.out.println("\n☕ Building your Coffee Drink...\n");
    System.out.println("Choose your coffe:");
    System.out.println("- Press A : for Americano");
    System.out.println("- Press L : for Latte");
    System.out.println("- Press C: for Cappuccino");
    String coffee = scanner.nextLine().trim().toUpperCase();

    String coffeeType = switch (coffee) {
        case "A" -> "Americano";
        case "L" -> "Latte";
        case "C" -> "Cappuccino";
        default -> "House Coffee";
    };

    System.out.println("Milk options ($1.00 each): Whole, Almond, Soy, Lactose-Free");
    System.out.println("- Press W : for Whole milk");
    System.out.println("- Press A : for Almond milk");
    System.out.println("- Press S : for Soy milk");
    System.out.println("- Press L : for Lactose-Free milk");
    System.out.println("- Press N : for None");
    System.out.print("Choose milk type: ");
    String milk = scanner.nextLine().trim();

    if(!milk.equalsIgnoreCase("N")) {
    drink.setMilkType(milk.isEmpty() ? "Whole" : milk);
} else {
        drink.setMilkType("None");
    }

    System.out.print("\nWould you like to add tea to your coffee? (Y/N): ");
    String teaAnswer = scanner.nextLine().trim().toUpperCase();

    if (teaAnswer.equals("Y") || teaAnswer.equals("YES")) {
        System.out.println("\nChoose your tea type:");
        drink.setTeaType(drink.askTeaType(scanner));
    } else {
        drink.setTeaType("None");
    }


    drink.setCupSize(drink.askCupSize(scanner));
    drink.setToppings(drink.askToppings(scanner));
    drink.setSugarLevel(drink.askSugarLevel(scanner));
    drink.setIceLevel(drink.askIceLevel(scanner));
    drink.setNote(drink.askPreference(scanner));

    return drink;
}


// Matcha
// -------------------------------------------------------
private CustomBoba buildMatchaTea() {
    CustomBoba drink = new CustomBoba("Matcha");
    System.out.println("\n🍵 Making your Matcha Drink...");


    System.out.println("\nChoose your Matcha flavor:");
    System.out.println("- Press C : for Classic Matcha");
    System.out.println("- Press S : for Strawberry Matcha");
    System.out.print("Enter choice: ");
    String input = scanner.nextLine().trim().toUpperCase();

    switch (input) {
        case "1" -> drink.setFlavor("Classic Matcha");
        case "2" -> drink.setFlavor("Strawberry Matcha");
        default -> {
            System.out.println("Invalid choice. Defaulting to Classic Matcha.");
            drink.setFlavor("Classic Matcha");
        }
    }
    drink.setCupSize(drink.askCupSize(scanner));
    drink.setToppings(drink.askToppings(scanner));
    drink.setSugarLevel(drink.askSugarLevel(scanner));
    drink.setIceLevel(drink.askIceLevel(scanner));
    drink.setNote(drink.askPreference(scanner));
    return drink;
}
}









