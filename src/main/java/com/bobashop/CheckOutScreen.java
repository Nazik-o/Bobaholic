package com.bobashop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CheckOutScreen {

    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<MenuItem> orderItems;
    private final double SALES_TAX = 0.0975; // Californian sales tax : 9.75%
    private double tipPercent = 0.0;

    public CheckOutScreen(ArrayList<MenuItem> orderItems) {
        this.orderItems = orderItems;
    }


    public void processCheckout() {
        if (orderItems.isEmpty()) {
            System.out.println("\n️ No items in your order. Returning to main menu...");
            return;
        }
//getting user information
        System.out.print("\n- Enter your name: ");
        String customerName = scanner.nextLine().trim();

        System.out.print("- Enter your phone number: ");
        String customerPhone = scanner.nextLine().trim();

        // Generate unique 4-digit order ID
        int orderId = new Random().nextInt(9000) + 1000;

        // Get current date/time
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Display order summary
        System.out.println("\n --- CHECKOUT SUMMARY 🧾 ---");
        System.out.println("Customer: " + customerName);
        System.out.println("Phone: " + customerPhone);
        System.out.println("Order ID: #" + orderId);
        System.out.println("Date/Time: " + formattedDate);
        System.out.println("-------------------------------");

        double subtotal = 0.0;
        for (MenuItem item : orderItems) {
            System.out.printf("%-30s $%.2f%n", item.getName(), item.calculatePrice());
            subtotal += item.calculatePrice();
        }

        double tax = subtotal * SALES_TAX;

        // Ask for tip, it is optional
        tipPercent = askTipPercentage();

        double tipAmount = subtotal * tipPercent;
        double total = subtotal + tax + tipAmount;

        System.out.println("-------------------------------");
        System.out.printf("Subtotal:            $%.2f%n", subtotal);
        System.out.printf("Sales Tax (9.75%%):   $%.2f%n", tax);
        System.out.printf("Tip (%.0f%%):         $%.2f%n", tipPercent * 100, tipAmount);
        System.out.printf("💰 Total:             $%.2f%n", total);
        System.out.println("-------------------------------");

        // Confirmation
        System.out.print("Confirm purchase? (Y/N): ");
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("Y") || confirm.equals("YES")) {
            System.out.println("✅ Order confirmed! Generating receipt...");
            saveReceipt(customerName, customerPhone, orderId, formattedDate, subtotal, tax, tipAmount, total);
        } else {
            System.out.println("❌ Order canceled. Returning to home screen...");
        }
    }

    private double askTipPercentage() {
        System.out.println("\nWould you like to add a tip?");
        System.out.println("1) 15%");
        System.out.println("2) 18%");
        System.out.println("3) 20%");
        System.out.println("4) Custom Amount");
        System.out.println("5) No Tip");

        System.out.print("Choose option: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> {
                return 0.15;
            }
            case "2" -> {
                return 0.18;
            }
            case "3" -> {
                return 0.20;
            }
            case "4" -> {
                System.out.print("Enter custom tip percentage (e.g., 10 for 10%): ");
                try {
                    double customTip = Double.parseDouble(scanner.nextLine().trim());
                    return customTip / 100.0;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. No tip applied.");
                    return 0.0;
                }
            }
            default -> {
                return 0.0;
            }
        }
    }

    private void saveReceipt(String name, String phone, int orderId, String date, double subtotal, double tax, double tip, double total) {
        String filename = String.format("receipts/%s-%d.txt", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")), orderId);

        try {
            //to check if our reciepts directory exists
            File receiptDir = new File("receipts");
            if (!receiptDir.exists()) {
                receiptDir.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write(" BOBAHOLIC SHOP RECEIPT \n");
                writer.write("------------------------------------------\n");
                writer.write("Customer: " + name + "\n");
                writer.write("Phone: " + phone + "\n");
                writer.write("Order ID: #" + orderId + "\n");
                writer.write("Date/Time: " + date + "\n\n");

                writer.write("Items Ordered:\n");
                for (MenuItem item : orderItems) {
                    writer.write(item.toString() + "\n\n"); // prints the detailed breakdown
                }

                writer.write("\n----------------------------------------\n");
                writer.write(String.format("Subtotal: $%.2f%n", subtotal));
                writer.write(String.format("Tax (9.75%%): $%.2f%n", tax));
                writer.write(String.format("Tip: $%.2f%n", tip));
                writer.write(String.format("TOTAL: $%.2f%n", total));
                writer.write("------------------------------------------\n");
                writer.write("Thank you for visiting \n");
                writer.write("See you again! \n");
            }
            System.out.println("\n📄 Receipt saved successfully: " + filename);
            System.out.println("\n--- RECEIPT PREVIEW ---");
            java.nio.file.Files.lines(java.nio.file.Path.of(filename)).forEach(System.out::println);

            } catch (IOException e) {
                System.out.println("❌ Error saving receipt: " + e.getMessage());
            }

    }
}

