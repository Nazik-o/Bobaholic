package com.bobashop;


public class ConsoleEffect {

    public static final String RESET = "\u001B[0m";
    public static final String ORANGE = "\u001B[38;2;255;165;0m";
    public static final String PURPLE = "\u001B[38;2;186;85;211m";

    // 5-second loading bar with BOBAHOLIC colors
    public static void loadingBar() {
        String[] steps = {"▃", "▄", "▅", "▆", "▇", "█"};

        System.out.print("\n⏳ ");

        for (String step : steps) {
            System.out.print(ORANGE + step + RESET);
            try {
                Thread.sleep(700); // it should be 5 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


    }
}

