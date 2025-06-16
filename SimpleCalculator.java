// Import the Scanner class to read user input from the console
import java.util.Scanner;

/**
 * This class implements a simple command-line calculator.
 * It allows users to perform basic arithmetic operations:
 * addition, subtraction, multiplication, and division.
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to get input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Java Calculator!");
        System.out.println("------------------------------------");

        // Get the first number from the user
        System.out.print("Enter the first number: ");
        // Use a try-catch block to handle non-numeric input
        double num1;
        try {
            num1 = scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.close(); // Close the scanner before exiting
            return; // Exit the program
        }

        // Get the second number from the user
        System.out.print("Enter the second number: ");
        double num2;
        try {
            num2 = scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.close(); // Close the scanner before exiting
            return; // Exit the program
        }

        // Get the operation from the user
        System.out.print("Choose an operation (+, -, *, /): ");
        String operation = scanner.next();

        double result = 0;
        boolean isValidOperation = true;

        // Perform the chosen operation using a switch statement
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                // Handle division by zero
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    isValidOperation = false;
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                // Handle invalid operation input
                System.out.println("Invalid operation. Please choose from +, -, *, /.");
                isValidOperation = false;
                break;
        }

        // Display the result if the operation was valid
        if (isValidOperation) {
            System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + result);
        }

        // Close the scanner to release system resources
        scanner.close();
        System.out.println("Thank you for using the calculator!");
    }
}
