/*
 * By: Jim Pamplona
 * 
 * 3. Answer the following questions:
 * a. Write the code to format number 12345.678 in the United Kingdom locale. Keep two digits after the decimal point.
 * b. Write the code to format number 12345.678 in U.S. currency.
 * c. Write the code to parse '12,345.678' into a number.
 */

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingNumbers {
    public static void main(String[] args) throws ParseException{
        double num = 12345.678;
        String numString = "12,345.678";
        
        //a
        System.out.println("a. " + toUKLocale(num));

        //b
        System.out.println("b. " + toUSCurrency(num));

        //c
        System.out.println("c. " + strToNumber(numString));
        }

    // a. Write the code to format number 12345.678 in the United Kingdom locale. Keep two digits after the decimal point.
    public static String toUKLocale(double num){
        NumberFormat ukNumberFormat = NumberFormat.getNumberInstance(Locale.UK);
        ukNumberFormat.setMaximumFractionDigits(2);
        ukNumberFormat.format(num);
        return ukNumberFormat.format(num);
    }

    // b. Write the code to format number 12345.678 in U.S. currency.
    public static String toUSCurrency(double num) {
        NumberFormat usCurrencyNumberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        
        return usCurrencyNumberFormat.format(num);
    }
    
    // c. Write the code to parse '12,345.678' into a number.
    public static Number strToNumber(String numString) throws ParseException{
        
        NumberFormat numFormatter = NumberFormat.getNumberInstance();
        return numFormatter.parse(numString);
    }

}
