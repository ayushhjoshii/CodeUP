/*
 * This class consist the definition of 5 functions:
 * 
 * 1. Expand : Given a string containing characters followed by digits, expand each character by repeating it according to the digit that follows. 
 * 2. CharacterFrequency: Write a Java program that takes a string input and outputs the frequency of each character in a compressed form. 
 * 3. isPrime : Write a Java program to determine if a given integer is a prime number. 
 * 4. numberToWord : Write a Java program that converts a given integer into its written English form. 
 * 5. longestUniqueSubstring : Given a string s, find the length of the longest substring without repeating characters. 
 * 
 * Owner: Ayush Joshi
 * Date Modified: 24/09/2025
 * 
 */
import java.util.Scanner;

public class MyString {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String callFunction;

        System.out.print("Type the function you want to perform (t1/t2/t3/t4/t5): ");

        while (true) {
            callFunction = sc.nextLine();
            
            if (callFunction.equalsIgnoreCase("t1")) {
                System.out.println(expand());
                break; // Exit the loop after the function runs successfully
            }else if(callFunction.equalsIgnoreCase("t3")){
                System.out.println(isPrime());
                break;
            }else if(callFunction.equalsIgnoreCase("t2")){
                System.out.println(frequency());
                break;
            }else if(callFunction.equalsIgnoreCase("t4")){
                System.out.println(numberToWord());
                break;
            }
            else {
                System.out.print("Invalid command!! please choose from t1/t2/t3/t4/t5: ");
            }
        }
    }

    // 1. Expand the String according to the number infront of the indivisual alternate character

    public static String expand() {
        String s;

        while (true) {
            System.out.print("Enter a string (e.g., a3b12): ");
            s = sc.nextLine().trim();// Here .trim() is used to get rid of the extra unwanted spaces

            if (s.isEmpty()) {
                System.out.println("Invalid input!! String cannot be empty.");
                continue; // Ask for input again
            }

            boolean isStringValid = true; // Assume the string is valid until a problem is found.
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (Character.isLowerCase(ch)) {
                   
                    if (i + 1 >= s.length() || !Character.isDigit(s.charAt(i + 1))) {
                        isStringValid = false;
                        break; 
                    }
                }
                // If it's not a lowercase letter, it must be a digit.
                else if (!Character.isDigit(ch)) {
                    isStringValid = false; 
                    break;
                }
            }

            // Only break out of the main while loop if the string passed all checks.
            if (isStringValid) {
                break;
            } else {
                System.out.println("Invalid format! Please enter only lowercase letters, each followed by a number.");
            }
        }

        // Process the valid string (kept your original string concatenation method).
        String result = "";
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int j = i + 1;

            // Collect all consecutive digits.
            int start = j;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                j++;
            }
            int count = Integer.parseInt(s.substring(start, j));

            // Expand the character.
            for (int k = 0; k < count; k++) {
                result = result + ch;
            }

            i = j; // Move to the start of the next block.
        }
        return result;
    }

    // 2. Checks the frequency of indivisual characters in a string

    public static String frequency(){
        String input;

        while (true) {
            System.out.print("Enter a string (lowercase letters only): ");
            input = sc.nextLine().trim(); // Here .trim() is used to remove the extra spaces from the input string

            if (input.matches("[a-z]+")) {
                break;
            } else {
                System.out.println("Invalid input! Only lowercase letters are allowed. Please try again.");
            }
        }

        // Process the valid string
        String result = "";
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                result += input.charAt(i)+count;
                count = 1;
            }
        }

        return result;
    }

    // 3. Checks whether the given number is prime or not

    public static String isPrime(){
        long n;
        System.out.print("Number: ");
        while(true){
            if(sc.hasNextLong()){
                n=sc.nextLong();
                break;
            }else{
                System.out.println("Error!! enter Integer values only: ");
                sc.next();
            }
        }
        int count = 0;
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                count++;
                if(n/i != i){
                    count++;
                }
            }
        }
        return "The given number is " + (count == 2 ? "" : "NOT ") + "PRIME";
    }

    // 4. Convert the integer into the equivalent word.

    public static String numberToWord() {
        System.out.println("Enter a number between 0 and 1000: ");
        int num;

        while (true) {
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                
                if (num >= 0 && num <= 1000) {
                    break; 
                } else {
                    System.out.println("Invalid range! Please enter a number between 0 and 1000:");
                }
            } else {
            
                System.out.println("Invalid input! Please enter a whole number:");
                sc.next(); 
            }
        }

        if (num == 0) {
            return "zero";
        }
        if (num == 1000) {
            return "one thousand";
        }

        String[] sd = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] ty = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String words = "";
        
        if (num >= 100) {
            words = words + sd[num / 100] + " hundred";
            if (num % 100 != 0) {
                words = words + " "; 
            }
        }

        int remainder = num % 100;
        
        if (remainder > 0) {
            if (remainder < 20) {
                words = words + sd[remainder];
            } else {
                words = words + ty[remainder / 10]; 
                if (remainder % 10 != 0) {
                    words = words + " " + sd[remainder % 10];
                }
            }
        }

        return words;
    }

    // 5. Checks the Longest-Unique-Substring from a given string

    public static int substring(){
        String st= sc.nextLine();
        int[] lastSeenAt = new int[256];
        for (int idx = 0; idx < 256; idx++) {
            lastSeenAt[idx] = -1;
        }

        int maxLen = 0;
        int windowStart = -1;

        for (int currentPos = 0; currentPos < st.length(); currentPos++) {
            if (lastSeenAt[st.charAt(currentPos)] > windowStart) {
                windowStart = lastSeenAt[st.charAt(currentPos)];
            }
            lastSeenAt[st.charAt(currentPos)] = currentPos;
            maxLen = Math.max(maxLen, currentPos - windowStart);
        }
        return maxLen;
    }
}
