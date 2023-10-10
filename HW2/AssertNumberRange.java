package HW2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AssertNumberRange {
    public static void main(String[] args) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int numberInput = -1;
        //while the number inputted is invalid, exception is caught and user is asked to input again or the assertion throws an error
        while (numberInput == -1) {
            try {
                System.out.print("Enter a number from 1 to 10: ");
                numberInput = scanner.nextInt();
                
                //Assertion for assignment
                assert (numberInput <= 10 && numberInput >= 0) : "The entered number is out of range.";
            }

            catch (InputMismatchException e) {
                numberInput = -1;
                System.out.println("Input not an Integer. Please input an Integer.");

            }

            finally {
                scanner.nextLine();
            }
        }
        scanner.close();
    }

}
