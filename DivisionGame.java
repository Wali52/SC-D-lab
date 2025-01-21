package javaapplication73;

import java.util.Scanner;

public class DivisionGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Take two integer inputs from the user
            System.out.print("Enter the first integer: ");
            int num1 = Integer.parseInt(scanner.nextLine()); // Validating integer input
            
            System.out.print("Enter the second integer: ");
            int num2 = Integer.parseInt(scanner.nextLine()); // Validating integer input

            // Step 2: Perform division
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            
            double result = (double) num1 / num2;
            System.out.println("The result of division is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter integer numbers only.");
        } finally {
            scanner.close();
        }
    }
}
