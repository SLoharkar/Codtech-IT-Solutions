//Basic Calculator
package Task_6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1, num2, result;
        char operator;

        System.out.println("\n\t\tSimple Console Calculator");
        System.out.println("\nAvailable operations: +, -, *, /\n");

        // Input first number
        System.out.print("\nEnter the first number: ");
        num1 = scanner.nextDouble();

        // Input operator
        System.out.print("\nEnter the operation (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        // Input second number
        System.out.print("\nEnter the second number: ");
        num2 = scanner.nextDouble();

        // Perform calculation
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("\n\t\tResult: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("\n\t\tResult: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("\n\t\tResult: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("\n\t\tResult: " + result);
                } else {
                    System.out.println("\n\tError: Cannot divide by zero.");
                }
                break;
            default:
                System.out.println("\n\tInvalid operator. Please use +, -, *, /");
        }

        scanner.close();
    }
}
