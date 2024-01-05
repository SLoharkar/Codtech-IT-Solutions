//Currency Converter
package Task_4;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayCurrency();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1, 2, 3, 4:
                    double amount = getCurrency();
                    calculateCurrency(choice, amount);
                    break;
                case 5:
                    System.out.println("\nExiting Currency Converter. Thank you!");
                    break;
                default:
                    System.out.println("Invalid input please try again");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayCurrency() {
        System.out.println("\nCurrency Converter");
        System.out.println("1. US Dollar to Indian Rupees");
        System.out.println("2. Indian Rupees to US Dollar");
        System.out.println("3. Europen Euro to Indian Rupees");
        System.out.println("4. Japanese Yen to Indian Rupees");
        System.out.println("5. Exit");
    }

    private static double getCurrency() {
        System.out.print("\nEnter amount to convert: ");
        double amount = scanner.nextDouble();
        return amount;
    }

    private static void calculateCurrency(int choice, double amount) {

        switch (choice) {
            case 1:
                amount = amount * 83.5; // Convert Dollar to Rupees
                break;
            case 2:
                amount = amount * 0.012; // Convert Rupees to Dollar
                break;
            case 3:
                amount = amount * 91.12; // Convert Euro to Rupees
                break;
            case 4:
                amount = amount * 0.58; // Convert Yen to Rupees
                break;
        }

        System.out.println("Converted Amount : " + amount);

    }

}
