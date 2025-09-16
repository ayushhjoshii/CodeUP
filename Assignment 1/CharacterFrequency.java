//This program helps to find the frequency of a character while preserving the order of the string
//Owner: Ayush Joshi

import java.util.Scanner;
public class CharacterFrequency {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String input;

            // Keep asking until valid input is entered
            while (true) {
                System.out.print("Enter a string (lowercase letters only): ");
                input = sc.nextLine().trim();

                if (input.matches("[a-z]+")) {
                    break; // valid input, exit loop
                } else {
                    System.out.println("Invalid input! Only lowercase letters are allowed. Please try again.");
                }
            }

            // Process the valid string
            StringBuilder result = new StringBuilder();
            int count = 1;

            for (int i = 0; i < input.length(); i++) {
                if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                    count++;
                } else {
                    result.append(input.charAt(i)).append(count);
                    count = 1;
                }
            }

            System.out.println("Compressed string: " + result);
        }
    }
}
