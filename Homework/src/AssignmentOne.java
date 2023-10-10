/*
 * Author: Jim Pamplona
 * Title: Assignment 1 - SE320
 * Description:
 * Write a Java program that meets the following requirements:
 * - Creates an array with 100 randomly chosen integers.
 * - Prompts the user to enter the index of the array, then displays the corresponding element value. 
 * If the specified index is out of bounds, catch the exception and display the message "Out of Bounds".
 */

import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> intArray = new ArrayList<>();
        int input = 0;
        
        System.out.println("""
                Which program would you like to run?
                1: Adding two integers
                2: Finding random value at index
                """);

        while (input != 1 && input != 2) {
            try {
                input = intScanner(sc, input);
                if (input == 1) {
                    addIntegers(sc, intArray, input);
                } else if (input == 2) {
                    valueAtIndex(sc, intArray, input);
                } else {
                    System.out.println("Please input 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer.");
            }
        }

    }

    public static void addIntegers(Scanner sc, ArrayList<Integer> intArray, int input) {
        System.out.println("Input two numbers to add.");

        while (intArray.size() != 2) {
            System.out.print("Input a number: ");
            try {
                intArray.add(intScanner(sc, input));
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer.");
            }
        }

        int sum = intArray.get(0) + intArray.get(1);
        System.out.println(intArray.get(0) + " + " + intArray.get(1) + " = " + sum);
        System.out.println("The sum is " + sum);

        sc.close();
        System.out.println("Scanner closed");
    }

    public static void valueAtIndex(Scanner sc, ArrayList<Integer> intArray, int input) {
        boolean leave = false;

        for (int i = 0; i < 100; i++) {
            int num = (int) (Math.random() * 100);
            intArray.add(num);
        }
        System.out.println("Integer ArrayList created with random values!");
        System.out.print("Enter a random index ranging from 0-99: ");

        while (!leave) {
            try {
                input = intScanner(sc, input);
                intArray.get(input);
                System.out.println("The value at index " + input + " is " + intArray.get(input) + ".");
                leave = true;
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please input an integer within bounds of the array (0-99).");
            }
        }
        sc.close();
        System.out.println("Scanner closed");
    }

    public static int intScanner(Scanner sc, int input) {
        input = Integer.parseInt(sc.next());
        System.out.println("Input was " + input);
        return input;
    }
}
