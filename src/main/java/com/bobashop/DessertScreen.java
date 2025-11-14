package com.bobashop;
import java.util.ArrayList;
import java.util.Scanner;

import static com.bobashop.TextStyle.*;

public class DessertScreen {
    private static final Scanner scanner = new Scanner(System.in);
    static class DessertItem {
        private String name;
        private String flavor;
        private double price;

        public DessertItem(String name, String flavor, double price) {
            this.name = name;
            this.flavor = flavor;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + flavor + ") - $" + String.format("%.2f", price);
        }
    }

        //Dessert Menu:
        public ArrayList<DessertItem> showDessertMenu() {
            ArrayList<DessertItem> orderList = new ArrayList<>();

            System.out.println(PURPLE + "╔══════════════════════════════════════════════════════════════╗" + RESET);
            System.out.println(PURPLE + "║                      " + BOLD + "🍰 DESSERT  MENU 🍰" + RESET + PURPLE + "                      ║" + RESET);
            System.out.println(PURPLE + "╠══════════════════════════════════════════════════════════════╣" + RESET);
            System.out.println(PURPLE + "║  " + ORANGE + "1)" + RESET + " Cream Puff       - $3.00                           " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "║  " + ORANGE + "2)" + RESET + " Macaron          - $2.50                           " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "║  " + ORANGE + "3)" + RESET + " Cheesecake       - $4.00                           " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "║  " + ORANGE + "4)" + RESET + " Done (finish selection)                           " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "╚══════════════════════════════════════════════════════════════╝" + RESET);




            while (true) {
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1" -> orderList.add(selectFlavor("Cream Puff", 3.00));
                    case "2" -> orderList.add(selectFlavor("Macaron", 2.50));
                    case "3" -> orderList.add(selectFlavor("Cheesecake", 4.00));
                    case "4" -> {
                        if (orderList.isEmpty()) {
                            System.out.println("No desserts selected.");
                        } else {
                            System.out.println("\n✅ Dessert order complete!");
                        }
                        return orderList;
                    }
                    default -> System.out.print("Invalid choice. Please enter 1–4: ");
                }

                System.out.print("\nWould you like to add another dessert? (Y/N): ");
                String again = scanner.nextLine().trim().toUpperCase();
                if (!again.equals("Y")) {
                    break;
                }
                System.out.print("\nChoose another dessert (1–4): ");
            }

            return orderList;
        }

        private DessertItem selectFlavor(String dessertName, double basePrice) {
            System.out.println();
            System.out.println(PURPLE + "╔══════════════════════════════════════════════════════════╗" + RESET);
            System.out.println(PURPLE + "║                 " + BOLD + "CHOOSE YOUR FLAVOR" + RESET + PURPLE + "                 ║" + RESET);
            System.out.println(PURPLE + "║             " + ORANGE + BOLD + dessertName.toUpperCase() + RESET + PURPLE + " (Flavor Options)            ║" + RESET);
            System.out.println(PURPLE + "╠══════════════════════════════════════════════════════════╣" + RESET);

            System.out.println(PURPLE + "║  " + ORANGE + "V)" + RESET + " Vanilla                                            " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "║  " + ORANGE + "C)" + RESET + " Chocolate                                          " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "║  " + ORANGE + "T)" + RESET + " Taro                                               " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "║  " + ORANGE + "S)" + RESET + " Strawberry                                         " + PURPLE + "║" + RESET);

            System.out.println(PURPLE + "╚══════════════════════════════════════════════════════════╝" + RESET);
            System.out.print(PURPLE + BOLD + "Enter your choice: " + RESET);


            String flavor = "";
            while (true) {
                String input = scanner.nextLine().trim().toUpperCase();
                switch (input) {
                    case "V" -> flavor = "Vanilla";
                    case "C" -> flavor = "Chocolate";
                    case "T" -> flavor = "Taro";
                    case "S" -> flavor = "Strawberry";
                    default -> {
                        System.out.print("Invalid choice. Please enter V, C, T, or S: ");
                        continue;
                    }
                }
                break;
            }


            DessertItem dessert = new DessertItem(dessertName, flavor, basePrice);
            System.out.println("✅ Added: " + dessert);
            return dessert;
        }


        //Print  the summary
        public static boolean confirmDessertOrder(ArrayList<DessertItem> desserts, Scanner scanner) {
            if (desserts == null || desserts.isEmpty()) {
                System.out.println("\nNo desserts added.");
                return false;
            }
            double total = 0;

            final String PURPLE = "\u001B[38;2;186;85;211m";
            final String ORANGE = "\u001B[38;2;255;165;0m";
            final String BOLD   = "\u001B[1m";
            final String RESET  = "\u001B[0m";

            System.out.println();
            System.out.println(PURPLE + "╔══════════════════════════════════════════════════════╗" + RESET);
            System.out.println(PURPLE + "║   " + ORANGE + BOLD + "🍮  DESSERT SUMMARY  🍮" + RESET + PURPLE + "                                 ║" + RESET);
            System.out.println(PURPLE + "╚══════════════════════════════════════════════════════╝" + RESET);

            for (DessertItem item : desserts) {
                System.out.println("- " + item);
                total += item.getPrice();
            }

            System.out.println(PURPLE + "╔══════════════════════════════════════════════════════╗" + RESET);
            System.out.printf("  Dessert Total: $%.2f%n", total);
            System.out.println(PURPLE + "╚══════════════════════════════════════════════════════╝" + RESET);





            System.out.print("\nDo you confirm your dessert order? (Y/N): ");
            String confirm = scanner.nextLine().trim().toUpperCase();

            if (confirm.equals("Y") || confirm.equals("YES")) {
                System.out.println("\n✅ Your dessert order has been confirmed!");
                return true;
            } else {
                System.out.println("\n❌ Dessert order canceled. Returning to menu...");
                return false;
            }
        }


    public MenuItem chooseDessert() {
        ArrayList<DessertItem> desserts = showDessertMenu();

        if (desserts == null || desserts.isEmpty()) {
            System.out.println("No desserts selected.");
            return null;
        }

        boolean confirmed = confirmDessertOrder(desserts, scanner);
        if (!confirmed) {
            return null; // canceled order
        }

        double total = 0;
        StringBuilder summary = new StringBuilder("Desserts: ");
        for (DessertItem d : desserts) {
            total += d.getPrice();
            summary.append(d.toString()).append("; ");
        }

        return new BasicMenuItem(summary.toString(), total);
    }
}

