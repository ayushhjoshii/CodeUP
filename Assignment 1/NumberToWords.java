//This program is used to convert the integer input into equivalent words
//Owner: Ayush Joshi

import java.util.Scanner;

public class NumberToWords {

    // Arrays to store words for numbers
    private static final String[] units = {
        "", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine"
    };

    private static final String[] teens = {
        "ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty",
        "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int num;

            // Input validation loop
            while (true) {
                System.out.print("Enter a positive integer (1-1000): ");
                if (sc.hasNextInt()) {
                    num = sc.nextInt();
                    if (num >= 1 && num <= 1000) break;
                } else {
                    sc.next(); // consume invalid input
                }
                System.out.println("❌ Invalid input! Please enter a number between 1 and 1000.");
            }
            
            // Convert number to words
            String words = convertToWords(num);
            System.out.println("✅ Number in words: " + words);
        }
    }

    private static String convertToWords(int num) {
        if (num == 1000) return "one thousand";

        StringBuilder sb = new StringBuilder();

        // Hundreds place
        if (num >= 100) {
            sb.append(units[num / 100]).append(" hundred");
            num %= 100;
            if (num != 0) sb.append(" ");
        }

        // Tens and units place
        if (num >= 20) {
            sb.append(tens[num / 10]);
            num %= 10;
            if (num != 0) sb.append(" ");
        } else if (num >= 10) {
            sb.append(teens[num - 10]);
            num = 0;
        }

        // Units place
        if (num > 0) {
            sb.append(units[num]);
        }

        return sb.toString();
    }
}

