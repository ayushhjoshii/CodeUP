/*
 * This Class consist of 4 functions:
 * 
 * 1. Append: Appends the newString provided by the user to the existing string.The method should remember the appended result. 
 * 
 * 2. Replace: Replaces all occurrences of character a with character b in the current string.
 * 
 * 3. Sort: Sorts the characters of the current string in alphabetical order.
 * 
 * 4. Reverse: To reverse the string.
 * 
 * Owner: Ayush Joshi
 * Date: 20/09/2025
 */

public class MyString {
    // 1. Append the input string in a existing string.

    public static String append(String input){
        String alreadyExisting = "Hello ";
        System.out.println("Already existing string: " + alreadyExisting);
        System.out.println("After appending: " + alreadyExisting + input);
        return "";
    }

    // 2. Replace any portion inside a given string with any user input.

    public static String replace(String input){

        System.out.print("Enter the old character you want to replace: ");
        String oldChar = Main.sc.nextLine();
        System.out.println("Enter the new character: ");
        String newChar = Main.sc.nextLine();
        String newString = " ";
        for(int index = 0; index < input.length(); index++){
            if(input.charAt(index) == oldChar.charAt(0)){
                newString += newChar.charAt(0);
            }else{
                newString += input.charAt(index); 
            }
        }
        return "The new String will be: " + newString;
    }

    // 3. Sort the given string according to the lexicographical order.

    public static String sort(String input){
        char[] charArray = input.toCharArray();
        String output = "";
        for(int index = 0; index < input.length(); index++){
            for(int j = 0; j < input.length()-index-1; j++){
                if(charArray[j] > charArray[j+1]){
                    char temp = charArray[j];
                    charArray[j] = charArray[j+1];
                    charArray[j+1] = temp;
                }
            }
        }
        for(int index = 0; index < input.length(); index++){
            output = output + charArray[index];
        }
        return "The new sorted list is: " + output;
    }

    // 4. Reverses any input string

    public static String reverse(String input){
        String reversedString = "";
        for(int index = input.length()-1; index >=0; index--){
            reversedString = reversedString + input.charAt(index);
        }
        return "Reversed String: "+reversedString;
    }
}
