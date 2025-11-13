package com.bobashop;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DrinkBase extends MenuItem {
    protected String cupSize;
    protected String teaType;
    protected ArrayList<String> toppings;
    protected String sugarLevel;
    protected String iceLevel;
    protected String note;
    public DrinkBase(String name, double price) {
        super(name, price);
        this.toppings = new ArrayList<>();
    }

    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public String getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(String sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public String getIceLevel() {
        return iceLevel;
    }

    public void setIceLevel(String iceLevel) {
        this.iceLevel = iceLevel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
//Cup size:

    protected String askCupSize(Scanner scanner) {
        System.out.println("\nChoose your cup size:");
        System.out.println("- Press M for Medium ($1.00)");
        System.out.println("- Press L for Large ($2.50)");
        System.out.print("Enter choice: ");

        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            switch (input) {
                case "M" -> {
                    cupSize = "Medium";
                    return cupSize;
                }
                case "L" -> {
                    cupSize = "Large";
                    return cupSize;
                }
                default -> System.out.print("Invalid choice. Please enter M or L: ");
            }
        }
    }

    //Sugar level:
    protected String askSugarLevel(Scanner scanner) {
        System.out.println("\nSugar Level Options:");
        System.out.println("  0% | 25% | 50% | 75% | 100% (default)");
        System.out.print("Enter sugar level (%): ");
        String input = scanner.nextLine().trim();


        if (input.isEmpty()) input = "100%";
        else if (!input.matches("0%|25%|50%|75%|100%")) {
            System.out.println("Invalid option. Defaulting to 100%.");
            input = "100%";
        }
        sugarLevel = input;
        return sugarLevel;
    }


//Ice level:
    protected String askIceLevel(Scanner scanner) {
        System.out.println("\nIce Level Options:");
        System.out.println("  Regular | Less Ice | No Ice | Hot (+$1.00)");
        System.out.print("Enter your choice: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) input = "Regular";
        return iceLevel;

    }
//Tea type:
    protected String askTeaType(Scanner scanner) {
        System.out.println("\nChoose tea type:");
        System.out.println("  Black | Green | Oolong" );
        System.out.print("Enter your choice: ");
        while (true) {
            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "black" -> teaType = "Black";
                case "green" -> teaType = "Green";
                case "oolong" -> teaType = "Oolong";
                default -> {
                    System.out.println(" Invalid option. Please choose: Black, Green, or Oolong.");
                    continue;
                }
            }
            return teaType;
        }
    }

//Toppings
    protected ArrayList<String> askToppings(Scanner scanner) {
        ArrayList<String> chosenToppings = new ArrayList<>();
        System.out.println("\nChoose your toppings (each $0.75, max 3).");
        System.out.println("Type 'done' when finished or 'none' for no toppings.");
        System.out.println("Available toppings:");
        System.out.println("- Boba (recommended)");
        System.out.println("- Crystal Boba");
        System.out.println("- Mini Boba");
        System.out.println("- Aiyu Jelly");
        System.out.println("- Popping Boba");
        System.out.println("- Lychee Jelly");
        System.out.println("- Milk Pudding");

        int toppingCount = 0;
        while (toppingCount < 3) {
            System.out.print("\nTopping #" + (toppingCount + 1) + ": ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("none")) {
                chosenToppings.clear();
                chosenToppings.add("None");
                break;
            }
            if (input.equalsIgnoreCase("done"))
                break;

            if (!input.isEmpty()) {
                chosenToppings.add(input);
                toppingCount++;
            } else {
                System.out.println(" Empty input, skipping.");
            }
        }

        if (chosenToppings.isEmpty()) chosenToppings.add("None");
        this.toppings = chosenToppings;
        return chosenToppings;
    }


    //Preference note:
    protected String askPreference(Scanner scanner) {
        String note = "";

        while (true) {
            System.out.print("\nWould you like to leave a note for the barista? (Y/N): ");
            String answer = scanner.nextLine().trim().toUpperCase();

            if (answer.equals("N") || answer.equals("No")) {
                // User chose not to leave a note
                return "";
            }
            else if (answer.equals("Y") || answer.equals("Yes")) {
                while (true) {
                    System.out.print("Enter your note (max 100 words): ");
                    note = scanner.nextLine().trim();

                    // If user just presses Enter, treat as no note
                    if (note.isEmpty()) {
                        return "";
                    }


                    String[] words = note.split("\\s+");
                    if (words.length > 100) {
                        System.out.println("Please keep your note under 100 words. You wrote " + words.length + ".");
                        System.out.println("Try again.\n");
                        continue; // Ask the user  again until valid,so they could correct their wording
                    }


                    System.out.println("✅ Note saved successfully!");
                    return note;
                }
            }
            else {
                System.out.println("Please answer with Y or N only.\n");
            }
        }
    }
    public abstract double calculatePrice();

}
