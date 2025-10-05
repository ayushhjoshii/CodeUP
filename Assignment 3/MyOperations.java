/*
 * This class consist of definitions of 4 functions which are used in Main.java class :
 * 
 * 1. generateParenthesis: Generates all combinations of given number of balanced parenthesis.
 * 2. digiSum: Calculates the sum of all the digits of a given number.
 * 3. consecutiveSum: Displays the number of ways that a number can be displayed as the sum of consecutive numbers.
 * 4. caesarCipher: This helps to shift the give string by the given number number of characters.
 * 5. transformation: This function is also same as the caesarCipher but it specifically uses an array to do so instead of direct string manipulation.
 * 
 * Owner: Ayush Joshi
 * Last Updated: 6/10/2025
 */
import java.util.*;
public class MyOperations {
    
    // 1. Generates all combinations of given number of balanced parenthesis.

     public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    // 2. Calculates the sum of all the digits of a given number.

    public String digiSum(int input){
        int sum = 0;
        for(int i = input; i != 0; i = i/10 ){
            int lastDigit = i % 10;
            sum += lastDigit;
        }
        return "Sum of Digits: "+sum;
    }

    // 3. Displays the number of ways that a number can be displayed as the sum of consecutive numbers.

    public int consecutiveSum(int input){
        int count = 0;
        for(int k = 1; k * (k-1)/2 < input; k++){
            int numerator = input - (k * (k-1)/2);
            if(numerator % k == 0){
                count++;
            }
        }
        System.out.print("Number of ways to represent " + input + " as the sum of consecutive numbers is: ");
        return count;
    }

    // 4. This helps to shift the give string by the given number number of characters.

    public String caesarCipher(String stringInput, int shift){
        String result = "";
        for(int index = 0; index < stringInput.length(); index++){
            char originalChar = stringInput.charAt(index);
            char shiftedChar = (char) (originalChar + shift);
            result = result + shiftedChar;
        }
        return "After Shifting: "+result;
    }

    // 5. This function is also same as the caesarCipher but it specifically uses an array to do so instead of direct string manipulation.

    public void transformation(int shift, String inputString){
        char[] charArr = new char[inputString.length()];
        for(int index = 0; index < inputString.length(); index ++){
            charArr[index] = (char) (inputString.charAt(index)+shift);
        }
        for(int index = 0; index < inputString.length(); index++){
            System.out.print(charArr[index]+" ");
        }
        System.out.println();
    }
}
