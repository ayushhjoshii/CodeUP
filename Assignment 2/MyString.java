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

    public String append(String existingString, String input){
        System.out.println("Already existing string: " + existingString);
        return "String after appending: " + existingString + input;
    }

    // 2. Replace any portion inside a given string with any user inpul

    public String replace(String inputStr, String oldStr, String newStr){
        if(oldStr == null || oldStr.isBlank()){
            return "String after Replacement: " + inputStr;
        }
        String resultString = "";
        int currentIndex = 0;
        int foundIndex;
        while((foundIndex = inputStr.indexOf(oldStr, currentIndex)) != -1){
            resultString = resultString + inputStr.substring(currentIndex, foundIndex);
            resultString = resultString + newStr;
            currentIndex = foundIndex + oldStr.length();
        }
        resultString = resultString + inputStr.substring(currentIndex);
        return "String after Replacement: " + resultString;
    }

    // 3. Sort the given string according to the lexicographical order.

    public String sort(String input){
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

    public String reverse(String input){
        String reversedString = "";
        for(int index = input.length()-1; index >=0; index--){
            reversedString = reversedString + input.charAt(index);
        }
        return "Reversed String: "+reversedString;
    }
}
