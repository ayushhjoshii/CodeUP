//This program expands the characters in String according to the frequency written infront of the single character
//Owner: Ayush Joshi

import java.util.Scanner;

public class ExpandCharacters {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String s;

            while (true) {
                System.out.print("Enter a valid string (lowercase letters followed by digits): ");
                s = sc.nextLine().trim();

                if (isValidInput(s)) {
                    break; // exit loop if input is valid
                } else {
                    System.out.println("Invalid input! Use only lowercase letters followed by digits, e.g., a1b4c3.");
                }
            }

            // Process the valid string
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                char ch = s.charAt(i);

                // read the number following the character
                int j = i + 1;
                if (j >= s.length() || !Character.isDigit(s.charAt(j))) {
                    System.out.println("Missing digit after '" + ch + "'.");
                    return;
                }

                // collect all consecutive digits
                int start = j;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int count = Integer.parseInt(s.substring(start, j));

                // expand the character
                for (int k = 0; k < count; k++) {
                    result.append(ch);
                }

                i = j;
            }
            System.out.println("Expanded string: " + result);
        }
    }

    // Helper method to validate input format
    private static boolean isValidInput(String str) {
        if (str.isEmpty()) return false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // letters must be lowercase
            if (Character.isLetter(ch) && !Character.isLowerCase(ch)) {
                return false;
            }

            // letters must be followed by at least one digit
            if (Character.isLowerCase(ch)) {
                if (i + 1 >= str.length() || !Character.isDigit(str.charAt(i + 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}