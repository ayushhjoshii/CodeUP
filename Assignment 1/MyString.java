import java.util.Scanner;

public class MyString {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String callFunction;
        // Added a prompt so the user knows what to do.
        System.out.print("Type the function you want to perform (t1/t2/t3/t4/t5): ");

        while (true) {
            callFunction = sc.nextLine();
            // Using .equalsIgnoreCase is more user-friendly as it is case-insensitive but .equals is case-sensitive.
            if (callFunction.equalsIgnoreCase("t1")) {
                System.out.println(Expand());
                break; // Exit the loop after the function runs successfully
            }else if(callFunction.equalsIgnoreCase("t3")){
                System.out.println(isPrime());
                break;
            }else if(callFunction.equalsIgnoreCase("t2")){
                System.out.println(Frequency());
                break;
            }else if(callFunction.equalsIgnoreCase("t4")){
                System.out.println(N2W());
                break;
            }
            else {
                System.out.print("Invalid command!! please choose from t1/t2/t3/t4/t5: ");
            }
        }
    }

    //Task-1

    public static String Expand() {
        String s;

        while (true) {
            System.out.print("Enter a string (e.g., a3b12): ");
            s = sc.nextLine().trim();// Here .trim() is used to get rid of the extra unwanted spaces

            if (s.isEmpty()) {
                System.out.println("Invalid input!! String cannot be empty.");
                continue; // Ask for input again
            }

            // Used a boolean flag for validation
            boolean isStringValid = true; // Assume the string is valid until a problem is found.
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                // Consist only of lowercase letters
                if (Character.isLowerCase(ch)) {
                    // followed by at least one digit.
                    if (i + 1 >= s.length() || !Character.isDigit(s.charAt(i + 1))) {
                        isStringValid = false; // The pattern is broken.
                        break; // No need to check the rest of the string.
                    }
                }
                // If it's not a lowercase letter, it must be a digit.
                else if (!Character.isDigit(ch)) {
                    isStringValid = false; // Invalid character found.
                    break; // No need to check the rest.
                }
            }

            // Only break out of the main while loop if the string passed all checks.
            if (isStringValid) {
                break;
            } else {
                System.out.println("Invalid format! Please enter only lowercase letters, each followed by a number.");
                // The while loop will now correctly repeat.
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

    //Task-2

    public static String Frequency(){
        String input;

        // Keep asking until valid input is entered
        while (true) {
            System.out.print("Enter a string (lowercase letters only): ");
            input = sc.nextLine().trim(); // Here .trim() is used to remove the extra spaces from the input string

            if (input.matches("[a-z]+")) {//Here regex refers to Regular expression used to perform searching/matching/replacing/splitting
                break; // valid input, exit loop
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

    //Task-3

    public static String isPrime(){
        long n;
        System.out.print("Number: ");
        while(true){
            if(sc.hasNextLong()){//sc.hasNextInt checks whether the input taken holds an integer value or not
                n=sc.nextLong();
                break;//To break out of the infinite loop
            }else{
                System.out.println("Error!! enter Integer values only: ");
                sc.next();//To avoid going into infinite loop
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

    //Task-4

    public static String N2W(){
        System.out.println("Enter a number between 0 to 1000: ");
        int num;
        while(true){
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if(num<1000 || num>0){
                    break;
                }else{
                    System.out.println("Invalid input!! please enter numbers between 0 to 1000: ");
                    sc.next();
                }
            }
        }
        if(num<1 || num>999){
            return "invalid input";
        }else{
            int a=num%10;
            int b=(num/10)%10;
            int c=num/100;
            String sd[]={"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
            String ty[]={"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
            if(num<20) return sd[num];
            else if(num>20 && num<100) return ty[b]+" "+sd[a];        
            else return sd[c]+" "+"hundred"+" "+ty[b]+" "+sd[a];
        }
    }

    // Task-5

    public static int Substring(){
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