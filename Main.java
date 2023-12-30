import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        File file = new File("src/Input.txt");
        ArrayList<Integer> calibrationList = new ArrayList<Integer>();

        try {
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {
                String intermediate = findFirstandLastDigit(in.nextLine());
                calibrationList.add(Integer.parseInt(intermediate));
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
}