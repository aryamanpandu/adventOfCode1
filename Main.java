import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        File file = new File("src/Input.txt");
        ArrayList<Integer> calibrationList = new ArrayList<Integer>();


        try {
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {
                String intermediate1 = replaceCharsToDigits(in.nextLine());
                String intermediate2 = findFirstandLastDigit(intermediate1);
                System.out.println(intermediate2);
                calibrationList.add(Integer.parseInt(intermediate2));
            }

            System.out.println(sumOfAllListEl(calibrationList));


        }
        catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid integer input");
        }
    }

    /**
     * A method that gives out a string containing the
     * first and last digit inside a string
     * @param value this is the string that contains the digits
     * @return String of the first and last digits in the String
     */
    public static String findFirstandLastDigit(String value) {

        String digits = "";


        // for loop to get the first digit from the string
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))) { //Checking if the character at that index is a digit
                digits += value.charAt(i);
                break;
            }
        }

        // for loop to get the second digit from the string
        for (int i = value.length() -1; i >= 0; i--) {
            if (Character.isDigit(value.charAt(i))) {
                digits += value.charAt(i);
                break;
            }
        }

        return digits;
    }

    /**
     * This method adds all the elements of an ArrayList<Integer> and gives out the result
     * @param list the ArrayList containing the elements
     * @return the sum of all the elements
     */
    public static int sumOfAllListEl(ArrayList<Integer> list) {
        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        return sum;
    }

    /**
     * This method is used to check if the String provided contains the digits in alphabetical form
     * of one two three four
     * five six seven eight and nine and if it does, the method replaces it
     * with their digit number in the string
     * @param value the string provided
     * @return the resultant string which contains the digits and not their alphabetical form
     */
    public static String replaceCharsToDigits(String value) {
        String result = "";
        if (value.contains("one")) {
            result = value.replace("one", "1");
            value = result;
        }
        if (value.contains("two")) {
            result = value.replace("two", "2");
            value = result;
        }
        if (value.contains("three")) {
            result = value.replace("three", "3");
            value = result;
        }
        if (value.contains("four")) {
            result = value.replace("four", "4");
            value = result;
        }
        if (value.contains("five")) {
            result = value.replace("five", "5");
            value = result;
        }
        if (value.contains("six")) {
            result = value.replace("six", "6");
            value = result;
        }
        if (value.contains("seven")) {
            result = value.replace("seven", "7");
            value = result;
        }
        if (value.contains("eight")) {
            result = value.replace("eight", "8");
            value = result;
        }
        if (value.contains("nine")) {
            result = value.replace("nine", "9");
            value = result;
        }
        return result;
    }
}