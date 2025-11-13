package com.bobashop;
import java.util.ArrayList;
import java.util.Scanner;

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

            System.out.println("\n Welcome to the Dessert Menu!");
            System.out.println("--------------------------------");
            System.out.println("1) Cream Puff  ($3.00)");
            System.out.println("2) Macaron    ($2.50)");
            System.out.println("3) Cheesecake ($4.00)");
            System.out.println("4) Done (no more desserts)");
            System.out.print("Choose an item (1–4): ");

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
            System.out.println("\nChoose your " + dessertName + " flavor:");
            System.out.println(" - V) Vanilla");
            System.out.println(" - C) Chocolate");
            System.out.println(" - T) Taro");
            System.out.println(" - S) Strawberry");
            System.out.print("Enter choice: ");

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
            System.out.println("\n Dessert Summary:");
            System.out.println("--------------------------------");
            for (DessertItem item : desserts) {
                System.out.println("- " + item);
                total += item.getPrice();
            }
            System.out.println("--------------------------------");
            System.out.printf("Dessert Total: $%.2f%n", total);


            System.out.print("\nDo you confirm your dessert order? (Y/N): ");
            String confirm = scanner.nextLine().trim().toUpperCase();

            if (confirm.equals("Y") || confirm.equals("YES")) {
                System.out.println("\n✅ Your dessert order has been confirmed!");
                return true;
            } else {
                System.out.println("\n❌ Dessert order canceled. Returning to menu...");
                return false; // user wants to go back
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

