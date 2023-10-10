/*
 * Author: Jim Pamplona
 * Title: Assignment 1 #1 - SE320
 * Description:
 * Write a Java program that prompts the user to enter two integers and displays their sum. 
 * Use exception handling to prompt the user for reading the number again if the input is incorrect.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class AddIntegers {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("Input two numbers to add.");

        while (intArray.size() != 2) {
            System.out.print("Input a number: ");
            try {
                input = Integer.parseInt(sc.next());
                System.out.println("Input was " + input);
                intArray.add(input);
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer.");
            }
        }

        int sum = intArray.get(0) + intArray.get(1);
        System.out.println(intArray.get(0) + " + " + intArray.get(1) + " = " + sum);
        System.out.println("The sum is " + sum);

        sc.close();
    }
}
