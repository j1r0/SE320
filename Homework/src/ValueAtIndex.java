/*
 * Author: Jim Pamplona
 * Title: Assignment 1 #2 - SE320
 * Description:
 * Write a Java program that meets the following requirements:
 * - Creates an array with 100 randomly chosen integers.
 * - Prompts the user to enter the index of the array, then displays the corresponding element value. 
 * If the specified index is out of bounds, catch the exception and display the message "Out of Bounds".
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ValueAtIndex {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int input;
        boolean leave = false;

        for (int i = 0; i < 100; i++) {
            int num = (int) (Math.random() * 100);
            intArray.add(num);
        }
        System.out.println("Integer ArrayList created with random values!");
        System.out.println("Enter a random index ranging from 0-99: ");
        
        while (!leave) {
            try {
                input = Integer.parseInt(sc.next());
                System.out.println("The value at index " + input + " is " + intArray.get(input) + ".");
                leave = true;
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Out of Bounds. \nPlease input an integer within bounds of the array (0-99).");
            }
        }
        sc.close();
    }
}
