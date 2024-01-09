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
                String intermediate1 = replaceCharsToDigitsOrdered(in.nextLine());
                String intermediate2 = findFirstandLastDigit(intermediate1);
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
            result = value.replace("one", "o1e");
            value = result;
        }
        if (value.contains("two")) {
            result = value.replace("two", "t2o");
            value = result;
        }
        if (value.contains("three")) {
            result = value.replace("three", "t3e");
            value = result;
        }
        if (value.contains("four")) {
            result = value.replace("four", "f4r");
            value = result;
        }
        if (value.contains("five")) {
            result = value.replace("five", "f5e");
            value = result;
        }
        if (value.contains("six")) {
            result = value.replace("six", "s6x");
            value = result;
        }
        if (value.contains("seven")) {
            result = value.replace("seven", "s7n");
            value = result;
        }
        if (value.contains("eight")) {
            result = value.replace("eight", "e8t");
            value = result;
        }
        if (value.contains("nine")) {
            result = value.replace("nine", "n9e");
            value = result;
        }
        return result;
    }

    /**
     * This method is used to check if the String provided contains the digits in alphabetical form
     * of one two three four
     * five six seven eight and nine and if it does, the method replaces it
     * with their digit number in the string in the order they come in.
     * @param value the string provided
     * @return the resultant string which contains the digits and not their alphabetical form
     */
    public static String replaceCharsToDigitsOrdered(String value) {
        String[] digits = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; //This array is used to check the alphabetical numbers
        String[] valuesToPut = {"o1e", "t2o", "t3e", "f4r", "f5e", "s6x", "s7n", "e8t", "n9e"}; //This is the value to be replaced.
        String currentWord = ""; //used to store the current word which also becomes the result by the end of the nested for loops

        for (int i = 0; i < value.length(); i++) {
            currentWord += value.charAt(i);
            for (int j = 0; j < digits.length; j++) {
                if(currentWord.contains(digits[j])) {
                    currentWord = currentWord.replaceFirst(digits[j], valuesToPut[j]);
                }
            }
        }
        return currentWord;
    }
}