//This program tell the length of the longest substring containing unique characters
//Owner: Ayush Joshi

import java.util.*;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the string: ");
            String s = sc.nextLine();
            int length = lengthOfLongestSubstring(s);
            System.out.println("Length of longest substring without repeating characters: " + length);
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0; // left pointer of sliding window
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // Shrink window if duplicate is found
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to set
            set.add(c);

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
