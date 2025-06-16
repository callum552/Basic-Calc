// Import the Scanner class to read user input from the console.
import java.util.InputMismatchException; // Specific import for input mismatch
import java.util.Scanner;

/**
 * This class implements an advanced command-line calculator.
 * It allows users to perform basic arithmetic operations (addition, subtraction,
 * multiplication, division, and modulo) continuously until they choose to exit.
 * It also includes improved input validation.
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to get input from the console.
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true; // Flag to control the calculation loop

        System.out.println("Welcome to the Advanced Java Calculator!");
        System.out.println("------------------------------------");

        // Loop to allow multiple calculations
        while (continueCalculating) {
            double num1 = 0;
            double num2 = 0;
            String operation = "";
            double result = 0;
            boolean isValidCalculation = true; // Flag to track if the current calculation is valid

            // Get the first number from the user.
            System.out.print("Enter the first number (or 'exit' to quit): ");
            // Check if the user wants to exit
            if (scanner.hasNext("exit") || scanner.hasNext("EXIT")) {
                continueCalculating = false;
                break; // Exit the while loop
            }
            try {
                num1 = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number or 'exit'.");
                scanner.next(); // Consume the invalid input
                isValidCalculation = false; // Mark calculation as invalid
            }

            if (!isValidCalculation) { // Skip to next iteration if num1 was invalid
                continue;
            }

            // Get the second number from the user.
            System.out.print("Enter the second number: ");
            try {
                num2 = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
                isValidCalculation = false; // Mark calculation as invalid
            }

            if (!isValidCalculation) { // Skip to next iteration if num2 was invalid
                continue;
            }

            // Get the operation from the user.
            System.out.print("Choose an operation (+, -, *, /, %): ");
            operation = scanner.next();

            // Perform the chosen operation using a switch statement.
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
                    // Handle division by zero.
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        isValidCalculation = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                case "%":
                    // Handle modulo by zero (similar to division by zero)
                    if (num2 == 0) {
                        System.out.println("Error: Modulo by zero is not allowed.");
                        isValidCalculation = false;
                    } else {
                        result = num1 % num2;
                    }
                    break;
                default:
                    // Handle invalid operation input.
                    System.out.println("Invalid operation. Please choose from +, -, *, /, %.");
                    isValidCalculation = false;
                    break;
            }

            // Display the result if the calculation was valid.
            if (isValidCalculation) {
                System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + result);
            }
            System.out.println("------------------------------------"); // Separator for clarity
        }

        // Close the scanner to release system resources.
        scanner.close();
        System.out.println("Thank you for using the calculator! Goodbye.");
    }
}
