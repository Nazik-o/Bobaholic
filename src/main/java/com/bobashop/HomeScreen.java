package com.bobashop;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeScreen {
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<MenuItem> currentOrder = new ArrayList<>();

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n==============================");
            System.out.println(" Welcome to Bobaholic!");
            System.out.println("==============================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> startNewOrder();
                case "0" -> {
                    System.out.println("\nThank you for visiting Bobaholic! Have a sweet day!");
                    running = false;
                }
                default -> System.out.println("Invalid input. Please choose 1 or 0.\n");
            }
        }
    }

    private void startNewOrder() {
        currentOrder.clear(); // start fresh
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n --- NEW ORDER ---");
            System.out.println("1) Create Custom Drink");
            System.out.println("2) Choose Specialty Drink");
            System.out.println("3) Add Dessert");
            System.out.println("4) Proceed to Checkout");
            System.out.println("0) Cancel Order and Return Home");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> {
                    CustomDrinkScreen customBuilder = new CustomDrinkScreen();
                    CustomBoba customDrink = customBuilder.createCustomDrink();
                    if (customDrink != null) {
                        currentOrder.add(customDrink);
                        System.out.println("✅ Custom drink added to order!");
                    }
                }

                case "2" -> {
                    SignatureDrinkScreen specialty = new SignatureDrinkScreen();
                    MenuItem selected = specialty.chooseSpecialtyDrink();
                    if (selected != null) {
                        currentOrder.add(selected);
                        System.out.println("✅ Specialty drink added to order!");
                    }
                }

                case "3" -> {
                    DessertScreen dessertScreen = new DessertScreen();
                    MenuItem dessert = dessertScreen.chooseDessert();
                    if (dessert != null) {
                        currentOrder.add(dessert);
                        System.out.println("✅ Dessert added to order!");
                    }
                }

                case "4" -> {
                    if (currentOrder.isEmpty()) {
                        System.out.println("You have no items in your order!");
                    } else {
                        CheckOutScreen checkout = new CheckOutScreen(currentOrder);
                        checkout.processCheckout();
                    }
                }

                case "0" -> {
                    System.out.println("\n🚫 Order canceled. Returning to home screen...");
                    ordering = false;
                }

                default -> System.out.println("❌ Invalid input. Please choose between 0–4.");
            }
        }
    }
    public static void main(String[] args) {
        HomeScreen home = new HomeScreen();
        home.start();
    }
}


