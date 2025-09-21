/*
 * This program is used to call 4 functions defined in the class called MyString :
 * 
 * 1. Append
 * 2. Replace 
 * 3. Sort
 * 4. Reverse
 * 
 * Owner: Ayush Joshi
 * Date: 20/09/2025
 */
import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the String: ");
        String input = sc.nextLine().trim();

        // This is a boolean Flag used to terminate the program.

        boolean keepGoing;

        //Here do-while loop is used to ensure that the program doesn't terminates without the user's will

        do{
            System.out.print("Which operation do you want to perform ?? (append/ replace/ sort/ reverse): ");
            String operationName = sc.nextLine();

            switch (operationName.toLowerCase()) {
                case "append"        -> System.out.println(MyString.append(input));
                case "replace"       -> System.out.println(MyString.replace(input));
                case "sort"          -> System.out.println(MyString.sort(input));
                case "reverse"       -> System.out.println(MyString.reverse(input));
                default              -> System.out.println("Invalid input");
            } 
            
            System.out.println("Do you want to perform operations again ? (y/n): ");
            String userResponse = sc.nextLine();
            keepGoing = userResponse.equalsIgnoreCase("y");
        } while (keepGoing);
    }
}

