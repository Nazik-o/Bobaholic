package com.bobashop;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DrinkBase extends MenuItem {
    protected String cupSize;
    protected String teaType;
    protected String flavor;
    protected String milkType;
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
    public String getFlavor() {
        return flavor;
    }
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getMilkType() {
        return milkType;
    }
    public void setMilkType(String milkType) {
        this.milkType = milkType;
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
        System.out.println("\n Choose Your Sugar Level:");
        System.out.println("· · ─ ·✶· ─ · ·· · ─ ·✶· ─ · ·");
        System.out.println("Press 1 - for 0%");
        System.out.println("Press 2 - for 25%");
        System.out.println("Press 3 - for 50%");
        System.out.println("Press 4 - for 75%");
        System.out.println("Press 5 - for 100%");
        System.out.println("· · ─ ·✶· ─ · ·· · ─ ·✶· ─ · ·");

        String sugarLevel = "";
        while (true) {
            System.out.print("Enter your choice (1–5): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> sugarLevel = "0%";
                case "2" -> sugarLevel = "25%";
                case "3" -> sugarLevel = "50%";
                case "4" -> sugarLevel = "75%";
                case "5" -> sugarLevel = "100%";
                default -> {
                    System.out.println(" Invalid input! Please choose a number between 1–5.");
                    continue;
                }
            }
            break;
        }

        this.sugarLevel = sugarLevel;
        return sugarLevel;
    }


//Ice level:
protected String askIceLevel(Scanner scanner) {
    System.out.println("\n🧊 Choose Your Ice Level: 🧊");
    System.out.println("∘₊✧──────✧₊∘∘₊✧──────✧₊∘∘₊✧──────✧₊∘");
    System.out.println("Press 1 - for Regular Ice");
    System.out.println("Press 2 - for Less Ice");
    System.out.println("Press 3 - for No Ice");
    System.out.println("Press 4 - for Hot (+$1.00)");
    System.out.println("∘₊✧──────✧₊∘∘₊✧──────✧₊∘∘₊✧──────✧₊∘");

    String iceLevel = "";
    while (true) {
        System.out.print("Enter your choice (1–4): ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> iceLevel = "Regular";
            case "2" -> iceLevel = "Less Ice";
            case "3" -> iceLevel = "No Ice";
            case "4" -> iceLevel = "Hot";
            default -> {
                System.out.println(" Invalid input! Please choose a number between 1–4.");
                continue;
            }
        }
        break;
    }

    this.iceLevel = iceLevel;
    return iceLevel;
}
//Tea type:
protected String askTeaType(Scanner scanner) {
    System.out.println("\n🍃 Choose Your Tea Type 🍃:");
    System.out.println("─── ⋆⋅☆⋅⋆ ────── ⋆⋅☆⋅⋆ ────── ⋆⋅☆⋅⋆ ───");
    System.out.println("Press 1 - for Black Tea");
    System.out.println("Press 2 - for Green Tea");
    System.out.println("Press 3 - for Oolong Tea");
    System.out.println("─── ⋆⋅☆⋅⋆ ────── ⋆⋅☆⋅⋆ ────── ⋆⋅☆⋅⋆ ───");

    String teaType = "";
    while (true) {
        System.out.print("Enter your choice (1–3): ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> teaType = "Black Tea";
            case "2" -> teaType = "Green Tea";
            case "3" -> teaType = "Oolong Tea";
            default -> {
                System.out.println("Invalid input! Please choose a number between 1–3.");
                continue;
            }
        }
        break;
    }

    this.teaType = teaType;
    return teaType;
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

                return "";
            }
            else if (answer.equals("Y") || answer.equals("Yes")) {
                while (true) {
                    System.out.print("Enter your note (max 100 words): ");
                    note = scanner.nextLine().trim();


                    if (note.isEmpty()) {
                        return "";
                    }


                    String[] words = note.split("\\s+");
                    if (words.length > 100) {
                        System.out.println("Please keep your note under 100 words. You wrote " + words.length + ".");
                        System.out.println("Try again.\n");
                        continue; // Ask the user  again until valid,so they could correct their wording
                    }


                    System.out.println("Note saved successfully! ✅ ");
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
