package com.bobashop;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeScreen {
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<MenuItem> currentOrder = new ArrayList<>();

    private static final String RESET = "\u001B[0m";
    private static final String ORANGE = "\u001B[38;2;255;165;0m";
    private static final String BLACK = "\u001B[30m";
    private static final String BOLD = "\u001B[1m";
    private static final String PURPLE = "\u001B[38;2;186;85;211m";
    // Optional clear-screen for aesthetics
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // 🧋 Fancy welcome screen
    public static void showWelcomeScreen() {
        clearScreen();

        System.out.println(ORANGE + BOLD);
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                                                                                         ║");
        System.out.println("║                                                                                                                                                         ║");
        System.out.println("║" + ORANGE + "                               ████▒                             ██                                                                                      " + RESET + "║");
        System.out.println("║" + ORANGE + "                              █▒░░░░███                      ███░░░██                                                                                    " + RESET + "║");
        System.out.println("║" + ORANGE + "                             ██░░░░░░░░██                 ███░░░░░░░██                                                                                   " + RESET + "║");
        System.out.println("║" + ORANGE + "                             █░░░▒██░░░░░██             ██░░░░░███░░██                                                                                   " + RESET + "║");
        System.out.println("║" + ORANGE + "                            ██░░▒░▒▒██░░░░███████████████░░░░██▒▒▒░░░█                                                                                   " + RESET + "║");
        System.out.println("║" + ORANGE + "                            ██░░▒▒▒▒▒▒█░░░░░░░░░░░░░░░░░░░░██▒▒▒▒▒░░░█                                                                                   " + RESET + "║");
        System.out.println("║" + ORANGE + "                            ██░░▒▒▒▒██░░░░░░░░░░░░░░░░░░░░░░██░▒▒▒░░██                                                                                   " + RESET + "║");
        System.out.println("║" + ORANGE + "                            ██░░▒▒██░░░░░░░░░░░░░░░░░░░░░░░░░░██▒▒░░██                                                                                   " + RESET + "║");
        System.out.println("║" + ORANGE + "                            ██░░▒█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█░░░█                                                                                    " + RESET + "║");
        System.out.println("║" + ORANGE + "                             █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██                                                                                    " + RESET + "║");
        System.out.println("║" + ORANGE + "                             ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██████                                                                                     " + RESET + "║");
        System.out.println("║" + ORANGE + "                             █░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██▒▒▒▒█                                                                                     " + RESET + "║");
        System.out.println("║" + ORANGE + "                            █▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█▒▒▒▒██                                                                                     " + RESET + "║");
        System.out.println("║" + ORANGE + "                           ██░░░░░░░░░██▓░░░░░░░░░░░░░░░░░░░█░▒▒▒▒███                                                                                    " + RESET + "║");
        System.out.println("║" + ORANGE + "                        ▒███░░░░░░░░██░░██░░░░░░░░░░░░███████▒▒▒▒██░██                                                                                   " + RESET + "║");
        System.out.println("║" + ORANGE + "                        █░░░░░░░       ░░█░  █████  ░██░░░██▒▒▒▒▒█░░░███                                                                                 " + RESET + "║");
        System.out.println("║" + ORANGE + "                         ██░░   ▒▒▒▒▒          █▒         ██▒▒▒▒██░░░░░█░                                                                                " + RESET + "║");
        System.out.println("║" + ORANGE + "                         ███    ▒▒▒▒▒      ██ ░██  █      █▒░▒▒▓█    ██                                                                                  " + RESET + "║");
        System.out.println("║" + ORANGE + "                         ░█▓                       █████ █▓▒▒▒▒██▒    █░                                                                                 " + RESET + "║");
        System.out.println("║" + ORANGE + "               █████████░  ███                  ███     ██▒▒▒▒██  ████                                                                                   " + RESET + "║");
        System.out.println("║" + ORANGE + "               █         ███ ███               █        █▒▒▒▒▒█     ██                                                                                   " + RESET + "║");
        System.out.println("║" + ORANGE + "                ██         ██   ████         ▓█   ▒██████▒▒▒▒████    ██                                                                                  " + RESET + "║");
        System.out.println("║" + ORANGE + "                 ██          ██   █████████░██▒█ ░░░░░░█▒▒░▒▒██████   ██                                                                                 " + RESET + "║");
        System.out.println("║" + ORANGE + "                 ██           █  ██░░░░░░░░█   ████▒░░░██████░░░░░░░██ █                                                                                 " + RESET + "║");
        System.out.println("║" + ORANGE + "                 ██       ░░░░████░░░░░░██░██         █████████████████▓█                                                                                " + RESET + "║");
        System.out.println("║" + ORANGE + "                 █   ░░░░░░░░░░██░░░░░░░░░█████████                     █                                                                                " + RESET + "║");
        System.out.println("║" + ORANGE + "                ██░░░░░░░░░░░░░█░░░░░░░░░░░░░░██░░░░░███████████████████                                                                                 " + RESET + "║");
        System.out.println("║" + ORANGE + "                ██░░░░░░░░░░░░██░░░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░░░█████                                                                                 " + RESET + "║");
        System.out.println("║" + ORANGE + "                ██░░░░░░░░░░░░█░░░░██░░░░░░░░░███░░░░░░░░░░░░░░░░░███░░██                                                                                " + RESET + "║");
        System.out.println("║" + ORANGE + "                ██░░░░░░░░░░░▒█░░░░░░████░░░░░███░████░░░░░░░███░░█░░░░░█                                                                                " + RESET + "║");
        System.out.println("║" + ORANGE + "                 █░░░░░░░░░░░██░░░░░████░░████ ░░░░██░░░██▓░░███░░███░██                                                                                 " + RESET + "║");
        System.out.println("║" + ORANGE + "                 ██░░░░░░░░░░██░░░░░░░░░░██░▒█ ░░██░░░░████░░░░░░░░░█                                                                                    " + RESET + "║");
        System.out.println("║" + ORANGE + "                  ██░░░░░░░░░██░░░░░░░░░░░██░█ ░████░░░░░░░░ ░███░░██                                                                                    " + RESET + "║");
        System.out.println("║" + ORANGE + "                    ██░░░░░░░▓█░░░░░░░░░░██████░░░░░ ███░░██ ░███░░█                                                                                     " + RESET + "║");
        System.out.println("║" + ORANGE + "                      ██████████░░░░░░░░██░░█░██░░▒░░███░▓███░░░░░▒█                                                                                     " + RESET + "║");
        System.out.println("║" + ORANGE + "                               ██░░░░░░░░░░░░░██░███░░░░ ░░░░██ ░░█▒                                                                                     " + RESET + "║");
        System.out.println("║" + ORANGE + "                                 ██░░░░░░░░░░░█░░░░░░░░███░░▓███░ █                                                                                      " + RESET + "║");
        System.out.println("║" + ORANGE + "                                   █████░░░░██ ███░░░░░▓█ ░░░░░░░█                                                                                       " + RESET + "║");
        System.out.println("║" + ORANGE + "                                                   █████████████                                                                                         " + RESET + "║");
        System.out.println("║                                                                                                                                                                       ║");
        System.out.println("║" + PURPLE + BOLD + "         ██▒░░███  ███▓▒███  ██░░▒██▓   ██▒██   ██▓█  ████  ███░███  ████    ███▒ ░██░░███                                                               " + RESET + "║");
        System.out.println("║" + PURPLE + BOLD + "         █░░██░░████░░░░░░░███░▒█░░░█  ██░░░░█  █░░██ █░░█ █░░░░░░░███░░█▓  ██░░███░░░░░░██                                                              " + RESET + "║");
        System.out.println("║" + PURPLE + BOLD + "         █░░██░░█▓█░░█░ █░░███░░██░░█  █░░█░░░█ █░░████░░██░░▓█ ██░░██░░█▓  ██░░██░░██ ███                                                               " + RESET + "║");
        System.out.println("║" + PURPLE + BOLD + "         █░░░░░░███░░█  █░░▒██░░░░░░███░░░██░░█ █░░░░░░░░██░░█▒  █░░██░░█▓  ██░░██░░█                                                                    " + RESET + "║");
        System.out.println("║" + PURPLE + BOLD + "         █░░███░░██░░████░░███░░███░░██░░░░░░░░██░░████░░██░░░███░░░██░░██████░░██░░░█████                                                               " + RESET + "║");
        System.out.println("║" + PURPLE+ BOLD + "         █░░░░░░████░░░░░░████░░░░░░██░░░█▒░█░░██░░█▒ █░░█ █░░░░░░░█ █░░░░░░██░░█ █░░░░░░██                                                               " + RESET + "║");
        System.out.println("║" + PURPLE+ BOLD + "          ██████    ██████   ██████▒  ███    ███ ███  ███    █████    ██████ ███    █████                                                                 " + RESET + "║");
        System.out.println("║                                                                                                                                                          ║");
        System.out.println("║                                            " + ORANGE + BOLD + "🧋 Welcome to Bobaholic Ordering System 🧋" + RESET + "                                                                  ║");
        System.out.println("║                                                                                                                                                         ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println(RESET);
    }

    public void start() {
        boolean running = true;

        // Shows welcome art once
        showWelcomeScreen();


    final String PURPLE = "\u001B[38;2;186;85;211m"; // Nice lavender purple

    while (running) {

        System.out.println(PURPLE + "╔═════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(PURPLE + "║                                                         ║" + RESET);
        System.out.println(PURPLE + "║        " + ORANGE + BOLD + "WELCOME TO BOBAHOLIC" + RESET + PURPLE + "                ║" + RESET);
        System.out.println(PURPLE + "║   (>*^o^)> \uD83E\uDDCB                                                      ║" + RESET);
        System.out.println(PURPLE + "║                                                         ║" + RESET);
        System.out.println(PURPLE + "╠═════════════════════════════════════════════════════════╣" + RESET);
        System.out.println(PURPLE + "║ " + ORANGE + BOLD + "1) New Order" + RESET + PURPLE + "                                ║" + RESET);
        System.out.println(PURPLE + "║ " + ORANGE + BOLD + "0) Exit" + RESET + PURPLE + "                                     ║" + RESET);
        System.out.println(PURPLE + "╚═════════════════════════════════════════════════════════╝" + RESET);
        System.out.print(PURPLE + BOLD + "Enter your choice: " + RESET);
        String input = scanner.nextLine().trim();



        ConsoleEffect.loadingBar();
        switch (input) {
                case "1" -> {
                    startNewOrder();

                }
                case "0" -> {
                    System.out.println("\nThank you for visiting Bobaholic! Have a sweet day!" + RESET);
                    System.out.println("⋆　  ⋏   ⪩⪨ ⋏　   ⟑   ⪩⪨  ⟑     ⋆");
                    System.out.println("　  ⚞ ᴖ  ᴗ  ᴖ ⚟   ミo̶̶̷̤  ｡ o̴̶̷̤ ミ");
                    System.out.println("♡ﾟ  づ🧋ど    ♡   づ🍵ど  *♡ﾟ");

                    running = false;
                }
                default -> System.out.println("Invalid input. Please choose 1 or 0.\n" + RESET);
            }
        }
    }

    private void startNewOrder() {
        currentOrder.clear(); // start fresh
        boolean ordering = true;

        while (ordering) {
            System.out.println(".");
            System.out.println(PURPLE + "╔══════════════════════════════════════════════════════════════╗" + RESET);
            System.out.println(PURPLE + "║                    " + BOLD + ORANGE + "🧋 NEW ORDER MENU 🧋" + RESET + PURPLE + "                       ║" + RESET);
            System.out.println(PURPLE + "╚══════════════════════════════════════════════════════════════╝" + RESET);


            System.out.println(ORANGE + BOLD + "1)" + RESET + " Create Custom Drink");
            System.out.println(ORANGE + BOLD + "2)" + RESET + " Choose Specialty Drink");
            System.out.println(ORANGE + BOLD + "3)" + RESET + " Add Dessert");
            System.out.println(ORANGE + BOLD + "4)" + RESET + " Proceed to Checkout");
            System.out.println(ORANGE + BOLD + "0)" + RESET + " Cancel Order and Return Home");


            System.out.print(PURPLE + BOLD + "\nEnter your choice: " + RESET);


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
                    System.out.println("\nOrder canceled. Returning to home screen...");
                    ordering = false;
                }

                default -> System.out.println("Invalid input. Please choose between 0–4.");
            }
        }
    }
    //Starter
    public static void main(String[] args) {
        HomeScreen home = new HomeScreen();
        home.start();
    }
}


