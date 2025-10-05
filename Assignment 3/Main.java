/*
 * This program will be used to call the following 4 functions from the class called MyOperations :
 * 
 * 1. Valid Parenthesis Combination
 * 2. Sum of Digits (DigitSum)
 * 3. Consecutive Number Sum
 * 4. Caesar Cipher Encoding
 * 
 * Owner: Ayush Joshi
 * Last Updated: 6/10/2025
 */
import java.util.*;
public class Main {
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String [] args){
        
        boolean keepGoing;
        MyOperations myOperationsObject = new MyOperations();
        String operationName = """
                1. Valid Parenthesis Combination
                2. Sum of Digits
                3. Consecutive Number Sum
                4. Caesar Cipher Encoding
                5. Encoded ASCII Transformation
                """;

        do{

            System.out.println("Enter the operation you want to perform:\n" + operationName);
            String operationNumber = userInput.nextLine();
            
            switch(operationNumber){

                case "1" -> {
                                System.out.println("Enter the number of parenthesis: ");
                                if(userInput.hasNextInt()){
                                    int input = userInput.nextInt();
                                    userInput.nextLine();
                                    System.out.println(myOperationsObject.generateParenthesis(input));
                                }else{
                                    System.out.println("Invalid input !!");
                                }
                            }

                case "2" -> {
                                System.out.println("Enter the number whose sum of digits is to be found: ");
                                if(userInput.hasNextInt()){
                                    int input = userInput.nextInt();
                                    userInput.nextLine();
                                    System.out.println(myOperationsObject.digiSum(input));
                                }else{
                                    System.out.println("Invalid input !!");
                                }
                            }

                case "3" -> {
                                System.out.print("Enter the number which is to be represented as the sum of consecutive numbers: ");
                                if(userInput.hasNextInt()){
                                    int input = userInput.nextInt();
                                    userInput.nextLine();
                                    System.out.println(myOperationsObject.consecutiveSum(input));
                                }else{
                                    System.out.println("Invalid input !!");
                                }
                            }

                case "4" -> {
                                System.out.print("Enter the String: ");
                                String stringInput = userInput.nextLine();
                                System.out.println("Shift by: ");
                                int shift = userInput.nextInt();
                                userInput.nextLine();
                                System.out.println(myOperationsObject.caesarCipher(stringInput, shift));
                            }

                case "5" -> {
                                System.out.print("Enter the Character array in the form of string: ");
                                String inputString = userInput.nextLine();
                                System.out.print("Enter the number of positions to be shifted: ");
                                int shift = userInput.nextInt();
                                userInput.nextLine();
                                myOperationsObject.transformation(shift, inputString);
                            }
                
                default  -> System.out.println("Invalid input !!");
            }
            System.out.println("Do you want to perform operations again ?? (y/n) : ");
            String userResponse = userInput.nextLine();
            keepGoing = userResponse.equalsIgnoreCase("y");

        } while(keepGoing);
    }
}
