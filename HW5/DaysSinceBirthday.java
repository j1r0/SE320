/*
 * By: Jim Pamplona
 * 
 * 1. Write a program that computes the number of days that have elapsed since you were born.
 * Use the Day class we studied in class, not the GregorianCalendar class. You can find all three
 * implementations of the Day class (that we've seen in class) on Canvas, under
 * Modules>Supplementary Material.
 */

package HW5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DaysSinceBirthday {
    
    public static void main(String[] args) {
        // {year[0], month[1], day[2]} ; {yyyy/MM/dd}
        int[] birthdayArray = {2003, 6, 28};
        int[] todayDateArray = splitTodaysDate();

        System.out.println("It has been "+ daysSinceBirthday(birthdayArray, todayDateArray) + " days since my birthday.");
    }

    private static int[] splitTodaysDate(){
        Date time = new Date();
        // Formats today's date to yyyy/MM/dd
        DateFormat todayDate = new  SimpleDateFormat("yyyy/MM/dd");
        String todayString = todayDate.format(time);

        String[] arrOfStr = todayString.split("/");
        int[] todayDateArray = new int[arrOfStr.length];

        // converts string array to int array: {year[0], month[1], day[2]}
        for (int i = 0; i < arrOfStr.length; i++){
            todayDateArray[i] = Integer.parseInt(arrOfStr[i]);
        }
        return todayDateArray;
    }

    private static int daysSinceBirthday(int[] birthdayArray, int[] todayDateArray){
        Day birthday = new Day(birthdayArray[0], birthdayArray[1], birthdayArray[2]);
        Day today = new Day(todayDateArray[0], todayDateArray[1], todayDateArray[2]);
        return today.daysFrom(birthday);
    }
    
}

