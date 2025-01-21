package javaapplication72;

import java.util.Random;
import java.util.Scanner;

public class ArrayTask {
    public static void main(String[] args) {
        // Step 1: Create an array with 10 random integers
        int[] numbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Random numbers between 0 and 99
        }

        // Step 2: Prompt the user to enter the index
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an index to access the array (0-9): ");
        
        try {
            int index = scanner.nextInt();
            System.out.println("Element at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds. Please enter a valid index.");
        } finally {
            scanner.close();
        }
    }
}
