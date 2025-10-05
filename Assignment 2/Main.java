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
        // This is a boolean Flag used to terminate the program.

        boolean keepGoing;
        MyString myStringObject = new MyString();


        //Here do-while loop is used to ensure that the program doesn't terminates without the user's will

        do{
            System.out.print("Which operation do you want to perform ?? (1. append/ 2. replace/ 3. sort/ 4. reverse): ");
            String operationNumber = sc.nextLine();
            switch (operationNumber) {
                case "1"    -> {
                                System.out.println("Enter already existing String and to be appended strings respectively: ");
                                System.out.println(myStringObject.append(sc.nextLine(), sc.nextLine()));
                                }

                case "2"    -> {
                                System.out.println("Enter the input String, OldSubstring and NewSubstring respectively: ");
                                System.out.println(myStringObject.replace(sc.nextLine(), sc.nextLine(), sc.nextLine()));
                                }

                case "3"    -> {
                                System.out.println("Enter the String: ");
                                System.out.println(myStringObject.sort(sc.nextLine()));
                                }

                case "4"    -> {
                                System.out.println("Enter the String: ");
                                System.out.println(myStringObject.reverse(sc.nextLine()));
                                }

                default     ->  System.out.println("Invalid input");
            } 
            
            System.out.println("Do you want to perform operations again ? (y/n): ");
            String userResponse = sc.nextLine();
            keepGoing = userResponse.equalsIgnoreCase("y");
            
        } while (keepGoing);
    }
}